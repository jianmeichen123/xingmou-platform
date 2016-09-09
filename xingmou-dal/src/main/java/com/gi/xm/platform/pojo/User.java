package com.gi.xm.platform.pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.sql.Timestamp;
import java.util.Date;

public class User extends Pojo {

        public static final String ID = "id";
        public static final String EMPLOY_NO = "工号";
        public static final String REAL_NAME = "真实姓名";
        public static final String NICK_NAME = "登录名称";
        public static final String STATUS = "账户状态： 0正常 ，1禁用";
        public static final String TYPE = "账户类型 ：目前未用";
        public static final String DEPARTMENT_ID = "部门id";
        public static final String DEPARTMENT_NAME = "冗余字段 部门名称";
        public static final String ROLE = "冗余字段角色名称";
        public static final String EMAIL = "email";
        public static final String PASSWORD = "密码";
        public static final String ORIGIN_PASSWORD = "初始密码";
        public static final String GENDER = "0 女 1男";
        public static final String IS_ADMIN = "是否管理员 目前未用";
        public static final String BIRTH = "birth";
        public static final String MOBILE = "mobile";
        public static final String TELEPHONE = "telephone";
        public static final String ADDRESS = "address";
        public static final String CREATED_TIME = "createdTime";
        public static final String UPDATED_TIME = "updatedTime";
    
	
	/**
	 * @Fields id : 
	 */
	private Long id;
	
	/**
	 * @Fields employNo : 工号
	 */
	private String employNo;
	
	/**
	 * @Fields realName : 真实姓名
	 */
	private String realName;
	
	/**
	 * @Fields nickName : 登录名称
	 */
	private String nickName;
	
	/**
	 * @Fields status : 账户状态： 0正常 ，1禁用
	 */
	private String status;
	
	/**
	 * @Fields type : 账户类型 ：目前未用
	 */
	private String type;
	
	/**
	 * @Fields departmentId : 部门id
	 */
	private Long departmentId;
	
	/**
	 * @Fields departmentName : 冗余字段 部门名称
	 */
	private String departmentName;
	
	/**
	 * @Fields role : 冗余字段角色名称
	 */
	private String role;
	
	/**
	 * @Fields email : 
	 */
	private String email;
	
	/**
	 * @Fields password : 密码
	 */
	private String password;
	
	/**
	 * @Fields originPassword : 初始密码
	 */
	private String originPassword;
	
	/**
	 * @Fields gender : 0 女 1男
	 */
	private Boolean gender;
	
	/**
	 * @Fields isAdmin : 是否管理员 目前未用
	 */
	private Boolean isAdmin;
	
	/**
	 * @Fields birth : 
	 */
	private Date birth;
	
	/**
	 * @Fields mobile : 
	 */
	private String mobile;
	
	/**
	 * @Fields telephone : 
	 */
	private String telephone;
	
	/**
	 * @Fields address : 
	 */
	private String address;
	
	/**
	 * @Fields createdTime : 
	 */
	private Long createdTime;
	
	/**
	 * @Fields updatedTime : 
	 */
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