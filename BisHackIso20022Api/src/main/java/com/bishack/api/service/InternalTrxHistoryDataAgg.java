package com.bishack.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bishack.api.dto.PayRiskCalcReqDto;
import com.bishack.api.dto.TrxRatingModelRequestDto;

@Service
public class InternalTrxHistoryDataAgg implements IRiskEngineDataAgg {

	@Override
	public List<TrxRatingModelRequestDto> getModelInputData(PayRiskCalcReqDto payRiskCalcReqDto) {
		List<TrxRatingModelRequestDto> trxRatingModelRequestDtos = null;
		
		// Call Swift Prevalidation and based on the response return the attributes 
		//{"category":"INTERNAL_TRX_HIST","attrName":"SRC_AVG_TRX_AMOUNT","value":"200.23"},{"category":"INTERNAL_TRX_HIST","attrName":"SRC_TOTAL_TRX_AMOUNT","value":"20000"}
		
		return trxRatingModelRequestDtos;
	}

}
