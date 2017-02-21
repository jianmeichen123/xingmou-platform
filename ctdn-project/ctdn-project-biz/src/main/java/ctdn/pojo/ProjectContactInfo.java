package ctdn.pojo;

import java.io.Serializable;

public class ProjectContactInfo implements Serializable {

	/**   
	 * @Fields serialVersionUID : 序列化版本号 
	 */ 
	private static final long serialVersionUID = 1L;

			
	/**
	 * @Fields id : 
	 */
	private Long id;
			
	/**
	 * @Fields projectId : 
	 */
	private Long projectId;
			
	/**
	 * @Fields contactName : 联系人姓名
	 */
	private String contactName;
			
	/**
	 * @Fields contactPosition : 联系人职务
	 */
	private String contactPosition;
			
	/**
	 * @Fields contactEmail : 联系人邮箱
	 */
	private String contactEmail;
			
	/**
	 * @Fields contactPhone : 联系人手机
	 */
	private String contactPhone;
			
	/**
	 * @Fields contactRole : 联系人在公司的角色
	 */
	private String contactRole;
			
	/**
	 * @Fields createdUid : 创建人id
	 */
	private Long createdUid;
			
	/**
	 * @Fields createdUname : 创建人名称
	 */
	private String createdUname;
			
	/**
	 * @Fields addTime : 
	 */
	private Long addTime;
			
	/**
	 * @Fields updateTime : 
	 */
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