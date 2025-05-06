package com.revisao.ecommerce.services;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revisao.ecommerce.dto.ItemDoPedidoDTO;
import com.revisao.ecommerce.dto.PedidoDTO;
import com.revisao.ecommerce.entities.ItemDoPedido;
import com.revisao.ecommerce.entities.Pedido;
import com.revisao.ecommerce.entities.Produto;
import com.revisao.ecommerce.entities.StatusDoPedido;
import com.revisao.ecommerce.entities.Usuario;
import com.revisao.ecommerce.repositories.ItemDoPedidoRepository;
import com.revisao.ecommerce.repositories.PedidoRepository;
import com.revisao.ecommerce.repositories.ProdutoRepository;
import com.revisao.ecommerce.repositories.UsuarioRepository;

import jakarta.transaction.Transactional;



@Service
public class PedidoService {
	
	@Autowired
	PedidoRepository repository;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	ItemDoPedidoRepository itemRepository;
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@Transactional
	public List<PedidoDTO> findAll(){
		List<Pedido> lista = repository.findAll();
		 return lista.stream().map(pedido -> new PedidoDTO(pedido)).toList();
		
	}
	
	public PedidoDTO findById(Long id) {
		Pedido entity = repository.findById(id).get();
		return new PedidoDTO(entity);
	}
	
	@Transactional //falar p banco que vc vai mandar varias 
	public PedidoDTO insert(PedidoDTO dto) {
			Pedido entity = new Pedido();
			entity.setMomento(Instant.now());
			entity.setStatus(StatusDoPedido.AGUARDANDO_PAGAMENTO);
			
			Usuario user = usuarioRepository.getReferenceById(dto.getCliente_id());
			entity.setCliente(user);
			
			for(ItemDoPedidoDTO itemDto : dto.getItens()) {
				Produto produto = produtoRepository.getReferenceById(itemDto.getProdutoId());
				ItemDoPedido item = new ItemDoPedido(entity,produto, itemDto.getQuantidade(), itemDto.getPreco());
				entity.getItens().add(item);
			}
			entity = repository.save(entity);
			itemRepository.saveAll(entity.getItens());
			return new PedidoDTO(entity);
		}
	
	
	
	@Transactional
	public PedidoDTO update(Long id, PedidoDTO dto) {
	    Pedido entity = repository.getReferenceById(id);

	    entity.setMomento(dto.getMomento());
	    entity.setStatus(dto.getStatus());

	    // Remove os itens antigos
	    itemRepository.deleteAll(entity.getItens());
	    entity.getItens().clear();

	    // Adiciona os novos itens
	    for (ItemDoPedidoDTO itemDTO : dto.getItens()) {
	        Produto produto = produtoRepository.getReferenceById(itemDTO.getProdutoId());
	        ItemDoPedido novoItem = new ItemDoPedido(entity, produto, itemDTO.getQuantidade(), itemDTO.getPreco());
	        entity.getItens().add(novoItem);
	    }

	    entity = repository.save(entity);
	    itemRepository.saveAll(entity.getItens());

	    return new PedidoDTO(entity);
	}
	
	@Transactional
	public void delete(Long id) {
		Pedido entity = repository.findById(id).orElseThrow();
		//precisa deletar a lista de pedidos
		itemRepository.deleteAll(entity.getItens());
		repository.deleteById(id);
	}
}
