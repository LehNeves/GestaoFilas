package com.gestaofilas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.gestaofilas.dao.ClienteDAO;
import com.gestaofilas.dao.EnderecoClienteDAO;
import com.gestaofilas.dao.TelClienteDAO;
import com.gestaofilas.entity.Cidade;
import com.gestaofilas.entity.Cliente;
import com.gestaofilas.entity.EnderecoCliente;
import com.gestaofilas.entity.Reserva;
import com.gestaofilas.entity.TelefoneCliente;
import com.gestaofilas.entity.dto.ClienteNewDTO;
import com.gestaofilas.entity.dto.ClienteUpdateDTO;
import com.gestaofilas.entity.enums.Perfil;
import com.gestaofilas.security.UserSS;
import com.gestaofilas.services.exceptions.AuthorizationException;
import com.gestaofilas.services.exceptions.DataIntegrityException;
import com.gestaofilas.services.exceptions.ObjectNotFoundException;

// TODO: Auto-generated Javadoc
/**
 * Classe ClienteService.
 */
@Service
public class ClienteService {
	
	/** The b crypt. */
	@Autowired
	BCryptPasswordEncoder bCrypt;

	/** The cliente repo. */
	@Autowired
	ClienteDAO clienteRepo;
	
	/** The telefone repo. */
	@Autowired
	TelClienteDAO telefoneRepo;
	
	/** The endereco repo. */
	@Autowired
	EnderecoClienteDAO enderecoRepo;
	
	/**
	 * Encontra tudo.
	 *
	 * @return the list
	 */
	public List<Cliente> findAll() {
		return clienteRepo.findAll();
	}
	
	/**
	 * Encontra por id.
	 *
	 * @param id the id
	 * @return the cliente
	 */
	public Cliente findById(Integer id) {
		
		UserSS user = UserService.authenticated();
		if (user==null || !user.hasRole(Perfil.ADMIN) && !id.equals(user.getId())) {
			throw new AuthorizationException("Acesso negado");
		}
		
		Optional<Cliente> obj = clienteRepo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
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
	public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return clienteRepo.findAll(pageRequest);
	}
	
	
	/**
	 * Insere.
	 *
	 * @param objDto the obj dto
	 * @return the cliente
	 */
	public Cliente insert(ClienteNewDTO objDto) {
		objDto.setSenha(bCrypt.encode(objDto.getSenha()));
		Cliente obj = new Cliente(objDto);
				
		EnderecoCliente enderecoCliente = new EnderecoCliente(objDto);
		Cidade cidade = new Cidade(objDto.getCidade(), null, null);
		enderecoCliente.setCidade(cidade);
		obj.setEndereco(enderecoCliente);
		
		TelefoneCliente telefoneCliente = new TelefoneCliente(null, objDto.getDdd(), objDto.getTelefone());
		telefoneCliente.setCliente(obj);
		obj.setTelefone(telefoneCliente);
		
		enderecoRepo.save(enderecoCliente);
		obj = clienteRepo.save(obj);
		telefoneRepo.save(telefoneCliente);

		return obj;
	}
	
	/**
	 * Atualiza.
	 *
	 * @param objDto the obj dto
	 */
	public void update(ClienteUpdateDTO objDto) {
		Cliente obj = findById(objDto.getId());
		obj = updateData(obj, objDto);
		clienteRepo.save(obj);
	}
	
	/**
	 * Atualiza dado.
	 *
	 * @param obj the obj
	 * @param objDto the obj dto
	 * @return the cliente
	 */
	public Cliente updateData(Cliente obj, ClienteUpdateDTO objDto) {
		obj.setNome(objDto.getNome());
		obj.setEmail(objDto.getEmail());
		obj.setEndereco(objDto.getEndereco());
		obj.setTelefone(objDto.getTelefone());
		
		return obj;
	}
	
	/**
	 * Deleta.
	 *
	 * @param id the id
	 */
	public void delete(Integer id) {
		Optional<Cliente> obj = clienteRepo.findById(id);

		if(obj.get().getReservas().isEmpty()) {
			clienteRepo.deleteById(id);
		}else {
			throw new DataIntegrityException("Este Cliente não pode ser deletado");
		}
	}
	
	/**
	 * Encontra por email.
	 *
	 * @param email the email
	 * @return the cliente
	 */
	public Cliente findByEmail(String email) {
		
		UserSS user = UserService.authenticated();
		if (user==null || !user.hasRole(Perfil.ADMIN) && !email.equals(user.getUsername())) {
			throw new AuthorizationException("Acesso negado");
		}
		
		Cliente obj = clienteRepo.findByEmail(email);
		if(obj == null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + email + ", Tipo: " + Cliente.class.getName());
		}
		
		return obj;
	}

	/**
	 * Encontra reserva.
	 *
	 * @param id the id
	 * @return the list
	 */
	public List<Reserva> findReserva(Integer id) {
		
		Cliente obj = findById(id);
		
		List<Reserva> list = obj.getReservas();
		
		
		return list;
	}
	
}
