package com.bishack.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bishack.api.dto.PayRiskCalcReqDto;
import com.bishack.api.dto.TrxRatingModelRequestDto;

@Service
public class SwiftComplianceDataAgg implements IRiskEngineDataAgg {

	@Override
	public List<TrxRatingModelRequestDto> getModelInputData(PayRiskCalcReqDto payRiskCalcReqDto) {
		List<TrxRatingModelRequestDto> trxRatingModelRequestDtos = new ArrayList<>();
		
		// Call Swift Prevalidation and based on the response return the attributes 
		//{"category":"SWIFT_COMPLIANCE","attrName":"SRC_INST_RISK","value":"LOW"},{"category":"SWIFT_COMPLIANCE","attrName":"BENFICIARY_INST_RISK","value":"LOW"}
		
		return trxRatingModelRequestDtos;
	}

}
