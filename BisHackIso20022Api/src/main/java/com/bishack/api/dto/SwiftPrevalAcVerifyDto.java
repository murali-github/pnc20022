package com.bishack.api.dto;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "correlation_identifier", "context", "uetr", "creditor_account", "creditor_name",
		"creditor_address", "creditor_organisation_identification", "creditor_agent",
		"creditor_agent_branch_identification" })
@JsonRootName(value = "SwiftPrevalAcVerifyDto")
public class SwiftPrevalAcVerifyDto extends BaseDto {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("correlation_identifier")
	private String correlationIdentifier;
	@JsonProperty("context")
	private String context;
	@JsonProperty("uetr")
	private String uetr;
	@JsonProperty("creditor_account")
	private String creditorAccount;
	@JsonProperty("creditor_name")
	private String creditorName;
	@JsonProperty("creditor_address")
	private CreditorAddress creditorAddress;
	@JsonProperty("creditor_organisation_identification")
	private CreditorOrganisationIdentification creditorOrganisationIdentification;
	@JsonProperty("creditor_agent")
	private CreditorAgent creditorAgent;
	@JsonProperty("creditor_agent_branch_identification")
	private String creditorAgentBranchIdentification;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("correlation_identifier")
	public String getCorrelationIdentifier() {
		return correlationIdentifier;
	}

	@JsonProperty("correlation_identifier")
	public void setCorrelationIdentifier(String correlationIdentifier) {
		this.correlationIdentifier = correlationIdentifier;
	}

	@JsonProperty("context")
	public String getContext() {
		return context;
	}

	@JsonProperty("context")
	public void setContext(String context) {
		this.context = context;
	}

	@JsonProperty("uetr")
	public String getUetr() {
		return uetr;
	}

	@JsonProperty("uetr")
	public void setUetr(String uetr) {
		this.uetr = uetr;
	}

	@JsonProperty("creditor_account")
	public String getCreditorAccount() {
		return creditorAccount;
	}

	@JsonProperty("creditor_account")
	public void setCreditorAccount(String creditorAccount) {
		this.creditorAccount = creditorAccount;
	}

	@JsonProperty("creditor_name")
	public String getCreditorName() {
		return creditorName;
	}

	@JsonProperty("creditor_name")
	public void setCreditorName(String creditorName) {
		this.creditorName = creditorName;
	}

	@JsonProperty("creditor_address")
	public CreditorAddress getCreditorAddress() {
		return creditorAddress;
	}

	@JsonProperty("creditor_address")
	public void setCreditorAddress(CreditorAddress creditorAddress) {
		this.creditorAddress = creditorAddress;
	}

	@JsonProperty("creditor_organisation_identification")
	public CreditorOrganisationIdentification getCreditorOrganisationIdentification() {
		return creditorOrganisationIdentification;
	}

	@JsonProperty("creditor_organisation_identification")
	public void setCreditorOrganisationIdentification(
			CreditorOrganisationIdentification creditorOrganisationIdentification) {
		this.creditorOrganisationIdentification = creditorOrganisationIdentification;
	}

	@JsonProperty("creditor_agent")
	public CreditorAgent getCreditorAgent() {
		return creditorAgent;
	}

	@JsonProperty("creditor_agent")
	public void setCreditorAgent(CreditorAgent creditorAgent) {
		this.creditorAgent = creditorAgent;
	}

	@JsonProperty("creditor_agent_branch_identification")
	public String getCreditorAgentBranchIdentification() {
		return creditorAgentBranchIdentification;
	}

	@JsonProperty("creditor_agent_branch_identification")
	public void setCreditorAgentBranchIdentification(String creditorAgentBranchIdentification) {
		this.creditorAgentBranchIdentification = creditorAgentBranchIdentification;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}