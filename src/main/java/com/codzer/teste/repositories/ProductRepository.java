package com.codzer.teste.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codzer.teste.entities.Category;
import com.codzer.teste.entities.Products;

public interface ProductRepository extends JpaRepository<Products, Long> {

	
}
