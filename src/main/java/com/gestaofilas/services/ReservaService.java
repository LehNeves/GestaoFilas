package com.gestaofilas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.gestaofilas.dao.ReservaDAO;
import com.gestaofilas.entity.Cliente;
import com.gestaofilas.entity.Reserva;
import com.gestaofilas.entity.Restaurante;
import com.gestaofilas.entity.dto.ReservaNewDTO;
import com.gestaofilas.entity.enums.EstadoReserva;
import com.gestaofilas.entity.enums.Perfil;
import com.gestaofilas.security.UserSS;
import com.gestaofilas.services.exceptions.AuthorizationException;
import com.gestaofilas.services.exceptions.ObjectNotFoundException;


// TODO: Auto-generated Javadoc
/**
 * Classe ReservaService.
 */
@Service
public class ReservaService {

	/** The repo. */
	@Autowired
	ReservaDAO repo;
	
	/** The usuario service. */
	@Autowired
	UsuarioService usuarioService;
	
	/** The restaurante service. */
	@Autowired
	RestauranteService restauranteService;
	
	/** The cliente service. */
	@Autowired
	ClienteService clienteService;
	
	/**
	 * Encontra por id.
	 *
	 * @param id the id
	 * @return the reserva
	 */
	public Reserva findById(Integer id) {
		Optional<Reserva> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Reserva.class.getName()));
	}

	/**
	 * Encontra tudo.
	 *
	 * @return the list
	 */
	public List<Reserva> findAll() {
		return repo.findAll();
	}
	
	/**
	 * Encontra um objeto do tipo page.
	 *
	 * @param page the page
	 * @param linesPerPage the lines per page
	 * @param orderBy the order by
	 * @param direction the direction
	 * @return the page
	 */
	public Page<Reserva> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		UserSS user = UserService.authenticated();
		if(user == null) {
			throw new AuthorizationException("Acesso negado");
		}
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		
		if(user.hasRole(Perfil.CLIENTE)) {
			Cliente cliente = clienteService.findById(user.getId());
			return repo.findByCliente(cliente, pageRequest);
		}else if(user.hasRole(Perfil.RESTAURANTE)) {
			Restaurante restaurante = restauranteService.findById(user.getId());
			return repo.findByRestaurante(restaurante, pageRequest);
		}
		
		return repo.findAll(pageRequest);
	}
	
	/**
	 * Insere.
	 *
	 * @param objDto the obj dto
	 * @return the reserva
	 */
	public Reserva insert (ReservaNewDTO objDto) {
		Reserva obj = new Reserva(null, objDto.getHoraReserva(), EstadoReserva.PENDENTE);
		Cliente cliente = clienteService.findById(objDto.getCliente());
		Restaurante restaurante = restauranteService.findById(objDto.getRestaurante());
		obj.setCliente(cliente);
		obj.setRestaurante(restaurante);
		
		return repo.save(obj);
	}
	
	/**
	 * Atualiza.
	 *
	 * @param obj the obj
	 * @return the reserva
	 */
	public Reserva update(Reserva obj) {
		findById(obj.getId());
		return repo.save(obj);
	}
	
	/**
	 * Deleta.
	 *
	 * @param id the id
	 */
	public void delete(Integer id) {
		Reserva obj = findById(id);
		repo.deleteById(obj.getId());
	}
	
	/**
	 * Encontra pelo cliente.
	 *
	 * @param id the id
	 * @return the list
	 */
	public List<Reserva> findByCliente(Integer id){
		
		UserSS user = UserService.authenticated();
		if(user == null) {
			throw new AuthorizationException("Acesso negado");
		}
		
		if(user.hasRole(Perfil.CLIENTE)) {
			Cliente cliente = clienteService.findById(user.getId());
			return repo.findByCliente(cliente);
		}
		
		return null;
	}
	
}
