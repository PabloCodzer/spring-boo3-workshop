package com.codzer.teste.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codzer.teste.entities.Category;
import com.codzer.teste.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	// Dependecia 
	private CategoryRepository repository;
	
	
	public List<Category> findAll()
	{
		return repository.findAll();
	}
	
	public Category findById(Long id)
	{
		Optional<Category> obj = repository.findById(id);
		return obj.get();
	}
}
