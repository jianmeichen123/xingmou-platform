package com.gi.xm.platform.view;

import java.io.Serializable;
import java.sql.Timestamp;

public class ProjectPersonInfo implements Serializable {

	/**   
	 * @Fields serialVersionUID : 序列化版本号 
	 */ 
	private static final long serialVersionUID = 1L;

			
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
	 * @Fields isCoreMember : 1核心成员 0非核心成员
	 */
	private Integer isCoreMember;
			
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
    
	public Integer getIsCoreMember(){
		return isCoreMember;
	}
	
	public void setIsCoreMember(Integer isCoreMember){
		this.isCoreMember = isCoreMember;
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