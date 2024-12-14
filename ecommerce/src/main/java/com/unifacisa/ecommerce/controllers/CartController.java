package com.unifacisa.ecommerce.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.unifacisa.ecommerce.entities.Cart;
import com.unifacisa.ecommerce.repositories.CartRepository;

@RestController
public class CartController {

    private final CartRepository repository;

	CartController(CartRepository repository){
		this.repository = repository;
	}
	
	@GetMapping("/carts")
	List<Cart> all(){
		return repository.findAll();
	}
	
	@GetMapping("/carts/{id}")
	Cart one(@PathVariable Long id) {
		return repository.findById(id).orElseThrow();
	}
}