package com.gestaofilas.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gestaofilas.entity.Categoria;
import com.gestaofilas.entity.Restaurante;

// TODO: Auto-generated Javadoc
/**
 * A Interface RestauranteDAO.
 */
@Repository
public interface RestauranteDAO extends JpaRepository<Restaurante, Integer>{

	/**
	 * Encontra distintos restaurantes por nome e que contenha determinada categoria.
	 *
	 * @param nome the nome
	 * @param categorias the categorias
	 * @param pageRequest the page request
	 * @return the page
	 */
	@Transactional(readOnly=true)
//	@Query("SELECT DISTINCT obj FROM Restaurante obj INNER JOIN obj.categorias cat WHERE obj.nomeFantasia LIKE %:nome% AND cat IN :categorias")
//	Page<Restaurante> search(@Param("nome") String nome, @Param("categorias") List<Categoria> categorias, Pageable pageRequest);
	Page<Restaurante> findDistinctByNomeContainingAndCategoriasIn(String nome, List<Categoria> categorias, Pageable pageRequest);
	
	/**
	 * Encontra restaurante pelo email.
	 *
	 * @param email the email
	 * @return the restaurante
	 */
	@Transactional(readOnly=true)
	Restaurante findByEmail(String email);
	
	/**
	 * Encontra restaurante pelo CNPJ.
	 *
	 * @param cnpj the cnpj
	 * @return the boolean
	 */
	@Transactional(readOnly=true)
	Boolean findByCnpj(String cnpj);
	
}
