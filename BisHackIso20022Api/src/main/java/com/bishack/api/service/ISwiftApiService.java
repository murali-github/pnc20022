package com.bishack.api.service;

import com.bishack.api.dto.SwiftInstitutionReviewDto;
import com.bishack.api.dto.SwiftPrevalAcFormatDto;
import com.bishack.api.dto.SwiftPrevalAcVerifyDto;
import com.bishack.api.dto.SwiftPrevalBicDto;
import com.bishack.api.dto.SwiftPrevalCatPurposeDto;
import com.bishack.api.dto.SwiftPrevalPurposeCdDto;
import com.bishack.api.dto.SwiftPrevalPurposeDto;

public interface ISwiftApiService {	
	String swiftPrevalAcFormat(SwiftPrevalAcFormatDto swiftPrevalAcFormatDto) throws Exception;
	String swiftPrevalAcVerify(SwiftPrevalAcVerifyDto swiftPrevalAcVerifyDto) throws Exception;	
	String swiftPrevalBic(SwiftPrevalBicDto swiftPrevalBicDto) throws Exception;	
	String swiftPrevalPurposeCd(SwiftPrevalPurposeCdDto swiftPrevalPurposeCdDto) throws Exception;	
	String swiftPrevalPurpose(SwiftPrevalPurposeDto swiftPrevalPurposeDto) throws Exception;	
	String swiftPrevalCatPurpose(SwiftPrevalCatPurposeDto swiftPrevalCatPurposeDto) throws Exception;		
	String swiftIntitutionReview(SwiftInstitutionReviewDto swiftInstitutionReviewDto) throws Exception;	
}
