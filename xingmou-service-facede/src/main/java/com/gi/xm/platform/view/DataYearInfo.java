package com.gi.xm.platform.view;

import java.math.BigDecimal;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class DataYearInfo implements Serializable {

	/**   
	 * @Fields serialVersionUID : 序列化版本号 
	 */ 
	private static final long serialVersionUID = 1L;

			
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