package com.unifacisa.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unifacisa.ecommerce.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
