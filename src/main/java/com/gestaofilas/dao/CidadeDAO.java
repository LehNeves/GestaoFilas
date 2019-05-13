package com.gestaofilas.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestaofilas.entity.Cidade;

@Repository
public interface CidadeDAO extends JpaRepository<Cidade, Integer>{

}
