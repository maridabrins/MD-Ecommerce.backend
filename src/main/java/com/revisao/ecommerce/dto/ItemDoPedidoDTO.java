package com.revisao.ecommerce.dto;

import com.revisao.ecommerce.entities.ItemDoPedido;

public class ItemDoPedidoDTO {
	
	private Long produtoId;
	private Integer quantidade;
	private Double preco;
	
	
	public ItemDoPedidoDTO() {
		
	}
	
	
	public ItemDoPedidoDTO(Long produtoId, Integer quantidade, Double preco) {
	    this.produtoId = produtoId;
	    this.quantidade = quantidade;
	    this.preco = preco;
	}
	
	public ItemDoPedidoDTO(ItemDoPedido entity) {
	    this.produtoId = entity.getProduto().getId(); 
	    this.quantidade = entity.getQuantidade();
	    this.preco = entity.getPreco();
	}


	public Long getProdutoId() {
		return produtoId;
	}


	public void setProdutoId(Long produtoId) {
		this.produtoId = produtoId;
	}


	public Integer getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}


	public Double getPreco() {
		return preco;
	}


	public void setPreco(Double preco) {
		this.preco = preco;
	}


	

}
