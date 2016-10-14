package com.gi.xm.platform.view;

import java.util.Date;
import java.math.BigDecimal;
import java.io.Serializable;
import java.sql.Timestamp;
import com.gi.xm.platform.view.common.QueryInfo;

public class ProjectPersonJobQueryInfo extends QueryInfo {
	
	/**   
	 * @Fields serialVersionUID : 序列化版本号 
	 */ 
	private static final long serialVersionUID = 1L;

	
	private Long id;
	
	private Long personId;
	
	private String companyName;
	
	private String postionName;
	
	private String startDate;
	
	private String endDate;
	
	private String description;
	
	private Timestamp addTime;
	
	private Timestamp updateTime;
		
    
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