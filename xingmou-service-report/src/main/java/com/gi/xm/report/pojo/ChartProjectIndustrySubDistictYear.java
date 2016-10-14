package com.gi.xm.report.pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.sql.Timestamp;
import java.util.Date;

public class ChartProjectIndustrySubDistictYear extends Pojo {

        public static final String ID = "id";
        public static final String YEAR = "年份";
        public static final String INDUSTRY_ID = "一级行业id";
        public static final String INDUSTRY_NAME = "一级行业名称（冗余）";
        public static final String INDUSTRY_SUB_ID = "industrySubId";
        public static final String INDUSTRY_SUB_NAME = "industrySubName";
        public static final String DISTRICT_ID = "地区id";
        public static final String DISTRICT_NAME = "地区名称（冗余）";
        public static final String PROJECT_NUM = "成立项目数";
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
	 * @Fields industrySubId : 
	 */
	private Integer industrySubId;
	
	/**
	 * @Fields industrySubName : 
	 */
	private String industrySubName;
	
	/**
	 * @Fields districtId : 地区id
	 */
	private Integer districtId;
	
	/**
	 * @Fields districtName : 地区名称（冗余）
	 */
	private String districtName;
	
	/**
	 * @Fields projectNum : 成立项目数
	 */
	private Integer projectNum;
	
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
    
	public Integer getProjectNum(){
		return projectNum;
	}

	public void setProjectNum(Integer projectNum){
		this.projectNum = projectNum;
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