package com.communication.buyfeedback.gateway.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.communication.buyfeedback.domain.CompraRedis;

@Repository
public interface CompraRedisRepository extends CrudRepository<CompraRedis, String>{

}
