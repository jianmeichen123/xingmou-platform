package com.gi.xm.platform.query;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class DataQuery extends Query {
	
	/**   
	 * @Fields serialVersionUID : 序列化版本号 
	 */ 
	private static final long serialVersionUID = 1L;
	
			
	private Integer id;
			
	private Integer projectNum;
			
	private Integer projectInvestedNum;
			
	private Long investedMoney;
			
	private Long investedMoneyPerProject;
			
	private Timestamp addTime;
			
	private Timestamp updateTime;
		
    
	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id = id;
	}
    
	public Integer getProjectNum(){
		return projectNum;
	}
	public void setProjectNum(Integer projectNum){
		this.projectNum = projectNum;
	}
    
	public Integer getProjectInvestedNum(){
		return projectInvestedNum;
	}
	public void setProjectInvestedNum(Integer projectInvestedNum){
		this.projectInvestedNum = projectInvestedNum;
	}
    
	public Long getInvestedMoney(){
		return investedMoney;
	}
	public void setInvestedMoney(Long investedMoney){
		this.investedMoney = investedMoney;
	}
    
	public Long getInvestedMoneyPerProject(){
		return investedMoneyPerProject;
	}
	public void setInvestedMoneyPerProject(Long investedMoneyPerProject){
		this.investedMoneyPerProject = investedMoneyPerProject;
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