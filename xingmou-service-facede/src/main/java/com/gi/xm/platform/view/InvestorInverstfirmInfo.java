package com.gi.xm.platform.view;

import java.math.BigDecimal;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class InvestorInverstfirmInfo implements Serializable {

	/**   
	 * @Fields serialVersionUID : 序列化版本号 
	 */ 
	private static final long serialVersionUID = 1L;

			
	/**
	 * @Fields id : 
	 */
	private Long id;
			
	/**
	 * @Fields investorId : 投资人id
	 */
	private Long investorId;
			
	/**
	 * @Fields title : 
	 */
	private String title;
			
	/**
	 * @Fields sortnum : 
	 */
	private Integer sortnum;
			
	public Long getId(){
		return id;
	}
	
	public void setId(Long id){
		this.id = id;
	}
    
	public Long getInvestorId(){
		return investorId;
	}
	
	public void setInvestorId(Long investorId){
		this.investorId = investorId;
	}
    
	public String getTitle(){
		return title;
	}
	
	public void setTitle(String title){
		this.title = title;
	}
    
	public Integer getSortnum(){
		return sortnum;
	}
	
	public void setSortnum(Integer sortnum){
		this.sortnum = sortnum;
	}
    
}