package com.retail.cart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.retail.cart.model.Cart;
import com.retail.cart.model.User;
import com.retail.cart.service.CartService;
import com.retail.cart.service.QuantityService;

@RestController
@RequestMapping("/cart")
@CrossOrigin
public class CartController {
	
	@Autowired
	public CartService cartService;
	
	@Autowired
	private QuantityService quantityService;
	
	// Get all cart items
	@GetMapping("/all-cart-items")
	public List<Cart> getAllItems() {
		return cartService.getAllItems();
	}
	
	@PostMapping("/addToCart")
	public Cart addToCart(@RequestBody Cart cart) {
		return cartService.addToCart(cart);
	}
	
	@PostMapping("/findByUser")
	public List<Cart> getByUser(@RequestBody User user ) {
		return cartService.getByUser(user);
	}
	
	@DeleteMapping("/deleteFromCart/{id}")
	public void deleteFromCart(@PathVariable String id) {
		cartService.deleteFromCart(Long.parseLong(id));
	}
	

}
