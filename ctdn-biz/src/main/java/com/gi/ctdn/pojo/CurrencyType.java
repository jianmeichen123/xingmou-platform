package com.gi.ctdn.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.gi.ctdn.view.common.PojoInfo;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CurrencyType extends PojoInfo {

        public static final String ID = "id";
        public static final String NAME = "name";
        public static final String VAL = "val";
    
	
	/**
	 * @Fields id : 
	 */
	private Integer id;
	
	/**
	 * @Fields name : 
	 */
	private String name;
	
	/**
	 * @Fields val : 
	 */
	private Integer val;
	
    
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
    
	public Integer getVal(){
		return val;
	}

	public void setVal(Integer val){
		this.val = val;
	}
    }