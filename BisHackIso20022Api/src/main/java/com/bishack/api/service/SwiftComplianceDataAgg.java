package com.bishack.api.service;

import java.util.List;

import com.bishack.api.dto.PayRiskCalcReqDto;
import com.bishack.api.dto.TrxRatingModelRequestDto;

public class SwiftComplianceDataAgg implements IRiskEngineDataAgg {

	@Override
	public List<TrxRatingModelRequestDto> getModelInputData(PayRiskCalcReqDto payRiskCalcReqDto) {
		List<TrxRatingModelRequestDto> trxRatingModelRequestDtos = null;
		
		// Call Swift Prevalidation and based on the response return the attributes 
		//{"category":"SWIFT_COMPLIANCE","attrName":"SRC_INST_RISK","value":"LOW"},{"category":"SWIFT_COMPLIANCE","attrName":"BENFICIARY_INST_RISK","value":"LOW"}
		
		return trxRatingModelRequestDtos;
	}

}
