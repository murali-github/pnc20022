package com.bishack.api.dto.swift.prevalidation.accountfmt;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bishack.api.dto.BaseDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Component
public class VerifyAccountFmtRespDto extends BaseDto {
    private static final long serialVersionUID = 1L;

    @JsonProperty("account_identification")
    private AccountIdentification accountIdentification;

    @JsonProperty("status")
    private String status;

    @JsonProperty("reason")
    private List<String> reason = new ArrayList<>();

    @JsonProperty("validation_check")
    private List<ValidationCheck> validationChecks = new ArrayList<>();

    public AccountIdentification getAccountIdentification() {
        return accountIdentification;
    }

    public void setAccountIdentification(AccountIdentification accountIdentification) {
        this.accountIdentification = accountIdentification;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<String> getReason() {
        return reason;
    }

    public void setReason(List<String> reason) {
        this.reason = reason;
    }

    public List<ValidationCheck> getValidationChecks() {
        return new ArrayList<>(validationChecks);
    }

    public void setValidationChecks(List<ValidationCheck> validationChecks) {
        this.validationChecks = new ArrayList<>(validationChecks);
    }

}
