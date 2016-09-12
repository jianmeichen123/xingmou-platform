package com.gi.xm.platform.query;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class InvestProjectInvestfirmQuery extends Query {
	
	/**   
	 * @Fields serialVersionUID : 序列化版本号 
	 */ 
	private static final long serialVersionUID = 1L;
	
			
	private Long id;
			
	private Long investId;
			
	private String investName;
			
	private Long projectId;
			
	private String projectName;
			
	private Long investfirmId;
			
	private String investfirmName;
			
	private Timestamp addTime;
			
	private Timestamp updateTime;
		
    private Long year;

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


    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }
}