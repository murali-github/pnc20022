package com.bishack.api.entity;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class TrxRecord {
	@Id
	String id;
	private String institutionName;
	private String creditorAccount;
	private String creditorName;
	private String uuid;
	private String amount;
	private String institutionId;
	private String countryCode;
	private String iban;
	private String bankId;
	private String bankIdCode;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getInstitutionName() {
		return institutionName;
	}

	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
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

	public String getInstitutionId() {
		return institutionId;
	}

	public void setInstitutionId(String institutionId) {
		this.institutionId = institutionId;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public String getBankId() {
		return bankId;
	}

	public void setBankId(String bankId) {
		this.bankId = bankId;
	}

	public String getBankIdCode() {
		return bankIdCode;
	}

	public void setBankIdCode(String bankIdCode) {
		this.bankIdCode = bankIdCode;
	}

}
