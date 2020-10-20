package com.communication.buyprocess.service.processar;


import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.communication.buyprocess.gateway.json.CompraChaveJson;
import com.communication.buyprocess.gateway.json.CompraFinalizadaJson;
import com.communication.buyprocess.service.bank.BankService;
import com.communication.buyprocess.service.bank.PagamentoRetorno;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class ListenerService {

	@Autowired
	private BankService bank;

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Value("${fila.entrada}")
	private String nomeFilaRepublicar;

	@Value("${fila.finalizado}")
	private String nomeFilaFinalizado;

	@HystrixCommand(fallbackMethod = "republicOnMessage")
	@RabbitListener(queues="${fila.entrada}")
    public void onMessage(Message message) throws JsonParseException, JsonMappingException, IOException  {
		
		String json = new String(message.getBody(), "UTF-8");
		
		System.out.println("Mensagem recebida:"+json);
		
		ObjectMapper mapper = new ObjectMapper(); // mapeando o objento json que esta na fila do habbitMq 
		CompraChaveJson compraChaveJson = mapper.readValue(json, CompraChaveJson.class); // convertendo o objeto json para o tipo CompraChaveJson

		PagamentoRetorno pg = bank.pagar(compraChaveJson); //Chamando o serviço que ira chamar o microsservice

		CompraFinalizadaJson compraFinalizadaJson = new CompraFinalizadaJson();
		compraFinalizadaJson.setCompraChaveJson(compraChaveJson);
		compraFinalizadaJson.setPagamentoOK(pg.isPagamentoOK());
		compraFinalizadaJson.setMensagem(pg.getMensagem());

		ObjectMapper obj = new ObjectMapper();
		String jsonFinalizado = obj.writeValueAsString(compraFinalizadaJson);

		rabbitTemplate.convertAndSend(nomeFilaFinalizado, jsonFinalizado);
    }

	public void republicOnMessage(Message message) throws JsonParseException, JsonMappingException, IOException  {
		System.out.println("Republicando mensagem...");
		rabbitTemplate.convertAndSend(nomeFilaRepublicar, message);
	}
}
