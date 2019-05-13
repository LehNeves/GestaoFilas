package com.gestaofilas.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestaofilas.entity.Cliente;

@Repository
public interface ClienteDAO extends JpaRepository<Cliente, Integer>{
	
}
