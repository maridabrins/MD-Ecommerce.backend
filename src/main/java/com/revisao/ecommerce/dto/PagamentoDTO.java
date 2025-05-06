package com.revisao.ecommerce.dto;

import java.time.Instant;

import com.revisao.ecommerce.entities.Pagamento;

public class PagamentoDTO {

	private Long pedidoId;
	private Instant momento;
	
	
	public PagamentoDTO() {
		
	}


	public PagamentoDTO(Long pedidoId, Instant momento) {
		this.pedidoId = pedidoId;
		this.momento = momento;
	}
	
	public PagamentoDTO(Pagamento entity) {
		this.pedidoId = entity.getPedido().getId();
		this.momento = entity.getMomento();
	}


	public Long getPedidoId() {
		return pedidoId;
	}


	public void setPedidoId(Long pedidoId) {
		this.pedidoId = pedidoId;
	}


	public Instant getMomento() {
		return momento;
	}


	public void setMomento(Instant momento) {
		this.momento = momento;
	}
	
	
	
	
}
