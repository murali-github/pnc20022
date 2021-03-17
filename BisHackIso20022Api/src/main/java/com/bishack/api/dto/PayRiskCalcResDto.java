package com.bishack.api.dto;

import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PayRiskCalcResDto {
	@JsonProperty("riskRecommendation")
	private String riskRecommendation;
	
	@JsonProperty("riskRating")
	private Integer riskRating;
	
	private Map<String, Integer> catScores;

	public String getRiskRecommendation() {
		return riskRecommendation;
	}

	public void setRiskRecommendation(String riskRecommendation) {
		this.riskRecommendation = riskRecommendation;
	}

	public Integer getRiskRating() {
		return riskRating;
	}

	public void setRiskRating(Integer riskRating) {
		this.riskRating = riskRating;
	}

	public PayRiskCalcResDto() {
		super();
	}

	public Map<String, Integer> getCatScores() {
		if (catScores == null) {
			catScores = new HashedMap<>();
		}
		return catScores;
	}

	public void setCatScores(Map<String, Integer> catScores) {
		this.catScores = catScores;
	}

	
}
