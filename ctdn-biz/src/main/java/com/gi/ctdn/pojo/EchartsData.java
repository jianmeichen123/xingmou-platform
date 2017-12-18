package com.gi.ctdn.pojo;

import java.util.List;

import com.gi.ctdn.view.common.PojoInfo;


public class EchartsData<E> extends PojoInfo {

	private List<E> series;
	
	private List<String> xAxis;
	
	private List<String> legend;

	public List<E> getSeries() {
		return series;
	}

	public void setSeries(List<E> series) {
		this.series = series;
	}

	public List<String> getxAxis() {
		return xAxis;
	}

	public void setxAxis(List<String> xAxis) {
		this.xAxis = xAxis;
	}

	public List<String> getLegend() {
		return legend;
	}

	public void setLegend(List<String> legend) {
		this.legend = legend;
	}
	
	
}
