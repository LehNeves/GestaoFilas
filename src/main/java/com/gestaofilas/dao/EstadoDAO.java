package com.gestaofilas.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gestaofilas.entity.Estado;

// TODO: Auto-generated Javadoc
/**
 * A Interface EstadoDAO.
 */
@Repository
public interface EstadoDAO extends JpaRepository<Estado, Integer>{
	
	/**
	 * Encontra todos os registros por nome dos estados.
	 *
	 * @return the list
	 */
	@Transactional(readOnly=true)
	public List<Estado> findAllByOrderByNome();

}
