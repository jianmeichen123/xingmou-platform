package com.gi.xm.platform.query;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class CurrencyQuery extends Query {
	
	/**   
	 * @Fields serialVersionUID : 序列化版本号 
	 */ 
	private static final long serialVersionUID = 1L;
	
			
	private Long id;
			
	private String title;
			
	private String code;
		
    
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
    }