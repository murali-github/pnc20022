package com.bishack.api.dto.swiftref.bbantoiban;

import com.bishack.api.dto.BaseDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BbanToIbanResDto extends BaseDto {
	@JsonProperty("status")
	private BbanToIbanResStatus status;

	@JsonProperty("iban")
	private String iban;

	@JsonProperty("iban")
	public String getIban() {
		return iban;
	}

	@JsonProperty("iban")
	public void setIban(String iban) {
		this.iban = iban;
	}

	@JsonProperty("status")
	public BbanToIbanResStatus getStatus() {
		return status;
	}

	@JsonProperty("status")
	public void setStatus(BbanToIbanResStatus status) {
		this.status = status;
	}

}
