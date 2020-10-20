package com.communication.buyprocess.gateway.json;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class PagamentoJson {

	private Integer nroCartao;
	private Integer codigoSegurancaCartao;
	private BigDecimal valorCompra;

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

	public BigDecimal getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(BigDecimal valorCompra) {
		this.valorCompra = valorCompra;
	}

}
