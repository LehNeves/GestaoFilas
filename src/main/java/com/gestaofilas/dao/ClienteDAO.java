package com.gestaofilas.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gestaofilas.entity.Cliente;

@Repository
public interface ClienteDAO extends JpaRepository<Cliente, Integer>{
	
	@Transactional(readOnly=true)
	Cliente findByCpf(String cpf);
	
	@Transactional(readOnly=true)
	Cliente findByEmail(String email);
	
}
