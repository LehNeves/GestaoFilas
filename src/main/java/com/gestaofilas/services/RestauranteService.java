package com.gestaofilas.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.gestaofilas.services.exceptions.AuthorizationException;
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
import com.gestaofilas.entity.enums.Perfil;
import com.gestaofilas.security.UserSS;

// TODO: Auto-generated Javadoc
/**
 * Classe RestauranteService.
 */
@Service
public class RestauranteService {
	
	/** The b crypt. */
	@Autowired
	BCryptPasswordEncoder bCrypt;
	
	/** The restaurante repo. */
	@Autowired
	RestauranteDAO restauranteRepo;
	
	/** The categoria repo. */
	@Autowired
	CategoriaDAO categoriaRepo;
	
	/** The telefone repo. */
	@Autowired
	TelRestauranteDAO telefoneRepo;
	
	/** The endereco repo. */
	@Autowired
	EnderecoRestauranteDAO enderecoRepo;
	
	/**
	 * Encontra tudo.
	 *
	 * @return the list
	 */
	public List<Restaurante> findAll(){
		return restauranteRepo.findAll();
	}
	
	/**
	 * Encontra pelo id.
	 *
	 * @param id the id
	 * @return the restaurante
	 */
	public Restaurante findById(Integer id) {
		
		UserSS user = UserService.authenticated();
		if (user==null || !user.hasRole(Perfil.ADMIN) && !id.equals(user.getId())) {
			throw new AuthorizationException("Acesso negado");
		}
		
		Optional<Restaurante> obj = restauranteRepo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Restaurante.class.getName()));
	}
	
	/**
	 * Busca.
	 *
	 * @param nome the nome
	 * @param ids the ids
	 * @param page the page
	 * @param linesPerPage the lines per page
	 * @param orderBy the order by
	 * @param direction the direction
	 * @return the page
	 */
	public Page<Restaurante> search(String nome, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		List<Categoria> categorias = categoriaRepo.findAllById(ids);
		return restauranteRepo.findDistinctByNomeContainingAndCategoriasIn(nome, categorias, pageRequest);
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
	public Page<Restaurante> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return restauranteRepo.findAll(pageRequest);
	}
	
	/**
	 * Insere.
	 *
	 * @param objDto the obj dto
	 * @return the restaurante
	 */
	public Restaurante insert(RestauranteNewDTO objDto) {
		objDto.setSenha(bCrypt.encode(objDto.getSenha()));
		Restaurante restaurante = new Restaurante(objDto);
		List<Categoria> categorias = new ArrayList<Categoria>();
		
		categorias = categoriaRepo.findAllById(objDto.getIdsCategoria());
		
		restaurante.setCategorias(categorias);
		
		for(Categoria x : categorias) {
			x.getRestaurantes().add(restaurante);
			categoriaRepo.save(x);
		}
		
		EnderecoRestaurante enderecoRestaurante = new EnderecoRestaurante(objDto);
		Cidade cidade = new Cidade(objDto.getCidade(), null, null);
		enderecoRestaurante.setCidade(cidade);
		restaurante.setEndereco(enderecoRestaurante);
		restaurante.setTelefonesRestaurante(objDto.getTelefones());
		enderecoRepo.save(enderecoRestaurante);
		restaurante = restauranteRepo.save(restaurante);
		for(TelefoneRestaurante x : objDto.getTelefones()) {
			TelefoneRestaurante tel = new TelefoneRestaurante(null, x.getDdd(), x.getTelefone());
			telefoneRepo.save(tel);
		}
		
		return restaurante;
	}
	
	/**
	 * Atualiza.
	 *
	 * @param objDto the obj dto
	 */
	public void update(RestauranteUpdateDTO objDto) {
		Restaurante obj = findById(objDto.getId());
		obj = updateData(obj, objDto);
		restauranteRepo.save(obj);
	}
	
	/**
	 * Atualiza dado.
	 *
	 * @param obj the obj
	 * @param objDto the obj dto
	 * @return the restaurante
	 */
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
	
	/**
	 * Deleta.
	 *
	 * @param id the id
	 */
	public void delete(Integer id) {
		Restaurante obj = findById(id);
		
		if(!obj.getReservas().isEmpty()) throw new DataIntegrityException("Este Resturante não pode ser deletado");
		
		restauranteRepo.delete(obj);
		
	}
}
