package com.gi.xm.platform.pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.sql.Timestamp;
import java.util.Date;

public class District extends Pojo {

        public static final String ID = " 地区ID";
        public static final String NAME = "地区名称";
        public static final String LEVEL = " 地区等级：1，省级；2，市级；3，县级；4，乡镇";
        public static final String UPID = "上级地区ID";
        public static final String TYPE = "1.国内  2.国外";
        public static final String DISPLAYORDER = "显示顺序";
    
	
	/**
	 * @Fields id :  地区ID
	 */
	private Integer id;
	
	/**
	 * @Fields name : 地区名称
	 */
	private String name;
	
	/**
	 * @Fields level :  地区等级：1，省级；2，市级；3，县级；4，乡镇
	 */
	private Integer level;
	
	/**
	 * @Fields upid : 上级地区ID
	 */
	private Integer upid;
	
	/**
	 * @Fields type : 1.国内  2.国外
	 */
	private Integer type;
	
	/**
	 * @Fields displayorder : 显示顺序
	 */
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