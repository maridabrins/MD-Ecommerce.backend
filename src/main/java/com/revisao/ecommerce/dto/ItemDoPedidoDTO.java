package com.revisao.ecommerce.dto;

import com.revisao.ecommerce.entities.ItemDoPedido;

public class ItemDoPedidoDTO {
	
	private Integer quantidade;
	private Double preco;
	
	
	public ItemDoPedidoDTO() {
		
	}
	
	
	public ItemDoPedidoDTO(Integer quantidade, Double preco) {
		super();
		this.quantidade = quantidade;
		this.preco = preco;
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
