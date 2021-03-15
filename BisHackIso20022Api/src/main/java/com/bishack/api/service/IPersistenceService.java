package com.bishack.api.service;

import java.util.List;

import com.bishack.api.entity.Customer;

public interface IPersistenceService {
	
	List<Customer> getAllCustomers();
	
	String saveCustomer(Customer customer);
}
