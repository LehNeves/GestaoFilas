package com.gestaofilas.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gestaofilas.entity.Reserva;
import com.gestaofilas.entity.dto.ReservaDTO;
import com.gestaofilas.entity.dto.ReservaNewDTO;
import com.gestaofilas.services.ReservaService;

// TODO: Auto-generated Javadoc
/**
 * The Class ReservaRest.
 */
@RestController
@RequestMapping(value = "/reservas")
public class ReservaRest {

	/** The service. */
	@Autowired
	private ReservaService service;

	/**
	 * Encontra uma reserva pelo ID.
	 *
	 * @param id the id
	 * @return the response entity
	 */
	@GetMapping(value="/{id}")
	public ResponseEntity<ReservaDTO> find(@PathVariable Integer id){ 
		Reserva obj = service.findById(id);
		ReservaDTO obj2 = new ReservaDTO(obj);
		return ResponseEntity.ok().body(obj2); 
	}

	/**
	 * Retorna um objeto page de reservas.
	 *
	 * @param page the page
	 * @param linesPerPage the lines per page
	 * @param orderBy the order by
	 * @param direction the direction
	 * @return the response entity
	 */
	@GetMapping
	public ResponseEntity<Page<ReservaDTO>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page,
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage,
			@RequestParam(value="orderBy", defaultValue="horaReserva") String orderBy,
			@RequestParam(value="direction", defaultValue="DESC") String direction) {
		Page<Reserva> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<ReservaDTO> pageDto = list.map(obj -> new ReservaDTO(obj));
		return ResponseEntity.ok().body(pageDto);
	}
	
	/**
	 * Insere uma reserva nova.
	 *
	 * @param obj the obj
	 * @return the response entity
	 */
	@PostMapping
	@PreAuthorize("hasAnyRole('ADMIN', 'CLIENTE')")
	public ResponseEntity<ReservaNewDTO> insert (@Valid @RequestBody ReservaNewDTO obj){
		Reserva obj2 = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj2.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	/**
	 * Atualiza uma reserva já cadastrada.
	 *
	 * @param id the id
	 * @param obj the obj
	 * @return the response entity
	 */
	@PutMapping(value="/{id}")
	public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody Reserva obj) { 
		obj.setId(id); 
		obj = service.update(obj); return ResponseEntity.noContent().build(); 
	}

	/**
	 * Deleta uma reserva.
	 *
	 * @param id the id
	 * @return the response entity
	 */
	@DeleteMapping(value="/{id}")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<Void> delete(@PathVariable Integer id){ 
		service.delete(id);
		return ResponseEntity.noContent().build(); 
	}
}