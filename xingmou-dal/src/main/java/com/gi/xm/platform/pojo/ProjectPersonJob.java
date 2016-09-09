package com.gi.xm.platform.pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.sql.Timestamp;
import java.util.Date;

public class ProjectPersonJob extends Pojo {

        public static final String ID = "id";
        public static final String PERSON_ID = "创业者id";
        public static final String COMPANY_NAME = "公司名称";
        public static final String POSTION_NAME = "职位名称";
        public static final String START_DATE = "开始日期";
        public static final String END_DATE = "结束日期";
        public static final String DESCRIPTION = "说明/描述";
        public static final String ADD_TIME = "addTime";
        public static final String UPDATE_TIME = "updateTime";
    
	
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
	
	/**
	 * @Fields addTime : 
	 */
	private Timestamp addTime;
	
	/**
	 * @Fields updateTime : 
	 */
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