package com.bishack.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentRiskResDto {
	@JsonProperty("riskFactor")
	private String riskFactor;

	@JsonProperty("riskFactor")
	public String getRiskFactor() {
		return riskFactor;
	}

	@JsonProperty("riskFactor")
	public void setRiskFactor(String riskFactor) {
		this.riskFactor = riskFactor;
	}
}
