package com.gi.ctdn.pojo;

import java.util.List;

import com.gi.ctdn.view.common.PojoInfo;

public class ChartProjectOrgPartner extends PojoInfo{

	private static final long serialVersionUID = 1L;
	
	private Long industryId;
	private String industryName;
	private Long industrySubId;
	private String industrySubName;
	private String orgCode;
	private String orgName;
	private String partnerOrgCode;
	private String partnerOrgName;
	private Long eventNum;
	private Long eventNumAll;
	private int industryType;
	private int timeType;
	
	private Long partnerCount;
	private Long competeCount;
	private List<Industry> industryList;
	private String orgJson;
	private List<ChartProjectOrgPartner> partnerList;
	public Long getPartnerCount() {
		return partnerCount;
	}
	public void setPartnerCount(Long partnerCount) {
		this.partnerCount = partnerCount;
	}
	public Long getCompeteCount() {
		return competeCount;
	}
	public void setCompeteCount(Long competeCount) {
		this.competeCount = competeCount;
	}
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
	public String getPartnerOrgCode() {
		return partnerOrgCode;
	}
	public void setPartnerOrgCode(String partnerOrgCode) {
		this.partnerOrgCode = partnerOrgCode;
	}
	public String getPartnerOrgName() {
		return partnerOrgName;
	}
	public void setPartnerOrgName(String partnerOrgName) {
		this.partnerOrgName = partnerOrgName;
	}
	public Long getEventNum() {
		return eventNum;
	}
	public void setEventNum(Long eventNum) {
		this.eventNum = eventNum;
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
	public List<Industry> getIndustryList() {
		return industryList;
	}
	public void setIndustryList(List<Industry> industryList) {
		this.industryList = industryList;
	}
	public String getOrgJson() {
		return orgJson;
	}
	public void setPartnerJson(String orgJson) {
		this.orgJson = orgJson;
	}
	public List<ChartProjectOrgPartner> getPartnerList() {
		return partnerList;
	}
	public void setPartnerList(List<ChartProjectOrgPartner> partnerList) {
		this.partnerList = partnerList;
	}
	
	
	

}
