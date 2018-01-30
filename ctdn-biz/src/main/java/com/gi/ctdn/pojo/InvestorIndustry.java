package com.gi.ctdn.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.gi.ctdn.view.common.PojoInfo;

public class InvestorIndustry  extends PojoInfo {


	private Integer id;

	private String name;

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
}