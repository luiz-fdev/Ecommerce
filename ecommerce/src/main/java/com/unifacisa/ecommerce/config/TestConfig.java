package com.unifacisa.ecommerce.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.unifacisa.ecommerce.entities.Cart;
import com.unifacisa.ecommerce.entities.CartItem;
import com.unifacisa.ecommerce.entities.Category;
import com.unifacisa.ecommerce.entities.Product;
import com.unifacisa.ecommerce.entities.User;
import com.unifacisa.ecommerce.repositories.CartItemRepository;
import com.unifacisa.ecommerce.repositories.CategoryRepository;
import com.unifacisa.ecommerce.repositories.ProductRepository;
import com.unifacisa.ecommerce.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CartItemRepository cartItemRepository;

	@Override
	public void run(String... args) throws Exception {

		Category cat1 = new Category(null, "Eletrônicos");
		Category cat2 = new Category(null, "Livros");
		Category cat3 = new Category(null, "Jogos");

		Product p1 = new Product(null, "EA Sports FC 24",
				"EA FC 24 é um jogo de futebol que oferece uma experiência imersiva, realista e emocionante", 369.9);
		Product p2 = new Product(null, "Iphone 15 Pro Max",
				"Smartphone de última geração da Apple que tem recursos avançados", 8000.0);
		Product p3 = new Product(null, "Acer Nitro 5", "Excelente e caro notebook da Acer, tem uma 4060.", 10000);
		Product p4 = new Product(null, "God of War", "Jogo que segue a jornada do Kratos.", 200.0);
		Product p5 = new Product(null, "Mil ao milhâo", "Guia financeiro.", 19.99);
		Product p6 = new Product(null, "A psicologia financeira", "Guia sobre a relação psicologia e finanças.", 17.99);

		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6));

		p1.getCategories().add(cat3);
		p2.getCategories().add(cat1);
		p3.getCategories().add(cat1);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);
		p6.getCategories().add(cat2);

		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6));

		User u1 = new User(null, "Luiz", "luiz@gmail.com", "12345");
		User u2 = new User(null, "Laerte", "laerte@gmail.com", "12345");

		userRepository.saveAll(Arrays.asList(u1, u2));
		
		Cart cart1 = new Cart();
		u1.setCart(cart1);
		
		Cart cart2 =  new Cart();
		u2.setCart(cart2);
		
		userRepository.save(u1);
		userRepository.save(u2);
		
		CartItem ci1 = new CartItem(cart1, p1, 2, p1.getPrice());
		CartItem ci2 = new CartItem(cart2, p3, 1, p3.getPrice());
		
		cartItemRepository.saveAll(Arrays.asList(ci1, ci2));
	}
}
