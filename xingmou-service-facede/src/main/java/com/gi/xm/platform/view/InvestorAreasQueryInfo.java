package com.gi.xm.platform.view;

import java.util.Date;
import java.math.BigDecimal;
import java.io.Serializable;
import java.sql.Timestamp;
import com.gi.xm.platform.view.common.QueryInfo;

public class InvestorAreasQueryInfo extends QueryInfo {
	
	/**   
	 * @Fields serialVersionUID : 序列化版本号 
	 */ 
	private static final long serialVersionUID = 1L;

	
	private Long id;
	
	private Long investorId;
	
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