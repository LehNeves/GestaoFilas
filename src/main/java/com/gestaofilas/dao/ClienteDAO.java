package com.gestaofilas.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gestaofilas.entity.Cliente;

// TODO: Auto-generated Javadoc
/**
 * The Interface ClienteDAO.
 */
@Repository
public interface ClienteDAO extends JpaRepository<Cliente, Integer>{
	
	/**
	 * Encontra cliente por cpf.
	 *
	 * @param cpf the cpf
	 * @return the cliente
	 */
	@Transactional(readOnly=true)
	Cliente findByCpf(String cpf);
	
	/**
	 * Encontra cliente pelo email.
	 *
	 * @param email the email
	 * @return the cliente
	 */
	@Transactional(readOnly=true)
	Cliente findByEmail(String email);
	
}
