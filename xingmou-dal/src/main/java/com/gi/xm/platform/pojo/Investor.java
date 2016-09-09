package com.gi.xm.platform.pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.sql.Timestamp;
import java.util.Date;

public class Investor extends Pojo {

        public static final String ID = "id";
        public static final String NAME = "投资人姓名";
        public static final String INVESTFIRM_ID = "所属投资机构id，关联dm_investfirms.id";
        public static final String INVESTFIRM_NAME = "冗余：机构名称";
        public static final String INVESTFIRM_POSTION_ID = "职位，关联ods.dw_v_postion.id";
        public static final String INVESTFIRM_POSTION_NAME = "冗余，职位名称";
        public static final String ICON = "头像";
        public static final String LOCAL = "冗余，地区";
        public static final String DESCRIPTION = "简介";
        public static final String ADD_TIME = "addTime";
        public static final String UPDATE_TIME = "updateTime";
    
	
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