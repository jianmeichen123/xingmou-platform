package com.gi.xm.platform.view;

import java.util.Date;
import java.math.BigDecimal;
import java.io.Serializable;
import java.sql.Timestamp;
import com.gi.xm.platform.view.common.QueryInfo;

public class DistrictQueryInfo extends QueryInfo {
	
	/**   
	 * @Fields serialVersionUID : 序列化版本号 
	 */ 
	private static final long serialVersionUID = 1L;

	
	private Integer id;
	
	private String name;
	
	private Integer level;
	
	private Integer upid;
	
	private Integer type;
	
	private Integer displayorder;
		
    
	public Integer getId(){
		return id;
	}
	
	public void setId(Integer id){
		this.id = id;
	}
    
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
    
	public Integer getLevel(){
		return level;
	}
	
	public void setLevel(Integer level){
		this.level = level;
	}
    
	public Integer getUpid(){
		return upid;
	}
	
	public void setUpid(Integer upid){
		this.upid = upid;
	}
    
	public Integer getType(){
		return type;
	}
	
	public void setType(Integer type){
		this.type = type;
	}
    
	public Integer getDisplayorder(){
		return displayorder;
	}
	
	public void setDisplayorder(Integer displayorder){
		this.displayorder = displayorder;
	}
    }