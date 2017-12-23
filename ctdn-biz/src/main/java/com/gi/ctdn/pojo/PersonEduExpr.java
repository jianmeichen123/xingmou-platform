package com.gi.ctdn.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.gi.ctdn.view.common.PojoInfo;

/**
 * 创业者教育经历
 */
public class PersonEduExpr extends PojoInfo {
	private Long id;
	/**
	 * 创业者/投资人code
	 */
	private String code;
	/**
	 * 时间段
	 */
	private String period;
	/**
	 * 大学
	 */
	private String colleage;
	/**
	 * 专业
	 */
	private String major;
	/**
	 * 学位
	 */
	private String degree;
	/**
	 * 创业者/投资人(S/I)
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

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getColleage() {
		return colleage;
	}

	public void setColleage(String colleage) {
		this.colleage = colleage;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}