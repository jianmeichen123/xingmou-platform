package com.gi.ctdn.pojo;

import com.gi.ctdn.view.common.PojoInfo;

public class ChartProjectOrgCompete extends PojoInfo{

	private static final long serialVersionUID = 1L;
	
	private Long industryId;
	private String industryName;
	private Long industrySubId;
	private String industrySubName;
	private String orgCode;
	private String orgName;
	private String competeOrgCode;
	private String competeOrgName;
	private Long orgEventNum;
	private Long competeOrgEventNum;
	private Long eventNumAll;
	private int industryType;
	private int timeType;
	public Long getIndustryId() {
		return industryId;
	}
	public void setIndustryId(Long industryId) {
		this.industryId = industryId;
	}
	public String getIndustryName() {
		return industryName;
	}
	public void setIndustryName(String industryName) {
		this.industryName = industryName;
	}
	public Long getIndustrySubId() {
		return industrySubId;
	}
	public void setIndustrySubId(Long industrySubId) {
		this.industrySubId = industrySubId;
	}
	public String getIndustrySubName() {
		return industrySubName;
	}
	public void setIndustrySubName(String industrySubName) {
		this.industrySubName = industrySubName;
	}
	public String getOrgCode() {
		return orgCode;
	}
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getCompeteOrgCode() {
		return competeOrgCode;
	}
	public void setCompeteOrgCode(String competeOrgCode) {
		this.competeOrgCode = competeOrgCode;
	}
	public String getCompeteOrgName() {
		return competeOrgName;
	}
	public void setCompeteOrgName(String competeOrgName) {
		this.competeOrgName = competeOrgName;
	}
	public Long getOrgEventNum() {
		return orgEventNum;
	}
	public void setOrgEventNum(Long orgEventNum) {
		this.orgEventNum = orgEventNum;
	}
	public Long getCompeteOrgEventNum() {
		return competeOrgEventNum;
	}
	public void setCompeteOrgEventNum(Long competeOrgEventNum) {
		this.competeOrgEventNum = competeOrgEventNum;
	}
	public Long getEventNumAll() {
		return eventNumAll;
	}
	public void setEventNumAll(Long eventNumAll) {
		this.eventNumAll = eventNumAll;
	}
	public int getIndustryType() {
		return industryType;
	}
	public void setIndustryType(int industryType) {
		this.industryType = industryType;
	}
	public int getTimeType() {
		return timeType;
	}
	public void setTimeType(int timeType) {
		this.timeType = timeType;
	}
	
	

}
