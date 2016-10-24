package com.gi.xm.report.pojo;

import java.sql.Timestamp;
import java.util.List;

public class Area extends Pojo {



	/**
	 * @Fields id : 
	 */
	private Long id;
	

	private Integer num;
	
	private String title;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}