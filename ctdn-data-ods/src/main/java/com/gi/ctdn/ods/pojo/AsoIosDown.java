package com.gi.ctdn.ods.pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.sql.Timestamp;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gi.xm.platform.view.common.PojoInfo;

public class AsoIosDown extends PojoInfo {

        public static final String ID = "id";
        public static final String DATE = "date";
        public static final String TITLE = "项目title";
        public static final String APPID = "appid";
        public static final String DOWNSUM = "截止统计日期的下载总量";
        public static final String DOWNDAY = "统计日期当天的下载量";
    
	
	/**
	 * @Fields id : 
	 */
	@JsonIgnore
	private Integer id;
	
	/**
	 * @Fields date : 
	 */
	private Integer date;
	
	/**
	 * @Fields title : 项目title
	 */
	@JsonIgnore
	private String title;
	
	/**
	 * @Fields appid : 
	 */
	@JsonIgnore
	private Long appid;
	
	/**
	 * @Fields downsum : 截止统计日期的下载总量
	 */
	private Integer downsum;
	
	/**
	 * @Fields downday : 统计日期当天的下载量
	 */
	private Integer downday;
	
    
	public Integer getId(){
		return id;
	}

	public void setId(Integer id){
		this.id = id;
	}
    
	public Integer getDate(){
		return date;
	}

	public void setDate(Integer date){
		this.date = date;
	}
    
	public String getTitle(){
		return title;
	}

	public void setTitle(String title){
		this.title = title;
	}
    
	public Long getAppid(){
		return appid;
	}

	public void setAppid(Long appid){
		this.appid = appid;
	}
    
	public Integer getDownsum(){
		return downsum;
	}

	public void setDownsum(Integer downsum){
		this.downsum = downsum;
	}
    
	public Integer getDownday(){
		return downday;
	}

	public void setDownday(Integer downday){
		this.downday = downday;
	}
    }