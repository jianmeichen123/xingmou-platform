package com.gi.ctdn.query;


import com.gi.xm.platform.view.common.QueryInfo;

import java.util.Date;
import java.util.List;

public class EventsQueryInfo extends QueryInfo {
	
	/**   
	 * @Fields serialVersionUID : 序列化版本号 
	 */ 
	private static final long serialVersionUID = 1L;

	
	private Long id;
	
	private Long projectId;
	
	private Integer roundId;
	
	private String roundName;
	
	private Date eventDate;
	
	private String investfirmNames;
	
	private Long eventMoney;
	
	private Integer currencyId;
	
	private String currencyName;
	
	private Long createdUid;
	
	private String createdUname;
	
	private Long addTime;
	
	private Long updateTime;

	private List<Long> projectIdList;
		
    
	public Long getId(){
		return id;
	}
	
	public void setId(Long id){
		this.id = id;
	}
    
	public Long getProjectId(){
		return projectId;
	}
	
	public void setProjectId(Long projectId){
		this.projectId = projectId;
	}
    
	public Integer getRoundId(){
		return roundId;
	}
	
	public void setRoundId(Integer roundId){
		this.roundId = roundId;
	}
    
	public String getRoundName(){
		return roundName;
	}
	
	public void setRoundName(String roundName){
		this.roundName = roundName;
	}
    
	public Date getEventDate(){
		return eventDate;
	}
	
	public void setEventDate(Date eventDate){
		this.eventDate = eventDate;
	}
    
	public String getInvestfirmNames(){
		return investfirmNames;
	}
	
	public void setInvestfirmNames(String investfirmNames){
		this.investfirmNames = investfirmNames;
	}
    
	public Long getEventMoney(){
		return eventMoney;
	}
	
	public void setEventMoney(Long eventMoney){
		this.eventMoney = eventMoney;
	}
    
	public Integer getCurrencyId(){
		return currencyId;
	}
	
	public void setCurrencyId(Integer currencyId){
		this.currencyId = currencyId;
	}
    
	public String getCurrencyName(){
		return currencyName;
	}
	
	public void setCurrencyName(String currencyName){
		this.currencyName = currencyName;
	}
    
	public Long getCreatedUid(){
		return createdUid;
	}
	
	public void setCreatedUid(Long createdUid){
		this.createdUid = createdUid;
	}
    
	public String getCreatedUname(){
		return createdUname;
	}
	
	public void setCreatedUname(String createdUname){
		this.createdUname = createdUname;
	}
    
	public Long getAddTime(){
		return addTime;
	}
	
	public void setAddTime(Long addTime){
		this.addTime = addTime;
	}
    
	public Long getUpdateTime(){
		return updateTime;
	}
	
	public void setUpdateTime(Long updateTime){
		this.updateTime = updateTime;
	}

	public void setProjectIdList(List<Long> projectIdList) {
		this.projectIdList = projectIdList;
	}

	public List<Long> getProjectIdList() {
		return projectIdList;
	}
}