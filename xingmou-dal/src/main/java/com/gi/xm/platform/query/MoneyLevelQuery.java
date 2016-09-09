package com.gi.xm.platform.query;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class MoneyLevelQuery extends Query {
	
	/**   
	 * @Fields serialVersionUID : 序列化版本号 
	 */ 
	private static final long serialVersionUID = 1L;
	
			
	private Integer id;
			
	private String code;
			
	private String title;
			
	private Timestamp addTime;
			
	private Timestamp updateTime;
		
    
	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id = id;
	}
    
	public String getCode(){
		return code;
	}
	public void setCode(String code){
		this.code = code;
	}
    
	public String getTitle(){
		return title;
	}
	public void setTitle(String title){
		this.title = title;
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