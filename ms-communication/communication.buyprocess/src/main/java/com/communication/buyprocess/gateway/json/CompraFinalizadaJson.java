package com.communication.buyprocess.gateway.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
public class CompraFinalizadaJson {

	private CompraChaveJson compraChaveJson;
	private String mensagem;
	private boolean pagamentoOK;

	public CompraChaveJson getCompraChaveJson() {
		return compraChaveJson;
	}

	public void setCompraChaveJson(CompraChaveJson compraChaveJson) {
		this.compraChaveJson = compraChaveJson;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public boolean isPagamentoOK() {
		return pagamentoOK;
	}

	public void setPagamentoOK(boolean pagamentoOK) {
		this.pagamentoOK = pagamentoOK;
	}

}
