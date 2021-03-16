package com.bishack.api.dto.swiftref.bbantoiban;

import com.bishack.api.dto.BaseDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BbanToIbanResStatus extends BaseDto {
	@JsonProperty("http")
	private Integer httpStatus;
	@JsonProperty("code")
	private String code;
	@JsonProperty("user_message")
	private String userMessage;
	@JsonProperty("more_info")
	private String moreInfo;

	@JsonProperty("http")
	public Integer getHttpStatus() {
		return httpStatus;
	}

	@JsonProperty("http")
	public void setHttpStatus(Integer httpStatus) {
		this.httpStatus = httpStatus;
	}

	@JsonProperty("code")
	public String getCode() {
		return code;
	}

	@JsonProperty("code")
	public void setCode(String code) {
		this.code = code;
	}

	@JsonProperty("user_message")
	public String getUserMessage() {
		return userMessage;
	}

	@JsonProperty("user_message")
	public void setUserMessage(String userMessage) {
		this.userMessage = userMessage;
	}

	@JsonProperty("more_info")
	public String getMoreInfo() {
		return moreInfo;
	}

	@JsonProperty("more_info")
	public void setMoreInfo(String moreInfo) {
		this.moreInfo = moreInfo;
	}

}
