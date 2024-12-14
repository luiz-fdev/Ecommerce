package com.unifacisa.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unifacisa.ecommerce.entities.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long>{

}
