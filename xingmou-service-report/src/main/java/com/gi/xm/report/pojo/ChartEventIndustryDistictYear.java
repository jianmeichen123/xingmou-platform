package com.gi.xm.report.pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.sql.Timestamp;
import java.util.Date;

public class ChartEventIndustryDistictYear extends Pojo {

        public static final String ID = "id";
        public static final String YEAR = "年份";
        public static final String INDUSTRY_ID = "一级行业id";
        public static final String INDUSTRY_NAME = "一级行业名称（冗余）";
        public static final String DISTRICT_ID = "地区id";
        public static final String DISTRICT_NAME = "地区名称（冗余）";
        public static final String INVESTED_NUM = "投资笔数";
        public static final String INVESTED_MONEY = "投资总额（元）";
        public static final String INVESTED_NUM_CENT = "占比（投资笔数）";
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
	 * @Fields districtId : 地区id
	 */
	private Integer districtId;
	
	/**
	 * @Fields districtName : 地区名称（冗余）
	 */
	private String districtName;
	
	/**
	 * @Fields investedNum : 投资笔数
	 */
	private Integer investedNum;
	
	/**
	 * @Fields investedMoney : 投资总额（元）
	 */
	private Long investedMoney;
	
	/**
	 * @Fields investedNumCent : 占比（投资笔数）
	 */
	private Integer investedNumCent;
	
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
    
	public Integer getInvestedNumCent(){
		return investedNumCent;
	}

	public void setInvestedNumCent(Integer investedNumCent){
		this.investedNumCent = investedNumCent;
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