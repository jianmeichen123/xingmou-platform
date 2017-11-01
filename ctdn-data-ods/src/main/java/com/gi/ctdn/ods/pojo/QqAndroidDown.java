package com.gi.ctdn.ods.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gi.ctdn.view.common.PojoInfo;

public class QqAndroidDown extends PojoInfo {

        public static final String ID = "id";
        public static final String DATE = "date";
        public static final String TITLE = "title";
        public static final String APPID = "appid";
        public static final String DOWNSUM = "downsum";
        public static final String DOWNDAY = "downday";
    
	
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
	 * @Fields downsum : 
	 */
	private Long downsum;
	
	/**
	 * @Fields downday : 
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
    
	public Long getDownsum(){
		return downsum;
	}

	public void setDownsum(Long downsum){
		this.downsum = downsum;
	}
    
	public Integer getDownday(){
		return downday;
	}

	public void setDownday(Integer downday){
		this.downday = downday;
	}
    }