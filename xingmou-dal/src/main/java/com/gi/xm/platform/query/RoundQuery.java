package com.gi.xm.platform.query;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class RoundQuery extends Query {
	
	/**   
	 * @Fields serialVersionUID : 序列化版本号 
	 */ 
	private static final long serialVersionUID = 1L;
	
			
	private Integer id;
			
	private String title;
			
	private String code;
			
	private Integer ordernum;
			
	private Integer type;
			
	private Long parentId;
			
	private Timestamp addTime;
			
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
    
	public Integer getOrdernum(){
		return ordernum;
	}
	public void setOrdernum(Integer ordernum){
		this.ordernum = ordernum;
	}
    
	public Integer getType(){
		return type;
	}
	public void setType(Integer type){
		this.type = type;
	}
    
	public Long getParentId(){
		return parentId;
	}
	public void setParentId(Long parentId){
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