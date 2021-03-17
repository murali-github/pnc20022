package com.bishack.api.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.bishack.api.dto.PayRiskCalcReqDto;
import com.bishack.api.dto.TrxRatingModelRequestDto;
import com.bishack.api.service.IServiceConstants.DataAggEnum;

@Service
public class InternalTrxHistoryDataAgg implements IRiskEngineDataAgg {

	@Override
	public List<TrxRatingModelRequestDto> getModelInputData(PayRiskCalcReqDto payRiskCalcReqDto) {

		List<TrxRatingModelRequestDto> trxRatingModelRequestDtos = new ArrayList<TrxRatingModelRequestDto>();
		TrxRatingModelRequestDto trxRatingModelRequestDto = null;
		
		if (payRiskCalcReqDto != null) {
			if (StringUtils.isNotBlank(payRiskCalcReqDto.getCreditorAccount())) {
				trxRatingModelRequestDto = new TrxRatingModelRequestDto();
				trxRatingModelRequestDtos.add(trxRatingModelRequestDto);
				trxRatingModelRequestDto.setAttrName(IServiceConstants.ATTR_SRC_AVG_TRX_AMOUNT);
				trxRatingModelRequestDto.setCategory(IServiceConstants.CAT_INTERNAL_TRX_HIST);
				trxRatingModelRequestDto.setValue(DataAggEnum.getAvgTrx(payRiskCalcReqDto.getCreditorAccount()));
				
			}
			if (StringUtils.isNotBlank(payRiskCalcReqDto.getDebitorAccount())) {
				trxRatingModelRequestDto = new TrxRatingModelRequestDto();
				trxRatingModelRequestDtos.add(trxRatingModelRequestDto);
				trxRatingModelRequestDto.setAttrName(IServiceConstants.ATTR_SRC_TOTAL_TRX_AMOUNT);
				trxRatingModelRequestDto.setCategory(IServiceConstants.CAT_INTERNAL_TRX_HIST);
				trxRatingModelRequestDto.setValue(DataAggEnum.getTotalTrx(payRiskCalcReqDto.getCreditorAccount()));
			}
		}
		
		return trxRatingModelRequestDtos;
	}

}
