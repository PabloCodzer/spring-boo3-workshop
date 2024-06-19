package com.codzer.teste.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codzer.teste.entities.Category;
import com.codzer.teste.entities.OrderItem;
import com.codzer.teste.entities.pk.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

	
}
 