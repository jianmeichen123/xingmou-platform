package com.gi.xm.report.pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.sql.Timestamp;
import java.util.Date;

public class ChartEventRoundYear extends Pojo {

    
	/**
	 * @Fields id : 
	 */
	private Long id;
	
	/**
	 * @Fields year : 年份
	 */
	private Integer year;
	
	/**
	 * @Fields roundName : 轮次名称
	 */
	private String roundName;
	
	/**
	 * @Fields investedNum : 融资笔数
	 */
	private Integer investedNum;
	
	/**
	 * @Fields investedMoney :融资金额
	 */
	private Long investedMoney;
	/**
	 * @Fields ordernum: 轮次排序字段
	 */
	private Integer ordernum;
	
	/**
	 * @Fields addTime : 
	 */
	private Timestamp addTime;
	
	/**
	 * @Fields updateTime : 
	 */
	private Timestamp updateTime;
	
    
	public Long getId(){
		return id;
	}

	public void setId(Long id){
		this.id = id;
	}
    
	public Integer getYear(){
		return year;
	}

	public void setYear(Integer year){
		this.year = year;
	}
    
	
    
	public String getRoundName(){
		return roundName;
	}

	public void setRoundName(String roundName){
		this.roundName = roundName;
	}
    
	public Integer getInvestedNum(){
		return investedNum;
	}

	public void setInvestedNum(Integer investedNum){
		this.investedNum = investedNum;
	}
    
	public Long getInvestedMoney(){
		return investedMoney;
	}

	public void setInvestedMoney(Long investedMoney){
		this.investedMoney = investedMoney;
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

	public Integer getOrdernum() {
		return ordernum;
	}

	public void setOrdernum(Integer ordernum) {
		this.ordernum = ordernum;
	}
    }