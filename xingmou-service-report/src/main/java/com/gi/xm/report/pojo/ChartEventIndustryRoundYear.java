package com.gi.xm.report.pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.sql.Timestamp;
import java.util.Date;

public class ChartEventIndustryRoundYear extends Pojo {

        public static final String ID = "id";
        public static final String YEAR = "年份";
        public static final String INDUSTRY_ID = "一级行业id";
        public static final String INDUSTRY_NAME = "一级行业名称（冗余）";
        public static final String ROUND_ID = "轮次id";
        public static final String ROUND_NAME = "轮次名称（冗余）";
        public static final String INVESTED_NUM = "投资笔数";
        public static final String INVESTED_MONEY = "投资总额(元)";
        public static final String PROJECT_INVESTED_NUM = "投资项目数";
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
	 * @Fields roundId : 轮次id
	 */
	private Integer roundId;
	
	/**
	 * @Fields roundName : 轮次名称（冗余）
	 */
	private String roundName;
	
	/**
	 * @Fields investedNum : 投资笔数
	 */
	private Integer investedNum;
	
	/**
	 * @Fields investedMoney : 投资总额(元)
	 */
	private Long investedMoney;
	
	/**
	 * @Fields projectInvestedNum : 投资项目数
	 */
	private Integer projectInvestedNum;
	
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
    
	public Integer getInvestedNum(){
		return investedNum;
	}

	public void setInvestedNum(Integer investedNum){
		this.investedNum = investedNum;
	}
    
	public Long getInvestedMoney(){
		return investedMoney;
	}

	public void setInvestedMoney(Long investedMoney){
		this.investedMoney = investedMoney;
	}
    
	public Integer getProjectInvestedNum(){
		return projectInvestedNum;
	}

	public void setProjectInvestedNum(Integer projectInvestedNum){
		this.projectInvestedNum = projectInvestedNum;
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