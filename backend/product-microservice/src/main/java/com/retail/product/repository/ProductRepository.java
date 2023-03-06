package com.retail.product.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.retail.product.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	List<Product> findByNameAndDescriptionAndPrice(String name, String description, BigDecimal price);

	List<Product> findByNameContainingIgnoreCase(String name);

//	public Product findByName(String name);
	
//	public Product findByImage(String image);


}
