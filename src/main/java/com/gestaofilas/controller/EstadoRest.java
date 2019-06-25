package com.gestaofilas.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gestaofilas.entity.Cidade;
import com.gestaofilas.entity.Estado;
import com.gestaofilas.entity.dto.CidadeDTO;
import com.gestaofilas.entity.dto.EstadoDTO;
import com.gestaofilas.services.CidadeService;
import com.gestaofilas.services.EstadoService;

// TODO: Auto-generated Javadoc
/**
 * The Class EstadoRest.
 */
@RestController
@RequestMapping(value="/estados")
public class EstadoRest {
	
	/** The service. */
	@Autowired
	private EstadoService service;
	
	/** The cidade service. */
	@Autowired
	private CidadeService cidadeService;
	
	/**
	 * Encontra todos os estados.
	 *
	 * @return the response entity
	 */
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<EstadoDTO>> findAll() {
		List<Estado> list = service.findAll();
		List<EstadoDTO> listDto = list.stream().map(obj -> new EstadoDTO(obj)).collect(Collectors.toList());  
		return ResponseEntity.ok().body(listDto);
	}
	
	/**
	 * Encontra as cidades conforme o estado.
	 *
	 * @param estadoId the estado id
	 * @return the response entity
	 */
	@RequestMapping(value="/{estadoId}/cidades", method=RequestMethod.GET)
	public ResponseEntity<List<CidadeDTO>> findCidades(@PathVariable Integer estadoId) {
		List<Cidade> list = cidadeService.findByEstado(estadoId);
		List<CidadeDTO> listDto = list.stream().map(obj -> new CidadeDTO(obj)).collect(Collectors.toList());  
		return ResponseEntity.ok().body(listDto);
	}
}