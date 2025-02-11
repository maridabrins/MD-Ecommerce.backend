package com.revisao.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revisao.ecommerce.entities.Usuario;
import com.revisao.ecommerce.repositories.UsuarioRepository;

@RestController
@RequestMapping(value = "usuario")
public class UsuarioController {
	
	/*@Autowired
	UsuarioRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> mostrarTodos(){
		List<Usuario> user = repository.findAll();
		return ResponseEntity.ok(user);
	}
	
	@GetMapping
	public ResponseEntity<?> mostrarPorId(@PathVariable Long id){
		Usuario user = repository.getById(id);
		return ResponseEntity.ok(user);
		
	}
*/
}
