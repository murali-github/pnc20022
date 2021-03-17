package com.bishack.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bishack.api.dto.SwiftInstitutionReviewDto;
import com.bishack.api.dto.SwiftPrevalBicDto;
import com.bishack.api.dto.SwiftPrevalCatPurposeDto;
import com.bishack.api.dto.SwiftPrevalPurposeCdDto;
import com.bishack.api.dto.SwiftPrevalPurposeDto;
import com.bishack.api.dto.SwiftTokenDto;
import com.bishack.api.dto.swift.prevalidation.account.VerifyAccountReqDto;
import com.bishack.api.dto.swift.prevalidation.account.VerifyAccountRespDto;
import com.bishack.api.dto.swift.prevalidation.accountfmt.VerifyAccountFmtReqDto;
import com.bishack.api.dto.swift.prevalidation.accountfmt.VerifyAccountFmtRespDto;
import com.bishack.api.service.ISwiftApiService;
import com.bishack.api.service.ISwiftApiTokenService;

@Controller
public class SwiftApiController {
	
	@Autowired
	private ISwiftApiService swiftApiService;
	
	@Autowired
	private ISwiftApiTokenService swiftApiTokenService;
    
    @GetMapping(path="/getSwiftPrevalAuthToken")
	@ResponseBody
	public ResponseEntity<SwiftTokenDto> getSwiftPrevalAuthToken() {    	
    	SwiftTokenDto respone= swiftApiTokenService.getSwiftPrevalAuthToken();
		return new ResponseEntity<SwiftTokenDto>(respone, HttpStatus.OK);
	}
    
    @GetMapping(path="/getSwiftComplianceAuthToken")
	@ResponseBody
	public ResponseEntity<SwiftTokenDto> getSwiftComplianceAuthToken() {    	
    	SwiftTokenDto respone= swiftApiTokenService.getSwiftComplianceAuthToken();
		return new ResponseEntity<SwiftTokenDto>(respone, HttpStatus.OK);
	}
    
    @PostMapping(path="/retrieveSwiftInstitutionReview", headers={"Accept=application/json", "Content-Type=application/json"})
	@ResponseBody
	public ResponseEntity<String> retrieveSwiftInstitutionReview(@RequestBody Optional<SwiftInstitutionReviewDto>  swiftInstitutionReviewDto) throws Exception {    	
    	String respone= swiftApiService.swiftIntitutionReview(swiftInstitutionReviewDto.get());
		return new ResponseEntity<String>(respone, HttpStatus.OK);
	}
	
    @PostMapping(path="/swiftPrevalAcFormat", headers={"Accept=application/json", "Content-Type=application/json"})
	public ResponseEntity<VerifyAccountFmtRespDto> swiftPrevalAcFormat(@RequestBody Optional<VerifyAccountFmtReqDto>  swiftPrevalAcFormatDto) throws Exception {      	
    	VerifyAccountFmtRespDto respone= swiftApiService.swiftPrevalAcFormat(swiftPrevalAcFormatDto.orElse(new VerifyAccountFmtReqDto("DE41500105170123456789", "DE", "INGDDEFFXXX")));
		return new ResponseEntity<VerifyAccountFmtRespDto>(respone, HttpStatus.OK);
	}
    
    @PostMapping(path="/swiftPrevalAcVerify", headers={"Accept=application/json", "Content-Type=application/json"})
	public ResponseEntity<VerifyAccountRespDto> swiftPrevalAcVerify(@RequestBody Optional<VerifyAccountReqDto>  swiftPrevalAcFormatDto) throws Exception {      	
    	VerifyAccountRespDto respone= swiftApiService.swiftPrevalAcVerify(swiftPrevalAcFormatDto.get(), null); // TODO this won't work unless we pass bic. Not sure if we need this class.
		return new ResponseEntity<VerifyAccountRespDto>(respone, HttpStatus.OK);
	}
    
    
    @PostMapping(path="/swiftPrevalBic", headers={"Accept=application/json", "Content-Type=application/json"})
	public ResponseEntity<String> swiftPrevalBic(@RequestBody Optional<SwiftPrevalBicDto>  swiftPrevalAcFormatDto) throws Exception {      	
    	String respone= swiftApiService.swiftPrevalBic(swiftPrevalAcFormatDto.orElse(new SwiftPrevalBicDto("INGDDEFFXXX", "DE")));
		return new ResponseEntity<String>(respone, HttpStatus.OK);
	}
    
    @PostMapping(path="/swiftPrevalPurposeCd", headers={"Accept=application/json", "Content-Type=application/json"})
	public ResponseEntity<String> swiftPrevalPurposeCd(@RequestBody Optional<SwiftPrevalPurposeCdDto>  swiftPrevalAcFormatDto) throws Exception {      	
    	String respone= swiftApiService.swiftPrevalPurposeCd(swiftPrevalAcFormatDto.orElse(new SwiftPrevalPurposeCdDto("VO10100", "RU")));
		return new ResponseEntity<String>(respone, HttpStatus.OK);
	}
    
    @PostMapping(path="/swiftPrevalPurpose", headers={"Accept=application/json", "Content-Type=application/json"})
	public ResponseEntity<String> swiftPrevalPurpose(@RequestBody Optional<SwiftPrevalPurposeDto>  swiftPrevalAcFormatDto) throws Exception {      	
    	String respone= swiftApiService.swiftPrevalPurpose(swiftPrevalAcFormatDto.orElse(new SwiftPrevalPurposeDto("VO01040", "RU", "Some description in Russian")));
		return new ResponseEntity<String>(respone, HttpStatus.OK);
	}
    
    @PostMapping(path="/swiftPrevalCatPurpose", headers={"Accept=application/json", "Content-Type=application/json"})
	public ResponseEntity<String> swiftPrevalCatPurpose(@RequestBody Optional<SwiftPrevalCatPurposeDto>  swiftPrevalAcFormatDto) throws Exception {      	
    	String respone= swiftApiService.swiftPrevalCatPurpose(swiftPrevalAcFormatDto.orElse(new SwiftPrevalCatPurposeDto("VO130405", "YY")));
		return new ResponseEntity<String>(respone, HttpStatus.OK);
	}
    
    
}
