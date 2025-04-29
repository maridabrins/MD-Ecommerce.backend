package com.revisao.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revisao.ecommerce.entities.ItemDoPedido;
import com.revisao.ecommerce.entities.ItemDoPedidoPK;

@Repository
public interface ItemDoPedidoRepository extends JpaRepository <ItemDoPedido, ItemDoPedidoPK>{

}
