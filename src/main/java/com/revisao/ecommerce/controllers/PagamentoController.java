package com.revisao.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revisao.ecommerce.entities.Pagamento;
import com.revisao.ecommerce.repositories.PagamentoRepository;

@RestController
@RequestMapping(value = "pagamento")
public class PagamentoController {
	/*
	@Autowired
	PagamentoRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Pagamento>> mostrarTodos(){
		List<Pagamento> pag = repository.findAll();
		return ResponseEntity.ok(pag);
	}

	@GetMapping
	public ResponseEntity<?> mostrarPorId(@PathVariable Long id){
		Pagamento pag = repository.getById(id);
		return ResponseEntity.ok(pag);
	}*/
}
