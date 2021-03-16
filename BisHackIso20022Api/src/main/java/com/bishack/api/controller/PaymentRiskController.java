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
import com.bishack.api.service.IRiskCalcEngine;
import com.bishack.api.service.RiskCalcEngine;
import com.bishack.config.AppProperties;

@Controller
public class PaymentRiskController {
	@Autowired
	private AppProperties appProperties;

	@PostMapping(path = "/paymentRisk", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<PayRiskCalcResDto> calcPaymentRisk(@RequestBody PayRiskCalcReqDto reqDto) {
		PayRiskCalcResDto resDto = null;
		try {
			// Only accept these two hard-coded source accounts for demo.
			if (!"500105170123456789".equals(reqDto.getCreditorAccount())
					&& !"100000010123123123".equals(reqDto.getCreditorAccount())) {
				return new ResponseEntity<PayRiskCalcResDto>(resDto, HttpStatus.BAD_REQUEST);
			}

			IRiskCalcEngine riskEngine = new RiskCalcEngine();
			resDto = riskEngine.executeRiskAnalysis(reqDto);

			return new ResponseEntity<PayRiskCalcResDto>(resDto, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<PayRiskCalcResDto>(resDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
}
