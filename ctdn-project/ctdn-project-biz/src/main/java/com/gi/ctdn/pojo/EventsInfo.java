package com.gi.ctdn.pojo;

import java.io.Serializable;
import java.util.Date;

public class EventsInfo extends  CtdnPojo implements Serializable {

	/**   
	 * @Fields serialVersionUID : 序列化版本号 
	 */ 
	private static final long serialVersionUID = 1L;

			
	/**
	 * @Fields id : 
	 */
	private Long id;
			
	/**
	 * @Fields projectId : 
	 */
	private Long projectId;
			
	/**
	 * @Fields roundId : 融资阶段id
	 */
	private Integer roundId;
			
	/**
	 * @Fields roundName : 融资阶段名称
	 */
	private String roundName;
			
	/**
	 * @Fields eventDate : 融资时间
	 */
	private Date eventDate;
			
	/**
	 * @Fields investfirmNames : 投资方，若为多方机构，以“，”分割
	 */
	private String investfirmNames;
			
	/**
	 * @Fields eventMoney : 融资金额
	 */
	private Long eventMoney;
			
	/**
	 * @Fields currencyId : 货币id
	 */
	private Integer currencyId;
			
	/**
	 * @Fields currencyName : 货币名称
	 */
	private String currencyName;

	public Long getId(){
		return id;
	}
	
	public void setId(Long id){
		this.id = id;
	}
    
	public Long getProjectId(){
		return projectId;
	}
	
	public void setProjectId(Long projectId){
		this.projectId = projectId;
	}
    
	public Integer getRoundId(){
		return roundId;
	}
	
	public void setRoundId(Integer roundId){
		this.roundId = roundId;
	}
    
	public String getRoundName(){
		return roundName;
	}
	
	public void setRoundName(String roundName){
		this.roundName = roundName;
	}
    
	public Date getEventDate(){
		return eventDate;
	}
	
	public void setEventDate(Date eventDate){
		this.eventDate = eventDate;
	}
    
	public String getInvestfirmNames(){
		return investfirmNames;
	}
	
	public void setInvestfirmNames(String investfirmNames){
		this.investfirmNames = investfirmNames;
	}
    
	public Long getEventMoney(){
		return eventMoney;
	}
	
	public void setEventMoney(Long eventMoney){
		this.eventMoney = eventMoney;
	}
    
	public Integer getCurrencyId(){
		return currencyId;
	}
	
	public void setCurrencyId(Integer currencyId){
		this.currencyId = currencyId;
	}
    
	public String getCurrencyName(){
		return currencyName;
	}
	
	public void setCurrencyName(String currencyName){
		this.currencyName = currencyName;
	}
    
    }