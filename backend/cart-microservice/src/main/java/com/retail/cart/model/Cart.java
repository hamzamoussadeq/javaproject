package com.retail.cart.model;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "t_cart")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@OneToOne(orphanRemoval = true,cascade=CascadeType.MERGE)
	private User user;
	@OneToMany(orphanRemoval = true,cascade=CascadeType.ALL)
	private List<Quantity> quantity;

	public Cart(Long id, User user, List<Quantity> quantity) {
		super();
		this.id = id;
		this.user = user;
		this.quantity = quantity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Quantity> getQuantity() {
		return quantity;
	}

	public void setQuantity(List<Quantity> quantity) {
		this.quantity = quantity;
	}

	public Cart() {
	}

}
