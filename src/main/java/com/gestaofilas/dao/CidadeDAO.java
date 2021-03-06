package com.gestaofilas.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gestaofilas.entity.Cidade;

// TODO: Auto-generated Javadoc
/**
 * A Interface CidadeDAO.
 */
@Repository
public interface CidadeDAO extends JpaRepository<Cidade, Integer>{

	/**
	 * Encontra cidades.
	 *
	 * @param estado_id the estado id
	 * @return the list
	 */
	@Transactional(readOnly=true)
	@Query("SELECT obj FROM Cidade obj WHERE obj.estado.id = :estadoId ORDER BY obj.nome")
	public List<Cidade> findCidades(@Param("estadoId") Integer estado_id);
	
}
