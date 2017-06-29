package com.gi.ctdn.pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.sql.Timestamp;
import java.util.Date;
import com.gi.xm.platform.view.common.PojoInfo;

public class EventInfoOrg extends PojoInfo {

        public static final String EVENTID = "事件ID";
        public static final String ROUND = "轮次";
        public static final String INVESTDATE = "时间";
        public static final String COMPANY = "融资公司";
        public static final String AMOUNTSTR = "投资额字面量";
        public static final String INVESTSIDEJSON = "投资方包含未收录";
        public static final String INVSTORGID = "投资事件对应投资机构id";
        public static final String SOURCECODE = "项目/投资机构 code";
    
	
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
	 * @Fields invstorgid : 投资事件对应投资机构id
	 */
	private Integer invstorgid;
	
	/**
	 * @Fields sourceCode : 项目/投资机构 code
	 */
	private String sourceCode;
	
    
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
    
	public Integer getInvstorgid(){
		return invstorgid;
	}

	public void setInvstorgid(Integer invstorgid){
		this.invstorgid = invstorgid;
	}
    
	public String getSourceCode(){
		return sourceCode;
	}

	public void setSourceCode(String sourceCode){
		this.sourceCode = sourceCode;
	}
    }