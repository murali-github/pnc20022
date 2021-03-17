package com.bishack.api.controller;

import java.util.Arrays;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bishack.api.dto.PayRiskCalcReqDto;
import com.bishack.api.dto.PayRiskCalcResDto;
import com.bishack.api.service.IRiskCalcEngine;
import com.bishack.api.service.IServiceConstants;

@Controller
public class PaymentRiskController {
    private static Logger LOG = LoggerFactory.getLogger(PaymentRiskController.class);
    
    @Autowired
    private IRiskCalcEngine riskCalcEngine;

    @PostMapping(path = "/paymentRisk", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<PayRiskCalcResDto> calcPaymentRisk(@RequestBody PayRiskCalcReqDto reqDto) {
        PayRiskCalcResDto resDto = null;
        try {
            // Only accept these two hard-coded source accounts for demo.
            if (!CollectionUtils.containsAny(IServiceConstants.VALID_AC_NUMBERS, Arrays.asList(reqDto.getDebitorAccount())) || 
            		!CollectionUtils.containsAny(IServiceConstants.VALID_AC_NUMBERS, Arrays.asList(reqDto.getCreditorAccount())) ) {
                return new ResponseEntity<PayRiskCalcResDto>(resDto, HttpStatus.BAD_REQUEST);
            }

            resDto = riskCalcEngine.executeRiskAnalysis(reqDto);

            return new ResponseEntity<PayRiskCalcResDto>(resDto, HttpStatus.OK);
        } catch (Exception e) {
            LOG.error("Encountered exception: {}", e);
            return new ResponseEntity<PayRiskCalcResDto>(resDto, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
