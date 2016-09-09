package com.gi.xm.platform.pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.sql.Timestamp;
import java.util.Date;

public class DataYear extends Pojo {

        public static final String ID = "id";
        public static final String YEAR = "年份";
        public static final String INDUSTRY_ID = "industryId";
        public static final String INDUSTRY_NAME = "industryName";
        public static final String INDUSTRY_SUB_ID = "industrySubId";
        public static final String INDUSTRY_SUB_NAME = "industrySubName";
        public static final String DISTRICT_ID = "districtId";
        public static final String DISTRICT_NAME = "districtName";
        public static final String DISTRICT_SUB_ID = "districtSubId";
        public static final String DISTRICT_SUB_NAME = "districtSubName";
        public static final String ROUND_ID = "roundId";
        public static final String ROUND_NAME = "roundName";
        public static final String MONEY_LEVEL_ID = "moneyLevelId";
        public static final String MONEY_LEVEL_TITLE = "moneyLevelTitle";
        public static final String PROJECT_NUM = "项目数";
        public static final String PROJECT_INVESTED_NUM = "已获投项目数量";
        public static final String INVESTED_MONEY = "融资总额(元)";
        public static final String INVESTED_MONEY_RATE = "融资金额增长率";
        public static final String ADD_TIME = "addTime";
        public static final String UPDATE_TIME = "updateTime";
    
	
	/**
	 * @Fields id : 
	 */
	private Long id;
	
	/**
	 * @Fields year : 年份
	 */
	private Integer year;
	
	/**
	 * @Fields industryId : 
	 */
	private Integer industryId;
	
	/**
	 * @Fields industryName : 
	 */
	private String industryName;
	
	/**
	 * @Fields industrySubId : 
	 */
	private Integer industrySubId;
	
	/**
	 * @Fields industrySubName : 
	 */
	private String industrySubName;
	
	/**
	 * @Fields districtId : 
	 */
	private Integer districtId;
	
	/**
	 * @Fields districtName : 
	 */
	private String districtName;
	
	/**
	 * @Fields districtSubId : 
	 */
	private Integer districtSubId;
	
	/**
	 * @Fields districtSubName : 
	 */
	private String districtSubName;
	
	/**
	 * @Fields roundId : 
	 */
	private Integer roundId;
	
	/**
	 * @Fields roundName : 
	 */
	private String roundName;
	
	/**
	 * @Fields moneyLevelId : 
	 */
	private Integer moneyLevelId;
	
	/**
	 * @Fields moneyLevelTitle : 
	 */
	private String moneyLevelTitle;
	
	/**
	 * @Fields projectNum : 项目数
	 */
	private Integer projectNum;
	
	/**
	 * @Fields projectInvestedNum : 已获投项目数量
	 */
	private Integer projectInvestedNum;
	
	/**
	 * @Fields investedMoney : 融资总额(元)
	 */
	private Long investedMoney;
	
	/**
	 * @Fields investedMoneyRate : 融资金额增长率
	 */
	private Integer investedMoneyRate;
	
	/**
	 * @Fields addTime : 
	 */
	private Timestamp addTime;
	
	/**
	 * @Fields updateTime : 
	 */
	private Timestamp updateTime;
	
    
	public Long getId(){
		return id;
	}

	public void setId(Long id){
		this.id = id;
	}
    
	public Integer getYear(){
		return year;
	}

	public void setYear(Integer year){
		this.year = year;
	}
    
	public Integer getIndustryId(){
		return industryId;
	}

	public void setIndustryId(Integer industryId){
		this.industryId = industryId;
	}
    
	public String getIndustryName(){
		return industryName;
	}

	public void setIndustryName(String industryName){
		this.industryName = industryName;
	}
    
	public Integer getIndustrySubId(){
		return industrySubId;
	}

	public void setIndustrySubId(Integer industrySubId){
		this.industrySubId = industrySubId;
	}
    
	public String getIndustrySubName(){
		return industrySubName;
	}

	public void setIndustrySubName(String industrySubName){
		this.industrySubName = industrySubName;
	}
    
	public Integer getDistrictId(){
		return districtId;
	}

	public void setDistrictId(Integer districtId){
		this.districtId = districtId;
	}
    
	public String getDistrictName(){
		return districtName;
	}

	public void setDistrictName(String districtName){
		this.districtName = districtName;
	}
    
	public Integer getDistrictSubId(){
		return districtSubId;
	}

	public void setDistrictSubId(Integer districtSubId){
		this.districtSubId = districtSubId;
	}
    
	public String getDistrictSubName(){
		return districtSubName;
	}

	public void setDistrictSubName(String districtSubName){
		this.districtSubName = districtSubName;
	}
    
	public Integer getRoundId(){
		return roundId;
	}

	public void setRoundId(Integer roundId){
		this.roundId = roundId;
	}
    
	public String getRoundName(){
		return roundName;
	}

	public void setRoundName(String roundName){
		this.roundName = roundName;
	}
    
	public Integer getMoneyLevelId(){
		return moneyLevelId;
	}

	public void setMoneyLevelId(Integer moneyLevelId){
		this.moneyLevelId = moneyLevelId;
	}
    
	public String getMoneyLevelTitle(){
		return moneyLevelTitle;
	}

	public void setMoneyLevelTitle(String moneyLevelTitle){
		this.moneyLevelTitle = moneyLevelTitle;
	}
    
	public Integer getProjectNum(){
		return projectNum;
	}

	public void setProjectNum(Integer projectNum){
		this.projectNum = projectNum;
	}
    
	public Integer getProjectInvestedNum(){
		return projectInvestedNum;
	}

	public void setProjectInvestedNum(Integer projectInvestedNum){
		this.projectInvestedNum = projectInvestedNum;
	}
    
	public Long getInvestedMoney(){
		return investedMoney;
	}

	public void setInvestedMoney(Long investedMoney){
		this.investedMoney = investedMoney;
	}
    
	public Integer getInvestedMoneyRate(){
		return investedMoneyRate;
	}

	public void setInvestedMoneyRate(Integer investedMoneyRate){
		this.investedMoneyRate = investedMoneyRate;
	}
    
	public Timestamp getAddTime(){
		return addTime;
	}

	public void setAddTime(Timestamp addTime){
		this.addTime = addTime;
	}
    
	public Timestamp getUpdateTime(){
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime){
		this.updateTime = updateTime;
	}
    }