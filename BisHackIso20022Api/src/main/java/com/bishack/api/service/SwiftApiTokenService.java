package com.bishack.api.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.bishack.api.dto.SwiftTokenDto;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service(value = "swiftApiTokenService")
public class SwiftApiTokenService implements ISwiftApiTokenService {
	
	@Autowired
	private RestTemplate swiftApiKeyRestTemplate;
	
	
	/* (non-Javadoc)
	 * @see com.bishack.api.service.ISwiftApiTokenService#getSwiftPrevalAuthToken()
	 */
	@Override
	@Cacheable(value="SwiftApiPrevalToken", key = "#root.methodName")
	public SwiftTokenDto getSwiftPrevalAuthToken() {
		
		SwiftTokenDto swiftTokenDto = new SwiftTokenDto();
		String response = null;
		try {
			String scope = "swift.preval!p";
			String grantType = "urn:ietf:params:oauth:grant-type:jwt-bearer";
			String assertion = "eyJhbGciOiJSUzI1NiIsIng1YyI6WyJNSUlFelRDQ0FyV2dBd0lCQWdJRVhqQi9sekFOQmdrcWhraUc5dzBCQVFzRkFEQVFNUTR3REFZRFZRUUtFd1ZUVjBsR1ZEQWVGdzB5TURBeU1qY3hOakl4TVROYUZ3MHlNakF5TWpjeE5qVXhNVE5hTUU0eERqQU1CZ05WQkFvVEJYTjNhV1owTVJFd0R3WURWUVFLRXdoemQyaHhZbVZpWWpFUE1BMEdBMVVFQ3hNR1lYQnBkbUZ6TVJnd0ZnWURWUVFERXc5aGNHbDJZWE10Y0hKdmRtbGtaWEl3Z2dFaU1BMEdDU3FHU0liM0RRRUJBUVVBQTRJQkR3QXdnZ0VLQW9JQkFRQ3lhTGhJbUVHT21IeTk4Wm51dVhPdTFSSUNaRFhPMjFOM01KNDhRbGZlUHoydDFaZTBJek1MQ3ArS1hwSWRYaWl5U2k1NmljRCs3d3ozUWZpMk5yakZ5UXJ4RVJhVDc2ZDBUSmV4cmRta0I2OHhxM2lUeDNnWGpXKzFtVUt6WUZ4MVI3Mys4T3g5UkRGZ2FybnAxb3doazdLUEoxMGdPMnpQSTJINVBVZ2xyS2swWkcwUTcvdy8rNFhPT2JCd1NPMy9QNndYWmtYdXgzenRoWUh4VVVTWXZNRGhlQWthVlI1VnA1aElRRk5DemQ1NU9hRTBBNWhIN1M0Q2FwaTluZkQvaysyN2JPbUsyWU5aMHFvZHd0aHdNNHdYaFo0T09Qa3dHQ1Jpdks1NExUelBVUkw4TTF3TVNwejh5UFc2bnhSQ3NnN1hIbi96WjMzZTlPV1duaWtSQWdNQkFBR2pnZkF3Z2Uwd0N3WURWUjBQQkFRREFnV2dNQlFHQTFVZElBUU5NQXN3Q1FZSEt4VUdBd3BrQVRBMUJnTlZIUjhFTGpBc01DcWdLS0FtcENRd0lqRU9NQXdHQTFVRUNoTUZVMWRKUmxReEVEQU9CZ05WQkFNVEIwTlNUREV5TURJd0t3WURWUjBRQkNRd0lvQVBNakF5TURBeU1qY3hOakl4TVROYWdROHlNREl4TURneU9ESXlOVEV4TTFvd0h3WURWUjBqQkJnd0ZvQVVJbGRLV3dEam5EQUZyRHpNaTVBTlVEbGQ4NDB3SFFZRFZSME9CQllFRk1GdGFCeUdKdWtDWTZKbTFuSFBBaytzNFZGUE1Ba0dBMVVkRXdRQ01BQXdHUVlKS29aSWh2WjlCMEVBQkF3d0Noc0VWamd1TWdNQ0E2Z3dEUVlKS29aSWh2Y05BUUVMQlFBRGdnSUJBQ1BDMURmSkh5VDU0UUdtQ1RRVWg1bjFHWUFuV3RuejN1bEpkR1gyN0huOVc3RmVMYkt1QndUdzhVMmEyNGl2NlpZWXBRWm1TS1YzSU1RUFhiYlo0K0R3aUZTTWJTR2UxY2gzdy9aNVJsR1JqUFFxbU1yR3h4OTk4NHc3SDFScTgyaVhUMHZQbWtVZ3pyZEg5WkdpcW9Meko1NGRZN214Vmp0dmJtTDZZaTNxTVk0VE93dmt6L3ozZFRINENqdkRRUzNPdHBxTkRJV3ZXZ20ycHJOdTFPOUU2SVhhMzh6SDNnWmdZcmpCQmFQVVR3RXhRcElwQ3Nwa3ZCbU5kL0FMcGExVkNTL2tjK3kzNDJVKytpbHAyZ2Z2ZzBBd29pSTloNEtac3VKdE4rMHVsZ05VSUp0L2NmR0ZnMjQ2NXdsTVBoSkJRbTUvK2loZVF4dlE5akozcXQ1Tk9JRGZXamRXaGRIcUxyRUNNOG1wcUlkelVpTURrUDZZNExwSDlKMmR5eVhmSXU0SlZFT1JkTG04TFRyMWlhZGljZldNVEVhdC9LZ3Vxc3hrR1J4SXBqODg3Sks1NmFzZThnS2pYWCt0eVp1SHltMjhzTC9ZSFpWUUVwWklPQTNVUXFoZERUOThWY2w4cUhhNzRHS1dhaTFVOFZ2YnVZZGt3RnYydXpxR0JWWFNLSDhmeWp5WktMM0FMbW5XVlpqUXBpcVBzRHRSZ2pKb3FqR0MrM2UyYUdqR3R2b0dpSVMrcG80dm9BdjJYRUFiemNib3hEYnlHSDhNN2c1UGFtaWt5YVpYTEpCTVFLdmU5aTE1dzdxNFJ1ZXRWZEpCMlc5cU9BbnNVanZOVi96NWlodmlZRGhYY3VhQ3VCZTM3NDNuR0Jyd1QrUkVRSFRlRVBjbFJtcUgiXSwidHlwIjoiSldUIn0.eyJpc3MiOiI4UkVDQWFzdHlPQmtybWxnTkNBVnBBenEyNndDRzdBUiIsInN1YiI6ImNuPWFwaXZhcy1wcm92aWRlcixPVT1hcGl2YXMsTz1zd2hxYmViYixPPXN3aWZ0IiwiYXVkIjoiYXBpLXRlc3Quc3dpZnRuZXQuc2lwbi5zd2lmdC5jb20vb2F1dGgyL3YxL3Rva2VuIiwiZXhwIjoxNTk0ODcwNjcwLCJpYXQiOjE1OTQ4Njk3NzAsImp0aSI6IjVuZWltd2lFdzlTaUhiVGRocGdGODBNRmJuR2ZrVDFBXzE1OTQ4Njk3NzBfVEMxd1N2VSJ9.XCuyhS9KGKl2_fFj7olX91fNQq5yNoNeX2vucbX3fAmpLH9wSCJuAyOxedzCrMJvgSVTfh4rq83WYA306k9bPEgjixl41VCbF3QUYy9nYTEY_PlNhS_pYhuBKbyKyUaiT7ndYuHNingqUUEDKLR9Qv_EAxusAGGyrs7ODc20AvE64BLkKFlCgxAmAF0iuUAL2C7ts9KHyLaf5kUcQPtN7dtteD947oq3Otyr_-3rXE7HPs02hvZL3-qHTYZhC1czfV7Z7T3C48-97asP053Q5kLPA5fA-2Zrn3USKEv0kl8jzxbsCEnWcxFwif6vWDfFubAaV-r20eS-O013vgVULg";
			// String basicAuth = "Basic
			// NmNqYjgwV1EzTFRPMFB3Q2JHellaNHZ2aUU1M1hoZzM6QWM4OFlmUXFEUHpMU0ZzYg==";

			String access_token_url = "https://sandbox.swift.com/oauth2/v1/token";

			MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<String, String>();
			requestBody.add("grant_type", grantType);
			requestBody.add("scope", scope);
			requestBody.add("assertion", assertion);

			response = swiftApiKeyRestTemplate.postForObject(access_token_url, requestBody, String.class, requestBody);
			
			
			if (StringUtils.isNotBlank(response)) {			
				ObjectMapper objectMapper = new ObjectMapper();			
				JsonNode jsonNode = objectMapper.readTree(response);
				String token_type = jsonNode.get("token_type").asText();
				String access_token = jsonNode.get("access_token").asText();
				String refresh_token = jsonNode.get("refresh_token").asText();
				String refresh_token_expires_in = jsonNode.get("refresh_token_expires_in").asText();
				String expires_in = jsonNode.get("expires_in").asText();
				swiftTokenDto.setAccess_token(access_token);
				swiftTokenDto.setExpires_in(expires_in);
				swiftTokenDto.setRefresh_token(refresh_token);
				swiftTokenDto.setRefresh_token_expires_in(refresh_token_expires_in);
				swiftTokenDto.setToken_type(token_type);
			}
			

		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}

		return swiftTokenDto;
	}


	@Override
	@Cacheable(value="SwiftApiComplianceToken", key = "#root.methodName")
	public SwiftTokenDto getSwiftComplianceAuthToken() {
		
		SwiftTokenDto swiftTokenDto = new SwiftTokenDto();
		String response = null;
		try {
			String username = "sandbox-id";
			String grantType = "password";
			String password = "sandbox-key";
			// String basicAuth = "Basic
			// NmNqYjgwV1EzTFRPMFB3Q2JHellaNHZ2aUU1M1hoZzM6QWM4OFlmUXFEUHpMU0ZzYg==";

			String access_token_url = "https://sandbox.swift.com/oauth2/v1/token";

			MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<String, String>();
			requestBody.add("username", username);
			requestBody.add("password", password);
			requestBody.add("grant_type", grantType);

			response = swiftApiKeyRestTemplate.postForObject(access_token_url, requestBody, String.class, requestBody);
			
			
			if (StringUtils.isNotBlank(response)) {			
				ObjectMapper objectMapper = new ObjectMapper();			
				JsonNode jsonNode = objectMapper.readTree(response);
				String token_type = jsonNode.get("token_type").asText();
				String access_token = jsonNode.get("access_token").asText();
				String refresh_token = jsonNode.get("refresh_token").asText();
				String refresh_token_expires_in = jsonNode.get("refresh_token_expires_in").asText();
				String expires_in = jsonNode.get("expires_in").asText();
				swiftTokenDto.setAccess_token(access_token);
				swiftTokenDto.setExpires_in(expires_in);
				swiftTokenDto.setRefresh_token(refresh_token);
				swiftTokenDto.setRefresh_token_expires_in(refresh_token_expires_in);
				swiftTokenDto.setToken_type(token_type);
			}
			

		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}

		return swiftTokenDto;
	}



}
