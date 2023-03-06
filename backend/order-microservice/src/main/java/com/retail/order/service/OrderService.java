package com.retail.order.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.retail.order.model.Order;
import com.retail.order.model.OrderOfItems;
import com.retail.order.repository.OrderRepository;

@Service
@Transactional
public class OrderService {

	@Autowired
	public OrderRepository orderRepository;
	
	private List<OrderItems> orderItemsList;
	
	
	public void placeOrder(OrderRequest orderRequest) {
		Order order = new Order();
		order.setOrderNo(UUID.randomUUID().toString());

		orderRequest.getOrderItemsList().stream().map(this::mapToDto).toList();

		orderRequest.setOrderItemsList(orderItemsList);

		orderRepository.save(order);
	}

	private Object mapToDto(OrderItems orderItems) {
		OrderOfItems orderOfItems = new OrderOfItems();
		orderOfItems.setPrice(orderOfItems.getPrice());
		orderOfItems.setQuantity(orderOfItems.getQuantity());
		orderOfItems.setProd_code(orderOfItems.getProd_code());
		return orderOfItems;
	}

}
