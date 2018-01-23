package com.gi.ctdn.dao;

import java.util.List;

import com.gi.ctdn.pojo.ChartProjectOrgCompete;
import com.gi.ctdn.pojo.ChartProjectOrgPartner;

public interface ChartProjectOrgCompeteDao {
	
	List<ChartProjectOrgCompete> selectChartProjectOrgCompete(ChartProjectOrgCompete chartProjectOrgCompete);

	Long getCompeteCount(ChartProjectOrgPartner chartProjectOrgPartner);

	List<ChartProjectOrgCompete> getParentCompeteList(ChartProjectOrgCompete chartProjectOrgCompete);

	List<ChartProjectOrgCompete> getChildCompeteList(ChartProjectOrgCompete chartProjectOrgCompete);

}
