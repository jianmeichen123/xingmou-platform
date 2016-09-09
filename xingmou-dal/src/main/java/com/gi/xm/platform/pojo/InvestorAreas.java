package com.gi.xm.platform.pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.sql.Timestamp;
import java.util.Date;

public class InvestorAreas extends Pojo {

        public static final String ID = "id";
        public static final String INVESTOR_ID = "投资人id";
        public static final String AREA_ID = "areaId";
        public static final String ADD_TIME = "addTime";
        public static final String UPDATE_TIME = "updateTime";
    
	
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