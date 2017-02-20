package ctdn.query;


import com.gi.xm.platform.view.common.QueryInfo;

public class TeamMembersQueryInfo extends QueryInfo {
	
	/**   
	 * @Fields serialVersionUID : 序列化版本号 
	 */ 
	private static final long serialVersionUID = 1L;

	
	private Long id;
	
	private Long projectId;
	
	private String avatar;
	
	private String name;
	
	private String sex;
	
	private String email;
	
	private String phone;
	
	private String info;
	
	private Integer isFounder;
	
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
    
	public String getAvatar(){
		return avatar;
	}
	
	public void setAvatar(String avatar){
		this.avatar = avatar;
	}
    
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
    
	public String getSex(){
		return sex;
	}
	
	public void setSex(String sex){
		this.sex = sex;
	}
    
	public String getEmail(){
		return email;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
    
	public String getPhone(){
		return phone;
	}
	
	public void setPhone(String phone){
		this.phone = phone;
	}
    
	public String getInfo(){
		return info;
	}
	
	public void setInfo(String info){
		this.info = info;
	}
    
	public Integer getIsFounder(){
		return isFounder;
	}
	
	public void setIsFounder(Integer isFounder){
		this.isFounder = isFounder;
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