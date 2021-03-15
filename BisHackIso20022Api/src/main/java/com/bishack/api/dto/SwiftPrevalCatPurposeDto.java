package com.bishack.api.dto;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Component
@JsonRootName(value = "SwiftPrevalCatPurposeDto")
public class SwiftPrevalCatPurposeDto extends BaseDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String category_purpose_code;
	private String country_code;
	
	
	public String getCategory_purpose_code() {
		return category_purpose_code;
	}


	public void setCategory_purpose_code(String category_purpose_code) {
		this.category_purpose_code = category_purpose_code;
	}


	public String getCountry_code() {
		return country_code;
	}


	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}


	public SwiftPrevalCatPurposeDto() {
		super();

	}

	public SwiftPrevalCatPurposeDto(String category_purpose_code, String country_code) {
		super();
		this.category_purpose_code = category_purpose_code;
		this.country_code = country_code;
	}
	
	
	
}
