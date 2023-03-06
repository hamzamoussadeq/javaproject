package com.retail.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.retail.order.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
	
//	Optional<Order> findByProd_code();

}
