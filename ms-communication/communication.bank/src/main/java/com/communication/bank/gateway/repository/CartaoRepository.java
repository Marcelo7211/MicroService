package com.communication.bank.gateway.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.communication.bank.domain.Cartao;

@Repository
public interface CartaoRepository extends JpaRepository<Cartao, Long> {

	@Query(value = "select count(id) as qtd from banco.cartao where codigo_seguranca_cartao = :codigoSegurancaCartao and nro_cartao = :nro_cartao", nativeQuery = true)
	public Integer getCartaoValido(@Param("codigoSegurancaCartao") Integer codigoSegurancaCartao, @Param("nro_cartao")Integer nroCartao);

	@Query("select count(obj.id) from Cartao obj where obj.codigoSegurancaCartao = ?1 and obj.nroCartao = ?2 and obj.valorCredito >= ?3")
	public Integer isSaldoSuficiente(Integer codigoSegurancaCartao, Integer nroCartao, BigDecimal valorCompra);

	@Query("from Cartao obj where obj.codigoSegurancaCartao = ?1 and obj.nroCartao = ?2")
	public Cartao findCartao(Integer codigoSegurancaCartao, Integer nroCartao);

	@Modifying
	@Query("update Cartao set valorCredito = (valorCredito - ?3) where codigoSegurancaCartao = ?1 and nroCartao = ?2 ")
	public void atualizarSaldo(Integer codigoSegurancaCartao, Integer nroCartao, BigDecimal valorCompra);
}
