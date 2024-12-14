package com.unifacisa.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unifacisa.ecommerce.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
