package com.gi.ctdn.pojo;

import java.sql.Timestamp;

import com.gi.ctdn.view.common.PojoInfo;

public class EventIndustryMonth extends PojoInfo {

	/**
	 * @Fields id : 
	 */
	private Integer id;
	
	/**
	 * @Fields industryid : 一级行业Id
	 */
	private Integer industryid;
	
	/**
	 * @Fields industryname : 一级行业名称
	 */
	private String industryname;
	
	/**
	 * @Fields eventnum : 新增事件数，按获投时间
	 */
	private Integer eventnum;
	
	/**
	 * @Fields amount : 融资总额,单位万人民币
	 */
	private Long amount;
	
	/**
	 * @Fields year : 年
	 */
	private Integer year;
	
	/**
	 * @Fields month : 月
	 */
	private Integer month;
	
	/**
	 * @Fields round : 轮次
	 */
	private String round;


	/**
	 * @Fields createdtime : 创建时间
	 */
	private Timestamp createdtime;
	
    
	public Integer getId(){
		return id;
	}

	public void setId(Integer id){
		this.id = id;
	}
    
	public Integer getIndustryid(){
		return industryid;
	}

	public void setIndustryid(Integer industryid){
		this.industryid = industryid;
	}
    
	public String getIndustryname(){
		return industryname;
	}

	public void setIndustryname(String industryname){
		this.industryname = industryname;
	}
    
	public Integer getEventnum(){
		return eventnum;
	}

	public void setEventnum(Integer eventnum){
		this.eventnum = eventnum;
	}
    
	public Long getAmount(){
		return amount;
	}

	public void setAmount(Long amount){
		this.amount = amount;
	}
    
	public Integer getYear(){
		return year;
	}

	public void setYear(Integer year){
		this.year = year;
	}
    
	public Integer getMonth(){
		return month;
	}

	public void setMonth(Integer month){
		this.month = month;
	}
    
	public String getRound(){
		return round;
	}

	public void setRound(String round){
		this.round = round;
	}

	public Timestamp getCreatedtime(){
		return createdtime;
	}

	public void setCreatedtime(Timestamp createdtime){
		this.createdtime = createdtime;
	}
    }