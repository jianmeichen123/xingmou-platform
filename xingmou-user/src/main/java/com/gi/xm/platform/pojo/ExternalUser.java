package com.gi.xm.platform.pojo;

import com.galaxyinternet.framework.core.model.BaseEntity;

public class ExternalUser extends BaseEntity{
	
	private Long id;
	private String mobile;
	private String password;
	private String roleType;
	private String status; // 1/第一次登录 0/不是第一次登录
	private String confirmPassword;
	
	private String code; //验证码
	private String type; //验证码类型（1、登录2、找回验证码3、注册）

	private boolean exists;

	private Long rolecode;

	private String userCode;//id+from encodeBase64
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getRoleType() {
		return roleType;
	}
	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public boolean isExists() {
		return exists;
	}
	public void setExists(boolean exists) {
		this.exists = exists;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserCode() {
		return userCode;
	}

	public Long getRolecode() {
		return rolecode;
	}

	public void setRolecode(Long rolecode) {
		this.rolecode = rolecode;
	}
	
	public boolean isEmptyPassword() {
		return isEmptyPassword;
	}
	public void setEmptyPassword(boolean isEmptyPassword) {
		this.isEmptyPassword = isEmptyPassword;
	}

	private boolean isEmptyPassword; //密码是否为空
	
}
