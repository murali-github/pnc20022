package com.bishack.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bishack.api.dto.PayRiskCalcReqDto;
import com.bishack.api.dto.PayRiskCalcResDto;
import com.bishack.config.AppProperties;

@Controller
public class PaymentRiskController {
	@Autowired
	private AppProperties appProperties;

	@PostMapping(path = "/paymentRisk", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<PayRiskCalcResDto> calcPaymentRisk(@RequestBody PayRiskCalcReqDto reqDto) {
		// TODO make calls to pre-validation APIs here and check if inputs are correct.
		PayRiskCalcResDto resDto = new PayRiskCalcResDto();
		resDto.setRiskFactor("HIGH");
		return new ResponseEntity<PayRiskCalcResDto>(resDto, HttpStatus.OK);
	}
}
