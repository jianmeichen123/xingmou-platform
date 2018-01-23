package com.gi.ctdn.pojo;

import java.util.List;

import com.gi.ctdn.view.common.PojoInfo;

public class OrgProjectChart extends PojoInfo{

	private static final long serialVersionUID = 1L;
	
	private List<ChartProjectOrg> chartProjectOrgList;
	
	private List<ChartProjectOrg> orgNameList;
	
	private List<ChartProjectOrg> projectNameList;

	public List<ChartProjectOrg> getChartProjectOrgList() {
		return chartProjectOrgList;
	}

	public void setChartProjectOrgList(List<ChartProjectOrg> chartProjectOrgList) {
		this.chartProjectOrgList = chartProjectOrgList;
	}

	public List<ChartProjectOrg> getOrgNameList() {
		return orgNameList;
	}

	public void setOrgNameList(List<ChartProjectOrg> orgNameList) {
		this.orgNameList = orgNameList;
	}

	public List<ChartProjectOrg> getProjectNameList() {
		return projectNameList;
	}

	public void setProjectNameList(List<ChartProjectOrg> projectNameList) {
		this.projectNameList = projectNameList;
	}

	
	
}
