package com.bishack.api.controller;

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
import com.bishack.api.entity.TxRecord;
import com.bishack.api.service.IPersistenceService;
import com.bishack.api.service.SwiftApiService;
import com.bishack.config.AppProperties;

@Controller
public class PaymentRiskController {
	@Autowired
	private AppProperties appProperties;

	@Autowired
	private SwiftApiService swiftService;

	@Autowired
	private IPersistenceService persistenceService;

	@PostMapping(path = "/paymentRisk", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<PayRiskCalcResDto> calcPaymentRisk(@RequestBody PayRiskCalcReqDto reqDto) {
		PayRiskCalcResDto resDto = null;
		try {
			// Only accept this hard-coded source account
			if (reqDto.getCreditorAccount() != "123110040000109876543210") {
				return new ResponseEntity<PayRiskCalcResDto>(resDto, HttpStatus.BAD_REQUEST);
			}

			TxRecord record = new TxRecord();
			record.setCreditorName(reqDto.getCreditorName());
			record.setCreditorAccount(reqDto.getCreditorAccount());
			record.setInstitutionName(reqDto.getInstitutionName());
			record.setUuid(UUID.randomUUID().toString());
			record.setAmount(reqDto.getAmount());
			// TODO add prevalidation result stuff to record
			prevalidateAccountFormat(record);

			TxRecord savedRecord = persistenceService.saveRecord(record);

			// TODO this should come from RiskEngine later when it's implemented
			resDto = new PayRiskCalcResDto();
			resDto.setRiskFactor("HIGH");
			return new ResponseEntity<PayRiskCalcResDto>(resDto, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<PayRiskCalcResDto>(resDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	private String prevalidateAccountFormat(TxRecord record) throws Exception {
		SwiftPrevalAcFormatDto prevalAccountFormatDto = new SwiftPrevalAcFormatDto();
		prevalAccountFormatDto.setAccount_identification(record.getCreditorAccount());
		prevalAccountFormatDto.setCountry_code(record.getCountryCode());
		prevalAccountFormatDto.setFinancial_institution_identification(record.getInstitutionId());
		return swiftService.swiftPrevalAcFormat(prevalAccountFormatDto);
	}
}
