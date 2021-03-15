package com.bishack.api.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bishack.api.entity.Customer;
import com.bishack.api.repository.CustomerRepository;

@Service
public class PersistenceService implements IPersistenceService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public List<Customer> getAllCustomers() {		
		return customerRepository.findAll();
	}
	
	@Override
	@Transactional
	public String saveCustomer(Customer customer) {		
		customerRepository.save(customer);
		return "success";
	}

}
