package com.bishack.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bishack.api.dto.PayRiskCalcReqDto;
import com.bishack.api.dto.TrxRatingModelRequestDto;

@Service
public class SwiftValidationDataAgg implements IRiskEngineDataAgg {

	@Override
	public List<TrxRatingModelRequestDto> getModelInputData(PayRiskCalcReqDto payRiskCalcReqDto) {
		List<TrxRatingModelRequestDto> trxRatingModelRequestDtos = null;
		
		// Call Swift Prevalidation and based on the response return the attributes 
		//{"category":"SWIFT_VALIDATION","attrName":"AC_FORMAT_VALIDATION","value":"LOW"},{"category":"SWIFT_VALIDATION","attrName":"AC_VERIFICATION","value":"LOW"}
		
		return trxRatingModelRequestDtos;
	}

}
