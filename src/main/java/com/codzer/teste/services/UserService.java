package com.codzer.teste.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.codzer.teste.entities.User;
import com.codzer.teste.repositories.UserRepository;
import com.codzer.teste.services.exceptions.DatabaseException;
import com.codzer.teste.services.exceptions.RessourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {

	@Autowired
	// Dependecia 
	private UserRepository repository;
	
	
	public List<User> findAll()
	{
		return repository.findAll();
	}
	
	public User findById(Long id)
	{
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(  ()-> new RessourceNotFoundException(id)  );
	}
	
	public User insert(User obj)
	{
		return repository.save(obj);
	}
	
	public void delete(Long id)
	{
		try {
			repository.deleteById(id);
		}
		catch (EmptyResultDataAccessException e) 
		{
			throw new RessourceNotFoundException(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public User update(Long id, User obj)
	{
		try {
			User entity = repository.getReferenceById(id);
			entity.setName( obj.getName() );
			entity.setPhone(obj.getPhone());
			return repository.save( entity);
		}
		catch (EntityNotFoundException e) 
		{
			throw new RessourceNotFoundException(id);
		}
	}
}
