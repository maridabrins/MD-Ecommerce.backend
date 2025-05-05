package com.revisao.ecommerce.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revisao.ecommerce.entities.Pedido;
@Repository
public interface PedidoRepository extends JpaRepository<Pedido,Long>{
	

}
