package com.unifacisa.ecommerce.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.unifacisa.ecommerce.entities.User;
import com.unifacisa.ecommerce.repositories.UserRepository;

@RestController
public class UserController {
	
	private final UserRepository repository;
	
	UserController(UserRepository repository){
		this.repository = repository;
	}
	
	@GetMapping("/users")
	List<User> all(){
		return repository.findAll();
	}
	
	@GetMapping("/users/{id}")
	User one(@PathVariable Long id) {
		return repository.findById(id).orElseThrow();
	}
	
	@PostMapping("/users")
	User newUser(@RequestBody User newUser) {
		return repository.save(newUser);
	}
	
	
	@PutMapping("/users/{id}")
	User replace(@RequestBody User newUser, @PathVariable Long id) {
		return repository.findById(id).map(user -> {
			user.setName(newUser.getName());
			user.setPassword(newUser.getPassword());
			user.setEmail(newUser.getEmail());
			user.setId(newUser.getId());
			return repository.save(newUser);
		}).orElseGet(() -> {
			newUser.setId(id);
			return repository.save(newUser);
		});
	}
	
	@DeleteMapping("/users/{id}")
	void deleteUser(@PathVariable Long id) {
		repository.deleteById(id);
	}

}
