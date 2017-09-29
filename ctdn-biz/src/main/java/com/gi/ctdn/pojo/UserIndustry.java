package com.gi.ctdn.pojo;

import com.gi.xm.platform.view.common.PojoInfo;

import java.util.List;

public class UserIndustry extends PojoInfo {

	/**
	 * @Fields id : 
	 */
	private Long id;
	
	/**
	 * @Fields userId : 登录用户id
	 */
	private Integer userId;
	
	/**
	 * @Fields industryNames : 行业名称,用","分隔
	 */
	private String industryNames;

	private List<String> industryNameList;
	/**
	 * @Fields firstLogin : 0第一次登录 1不是第一次登录
	 */
	private Integer firstLogin;
	
	/**
	 * @Fields departmentId : 登录用户部门id
	 */
	private Integer departmentId;
	
	/**
	 * @Fields industryIds : 行业id,用","分隔
	 */
	private String industryIds;

	private List<Integer> industryIdList;
	
    
	public Long getId(){
		return id;
	}

	public void setId(Long id){
		this.id = id;
	}
    
	public Integer getUserId(){
		return userId;
	}

	public void setUserId(Integer userId){
		this.userId = userId;
	}
    
	public String getIndustryNames(){
		return industryNames;
	}

	public void setIndustryNames(String industryNames){
		this.industryNames = industryNames;
	}
    
	public Integer getFirstLogin(){
		return firstLogin;
	}

	public void setFirstLogin(Integer firstLogin){
		this.firstLogin = firstLogin;
	}
    
	public Integer getDepartmentId(){
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId){
		this.departmentId = departmentId;
	}
    
	public String getIndustryIds(){
		return industryIds;
	}

	public void setIndustryIds(String industryIds){
		this.industryIds = industryIds;
	}

	public List<String> getIndustryNameList() {
		return industryNameList;
	}

	public void setIndustryNameList(List<String> industryNameList) {
		this.industryNameList = industryNameList;
	}

	public List<Integer> getIndustryIdList() {
		return industryIdList;
	}

	public void setIndustryIdList(List<Integer> industryIdList) {
		this.industryIdList = industryIdList;
	}
}