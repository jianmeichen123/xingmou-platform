package com.gi.xm.platform.view;

import java.math.BigDecimal;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class ProjectPersonJobInfo implements Serializable {

	/**   
	 * @Fields serialVersionUID : 序列化版本号 
	 */ 
	private static final long serialVersionUID = 1L;

			
	/**
	 * @Fields id : 
	 */
	private Long id;
			
	/**
	 * @Fields personId : 创业者id
	 */
	private Long personId;
			
	/**
	 * @Fields companyName : 公司名称
	 */
	private String companyName;
			
	/**
	 * @Fields postionName : 职位名称
	 */
	private String postionName;
			
	/**
	 * @Fields startDate : 开始日期
	 */
	private String startDate;
			
	/**
	 * @Fields endDate : 结束日期
	 */
	private String endDate;
			
	/**
	 * @Fields description : 说明/描述
	 */
	private String description;
			
	public Long getId(){
		return id;
	}
	
	public void setId(Long id){
		this.id = id;
	}
    
	public Long getPersonId(){
		return personId;
	}
	
	public void setPersonId(Long personId){
		this.personId = personId;
	}
    
	public String getCompanyName(){
		return companyName;
	}
	
	public void setCompanyName(String companyName){
		this.companyName = companyName;
	}
    
	public String getPostionName(){
		return postionName;
	}
	
	public void setPostionName(String postionName){
		this.postionName = postionName;
	}
    
	public String getStartDate(){
		return startDate;
	}
	
	public void setStartDate(String startDate){
		this.startDate = startDate;
	}
    
	public String getEndDate(){
		return endDate;
	}
	
	public void setEndDate(String endDate){
		this.endDate = endDate;
	}
    
	public String getDescription(){
		return description;
	}
	
	public void setDescription(String description){
		this.description = description;
	}
    
}