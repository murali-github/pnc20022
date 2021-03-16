package com.bishack.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bishack.api.dto.PayRiskCalcReqDto;
import com.bishack.api.dto.TrxRatingModelRequestDto;

@Service
public class InternalComplianceDataAgg implements IRiskEngineDataAgg {

	@Override
	public List<TrxRatingModelRequestDto> getModelInputData(PayRiskCalcReqDto payRiskCalcReqDto) {
		List<TrxRatingModelRequestDto> trxRatingModelRequestDtos = new ArrayList<>();
		
		// Call Swift Prevalidation and based on the response return the attributes 
		//{"category":"INTERNAL_COMPLIANCE","attrName":"HIGH_RISK_BENE_CNTRY","value":"AZ, AY, AX"}
		
		return trxRatingModelRequestDtos;
	}

}
