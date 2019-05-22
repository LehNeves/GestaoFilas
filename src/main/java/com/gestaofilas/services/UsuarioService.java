package com.gestaofilas.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.gestaofilas.dao.UsuarioDAO;
import com.gestaofilas.entity.Usuario;
import com.gestaofilas.entity.enums.Perfil;
import com.gestaofilas.security.UserSS;
import com.gestaofilas.services.exceptions.AuthorizationException;
import com.gestaofilas.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {
	
	@Autowired
	BCryptPasswordEncoder bCrypt;

	@Autowired
	UsuarioDAO usuarioRepo;
	
	public Usuario findById(Integer id) {
		
		UserSS user = UserService.authenticated();
		if (user==null || !user.hasRole(Perfil.ADMIN) && !id.equals(user.getId())) {
			throw new AuthorizationException("Acesso negado");
		}
		
		Optional<Usuario> obj = usuarioRepo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName()));
	}
	
}
