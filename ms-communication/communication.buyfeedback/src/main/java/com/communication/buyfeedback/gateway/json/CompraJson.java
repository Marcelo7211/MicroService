package com.communication.buyfeedback.gateway.json;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
public class CompraJson {

	private Integer codigoPassagem;
	private Integer nroCartao;
	private Integer codigoSegurancaCartao;
	private BigDecimal valorPassagem;

	public Integer getCodigoPassagem() {
		return codigoPassagem;
	}

	public void setCodigoPassagem(Integer codigoPassagem) {
		this.codigoPassagem = codigoPassagem;
	}

	public Integer getNroCartao() {
		return nroCartao;
	}

	public void setNroCartao(Integer nroCartao) {
		this.nroCartao = nroCartao;
	}

	public Integer getCodigoSegurancaCartao() {
		return codigoSegurancaCartao;
	}

	public void setCodigoSegurancaCartao(Integer codigoSegurancaCartao) {
		this.codigoSegurancaCartao = codigoSegurancaCartao;
	}

	public BigDecimal getValorPassagem() {
		return valorPassagem;
	}

	public void setValorPassagem(BigDecimal valorPassagem) {
		this.valorPassagem = valorPassagem;
	}

}
