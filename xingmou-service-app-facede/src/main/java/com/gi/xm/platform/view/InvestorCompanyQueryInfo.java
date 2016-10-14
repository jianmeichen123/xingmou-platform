package com.gi.xm.platform.view;

import java.util.Date;
import java.math.BigDecimal;
import java.io.Serializable;
import java.sql.Timestamp;
import com.gi.xm.platform.view.common.QueryInfo;

public class InvestorCompanyQueryInfo extends QueryInfo {
	
	/**   
	 * @Fields serialVersionUID : 序列化版本号 
	 */ 
	private static final long serialVersionUID = 1L;

	
	private Long id;
	
	private Long investorId;
	
	private Long inverstfirmId;
	
	private String inverstfirmName;
	
	private Long inverstfirmPostionId;
	
	private String inverstfirmPostionName;
	
	private Long sourceInverstfirmId;
	
	private Integer sortnum;
	
	private Integer status;
	
	private Timestamp addTime;
	
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
    
	public Long getInverstfirmId(){
		return inverstfirmId;
	}
	
	public void setInverstfirmId(Long inverstfirmId){
		this.inverstfirmId = inverstfirmId;
	}
    
	public String getInverstfirmName(){
		return inverstfirmName;
	}
	
	public void setInverstfirmName(String inverstfirmName){
		this.inverstfirmName = inverstfirmName;
	}
    
	public Long getInverstfirmPostionId(){
		return inverstfirmPostionId;
	}
	
	public void setInverstfirmPostionId(Long inverstfirmPostionId){
		this.inverstfirmPostionId = inverstfirmPostionId;
	}
    
	public String getInverstfirmPostionName(){
		return inverstfirmPostionName;
	}
	
	public void setInverstfirmPostionName(String inverstfirmPostionName){
		this.inverstfirmPostionName = inverstfirmPostionName;
	}
    
	public Long getSourceInverstfirmId(){
		return sourceInverstfirmId;
	}
	
	public void setSourceInverstfirmId(Long sourceInverstfirmId){
		this.sourceInverstfirmId = sourceInverstfirmId;
	}
    
	public Integer getSortnum(){
		return sortnum;
	}
	
	public void setSortnum(Integer sortnum){
		this.sortnum = sortnum;
	}
    
	public Integer getStatus(){
		return status;
	}
	
	public void setStatus(Integer status){
		this.status = status;
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