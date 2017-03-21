package com.gi.ctdn.ods.pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.sql.Timestamp;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gi.xm.platform.view.common.PojoInfo;

public class AlexaPvUv extends PojoInfo {

        public static final String ID = "id";
        public static final String DATE = "date";
        public static final String TITLE = "项目title";
        public static final String DOMAIN = "网站域名";
        public static final String PV = "pv";
        public static final String PV_C = "pvC";
        public static final String UV = "uv";
        public static final String UV_C = "uvC";
        public static final String CODE = "code";
    
	
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
	 * @Fields domain : 网站域名
	 */
	private String domain;
	
	/**
	 * @Fields pv : 
	 */
	private Integer pv;
	
	/**
	 * @Fields pvC : 
	 */
	@JsonIgnore
	private Integer pvC;
	
	/**
	 * @Fields uv : 
	 */
	private Long uv;
	
	/**
	 * @Fields uvC : 
	 */
	@JsonIgnore
	private Long uvC;
	
	/**
	 * @Fields code : 
	 */
	@JsonIgnore
	private String code;
	
    
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
    
	public String getDomain(){
		return domain;
	}

	public void setDomain(String domain){
		this.domain = domain;
	}
    
	public Integer getPv(){
		return pv;
	}

	public void setPv(Integer pv){
		this.pv = pv;
	}
    
	public Integer getPvC(){
		return pvC;
	}

	public void setPvC(Integer pvC){
		this.pvC = pvC;
	}
    
	public Long getUv(){
		return uv;
	}

	public void setUv(Long uv){
		this.uv = uv;
	}
    
	public Long getUvC(){
		return uvC;
	}

	public void setUvC(Long uvC){
		this.uvC = uvC;
	}
    
	public String getCode(){
		return code;
	}

	public void setCode(String code){
		this.code = code;
	}
    }