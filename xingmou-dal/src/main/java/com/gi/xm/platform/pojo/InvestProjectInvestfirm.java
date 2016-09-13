package com.gi.xm.platform.pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.sql.Timestamp;
import java.util.Date;

public class InvestProjectInvestfirm extends Pojo {

        public static final String ID = "id";
        public static final String INVEST_ID = "投资事件id";
        public static final String INDUSTRY_ID = "一级行业分类id";
        public static final String INDUSTRY_SUB_ID = "二级行业分类id";
        public static final String YEAR = "year";
        public static final String INVEST_NAME = "投资事件标题(冗余)";
        public static final String PROJECT_ID = "项目id";
        public static final String PROJECT_NAME = "项目名称（冗余）";
        public static final String INVESTFIRM_ID = "投资机构id";
        public static final String INVESTFIRM_NAME = "投资机构名称（冗余）";
        public static final String ADD_TIME = "addTime";
        public static final String UPDATE_TIME = "updateTime";
    
	
	/**
	 * @Fields id : 
	 */
	private Long id;
	
	/**
	 * @Fields investId : 投资事件id
	 */
	private Long investId;
	
	/**
	 * @Fields industryId : 一级行业分类id
	 */
	private Integer industryId;
	
	/**
	 * @Fields industrySubId : 二级行业分类id
	 */
	private Integer industrySubId;
	
	/**
	 * @Fields year : 
	 */
	private Integer year;
	
	/**
	 * @Fields investName : 投资事件标题(冗余)
	 */
	private String investName;
	
	/**
	 * @Fields projectId : 项目id
	 */
	private Long projectId;
	
	/**
	 * @Fields projectName : 项目名称（冗余）
	 */
	private String projectName;
	
	/**
	 * @Fields investfirmId : 投资机构id
	 */
	private Long investfirmId;
	
	/**
	 * @Fields investfirmName : 投资机构名称（冗余）
	 */
	private String investfirmName;
	
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
    
	public Long getInvestId(){
		return investId;
	}

	public void setInvestId(Long investId){
		this.investId = investId;
	}
    
	public Integer getIndustryId(){
		return industryId;
	}

	public void setIndustryId(Integer industryId){
		this.industryId = industryId;
	}
    
	public Integer getIndustrySubId(){
		return industrySubId;
	}

	public void setIndustrySubId(Integer industrySubId){
		this.industrySubId = industrySubId;
	}
    
	public Integer getYear(){
		return year;
	}

	public void setYear(Integer year){
		this.year = year;
	}
    
	public String getInvestName(){
		return investName;
	}

	public void setInvestName(String investName){
		this.investName = investName;
	}
    
	public Long getProjectId(){
		return projectId;
	}

	public void setProjectId(Long projectId){
		this.projectId = projectId;
	}
    
	public String getProjectName(){
		return projectName;
	}

	public void setProjectName(String projectName){
		this.projectName = projectName;
	}
    
	public Long getInvestfirmId(){
		return investfirmId;
	}

	public void setInvestfirmId(Long investfirmId){
		this.investfirmId = investfirmId;
	}
    
	public String getInvestfirmName(){
		return investfirmName;
	}

	public void setInvestfirmName(String investfirmName){
		this.investfirmName = investfirmName;
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