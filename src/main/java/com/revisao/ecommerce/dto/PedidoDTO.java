package com.revisao.ecommerce.dto;

import java.time.Instant;

import com.revisao.ecommerce.entities.Pedido;
import com.revisao.ecommerce.entities.StatusDoPedido;

public class PedidoDTO {
	
	private Long id;
	private Instant momento;
	private StatusDoPedido status;
	private Long cliente_id; //pq usou o LOng ao inves de importar o DTO?
	
	public PedidoDTO() {
		
	}

	public PedidoDTO(Long id, Instant momento, StatusDoPedido status, Long cliente_id) {
		this.id = id;
		this.momento = momento;
		this.status = status;
		this.cliente_id = cliente_id;
	}
	
	public PedidoDTO(Pedido entity) {
		id = entity.getId();
		momento = entity.getMomento();
		status = entity.getStatus();
		cliente_id = entity.getCliente().getId();	//associando o id do cliente com o id do pedido
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

	public Long getCliente_id() {
		return cliente_id;
	}

	public void setCliente_id(Long cliente_id) {
		this.cliente_id = cliente_id;
	}
	
	


	
	
	
	

}
