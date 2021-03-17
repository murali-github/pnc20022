package com.bishack.api.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bishack.api.service.IServiceConstants;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Component
@JsonRootName(value = "TrxRatingModelDto")
public class TrxRatingModelDto extends BaseDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<TrxRatingModelRequestDto> trxRatingModelRequestDtos;
	private List<TrxRatingModelResponeDto> trxRatingModelResponeDtos;
	
	private List<String> category;

    private List<Integer> score;
	
	private Integer overallScore;
	private BigDecimal trxAmount;

	
	
	public List<TrxRatingModelRequestDto> getTrxRatingModelRequestDtos() {
		return trxRatingModelRequestDtos;
	}

	public void setTrxRatingModelRequestDtos(List<TrxRatingModelRequestDto> trxRatingModelRequestDtos) {
		this.trxRatingModelRequestDtos = trxRatingModelRequestDtos;
	}

	public List<TrxRatingModelResponeDto> getTrxRatingModelResponeDtos() {
		return trxRatingModelResponeDtos;
	}

	public void setTrxRatingModelResponeDtos(List<TrxRatingModelResponeDto> trxRatingModelResponeDtos) {
		this.trxRatingModelResponeDtos = trxRatingModelResponeDtos;
	}

	public List<String> getCategory() {
		return category;
	}

	public void setCategory(List<String> category) {
		this.category = category;
	}

	public List<Integer> getScore() {
		return score;
	}

	public void setScore(List<Integer> score) {
		this.score = score;
	}

	public List<TrxRatingModelRequestDto> getTrxRatingModelRequestDto() {
		return trxRatingModelRequestDtos;
	}

	public void setTrxRatingModelRequestDto(List<TrxRatingModelRequestDto> trxRatingModelRequestDto) {
		this.trxRatingModelRequestDtos = trxRatingModelRequestDto;
	}

	public List<TrxRatingModelResponeDto> getTrxRatingModelResponeDto() {
		return trxRatingModelResponeDtos;
	}

	public void setTrxRatingModelResponeDto(List<TrxRatingModelResponeDto> trxRatingModelResponeDto) {
		this.trxRatingModelResponeDtos = trxRatingModelResponeDto;
	}



	public TrxRatingModelDto() {
		super();
	}

	public Integer getOverallScore() {
		return overallScore;
	}

	public void setOverallScore(Integer overallScore) {
		this.overallScore = overallScore;
	}

	public BigDecimal getTrxAmount() {
		return trxAmount;
	}

	public void setTrxAmount(BigDecimal trxAmount) {
		this.trxAmount = trxAmount;
	}
	
	public static void main(String a[]) throws JsonProcessingException {
		TrxRatingModelDto trxRatingModelDto = new TrxRatingModelDto();
		
		
		
		List<TrxRatingModelRequestDto> trxRatingModelRequestDtos = new ArrayList<>();
		
		List<TrxRatingModelResponeDto> trxRatingModelResponeDtos = new ArrayList<>();
		
		TrxRatingModelRequestDto trxRatingModelRequestDto = null;
		TrxRatingModelResponeDto trxRatingModelResponeDto = null;
		
		trxRatingModelDto.setTrxRatingModelRequestDto(trxRatingModelRequestDtos);
		trxRatingModelDto.setTrxRatingModelResponeDto(trxRatingModelResponeDtos);
		
		
		trxRatingModelDto.setTrxAmount(new BigDecimal(100));
		
		trxRatingModelRequestDto = new TrxRatingModelRequestDto();
		trxRatingModelRequestDtos.add(trxRatingModelRequestDto);
		trxRatingModelRequestDto.setCategory(IServiceConstants.CAT_SWIFT_VALIDATION);
		trxRatingModelRequestDto.setAttrName(IServiceConstants.ATTR_SRC_AC_FORMAT_VALIDATION);		
		trxRatingModelRequestDto.setValue(IServiceConstants.RATING_LEVEL_LOW);
		
		
		trxRatingModelRequestDto = new TrxRatingModelRequestDto();
		trxRatingModelRequestDtos.add(trxRatingModelRequestDto);				
		trxRatingModelRequestDto.setCategory(IServiceConstants.CAT_SWIFT_VALIDATION);
		trxRatingModelRequestDto.setAttrName(IServiceConstants.ATTR_SRC_AC_VERIFICATION);		
		trxRatingModelRequestDto.setValue(IServiceConstants.RATING_LEVEL_LOW);
		
		trxRatingModelRequestDto = new TrxRatingModelRequestDto();
		trxRatingModelRequestDtos.add(trxRatingModelRequestDto);
		trxRatingModelRequestDto.setCategory(IServiceConstants.CAT_SWIFT_COMPLIANCE);
		trxRatingModelRequestDto.setAttrName(IServiceConstants.ATTR_SRC_INST_RISK);		
		trxRatingModelRequestDto.setValue(IServiceConstants.RATING_LEVEL_LOW);
		
		trxRatingModelRequestDto = new TrxRatingModelRequestDto();
		trxRatingModelRequestDtos.add(trxRatingModelRequestDto);
		trxRatingModelRequestDto.setCategory(IServiceConstants.CAT_SWIFT_COMPLIANCE);
		trxRatingModelRequestDto.setAttrName(IServiceConstants.ATTR_BENFICIARY_INST_RISK);		
		trxRatingModelRequestDto.setValue(IServiceConstants.RATING_LEVEL_LOW);
		
		trxRatingModelRequestDto = new TrxRatingModelRequestDto();
		trxRatingModelRequestDtos.add(trxRatingModelRequestDto);
		trxRatingModelRequestDto.setCategory(IServiceConstants.CAT_INTERNAL_TRX_HIST);
		trxRatingModelRequestDto.setAttrName(IServiceConstants.ATTR_SRC_AVG_TRX_AMOUNT);		
		trxRatingModelRequestDto.setValue("200.23");
		
		trxRatingModelRequestDto = new TrxRatingModelRequestDto();
		trxRatingModelRequestDtos.add(trxRatingModelRequestDto);
		trxRatingModelRequestDto.setCategory(IServiceConstants.CAT_INTERNAL_TRX_HIST);
		trxRatingModelRequestDto.setAttrName(IServiceConstants.ATTR_SRC_TOTAL_TRX_AMOUNT);		
		trxRatingModelRequestDto.setValue("20000");
		
		
		trxRatingModelRequestDto = new TrxRatingModelRequestDto();
		trxRatingModelRequestDtos.add(trxRatingModelRequestDto);
		trxRatingModelRequestDto.setCategory(IServiceConstants.CAT_INTERNAL_COMPLIANCE);
		trxRatingModelRequestDto.setAttrName(IServiceConstants.ATTR_HIGH_RISK_BENE_CNTRY);		
		trxRatingModelRequestDto.setValue("AZ, AY, AX");
		
		
		trxRatingModelResponeDto = new TrxRatingModelResponeDto();
		trxRatingModelResponeDtos.add(trxRatingModelResponeDto);
		trxRatingModelResponeDto.setCategory(IServiceConstants.CAT_SWIFT_VALIDATION);
		trxRatingModelResponeDto.setScore(5);
		
		trxRatingModelResponeDto = new TrxRatingModelResponeDto();
		trxRatingModelResponeDtos.add(trxRatingModelResponeDto);
		trxRatingModelResponeDto.setCategory(IServiceConstants.CAT_SWIFT_COMPLIANCE);
		trxRatingModelResponeDto.setScore(6);
		
		trxRatingModelResponeDto = new TrxRatingModelResponeDto();
		trxRatingModelResponeDtos.add(trxRatingModelResponeDto);
		trxRatingModelResponeDto.setCategory(IServiceConstants.CAT_INTERNAL_COMPLIANCE);
		trxRatingModelResponeDto.setScore(5);
		
		trxRatingModelResponeDto = new TrxRatingModelResponeDto();
		trxRatingModelResponeDtos.add(trxRatingModelResponeDto);
		trxRatingModelResponeDto.setCategory(IServiceConstants.CAT_INTERNAL_TRX_HIST);
		trxRatingModelResponeDto.setScore(7);
		
		trxRatingModelDto.setOverallScore(6);
		
		ObjectMapper objMapper = new ObjectMapper();
		String jsonString = objMapper.writeValueAsString(trxRatingModelDto);
		System.out.println(jsonString);

		
	}
}
