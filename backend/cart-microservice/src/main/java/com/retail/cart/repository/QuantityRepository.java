package com.retail.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.retail.cart.model.Product;
import com.retail.cart.model.Quantity;

@Repository
public interface QuantityRepository extends JpaRepository<Quantity, Long> {

	Quantity findByProduct(Product product);
	
	
}
