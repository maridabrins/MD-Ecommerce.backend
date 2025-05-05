package com.revisao.ecommerce.dto;

import com.revisao.ecommerce.entities.ItemDoPedido;

public class ItemDoPedidoDTO {
	
	private Long produtoId;
	private String nome;
	private int quantidade;
	private Double preco;
	private String urlImg;
	
	
	public ItemDoPedidoDTO() {
		
	}


	public ItemDoPedidoDTO(Long produtoId, String nome, int quantidade, Double preco, String urlImg) {
		this.produtoId = produtoId;
		this.nome = nome;
		this.quantidade = quantidade;
		this.preco = preco;
		this.urlImg = urlImg;
	}
	
	public ItemDoPedidoDTO(ItemDoPedido entity) {
		this.produtoId = entity.getProduto().getId(); //pegando o id do Produto
		this.nome = entity.getProduto().getNome(); //pegando o nome do Produto
		this.quantidade = entity.getQuantidade();
		this.preco = entity.getPreco();
		this.urlImg = entity.getProduto().getImgUrl(); //pegando url do Produto
	}


	public Long getProdutoId() {
		return produtoId;
	}


	public void setProdutoId(Long produtoId) {
		this.produtoId = produtoId;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}


	public Double getPreco() {
		return preco;
	}


	public void setPreco(Double preco) {
		this.preco = preco;
	}


	public String getUrlImg() {
		return urlImg;
	}


	public void setUrlImg(String urlImg) {
		this.urlImg = urlImg;
	}
	
	public Double getSubTotal() {
		return preco * quantidade;
	}
	
	
}
