package com.unifacisa.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unifacisa.ecommerce.entities.Product;
import com.unifacisa.ecommerce.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> list(){
		return productRepository.findAll();
	}
	
	public Product one(Long id) {
		return productRepository.findById(id).orElseThrow();
	}
	
	public Product newProduct(Product newProduct) {
		return productRepository.save(newProduct);	
	}
	
	public Product replace(Product newProduct, Long id) {
		return productRepository.findById(id).map(product -> {
			product.setDescription(newProduct.getDescription());
			product.setName(newProduct.getName());
			product.setPrice(newProduct.getPrice());
			product.setId(newProduct.getId());
			return productRepository.save(newProduct);
		}).orElseGet(() -> {
			newProduct.setId(id);
			return productRepository.save(newProduct);
		});
	}
	
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}

}
