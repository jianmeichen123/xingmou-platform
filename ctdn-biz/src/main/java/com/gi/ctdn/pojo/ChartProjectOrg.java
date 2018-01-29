package com.gi.ctdn.pojo;

import com.gi.ctdn.view.common.PojoInfo;

public class ChartProjectOrg extends PojoInfo{

	private static final long serialVersionUID = 1L;
	private Long industryId;
	private String industryName;
	private Long industrySubId;
	private String industrySubName;
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
	private Long eventId;
	private String projCode;
	private String projName;
	private String orgCode;
	private String orgName;
	private int industryType;
	private int timeType;
	
	private String source;
	private String target;
	
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public Long getEventId() {
		return eventId;
	}
	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}
	public String getProjCode() {
		return projCode;
	}
	public void setProjCode(String projCode) {
		this.projCode = projCode;
	}
	public String getProjName() {
		return projName;
	}
	public void setProjName(String projName) {
		this.projName = projName;
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
	
	public String getInvestDate() {
		return investDate;
	}
	public void setInvestDate(String investDate) {
		this.investDate = investDate;
	}
	public String getOrgNameAndCodes() {
		return orgNameAndCodes;
	}
	public void setOrgNameAndCodes(String orgNameAndCodes) {
		this.orgNameAndCodes = orgNameAndCodes;
	}
	private String investDate;
	private String orgNameAndCodes; // orgName:orgCode,orgName1:orgCode2

}
