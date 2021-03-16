package com.bishack.api.service;

import com.bishack.api.dto.PayRiskCalcReqDto;
import com.bishack.api.dto.PayRiskCalcResDto;


public interface IRiskCalcEngine {
	PayRiskCalcResDto executeRiskAnalysis(PayRiskCalcReqDto payRiskCalcReqDto);
}
