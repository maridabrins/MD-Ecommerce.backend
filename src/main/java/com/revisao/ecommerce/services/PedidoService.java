package com.revisao.ecommerce.services;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revisao.ecommerce.dto.PedidoDTO;
import com.revisao.ecommerce.entities.Pedido;
import com.revisao.ecommerce.entities.StatusDoPedido;
import com.revisao.ecommerce.entities.Usuario;
import com.revisao.ecommerce.repositories.PedidoRepository;
import com.revisao.ecommerce.repositories.UsuarioRepository;

import jakarta.transaction.Transactional;



@Service
public class PedidoService {
	
	@Autowired
	PedidoRepository repository;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	
	@Transactional //falar p banco que vc vai mandar varias 
	public PedidoDTO insert(PedidoDTO dto) {
			Pedido entity = new Pedido();
			entity.setId(dto.getId());
			entity.setMomento(Instant.now());
			entity.setStatus(StatusDoPedido.AGUARDANDO_PAGAMENTO);
			
			Usuario user = usuarioRepository.getReferenceById(dto.getCliente_id());
			
			entity.setCliente(user);
			
			entity = repository.save(entity);
			
			return new PedidoDTO(entity);
		}
}
