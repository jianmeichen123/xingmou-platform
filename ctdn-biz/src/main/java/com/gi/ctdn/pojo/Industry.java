package com.gi.ctdn.pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.gi.xm.platform.view.common.PojoInfo;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Industry extends PojoInfo {

        public static final String ID = "id";
        public static final String INDUSTRYID = "industryId";
        public static final String PARENTID = "parentId";
        public static final String NAME = "name";
        public static final String INDUSTRYLIST = "industryList";
        public static final String VAL = "val";
    
	
	/**
	 * @Fields id : 
	 */
	private Integer id;
	
	/**
	 * @Fields industryId : 
	 */
	private Integer industryId;
	
	/**
	 * @Fields parentId : 
	 */
	private Integer parentId;

	/**
	 * @Fields parentId :
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private List<Industry> children;
	
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
    
	public Integer getIndustryId(){
		return industryId;
	}

	public void setIndustryId(Integer industryId){
		this.industryId = industryId;
	}
    
	public Integer getParentId(){
		return parentId;
	}

	public void setParentId(Integer parentId){
		this.parentId = parentId;
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

	public List<Industry> getChildren() {
		return children;
	}

	public void setChildren(List<Industry> children) {
		this.children = children;
	}
}