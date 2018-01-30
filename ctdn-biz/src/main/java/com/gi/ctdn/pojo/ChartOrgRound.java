package com.gi.ctdn.pojo;

import com.gi.ctdn.view.common.PojoInfo;

public class ChartOrgRound extends PojoInfo {

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
	private Long roundId;
	private String roundName;
	private Long orgNum;
	private String orgJson;
	private Long rank;
	private int industryType;
	private String timeType;
	public Long getRoundId() {
		return roundId;
	}
	public void setRoundId(Long roundId) {
		this.roundId = roundId;
	}
	public String getRoundName() {
		return roundName;
	}
	public void setRoundName(String roundName) {
		this.roundName = roundName;
	}
	public Long getOrgNum() {
		return orgNum;
	}
	public void setOrgNum(Long orgNum) {
		this.orgNum = orgNum;
	}
	public String getOrgJson() {
		return orgJson;
	}
	public void setOrgJson(String orgJson) {
		this.orgJson = orgJson;
	}
	public Long getRank() {
		return rank;
	}
	public void setRank(Long rank) {
		this.rank = rank;
	}
	public int getIndustryType() {
		return industryType;
	}
	public void setIndustryType(int industryType) {
		this.industryType = industryType;
	}
	public String getTimeType() {
		return timeType;
	}
	public void setTimeType(String timeType) {
		this.timeType = timeType;
	}
	
}
