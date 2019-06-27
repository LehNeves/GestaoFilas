package com.gestaofilas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestaofilas.dao.EstadoDAO;
import com.gestaofilas.entity.Estado;


// TODO: Auto-generated Javadoc
/**
 * Classe EstadoService.
 */
@Service
public class EstadoService {
	
	/** The repo. */
	@Autowired
	private EstadoDAO repo;
	
	/**
	 * Encontra tudo.
	 *
	 * @return the list
	 */
	public List<Estado> findAll() {
		return repo.findAllByOrderByNome();
	}
}