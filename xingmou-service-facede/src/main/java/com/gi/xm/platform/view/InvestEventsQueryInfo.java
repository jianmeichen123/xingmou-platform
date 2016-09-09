package com.gi.xm.platform.view;

import java.util.Date;
import java.math.BigDecimal;
import java.io.Serializable;
import java.sql.Timestamp;
import com.gi.xm.platform.view.common.QueryInfo;

public class InvestEventsQueryInfo extends QueryInfo {
	
	/**   
	 * @Fields serialVersionUID : 序列化版本号 
	 */ 
	private static final long serialVersionUID = 1L;

	
	private Long id;
	
	private String title;
	
	private Long projectId;
	
	private String investMoney;
	
	private String money;
	
	private BigDecimal moneyNum;
	
	private Long currencyId;
	
	private String currencyTitle;
	
	private String currencyCode;
	
	private Date investDate;
	
	private Long roundId;
	
	private String roundName;
	
	private Long districtId;
	
	private String districtName;
	
	private Long districtSubId;
	
	private String districtSubName;
	
	private Long industryId;
	
	private String industryName;
	
	private Long industrySubId;
	
	private String industrySubName;
	
	private String investPer;
	
	private String investfirmNames;
	
	private Timestamp addTime;
	
	private Timestamp updateTime;
		
    
	public Long getId(){
		return id;
	}
	
	public void setId(Long id){
		this.id = id;
	}
    
	public String getTitle(){
		return title;
	}
	
	public void setTitle(String title){
		this.title = title;
	}
    
	public Long getProjectId(){
		return projectId;
	}
	
	public void setProjectId(Long projectId){
		this.projectId = projectId;
	}
    
	public String getInvestMoney(){
		return investMoney;
	}
	
	public void setInvestMoney(String investMoney){
		this.investMoney = investMoney;
	}
    
	public String getMoney(){
		return money;
	}
	
	public void setMoney(String money){
		this.money = money;
	}
    
	public BigDecimal getMoneyNum(){
		return moneyNum;
	}
	
	public void setMoneyNum(BigDecimal moneyNum){
		this.moneyNum = moneyNum;
	}
    
	public Long getCurrencyId(){
		return currencyId;
	}
	
	public void setCurrencyId(Long currencyId){
		this.currencyId = currencyId;
	}
    
	public String getCurrencyTitle(){
		return currencyTitle;
	}
	
	public void setCurrencyTitle(String currencyTitle){
		this.currencyTitle = currencyTitle;
	}
    
	public String getCurrencyCode(){
		return currencyCode;
	}
	
	public void setCurrencyCode(String currencyCode){
		this.currencyCode = currencyCode;
	}
    
	public Date getInvestDate(){
		return investDate;
	}
	
	public void setInvestDate(Date investDate){
		this.investDate = investDate;
	}
    
	public Long getRoundId(){
		return roundId;
	}
	
	public void setRoundId(Long roundId){
		this.roundId = roundId;
	}
    
	public String getRoundName(){
		return roundName;
	}
	
	public void setRoundName(String roundName){
		this.roundName = roundName;
	}
    
	public Long getDistrictId(){
		return districtId;
	}
	
	public void setDistrictId(Long districtId){
		this.districtId = districtId;
	}
    
	public String getDistrictName(){
		return districtName;
	}
	
	public void setDistrictName(String districtName){
		this.districtName = districtName;
	}
    
	public Long getDistrictSubId(){
		return districtSubId;
	}
	
	public void setDistrictSubId(Long districtSubId){
		this.districtSubId = districtSubId;
	}
    
	public String getDistrictSubName(){
		return districtSubName;
	}
	
	public void setDistrictSubName(String districtSubName){
		this.districtSubName = districtSubName;
	}
    
	public Long getIndustryId(){
		return industryId;
	}
	
	public void setIndustryId(Long industryId){
		this.industryId = industryId;
	}
    
	public String getIndustryName(){
		return industryName;
	}
	
	public void setIndustryName(String industryName){
		this.industryName = industryName;
	}
    
	public Long getIndustrySubId(){
		return industrySubId;
	}
	
	public void setIndustrySubId(Long industrySubId){
		this.industrySubId = industrySubId;
	}
    
	public String getIndustrySubName(){
		return industrySubName;
	}
	
	public void setIndustrySubName(String industrySubName){
		this.industrySubName = industrySubName;
	}
    
	public String getInvestPer(){
		return investPer;
	}
	
	public void setInvestPer(String investPer){
		this.investPer = investPer;
	}
    
	public String getInvestfirmNames(){
		return investfirmNames;
	}
	
	public void setInvestfirmNames(String investfirmNames){
		this.investfirmNames = investfirmNames;
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