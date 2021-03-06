package com.bishack.api.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.bishack.api.dto.PayRiskCalcReqDto;
import com.bishack.api.dto.PayRiskCalcResDto;
import com.bishack.api.dto.TrxRatingModelDto;
import com.bishack.api.dto.TrxRatingModelRequestDto;
import com.bishack.api.dto.TrxRatingModelResponeDto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service(value = "riskCalcEngine")
public class RiskCalcEngine implements IRiskCalcEngine {
	@Autowired
	private List<IRiskEngineDataAgg> riskEngineDataAggs;
	
	@Autowired
	private RestTemplate modelApiRestTemplate;

	@Override
	public PayRiskCalcResDto executeRiskAnalysis(PayRiskCalcReqDto payRiskCalcReqDto)  {
		
		PayRiskCalcResDto payRiskCalcResDto = new PayRiskCalcResDto();
		payRiskCalcResDto.setRiskRecommendation("COULD_NOT_PERFORM");
		ObjectMapper objectMapper = new ObjectMapper();
		
		try {
		

		List<TrxRatingModelRequestDto> trxRatingModelRequestDtos = new ArrayList<TrxRatingModelRequestDto>();
		if (riskEngineDataAggs != null) {
			for (IRiskEngineDataAgg riskEngineDataAgg : riskEngineDataAggs) {
				List<TrxRatingModelRequestDto> trxRatingModelRequests = riskEngineDataAgg
						.getModelInputData(payRiskCalcReqDto);
				trxRatingModelRequestDtos.addAll(trxRatingModelRequests);
			}

			if (CollectionUtils.isNotEmpty(trxRatingModelRequestDtos)) {

				RestTemplate restTemplate = new RestTemplate();
				TrxRatingModelDto trxRatingModelDto = new TrxRatingModelDto();
				trxRatingModelDto.setTrxRatingModelRequestDtos(trxRatingModelRequestDtos);
				HttpHeaders headers = new HttpHeaders();				
				headers.setContentType(MediaType.APPLICATION_JSON);				
				HttpEntity<TrxRatingModelDto> request = new HttpEntity<>(trxRatingModelDto, headers);
				System.out.println(objectMapper.writeValueAsString(trxRatingModelDto));
				
				
				MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<String, String>();
				
				requestBody.addIfAbsent("trxRatingModelRequestDtos", objectMapper.writeValueAsString(trxRatingModelDto));
						
		
				String jsonStr = modelApiRestTemplate.postForObject("http://localhost:80/predict_score", requestBody, String.class, requestBody);
				
				/*ResponseEntity<String> responseEnt = restTemplate.exchange(
						"http://localhost:80/predict_score",
						HttpMethod.GET, request, String.class);
				
				
				String jsonStr = responseEnt.getBody();*/
				
				objectMapper = new ObjectMapper();
				
				
				//String jsonStr = "[{\"category\":[\"SWIFT_VALIDATION\"],\"score\":[5]},{\"category\":[\"SWIFT_COMPLIANCE\"],\"score\":[6]},{\"category\":[\"INTERNAL_COMPLIANCE\"],\"score\":[7]},{\"category\":[\"INTERNAL_TRX_HIST\"],\"score\":[57]},{\"category\":[\"OVERALL_SCORE\"],\"score\":[6]}]";
						
				jsonStr = StringUtils.remove(jsonStr, "[");
				jsonStr = StringUtils.remove(jsonStr, "]");
				jsonStr = "[" +jsonStr +"]";
				
				List<TrxRatingModelResponeDto> trxRatingModelDtoResp = objectMapper.readValue(jsonStr, new TypeReference<List<TrxRatingModelResponeDto>>(){});
				
				
				if (CollectionUtils.isNotEmpty(trxRatingModelDtoResp)) {
					payRiskCalcResDto.setRiskRatingDetails(trxRatingModelDtoResp);
					for (TrxRatingModelResponeDto trxRatingDto :trxRatingModelDtoResp ) {
						if (IServiceConstants.CAT_OVERALL_SCORE.equalsIgnoreCase(trxRatingDto.getCategory())) {
							if (trxRatingDto.getScore() != null) {
								if (trxRatingDto.getScore() <= 5) {
									payRiskCalcResDto.setRiskRecommendation(IServiceConstants.RATING_REC_PROCEED);
								} else if (trxRatingDto.getScore() <= 8) {
									payRiskCalcResDto.setRiskRecommendation(IServiceConstants.RATING_REC_REVIEW);
								} else {
									payRiskCalcResDto.setRiskRecommendation(IServiceConstants.RATING_REC_REJECT);
								}
							}
						}
					}
					
					payRiskCalcResDto.setTrxRatingModelDto(trxRatingModelDto);
				}
				
				
				
			}
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return payRiskCalcResDto;
	}

}
