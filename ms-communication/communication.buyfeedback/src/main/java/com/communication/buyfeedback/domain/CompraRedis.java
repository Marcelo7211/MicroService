package com.communication.buyfeedback.domain;

import java.math.BigDecimal;

import javax.persistence.Id;

import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RedisHash("compra") // Passando o nome do objeto no banco de dados não relacional, similar a
						// @Table() e @Entity Juntos
@AllArgsConstructor
@NoArgsConstructor
public class CompraRedis {

	@Id
	private String id;
	
	private String mensagem;
	
	private Integer codigoPassagem;
	
	private Integer nroCartao;
	
	private BigDecimal valorPassagem;
	
	private boolean pagamentoOK;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

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

	public BigDecimal getValorPassagem() {
		return valorPassagem;
	}

	public void setValorPassagem(BigDecimal valorPassagem) {
		this.valorPassagem = valorPassagem;
	}

	public boolean isPagamentoOK() {
		return pagamentoOK;
	}

	public void setPagamentoOK(boolean pagamentoOK) {
		this.pagamentoOK = pagamentoOK;
	}

}
