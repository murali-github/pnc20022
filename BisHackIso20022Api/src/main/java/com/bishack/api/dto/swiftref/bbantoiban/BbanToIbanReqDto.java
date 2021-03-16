package com.bishack.api.dto.swiftref.bbantoiban;

import com.bishack.api.dto.BaseDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BbanToIbanReqDto extends BaseDto {
	@JsonProperty("bban")
	private String bban;

	@JsonProperty("country_code")
	private String countryCode;

	@JsonProperty("bban")
	public String getBban() {
		return bban;
	}

	@JsonProperty("bban")
	public void setBban(String bban) {
		this.bban = bban;
	}

	@JsonProperty("country_code")
	public String getCountryCode() {
		return countryCode;
	}

	@JsonProperty("country_code")
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

}
