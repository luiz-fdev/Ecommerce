package com.unifacisa.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unifacisa.ecommerce.entities.Cart;
import com.unifacisa.ecommerce.repositories.CartRepository;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;
	
	public List<Cart> list(){
		return cartRepository.findAll();
	}
	
	public Cart one(Long id) {
		return cartRepository.findById(id).orElseThrow();
	}

}
