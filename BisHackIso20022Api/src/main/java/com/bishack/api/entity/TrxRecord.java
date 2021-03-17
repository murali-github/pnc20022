package com.bishack.api.entity;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class TrxRecord {
    @Id
    String id;

    private String creditorAccount;
    private String creditorName;
    private String creditorIban;
    private String creditorBankId;
    private String creditorBankIdCode;
    private String creditorInstitutionName;
    private String creditorInstitutionId;
    private String creditorCountryCode;

    private String debitorAccount;
    private String debitorName;
    private String debitorIban;
    private String debitorBankId;
    private String debitorBankIdCode;
    private String debitorInstitutionName;
    private String debitorInstitutionId;
    private String debitorCountryCode;

    private String uuid;
    private String amount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreditorAccount() {
        return creditorAccount;
    }

    public void setCreditorAccount(String creditorAccount) {
        this.creditorAccount = creditorAccount;
    }

    public String getCreditorName() {
        return creditorName;
    }

    public void setCreditorName(String creditorName) {
        this.creditorName = creditorName;
    }

    public String getCreditorIban() {
        return creditorIban;
    }

    public void setCreditorIban(String creditorIban) {
        this.creditorIban = creditorIban;
    }

    public String getCreditorBankId() {
        return creditorBankId;
    }

    public void setCreditorBankId(String creditorBankId) {
        this.creditorBankId = creditorBankId;
    }

    public String getCreditorBankIdCode() {
        return creditorBankIdCode;
    }

    public void setCreditorBankIdCode(String creditorBankIdCode) {
        this.creditorBankIdCode = creditorBankIdCode;
    }

    public String getCreditorInstitutionName() {
        return creditorInstitutionName;
    }

    public void setCreditorInstitutionName(String creditorInstitutionName) {
        this.creditorInstitutionName = creditorInstitutionName;
    }

    public String getCreditorInstitutionId() {
        return creditorInstitutionId;
    }

    public void setCreditorInstitutionId(String creditorInstitutionId) {
        this.creditorInstitutionId = creditorInstitutionId;
    }

    public String getCreditorCountryCode() {
        return creditorCountryCode;
    }

    public void setCreditorCountryCode(String creditorCountryCode) {
        this.creditorCountryCode = creditorCountryCode;
    }

    public String getDebitorAccount() {
        return debitorAccount;
    }

    public void setDebitorAccount(String debitorAccount) {
        this.debitorAccount = debitorAccount;
    }

    public String getDebitorName() {
        return debitorName;
    }

    public void setDebitorName(String debitorName) {
        this.debitorName = debitorName;
    }

    public String getDebitorIban() {
        return debitorIban;
    }

    public void setDebitorIban(String debitorIban) {
        this.debitorIban = debitorIban;
    }

    public String getDebitorBankId() {
        return debitorBankId;
    }

    public void setDebitorBankId(String debitorBankId) {
        this.debitorBankId = debitorBankId;
    }

    public String getDebitorBankIdCode() {
        return debitorBankIdCode;
    }

    public void setDebitorBankIdCode(String debitorBankIdCode) {
        this.debitorBankIdCode = debitorBankIdCode;
    }

    public String getDebitorInstitutionName() {
        return debitorInstitutionName;
    }

    public void setDebitorInstitutionName(String debitorInstitutionName) {
        this.debitorInstitutionName = debitorInstitutionName;
    }

    public String getDebitorInstitutionId() {
        return debitorInstitutionId;
    }

    public void setDebitorInstitutionId(String debitorInstitutionId) {
        this.debitorInstitutionId = debitorInstitutionId;
    }

    public String getDebitorCountryCode() {
        return debitorCountryCode;
    }

    public void setDebitorCountryCode(String debitorCountryCode) {
        this.debitorCountryCode = debitorCountryCode;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

}
