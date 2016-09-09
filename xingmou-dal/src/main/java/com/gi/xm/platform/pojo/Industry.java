package com.gi.xm.platform.pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.sql.Timestamp;
import java.util.Date;

public class Industry extends Pojo {

        public static final String ID = "id";
        public static final String TITLE = "title";
        public static final String CODE = "code";
        public static final String PARENT_ID = "parentId";
        public static final String ADD_TIME = "addTime";
        public static final String UPDATE_TIME = "updateTime";
    
	
	/**
	 * @Fields id : 
	 */
	private Integer id;
	
	/**
	 * @Fields title : 
	 */
	private String title;
	
	/**
	 * @Fields code : 
	 */
	private String code;
	
	/**
	 * @Fields parentId : 
	 */
	private Integer parentId;
	
	/**
	 * @Fields addTime : 
	 */
	private Timestamp addTime;
	
	/**
	 * @Fields updateTime : 
	 */
	private Timestamp updateTime;
	
    
	public Integer getId(){
		return id;
	}

	public void setId(Integer id){
		this.id = id;
	}
    
	public String getTitle(){
		return title;
	}

	public void setTitle(String title){
		this.title = title;
	}
    
	public String getCode(){
		return code;
	}

	public void setCode(String code){
		this.code = code;
	}
    
	public Integer getParentId(){
		return parentId;
	}

	public void setParentId(Integer parentId){
		this.parentId = parentId;
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