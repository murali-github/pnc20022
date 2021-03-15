package com.bishack.api.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bishack.api.entity.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String> { 
	List<Customer> findByName(String name);

}