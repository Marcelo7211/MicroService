package com.communication.buyfeedback.gateway.http;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.communication.buyfeedback.domain.CompraRedis;
import com.communication.buyfeedback.exceptions.NaoFinalizadoException;
import com.communication.buyfeedback.gateway.repository.CompraRedisRepository;

@RestController
@RequestMapping("/")
public class CompraController {
	
	@Autowired
	private CompraRedisRepository compraRedisRepository;
	
	@GetMapping("/{chave}")
	public CompraRedis status(@PathVariable String chave){
		
		Optional<CompraRedis> compra = compraRedisRepository.findById(chave);
		
		if( !compra.isPresent()){
			throw new NaoFinalizadoException();
		}
		
		return compra.get();
	}
	
	@GetMapping("/meunome")
	public String status(){
		return "Estou na máquina do: Marcelo";
	}

}
