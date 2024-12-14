package com.unifacisa.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unifacisa.ecommerce.entities.Cart;

public interface CartRepository extends JpaRepository<Cart, Long>{

}
