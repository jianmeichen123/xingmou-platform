package com.gi.xm.platform.view;

import java.math.BigDecimal;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class InvestEventsInfo implements Serializable {

	/**   
	 * @Fields serialVersionUID : 序列化版本号 
	 */ 
	private static final long serialVersionUID = 1L;

			
	/**
	 * @Fields id : 
	 */
	private Long id;
			
	/**
	 * @Fields title : 标题
	 */
	private String title;
			
	/**
	 * @Fields projectId : 项目id，关联:dm_project.id
	 */
	private Long projectId;
			
	/**
	 * @Fields investMoney : 投资金额
	 */
	private String investMoney;
			
	/**
	 * @Fields money : 处理后投资金额
	 */
	private String money;
			
	/**
	 * @Fields moneyNum : 具体金额,处理了汇率
	 */
	private BigDecimal moneyNum;
			
	/**
	 * @Fields currencyId : 货币id
	 */
	private Long currencyId;
			
	/**
	 * @Fields currencyTitle : 冗余：货币名称
	 */
	private String currencyTitle;
			
	/**
	 * @Fields currencyCode : 冗余：货币code
	 */
	private String currencyCode;
			
	/**
	 * @Fields investDate : 投资日期
	 */
	private Date investDate;
			
	/**
	 * @Fields roundId : 轮次id
	 */
	private Long roundId;
			
	/**
	 * @Fields roundName : 冗余：轮次名称
	 */
	private String roundName;
			
	/**
	 * @Fields districtId : 地区id
	 */
	private Long districtId;
			
	/**
	 * @Fields districtName : 冗余：地区名称
	 */
	private String districtName;
			
	/**
	 * @Fields districtSubId : 二级地区id
	 */
	private Long districtSubId;
			
	/**
	 * @Fields districtSubName : 冗余：二级地区名称
	 */
	private String districtSubName;
			
	/**
	 * @Fields industryId :  行业id
	 */
	private Long industryId;
			
	/**
	 * @Fields industryName : 冗余：行业名称
	 */
	private String industryName;
			
	/**
	 * @Fields industrySubId : 子行业id
	 */
	private Long industrySubId;
			
	/**
	 * @Fields industrySubName : 冗余：子行业名称
	 */
	private String industrySubName;
			
	/**
	 * @Fields investPer : 股权占比
	 */
	private String investPer;
			
	/**
	 * @Fields investfirmNames : 冗余：投资机构名称
	 */
	private String investfirmNames;
			

	/**
	 * @Fields year : 
	 */
	private Integer year;
	//新加
	private String projectName;
	
	/**
	 * @Fields yaar : 项目源id
	 * @return
	 */
	private Long sourceId;
	
	private String pic;

	
	public String getProjectName() {
		return projectName;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}


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
    
	public Integer getYear(){
		return year;
	}
	
	public void setYear(Integer year){
		this.year = year;
	}

	public Long getSourceId() {
		return sourceId;
	}

	public void setSourceId(Long sourceId) {
		this.sourceId = sourceId;
	}
    }