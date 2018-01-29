package com.gi.ctdn.dao;

import java.util.List;

import com.gi.ctdn.pojo.ChartProjectOrg;

public interface ChartProjectOrgDao {

	List<ChartProjectOrg> selectChartProjectOrg(ChartProjectOrg chartProjectOrg);
	List<ChartProjectOrg> getDistrictOrgNameList(ChartProjectOrg chartProjectOrg);
	List<ChartProjectOrg> getDistrictProjectNameList(ChartProjectOrg chartProjectOrg);
	List<String> getTopOrgEventId(ChartProjectOrg chartProjectOrg);
}
