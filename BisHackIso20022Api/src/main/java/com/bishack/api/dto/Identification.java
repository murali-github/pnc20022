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
"identification",
"type",
"issuer",
"short_name"
})
public class Identification {

@JsonProperty("identification")
private String identification;
@JsonProperty("type")
private String type;
@JsonProperty("issuer")
private String issuer;
@JsonProperty("short_name")
private String shortName;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("identification")
public String getIdentification() {
return identification;
}

@JsonProperty("identification")
public void setIdentification(String identification) {
this.identification = identification;
}

@JsonProperty("type")
public String getType() {
return type;
}

@JsonProperty("type")
public void setType(String type) {
this.type = type;
}

@JsonProperty("issuer")
public String getIssuer() {
return issuer;
}

@JsonProperty("issuer")
public void setIssuer(String issuer) {
this.issuer = issuer;
}

@JsonProperty("short_name")
public String getShortName() {
return shortName;
}

@JsonProperty("short_name")
public void setShortName(String shortName) {
this.shortName = shortName;
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