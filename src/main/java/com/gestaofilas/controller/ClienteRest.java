package com.gestaofilas.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gestaofilas.entity.Cliente;
import com.gestaofilas.entity.dto.ClienteDTO;
import com.gestaofilas.services.ClienteService;

@RestController
@RequestMapping(value="/clientes")
public class ClienteRest {
	
	@Autowired
	ClienteService service;
	
//	@GetMapping
//	public ResponseEntity<Page<ClienteDTO>> findPage(
//			@RequestParam(value="page", defaultValue="0") Integer page, 
//			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
//			@RequestParam(value="orderBy", defaultValue="nome") String orderBy, 
//			@RequestParam(value="direction", defaultValue="ASC") String direction
//		){
//		
//			Page<Cliente> list = service.findPage(page, linesPerPage, orderBy, direction);
//			Page<ClienteDTO> listDto = list.map(obj -> new ClienteDTO(obj));
//
//			return ResponseEntity.ok().body(listDto);
//		}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<ClienteDTO> findByID(@PathVariable Integer id){
		Cliente cliente = service.findById(id);
		ClienteDTO clienteDto = new ClienteDTO(cliente);
		return ResponseEntity.ok().body(clienteDto);
	}
	
	@GetMapping
	public ResponseEntity<List<ClienteDTO>> findAll(){
		List<Cliente> cliente = service.findAll();
		List<ClienteDTO> clienteDto = cliente.stream().map(obj -> new ClienteDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(clienteDto);
	}
	
}
