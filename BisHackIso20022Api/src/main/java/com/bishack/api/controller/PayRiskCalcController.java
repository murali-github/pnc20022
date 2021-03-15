package com.bishack.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bishack.api.dto.PayRiskCalcReqDto;
import com.bishack.api.dto.PayRiskCalcResDto;
import com.bishack.api.entity.Customer;
import com.bishack.api.service.IPersistenceService;
import com.bishack.config.AppProperties;

@Controller
public class PayRiskCalcController {
	@Autowired
	private AppProperties appProperties;
  
    @PostMapping(path="/calcPaymentRisk", headers={"Accept=application/json", "Content-Type=application/json"})
	public ResponseEntity<PayRiskCalcResDto> calcPaymentRisk(@RequestBody PayRiskCalcReqDto reqDto) {
    	PayRiskCalcResDto resDto = new PayRiskCalcResDto();
    	resDto.setRiskFactor("HIGH");
 		return new ResponseEntity<PayRiskCalcResDto>(resDto, HttpStatus.OK);
 	}
}
