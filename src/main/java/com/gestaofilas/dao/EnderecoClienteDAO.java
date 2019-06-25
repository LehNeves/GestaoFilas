package com.gestaofilas.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestaofilas.entity.EnderecoCliente;

/**
 * A Interface EnderecoClienteDAO.
 */
@Repository
public interface EnderecoClienteDAO extends JpaRepository<EnderecoCliente, Integer>{

}
