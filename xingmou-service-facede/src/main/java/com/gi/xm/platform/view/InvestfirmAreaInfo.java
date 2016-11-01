package com.gi.xm.platform.view;

import java.math.BigDecimal;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class InvestfirmAreaInfo implements Serializable {

	/**   
	 * @Fields serialVersionUID : 序列化版本号 
	 */ 
	private static final long serialVersionUID = 1L;

			
	/**
	 * @Fields id : 
	 */
	private Long id;
			
	/**
	 * @Fields investfrimId : 关联 dm_investfrims.id
	 */
	private Integer investfrimId;
			
	/**
	 * @Fields areaId : 关联 ods.dw_v_area.id
	 */
	private Integer areaId;
			
	public Long getId(){
		return id;
	}
	
	public void setId(Long id){
		this.id = id;
	}
    
	public Integer getInvestfrimId(){
		return investfrimId;
	}
	
	public void setInvestfrimId(Integer investfrimId){
		this.investfrimId = investfrimId;
	}
    
	public Integer getAreaId(){
		return areaId;
	}
	
	public void setAreaId(Integer areaId){
		this.areaId = areaId;
	}
}