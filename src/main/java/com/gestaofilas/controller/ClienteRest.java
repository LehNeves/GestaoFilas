package com.gestaofilas.controller;

import java.net.URI;

import javax.validation.Valid;

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

import com.gestaofilas.entity.Cliente;
import com.gestaofilas.entity.dto.ClienteDTO;
import com.gestaofilas.entity.dto.ClienteDTO2;
import com.gestaofilas.entity.dto.ClienteNewDTO;
import com.gestaofilas.services.ClienteService;

@RestController
@RequestMapping(value="/clientes")
public class ClienteRest {
	
	@Autowired
	ClienteService service;
	
	@GetMapping
	public ResponseEntity<Page<ClienteDTO>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="nome") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction
		){
			Page<Cliente> list = service.findPage(page, linesPerPage, orderBy, direction);			
			Page<ClienteDTO> listDto = list.map(obj -> new ClienteDTO(obj));

			return ResponseEntity.ok().body(listDto);
		}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<ClienteDTO2> findByID(@PathVariable Integer id){
		Cliente obj = service.findById(id);
		ClienteDTO2 objDto = new ClienteDTO2(obj);
		return ResponseEntity.ok().body(objDto);
	}
	
	@PostMapping
	public ResponseEntity<ClienteDTO> insert (@Valid @RequestBody ClienteNewDTO obj){
		Cliente obj2 = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj2.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value="/{id}") 
    public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody Cliente obj) { 
        obj.setId(id); 
        obj = service.update(obj); 
        return ResponseEntity.noContent().build(); 
    }

    @DeleteMapping(value="/{id}") 
    public ResponseEntity<Void> delete(@PathVariable Integer id){ 
        service.delete(id);
        return ResponseEntity.noContent().build(); 
    }

}
