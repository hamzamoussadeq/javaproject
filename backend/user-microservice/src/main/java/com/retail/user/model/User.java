package com.retail.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer id;
	
	@NotBlank(message = "User name should not be empty")
	@Size(min = 1, max = 255, message = "Name must be 1-255 characters long")
	@Pattern(regexp = "^[a-zA-Z]+$", message = "Username must contain only letters")
	public String username;
	
//	@NotBlank(message = "password should not be empty")
//	public String password;
	
	
    @NotNull(message = "Password is required")
    @Size(min = 1, message = "Password cannot be empty")
    private String password;
	
	@NotNull(message = "User address should not be null")
	@Pattern(regexp = "^[a-zA-Z]+$", message = "Address should be only letters")
	public String address;
	
	@Size(min = 10, max = 10, message = "Mobile no. must be 10 digits")
    @Column(unique = true, length = 10)
	public String phoneNo;

	public User() {
	}

	public User(Integer id, String username, String password, String address, String phoneNo) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.address = address;
		this.phoneNo = phoneNo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

}
