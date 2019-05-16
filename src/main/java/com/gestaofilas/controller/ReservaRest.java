package com.gestaofilas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gestaofilas.entity.Reserva;
import com.gestaofilas.entity.dto.ReservaDTO;
import com.gestaofilas.services.ReservaService;

@RestController
@RequestMapping(value = "/reservas")
public class ReservaRest {

	@Autowired
	private ReservaService service;

	@GetMapping(value="/{id}") 
	public ResponseEntity<ReservaDTO> find(@PathVariable Integer id){ 
		Reserva obj = service.findById(id);
		ReservaDTO obj2 = new ReservaDTO(obj);
		return ResponseEntity.ok().body(obj2); 
	}

	@GetMapping
	public ResponseEntity<Page<ReservaDTO>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page,
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage,
			@RequestParam(value="orderBy", defaultValue="horaReserva") String orderBy,
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		Page<Reserva> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<ReservaDTO> pageDto = list.map(obj -> new ReservaDTO(obj));
		return ResponseEntity.ok().body(pageDto);
	}

	@PutMapping(value="/{id}") 
	public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody Reserva obj) { 
		obj.setId(id); 
		obj = service.update(obj); return ResponseEntity.noContent().build(); 
	}

	@DeleteMapping(value="/{id}") 
	public ResponseEntity<Void> delete(@PathVariable Integer id){ 
		service.delete(id);
		return ResponseEntity.noContent().build(); 
	}
}