package com.bishack.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bishack.api.dto.PayRiskCalcReqDto;
import com.bishack.api.dto.SwiftPrevalAcFormatDto;
import com.bishack.api.dto.SwiftPrevalAcVerifyDto;
import com.bishack.api.dto.TrxRatingModelRequestDto;
import com.bishack.api.entity.TrxRecord;

@Service
public class SwiftValidationDataAgg implements IRiskEngineDataAgg {
	@Autowired
	private SwiftApiService swiftApiService;

	@Override
	public List<TrxRatingModelRequestDto> getModelInputData(PayRiskCalcReqDto payRiskCalcReqDto) {
		List<TrxRatingModelRequestDto> trxRatingModelRequestDtos = new ArrayList<>();
		
		TrxRecord record = translateToTrxRecord(payRiskCalcReqDto);
		// TODO capture return value here
		try {
			prevalidateAccountFormat(record);
			prevalidateAccount(record);
		} catch (Exception e) {
			// TODO how to deal with this?
		}
		
		// Call Swift Prevalidation and based on the response return the attributes 
		//{"category":"SWIFT_VALIDATION","attrName":"AC_FORMAT_VALIDATION","value":"LOW"},{"category":"SWIFT_VALIDATION","attrName":"AC_VERIFICATION","value":"LOW"}
		
		return trxRatingModelRequestDtos;
	}
	
	private TrxRecord translateToTrxRecord(PayRiskCalcReqDto req) {
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
		return swiftApiService.swiftPrevalAcFormat(prevalAccountFormatDto);
	}

	private String prevalidateAccount(TrxRecord record) throws Exception {
		SwiftPrevalAcVerifyDto dto = new SwiftPrevalAcVerifyDto();
		dto.setCreditorName(record.getCreditorName());
		// Request is in the scope of the payment initiation
		dto.setContext("PAYM");
		dto.setCreditorAccount(record.getCreditorAccount());
		dto.setCreditorName(record.getCreditorName());
		return swiftApiService.swiftPrevalAcVerify(dto, record.getBankIdCode());
	}

}
