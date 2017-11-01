package com.gi.ctdn.view.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class QueryResultInfo<E>  implements Serializable  {

	/**   
	 * @Fields serialVersionUID : TODO 
	 */ 
	private static final long serialVersionUID = -4137328713263172465L;
	
	private Integer pages;
	private List<E> records;
	private Long total;

	private final List<E> empty = new ArrayList<>();

	public Integer getPages() {
		return pages;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}

	public List<E> getRecords() {
		if (records == null){
			return empty;
		}
		return records;
	}

	public void setRecords(List<E> records) {
		this.records = records;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

}
