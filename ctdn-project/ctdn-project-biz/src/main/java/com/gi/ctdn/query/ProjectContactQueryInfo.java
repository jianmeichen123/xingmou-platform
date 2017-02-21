package com.gi.ctdn.query;


import com.gi.xm.platform.view.common.QueryInfo;

public class ProjectContactQueryInfo extends QueryInfo {
	
	/**   
	 * @Fields serialVersionUID : 序列化版本号 
	 */ 
	private static final long serialVersionUID = 1L;

	
	private Long id;
	
	private Long projectId;
	
	private String contactName;
	
	private String contactPosition;
	
	private String contactEmail;
	
	private String contactPhone;
	
	private String contactRole;
	
	private Long createdUid;
	
	private String createdUname;
	
	private Long addTime;
	
	private Long updateTime;
		
    
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
    
	public String getContactName(){
		return contactName;
	}
	
	public void setContactName(String contactName){
		this.contactName = contactName;
	}
    
	public String getContactPosition(){
		return contactPosition;
	}
	
	public void setContactPosition(String contactPosition){
		this.contactPosition = contactPosition;
	}
    
	public String getContactEmail(){
		return contactEmail;
	}
	
	public void setContactEmail(String contactEmail){
		this.contactEmail = contactEmail;
	}
    
	public String getContactPhone(){
		return contactPhone;
	}
	
	public void setContactPhone(String contactPhone){
		this.contactPhone = contactPhone;
	}
    
	public String getContactRole(){
		return contactRole;
	}
	
	public void setContactRole(String contactRole){
		this.contactRole = contactRole;
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
    }