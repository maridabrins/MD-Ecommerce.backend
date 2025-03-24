package com.revisao.ecommerce.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	
	
	
	@PostMapping(value = "/criar")
	public ResponseEntity<PedidoDTO> insert (@RequestBody PedidoDTO dto){
		dto = service.insert(dto);
		return ResponseEntity.ok(dto);
	}

}
