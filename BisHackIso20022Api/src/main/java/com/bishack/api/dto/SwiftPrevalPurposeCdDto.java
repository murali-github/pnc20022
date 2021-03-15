package com.bishack.api.dto;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Component
@JsonRootName(value = "SwiftPrevalPurposeCdDto")
public class SwiftPrevalPurposeCdDto extends BaseDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String purpose_code;
	private String country_code;
	
	public SwiftPrevalPurposeCdDto() {
		super();

	}

	public SwiftPrevalPurposeCdDto(String purpose_code, String country_code) {
		super();
		this.purpose_code = purpose_code;
		this.country_code = country_code;
	}

	public String getPurpose_code() {
		return purpose_code;
	}

	public void setPurpose_code(String purpose_code) {
		this.purpose_code = purpose_code;
	}

	public String getCountry_code() {
		return country_code;
	}

	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}
	
	
	
}
