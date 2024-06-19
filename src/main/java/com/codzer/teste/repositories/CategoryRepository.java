package com.codzer.teste.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codzer.teste.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

	
}
