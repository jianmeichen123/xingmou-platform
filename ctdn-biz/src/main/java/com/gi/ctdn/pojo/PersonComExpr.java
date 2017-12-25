package com.gi.ctdn.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.gi.ctdn.view.common.PojoInfo;


/**
 * 创业经历
 */
public class PersonComExpr extends PojoInfo {
	private Long id;
	/**
	 * 创业者/投资人code
	 */
	private String code;
	/**
	 * 项目code
	 */
	private String projCode;
	/**
	 * 项目成立时间
	 */
	private String projSetUpDT;
	/**
	 * 项目名
	 */
	private String projTitle;
	/**
	 * 官网
	 */
	private String projUrl;
	/**
	 * 一级行业
	 */
	private String industryName;
	/**
	 * 二级行业
	 */
	private String industrySubName;
	/**
	 * 一级地区
	 */
	private String districtName;
	/**
	 * 二级地区
	 */
	private String districtSubName;
	/**
	 * 三级地区
	 */
	private String districtGrandsonName;
	/**
	 * 最新融资轮次
	 */
	private String latestFinanceRound;
	/**
	 * 最新融资金额
	 */
	private String latestFinanceAmountStr;
	/**
	 * 项目简介
	 */
	private String projIntroduce;
	/**
	 * 在职时间
	 */
	private String jobPeriod;
	/**
	 *职位
	 */
	private String job;
	/**
	 * 创业者/投资人（S/I）
	 */
	private String type;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getProjCode() {
		return projCode;
	}

	public void setProjCode(String projCode) {
		this.projCode = projCode;
	}

	public String getProjSetUpDT() {
		return projSetUpDT;
	}

	public void setProjSetUpDT(String projSetUpDT) {
		this.projSetUpDT = projSetUpDT;
	}

	public String getProjTitle() {
		return projTitle;
	}

	public void setProjTitle(String projTitle) {
		this.projTitle = projTitle;
	}

	public String getProjUrl() {
		return projUrl;
	}

	public void setProjUrl(String projUrl) {
		this.projUrl = projUrl;
	}

	public String getIndustryName() {
		return industryName;
	}

	public void setIndustryName(String industryName) {
		this.industryName = industryName;
	}

	public String getIndustrySubName() {
		return industrySubName;
	}

	public void setIndustrySubName(String industrySubName) {
		this.industrySubName = industrySubName;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public String getDistrictSubName() {
		return districtSubName;
	}

	public void setDistrictSubName(String districtSubName) {
		this.districtSubName = districtSubName;
	}

	public String getDistrictGrandsonName() {
		return districtGrandsonName;
	}

	public void setDistrictGrandsonName(String districtGrandsonName) {
		this.districtGrandsonName = districtGrandsonName;
	}

	public String getLatestFinanceRound() {
		return latestFinanceRound;
	}

	public void setLatestFinanceRound(String latestFinanceRound) {
		this.latestFinanceRound = latestFinanceRound;
	}

	public String getLatestFinanceAmountStr() {
		return latestFinanceAmountStr;
	}

	public void setLatestFinanceAmountStr(String latestFinanceAmountStr) {
		this.latestFinanceAmountStr = latestFinanceAmountStr;
	}

	public String getProjIntroduce() {
		return projIntroduce;
	}

	public void setProjIntroduce(String projIntroduce) {
		this.projIntroduce = projIntroduce;
	}

	public String getJobPeriod() {
		return jobPeriod;
	}

	public void setJobPeriod(String jobPeriod) {
		this.jobPeriod = jobPeriod;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}