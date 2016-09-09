package com.gi.xm.platform.pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.sql.Timestamp;
import java.util.Date;

public class ProjectPerson extends Pojo {

        public static final String ID = "id";
        public static final String PROJECT_ID = "项目id";
        public static final String NAME = "姓名";
        public static final String ICON = "头像";
        public static final String ADD_TIME = "addTime";
        public static final String UPDATE_TIME = "updateTime";
    
	
	/**
	 * @Fields id : 
	 */
	private Integer id;
	
	/**
	 * @Fields projectId : 项目id
	 */
	private Long projectId;
	
	/**
	 * @Fields name : 姓名
	 */
	private String name;
	
	/**
	 * @Fields icon : 头像
	 */
	private String icon;
	
	/**
	 * @Fields addTime : 
	 */
	private Timestamp addTime;
	
	/**
	 * @Fields updateTime : 
	 */
	private Timestamp updateTime;
	
    
	public Integer getId(){
		return id;
	}

	public void setId(Integer id){
		this.id = id;
	}
    
	public Long getProjectId(){
		return projectId;
	}

	public void setProjectId(Long projectId){
		this.projectId = projectId;
	}
    
	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}
    
	public String getIcon(){
		return icon;
	}

	public void setIcon(String icon){
		this.icon = icon;
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