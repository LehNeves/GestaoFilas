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
import com.gestaofilas.security.UserSS;
import com.gestaofilas.services.exceptions.AuthorizationException;
import com.gestaofilas.services.exceptions.ObjectNotFoundException;


@Service
public class ReservaService {

	@Autowired
	ReservaDAO repo;
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	RestauranteService restauranteService;
	
	@Autowired
	ClienteService clienteService;
	
	public Reserva findById(Integer id) {
		Optional<Reserva> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Reserva.class.getName()));
	}
	
	public List<Reserva> findAll() {
		return repo.findAll();
	}
	
	public Page<Reserva> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		UserSS user = UserService.authenticated();
		if(user == null) {
			throw new AuthorizationException("Acesso negado");
		}
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		
		Cliente cliente = clienteService.findById(user.getId());
		
		return repo.findByCliente(cliente, pageRequest);
	}
	
	public Reserva insert (ReservaNewDTO objDto) {
		Reserva obj = new Reserva(null, objDto.getHoraReserva(), EstadoReserva.PENDENTE);
		Cliente cliente = clienteService.findById(objDto.getCliente());
		Restaurante restaurante = restauranteService.findById(objDto.getRestaurante());
		obj.setCliente(cliente);
		obj.setRestaurante(restaurante);
		
		return repo.save(obj);
	}
	
	public Reserva update(Reserva obj) {
		findById(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		Reserva obj = findById(id);
		repo.deleteById(obj.getId());
	}
}
