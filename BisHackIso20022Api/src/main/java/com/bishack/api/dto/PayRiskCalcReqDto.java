package com.bishack.api.dto;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PayRiskCalcReqDto {
	@JsonProperty("institutionName")
	private String institutionName;
	@JsonProperty("creditorAccount")
	private String creditorAccount;
	@JsonProperty("creditorName")
	private String creditorName;
	@JsonProperty("amount")
	private String amount;
	
	@JsonProperty("uuid")
	private String uuid = UUID.randomUUID().toString();

	@JsonProperty("institutionName")
	public String getInstitutionName() {
		return institutionName;
	}

	@JsonProperty("institutionName")
	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
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

	@JsonProperty("amount")
	public String getAmount() {
		return amount;
	}

	@JsonProperty("amount")
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	
}
