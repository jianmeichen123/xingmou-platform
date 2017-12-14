package com.gi.ctdn.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.gi.ctdn.view.common.PojoInfo;

@JsonInclude(JsonInclude.Include.NON_NULL)
/**
 * 工作经历
 */
public class PersonWorkExpr extends PojoInfo {

	private Long id;
	/**
	 * 创业者/投资人 code
	 */
	private String code;
	/**
	 * 任职时间
	 */
	private String period;
	/**
	 * 所在项目名
	 */
	private String projTitle;
	/**
	 * 项目code
	 */
	private String projCode;
	/**
	 * 所属职位
	 */
	private String job;
	/**
	 * 创业者/投资人 S/I
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

	public String getProjTitle() {
		return projTitle;
	}

	public void setProjTitle(String projTitle) {
		this.projTitle = projTitle;
	}

	public String getProjCode() {
		return projCode;
	}

	public void setProjCode(String projCode) {
		this.projCode = projCode;
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