package com.gestaofilas.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gestaofilas.entity.Categoria;
import com.gestaofilas.entity.Restaurante;

@Repository
public interface RestauranteDAO extends JpaRepository<Restaurante, Integer>{

//	@Transactional(readOnly=true)
//	@Query("SELECT DISTINCT obj FROM Restaurante obj INNER JOIN obj.categorias cat WHERE obj.nomeFantasia LIKE %:nome% AND cat IN :categorias")
//	Page<Restaurante> search(@Param("nome") String nome, @Param("categorias") List<Categoria> categorias, Pageable pageRequest);
	Page<Restaurante> findDistinctByNomeContainingAndCategoriasIn(String nome, List<Categoria> categorias, Pageable pageRequest);
}
