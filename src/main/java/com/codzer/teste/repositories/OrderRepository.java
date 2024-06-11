package com.codzer.teste.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codzer.teste.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

	
}
