package com.codzer.teste.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.codzer.teste.entities.Category;
import com.codzer.teste.entities.Order;
import com.codzer.teste.entities.Products;
import com.codzer.teste.entities.User;
import com.codzer.teste.entities.enums.OrderStatus;
import com.codzer.teste.repositories.CategoryRepository;
import com.codzer.teste.repositories.OrderRepository;
import com.codzer.teste.repositories.ProductRepository;
import com.codzer.teste.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777");
		
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID,u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT ,u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.DELIVERED ,u1); 
		
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers"); 
		
		Products p1 = new Products(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, ""); 
		Products p2 = new Products(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, ""); 
		Products p3 = new Products(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, ""); 
		Products p4 = new Products(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, ""); 
		Products p5 = new Products(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, ""); 



		
		
		userRepository.saveAll(  Arrays.asList(u1,u2)  );
		orderRepository.saveAll( Arrays.asList(o1,o2,o3) );
		categoryRepository.saveAll( Arrays.asList(cat1,cat2,cat3) );
		productRepository.saveAll( Arrays.asList(p1, p2, p3, p4, p5) );
		
		p1.getCategory().add(cat2);
		p2.getCategory().add(cat1);
		p2.getCategory().add(cat3);
		p3.getCategory().add(cat3);
		p4.getCategory().add(cat3);
		p5.getCategory().add(cat2);
		productRepository.saveAll( Arrays.asList(p1, p2, p3, p4, p5) );
		
	}
}
