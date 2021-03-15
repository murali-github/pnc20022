package com.bishack.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bishack.api.entity.Customer;
import com.bishack.api.service.IPersistenceService;
import com.bishack.config.AppProperties;

@Controller
public class PayRiskCalcController {

	@Autowired
	private AppProperties appProperties;

	@Autowired
	private IPersistenceService persistenceService;
	  
  
    @PostMapping(path="/calcPaymentRisk", headers={"Accept=application/json", "Content-Type=application/json"})
	public ResponseEntity<String> calcPaymentRisk(@RequestBody  Customer customer) {   	
 		return new ResponseEntity<>(persistenceService.saveCustomer(customer), HttpStatus.OK);
 	}
}
