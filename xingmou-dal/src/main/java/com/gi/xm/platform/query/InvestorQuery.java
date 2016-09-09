package com.gi.xm.platform.query;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class InvestorQuery extends Query {
	
	/**   
	 * @Fields serialVersionUID : 序列化版本号 
	 */ 
	private static final long serialVersionUID = 1L;
	
			
	private Long id;
			
	private String name;
			
	private Integer investfirmId;
			
	private String investfirmName;
			
	private Integer investfirmPostionId;
			
	private String investfirmPostionName;
			
	private String icon;
			
	private String local;
			
	private String description;
			
	private Timestamp addTime;
			
	private Timestamp updateTime;
		
    
	public Long getId(){
		return id;
	}
	public void setId(Long id){
		this.id = id;
	}
    
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
    
	public Integer getInvestfirmId(){
		return investfirmId;
	}
	public void setInvestfirmId(Integer investfirmId){
		this.investfirmId = investfirmId;
	}
    
	public String getInvestfirmName(){
		return investfirmName;
	}
	public void setInvestfirmName(String investfirmName){
		this.investfirmName = investfirmName;
	}
    
	public Integer getInvestfirmPostionId(){
		return investfirmPostionId;
	}
	public void setInvestfirmPostionId(Integer investfirmPostionId){
		this.investfirmPostionId = investfirmPostionId;
	}
    
	public String getInvestfirmPostionName(){
		return investfirmPostionName;
	}
	public void setInvestfirmPostionName(String investfirmPostionName){
		this.investfirmPostionName = investfirmPostionName;
	}
    
	public String getIcon(){
		return icon;
	}
	public void setIcon(String icon){
		this.icon = icon;
	}
    
	public String getLocal(){
		return local;
	}
	public void setLocal(String local){
		this.local = local;
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