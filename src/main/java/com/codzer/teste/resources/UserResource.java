package com.codzer.teste.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codzer.teste.entities.User;

@RestController
@RequestMapping(value =	"/users")
public class UserResource {

	@GetMapping
	public ResponseEntity<User> findAll()
	{
		User u = new User(1L, "Nome do usuario", "0800 11 00 51", "adocica meu amor");
		return ResponseEntity.ok().body(u);
	}
	
	@PostMapping
	public ResponseEntity<User> findAl2222l()
	{
		User u = new User(1L, "Nome do usuario", "0800 11 00 51", "adocica meu amor");
		return ResponseEntity.ok().body(u);
	}
}
