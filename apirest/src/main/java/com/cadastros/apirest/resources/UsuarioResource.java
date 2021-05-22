package com.cadastros.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cadastros.apirest.models.Endereco;
import com.cadastros.apirest.models.Usuario;
import com.cadastros.apirest.repository.EnderecoRepository;
import com.cadastros.apirest.repository.UsuarioRepository;

@RestController
@RequestMapping(value="/api")
public class UsuarioResource {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	EnderecoRepository enderecoRepository;
	
	@GetMapping("/usuarios")
	public List<Usuario> listaUsuarios(){
		return usuarioRepository.findAll();
	}
	
	@GetMapping("/usuario/{id}")
	public Usuario listaUsuarioUnico(@PathVariable(value="id") long id){
		return usuarioRepository.findById(id);
	}
	

	@PostMapping("/usuario")
	public Usuario salvaUsuario(@RequestBody @Validated Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	@DeleteMapping("/usuario")
	public void deletaUsuario(@RequestBody @Validated Usuario usuario) {
		usuarioRepository.delete(usuario);
	}
	
	@PutMapping("/usuario")
	public Usuario atualizaProduto(@RequestBody @Validated Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	@GetMapping("/usuario/{id}/endereco/{id}")
	public Endereco listaEnderecoUnico(@PathVariable(value="id") long id) {
		return enderecoRepository.findById(id);
	}
	
	@GetMapping("/usuario/{id}/enderecos")
	public List<Endereco> listaEnderecos(){
		return enderecoRepository.findAll();
	}

	@PostMapping("/usuario/{id}/endereco")
	public Endereco salvaEndereco(@RequestBody @Validated Endereco endereco) {
		return enderecoRepository.save(endereco);
	}

}
