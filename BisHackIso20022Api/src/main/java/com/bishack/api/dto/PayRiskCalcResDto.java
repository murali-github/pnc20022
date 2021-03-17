package com.bishack.api.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PayRiskCalcResDto {
	@JsonProperty("riskRecommendation")
	private String riskRecommendation;

	
	private List<TrxRatingModelResponeDto> riskRatingDetails;
	
	@JsonProperty("mlModelInput")
	private TrxRatingModelDto trxRatingModelDto;

	public String getRiskRecommendation() {
		return riskRecommendation;
	}

	public void setRiskRecommendation(String riskRecommendation) {
		this.riskRecommendation = riskRecommendation;
	}

	public PayRiskCalcResDto() {
		super();
	}

	public List<TrxRatingModelResponeDto> getRiskRatingDetails() {
		return riskRatingDetails;
	}

	public void setRiskRatingDetails(List<TrxRatingModelResponeDto> riskRatingDetails) {
		this.riskRatingDetails = riskRatingDetails;
	}

	public TrxRatingModelDto getTrxRatingModelDto() {
		return trxRatingModelDto;
	}

	public void setTrxRatingModelDto(TrxRatingModelDto trxRatingModelDto) {
		this.trxRatingModelDto = trxRatingModelDto;
	}
	

	
}
