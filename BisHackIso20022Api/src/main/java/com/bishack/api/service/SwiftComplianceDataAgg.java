package com.bishack.api.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.bishack.api.dto.PayRiskCalcReqDto;
import com.bishack.api.dto.TrxRatingModelRequestDto;

@Service
public class SwiftComplianceDataAgg implements IRiskEngineDataAgg {

	@Override
	public List<TrxRatingModelRequestDto> getModelInputData(PayRiskCalcReqDto payRiskCalcReqDto) {
		List<TrxRatingModelRequestDto> trxRatingModelRequestDtos = new ArrayList<TrxRatingModelRequestDto>();
		TrxRatingModelRequestDto trxRatingModelRequestDto = null;
		
		if (payRiskCalcReqDto != null) {
			if (StringUtils.isNotBlank(payRiskCalcReqDto.getCreditorAccount())) {
				trxRatingModelRequestDto = new TrxRatingModelRequestDto();
				trxRatingModelRequestDtos.add(trxRatingModelRequestDto);
				trxRatingModelRequestDto.setAttrName(IServiceConstants.ATTR_BENE_AC_VERIFICATION);
				trxRatingModelRequestDto.setCategory(IServiceConstants.CAT_SWIFT_COMPLIANCE);
				if (CollectionUtils.containsAny(IServiceConstants.BBAN_AC_VERIFY_LOW, Arrays.asList(payRiskCalcReqDto.getCreditorAccount()))) {
					trxRatingModelRequestDto.setValue(IServiceConstants.RATING_LEVEL_LOW);
				} else if (CollectionUtils.containsAny(IServiceConstants.BBAN_AC_VERIFY_MEDIUM, Arrays.asList(payRiskCalcReqDto.getCreditorAccount()))) {
					trxRatingModelRequestDto.setValue(IServiceConstants.RATING_LEVEL_MEDIUM);
				} else if (CollectionUtils.containsAny(IServiceConstants.BBAN_AC_VERIFY_HIGH, Arrays.asList(payRiskCalcReqDto.getCreditorAccount()))) {
					trxRatingModelRequestDto.setValue(IServiceConstants.RATING_LEVEL_HIGH);
				} else {
					trxRatingModelRequestDto.setValue(IServiceConstants.RATING_LEVEL_LOW);
				}
				
			}
			if (StringUtils.isNotBlank(payRiskCalcReqDto.getDebitorAccount())) {
				trxRatingModelRequestDto = new TrxRatingModelRequestDto();
				trxRatingModelRequestDtos.add(trxRatingModelRequestDto);
				trxRatingModelRequestDto.setAttrName(IServiceConstants.ATTR_SRC_AC_VERIFICATION);
				trxRatingModelRequestDto.setCategory(IServiceConstants.CAT_SWIFT_COMPLIANCE);
				if (CollectionUtils.containsAny(IServiceConstants.BBAN_AC_VERIFY_LOW, Arrays.asList(payRiskCalcReqDto.getDebitorAccount()))) {
					trxRatingModelRequestDto.setValue(IServiceConstants.RATING_LEVEL_LOW);
				} else if (CollectionUtils.containsAny(IServiceConstants.BBAN_AC_VERIFY_MEDIUM, Arrays.asList(payRiskCalcReqDto.getDebitorAccount()))) {
					trxRatingModelRequestDto.setValue(IServiceConstants.RATING_LEVEL_MEDIUM);
				} else if (CollectionUtils.containsAny(IServiceConstants.BBAN_AC_VERIFY_HIGH, Arrays.asList(payRiskCalcReqDto.getDebitorAccount()))) {
					trxRatingModelRequestDto.setValue(IServiceConstants.RATING_LEVEL_HIGH);
				} else {
					trxRatingModelRequestDto.setValue(IServiceConstants.RATING_LEVEL_LOW);
				}
				
			}
		}
		
		return trxRatingModelRequestDtos;
	}

}
