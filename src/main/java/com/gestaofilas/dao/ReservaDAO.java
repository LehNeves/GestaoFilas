package com.gestaofilas.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gestaofilas.entity.Cliente;
import com.gestaofilas.entity.Reserva;
import com.gestaofilas.entity.Restaurante;

// TODO: Auto-generated Javadoc
/**
 * The Interface ReservaDAO.
 */
@Repository
public interface ReservaDAO extends JpaRepository<Reserva, Integer>{
	
	/**
	 * Encontra uma reserva pelo cliente.
	 *
	 * @param cliente the cliente
	 * @param pageRequest the page request
	 * @return the page
	 */
	@Transactional(readOnly=true)
	Page<Reserva> findByCliente(Cliente cliente, Pageable pageRequest);
	
	/**
	 * Encontra reserva por restaurante.
	 *
	 * @param restaurante the restaurante
	 * @param pageRequest the page request
	 * @return the page
	 */
	@Transactional(readOnly=true)
	Page<Reserva> findByRestaurante(Restaurante restaurante, Pageable pageRequest);
	
	/**
	 * Encontra reserva pelo cliente.
	 *
	 * @param cliente the cliente
	 * @return the list
	 */
	@Transactional(readOnly=true)
	List<Reserva> findByCliente(Cliente cliente);
	
	/**
	 * Encontra reserva por restaurante.
	 *
	 * @param restaurante the restaurante
	 * @return the list
	 */
	@Transactional(readOnly=true)
	List<Reserva> findByRestaurante(Restaurante restaurante);

}
