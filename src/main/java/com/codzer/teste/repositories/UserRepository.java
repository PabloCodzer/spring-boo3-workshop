package com.codzer.teste.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codzer.teste.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	
}
