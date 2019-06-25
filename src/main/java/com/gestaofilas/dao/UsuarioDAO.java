package com.gestaofilas.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestaofilas.entity.Usuario;

// TODO: Auto-generated Javadoc
/**
 * A Interface UsuarioDAO.
 */
@Repository
public interface UsuarioDAO extends JpaRepository<Usuario, Integer>{
	
	/**
	 * Encontra um usuário pelo email.
	 *
	 * @param email the email
	 * @return the usuario
	 */
	Usuario findByEmail(String email);
	
}