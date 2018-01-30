package com.gi.ctdn.pojo;

import com.gi.ctdn.view.common.PojoInfo;

public class InvestorRound  extends PojoInfo{


	private Integer id;

	private String name;

	private Integer showOrder;

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

	public Integer getShowOrder() {
		return showOrder;
	}

	public void setShowOrder(Integer showOrder) {
		this.showOrder = showOrder;
	}
}