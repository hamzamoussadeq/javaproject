package com.retail.cart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.retail.cart.model.Cart;
import com.retail.cart.model.User;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long>{

	List<Cart> findByUser(User user);

//	Optional<Cart> findByProdcode();

}
