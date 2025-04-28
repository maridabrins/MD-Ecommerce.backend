package com.revisao.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.revisao.ecommerce.dto.CategoriaDTO;
import com.revisao.ecommerce.dto.ProdutoDTO;
import com.revisao.ecommerce.entities.Categoria;
import com.revisao.ecommerce.entities.Produto;
import com.revisao.ecommerce.repositories.CategoriaRepository;
import com.revisao.ecommerce.repositories.ProdutoRepository;

import jakarta.transaction.Transactional;

@Service
public class ProdutoService {
	
	@Autowired
	ProdutoRepository repository;
	
	@Autowired
	CategoriaRepository cRepository;
	
	//estamos definindo uma lista de produtos
	public List<ProdutoDTO> findAll(){
		List<Produto> lista = repository.findAll();
		return lista.stream().map(x-> new ProdutoDTO(x)).toList();
	}
	
	public Page<ProdutoDTO> findPagina(Pageable pagina){
		Page<Produto> busca = repository.findAll(pagina);
		return busca.map(x-> new ProdutoDTO(x));
	}
	
	
	@Transactional //garantir eficacia do método
	public ProdutoDTO findById(Long id){
		Produto entity = repository.findById(id).get();
		return  new ProdutoDTO(entity);
	}
	
	@Transactional
	public ProdutoDTO insert(ProdutoDTO dto) {
		Produto entity = new Produto();
		entity.setNome(dto.getNome());
		entity.setDescricao(dto.getDescricao());
		entity.setPreco(dto.getPreco());
		entity.setImgUrl(dto.getImgUrl());
		
		for(CategoriaDTO cDTO : dto.getCategorias()) {
			Categoria cat = cRepository.getReferenceById(cDTO.getId());
			entity.getCategorias().add(cat);
		}
		entity = repository.save(entity);
		return new ProdutoDTO(entity);
	}
	
	@Transactional
	public ProdutoDTO update(Long id, ProdutoDTO dto) {
		
			Produto entity = repository.getReferenceById(id);
			entity.setNome(dto.getNome());
			entity.setDescricao(dto.getDescricao());
			entity.setPreco(dto.getPreco());
			entity.setImgUrl(dto.getImgUrl());
			
			entity.getCategorias().clear();
			for (CategoriaDTO cDTO : dto.getCategorias()){
				Categoria cat = cRepository.getReferenceById(cDTO.getId());
						entity.getCategorias().add(cat);
			}
			
			entity = repository.save(entity);
			return new ProdutoDTO(entity);
		
			
		}
	}
	
	


