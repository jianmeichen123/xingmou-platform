package com.gi.xm.platform.query;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class InvestorAreasQuery extends Query {
	
	/**   
	 * @Fields serialVersionUID : 序列化版本号 
	 */ 
	private static final long serialVersionUID = 1L;
	
			
	private Long id;
			
	private Long investorId;
			
	private Integer areaId;
			
	private Timestamp addTime;
			
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
    
	public Integer getAreaId(){
		return areaId;
	}
	public void setAreaId(Integer areaId){
		this.areaId = areaId;
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