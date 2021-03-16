package com.bishack.api.service;

import java.nio.file.Files;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
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
import com.bishack.api.dto.swiftref.bbantoiban.BbanToIbanResDto;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service(value = "mockSwiftApiService")
public class MockSwiftApiService implements ISwiftApiService {

	@Autowired
	private RestTemplate swiftApiRestTemplate;

	@Autowired
	private ISwiftApiTokenService swiftApiTokenService;

	@Override
	public String swiftPrevalAcFormat(SwiftPrevalAcFormatDto swiftPrevalAcFormatDto) throws Exception {
		String response = null;

		return response;
	}

	@Override
	public String swiftPrevalAcVerify(SwiftPrevalAcVerifyDto swiftPrevalAcVerifyDto, String bic) throws Exception {
		String response = null;

		return response;
	}

	@Override
	public String swiftPrevalBic(SwiftPrevalBicDto swiftPrevalBicDto) throws Exception {
		String response = null;

		return response;
	}

	@Override
	public String swiftPrevalPurposeCd(SwiftPrevalPurposeCdDto swiftPrevalPurposeCdDto) throws Exception {
		String response = null;

		return response;
	}

	@Override
	public String swiftPrevalPurpose(SwiftPrevalPurposeDto swiftPrevalPurposeDto) throws Exception {
		String response = null;

		return response;
	}

	@Override
	public String swiftPrevalCatPurpose(SwiftPrevalCatPurposeDto swiftPrevalCatPurposeDto) throws Exception {
		String response = null;

		return response;
	}

	@Override
	public String swiftIntitutionReview(SwiftInstitutionReviewDto swiftInstitutionReviewDto) throws Exception {
		String response = null;

		return response;
	}

	public BbanToIbanResDto getIbanFromBban(String bban) throws Exception {
		ClassPathResource resource = new ClassPathResource("mock-data/bban2iban/500700100532013000.json");
		String resourceContent = new String(Files.readAllBytes(resource.getFile().toPath()));
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(resourceContent, BbanToIbanResDto.class);
	}

}
