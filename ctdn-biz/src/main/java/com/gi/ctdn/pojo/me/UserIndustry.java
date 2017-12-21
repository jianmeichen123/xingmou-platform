package com.gi.ctdn.pojo.me;

import com.gi.ctdn.view.common.PojoInfo;

import java.util.List;

public class UserIndustry  extends PojoInfo{

	/**
	 * @Fields id : 
	 */
	private Long id;
	
	/**
	 * @Fields userId : 登录用户code
	 */
	private String userCode;

	private Integer industryId;

	private String industryName;
	/**
	 * @Fields industryNames : 行业名称,用","分隔
	 */
	private String industryNames;

	private List<String> industryNameList;
	/**
	 * @Fields industryIds : 行业id,用","分隔
	 */
	private String industryIds;

	private List<Integer> industryIdList;

	/**
	 * 1使用 0删除
	 */
	private Integer isdel;


	public Long getId(){
		return id;
	}

	public void setId(Long id){
		this.id = id;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserCode() {
		return userCode;
	}

	public String getIndustryNames(){
		return industryNames;
	}

	public void setIndustryNames(String industryNames){
		this.industryNames = industryNames;
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

	public void setIsdel(Integer isdel) {
		this.isdel = isdel;
	}

	public Integer getIsdel() {
		return isdel;
	}

	public void setIndustryId(Integer industryId) {
		this.industryId = industryId;
	}

	public Integer getIndustryId() {
		return industryId;
	}

	public void setIndustryName(String industryName) {
		this.industryName = industryName;
	}

	public String getIndustryName() {
		return industryName;
	}
	
}