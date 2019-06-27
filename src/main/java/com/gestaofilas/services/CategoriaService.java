package com.gestaofilas.services;

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
import com.gestaofilas.entity.Categoria;


// TODO: Auto-generated Javadoc
/**
 * Classe CategoriaService.
 */
@Service
public class CategoriaService {

	/** The repo. */
	@Autowired
	CategoriaDAO repo;
	
	/**
	 * Encontra por id.
	 *
	 * @param id the id
	 * @return the categoria
	 */
	public Categoria findById(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}
	
	/**
	 * Encontra tudo.
	 *
	 * @return the list
	 */
	public List<Categoria> findAll() {
		return repo.findAll();
	}
	
	/**
	 * Encontra um objeto do tipo page.
	 *
	 * @param page the page
	 * @param linesPerPage the lines per page
	 * @param orderBy the order by
	 * @param direction the direction
	 * @return the page
	 */
	public Page<Categoria> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	/**
	 * Salva.
	 *
	 * @param obj the obj
	 * @return the categoria
	 */
	public Categoria save (Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	/**
	 * Atualiza.
	 *
	 * @param obj the obj
	 * @return the categoria
	 */
	public Categoria update(Categoria obj) {
		findById(obj.getId());
		return repo.save(obj);
	}
	
	/**
	 * Deleta.
	 *
	 * @param id the id
	 */
	public void delete(Integer id) {
		Categoria obj = findById(id);

		if(obj.getRestaurantes().isEmpty()) {
			repo.deleteById(id);
		}else {
			throw new DataIntegrityException("Está Categoria não pode ser deletada");
		}
		
	}
}
