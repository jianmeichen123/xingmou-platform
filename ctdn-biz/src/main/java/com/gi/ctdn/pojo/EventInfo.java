package com.gi.ctdn.pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.sql.Timestamp;
import java.util.Date;
import com.gi.xm.platform.view.common.PojoInfo;

public class EventInfo extends PojoInfo {

	/**
	 * @Fields investevent : 投资事件
	 */
	private String investevent;
	
	/**
	 * @Fields eventId : 事件ID
	 */
	private Integer eventId;
	
	/**
	 * @Fields code : 事件code
	 */
	private String code;
	
	/**
	 * @Fields round : 轮次
	 */
	private String round;
	
	/**
	 * @Fields districtName : 一级地区
	 */
	private String districtName;
	
	/**
	 * @Fields districtSubName : 二级地区
	 */
	private String districtSubName;
	
	/**
	 * @Fields investDate : 时间
	 */
	private Date investDate;
	
	/**
	 * @Fields company : 融资公司
	 */
	private String company;
	
	/**
	 * @Fields stage : 投资阶段
	 */
	private String stage;
	
	/**
	 * @Fields valuation : 企业估值
	 */
	private Integer valuation;
	
	/**
	 * @Fields stock : 股权
	 */
	private Integer stock;
	
	/**
	 * @Fields mode : 融资方式
	 */
	private String mode;
	
	/**
	 * @Fields desc : 描述
	 */
	private String desc;
	
	/**
	 * @Fields sourceId : 项目/投资机构 id
	 */
	private Integer sourceId;
	
	/**
	 * @Fields sourceCode : 项目/投资机构 code
	 */
	private String sourceCode;
	
	/**
	 * @Fields logo : 列表项logo
	 */
	private String logo;
	
	/**
	 * @Fields industryName : 一级行业
	 */
	private String industryName;
	
	/**
	 * @Fields industrySubName : 二级行业
	 */
	private String industrySubName;
	
	/**
	 * @Fields industryGrandsonName : 三级行业
	 */
	private String industryGrandsonName;
	
	/**
	 * @Fields industryIds : 行业ids,各级行业逗号分隔
	 */
	private String industryIds;
	
	/**
	 * @Fields districtId : 一级地区id
	 */
	private Integer districtId;
	
	/**
	 * @Fields districtSubId : 二级地区id
	 */
	private Integer districtSubId;
	
	/**
	 * @Fields amountNum : 投资金额 确切数字
	 */
	private Integer amountNum;
	
	/**
	 * @Fields amountStr : 投资额字面量
	 */
	private String amountStr;
	
	/**
	 * @Fields currencyType : 
	 */
	private String currencyType;
	
	/**
	 * @Fields investSideJson : 投资方包含未收录 {"investSideJson":[{"type":"0","code":199,"title":"红杉资本","isClick":"0"}]}
	 */
	private String investSideJson;
	
	/**
	 * @Fields bodyRole : 投资事件主体
	 */
	private String bodyRole;
	
	/**
	 * @Fields sourceType : 预留 类型:指定是项目或投资机构
	 */
	private String sourceType;
	
	/**
	 * @Fields isClick : 预留 是否可点击
	 */
	private String isClick;
	
	/**
	 * @Fields invstorgids : 投资事件对应投资机构ids
	 */
	private String invstorgids;
	
	/**
	 * @Fields invstorgnames : 投资事件对应投资机构names
	 */
	private String invstorgnames;
	
    
	public String getInvestevent(){
		return investevent;
	}

	public void setInvestevent(String investevent){
		this.investevent = investevent;
	}
    
	public Integer getEventId(){
		return eventId;
	}

	public void setEventId(Integer eventId){
		this.eventId = eventId;
	}
    
	public String getCode(){
		return code;
	}

	public void setCode(String code){
		this.code = code;
	}
    
	public String getRound(){
		return round;
	}

	public void setRound(String round){
		this.round = round;
	}
    
	public String getDistrictName(){
		return districtName;
	}

	public void setDistrictName(String districtName){
		this.districtName = districtName;
	}
    
	public String getDistrictSubName(){
		return districtSubName;
	}

	public void setDistrictSubName(String districtSubName){
		this.districtSubName = districtSubName;
	}
    
	public Date getInvestDate(){
		return investDate;
	}

	public void setInvestDate(Date investDate){
		this.investDate = investDate;
	}
    
	public String getCompany(){
		return company;
	}

	public void setCompany(String company){
		this.company = company;
	}
    
	public String getStage(){
		return stage;
	}

	public void setStage(String stage){
		this.stage = stage;
	}
    
	public Integer getValuation(){
		return valuation;
	}

	public void setValuation(Integer valuation){
		this.valuation = valuation;
	}
    
	public Integer getStock(){
		return stock;
	}

	public void setStock(Integer stock){
		this.stock = stock;
	}
    
	public String getMode(){
		return mode;
	}

	public void setMode(String mode){
		this.mode = mode;
	}
    
	public String getDesc(){
		return desc;
	}

	public void setDesc(String desc){
		this.desc = desc;
	}
    
	public Integer getSourceId(){
		return sourceId;
	}

	public void setSourceId(Integer sourceId){
		this.sourceId = sourceId;
	}

	public String getSourceCode() {
		return sourceCode;
	}

	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}

	public String getLogo(){
		return logo;
	}

	public void setLogo(String logo){
		this.logo = logo;
	}

	public String getIndustryName(){
		return industryName;
	}

	public void setIndustryName(String industryName){
		this.industryName = industryName;
	}
    
	public String getIndustrySubName(){
		return industrySubName;
	}

	public void setIndustrySubName(String industrySubName){
		this.industrySubName = industrySubName;
	}
    
	public String getIndustryGrandsonName(){
		return industryGrandsonName;
	}

	public void setIndustryGrandsonName(String industryGrandsonName){
		this.industryGrandsonName = industryGrandsonName;
	}
    
	public String getIndustryIds(){
		return industryIds;
	}

	public void setIndustryIds(String industryIds){
		this.industryIds = industryIds;
	}
    
	public Integer getDistrictId(){
		return districtId;
	}

	public void setDistrictId(Integer districtId){
		this.districtId = districtId;
	}
    
	public Integer getDistrictSubId(){
		return districtSubId;
	}

	public void setDistrictSubId(Integer districtSubId){
		this.districtSubId = districtSubId;
	}
    
	public Integer getAmountNum(){
		return amountNum;
	}

	public void setAmountNum(Integer amountNum){
		this.amountNum = amountNum;
	}
    
	public String getAmountStr(){
		return amountStr;
	}

	public void setAmountStr(String amountStr){
		this.amountStr = amountStr;
	}
    
	public String getCurrencyType(){
		return currencyType;
	}

	public void setCurrencyType(String currencyType){
		this.currencyType = currencyType;
	}
    
	public String getInvestSideJson(){
		return investSideJson;
	}

	public void setInvestSideJson(String investSideJson){
		this.investSideJson = investSideJson;
	}
    
	public String getBodyRole(){
		return bodyRole;
	}

	public void setBodyRole(String bodyRole){
		this.bodyRole = bodyRole;
	}
    
	public String getSourceType(){
		return sourceType;
	}

	public void setSourceType(String sourceType){
		this.sourceType = sourceType;
	}
    
	public String getIsClick(){
		return isClick;
	}

	public void setIsClick(String isClick){
		this.isClick = isClick;
	}
    
	public String getInvstorgids(){
		return invstorgids;
	}

	public void setInvstorgids(String invstorgids){
		this.invstorgids = invstorgids;
	}
    
	public String getInvstorgnames(){
		return invstorgnames;
	}

	public void setInvstorgnames(String invstorgnames){
		this.invstorgnames = invstorgnames;
	}
    }