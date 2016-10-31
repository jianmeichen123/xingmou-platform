package com.gi.xm.platform.view;

import java.math.BigDecimal;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class ProjectPersonStudyInfo implements Serializable {

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
    
}