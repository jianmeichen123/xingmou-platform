package com.gi.xm.report.pojo;

import java.sql.Timestamp;

public class ChartDataIndustry extends Pojo {

	
	/**
	 * @Fields id : 
	 */
	private Long id;
	
	/**
	 * @Fields industryId : 
	 */
	private Integer industryId;
	
	/**
	 * @Fields industryName : 
	 */
	private String industryName;
	
	/**
	 * @Fields projectNum : 
	 */
	private Integer projectNum;
	
	/**
	 * @Fields investedNum : 
	 */
	private Integer investedNum;
	
	/**
	 * @Fields investedMoney : 
	 */
	private Long investedMoney;
	
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
    
	public Integer getProjectNum(){
		return projectNum;
	}

	public void setProjectNum(Integer projectNum){
		this.projectNum = projectNum;
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