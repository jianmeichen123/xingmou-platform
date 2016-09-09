package com.gi.xm.platform.query;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class UserQuery extends Query {
	
	/**   
	 * @Fields serialVersionUID : 序列化版本号 
	 */ 
	private static final long serialVersionUID = 1L;
	
			
	private Long id;
			
	private String employNo;
			
	private String realName;
			
	private String nickName;
			
	private String status;
			
	private String type;
			
	private Long departmentId;
			
	private String departmentName;
			
	private String role;
			
	private String email;
			
	private String password;
			
	private String originPassword;
			
	private Boolean gender;
			
	private Boolean isAdmin;
			
	private Date birth;
			
	private String mobile;
			
	private String telephone;
			
	private String address;
			
	private Long createdTime;
			
	private Long updatedTime;
		
    
	public Long getId(){
		return id;
	}
	public void setId(Long id){
		this.id = id;
	}
    
	public String getEmployNo(){
		return employNo;
	}
	public void setEmployNo(String employNo){
		this.employNo = employNo;
	}
    
	public String getRealName(){
		return realName;
	}
	public void setRealName(String realName){
		this.realName = realName;
	}
    
	public String getNickName(){
		return nickName;
	}
	public void setNickName(String nickName){
		this.nickName = nickName;
	}
    
	public String getStatus(){
		return status;
	}
	public void setStatus(String status){
		this.status = status;
	}
    
	public String getType(){
		return type;
	}
	public void setType(String type){
		this.type = type;
	}
    
	public Long getDepartmentId(){
		return departmentId;
	}
	public void setDepartmentId(Long departmentId){
		this.departmentId = departmentId;
	}
    
	public String getDepartmentName(){
		return departmentName;
	}
	public void setDepartmentName(String departmentName){
		this.departmentName = departmentName;
	}
    
	public String getRole(){
		return role;
	}
	public void setRole(String role){
		this.role = role;
	}
    
	public String getEmail(){
		return email;
	}
	public void setEmail(String email){
		this.email = email;
	}
    
	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password = password;
	}
    
	public String getOriginPassword(){
		return originPassword;
	}
	public void setOriginPassword(String originPassword){
		this.originPassword = originPassword;
	}
    
	public Boolean getGender(){
		return gender;
	}
	public void setGender(Boolean gender){
		this.gender = gender;
	}
    
	public Boolean getIsAdmin(){
		return isAdmin;
	}
	public void setIsAdmin(Boolean isAdmin){
		this.isAdmin = isAdmin;
	}
    
	public Date getBirth(){
		return birth;
	}
	public void setBirth(Date birth){
		this.birth = birth;
	}
    
	public String getMobile(){
		return mobile;
	}
	public void setMobile(String mobile){
		this.mobile = mobile;
	}
    
	public String getTelephone(){
		return telephone;
	}
	public void setTelephone(String telephone){
		this.telephone = telephone;
	}
    
	public String getAddress(){
		return address;
	}
	public void setAddress(String address){
		this.address = address;
	}
    
	public Long getCreatedTime(){
		return createdTime;
	}
	public void setCreatedTime(Long createdTime){
		this.createdTime = createdTime;
	}
    
	public Long getUpdatedTime(){
		return updatedTime;
	}
	public void setUpdatedTime(Long updatedTime){
		this.updatedTime = updatedTime;
	}
    }