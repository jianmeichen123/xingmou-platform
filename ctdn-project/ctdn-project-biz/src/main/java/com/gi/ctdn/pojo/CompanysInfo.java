package com.gi.ctdn.pojo;

import java.io.Serializable;
import java.util.Date;

public class CompanysInfo extends  CtdnPojo implements Serializable {

	/**   
	 * @Fields serialVersionUID : 序列化版本号 
	 */ 
	private static final long serialVersionUID = 1L;

			
	/**
	 * @Fields id : 
	 */
	private Long id;
			
	/**
	 * @Fields title : 公司名称
	 */
	private String title;
			
	/**
	 * @Fields districtId : 一级地区id
	 */
	private Integer districtId;
			
	/**
	 * @Fields districtName : 一级地区名称
	 */
	private String districtName;
			
	/**
	 * @Fields districtSubId : 二级地区id
	 */
	private Integer districtSubId;
			
	/**
	 * @Fields districtSubName : 二级地区名称
	 */
	private String districtSubName;
			
	/**
	 * @Fields employeeNumber : 公司规模，根据员工人数划分等级
	 */
	private Integer employeeNumber;
			
	/**
	 * @Fields foundDate : 公司成立时间
	 */
	private Date foundDate;

	/**
	 * @Fields needStatus:融资需求
	 */
	private Integer needStatus;
			
	/**
	 * @Fields roundId : 融资阶段id
	 */
	private Integer roundId;
			
	/**
	 * @Fields roundName : 融资阶段名称
	 */
	private String roundName;

	/**
	 * ＠Fields projectId 冗余
     */
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

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getRoundName(){
		return roundName;
	}
	
	public void setRoundName(String roundName){
		this.roundName = roundName;
	}

	public void setNeedStatus(Integer needStatus) {
		this.needStatus = needStatus;
	}

	public Integer getNeedStatus() {
		return needStatus;
	}
}