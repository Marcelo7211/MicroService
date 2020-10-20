package com.communication.buytrip.gateway.json;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class RetornoJson {

	private String mensagem;
	private String chavePesquisa;

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getChavePesquisa() {
		return chavePesquisa;
	}

	public void setChavePesquisa(String chavePesquisa) {
		this.chavePesquisa = chavePesquisa;
	}

}
