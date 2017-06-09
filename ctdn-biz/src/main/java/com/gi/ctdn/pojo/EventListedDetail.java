package com.gi.ctdn.pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.sql.Timestamp;
import java.util.Date;
import com.gi.xm.platform.view.common.PojoInfo;

public class EventListedDetail extends PojoInfo {

        public static final String LISTEDEVENT = "上市挂牌事件";
        public static final String EVENTID = "事件ID";
        public static final String CODE = "事件code";
        public static final String INVESTPARTY = "投资方";
        public static final String FUND = "基金";
        public static final String QUITTIME = "退出时间";
        public static final String QUITTYPE = "退出方式";
        public static final String QUITRETURN = "账面退出回报";
        public static final String RETURNMULTI = "账面回报(倍数)";
    
	
	/**
	 * @Fields listedEvent : 上市挂牌事件
	 */
	private String listedEvent;
	
	/**
	 * @Fields eventId : 事件ID
	 */
	private Integer eventId;
	
	/**
	 * @Fields code : 事件code
	 */
	private String code;
	
	/**
	 * @Fields investParty : 投资方
	 */
	private String investParty;
	
	/**
	 * @Fields fund : 基金
	 */
	private String fund;
	
	/**
	 * @Fields quitTime : 退出时间
	 */
	private String quitTime;
	
	/**
	 * @Fields quitType : 退出方式
	 */
	private String quitType;
	
	/**
	 * @Fields quitReturn : 账面退出回报
	 */
	private String quitReturn;
	
	/**
	 * @Fields returnMulti : 账面回报(倍数)
	 */
	private BigDecimal returnMulti;
	
    
	public String getListedEvent(){
		return listedEvent;
	}

	public void setListedEvent(String listedEvent){
		this.listedEvent = listedEvent;
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
    
	public String getInvestParty(){
		return investParty;
	}

	public void setInvestParty(String investParty){
		this.investParty = investParty;
	}
    
	public String getFund(){
		return fund;
	}

	public void setFund(String fund){
		this.fund = fund;
	}
    
	public String getQuitTime(){
		return quitTime;
	}

	public void setQuitTime(String quitTime){
		this.quitTime = quitTime;
	}
    
	public String getQuitType(){
		return quitType;
	}

	public void setQuitType(String quitType){
		this.quitType = quitType;
	}
    
	public String getQuitReturn(){
		return quitReturn;
	}

	public void setQuitReturn(String quitReturn){
		this.quitReturn = quitReturn;
	}
    
	public BigDecimal getReturnMulti(){
		return returnMulti;
	}

	public void setReturnMulti(BigDecimal returnMulti){
		this.returnMulti = returnMulti;
	}
    }