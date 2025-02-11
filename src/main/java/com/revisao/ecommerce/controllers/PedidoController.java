package com.revisao.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revisao.ecommerce.entities.Pedido;
import com.revisao.ecommerce.repositories.PedidoRepository;

@RestController
@RequestMapping(value = "pedido")
public class PedidoController {
	
	@Autowired
	PedidoRepository repository;
	
	/*@GetMapping
	public ResponseEntity<List<Pedido>> mostrarTodos(){
		List<Pedido> pedido = repository.findAll();
		return ResponseEntity.ok(pedido);
	}
	
	@GetMapping
	public ResponseEntity<?> mostrarPorId(@PathVariable Long id){
		Pedido pedido = repository.getById(id);
		return ResponseEntity.ok(pedido);
	}*/
	

}
