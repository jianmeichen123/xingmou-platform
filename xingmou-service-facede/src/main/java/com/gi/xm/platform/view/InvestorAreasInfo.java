package com.gi.xm.platform.view;

import java.math.BigDecimal;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class InvestorAreasInfo implements Serializable {

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
	 * @Fields areaId : 
	 */
	private Integer areaId;
			
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
    
}