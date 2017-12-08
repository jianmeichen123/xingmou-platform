package com.gi.ctdn.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.gi.ctdn.view.common.PojoInfo;

@JsonInclude(JsonInclude.Include.NON_NULL)
/**
 * 投资策略
 */
public class InvestPolicy extends PojoInfo {
	private Long id;
	/**
	 * 投资人code
	 */
	private String code;
	/**
	 * 关注行业
	 */
	private String fields;
	/**
	 * 投资阶段
	 */
	private String rounds;
	/**
	 * 投资计划
	 */
	private String plan;
	/**
	 * 单笔可投
	 */
	private String singleStroke;

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

	public String getFields() {
		return fields;
	}

	public void setFields(String fields) {
		this.fields = fields;
	}

	public String getRounds() {
		return rounds;
	}

	public void setRounds(String rounds) {
		this.rounds = rounds;
	}

	public String getPlan() {
		return plan;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}

	public String getSingleStroke() {
		return singleStroke;
	}

	public void setSingleStroke(String singleStroke) {
		this.singleStroke = singleStroke;
	}
}