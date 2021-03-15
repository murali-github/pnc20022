package com.bishack.api.dto;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"account_validation_status",
"creditor_account_match",
"creditor_name_match",
"creditor_address_match",
"creditor_organisation_identification_match",
"validation_source"
})
public class Response {

@JsonProperty("account_validation_status")
private String accountValidationStatus;
@JsonProperty("creditor_account_match")
private String creditorAccountMatch;
@JsonProperty("creditor_name_match")
private String creditorNameMatch;
@JsonProperty("creditor_address_match")
private String creditorAddressMatch;
@JsonProperty("creditor_organisation_identification_match")
private String creditorOrganisationIdentificationMatch;
@JsonProperty("validation_source")
private String validationSource;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("account_validation_status")
public String getAccountValidationStatus() {
return accountValidationStatus;
}

@JsonProperty("account_validation_status")
public void setAccountValidationStatus(String accountValidationStatus) {
this.accountValidationStatus = accountValidationStatus;
}

@JsonProperty("creditor_account_match")
public String getCreditorAccountMatch() {
return creditorAccountMatch;
}

@JsonProperty("creditor_account_match")
public void setCreditorAccountMatch(String creditorAccountMatch) {
this.creditorAccountMatch = creditorAccountMatch;
}

@JsonProperty("creditor_name_match")
public String getCreditorNameMatch() {
return creditorNameMatch;
}

@JsonProperty("creditor_name_match")
public void setCreditorNameMatch(String creditorNameMatch) {
this.creditorNameMatch = creditorNameMatch;
}

@JsonProperty("creditor_address_match")
public String getCreditorAddressMatch() {
return creditorAddressMatch;
}

@JsonProperty("creditor_address_match")
public void setCreditorAddressMatch(String creditorAddressMatch) {
this.creditorAddressMatch = creditorAddressMatch;
}

@JsonProperty("creditor_organisation_identification_match")
public String getCreditorOrganisationIdentificationMatch() {
return creditorOrganisationIdentificationMatch;
}

@JsonProperty("creditor_organisation_identification_match")
public void setCreditorOrganisationIdentificationMatch(String creditorOrganisationIdentificationMatch) {
this.creditorOrganisationIdentificationMatch = creditorOrganisationIdentificationMatch;
}

@JsonProperty("validation_source")
public String getValidationSource() {
return validationSource;
}

@JsonProperty("validation_source")
public void setValidationSource(String validationSource) {
this.validationSource = validationSource;
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