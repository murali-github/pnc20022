package com.bishack.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bishack.api.dto.PayRiskCalcReqDto;
import com.bishack.api.dto.TrxRatingModelRequestDto;
import com.bishack.api.dto.swift.prevalidation.account.VerifyAccountReqDto;
import com.bishack.api.dto.swift.prevalidation.account.VerifyAccountRespDto;
import com.bishack.api.dto.swift.prevalidation.accountfmt.VerifyAccountFmtReqDto;
import com.bishack.api.entity.TrxRecord;

@Service
public class SwiftValidationDataAgg implements IRiskEngineDataAgg {
    private static Logger LOG = LoggerFactory.getLogger(SwiftValidationDataAgg.class);

    @Autowired
    private SwiftApiService swiftApiService;

    @Override
    public List<TrxRatingModelRequestDto> getModelInputData(PayRiskCalcReqDto payRiskCalcReqDto) {
        List<TrxRatingModelRequestDto> trxRatingModelRequestDtos = new ArrayList<>();

        TrxRecord record = translateToTrxRecord(payRiskCalcReqDto);
        // TODO capture return value here
        try {
            prevalidateAccountFormat(record);
            VerifyAccountRespDto verifyAccountResponse = prevalidateAccount(record);
        } catch (Exception e) {
            LOG.error("Encountered exception: {}", e);
        }

        // Call Swift Prevalidation and based on the response return the attributes
        // {"category":"SWIFT_VALIDATION","attrName":"AC_FORMAT_VALIDATION","value":"LOW"},{"category":"SWIFT_VALIDATION","attrName":"AC_VERIFICATION","value":"LOW"}

        return trxRatingModelRequestDtos;
    }

    private TrxRecord translateToTrxRecord(PayRiskCalcReqDto req) {
        TrxRecord record = new TrxRecord();
        record.setCreditorName(req.getCreditorName());
        record.setCreditorAccount(req.getCreditorAccount());
        record.setInstitutionName(req.getInstitutionName());
        record.setUuid(UUID.randomUUID().toString());
        record.setAmount(req.getAmount());

        // TODO hardcoded for demo.
        if ("500105170123456789".equals(req.getCreditorAccount())) {
            record.setIban("DE41500105170123456789");
            record.setCountryCode("DE");
            record.setBankId("50010517");
            record.setBankIdCode("INGDDEFFXXX");
        } else if ("100000010123123123".equals(req.getCreditorAccount())) {
            record.setIban("DE39100000010123123123");
            record.setCountryCode("DE");
            record.setBankId("10000001");
            record.setBankIdCode("BLKFDE33");
        }
        return record;
    }

    private String prevalidateAccountFormat(TrxRecord record) throws Exception {
        VerifyAccountFmtReqDto prevalAccountFormatDto = new VerifyAccountFmtReqDto();
        prevalAccountFormatDto.setAccount_identification(record.getIban());
        prevalAccountFormatDto.setCountry_code(record.getCountryCode());
        prevalAccountFormatDto.setFinancial_institution_identification(record.getInstitutionId());
        return swiftApiService.swiftPrevalAcFormat(prevalAccountFormatDto);
    }

    private VerifyAccountRespDto prevalidateAccount(TrxRecord record) throws Exception {
        VerifyAccountReqDto dto = new VerifyAccountReqDto();
        dto.setCreditorName(record.getCreditorName());
        // Request is in the scope of the payment initiation
        dto.setContext("BENR");
        dto.setCreditorAccount(record.getCreditorAccount());
        dto.setCreditorName(record.getCreditorName());
        dto.setCorrelationIdentifier("SCENARIO1-CORRID-001");
        return swiftApiService.swiftPrevalAcVerify(dto, "916a97d-a699-4f20-b8c2-2b07e2684a27");
    }

}
