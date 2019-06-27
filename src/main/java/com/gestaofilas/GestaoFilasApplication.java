package com.gestaofilas;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.gestaofilas.dao.*;
import com.gestaofilas.entity.*;
import com.gestaofilas.entity.enums.*;

// TODO: Auto-generated Javadoc
/**
 * The Class GestaoFilasApplication.
 */
@SpringBootApplication
public class GestaoFilasApplication implements CommandLineRunner {
	
	/** The b crypt. */
	@Autowired
	BCryptPasswordEncoder bCrypt;
	
	/** The cat save. */
	@Autowired
	private CategoriaDAO catSave;
	
	/** The cid save. */
	@Autowired
	private CidadeDAO cidSave;
	
	/** The rest save. */
	@Autowired
	private RestauranteDAO restSave;
	
	/** The cliente save. */
	@Autowired
	private ClienteDAO clienteSave;
	
	/** The est save. */
	@Autowired
	private EstadoDAO estSave;
	
	/** The end rest save. */
	@Autowired
	private EnderecoRestauranteDAO endRestSave;
	
	/** The end cliente save. */
	@Autowired
	private EnderecoClienteDAO endClienteSave;
	
	/** The tel rest save. */
	@Autowired
	private TelRestauranteDAO telRestSave;
	
	/** The tel cliente save. */
	@Autowired
	private TelClienteDAO telClienteSave;
	
	/** The reserva save. */
	@Autowired
	private ReservaDAO reservaSave;
	
	/** The usuario save. */
	@Autowired
	private UsuarioDAO usuarioSave;

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(GestaoFilasApplication.class, args);
	}
	
	/**
	 * Adicionando as categorias no back-end.
	 *
	 * @param args the args
	 * @throws Exception the exception
	 */
	public void run(String... args) throws Exception {
		
		String[] categorias = {
				"Asiatico",
				"Brasileiro",
				"Churrascaria",
				"Vegetariano",
				"Japonês",
				"Caseira",
				"Pizzaria"
		};
		
		Categoria cat1 = new Categoria(null, "Teste 1");
		Categoria cat2 = new Categoria(null, "Teste 2");
		
		for(int i = 0; i < categorias.length; i++) {
			Categoria cat = new Categoria(null, categorias[i]);
			catSave.save(cat);
		}
		
		Restaurante rest1 = new Restaurante(null, "rest1", "rest1", "123", "rest1@email.com", bCrypt.encode("123"));
		Restaurante rest2 = new Restaurante(null, "rest2", "rest2", "123", "rest2@email.com", bCrypt.encode("123"));
		
		EnderecoRestaurante endRestaurante = new EnderecoRestaurante(null, "rua", "123", "", "bairro", "cep");
		EnderecoRestaurante endRestaurante2 = new EnderecoRestaurante(null, "rua2", "123", "", "bairro", "cep");

		Cidade cidade = new Cidade(null, "Cidade1", null);

		Estado estado = new Estado(null, "São Paulo");
		
		TelefoneRestaurante telRest1 = new TelefoneRestaurante(null, 16, "00000");
		TelefoneRestaurante telRest2 = new TelefoneRestaurante(null, 15, "00000");
		TelefoneRestaurante telRest3 = new TelefoneRestaurante(null, 17, "00000");
		
		telRest1.setRestaurante(rest1);
		telRest2.setRestaurante(rest1);
		telRest3.setRestaurante(rest1);
		
		estado.setCidades(Arrays.asList(cidade));
		estSave.save(estado);
		
		cidade.setEstado(estado);
		cidSave.save(cidade);
		
		endRestaurante.setCidade(cidade);
		endRestSave.save(endRestaurante);
		
		endRestaurante2.setCidade(cidade);
		endRestSave.save(endRestaurante2);

		cat1.getRestaurantes().addAll(Arrays.asList(rest1));
		cat2.getRestaurantes().addAll(Arrays.asList(rest1));
		cat1.getRestaurantes().addAll(Arrays.asList(rest2));
		
		rest1.getCategorias().addAll(Arrays.asList(cat1, cat2));
		rest1.setEndereco(endRestaurante);
		rest1.getTelefonesRestaurante().addAll(Arrays.asList(telRest1, telRest2));
		
		rest2.getCategorias().addAll(Arrays.asList(cat1));
		rest2.setEndereco(endRestaurante2);
		rest2.getTelefonesRestaurante().addAll(Arrays.asList(telRest3));
		
		catSave.saveAll(Arrays.asList(cat1, cat2));
		
		restSave.saveAll(Arrays.asList(rest1, rest2));
		telRestSave.saveAll(Arrays.asList(telRest1, telRest2, telRest3));
		
		Cliente cliente = new Cliente(null, "Leandro", "leandro@gmail.com", "000000", bCrypt.encode("123"));
		
		TelefoneCliente telCliente1 = new TelefoneCliente(null, 16, "00000");
		
		telCliente1.setCliente(cliente);
		
		EnderecoCliente endCliente = new EnderecoCliente(null, "Rua", "000", "bairroteste", "cepteste");
		endCliente.setCidade(cidade);
		
		cliente.setEndereco(endCliente);
		
		endClienteSave.save(endCliente);
		
		clienteSave.save(cliente);
		
		telClienteSave.save(telCliente1);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Reserva reserva = new Reserva(null, sdf.parse("30/05/2019 10:30"), EstadoReserva.PENDENTE);
		reserva.setCliente(cliente);
		reserva.setRestaurante(rest1);
		reservaSave.save(reserva);
		
		Usuario usuario = new Usuario(null, "admin", bCrypt.encode("123"));
		usuario.addPerfil(Perfil.ADMIN);
		usuarioSave.save(usuario);
		
	}
}
