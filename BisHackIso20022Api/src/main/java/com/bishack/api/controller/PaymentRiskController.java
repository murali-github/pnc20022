package com.bishack.api.controller;

import java.util.List;
import java.util.UUID;

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
import com.bishack.api.dto.SwiftPrevalAcFormatDto;
import com.bishack.api.dto.SwiftPrevalAcVerifyDto;
import com.bishack.api.dto.TrxRatingModelDto;
import com.bishack.api.dto.TrxRatingModelRequestDto;
import com.bishack.api.entity.TrxRecord;
import com.bishack.api.service.IPersistenceService;
import com.bishack.api.service.SwiftApiService;
import com.bishack.api.service.SwiftValidationDataAgg;
import com.bishack.config.AppProperties;

@Controller
public class PaymentRiskController {
	@Autowired
	private AppProperties appProperties;
	
	@Autowired
	private SwiftValidationDataAgg swiftValidation;

	@PostMapping(path = "/paymentRisk", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<PayRiskCalcResDto> calcPaymentRisk(@RequestBody PayRiskCalcReqDto reqDto) {
		PayRiskCalcResDto resDto = null;
		try {
			// TODO Only accept these two hard-coded source accounts for demo.
			if (!"500105170123456789".equals(reqDto.getCreditorAccount())
					&& !"100000010123123123".equals(reqDto.getCreditorAccount())) {
				return new ResponseEntity<PayRiskCalcResDto>(resDto, HttpStatus.BAD_REQUEST);
			}

			List<TrxRatingModelRequestDto> ratings = swiftValidation.getModelInputData(reqDto);

			// TODO populate a TrxRatingModelDto and engage RiskEngine to get response.
			resDto = new PayRiskCalcResDto();
			resDto.setRiskFactor("HIGH");
			return new ResponseEntity<PayRiskCalcResDto>(resDto, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<PayRiskCalcResDto>(resDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
}
