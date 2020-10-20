package com.communication.buytrip.gateway.json;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
public class CompraJson {

	@NotNull(message = "Código da passagem é obrigatório")
	private Integer codigoPassagem;

	@NotNull(message = "Número do cartão é obrigatório")
	private Integer nroCartao;

	@NotNull(message = "Código de segurança do cartão é obrigatório")
	private Integer codigoSegurancaCartao;

	@NotNull(message = "Valor da compra é obrigatório")
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
