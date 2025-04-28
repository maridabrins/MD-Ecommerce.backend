package com.revisao.ecommerce.entities;

import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_pedido")
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Instant momento;
	@Enumerated(EnumType.STRING)
	private StatusDoPedido status;
	
	@ManyToOne
	@JoinColumn(name ="cliente_id") //o id do cliente é o mesmo nas duas tabelas
	private Usuario cliente;
	
	//o cascade significa que após um id ser criado o outro será criado junto
	@OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL)
	private Pagamento pagamento;
	
	@OneToMany(mappedBy = "id.pedido")
	private Set<ItemDoPedido> itens = new HashSet<>();
	
	
	public Pedido() {
		
	}
	
	public Pedido(Long id, Instant momento, StatusDoPedido status) {
		this.id = id;
		this.momento = momento;
		this.status = status;
	}

	public Usuario getCliente() {
		return cliente;
	}

	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMomento() {
		return momento;
	}

	public void setMomento(Instant momento) {
		this.momento = momento;
	}

	public StatusDoPedido getStatus() {
		return status;
	}

	public void setStatus(StatusDoPedido status) {
		this.status = status;
	}
	
	public Set<ItemDoPedido> getItens() {
		return itens;
	}

	public List<Produto> getPedido(){
		return itens.stream().map(x ->x.getProduto()).toList();
	}

	
	
	

}
