package com.gi.ctdn.ods.pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.sql.Timestamp;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gi.xm.platform.view.common.PojoInfo;

public class QqAndroidRateDaily extends PojoInfo {

        public static final String ID = "id";
        public static final String DATE = "date";
        public static final String TITLE = "title";
        public static final String APPID = "appid";
        public static final String NEGETIVES = "negetives";
        public static final String POSITIVES = "positives";
    
	
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
	 * @Fields title : 
	 */
	@JsonIgnore
	private String title;
	
	/**
	 * @Fields appid : 
	 */
	@JsonIgnore
	private Long appid;
	
	/**
	 * @Fields negetives : 
	 */
	private Integer negetives;
	
	/**
	 * @Fields positives : 
	 */
	private Integer positives;
	
    
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
    
	public Integer getNegetives(){
		return negetives;
	}

	public void setNegetives(Integer negetives){
		this.negetives = negetives;
	}
    
	public Integer getPositives(){
		return positives;
	}

	public void setPositives(Integer positives){
		this.positives = positives;
	}
    }