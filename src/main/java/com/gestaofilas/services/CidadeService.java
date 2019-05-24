package com.gestaofilas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestaofilas.dao.CidadeDAO;
import com.gestaofilas.entity.Cidade;


@Service
public class CidadeService {
	
	@Autowired
	private CidadeDAO repo;
	
	public List<Cidade> findByEstado(Integer estadoId) {
		return repo.findCidades(estadoId);
	}
}