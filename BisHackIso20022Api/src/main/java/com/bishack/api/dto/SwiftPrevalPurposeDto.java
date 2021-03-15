package com.bishack.api.dto;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Component
@JsonRootName(value = "SwiftPrevalPurposeDto")
public class SwiftPrevalPurposeDto extends BaseDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String purpose_code;
	private String country_code;
	private String purpose_description;
	
	public SwiftPrevalPurposeDto() {
		super();

	}

	public SwiftPrevalPurposeDto(String purpose_code, String country_code, String purpose_description) {
		super();
		this.purpose_code = purpose_code;
		this.country_code = country_code;
		this.purpose_description = purpose_description;
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

	public String getPurpose_description() {
		return purpose_description;
	}

	public void setPurpose_description(String purpose_description) {
		this.purpose_description = purpose_description;
	}
	
	
	
}
