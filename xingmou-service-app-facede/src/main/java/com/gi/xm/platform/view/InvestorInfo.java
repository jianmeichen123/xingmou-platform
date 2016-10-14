package com.gi.xm.platform.view;

import java.math.BigDecimal;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class InvestorInfo implements Serializable {

	/**   
	 * @Fields serialVersionUID : 序列化版本号 
	 */ 
	private static final long serialVersionUID = 1L;

			
	/**
	 * @Fields id : 
	 */
	private Long id;
			
	/**
	 * @Fields name : 投资人姓名
	 */
	private String name;
			
	/**
	 * @Fields investfirmId : 所属投资机构id，关联dm_investfirms.id
	 */
	private Integer investfirmId;
			
	/**
	 * @Fields investfirmName : 冗余：机构名称
	 */
	private String investfirmName;
			
	/**
	 * @Fields investfirmPostionId : 职位，关联ods.dw_v_postion.id
	 */
	private Integer investfirmPostionId;
			
	/**
	 * @Fields investfirmPostionName : 冗余，职位名称
	 */
	private String investfirmPostionName;
			
	/**
	 * @Fields icon : 头像
	 */
	private String icon;
			
	/**
	 * @Fields local : 冗余，地区
	 */
	private String local;
			
	/**
	 * @Fields description : 简介
	 */
	private String description;
			
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
    
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
    
	public Integer getInvestfirmId(){
		return investfirmId;
	}
	
	public void setInvestfirmId(Integer investfirmId){
		this.investfirmId = investfirmId;
	}
    
	public String getInvestfirmName(){
		return investfirmName;
	}
	
	public void setInvestfirmName(String investfirmName){
		this.investfirmName = investfirmName;
	}
    
	public Integer getInvestfirmPostionId(){
		return investfirmPostionId;
	}
	
	public void setInvestfirmPostionId(Integer investfirmPostionId){
		this.investfirmPostionId = investfirmPostionId;
	}
    
	public String getInvestfirmPostionName(){
		return investfirmPostionName;
	}
	
	public void setInvestfirmPostionName(String investfirmPostionName){
		this.investfirmPostionName = investfirmPostionName;
	}
    
	public String getIcon(){
		return icon;
	}
	
	public void setIcon(String icon){
		this.icon = icon;
	}
    
	public String getLocal(){
		return local;
	}
	
	public void setLocal(String local){
		this.local = local;
	}
    
	public String getDescription(){
		return description;
	}
	
	public void setDescription(String description){
		this.description = description;
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