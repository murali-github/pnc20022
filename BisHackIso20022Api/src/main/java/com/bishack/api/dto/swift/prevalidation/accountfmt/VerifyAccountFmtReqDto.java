package com.bishack.api.dto.swift.prevalidation.accountfmt;

import org.springframework.stereotype.Component;

import com.bishack.api.dto.BaseDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Component
public class VerifyAccountFmtReqDto extends BaseDto {
    private static final long serialVersionUID = 1L;
    @JsonProperty("account_identification")
    private String account_identification;
    @JsonProperty("country_code")
    private String country_code;
    @JsonProperty("financial_institution_identification")
    private String financial_institution_identification;

    public String getAccount_identification() {
        return account_identification;
    }

    public void setAccount_identification(String account_identification) {
        this.account_identification = account_identification;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public String getFinancial_institution_identification() {
        return financial_institution_identification;
    }

    public void setFinancial_institution_identification(String financial_institution_identification) {
        this.financial_institution_identification = financial_institution_identification;
    }

    public VerifyAccountFmtReqDto(String account_identification, String country_code,
            String financial_institution_identification) {
        super();
        this.account_identification = account_identification;
        this.country_code = country_code;
        this.financial_institution_identification = financial_institution_identification;
    }

    public VerifyAccountFmtReqDto() {
        super();

    }

}
