package com.bishack.api.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.bishack.api.dto.SwiftInstitutionReviewDto;
import com.bishack.api.dto.SwiftPrevalAcFormatDto;
import com.bishack.api.dto.SwiftPrevalAcVerifyDto;
import com.bishack.api.dto.SwiftPrevalBicDto;
import com.bishack.api.dto.SwiftPrevalCatPurposeDto;
import com.bishack.api.dto.SwiftPrevalPurposeCdDto;
import com.bishack.api.dto.SwiftPrevalPurposeDto;
import com.bishack.api.dto.SwiftTokenDto;

@Service(value = "swiftApiService")
public class SwiftApiService implements ISwiftApiService {

	@Autowired
	private RestTemplate swiftApiRestTemplate;

	@Autowired
	private ISwiftApiTokenService swiftApiTokenService;

	@Override
	public String swiftPrevalAcFormat(SwiftPrevalAcFormatDto swiftPrevalAcFormatDto) throws Exception {
		String response = null;

		if (swiftPrevalAcFormatDto != null) {

			SwiftTokenDto swiftTokenDto = swiftApiTokenService.getSwiftPrevalAuthToken();
			if (swiftTokenDto != null && StringUtils.isNotBlank(swiftTokenDto.getAccess_token())) {

				HttpHeaders headers = new HttpHeaders();
				headers.add("Authorization", "Bearer " + swiftTokenDto.getAccess_token());
				headers.setContentType(MediaType.APPLICATION_JSON);

				HttpEntity<SwiftPrevalAcFormatDto> request = new HttpEntity<>(swiftPrevalAcFormatDto, headers);

				ResponseEntity<String> responseEnt = swiftApiRestTemplate.exchange(
						"https://sandbox.swift.com/swift-preval-pilot/v2/payment/account-format", HttpMethod.POST,
						request, String.class);
				response = responseEnt.getBody();
			}
		}

		return response;
	}

	@Override
	public String swiftPrevalAcVerify(SwiftPrevalAcVerifyDto swiftPrevalAcVerifyDto, String bic) throws Exception {
		String response = null;
		

		if (swiftPrevalAcVerifyDto != null) {

			SwiftTokenDto swiftTokenDto = swiftApiTokenService.getSwiftPrevalAuthToken();
			if (swiftTokenDto != null && StringUtils.isNotBlank(swiftTokenDto.getAccess_token())) {

				HttpHeaders headers = new HttpHeaders();
				headers.add("Authorization", "Bearer " + swiftTokenDto.getAccess_token());
				headers.setContentType(MediaType.APPLICATION_JSON);
				headers.add("x-bic", bic);

				HttpEntity<SwiftPrevalAcVerifyDto> request = new HttpEntity<>(swiftPrevalAcVerifyDto, headers);

				ResponseEntity<String> responseEnt = swiftApiRestTemplate.exchange(
						"https://sandbox.swift.com/swift-preval-pilot/v2/accounts/verification", HttpMethod.POST,
						request, String.class);
				response = responseEnt.getBody();
			}
		}

		return response;
	}

	@Override
	public String swiftPrevalBic(SwiftPrevalBicDto swiftPrevalBicDto) throws Exception {
		String response = null;

		if (swiftPrevalBicDto != null) {

			SwiftTokenDto swiftTokenDto = swiftApiTokenService.getSwiftPrevalAuthToken();
			if (swiftTokenDto != null && StringUtils.isNotBlank(swiftTokenDto.getAccess_token())) {

				HttpHeaders headers = new HttpHeaders();
				headers.add("Authorization", "Bearer " + swiftTokenDto.getAccess_token());
				headers.setContentType(MediaType.APPLICATION_JSON);

				HttpEntity<SwiftPrevalBicDto> request = new HttpEntity<>(swiftPrevalBicDto, headers);

				ResponseEntity<String> responseEnt = swiftApiRestTemplate.exchange(
						"https://sandbox.swift.com/swift-preval-pilot/v2/payment/financial-institution-identity", HttpMethod.POST,
						request, String.class);
				response = responseEnt.getBody();
			}
		}

		return response;
	}

	@Override
	public String swiftPrevalPurposeCd(SwiftPrevalPurposeCdDto swiftPrevalPurposeCdDto) throws Exception {
		String response = null;

		if (swiftPrevalPurposeCdDto != null) {

			SwiftTokenDto swiftTokenDto = swiftApiTokenService.getSwiftPrevalAuthToken();
			if (swiftTokenDto != null && StringUtils.isNotBlank(swiftTokenDto.getAccess_token())) {

				HttpHeaders headers = new HttpHeaders();
				headers.add("Authorization", "Bearer " + swiftTokenDto.getAccess_token());
				headers.setContentType(MediaType.APPLICATION_JSON);

				HttpEntity<SwiftPrevalPurposeCdDto> request = new HttpEntity<>(swiftPrevalPurposeCdDto, headers);

				ResponseEntity<String> responseEnt = swiftApiRestTemplate.exchange(
						"https://sandbox.swift.com/swift-preval-pilot/v2/payment/purpose-code", HttpMethod.POST,
						request, String.class);
				response = responseEnt.getBody();
			}
		}

		return response;
	}

	@Override
	public String swiftPrevalPurpose(SwiftPrevalPurposeDto swiftPrevalPurposeDto) throws Exception {
		String response = null;

		if (swiftPrevalPurposeDto != null) {

			SwiftTokenDto swiftTokenDto = swiftApiTokenService.getSwiftPrevalAuthToken();
			if (swiftTokenDto != null && StringUtils.isNotBlank(swiftTokenDto.getAccess_token())) {

				HttpHeaders headers = new HttpHeaders();
				headers.add("Authorization", "Bearer " + swiftTokenDto.getAccess_token());
				headers.setContentType(MediaType.APPLICATION_JSON);

				HttpEntity<SwiftPrevalPurposeDto> request = new HttpEntity<>(swiftPrevalPurposeDto, headers);

				ResponseEntity<String> responseEnt = swiftApiRestTemplate.exchange(
						"https://sandbox.swift.com/swift-preval-pilot/v2/payment/payment-purpose", HttpMethod.POST,
						request, String.class);
				response = responseEnt.getBody();
			}
		}

		return response;
	}

	@Override
	public String swiftPrevalCatPurpose(SwiftPrevalCatPurposeDto swiftPrevalCatPurposeDto) throws Exception {
		String response = null;

		if (swiftPrevalCatPurposeDto != null) {

			SwiftTokenDto swiftTokenDto = swiftApiTokenService.getSwiftPrevalAuthToken();
			if (swiftTokenDto != null && StringUtils.isNotBlank(swiftTokenDto.getAccess_token())) {

				HttpHeaders headers = new HttpHeaders();
				headers.add("Authorization", "Bearer " + swiftTokenDto.getAccess_token());
				headers.setContentType(MediaType.APPLICATION_JSON);

				HttpEntity<SwiftPrevalCatPurposeDto> request = new HttpEntity<>(swiftPrevalCatPurposeDto, headers);

				ResponseEntity<String> responseEnt = swiftApiRestTemplate.exchange(
						"https://sandbox.swift.com/swift-preval-pilot/v2/payment/category-purpose", HttpMethod.POST,
						request, String.class);
				response = responseEnt.getBody();
			}
		}

		return response;
	}

	@Override
	public String swiftIntitutionReview(SwiftInstitutionReviewDto swiftInstitutionReviewDto) throws Exception {
		String response = null;

		if (swiftInstitutionReviewDto != null) {

			SwiftTokenDto swiftTokenDto = swiftApiTokenService.getSwiftComplianceAuthToken();
			if (swiftTokenDto != null && StringUtils.isNotBlank(swiftTokenDto.getAccess_token())) {

				HttpHeaders headers = new HttpHeaders();
				headers.add("Authorization", "Bearer " + swiftTokenDto.getAccess_token());
				
				String api_url = "https://sandbox.swift.com/bi/compliance-analytics/v1/institution-review";

				MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<String, String>();
				
				if (StringUtils.isNotBlank(swiftInstitutionReviewDto.getInstitution_rating_set())) {
					requestBody.add("institution_rating_set", swiftInstitutionReviewDto.getInstitution_rating_set());
				}
				if (StringUtils.isNotBlank(swiftInstitutionReviewDto.getCountry_rating_set())) {
					requestBody.add("country_rating_set", swiftInstitutionReviewDto.getCountry_rating_set());
				}
				if (StringUtils.isNotBlank(swiftInstitutionReviewDto.getReporting_period())) {
					requestBody.add("reporting_period", swiftInstitutionReviewDto.getReporting_period());
				}
				if (StringUtils.isNotBlank(swiftInstitutionReviewDto.getExposure())) {
					requestBody.add("exposure", swiftInstitutionReviewDto.getExposure());
				}
				if (StringUtils.isNotBlank(swiftInstitutionReviewDto.getDirection())) {
					requestBody.add("direction", swiftInstitutionReviewDto.getDirection());
				}
				if (StringUtils.isNotBlank(swiftInstitutionReviewDto.getId())) {
					requestBody.add("id", swiftInstitutionReviewDto.getId());	
				}
				if (StringUtils.isNotBlank(swiftInstitutionReviewDto.getTarget_currency())) {
					requestBody.add("target_currency", swiftInstitutionReviewDto.getTarget_currency());
				}
		
				response = swiftApiRestTemplate.getForObject(api_url, String.class, requestBody);
	
			}
		}

		return response;
	}

}
