package com.gestaofilas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.gestaofilas.services.exceptions.DataIntegrityException;
import com.gestaofilas.services.exceptions.ObjectNotFoundException;
import com.gestaofilas.dao.CategoriaDAO;
import com.gestaofilas.entity.Categoria;


@Service
public class CategoriaService {

	@Autowired
	CategoriaDAO repo;
	
	public List<Categoria> findAll() {
		return repo.findAll();
	}
	
	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}
	
	public Page<Categoria> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Categoria save (Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Categoria update(Categoria obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		Optional<Categoria> obj = repo.findById(id);

		if(obj.get().getRestaurantes().isEmpty()) {
			repo.deleteById(id);
		}else {
			throw new DataIntegrityException("Está Categoria não pode ser deletada");
		}
		
	}
}
