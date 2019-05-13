package com.gestaofilas.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestaofilas.entity.Categoria;

@Repository
public interface CategoriaDAO extends JpaRepository<Categoria, Integer>{
	
	
}
