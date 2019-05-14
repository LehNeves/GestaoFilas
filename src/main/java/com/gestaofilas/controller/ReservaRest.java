package com.gestaofilas.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
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
import com.gestaofilas.services.ReservaService;

@RestController
@RequestMapping(value="/categorias")
public class ReservaRest {
	
	@Autowired
	private ReservaService service;
	
	@GetMapping
	public ResponseEntity<List<ReservaDTO>> getReservas() {
		List<Reserva> list = service.findAll();
		List<ReservaDTO> listDto = list.stream().map(obj -> new ReservaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	/*
	 * @GetMapping(value="/{id}") public ResponseEntity<ReservaDTO>
	 * find(@PathVariable Integer id){ Reserva categoria = service.find(id);
	 * ReservaDTO obj = new ReservaDTO(categoria, categoria.getRestaurantes());
	 * return ResponseEntity.ok().body(obj); }
	 * 
	 * @GetMapping(value="/page") public ResponseEntity<Page<ReservaDTO2>> findPage(
	 * 
	 * @RequestParam(value="page", defaultValue="0") Integer page,
	 * 
	 * @RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage,
	 * 
	 * @RequestParam(value="orderBy", defaultValue="nome") String orderBy,
	 * 
	 * @RequestParam(value="direction", defaultValue="ASC") String direction) {
	 * Page<Reserva> list = service.findPage(page, linesPerPage, orderBy,
	 * direction); Page<ReservaDTO2> listDto = list.map(obj -> new
	 * ReservaDTO2(obj)); return ResponseEntity.ok().body(listDto); }
	 * 
	 * @PostMapping ResponseEntity<Void> insert (@RequestBody Reserva obj){ obj =
	 * service.save(obj); URI uri =
	 * ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand
	 * (obj.getId()).toUri(); return ResponseEntity.created(uri).build(); }
	 * 
	 * @PutMapping(value="/{id}") public ResponseEntity<Void> update(@PathVariable
	 * Integer id, @RequestBody Reserva obj){ obj.setId(id); obj =
	 * service.update(obj); return ResponseEntity.noContent().build(); }
	 * 
	 * @DeleteMapping(value="/{id}") public ResponseEntity<Void>
	 * delete(@PathVariable Integer id){ service.delete(id); return
	 * ResponseEntity.noContent().build(); }
	 */

}