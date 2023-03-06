package com.retail.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.retail.product.model.Product;
import com.retail.product.service.ProductService;

@RestController
@RequestMapping("/product")
@CrossOrigin
public class ProductController {

	@Autowired
	public ProductService productService;

	// Get all product details
	@GetMapping("/all-products")
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	// To Create products
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public Product createProduct(@RequestBody Product p) {
		return productService.createProduct(p);
	}

	// To get product by Id
	@GetMapping("/products/{id}")
	@ResponseStatus(HttpStatus.FOUND)
	public Product getProductById(@PathVariable("id") String id) {
		return productService.getProductById(Long.parseLong(id));
	}

	// To get product by name
	@GetMapping("/products/name/{name}")
	public List<Product> getProductByName(@PathVariable("name") String name) {
		return productService.getProductByName(name);
	}
	
	// Update by product Id
	@PutMapping("/update/{id}")
	public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product p) {
		return productService.updateById(id, p);
	}

	// Delete product by Id
	@DeleteMapping("/delete/{id}")
	@ResponseStatus(HttpStatus.OK)
	public String deleteProduct(@PathVariable("id") Long id) {
		return productService.deleteProductById(id);
	}

}
