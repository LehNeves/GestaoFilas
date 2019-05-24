package com.gestaofilas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestaofilas.dao.EstadoDAO;
import com.gestaofilas.entity.Estado;


@Service
public class EstadoService {
	
	@Autowired
	private EstadoDAO repo;
	
	public List<Estado> findAll() {
		return repo.findAllByOrderByNome();
	}
}