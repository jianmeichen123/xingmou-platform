package com.gi.xm.platform.pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.sql.Timestamp;
import java.util.Date;

public class InvestorInverstfirm extends Pojo {

        public static final String ID = "id";
        public static final String INVESTOR_ID = "投资人id";
        public static final String TITLE = "title";
        public static final String SORTNUM = "sortnum";
        public static final String ADD_TIME = "addTime";
        public static final String UPDATE_TIME = "updateTime";
    
	
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