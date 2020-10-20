package com.communication.bank.gateway.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.communication.bank.domain.Pagamento;
import com.communication.bank.exceptions.PaymentException;
import com.communication.bank.gateway.json.PaymentJson;
import com.communication.bank.gateway.repository.PagamentoRepository;

@Service
public class PagamentoService{

	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private CartaoService cartaoService;
	
	@Transactional
	public void pagamento(PaymentJson pagamentoJson){
	
		if( !cartaoService.isValido(pagamentoJson.getCodigoSegurancaCartao(), pagamentoJson.getNroCartao()) ){
			throw new PaymentException("Cartão inválido.");
		}
		
		if( !cartaoService.isSaldoSuficiente(pagamentoJson.getCodigoSegurancaCartao(), pagamentoJson.getNroCartao(), pagamentoJson.getValorCompra()) ){
			throw new PaymentException("Cartão não possui saldo suficiente.");
		}

		Pagamento pagamento = new Pagamento();
		pagamento.setValorCompra(pagamentoJson.getValorCompra());
		pagamento.setCartao(cartaoService.getCartao(pagamentoJson.getCodigoSegurancaCartao(), pagamentoJson.getNroCartao()));
		
		pagamentoRepository.save(pagamento);
		
		cartaoService.atualizarSaldo(pagamentoJson.getCodigoSegurancaCartao(), pagamentoJson.getNroCartao(), pagamentoJson.getValorCompra());
	}
}
	