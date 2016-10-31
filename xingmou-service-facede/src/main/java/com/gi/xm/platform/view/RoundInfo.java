package com.gi.xm.platform.view;

import java.math.BigDecimal;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class RoundInfo implements Serializable {

	/**   
	 * @Fields serialVersionUID : 序列化版本号 
	 */ 
	private static final long serialVersionUID = 1L;

			
	/**
	 * @Fields id : 
	 */
	private Integer id;
			
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
	 * @Fields type : 1投资事件轮次  2机构关注轮次
	 */
	private Integer type;
			
	/**
	 * @Fields parentId : 上级分类，暂时只有type＝1有上级
	 */
	private Long parentId;

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

}