package com.revisao.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revisao.ecommerce.entities.Categoria;
import com.revisao.ecommerce.repositories.CategoriaRepository;

@RestController
@RequestMapping(value = "categoria")
public class CategoriaController {
	/*
	@Autowired
	CategoriaRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> mostrarTodos(){
		List<Categoria> categoria = repository.findAll();
		return ResponseEntity.ok(categoria);
	}
	
	@GetMapping
	public ResponseEntity<?> mostrarPorId(@PathVariable Long id){
		Categoria categoria = repository.getById(id);
		return ResponseEntity.ok(categoria);
	}*/

}
