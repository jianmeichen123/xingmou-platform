package com.gi.xm.platform.pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.sql.Timestamp;
import java.util.Date;

public class Postion extends Pojo {

        public static final String ID = "id";
        public static final String TITLE = "职位名称";
        public static final String CODE = "职位编码";
        public static final String TYPE = "1.投资人职位 ";
        public static final String ADD_TIME = "addTime";
        public static final String UPDATE_TIME = "updateTime";
    
	
	/**
	 * @Fields id : 
	 */
	private Long id;
	
	/**
	 * @Fields title : 职位名称
	 */
	private String title;
	
	/**
	 * @Fields code : 职位编码
	 */
	private String code;
	
	/**
	 * @Fields type : 1.投资人职位 
	 */
	private Integer type;
	
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
    
	public Integer getType(){
		return type;
	}

	public void setType(Integer type){
		this.type = type;
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