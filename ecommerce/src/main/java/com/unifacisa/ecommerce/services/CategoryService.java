package com.unifacisa.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unifacisa.ecommerce.entities.Category;
import com.unifacisa.ecommerce.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> list(){
		return categoryRepository.findAll();
	}
	
	public Category one(Long id) {
		return categoryRepository.findById(id).orElseThrow();
	}

}
