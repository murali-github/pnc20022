package com.bishack.api.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.bishack.api.dto.PayRiskCalcReqDto;
import com.bishack.api.dto.TrxRatingModelRequestDto;
import com.bishack.api.service.IServiceConstants.DataAggEnum;

@Service
public class InternalComplianceDataAgg implements IRiskEngineDataAgg {

	@Override
	public List<TrxRatingModelRequestDto> getModelInputData(PayRiskCalcReqDto payRiskCalcReqDto) {
		List<TrxRatingModelRequestDto> trxRatingModelRequestDtos = new ArrayList<>();

		if (payRiskCalcReqDto != null) {
			if (StringUtils.isNotBlank(payRiskCalcReqDto.getDebitorAccount())) {

				TrxRatingModelRequestDto trxRatingModelRequestDto = new TrxRatingModelRequestDto();
				trxRatingModelRequestDtos.add(trxRatingModelRequestDto);
				trxRatingModelRequestDto.setAttrName(IServiceConstants.ATTR_HIGH_RISK_BENE_CNTRY);
				trxRatingModelRequestDto.setCategory(IServiceConstants.CAT_INTERNAL_COMPLIANCE);
				trxRatingModelRequestDto.setValue(DataAggEnum.getHighRiskBeneCntry(payRiskCalcReqDto.getCreditorAccount()));
			}
		}

		return trxRatingModelRequestDtos;
	}

}
