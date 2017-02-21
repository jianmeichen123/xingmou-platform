package com.gi.ctdn.query;


import com.gi.xm.platform.view.common.QueryInfo;

import java.util.Date;

public class CompanysQueryInfo extends QueryInfo {
	
	/**   
	 * @Fields serialVersionUID : 序列化版本号 
	 */ 
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String title;
	
	private Integer districtId;
	
	private String districtName;
	
	private Integer districtSubId;
	
	private String districtSubName;
	
	private Integer employeeNumber;
	
	private Date foundDate;
	
	private Integer roundId;
	
	private String roundName;
	
	private Long createdUid;
	
	private String createdUname;

	private Long projectId;

	public Long getId(){
		return id;
	}
	
	public void setId(Long id){
		this.id = id;
	}
    
	public String getTitle(){
		return title;
	}
	
	public void setTitle(String title){
		this.title = title;
	}
    
	public Integer getDistrictId(){
		return districtId;
	}
	
	public void setDistrictId(Integer districtId){
		this.districtId = districtId;
	}
    
	public String getDistrictName(){
		return districtName;
	}
	
	public void setDistrictName(String districtName){
		this.districtName = districtName;
	}
    
	public Integer getDistrictSubId(){
		return districtSubId;
	}
	
	public void setDistrictSubId(Integer districtSubId){
		this.districtSubId = districtSubId;
	}
    
	public String getDistrictSubName(){
		return districtSubName;
	}
	
	public void setDistrictSubName(String districtSubName){
		this.districtSubName = districtSubName;
	}
    
	public Integer getEmployeeNumber(){
		return employeeNumber;
	}
	
	public void setEmployeeNumber(Integer employeeNumber){
		this.employeeNumber = employeeNumber;
	}
    
	public Date getFoundDate(){
		return foundDate;
	}
	
	public void setFoundDate(Date foundDate){
		this.foundDate = foundDate;
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

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
}