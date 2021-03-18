package com.bishack.api.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.bishack.api.dto.PayRiskCalcReqDto;
import com.bishack.api.dto.TrxRatingModelRequestDto;

@Service
public class CurrentTrxDataAgg implements IRiskEngineDataAgg {

	@Override
	public List<TrxRatingModelRequestDto> getModelInputData(PayRiskCalcReqDto payRiskCalcReqDto) {

		List<TrxRatingModelRequestDto> trxRatingModelRequestDtos = new ArrayList<TrxRatingModelRequestDto>();
		TrxRatingModelRequestDto trxRatingModelRequestDto = null;
		
		if (payRiskCalcReqDto != null) {
			if (StringUtils.isNotBlank(payRiskCalcReqDto.getCreditorAccount())) {
				trxRatingModelRequestDto = new TrxRatingModelRequestDto();
				trxRatingModelRequestDtos.add(trxRatingModelRequestDto);
				trxRatingModelRequestDto.setAttrName(IServiceConstants.ATTR_BENEFICIARY_AC);
				trxRatingModelRequestDto.setCategory(IServiceConstants.CAT_CURRENT_TRX);
				trxRatingModelRequestDto.setValue(payRiskCalcReqDto.getCreditorAccount());
				
			}
			if (StringUtils.isNotBlank(payRiskCalcReqDto.getDebitorAccount())) {
				trxRatingModelRequestDto = new TrxRatingModelRequestDto();
				trxRatingModelRequestDtos.add(trxRatingModelRequestDto);
				trxRatingModelRequestDto.setAttrName(IServiceConstants.ATTR_SRC_AC);
				trxRatingModelRequestDto.setCategory(IServiceConstants.CAT_CURRENT_TRX);
				trxRatingModelRequestDto.setValue(payRiskCalcReqDto.getDebitorAccount());
			}
			if (StringUtils.isNotBlank(payRiskCalcReqDto.getAmount())) {
				trxRatingModelRequestDto = new TrxRatingModelRequestDto();
				trxRatingModelRequestDtos.add(trxRatingModelRequestDto);
				trxRatingModelRequestDto.setAttrName(IServiceConstants.ATTR_AMOUNT);
				trxRatingModelRequestDto.setCategory(IServiceConstants.CAT_CURRENT_TRX);
				trxRatingModelRequestDto.setValue(payRiskCalcReqDto.getAmount());
			}
		}
		
		return trxRatingModelRequestDtos;
	}

}
