package com.retail.order.service;

import java.util.List;

public class OrderRequest {
	
	private List<OrderItems> orderItemsList;

	public List<OrderItems> getOrderItemsList() {
		return orderItemsList;
	}

	public void setOrderItemsList(List<OrderItems> orderItemsList) {
		this.orderItemsList = orderItemsList;
	}
	
	

}
