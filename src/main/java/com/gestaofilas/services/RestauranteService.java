package com.gestaofilas.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.gestaofilas.services.exceptions.DataIntegrityException;
import com.gestaofilas.services.exceptions.ObjectNotFoundException;
import com.gestaofilas.dao.CategoriaDAO;
import com.gestaofilas.dao.EnderecoRestauranteDAO;
import com.gestaofilas.dao.RestauranteDAO;
import com.gestaofilas.dao.TelRestauranteDAO;
import com.gestaofilas.entity.Categoria;
import com.gestaofilas.entity.Cidade;
import com.gestaofilas.entity.EnderecoRestaurante;
import com.gestaofilas.entity.Restaurante;
import com.gestaofilas.entity.TelefoneRestaurante;
import com.gestaofilas.entity.dto.RestauranteNewDTO;
import com.gestaofilas.entity.dto.RestauranteUpdateDTO;

@Service
public class RestauranteService {
	
	@Autowired
	RestauranteDAO restauranteRepo;
	
	@Autowired
	CategoriaDAO categoriaRepo;
	
	@Autowired
	TelRestauranteDAO telefoneRepo;
	
	@Autowired
	EnderecoRestauranteDAO enderecoRepo;
	
	public List<Restaurante> findAll(){
		return restauranteRepo.findAll();
	}
	
	public Restaurante findById(Integer id) {
		Optional<Restaurante> obj = restauranteRepo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Restaurante.class.getName()));
	}
	
	public Page<Restaurante> search(String nome, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		List<Categoria> categorias = categoriaRepo.findAllById(ids);
		return restauranteRepo.findDistinctByNomeContainingAndCategoriasIn(nome, categorias, pageRequest);
	}
	
	public Page<Restaurante> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return restauranteRepo.findAll(pageRequest);
	}
	
	public Restaurante insert(RestauranteNewDTO obj) {
		Restaurante restaurante = new Restaurante(obj);
		List<Categoria> categorias = new ArrayList<Categoria>();
		
		categorias = categoriaRepo.findAllById(obj.getIdsCategoria());
		
		restaurante.setCategorias(categorias);
		
		for(Categoria x : categorias) {
			x.getRestaurantes().add(restaurante);
			categoriaRepo.save(x);
		}
		
		EnderecoRestaurante enderecoRestaurante = new EnderecoRestaurante(obj);
		Cidade cidade = new Cidade(obj.getCidade(), null, null);
		enderecoRestaurante.setCidade(cidade);
		restaurante.setEndereco(enderecoRestaurante);
		restaurante.setTelefonesRestaurante(obj.getTelefones());
		enderecoRepo.save(enderecoRestaurante);
		restaurante = restauranteRepo.save(restaurante);
		for(TelefoneRestaurante x : obj.getTelefones()) {
			TelefoneRestaurante tel = new TelefoneRestaurante(null, x.getDdd(), x.getTelefone());
			telefoneRepo.save(tel);
		}
		
		return restaurante;
	}
	
	public void update(RestauranteUpdateDTO objDto) {
		Restaurante obj = findById(objDto.getId());
		obj = updateData(obj, objDto);
		restauranteRepo.save(obj);
	}
	
	public Restaurante updateData(Restaurante obj, RestauranteUpdateDTO objDto) {
		obj.setNome(objDto.getNome());
		obj.setEmail(objDto.getEmail());
		obj.setRazaoSocial(objDto.getRazaoSocial());
		obj.setSenha(objDto.getSenha());
		obj.setEndereco(objDto.getEnderecoRestaurante());
		obj.setTelefonesRestaurante(objDto.getTelefonesRestaurante());
		
		List<Categoria> categorias = categoriaRepo.findAllById(objDto.getIdsCategorias());
		obj.setCategorias(categorias);
		
		for(Categoria x : categorias) {
			x.getRestaurantes().add(obj);
			categoriaRepo.save(x);
		}
		
		return obj;
	}
	
	public void delete(Integer id) {
		Restaurante obj = findById(id);
		
		if(!obj.getReservas().isEmpty()) throw new DataIntegrityException("Este Resturante não pode ser deletado");
		
		restauranteRepo.delete(obj);
		
	}
}
