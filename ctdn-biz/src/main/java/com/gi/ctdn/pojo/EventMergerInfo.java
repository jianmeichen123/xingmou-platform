package com.gi.ctdn.pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.sql.Timestamp;
import java.util.Date;
import com.gi.xm.platform.view.common.PojoInfo;

public class EventMergerInfo extends PojoInfo {

    
	
	/**
	 * @Fields mergerEvent : 并购事件
	 */
	private String mergerEvent;
	
	/**
	 * @Fields eventId : 事件ID
	 */
	private Integer eventId;
	
	/**
	 * @Fields code : 事件code
	 */
	private String code;
	
	/**
	 * @Fields industryName : 行业
	 */
	private String industryName;
	
	/**
	 * @Fields mergeType : 并购类型
	 */
	private String mergeType;
	
	/**
	 * @Fields mergeState : 并购状态
	 */
	private String mergeState;
	
	/**
	 * @Fields equityRate : 股权比例
	 */
	private String equityRate;
	
	/**
	 * @Fields currencyType : 币种
	 */
	private String currencyType;
	
	/**
	 * @Fields projTitle : 被并购方
	 */
	private String projTitle;
	
	/**
	 * @Fields amountStr : 金额
	 */
	private String amountStr;
	
	/**
	 * @Fields mergeSideJson : 并购方 {"投资方 {"mergeSideJson":[{"type":"0","code":199,"title":"红杉资本","isClick":"0"}]}":[{"type":"0","code":199,"title":"红杉资本","isClick":"0"}]}
	 */
	private String mergeSideJson;
	
	/**
	 * @Fields mergeDate : 并购时间
	 */
	private Date mergeDate;
	
	/**
	 * @Fields isCross : 是否跨国并购
	 */
	private String isCross;
	
	/**
	 * @Fields valuation : 企业估值
	 */
	private String valuation;
	
	/**
	 * @Fields desc : 描述
	 */
	private String desc;
	
	/**
	 * @Fields industrySubname : 二级行业
	 */
	private String industrySubname;
	
	/**
	 * @Fields industryIds : 一级行业,二级行业id 用逗号隔开
	 */
	private String industryIds;
	
	/**
	 * @Fields districtSubName : 二级地区
	 */
	private String districtSubName;



	/**
	 * @Fields districtGrandsonName : 三级地区
	 */
	private String districtGrandsonName;

	/**
	 * @Fields equityrateRange : 股权比例范围   0-10%  :0   10%-30%  :1     30%-50%   :2    50%以上 :3
	 */
	private String equityrateRange;
	
	/**
	 * @Fields sourceId : 被并购方id
	 */
	private Integer sourceId;
	
	/**
	 * @Fields sourceCode : 被并购方code
	 */
	private String sourceCode;
	
	/**
	 * @Fields logo : 被并购方logo
	 */
	private String logo;
	
	/**
	 * @Fields bodyRole : 被并购方主体 预留
	 */
	private String bodyRole;
	
	/**
	 * @Fields sourcetype : 被并购方类型预留
	 */
	private String sourcetype;
	
	/**
	 * @Fields isClick : 是否可点击
	 */
	private String isClick;
	
    
	public String getMergerEvent(){
		return mergerEvent;
	}

	public void setMergerEvent(String mergerEvent){
		this.mergerEvent = mergerEvent;
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
    
	public String getIndustryName(){
		return industryName;
	}

	public void setIndustryName(String industryName){
		this.industryName = industryName;
	}
    
	public String getMergeType(){
		return mergeType;
	}

	public void setMergeType(String mergeType){
		this.mergeType = mergeType;
	}
    
	public String getMergeState(){
		return mergeState;
	}

	public void setMergeState(String mergeState){
		this.mergeState = mergeState;
	}
    
	public String getEquityRate(){
		return equityRate;
	}

	public void setEquityRate(String equityRate){
		this.equityRate = equityRate;
	}
    
	public String getCurrencyType(){
		return currencyType;
	}

	public void setCurrencyType(String currencyType){
		this.currencyType = currencyType;
	}
    
	public String getProjTitle(){
		return projTitle;
	}

	public void setProjTitle(String projTitle){
		this.projTitle = projTitle;
	}
    
	public String getAmountStr(){
		return amountStr;
	}

	public void setAmountStr(String amountStr){
		this.amountStr = amountStr;
	}
    
	public String getMergeSideJson(){
		return mergeSideJson;
	}

	public void setMergeSideJson(String mergeSideJson){
		this.mergeSideJson = mergeSideJson;
	}
    
	public Date getMergeDate(){
		return mergeDate;
	}

	public void setMergeDate(Date mergeDate){
		this.mergeDate = mergeDate;
	}
    
	public String getIsCross(){
		return isCross;
	}

	public void setIsCross(String isCross){
		this.isCross = isCross;
	}
    
	public String getValuation(){
		return valuation;
	}

	public void setValuation(String valuation){
		this.valuation = valuation;
	}
    
	public String getDesc(){
		return desc;
	}

	public void setDesc(String desc){
		this.desc = desc;
	}
    
	public String getIndustrySubname(){
		return industrySubname;
	}

	public void setIndustrySubname(String industrySubname){
		this.industrySubname = industrySubname;
	}
    
	public String getIndustryIds(){
		return industryIds;
	}

	public void setIndustryIds(String industryIds){
		this.industryIds = industryIds;
	}
    
	public String getDistrictSubName(){
		return districtSubName;
	}

	public void setDistrictSubName(String districtSubName){
		this.districtSubName = districtSubName;
	}
    
	public String getEquityrateRange(){
		return equityrateRange;
	}

	public void setEquityrateRange(String equityrateRange){
		this.equityrateRange = equityrateRange;
	}
    
	public Integer getSourceId(){
		return sourceId;
	}

	public void setSourceId(Integer sourceId){
		this.sourceId = sourceId;
	}
    
	public String getSourceCode(){
		return sourceCode;
	}

	public void setSourceCode(String sourceCode){
		this.sourceCode = sourceCode;
	}
    
	public String getLogo(){
		return logo;
	}

	public void setLogo(String logo){
		this.logo = logo;
	}
    
	public String getBodyRole(){
		return bodyRole;
	}

	public void setBodyRole(String bodyRole){
		this.bodyRole = bodyRole;
	}
    
	public String getSourcetype(){
		return sourcetype;
	}

	public void setSourcetype(String sourcetype){
		this.sourcetype = sourcetype;
	}
    
	public String getIsClick(){
		return isClick;
	}

	public void setIsClick(String isClick){
		this.isClick = isClick;
	}

	public String getDistrictGrandsonName() {
		return districtGrandsonName;
	}

	public void setDistrictGrandsonName(String districtGrandsonName) {
		this.districtGrandsonName = districtGrandsonName;
	}
    }