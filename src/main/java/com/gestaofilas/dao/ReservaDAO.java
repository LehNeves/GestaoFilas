package com.gestaofilas.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gestaofilas.entity.Cliente;
import com.gestaofilas.entity.Reserva;
import com.gestaofilas.entity.Restaurante;

@Repository
public interface ReservaDAO extends JpaRepository<Reserva, Integer>{
	
	@Transactional(readOnly=true)
	Page<Reserva> findByCliente(Cliente cliente, Pageable pageRequest);
	
	@Transactional(readOnly=true)
	Page<Reserva> findByRestaurante(Restaurante restaurante, Pageable pageRequest);

}
