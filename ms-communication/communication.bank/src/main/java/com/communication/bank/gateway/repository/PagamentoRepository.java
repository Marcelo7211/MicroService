package com.communication.bank.gateway.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.communication.bank.domain.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
}

