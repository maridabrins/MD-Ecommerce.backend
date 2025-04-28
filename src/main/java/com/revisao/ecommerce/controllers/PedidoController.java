package com.revisao.ecommerce.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revisao.ecommerce.dto.PedidoDTO;
import com.revisao.ecommerce.services.PedidoService;

@RestController
@RequestMapping(value = "pedido")
public class PedidoController {
	
	@Autowired
	PedidoService service;
	
	@GetMapping
	public List<PedidoDTO> findAll(){
		return service.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<PedidoDTO> findById(@PathVariable Long id){
		PedidoDTO dto = service.findById(id);
		return ResponseEntity.ok(dto);
	}
	
	
	@PostMapping(value = "/criar")
	public ResponseEntity<PedidoDTO> insert (@RequestBody PedidoDTO dto){
		dto = service.insert(dto);
		return ResponseEntity.ok(dto);
	}

	@DeleteMapping(value = "/excluir/{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
}
