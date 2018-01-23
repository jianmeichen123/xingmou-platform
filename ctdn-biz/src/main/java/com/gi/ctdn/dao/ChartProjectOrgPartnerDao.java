package com.gi.ctdn.dao;

import java.util.List;

import com.gi.ctdn.pojo.ChartProjectOrgPartner;

public interface ChartProjectOrgPartnerDao {
	
	List<ChartProjectOrgPartner> selectChartProjectOrgPartner(ChartProjectOrgPartner chartProjectOrgPartner);

	Long getPartnerCount(ChartProjectOrgPartner chartProjectOrgPartner);

	List<ChartProjectOrgPartner> getParentPartnerList(ChartProjectOrgPartner chartProjectOrgPartner);

	List<ChartProjectOrgPartner> getChildPartnerList(ChartProjectOrgPartner chartProjectOrgPartner);
	

}
