package com.bishack.api.dto;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Component
@JsonRootName(value = "SwiftInstitutionReviewDto")
public class SwiftInstitutionReviewDto extends BaseDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
			
	private String institution_rating_set;
	private String country_rating_set;
	private String target_currency;
	private String reporting_period;
	private String exposure;
	private String direction;
	private String id;
	
	
	
	public SwiftInstitutionReviewDto(String institution_rating_set, String country_rating_set, String target_currency,
			String reporting_period, String exposure, String direction, String id) {
		super();
		this.institution_rating_set = institution_rating_set;
		this.country_rating_set = country_rating_set;
		this.target_currency = target_currency;
		this.reporting_period = reporting_period;
		this.exposure = exposure;
		this.direction = direction;
		this.id = id;
	}
	
	
	public SwiftInstitutionReviewDto() {
		super();
	}


	public String getInstitution_rating_set() {
		return institution_rating_set;
	}
	public void setInstitution_rating_set(String institution_rating_set) {
		this.institution_rating_set = institution_rating_set;
	}
	public String getCountry_rating_set() {
		return country_rating_set;
	}
	public void setCountry_rating_set(String country_rating_set) {
		this.country_rating_set = country_rating_set;
	}
	public String getTarget_currency() {
		return target_currency;
	}
	public void setTarget_currency(String target_currency) {
		this.target_currency = target_currency;
	}
	public String getReporting_period() {
		return reporting_period;
	}
	public void setReporting_period(String reporting_period) {
		this.reporting_period = reporting_period;
	}
	public String getExposure() {
		return exposure;
	}
	public void setExposure(String exposure) {
		this.exposure = exposure;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	
}
