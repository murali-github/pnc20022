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
"correlation_identifier",
"response"
})
public class SwiftPrevalAcVerifyRespDto {

@JsonProperty("correlation_identifier")
private String correlationIdentifier;
@JsonProperty("response")
private Response response;
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

@JsonProperty("response")
public Response getResponse() {
return response;
}

@JsonProperty("response")
public void setResponse(Response response) {
this.response = response;
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