package com.retail.order.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
@Entity
@Table(name="t_order")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String orderNo;
	@OneToMany(cascade = CascadeType.ALL)
	private List<OrderOfItems> orderOfItems;
	
	public Order() {
	}

	public Order(Long id, String orderNo, List<OrderOfItems> orderOfItems) {
		super();
		this.id = id;
		this.orderNo = orderNo;
		this.orderOfItems = orderOfItems;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public List<OrderOfItems> getOrderOfItems() {
		return orderOfItems;
	}

}
