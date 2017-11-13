package com.gi.ctdn.pojo;

import com.gi.ctdn.view.common.Pagination;

import java.math.BigDecimal;
import java.util.Date;

public class EventDetail extends Pagination {

        public static final String INVESTEVENT = "投资事件";
        public static final String EVENTID = "事件ID";
        public static final String CODE = "事件code";
        public static final String ORG = "机构";
        public static final String FUND = "基金";
        public static final String INVESTOR = "投资人";
        public static final String INVESTTIME = "投资时间";
        public static final String ROLE = "领投/跟投";
        public static final String AMOUNT = "投资金额";
        public static final String STOCK = "股权";
        public static final String ORGTYPE = "机构类型";
        public static final String QUITTIME = "退出时间";
        public static final String QUITTYPE = "退出方式";
        public static final String RETURNAMOUNT = "账面回报金额";
        public static final String RETURNMULTI = "账面回报(倍数)";
        public static final String INVESTED = "被投资方";
        public static final String ROUND = "轮次";
        public static final String COMMITAMOUNT = "承诺金额";
    
	
	/**
	 * @Fields investEvent : 投资事件
	 */
	private String investEvent;
	
	/**
	 * @Fields eventId : 事件ID
	 */
	private Integer eventId;
	
	/**
	 * @Fields code : 事件code
	 */
	private String code;
	
	/**
	 * @Fields org : 机构
	 */
	private String org;
	
	/**
	 * @Fields fund : 基金
	 */
	private String fund;
	
	/**
	 * @Fields investor : 投资人
	 */
	private String investor;
	
	/**
	 * @Fields investtime : 投资时间
	 */
	private String investtime;
	
	/**
	 * @Fields role : 领投/跟投
	 */
	private String role;
	
	/**
	 * @Fields amount : 投资金额
	 */
	private String amount;
	
	/**
	 * @Fields stock : 股权
	 */
	private BigDecimal stock;
	
	/**
	 * @Fields orgType : 机构类型
	 */
	private String orgType;
	
	/**
	 * @Fields quitTime : 退出时间
	 */
	private Date quitTime;
	
	/**
	 * @Fields quitType : 退出方式
	 */
	private String quitType;
	
	/**
	 * @Fields returnAmount : 账面回报金额
	 */
	private String returnAmount;
	
	/**
	 * @Fields returnMulti : 账面回报(倍数)
	 */
	private BigDecimal returnMulti;
	
	/**
	 * @Fields invested : 被投资方
	 */
	private String invested;
	
	/**
	 * @Fields round : 轮次
	 */
	private String round;
	
	/**
	 * @Fields commitAmount : 承诺金额
	 */
	private String commitAmount;
	
    
	public String getInvestEvent(){
		return investEvent;
	}

	public void setInvestEvent(String investEvent){
		this.investEvent = investEvent;
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
    
	public String getOrg(){
		return org;
	}

	public void setOrg(String org){
		this.org = org;
	}
    
	public String getFund(){
		return fund;
	}

	public void setFund(String fund){
		this.fund = fund;
	}
    
	public String getInvestor(){
		return investor;
	}

	public void setInvestor(String investor){
		this.investor = investor;
	}
    
	public String getInvesttime(){
		return investtime;
	}

	public void setInvesttime(String investtime){
		this.investtime = investtime;
	}
    
	public String getRole(){
		return role;
	}

	public void setRole(String role){
		this.role = role;
	}
    
	public String getAmount(){
		return amount;
	}

	public void setAmount(String amount){
		this.amount = amount;
	}
    
	public BigDecimal getStock(){
		return stock;
	}

	public void setStock(BigDecimal stock){
		this.stock = stock;
	}
    
	public String getOrgType(){
		return orgType;
	}

	public void setOrgType(String orgType){
		this.orgType = orgType;
	}
    
	public Date getQuitTime(){
		return quitTime;
	}

	public void setQuitTime(Date quitTime){
		this.quitTime = quitTime;
	}
    
	public String getQuitType(){
		return quitType;
	}

	public void setQuitType(String quitType){
		this.quitType = quitType;
	}
    
	public String getReturnAmount(){
		return returnAmount;
	}

	public void setReturnAmount(String returnAmount){
		this.returnAmount = returnAmount;
	}
    
	public BigDecimal getReturnMulti(){
		return returnMulti;
	}

	public void setReturnMulti(BigDecimal returnMulti){
		this.returnMulti = returnMulti;
	}
    
	public String getInvested(){
		return invested;
	}

	public void setInvested(String invested){
		this.invested = invested;
	}
    
	public String getRound(){
		return round;
	}

	public void setRound(String round){
		this.round = round;
	}
    
	public String getCommitAmount(){
		return commitAmount;
	}

	public void setCommitAmount(String commitAmount){
		this.commitAmount = commitAmount;
	}
    }