package com.gi.ctdn.pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.sql.Timestamp;
import java.util.Date;

public class IndustryLabel extends CtdnPojo {

        public static final String SUB_INDUSTRY_ID = "subIndustryId";
        public static final String SUB_INDUSTRY_NAME = "subIndustryName";
        public static final String LABEL_NAME = "labelName";
        public static final String TFIDF_VALUE = "tfidfValue";
    
	
	/**
	 * @Fields subIndustryId : 
	 */
	private Integer subIndustryId;
	
	/**
	 * @Fields subIndustryName : 
	 */
	private String subIndustryName;
	
	/**
	 * @Fields labelName : 
	 */
	private String labelName;
	
	/**
	 * @Fields tfidfValue : 
	 */
	private Integer tfidfValue;


	public void setSubIndustryId(Integer subIndustryId) {
		this.subIndustryId = subIndustryId;
	}

	public  Integer getSubIndustryId() {
		return subIndustryId;
	}

	public String getSubIndustryName(){
		return subIndustryName;
	}

	public void setSubIndustryName(String subIndustryName){
		this.subIndustryName = subIndustryName;
	}
    
	public String getLabelName(){
		return labelName;
	}

	public void setLabelName(String labelName){
		this.labelName = labelName;
	}

	public void setTfidfValue(Integer tfidfValue) {
		this.tfidfValue = tfidfValue;
	}

	public  Integer getTfidfValue() {
		return tfidfValue;
	}
}