package com.unifacisa.ecommerce.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.unifacisa.ecommerce.entities.Category;
import com.unifacisa.ecommerce.repositories.CategoryRepository;

@RestController
public class CategoryController {
	
	private final CategoryRepository repository;
	
	CategoryController(CategoryRepository repository){
		this.repository = repository;
	}
	
	@GetMapping("/categories")
	List<Category> all(){
		return repository.findAll();
	}
	
	@GetMapping("/categories/{id}")
	Category one(@PathVariable Long id) {
		return repository.findById(id).orElseThrow();
	}
}
