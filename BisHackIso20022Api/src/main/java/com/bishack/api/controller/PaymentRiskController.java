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

import com.bishack.api.dto.PaymentRiskReqDto;
import com.bishack.api.dto.PaymentRiskResDto;
import com.bishack.api.dto.SwiftPrevalAcFormatDto;
import com.bishack.api.dto.SwiftPrevalAcVerifyDto;
import com.bishack.api.entity.TrxRecord;
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
	public ResponseEntity<PaymentRiskResDto> calcPaymentRisk(@RequestBody PaymentRiskReqDto reqDto) {
		PaymentRiskResDto resDto = null;
		try {
			// TODO Only accept these two hard-coded source accounts for demo.
			if (!"500105170123456789".equals(reqDto.getCreditorAccount())
					&& !"100000010123123123".equals(reqDto.getCreditorAccount())) {
				return new ResponseEntity<PaymentRiskResDto>(resDto, HttpStatus.BAD_REQUEST);
			}

			TrxRecord record = translateToTrxRecord(reqDto);

			// TODO add prevalidation result stuff to record
			prevalidateAccountFormat(record);
			prevalidateAccount(record);

			TrxRecord savedRecord = persistenceService.saveRecord(record);

			// TODO populate a TrxRatingModelDto and engage RiskEngine to get response.
			resDto = new PaymentRiskResDto();
			resDto.setRiskFactor("HIGH");
			return new ResponseEntity<PaymentRiskResDto>(resDto, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<PaymentRiskResDto>(resDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	private TrxRecord translateToTrxRecord(PaymentRiskReqDto req) {
		TrxRecord record = new TrxRecord();
		record.setCreditorName(req.getCreditorName());
		record.setCreditorAccount(req.getCreditorAccount());
		record.setInstitutionName(req.getInstitutionName());
		record.setUuid(UUID.randomUUID().toString());
		record.setAmount(req.getAmount());

		// TODO hardcoded for demo.
		if ("500105170123456789".equals(req.getCreditorAccount())) {
			record.setIban("DE41500105170123456789");
			record.setCountryCode("DE");
			record.setBankId("50010517");
			record.setBankIdCode("INGDDEFFXXX");
		} else if ("100000010123123123".equals(req.getCreditorAccount())) {
			record.setIban("DE39100000010123123123");
			record.setCountryCode("DE");
			record.setBankId("10000001");
			record.setBankIdCode("BLKFDE33");
		}
		return record;
	}

	private String prevalidateAccountFormat(TrxRecord record) throws Exception {
		SwiftPrevalAcFormatDto prevalAccountFormatDto = new SwiftPrevalAcFormatDto();
		prevalAccountFormatDto.setAccount_identification(record.getIban());
		prevalAccountFormatDto.setCountry_code(record.getCountryCode());
		prevalAccountFormatDto.setFinancial_institution_identification(record.getInstitutionId());
		return swiftService.swiftPrevalAcFormat(prevalAccountFormatDto);
	}

	private String prevalidateAccount(TrxRecord record) throws Exception {
		SwiftPrevalAcVerifyDto dto = new SwiftPrevalAcVerifyDto();
		dto.setCreditorName(record.getCreditorName());
		// Request is in the scope of the payment initiation
		dto.setContext("PAYM");
		dto.setCreditorAccount(record.getCreditorAccount());
		dto.setCreditorName(record.getCreditorName());
		return swiftService.swiftPrevalAcVerify(dto, record.getBankIdCode());
	}
}
