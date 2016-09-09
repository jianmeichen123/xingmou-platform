package com.gi.xm.platform.view;

import java.math.BigDecimal;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class AreaInfo implements Serializable {

	/**   
	 * @Fields serialVersionUID : 序列化版本号 
	 */ 
	private static final long serialVersionUID = 1L;

			
	/**
	 * @Fields id : 
	 */
	private Long id;
			
	/**
	 * @Fields title : 
	 */
	private String title;
			
	/**
	 * @Fields code : 
	 */
	private String code;
			
	/**
	 * @Fields ordernum : 
	 */
	private Integer ordernum;
			
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
    
	public Integer getOrdernum(){
		return ordernum;
	}
	
	public void setOrdernum(Integer ordernum){
		this.ordernum = ordernum;
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