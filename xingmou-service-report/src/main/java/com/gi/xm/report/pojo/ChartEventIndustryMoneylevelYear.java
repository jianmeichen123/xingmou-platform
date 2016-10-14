package com.gi.xm.report.pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.sql.Timestamp;
import java.util.Date;

public class ChartEventIndustryMoneylevelYear extends Pojo {

        public static final String ID = "id";
        public static final String YEAR = "年份";
        public static final String INDUSTRY_ID = "一级行业id";
        public static final String INDUSTRY_NAME = "一级行业名称（冗余）";
        public static final String MONEY_LEVEL_ID = "金额等级id";
        public static final String MONEY_LEVEL_TITLE = "金额等级名称（冗余）";
        public static final String MONEY_LEVEL_NUM = "投资笔数";
        public static final String MONEY_LEVEL_CENT = "占比（投资笔数）";
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
	 * @Fields industryId : 一级行业id
	 */
	private Integer industryId;
	
	/**
	 * @Fields industryName : 一级行业名称（冗余）
	 */
	private String industryName;
	
	/**
	 * @Fields moneyLevelId : 金额等级id
	 */
	private Integer moneyLevelId;
	
	/**
	 * @Fields moneyLevelTitle : 金额等级名称（冗余）
	 */
	private String moneyLevelTitle;
	
	/**
	 * @Fields moneyLevelNum : 投资笔数
	 */
	private Integer moneyLevelNum;
	
	/**
	 * @Fields moneyLevelCent : 占比（投资笔数）
	 */
	private Integer moneyLevelCent;
	
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
    
	public Integer getMoneyLevelNum(){
		return moneyLevelNum;
	}

	public void setMoneyLevelNum(Integer moneyLevelNum){
		this.moneyLevelNum = moneyLevelNum;
	}
    
	public Integer getMoneyLevelCent(){
		return moneyLevelCent;
	}

	public void setMoneyLevelCent(Integer moneyLevelCent){
		this.moneyLevelCent = moneyLevelCent;
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