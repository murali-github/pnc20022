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
import com.bishack.api.dto.swift.prevalidation.accountfmt.VerifyAccountFmtRespDto;
import com.bishack.api.entity.TrxRecord;

@Service
public class SwiftValidationDataAgg implements IRiskEngineDataAgg {
    private static Logger LOG = LoggerFactory.getLogger(SwiftValidationDataAgg.class);

    @Autowired
    private SwiftApiService swiftApiService;

    @Override
    public List<TrxRatingModelRequestDto> getModelInputData(PayRiskCalcReqDto payRiskCalcReqDto) {
        TrxRecord record = translateToTrxRecord(payRiskCalcReqDto);

        VerifyAccountFmtRespDto verifyCreditorAccountFmtResponse = null;
        try {
            verifyCreditorAccountFmtResponse = prevalidateCreditorAccountFormat(record);
            LOG.debug("Creditor account format verification result: {}", verifyCreditorAccountFmtResponse);
        } catch (Exception e) {
            LOG.warn("Swift call encountered exception: {}", e);
            // For demo we don't want to bother with handling this. Rating model is somewhat
            // mocked so it won't cause issues.
        }

        VerifyAccountFmtRespDto verifyDebitorAccountFmtResponse = null;
        try {
            verifyCreditorAccountFmtResponse = prevalidateDebitorAccountFormat(record);
            LOG.debug("Debitor account format verification result: {}", verifyDebitorAccountFmtResponse);
        } catch (Exception e) {
            LOG.warn("Swift call encountered exception: {}", e);
            // For demo we don't want to bother with handling this. Rating model is somewhat
            // mocked so it won't cause issues.
        }

        VerifyAccountRespDto verifyCreditorAccountResponse = null;
        try {
            verifyCreditorAccountResponse = prevalidateCreditorAccount(record);
            LOG.debug("Creditor account verification result: {}", verifyCreditorAccountResponse);
        } catch (Exception e) {
            LOG.warn("Swift call encountered exception: {}", e);
            // For demo we don't want to bother with handling this. Rating model is somewhat
            // mocked so it won't cause issues.
        }

        List<TrxRatingModelRequestDto> trxRatingModelRequestDtos = translateToRatingModelRequest(payRiskCalcReqDto);
        return trxRatingModelRequestDtos;
    }

    private List<TrxRatingModelRequestDto> translateToRatingModelRequest(PayRiskCalcReqDto payRiskCalcReqDto) {
        List<TrxRatingModelRequestDto> trxRatingModelRequestDtos = new ArrayList<>();

        // Creditor account format validation
        TrxRatingModelRequestDto creditorAcctFormatRating = new TrxRatingModelRequestDto();
        creditorAcctFormatRating.setAttrName(IServiceConstants.ATTR_BENE_AC_FORMAT_VALIDATION);
        creditorAcctFormatRating.setCategory(IServiceConstants.CAT_SWIFT_VALIDATION);
        if (IServiceConstants.BBAN_AC_FORMAT_LOW.contains(payRiskCalcReqDto.getCreditorAccount())) {
            creditorAcctFormatRating.setValue(IServiceConstants.RATING_LEVEL_LOW);
        } else if (IServiceConstants.BBAN_AC_FORMAT_MEDIUM.contains(payRiskCalcReqDto.getCreditorAccount())) {
            creditorAcctFormatRating.setValue(IServiceConstants.RATING_LEVEL_LOW);
        } else {
            creditorAcctFormatRating.setValue(IServiceConstants.RATING_LEVEL_HIGH);
        }
        trxRatingModelRequestDtos.add(creditorAcctFormatRating);

        // Debitor account format validation
        TrxRatingModelRequestDto debitorAcctFormatRating = new TrxRatingModelRequestDto();
        debitorAcctFormatRating.setAttrName(IServiceConstants.ATTR_SRC_AC_FORMAT_VALIDATION);
        debitorAcctFormatRating.setCategory(IServiceConstants.CAT_SWIFT_VALIDATION);
        if (IServiceConstants.BBAN_AC_FORMAT_LOW.contains(payRiskCalcReqDto.getDebitorAccount())) {
            debitorAcctFormatRating.setValue(IServiceConstants.RATING_LEVEL_LOW);
        } else if (IServiceConstants.BBAN_AC_FORMAT_MEDIUM.contains(payRiskCalcReqDto.getDebitorAccount())) {
            debitorAcctFormatRating.setValue(IServiceConstants.RATING_LEVEL_LOW);
        } else {
            debitorAcctFormatRating.setValue(IServiceConstants.RATING_LEVEL_HIGH);
        }
        trxRatingModelRequestDtos.add(debitorAcctFormatRating);

       /* // Creditor account validation
        TrxRatingModelRequestDto creditorAcctRating = new TrxRatingModelRequestDto();
        creditorAcctRating.setAttrName(IServiceConstants.ATTR_BENE_AC_VERIFICATION);
        creditorAcctRating.setCategory(IServiceConstants.CAT_SWIFT_VALIDATION);
        if (IServiceConstants.BBAN_AC_VERIFY_LOW.contains(payRiskCalcReqDto.getCreditorAccount())) {
            creditorAcctRating.setValue(IServiceConstants.RATING_LEVEL_LOW);
        } else if (IServiceConstants.BBAN_AC_VERIFY_LOW.contains(payRiskCalcReqDto.getCreditorAccount())) {
            creditorAcctRating.setValue(IServiceConstants.RATING_LEVEL_LOW);
        } else {
            creditorAcctRating.setValue(IServiceConstants.RATING_LEVEL_HIGH);
        }
        trxRatingModelRequestDtos.add(creditorAcctRating);*/

        return trxRatingModelRequestDtos;
    }

    private TrxRecord translateToTrxRecord(PayRiskCalcReqDto req) {
        TrxRecord record = new TrxRecord();
        record.setCreditorName(req.getCreditorName());
        record.setCreditorAccount(req.getCreditorAccount());
        record.setCreditorInstitutionName(req.getInstitutionName());
        record.setUuid(UUID.randomUUID().toString());
        record.setAmount(req.getAmount());

        // TODO hardcoded for demo.
        if ("500105170123456789".equals(req.getCreditorAccount())) {
            record.setCreditorIban("DE41500105170123456789");
            record.setCreditorCountryCode("DE");
            record.setCreditorBankId("50010517");
            record.setCreditorBankIdCode("INGDDEFFXXX");
        } else if ("100000010123123123".equals(req.getCreditorAccount())) {
            record.setCreditorIban("DE39100000010123123123");
            record.setCreditorCountryCode("DE");
            record.setCreditorBankId("10000001");
            record.setCreditorBankIdCode("BLKFDE33");
        }

        return record;
    }

    private VerifyAccountFmtRespDto prevalidateCreditorAccountFormat(TrxRecord record) throws Exception {
        VerifyAccountFmtReqDto prevalAccountFormatDto = new VerifyAccountFmtReqDto();
        prevalAccountFormatDto.setAccount_identification(record.getCreditorIban());
        prevalAccountFormatDto.setCountry_code(record.getCreditorCountryCode());
        prevalAccountFormatDto.setFinancial_institution_identification(record.getCreditorInstitutionId());
        return swiftApiService.swiftPrevalAcFormat(prevalAccountFormatDto);
    }

    private VerifyAccountRespDto prevalidateCreditorAccount(TrxRecord record) throws Exception {
        VerifyAccountReqDto dto = new VerifyAccountReqDto();
        dto.setCreditorName(record.getCreditorName());
        // Request is in the scope of the payment initiation
        dto.setContext("BENR");
        dto.setCreditorAccount(record.getCreditorAccount());
        dto.setCreditorName(record.getCreditorName());
        dto.setCorrelationIdentifier("SCENARIO1-CORRID-001");
        return swiftApiService.swiftPrevalAcVerify(dto, "916a97d-a699-4f20-b8c2-2b07e2684a27");
    }

    private VerifyAccountFmtRespDto prevalidateDebitorAccountFormat(TrxRecord record) throws Exception {
        VerifyAccountFmtReqDto prevalAccountFormatDto = new VerifyAccountFmtReqDto();
        prevalAccountFormatDto.setAccount_identification(record.getDebitorIban());
        prevalAccountFormatDto.setCountry_code(record.getDebitorCountryCode());
        prevalAccountFormatDto.setFinancial_institution_identification(record.getDebitorInstitutionId());
        return swiftApiService.swiftPrevalAcFormat(prevalAccountFormatDto);
    }

}
