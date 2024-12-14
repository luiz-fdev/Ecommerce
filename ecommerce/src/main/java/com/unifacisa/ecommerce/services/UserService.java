package com.unifacisa.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unifacisa.ecommerce.entities.User;
import com.unifacisa.ecommerce.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> list(){
		return userRepository.findAll();
	}
	
	public User one(Long id) {
		return userRepository.findById(id).orElseThrow();
	}
	
	public User newUser(User newUser) {
		return userRepository.save(newUser);	
	}
	
	public User replace(User newUser, Long id) {
		return userRepository.findById(id).map(user -> {
			user.setName(newUser.getName());
			user.setPassword(newUser.getPassword());
			user.setEmail(newUser.getEmail());
			user.setId(newUser.getId());
			return userRepository.save(newUser);
		}).orElseGet(() -> {
			newUser.setId(id);
			return userRepository.save(newUser);
		});
	}
	
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
	
}
