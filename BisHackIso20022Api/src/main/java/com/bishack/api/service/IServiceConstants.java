package com.bishack.api.service;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public interface IServiceConstants {

    String RATING_LEVEL_LOW = "LOW";
    String RATING_LEVEL_MEDIUM = "MEDIUM";
    String RATING_LEVEL_HIGH = "HIGH";

    String RATING_REC_PROCEED = "PROCEED";
    String RATING_REC_REVIEW = "REVIEW";
    String RATING_REC_REJECT = "REJECT";

    String CAT_SWIFT_VALIDATION = "SWIFT_VALIDATION";
    String CAT_SWIFT_COMPLIANCE = "SWIFT_COMPLIANCE";
    String CAT_INTERNAL_TRX_HIST = "INTERNAL_TRX_HIST";
    String CAT_INTERNAL_COMPLIANCE = "INTERNAL_COMPLIANCE";
    String CAT_OVERALL_SCORE = "OVERALL_SCORE";
    String CAT_CURRENT_TRX = "CURRENT_TRX";

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
    
    String ATTR_BENEFICIARY_AC = "BENEFICIARY_AC";
    String ATTR_SRC_AC = "SRC_AC";
    String ATTR_AMOUNT = "AMOUNT";


    List<String> BBAN_AC_FORMAT_LOW = Arrays.asList("123110040000109876543210", "500105170123456789");
    List<String> BBAN_AC_VERIFY_LOW = Arrays.asList("123110040000109876543210", "500105170123456789");

    List<String> BBAN_AC_VERIFY_MEDIUM = Arrays.asList("100000010123123123");
    List<String> BBAN_AC_FORMAT_MEDIUM = Arrays.asList("100000010123123123");

    List<String> BBAN_AC_VERIFY_HIGH = Arrays.asList("100000010123123124");
    List<String> BBAN_AC_FORMAT_HIGH = Arrays.asList("100000010123123124");    

    List<String> VALID_AC_NUMBERS = Arrays.asList("123110040000109876543210", "500105170123456789",
            "100000010123123123", "100000010123123124");
    
    
    
public enum DataAggEnum {
		
		
		LOW_RISK_AC_1("123110040000109876543210", "2000", "20000", "20210101", "20210331", "LOW", "LOW", "AW,AZ"),
		LOW_RISK_AC_2("500105170123456789", "1500", "100000", "20210101", "20210331", "LOW", "LOW", "BA,BB"),
		MEDIUM_RISK_AC_1("100000010123123123", "500", "250000", "20210101", "20210331", "MEDIUM", "MEDIUM", "CG,CK"), 
		HIGH_RISK_AC_1("100000010123123124", "1000", "10000", "20210101", "20210331", "HIGH", "HIGH", "GI,GP");
	

		
		private String acNum;
		private String avgTrx; 
		private String totalTrx;
		private String startDt;
		private String endDt;
		private String acFormatLevel;
		private String acVerifyLevel;
		private String highRiskBeneCntry;
		
		public String getAcNum() {
			return acNum;
		}
		public void setAcNum(String acNum) {
			this.acNum = acNum;
		}
		public String getAvgTrx() {
			return avgTrx;
		}
		public void setAvgTrx(String avgTrx) {
			this.avgTrx = avgTrx;
		}
		public String getTotalTrx() {
			return totalTrx;
		}
		public void setTotalTrx(String totalTrx) {
			this.totalTrx = totalTrx;
		}
		public String getStartDt() {
			return startDt;
		}
		public void setStartDt(String startDt) {
			this.startDt = startDt;
		}
		public String getEndDt() {
			return endDt;
		}
		public void setEndDt(String endDt) {
			this.endDt = endDt;
		}
		public String getAcFormatLevel() {
			return acFormatLevel;
		}
		public void setAcFormatLevel(String acFormatLevel) {
			this.acFormatLevel = acFormatLevel;
		}
		public String getAcVerifyLevel() {
			return acVerifyLevel;
		}
		public void setAcVerifyLevel(String acVerifyLevel) {
			this.acVerifyLevel = acVerifyLevel;
		}		
		public String getHighRiskBeneCntry() {
			return highRiskBeneCntry;
		}
		public void setHighRiskBeneCntry(String highRiskBeneCntry) {
			this.highRiskBeneCntry = highRiskBeneCntry;
		}
		
		
		private DataAggEnum(String acNum, String avgTrx, String totalTrx, String startDt, String endDt,
				String acFormatLevel, String acVerifyLevel, String highRiskBeneCntry) {
			this.acNum = acNum;
			this.avgTrx = avgTrx;
			this.totalTrx = totalTrx;
			this.startDt = startDt;
			this.endDt = endDt;
			this.acFormatLevel = acFormatLevel;
			this.acVerifyLevel = acVerifyLevel;
			this.highRiskBeneCntry = highRiskBeneCntry;
		}
		public static String getAvgTrx(String acNum) {
			String avgTrx = "2000";
			for (DataAggEnum dataAggEnum : DataAggEnum.values()) {
				if (StringUtils.equalsIgnoreCase(dataAggEnum.acNum, acNum)) {
					avgTrx = dataAggEnum.getAvgTrx();
				}
			}
			return avgTrx;
		}
		
		public static String getTotalTrx(String acNum) {
			String totalTrx = "20000";
			for (DataAggEnum dataAggEnum : DataAggEnum.values()) {
				if (StringUtils.equalsIgnoreCase(dataAggEnum.acNum, acNum)) {
					totalTrx = dataAggEnum.getTotalTrx();
				}
			}
			return totalTrx;
		}
		
		public static String getHighRiskBeneCntry(String acNum) {
			String highRiskBeneCntry = "AB, AC";
			for (DataAggEnum dataAggEnum : DataAggEnum.values()) {
				if (StringUtils.equalsIgnoreCase(dataAggEnum.acNum, acNum)) {
					highRiskBeneCntry = dataAggEnum.getHighRiskBeneCntry();
				}
			}
			return highRiskBeneCntry;
		}

		/*public static List<String> getMembers() {
			List<String> members = new ArrayList<String>();
			for (DataAggEnum portfolioSubSegDefEnum : DataAggEnum.values()) {
				members.add(portfolioSubSegDefEnum.getClasFinRecDesc());
			}
			CollectionUtils.filter(members, PredicateUtils.notNullPredicate());
			return members;
		}
		
		*//**
		 * @return
		 *//*
		public static Map<String, String> getCofrPrtfSubSegMap() {
			Map<String, String> cofrPrtfSubSegMap = new LinkedHashMap<String, String>();
			for (DataAggEnum portfolioSubSegDefEnum : DataAggEnum.values()) {
				cofrPrtfSubSegMap.put(portfolioSubSegDefEnum.getClasFinRecDesc(), portfolioSubSegDefEnum.getPrtfSubSgmntCdVldVal());
			}
			return cofrPrtfSubSegMap;
		}*/
	}
	

}
