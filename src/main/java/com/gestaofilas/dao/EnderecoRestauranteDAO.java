package com.gestaofilas.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestaofilas.entity.EnderecoRestaurante;

/**
 * A Interface EnderecoRestauranteDAO.
 */
@Repository
public interface EnderecoRestauranteDAO extends JpaRepository<EnderecoRestaurante, Integer>{

}
