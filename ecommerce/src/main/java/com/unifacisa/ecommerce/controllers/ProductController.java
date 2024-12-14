package com.unifacisa.ecommerce.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.unifacisa.ecommerce.entities.Product;
import com.unifacisa.ecommerce.repositories.ProductRepository;

@RestController
public class ProductController {
	
	private final ProductRepository repository;
	
	ProductController(ProductRepository repository){
		this.repository = repository;
	}
	
	@GetMapping("/products")
	List<Product> all(){
		return repository.findAll();
	}
	
	@GetMapping("/products/{id}")
	Product one(@PathVariable Long id) {
		return repository.findById(id).orElseThrow();
	}
	
	@PostMapping("/products")
	Product newProduct(@RequestBody Product newProduct) {
		return repository.save(newProduct);
	}
	
	
	@PutMapping("/products/{id}")
	Product replace(@RequestBody Product newProduct, @PathVariable Long id) {
		return repository.findById(id).map(product -> {
			product.setDescription(newProduct.getDescription());
			product.setName(newProduct.getName());
			product.setPrice(newProduct.getPrice());
			product.setId(newProduct.getId());
			return repository.save(newProduct);
		}).orElseGet(() -> {
			newProduct.setId(id);
			return repository.save(newProduct);
		});
	}
	
	@DeleteMapping("/products/{id}")
	void deleteProduct(@PathVariable Long id) {
		repository.deleteById(id);
	}

}
