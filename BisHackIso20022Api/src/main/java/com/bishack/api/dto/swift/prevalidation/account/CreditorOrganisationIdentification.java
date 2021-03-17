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
@JsonPropertyOrder({ "identification", "common_name", "location_category", "address", "country_code", "scheme_data" })
public class CreditorOrganisationIdentification {
    @JsonProperty("identification")
    private Identification identification;
    @JsonProperty("common_name")
    private String commonName;
    @JsonProperty("location_category")
    private String locationCategory;
    @JsonProperty("address")
    private String address;
    @JsonProperty("country_code")
    private String countryCode;
    @JsonProperty("scheme_data")
    private String schemeData;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("identification")
    public Identification getIdentification() {
        return identification;
    }

    @JsonProperty("identification")
    public void setIdentification(Identification identification) {
        this.identification = identification;
    }

    @JsonProperty("common_name")
    public String getCommonName() {
        return commonName;
    }

    @JsonProperty("common_name")
    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    @JsonProperty("location_category")
    public String getLocationCategory() {
        return locationCategory;
    }

    @JsonProperty("location_category")
    public void setLocationCategory(String locationCategory) {
        this.locationCategory = locationCategory;
    }

    @JsonProperty("address")
    public String getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(String address) {
        this.address = address;
    }

    @JsonProperty("country_code")
    public String getCountryCode() {
        return countryCode;
    }

    @JsonProperty("country_code")
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @JsonProperty("scheme_data")
    public String getSchemeData() {
        return schemeData;
    }

    @JsonProperty("scheme_data")
    public void setSchemeData(String schemeData) {
        this.schemeData = schemeData;
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