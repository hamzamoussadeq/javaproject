package com.retail.cart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retail.cart.repository.QuantityRepository;

@Service
public class QuantityService {
	
	@Autowired
	private QuantityRepository quantityRepository;

}
