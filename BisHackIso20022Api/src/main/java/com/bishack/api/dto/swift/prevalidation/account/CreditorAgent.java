package com.bishack.api.dto.swift.prevalidation.account;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "bicfi", "clearing_system_member_identification" })
public class CreditorAgent {
    @JsonProperty("bicfi")
    private String bicfi;
    @JsonProperty("clearing_system_member_identification")
    private ClearingSystemMemberIdentification clearingSystemMemberIdentification;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("bicfi")
    public String getBicfi() {
        return bicfi;
    }

    @JsonProperty("bicfi")
    public void setBicfi(String bicfi) {
        this.bicfi = bicfi;
    }

    @JsonProperty("clearing_system_member_identification")
    public ClearingSystemMemberIdentification getClearingSystemMemberIdentification() {
        return clearingSystemMemberIdentification;
    }

    @JsonProperty("clearing_system_member_identification")
    public void setClearingSystemMemberIdentification(
            ClearingSystemMemberIdentification clearingSystemMemberIdentification) {
        this.clearingSystemMemberIdentification = clearingSystemMemberIdentification;
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