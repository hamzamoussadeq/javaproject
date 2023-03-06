package com.retail.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retail.product.model.Product;
import com.retail.product.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	public ProductRepository productRepository;

	// Get all product details
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
	
//	//Check for duplicate product image
//	public boolean isProductUnique(String imageString) {
//		List<Product> products = getAllProducts();
//		for(Product p:products) {
//			if(p.getImage().equalsIgnoreCase(imageString)) {
//				return false;
//			}
//		} 
//		return true;
//	}
//		Product checkProduct = productRepository.findByImage(p.getImage());	
	
	// Create product
	public Product createProduct(Product p) {
//		boolean checkImage = isProductUnique(null);
		List<Product> product_list = productRepository.findByNameAndDescriptionAndPrice(p.getName(), p.getDescription(),
				p.getPrice());
		if (product_list.size() >= 1) {   //p.getImage().equalsIgnoreCase(checkProduct.getImage()
			return null;
		} else {
			return productRepository.save(p);
		}
	}

	// Get product by Id
	public Product getProductById(Long id) {
		Optional<Product> productOptional = productRepository.findById(id);
		if (productOptional.isPresent()) {
			return productOptional.get();
		} else {
			return null;
		}
	}

	// To get product by name
	public List<Product> getProductByName(String name) {
		 return productRepository.findByNameContainingIgnoreCase(name);
//		if (productOptional.isPresent()) {
//			return productOptional.get();
//		} else {
//			return null;
//		}
	}

	// Update products
	public Product updateById(Long id, Product p) {
		Product updated_prod = getProductById(id);
		if (updated_prod == null)
			return null;
		updated_prod.setName(p.getName());
		updated_prod.setDescription(p.getDescription());
		updated_prod.setPrice(p.getPrice());
		updated_prod.setCategory(p.getCategory());
		updated_prod.setImage(p.getImage());
		return productRepository.save(updated_prod);
	}

	// Delete product by id
	public String deleteProductById(Long id) {
		Product p = getProductById(id);
		if (p == null) {
			return "Does not Exists";
		}
		productRepository.deleteById(id);
		return "Details got deleted.";
	}

	// Delete all products
	public void deleteAllProducts() {
		productRepository.deleteAll();
	}

//	// Create product
//	public void createProduct(ProductRequest productRequest) {
//		Product product = Product.builder()
//				.name(productRequest.getName())
//				.description(productRequest.getDescription())
//				.price(productRequest.getPrice())
//				.build();
//		
//		productRepository.save(product);
//	}

}
