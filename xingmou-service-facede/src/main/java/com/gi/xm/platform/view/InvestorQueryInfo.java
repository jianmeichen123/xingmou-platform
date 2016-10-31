package com.gi.xm.platform.view;

import java.util.Date;
import java.math.BigDecimal;
import java.io.Serializable;
import java.sql.Timestamp;
import com.gi.xm.platform.view.common.QueryInfo;

public class InvestorQueryInfo extends QueryInfo {
	
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
    
}