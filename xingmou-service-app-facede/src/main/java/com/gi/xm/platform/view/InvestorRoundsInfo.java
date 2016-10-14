package com.gi.xm.platform.view;

import java.math.BigDecimal;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class InvestorRoundsInfo implements Serializable {

	/**   
	 * @Fields serialVersionUID : 序列化版本号 
	 */ 
	private static final long serialVersionUID = 1L;

			
	/**
	 * @Fields id : 
	 */
	private Long id;
			
	/**
	 * @Fields investorId : 投资人id
	 */
	private Long investorId;
			
	/**
	 * @Fields roundId : 
	 */
	private Integer roundId;
			
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
    
	public Long getInvestorId(){
		return investorId;
	}
	
	public void setInvestorId(Long investorId){
		this.investorId = investorId;
	}
    
	public Integer getRoundId(){
		return roundId;
	}
	
	public void setRoundId(Integer roundId){
		this.roundId = roundId;
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
    }