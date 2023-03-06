package com.retail.cart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CartMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CartMsApplication.class, args);
	}
	
//	@Bean
//	public CommandLineRunner loadData(CartRepository cartRepository) {
//		return args -> {
//		Cart cart = new Cart();
//		cart.setProdcode("iphone_13");
//		cart.setQuantity(100);
//		
//		Cart cart1 = new Cart();
//		cart1.setProdcode("iphone_13_black");
//		cart1.setQuantity(0);
//		
//		cartRepository.save(cart);
//		cartRepository.save(cart1);
//		};
//	}

}
