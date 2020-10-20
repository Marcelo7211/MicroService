package com.communication.buyfeedback.gateway.json;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
public class CompraChaveJson {

	private String chave;
	private CompraJson compraJson;

	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

	public CompraJson getCompraJson() {
		return compraJson;
	}

	public void setCompraJson(CompraJson compraJson) {
		this.compraJson = compraJson;
	}

}
