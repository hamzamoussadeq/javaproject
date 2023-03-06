package com.retail.cart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.retail.cart.model.Cart;
import com.retail.cart.model.Quantity;
import com.retail.cart.model.User;
import com.retail.cart.repository.CartRepository;
import com.retail.cart.repository.QuantityRepository;

@Service
public class CartService {

	@Autowired
	public CartRepository cartRepository;
	@Autowired
	private QuantityRepository quantityRepository;
	@Autowired
	private RestTemplate restTemplate;

//	// Check that product is in stock
//	@Transactional(readOnly = true)
//	public boolean isInStock(String prodcode) {
//		return cartRepository.findByProdcode().isPresent();
//	}
//	
	// Get all cart items
	public List<Cart> getAllItems() {
		return cartRepository.findAll();
	}

	public Cart addToCart(Cart cart) {
		// TODO Auto-generated method stub
		List<Quantity> quantity = cart.getQuantity();
		quantity.stream().map(item -> quantityRepository.save(item));
		return cartRepository.save(cart);

	}

	public void deleteFromCart(Long id) {
		cartRepository.deleteById(id);
		// TODO Auto-generated method stub
//		Product checkProduct= restTemplate.getForObject("http://localhost:8081/product/products/"+parseLong, Product.class);
//		System.out.print(checkProduct);
//		Quantity checkQuantity=quantityRepository.findByProduct(product);
//		System.out.print(checkQuantity);
//		quantityRepository.delete(checkQuantity);
//		if(checkQuantity.getQuantity()>1) {
//			checkQuantity.setQuantity(checkQuantity.getQuantity()-1);
//		}
//		else {
//			quantityRepository.delete(checkQuantity);
//		}		
	}

	public List<Cart> getByUser(User user) {
		return cartRepository.findByUser(user);
		
		
	}

}
