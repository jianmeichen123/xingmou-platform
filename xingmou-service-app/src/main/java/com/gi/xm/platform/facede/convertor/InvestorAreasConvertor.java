package com.gi.xm.platform.facede.convertor;
import java.util.ArrayList;
import java.util.List;

import java.util.Date;
import org.springframework.cglib.beans.BeanCopier;

import com.gi.xm.platform.view.InvestorAreasInfo;
import com.gi.xm.platform.view.InvestorAreasQueryInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.pojo.InvestorAreas;
import com.gi.xm.platform.query.InvestorAreasQuery;
import com.gi.xm.platform.biz.common.QueryResult;

public abstract class InvestorAreasConvertor {

	private static final BeanCopier beanCopierForInvestorAreasInfo = BeanCopier.create(InvestorAreas.class, InvestorAreasInfo.class, false);
	private static final BeanCopier beanCopierForInvestorAreas = BeanCopier.create(InvestorAreasInfo.class, InvestorAreas.class, false);
	private static final BeanCopier beanCopierForInvestorAreasQuery = BeanCopier.create(InvestorAreasQueryInfo.class, InvestorAreasQuery.class, false);

	public static InvestorAreasInfo toInvestorAreasInfo(InvestorAreas investorAreas)
	{
		if (investorAreas == null) {
			return null;
		}
		InvestorAreasInfo investorAreasInfo = new InvestorAreasInfo();
		beanCopierForInvestorAreasInfo.copy(investorAreas, investorAreasInfo, null);
		return investorAreasInfo;
	}

	public static InvestorAreas toInvestorAreas(InvestorAreasInfo investorAreasInfo)
	{
		InvestorAreas investorAreas = new InvestorAreas();
		beanCopierForInvestorAreas.copy(investorAreasInfo, investorAreas, null);
		return investorAreas;
	}

	public static List<InvestorAreasInfo> toInvestorAreasInfoList(List<InvestorAreas> investorAreasList)
	{
		if (investorAreasList == null || investorAreasList.isEmpty()) {
			return null;
		}
		List<InvestorAreasInfo> investorAreasInfoList = new ArrayList<InvestorAreasInfo>(investorAreasList.size());
		for (InvestorAreas investorAreas : investorAreasList) {
			investorAreasInfoList.add(toInvestorAreasInfo(investorAreas));
		}
		return investorAreasInfoList;
	}

	public static List<InvestorAreas> toInvestorAreasList(List<InvestorAreasInfo> investorAreasInfoList)
	{
		if (investorAreasInfoList == null || investorAreasInfoList.isEmpty()) {
			return null;
		}
		List<InvestorAreas> investorAreasList = new ArrayList<InvestorAreas>(investorAreasInfoList.size());
		for (InvestorAreasInfo investorAreasInfo : investorAreasInfoList) {
			investorAreasList.add(toInvestorAreas(investorAreasInfo));
		}
		return investorAreasList;
	}
	
	public static InvestorAreasQuery toInvestorAreasQuery(InvestorAreasQueryInfo investorAreasQueryInfo)
	{
		if (investorAreasQueryInfo== null) {
			return null;
		}
		InvestorAreasQuery investorAreasQuery = new InvestorAreasQuery();
		beanCopierForInvestorAreasQuery.copy(investorAreasQueryInfo, investorAreasQuery, null);
		return investorAreasQuery;
	}

	public static QueryResultInfo<InvestorAreasInfo> toQueryResultInfo(QueryResult<InvestorAreas> queryResult)
	{
		QueryResultInfo<InvestorAreasInfo> queryResultInfo = new QueryResultInfo<InvestorAreasInfo>();
		queryResultInfo.setPages(queryResult.getPages());
		queryResult.setRecords(queryResult.getRecords());
		queryResultInfo.setTotal(queryResult.getTotal());
		queryResultInfo.setRecords(toInvestorAreasInfoList(queryResult.getRecords()));
		return queryResultInfo;
	}
}