package com.revisao.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revisao.ecommerce.dto.ProdutoDTO;
import com.revisao.ecommerce.services.ProdutoService;

@RestController
@RequestMapping(value = "produto")
public class ProdutoController {
	
	@Autowired
	ProdutoService service;
	
	@GetMapping
	public List<ProdutoDTO> findAll(){
		return service.findAll();
	}
	
	@GetMapping(value = "/pagina")
	public Page<ProdutoDTO> findAll(Pageable pagina){
		return service.findPagina(pagina);	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ProdutoDTO> findById(@PathVariable Long id) {
		ProdutoDTO dto = service.findById(id);
		return ResponseEntity.ok(dto);
	}
	@PostMapping(value = "/salvar")
	public ResponseEntity<ProdutoDTO> insert (@RequestBody ProdutoDTO dto){
		dto = service.insert(dto);
		return ResponseEntity.ok(dto);
	}
	
	@PutMapping(value = "/editar/{id}")
	public ResponseEntity<ProdutoDTO> update(@PathVariable Long id, @RequestBody ProdutoDTO dto){
		dto = service.update(id, dto);
		return ResponseEntity.ok(dto);
	}
	
	@DeleteMapping("/excluir/{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}

}
