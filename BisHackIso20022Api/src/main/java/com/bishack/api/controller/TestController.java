package com.bishack.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bishack.api.entity.Customer;
import com.bishack.api.service.IPersistenceService;
import com.bishack.config.AppProperties;

@Controller
public class TestController {

	@Autowired
	private AppProperties appProperties;

	@Autowired
	private IPersistenceService persistenceService;
	  
    @GetMapping(path="/test")
 	public ResponseEntity<String> test() {     	
 		return new ResponseEntity<String>("Test Success", HttpStatus.OK);
 	}
    
    @GetMapping(path="/getCustomers")
 	public ResponseEntity<List<Customer>> getCustomers() {   	
 		return new ResponseEntity<>(persistenceService.getAllCustomers(), HttpStatus.OK);
 	}
 	
   
    @PostMapping(path="/saveCustomer", headers={"Accept=application/json", "Content-Type=application/json"})
	public ResponseEntity<String> saveCustomer(@RequestBody  Customer customer) {   	
 		return new ResponseEntity<>(persistenceService.saveCustomer(customer), HttpStatus.OK);
 	}
}
