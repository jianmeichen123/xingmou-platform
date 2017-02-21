package com.gi.ctdn.pojo;

import java.io.Serializable;
import java.util.List;

public class TeamMembersInfo extends CtdnPojo implements Serializable {

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
	 * @Fields avatar : 头像文件地址
	 */
	private String avatar;
			
	/**
	 * @Fields name : 创始人姓名
	 */
	private String name;
			
	/**
	 * @Fields sex : 
	 */
	private String sex;
			
	/**
	 * @Fields email : 创始人邮箱
	 */
	private String email;
			
	/**
	 * @Fields phone : 创始人电话
	 */
	private String phone;
			
	/**
	 * @Fields info : 创始人简介
	 */
	private String info;
			
	/**
	 * @Fields isFounder : 是否创始人
	 */
	private Integer isFounder;

	/**
	 * @Fields studyInfoList : 学习经历冗余
     */
	private List<TeamMemberStudyInfo> studyInfoList;

	/**
	 * @Fields jobInfoList : 学习经历冗余
     */
	private List<TeamMemberJobInfo> jobInfoList;

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

	public List<TeamMemberStudyInfo> getStudyInfoList() {
		return studyInfoList;
	}

	public void setStudyInfoList(List<TeamMemberStudyInfo> studyInfoList) {
		this.studyInfoList = studyInfoList;
	}

	public List<TeamMemberJobInfo> getJobInfoList() {
		return jobInfoList;
	}

	public void setJobInfoList(List<TeamMemberJobInfo> jobInfoList) {
		this.jobInfoList = jobInfoList;
	}
}