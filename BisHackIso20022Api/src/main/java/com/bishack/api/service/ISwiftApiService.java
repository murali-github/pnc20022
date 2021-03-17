package com.bishack.api.service;

import com.bishack.api.dto.SwiftInstitutionReviewDto;
import com.bishack.api.dto.SwiftPrevalBicDto;
import com.bishack.api.dto.SwiftPrevalCatPurposeDto;
import com.bishack.api.dto.SwiftPrevalPurposeCdDto;
import com.bishack.api.dto.SwiftPrevalPurposeDto;
import com.bishack.api.dto.swift.prevalidation.account.VerifyAccountReqDto;
import com.bishack.api.dto.swift.prevalidation.account.VerifyAccountRespDto;
import com.bishack.api.dto.swift.prevalidation.accountfmt.VerifyAccountFmtReqDto;
import com.bishack.api.dto.swift.prevalidation.accountfmt.VerifyAccountFmtRespDto;

public interface ISwiftApiService {	
	VerifyAccountFmtRespDto swiftPrevalAcFormat(VerifyAccountFmtReqDto swiftPrevalAcFormatDto) throws Exception;
	VerifyAccountRespDto swiftPrevalAcVerify(VerifyAccountReqDto swiftPrevalAcVerifyDto, String bic) throws Exception;	
	String swiftPrevalBic(SwiftPrevalBicDto swiftPrevalBicDto) throws Exception;	
	String swiftPrevalPurposeCd(SwiftPrevalPurposeCdDto swiftPrevalPurposeCdDto) throws Exception;	
	String swiftPrevalPurpose(SwiftPrevalPurposeDto swiftPrevalPurposeDto) throws Exception;	
	String swiftPrevalCatPurpose(SwiftPrevalCatPurposeDto swiftPrevalCatPurposeDto) throws Exception;		
	String swiftIntitutionReview(SwiftInstitutionReviewDto swiftInstitutionReviewDto) throws Exception;	
}
