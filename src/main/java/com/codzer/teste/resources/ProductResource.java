package com.codzer.teste.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codzer.teste.entities.Products;
import com.codzer.teste.services.ProductService;

@RestController
@RequestMapping(value =	"/products")
public class ProductResource {

	@Autowired
	private ProductService service;
	
	@GetMapping
	public ResponseEntity<List<Products>> findAll()
	{
		List<Products> TodosUsuarios = service.findAll();
		return ResponseEntity.ok().body(TodosUsuarios);
	}
	
	@GetMapping(value= "/{id}")
	public ResponseEntity<Products> findById(@PathVariable Long id )
	{
		Products obj = service.findById(id);
		return  ResponseEntity.ok().body( obj );
	}
}
