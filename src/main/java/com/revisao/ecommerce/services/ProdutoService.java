package com.revisao.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.revisao.ecommerce.dto.ProdutoDTO;
import com.revisao.ecommerce.entities.Produto;
import com.revisao.ecommerce.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	ProdutoRepository repository;
	
	//estamos definindo uma lista de produtos
	public List<ProdutoDTO> findAll(){
		List<Produto> lista = repository.findAll();
		return lista.stream().map(x-> new ProdutoDTO(x)).toList();
	}
	
	public Page<ProdutoDTO> findPagina(Pageable pagina){
		Page<Produto> busca = repository.findAll(pagina);
		return busca.map(x-> new ProdutoDTO(x));
	}

}
