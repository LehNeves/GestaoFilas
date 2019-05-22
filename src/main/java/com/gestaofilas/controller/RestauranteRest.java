package com.gestaofilas.controller;

import java.net.URI;
import java.util.List;

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

import com.gestaofilas.controller.utils.URL;
import com.gestaofilas.entity.Restaurante;
import com.gestaofilas.entity.dto.RestauranteDTO;
import com.gestaofilas.entity.dto.RestauranteDTO2;
import com.gestaofilas.entity.dto.RestauranteNewDTO;
import com.gestaofilas.entity.dto.RestauranteUpdateDTO;
import com.gestaofilas.services.RestauranteService;

@RestController
@RequestMapping(value="/restaurantes")
public class RestauranteRest {

	@Autowired
	RestauranteService service;
	
	@GetMapping
	public ResponseEntity<Page<RestauranteDTO>> findPage(
		@RequestParam(value="nome", defaultValue="") String nome, 
		@RequestParam(value="categorias", defaultValue="") String categorias,
		@RequestParam(value="page", defaultValue="0") Integer page, 
		@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
		@RequestParam(value="orderBy", defaultValue="nome") String orderBy, 
		@RequestParam(value="direction", defaultValue="ASC") String direction
	){
		List<Integer> ids = URL.decodeIntList(categorias);
		String nomeDecoded = URL.decodeParam(nome);
		Page<Restaurante> list = service.search(nomeDecoded, ids, page, linesPerPage, orderBy, direction);
		Page<RestauranteDTO> listdto = list.map(obj -> new RestauranteDTO(obj));
		
		return ResponseEntity.ok().body(listdto);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<RestauranteDTO2> findByID(@PathVariable Integer id){
		Restaurante obj = service.findById(id);
		RestauranteDTO2 dto = new RestauranteDTO2(obj, obj.getTelefonesRestaurante());
		return ResponseEntity.ok().body(dto);
	}
	
	@PostMapping
	@PreAuthorize("hasAnyRole('RESTAURANTE', 'ADMIN')")
	public ResponseEntity<Void> insert(@Valid @RequestBody RestauranteNewDTO obj){
		Restaurante obj2 = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj2.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value="/{id}")
	@PreAuthorize("hasAnyRole('RESTAURANTE', 'ADMIN')")
	public ResponseEntity<Void> update(@Valid @PathVariable Integer id, @RequestBody RestauranteUpdateDTO objDto){
		service.update(objDto);
		return ResponseEntity.noContent().build();
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
