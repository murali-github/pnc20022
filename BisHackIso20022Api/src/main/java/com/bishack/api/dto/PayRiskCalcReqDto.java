package com.bishack.api.dto;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PayRiskCalcReqDto {
	// TODO: if we have a good way to find bic then we can populate this automatically. But for now
	// let's just take it from our API consumer.
	@JsonProperty("bic")
	private String bic;
	
	@JsonProperty("creditorAccount")
	private String creditorAccount;
	@JsonProperty("creditorName")
	private String creditorName;
	
	@JsonProperty("uuid")
	private String uuid = UUID.randomUUID().toString();

	@JsonProperty("bic")
	public String getBic() {
		return bic;
	}

	@JsonProperty("bic")
	public void setBic(String bic) {
		this.bic = bic;
	}

	@JsonProperty("creditorAccount")
	public String getCreditorAccount() {
		return creditorAccount;
	}

	@JsonProperty("creditorAccount")
	public void setCreditorAccount(String creditorAccount) {
		this.creditorAccount = creditorAccount;
	}

	@JsonProperty("creditorName")
	public String getCreditorName() {
		return creditorName;
	}

	@JsonProperty("creditorName")
	public void setCreditorName(String creditorName) {
		this.creditorName = creditorName;
	}

	@JsonProperty("uuid")
	public String getUuid() {
		return uuid;
	}

	@JsonProperty("uuid")
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	
}
