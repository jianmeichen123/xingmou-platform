package com.gi.ctdn.pojo;

import com.gi.ctdn.view.common.Query;

import java.util.Date;

public class EventInfoExt extends Query {

        public static final String ID = "id";
        public static final String EVENTID = "事件ID";
        public static final String ROUND = "轮次";
        public static final String INVESTDATE = "时间";
        public static final String COMPANY = "融资公司";
        public static final String AMOUNTSTR = "投资额字面量";
        public static final String INVESTSIDEJSON = "投资方包含未收录";
        public static final String INVSTORID = "投资事件对应投资机构id";
        public static final String SOURCECODE = "项目/投资机构 code";
        public static final String TYPE = "投资方类型【invst/com/person】";
    
	
	/**
	 * @Fields id : 
	 */
	private Integer id;
	
	/**
	 * @Fields eventId : 事件ID
	 */
	private Integer eventId;
	
	/**
	 * @Fields round : 轮次
	 */
	private String round;
	
	/**
	 * @Fields investDate : 时间
	 */
	private Date investDate;
	
	/**
	 * @Fields company : 融资公司
	 */
	private String company;
	
	/**
	 * @Fields amountStr : 投资额字面量
	 */
	private String amountStr;
	
	/**
	 * @Fields investSideJson : 投资方包含未收录
	 */
	private String investSideJson;
	
	/**
	 * @Fields invstorid : 投资事件对应投资机构id
	 */
	private Integer invstorid;
	
	/**
	 * @Fields sourceCode : 项目/投资机构 code
	 */
	private String sourceCode;
	
	/**
	 * @Fields type : 投资方类型【invst/com/person】
	 */
	private String type;

	private String invstorCode;
    
	public Integer getId(){
		return id;
	}

	public void setId(Integer id){
		this.id = id;
	}
    
	public Integer getEventId(){
		return eventId;
	}

	public void setEventId(Integer eventId){
		this.eventId = eventId;
	}
    
	public String getRound(){
		return round;
	}

	public void setRound(String round){
		this.round = round;
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
    
	public String getAmountStr(){
		return amountStr;
	}

	public void setAmountStr(String amountStr){
		this.amountStr = amountStr;
	}
    
	public String getInvestSideJson(){
		return investSideJson;
	}

	public void setInvestSideJson(String investSideJson){
		this.investSideJson = investSideJson;
	}
    
	public Integer getInvstorid(){
		return invstorid;
	}

	public void setInvstorid(Integer invstorid){
		this.invstorid = invstorid;
	}
    
	public String getSourceCode(){
		return sourceCode;
	}

	public void setSourceCode(String sourceCode){
		this.sourceCode = sourceCode;
	}
    
	public String getType(){
		return type;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getInvstorCode() {
		return invstorCode;
	}

	public void setInvstorCode(String invstorCode) {
		this.invstorCode = invstorCode;
	}
}