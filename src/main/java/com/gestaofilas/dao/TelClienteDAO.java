package com.gestaofilas.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestaofilas.entity.TelefoneCliente;

@Repository
public interface TelClienteDAO extends JpaRepository<TelefoneCliente, Integer>{

}
