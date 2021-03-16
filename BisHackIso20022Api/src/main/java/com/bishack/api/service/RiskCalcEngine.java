package com.bishack.api.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bishack.api.dto.PayRiskCalcReqDto;
import com.bishack.api.dto.PayRiskCalcResDto;
import com.bishack.api.dto.TrxRatingModelRequestDto;

@Service(value = "riskCalcEngine")
public class RiskCalcEngine implements IRiskCalcEngine {
    @Autowired
    private List<IRiskEngineDataAgg> riskEngineDataAggs;

    @Override
    public PayRiskCalcResDto executeRiskAnalysis(PayRiskCalcReqDto payRiskCalcReqDto) {
        PayRiskCalcResDto payRiskCalcResDto = null;

        List<TrxRatingModelRequestDto> trxRatingModelRequestDtos = new ArrayList<TrxRatingModelRequestDto>();
        if (riskEngineDataAggs != null) {
            for (IRiskEngineDataAgg riskEngineDataAgg : riskEngineDataAggs) {
                List<TrxRatingModelRequestDto> trxRatingModelRequests = riskEngineDataAgg
                        .getModelInputData(payRiskCalcReqDto);
                trxRatingModelRequestDtos.addAll(trxRatingModelRequests);
            }

            if (CollectionUtils.isNotEmpty(trxRatingModelRequestDtos)) {

                // Make a call to Andrews' Risk Engine and get the reponse and convert that into
                // payRiskCalcReqDto
            }
        }

        return payRiskCalcResDto;
    }

}
