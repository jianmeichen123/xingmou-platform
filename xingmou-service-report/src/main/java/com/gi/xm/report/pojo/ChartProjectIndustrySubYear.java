package com.gi.xm.report.pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.sql.Timestamp;
import java.util.Date;

public class ChartProjectIndustrySubYear extends Pojo {

        public static final String ID = "id";
        public static final String YEAR = "年份";
        public static final String INDUSTRY_ID = "一级行业id";
        public static final String INDUSTRY_NAME = "一级行业名称(冗余)";
        public static final String INDUSTRY_SUB_ID = "二级行业id";
        public static final String INDUSTRY_SUB_NAME = "二级行业名称(冗余)";
        public static final String PROJECT_NUM = "项目数";
        public static final String PROJECT_INVESTED_NUM = "已获投项目数(成立项目中)";
        public static final String PROJECT_UNINVESTED_NUM = "未获投项目数";
        public static final String PROJECT_INVESTED_MONEY = "融资总额(元)(成立项目中)";
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
	 * @Fields industryName : 一级行业名称(冗余)
	 */
	private String industryName;
	
	/**
	 * @Fields industrySubId : 二级行业id
	 */
	private Integer industrySubId;
	
	/**
	 * @Fields industrySubName : 二级行业名称(冗余)
	 */
	private String industrySubName;
	
	/**
	 * @Fields projectNum : 项目数
	 */
	private Integer projectNum;
	
	/**
	 * @Fields projectInvestedNum : 已获投项目数(成立项目中)
	 */
	private Integer projectInvestedNum;
	
	/**
	 * @Fields projectUninvestedNum : 未获投项目数
	 */
	private Integer projectUninvestedNum;
	
	/**
	 * @Fields projectInvestedMoney : 融资总额(元)(成立项目中)
	 */
	private Long projectInvestedMoney;
	
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
    
	public Integer getProjectUninvestedNum(){
		return projectUninvestedNum;
	}

	public void setProjectUninvestedNum(Integer projectUninvestedNum){
		this.projectUninvestedNum = projectUninvestedNum;
	}
    
	public Long getProjectInvestedMoney(){
		return projectInvestedMoney;
	}

	public void setProjectInvestedMoney(Long projectInvestedMoney){
		this.projectInvestedMoney = projectInvestedMoney;
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