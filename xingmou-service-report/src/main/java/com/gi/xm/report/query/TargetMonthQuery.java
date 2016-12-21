package com.gi.xm.report.query;

import com.gi.xm.platform.view.common.QueryInfo;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class TargetMonthQuery extends QueryInfo {
	
	/**   
	 * @Fields serialVersionUID : 序列化版本号 
	 */ 
	private static final long serialVersionUID = 1L;
	
			
	private Integer id;
			
	private Integer year;
			
	private Integer month;
			
	private Integer industryId;
			
	private String industryName;
			
	private Integer industrySubId;
			
	private String industrySubName;
			
	private Integer districtId;
			
	private String districtName;
			
	private Integer investNum;
			
	private Long investMoney;
			
	private Integer createNum;
			
	private Integer activeInvestfirmNum;
			
	private Integer industryType;
			
	private Integer hasYm;
			
	private Integer hasDistict;
			
	private Timestamp addTime;
			
	private Timestamp updateTime;
		
    
	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id = id;
	}
    
	public Integer getYear(){
		return year;
	}
	public void setYear(Integer year){
		this.year = year;
	}
    
	public Integer getMonth(){
		return month;
	}
	public void setMonth(Integer month){
		this.month = month;
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
    
	public Integer getInvestNum(){
		return investNum;
	}
	public void setInvestNum(Integer investNum){
		this.investNum = investNum;
	}
    
	public Long getInvestMoney(){
		return investMoney;
	}
	public void setInvestMoney(Long investMoney){
		this.investMoney = investMoney;
	}
    
	public Integer getCreateNum(){
		return createNum;
	}
	public void setCreateNum(Integer createNum){
		this.createNum = createNum;
	}
    
	public Integer getActiveInvestfirmNum(){
		return activeInvestfirmNum;
	}
	public void setActiveInvestfirmNum(Integer activeInvestfirmNum){
		this.activeInvestfirmNum = activeInvestfirmNum;
	}
    
	public Integer getIndustryType(){
		return industryType;
	}
	public void setIndustryType(Integer industryType){
		this.industryType = industryType;
	}
    
	public Integer getHasYm(){
		return hasYm;
	}
	public void setHasYm(Integer hasYm){
		this.hasYm = hasYm;
	}
    
	public Integer getHasDistict(){
		return hasDistict;
	}
	public void setHasDistict(Integer hasDistict){
		this.hasDistict = hasDistict;
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