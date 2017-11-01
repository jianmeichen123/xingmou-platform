package com.gi.ctdn.ods.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gi.ctdn.view.common.PojoInfo;

public class AsoIosRate extends PojoInfo {

        public static final String ID = "id";
        public static final String DATE = "date";
        public static final String TITLE = "title";
        public static final String APPID = "appid";
        public static final String R1 = "r1";
        public static final String R2 = "r2";
        public static final String R3 = "r3";
        public static final String R4 = "r4";
        public static final String R5 = "r5";
        public static final String SUMR = "sumr";
        public static final String AVGR = "avgr";
        public static final String TYPE = "type";
    
	
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
	 * @Fields r1 : 
	 */
	private Integer r1;
	
	/**
	 * @Fields r2 : 
	 */
	private Integer r2;
	
	/**
	 * @Fields r3 : 
	 */
	private Integer r3;
	
	/**
	 * @Fields r4 : 
	 */
	private Integer r4;
	
	/**
	 * @Fields r5 : 
	 */
	private Integer r5;
	
	/**
	 * @Fields sumr : 
	 */
	private Integer sumr;
	
	/**
	 * @Fields avgr : 
	 */
	private Integer avgr;
	
	/**
	 * @Fields type : 
	 */
	private Integer type;
	
    
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
    
	public Integer getR1(){
		return r1;
	}

	public void setR1(Integer r1){
		this.r1 = r1;
	}
    
	public Integer getR2(){
		return r2;
	}

	public void setR2(Integer r2){
		this.r2 = r2;
	}
    
	public Integer getR3(){
		return r3;
	}

	public void setR3(Integer r3){
		this.r3 = r3;
	}
    
	public Integer getR4(){
		return r4;
	}

	public void setR4(Integer r4){
		this.r4 = r4;
	}
    
	public Integer getR5(){
		return r5;
	}

	public void setR5(Integer r5){
		this.r5 = r5;
	}
    
	public Integer getSumr(){
		return sumr;
	}

	public void setSumr(Integer sumr){
		this.sumr = sumr;
	}
    
	public Integer getAvgr(){
		return avgr;
	}

	public void setAvgr(Integer avgr){
		this.avgr = avgr;
	}
    
	public Integer getType(){
		return type;
	}

	public void setType(Integer type){
		this.type = type;
	}
    }