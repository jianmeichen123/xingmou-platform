package com.gi.xm.platform.pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.sql.Timestamp;
import java.util.Date;

public class ProjectPersonStudy extends Pojo {

        public static final String ID = "id";
        public static final String PERSON_ID = "创业者id";
        public static final String SCHOOL_NAME = "学校名称";
        public static final String START_DATE = "开始时间";
        public static final String END_DATE = "结束时间";
        public static final String MAJOR_NAME = "专业名称";
        public static final String EDUCATION_NAME = "学历名称";
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
	 * @Fields schoolName : 学校名称
	 */
	private String schoolName;
	
	/**
	 * @Fields startDate : 开始时间
	 */
	private String startDate;
	
	/**
	 * @Fields endDate : 结束时间
	 */
	private String endDate;
	
	/**
	 * @Fields majorName : 专业名称
	 */
	private String majorName;
	
	/**
	 * @Fields educationName : 学历名称
	 */
	private String educationName;
	
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
    
	public String getSchoolName(){
		return schoolName;
	}

	public void setSchoolName(String schoolName){
		this.schoolName = schoolName;
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
    
	public String getMajorName(){
		return majorName;
	}

	public void setMajorName(String majorName){
		this.majorName = majorName;
	}
    
	public String getEducationName(){
		return educationName;
	}

	public void setEducationName(String educationName){
		this.educationName = educationName;
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