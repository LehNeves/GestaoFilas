package com.gestaofilas.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestaofilas.entity.TelefoneRestaurante;

/**
 * A Interface TelRestauranteDAO.
 */
@Repository
public interface TelRestauranteDAO extends JpaRepository<TelefoneRestaurante, Integer>{

}
