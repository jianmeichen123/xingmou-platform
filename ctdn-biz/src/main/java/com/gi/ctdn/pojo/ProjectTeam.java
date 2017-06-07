package com.gi.ctdn.pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.sql.Timestamp;
import java.util.Date;
import com.gi.xm.platform.view.common.PojoInfo;

public class ProjectTeam extends PojoInfo {

	/**
	 * @Fields projectId : 项目ID
	 */
	private Integer projectId;
	
	/**
	 * @Fields code : code
	 */
	private String code;
	
	/**
	 * @Fields projTitle : 项目名称
	 */
	private String projTitle;
	
	/**
	 * @Fields name : 姓名
	 */
	private String name;
	
	/**
	 * @Fields job : 职务
	 */
	private String job;
	
	/**
	 * @Fields state : 状态
	 */
	private String state;
	
	/**
	 * @Fields college : 大学
	 */
	private String college;
	
	/**
	 * @Fields edu : 学历
	 */
	private String edu;
	
	/**
	 * @Fields introduction : 简介
	 */
	private String introduction;
	
	/**
	 * @Fields sourcecode : project code
	 */
	private String sourcecode;
	
    
	public Integer getProjectId(){
		return projectId;
	}

	public void setProjectId(Integer projectId){
		this.projectId = projectId;
	}
    
	public String getCode(){
		return code;
	}

	public void setCode(String code){
		this.code = code;
	}
    
	public String getProjTitle(){
		return projTitle;
	}

	public void setProjTitle(String projTitle){
		this.projTitle = projTitle;
	}
    
	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}
    
	public String getJob(){
		return job;
	}

	public void setJob(String job){
		this.job = job;
	}
    
	public String getState(){
		return state;
	}

	public void setState(String state){
		this.state = state;
	}
    
	public String getCollege(){
		return college;
	}

	public void setCollege(String college){
		this.college = college;
	}
    
	public String getEdu(){
		return edu;
	}

	public void setEdu(String edu){
		this.edu = edu;
	}
    
	public String getIntroduction(){
		return introduction;
	}

	public void setIntroduction(String introduction){
		this.introduction = introduction;
	}
    
	public String getSourcecode(){
		return sourcecode;
	}

	public void setSourcecode(String sourcecode){
		this.sourcecode = sourcecode;
	}
    }