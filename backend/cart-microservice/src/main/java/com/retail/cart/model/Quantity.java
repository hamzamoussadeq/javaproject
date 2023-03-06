package com.retail.cart.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Quantity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long quantityId;
	@OneToOne(orphanRemoval = true,cascade=CascadeType.MERGE)
	private Product product;
	
	private Long quantity;
	
	public Long getQuantityId() {
		return quantityId;
	}
	public void setQuantityId(Long quantityId) {
		this.quantityId = quantityId;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	
}
