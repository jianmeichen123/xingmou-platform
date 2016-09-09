package com.gi.xm.platform.query;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class IndustryDataYearQuery extends Query {
	
	/**   
	 * @Fields serialVersionUID : 序列化版本号 
	 */ 
	private static final long serialVersionUID = 1L;
	
			
	private Long id;
			
	private Integer yaar;
			
	private Integer industryId;
			
	private String industryName;
			
	private Integer industrySubId;
			
	private String industrySubName;
			
	private BigDecimal marketMoney;
			
	private Double marketMoneyRate;
			
	private Long marketUser;
			
	private Integer marketUserRate;
			
	private Long singleUserValue;
			
	private Long marketMoneyStock;
			
	private Integer projectNum;
			
	private Integer investedNum;
			
	private Integer investedNumRate;
			
	private Long investedMoney;
			
	private Integer investedMoneyRate;
			
	private Long investedPerMoney;
			
	private Long investedMedianMoney;
			
	private Long investedMaxMoney;
			
	private Timestamp addTime;
			
	private Timestamp updateTime;
		
    
	public Long getId(){
		return id;
	}
	public void setId(Long id){
		this.id = id;
	}
    
	public Integer getYaar(){
		return yaar;
	}
	public void setYaar(Integer yaar){
		this.yaar = yaar;
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
    
	public BigDecimal getMarketMoney(){
		return marketMoney;
	}
	public void setMarketMoney(BigDecimal marketMoney){
		this.marketMoney = marketMoney;
	}
    
	public Double getMarketMoneyRate(){
		return marketMoneyRate;
	}
	public void setMarketMoneyRate(Double marketMoneyRate){
		this.marketMoneyRate = marketMoneyRate;
	}
    
	public Long getMarketUser(){
		return marketUser;
	}
	public void setMarketUser(Long marketUser){
		this.marketUser = marketUser;
	}
    
	public Integer getMarketUserRate(){
		return marketUserRate;
	}
	public void setMarketUserRate(Integer marketUserRate){
		this.marketUserRate = marketUserRate;
	}
    
	public Long getSingleUserValue(){
		return singleUserValue;
	}
	public void setSingleUserValue(Long singleUserValue){
		this.singleUserValue = singleUserValue;
	}
    
	public Long getMarketMoneyStock(){
		return marketMoneyStock;
	}
	public void setMarketMoneyStock(Long marketMoneyStock){
		this.marketMoneyStock = marketMoneyStock;
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
    
	public Integer getInvestedNumRate(){
		return investedNumRate;
	}
	public void setInvestedNumRate(Integer investedNumRate){
		this.investedNumRate = investedNumRate;
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
    
	public Long getInvestedPerMoney(){
		return investedPerMoney;
	}
	public void setInvestedPerMoney(Long investedPerMoney){
		this.investedPerMoney = investedPerMoney;
	}
    
	public Long getInvestedMedianMoney(){
		return investedMedianMoney;
	}
	public void setInvestedMedianMoney(Long investedMedianMoney){
		this.investedMedianMoney = investedMedianMoney;
	}
    
	public Long getInvestedMaxMoney(){
		return investedMaxMoney;
	}
	public void setInvestedMaxMoney(Long investedMaxMoney){
		this.investedMaxMoney = investedMaxMoney;
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