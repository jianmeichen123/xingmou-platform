package com.gi.xm.platform.view;

import java.math.BigDecimal;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class InvestProjectInvestfirmInfo implements Serializable {

	/**   
	 * @Fields serialVersionUID : 序列化版本号 
	 */ 
	private static final long serialVersionUID = 1L;

			
	/**
	 * @Fields id : 
	 */
	private Long id;
			
	/**
	 * @Fields investId : 投资事件id
	 */
	private Long investId;
			
	/**
	 * @Fields investName : 投资事件标题(冗余)
	 */
	private String investName;
			
	/**
	 * @Fields projectId : 项目id
	 */
	private Long projectId;
			
	/**
	 * @Fields projectName : 项目名称（冗余）
	 */
	private String projectName;
			
	/**
	 * @Fields investfirmId : 投资机构id
	 */
	private Long investfirmId;
			
	/**
	 * @Fields investfirmName : 投资机构名称（冗余）
	 */
	private String investfirmName;
			
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
    
	public Long getInvestId(){
		return investId;
	}
	
	public void setInvestId(Long investId){
		this.investId = investId;
	}
    
	public String getInvestName(){
		return investName;
	}
	
	public void setInvestName(String investName){
		this.investName = investName;
	}
    
	public Long getProjectId(){
		return projectId;
	}
	
	public void setProjectId(Long projectId){
		this.projectId = projectId;
	}
    
	public String getProjectName(){
		return projectName;
	}
	
	public void setProjectName(String projectName){
		this.projectName = projectName;
	}
    
	public Long getInvestfirmId(){
		return investfirmId;
	}
	
	public void setInvestfirmId(Long investfirmId){
		this.investfirmId = investfirmId;
	}
    
	public String getInvestfirmName(){
		return investfirmName;
	}
	
	public void setInvestfirmName(String investfirmName){
		this.investfirmName = investfirmName;
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