package com.communication.bank.http;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.communication.bank.gateway.json.PaymentJson;
import com.communication.bank.gateway.json.RetornoJson;
import com.communication.bank.gateway.service.PagamentoService;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {

	@Autowired
	private PagamentoService pagamentoService;
	
	@PostMapping
	public ResponseEntity<RetornoJson> pagamento(
			@Valid @NotNull @RequestBody PaymentJson pagamentoJson) {

		pagamentoService.pagamento(pagamentoJson);
		
		RetornoJson retorno = new RetornoJson();
		retorno.setMensagem("Pagamento registrado com sucesso");
		
		return new ResponseEntity<RetornoJson>(retorno, HttpStatus.OK);
	}
	
}
