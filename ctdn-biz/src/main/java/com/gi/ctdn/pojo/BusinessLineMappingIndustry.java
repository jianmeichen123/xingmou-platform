package com.gi.ctdn.pojo;

import com.gi.ctdn.view.common.PojoInfo;

public class BusinessLineMappingIndustry extends PojoInfo{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private String industryIds;
	private String industryNames;
	private String isEmpty;
	private Long departmentId;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIndustryIds() {
		return industryIds;
	}
	public void setIndustryIds(String industryIds) {
		this.industryIds = industryIds;
	}
	public String getIndustryNames() {
		return industryNames;
	}
	public void setIndustryNames(String industryNames) {
		this.industryNames = industryNames;
	}
	public String getIsEmpty() {
		return isEmpty;
	}
	public void setIsEmpty(String isEmpty) {
		this.isEmpty = isEmpty;
	}
	public Long getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
	
	

}
