package com.gestaofilas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestaofilas.dao.CidadeDAO;
import com.gestaofilas.entity.Cidade;


// TODO: Auto-generated Javadoc
/**
 * Classe CidadeService.
 */
@Service
public class CidadeService {
	
	/** The repo. */
	@Autowired
	private CidadeDAO repo;
	
	/**
	 * Encontra por estado.
	 *
	 * @param estadoId the estado id
	 * @return the list
	 */
	public List<Cidade> findByEstado(Integer estadoId) {
		return repo.findCidades(estadoId);
	}
}