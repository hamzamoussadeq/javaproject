package com.retail.product.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull(message = "Name should not be empty")
	private String name;
	private String description;
	@NotBlank(message = "Category must be defined")
	@Size(min = 1, max = 255, message = "fullName must be 1-70 characters long")
	private String category;
	@NotNull(message = "Price should not be null")
	private BigDecimal price;
	@NotBlank(message = "Image link should be added")
	private String image;
	
	public Product() {
	}
	
	public Product(Long id, String name, String description,String category, BigDecimal price, String image) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.category=category;
		this.price = price;
		this.setImage(image);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + "]";
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	

}
