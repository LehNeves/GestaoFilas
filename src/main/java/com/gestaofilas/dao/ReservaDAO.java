package com.gestaofilas.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestaofilas.entity.Reserva;

@Repository
public interface ReservaDAO extends JpaRepository<Reserva, Integer>{

}
