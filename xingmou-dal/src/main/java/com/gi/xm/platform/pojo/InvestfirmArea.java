package com.gi.xm.platform.pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.sql.Timestamp;
import java.util.Date;

public class InvestfirmArea extends Pojo {

        public static final String ID = "id";
        public static final String INVESTFRIM_ID = "关联 dm_investfrims.id";
        public static final String AREA_ID = "关联 ods.dw_v_area.id";
        public static final String ADD_TIME = "addTime";
        public static final String UPDATE_TIME = "updateTime";
    
	
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