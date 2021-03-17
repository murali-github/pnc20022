package com.bishack.api.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public interface IServiceConstants {
	
	
	String RATING_REC_PROCEED = "PROCEED";
	String RATING_REC_REVIEW = "REVIEW";
	String RATING_REC_REJECT = "REJECT";
	
	String RATING_LEVEL_LOW = "LOW";
	String RATING_LEVEL_MEDIUM = "MEDIUM";
	String RATING_LEVEL_HIGH = "HIGH";
	
	String CAT_SWIFT_VALIDATION = "SWIFT_VALIDATION";
	String CAT_SWIFT_COMPLIANCE = "SWIFT_COMPLIANCE";
	String CAT_INTERNAL_TRX_HIST = "INTERNAL_TRX_HIST";
	String CAT_INTERNAL_COMPLIANCE = "INTERNAL_COMPLIANCE";
	
	String ATTR_SRC_AC_FORMAT_VALIDATION = "SRC_AC_FORMAT";
	String ATTR_SRC_AC_VERIFICATION = "SRC_AC_VERIFICATION";
	String ATTR_BENE_AC_FORMAT_VALIDATION = "BENEFICIARY_AC_FORMAT";
	String ATTR_BENE_AC_VERIFICATION = "BENEFICIARY_AC_VERIFICATION";
	String ATTR_TRX_AMOUNT = "TRX_AMOUNT";
	String ATTR_BENFICIARY_INST_RISK = "BENEFICIARY_INST_RISK";
	String ATTR_SRC_INST_RISK = "SRC_INST_RISK";
	
	String ATTR_SRC_AVG_TRX_AMOUNT = "SRC_AVG_TRX_AMOUNT";
	String ATTR_SRC_TOTAL_TRX_AMOUNT = "SRC_TOTAL_TRX_AMOUNT";	
	String ATTR_HIGH_RISK_BENE_CNTRY = "HIGH_RISK_BENE_CNTRY";	
	
	List<String> BBAN_AC_FORMAT_LOW = Arrays.asList("123110040000109876543210", "500105170123456789");
	List<String> BBAN_AC_VERIFY_LOW = Arrays.asList("123110040000109876543210", "500105170123456789");
	
	List<String> BBAN_AC_VERIFY_MEDIUM = Arrays.asList("100000010123123123");
	List<String> BBAN_AC_FORMAT_MEDIUM = Arrays.asList("100000010123123123");
	
	List<String> BBAN_AC_VERIFY_HIGH = Arrays.asList("");
	List<String> BBAN_AC_FORMAT_HIGH = Arrays.asList("");
	
	List<String> VALID_AC_NUMBERS = Arrays.asList("123110040000109876543210", "DE41500105170123456789", "DE39100000010123123123");


}
