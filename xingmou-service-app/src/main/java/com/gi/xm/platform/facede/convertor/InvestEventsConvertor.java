package com.gi.xm.platform.facede.convertor;
import java.util.ArrayList;
import java.util.List;

import java.util.Date;
import org.springframework.cglib.beans.BeanCopier;

import com.gi.xm.platform.view.InvestEventsInfo;
import com.gi.xm.platform.view.InvestEventsQueryInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.pojo.InvestEvents;
import com.gi.xm.platform.query.InvestEventsQuery;
import com.gi.xm.platform.biz.common.QueryResult;

public abstract class InvestEventsConvertor {

	private static final BeanCopier beanCopierForInvestEventsInfo = BeanCopier.create(InvestEvents.class, InvestEventsInfo.class, false);
	private static final BeanCopier beanCopierForInvestEvents = BeanCopier.create(InvestEventsInfo.class, InvestEvents.class, false);
	private static final BeanCopier beanCopierForInvestEventsQuery = BeanCopier.create(InvestEventsQueryInfo.class, InvestEventsQuery.class, false);

	public static InvestEventsInfo toInvestEventsInfo(InvestEvents investEvents)
	{
		if (investEvents == null) {
			return null;
		}
		InvestEventsInfo investEventsInfo = new InvestEventsInfo();
		beanCopierForInvestEventsInfo.copy(investEvents, investEventsInfo, null);
		return investEventsInfo;
	}

	public static InvestEvents toInvestEvents(InvestEventsInfo investEventsInfo)
	{
		InvestEvents investEvents = new InvestEvents();
		beanCopierForInvestEvents.copy(investEventsInfo, investEvents, null);
		return investEvents;
	}

	public static List<InvestEventsInfo> toInvestEventsInfoList(List<InvestEvents> investEventsList)
	{
		if (investEventsList == null || investEventsList.isEmpty()) {
			return null;
		}
		List<InvestEventsInfo> investEventsInfoList = new ArrayList<InvestEventsInfo>(investEventsList.size());
		for (InvestEvents investEvents : investEventsList) {
			investEventsInfoList.add(toInvestEventsInfo(investEvents));
		}
		return investEventsInfoList;
	}

	public static List<InvestEvents> toInvestEventsList(List<InvestEventsInfo> investEventsInfoList)
	{
		if (investEventsInfoList == null || investEventsInfoList.isEmpty()) {
			return null;
		}
		List<InvestEvents> investEventsList = new ArrayList<InvestEvents>(investEventsInfoList.size());
		for (InvestEventsInfo investEventsInfo : investEventsInfoList) {
			investEventsList.add(toInvestEvents(investEventsInfo));
		}
		return investEventsList;
	}
	
	public static InvestEventsQuery toInvestEventsQuery(InvestEventsQueryInfo investEventsQueryInfo)
	{
		if (investEventsQueryInfo== null) {
			return null;
		}
		InvestEventsQuery investEventsQuery = new InvestEventsQuery();
		beanCopierForInvestEventsQuery.copy(investEventsQueryInfo, investEventsQuery, null);
		return investEventsQuery;
	}

	public static QueryResultInfo<InvestEventsInfo> toQueryResultInfo(QueryResult<InvestEvents> queryResult)
	{
		QueryResultInfo<InvestEventsInfo> queryResultInfo = new QueryResultInfo<InvestEventsInfo>();
		queryResultInfo.setPages(queryResult.getPages());
		queryResult.setRecords(queryResult.getRecords());
		queryResultInfo.setTotal(queryResult.getTotal());
		queryResultInfo.setRecords(toInvestEventsInfoList(queryResult.getRecords()));
		return queryResultInfo;
	}
}