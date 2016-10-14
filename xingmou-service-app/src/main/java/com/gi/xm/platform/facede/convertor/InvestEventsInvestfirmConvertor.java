package com.gi.xm.platform.facede.convertor;
import java.util.ArrayList;
import java.util.List;

import java.util.Date;
import org.springframework.cglib.beans.BeanCopier;

import com.gi.xm.platform.view.InvestEventsInvestfirmInfo;
import com.gi.xm.platform.view.InvestEventsInvestfirmQueryInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.pojo.InvestEventsInvestfirm;
import com.gi.xm.platform.query.InvestEventsInvestfirmQuery;
import com.gi.xm.platform.biz.common.QueryResult;

public abstract class InvestEventsInvestfirmConvertor {

	private static final BeanCopier beanCopierForInvestEventsInvestfirmInfo = BeanCopier.create(InvestEventsInvestfirm.class, InvestEventsInvestfirmInfo.class, false);
	private static final BeanCopier beanCopierForInvestEventsInvestfirm = BeanCopier.create(InvestEventsInvestfirmInfo.class, InvestEventsInvestfirm.class, false);
	private static final BeanCopier beanCopierForInvestEventsInvestfirmQuery = BeanCopier.create(InvestEventsInvestfirmQueryInfo.class, InvestEventsInvestfirmQuery.class, false);

	public static InvestEventsInvestfirmInfo toInvestEventsInvestfirmInfo(InvestEventsInvestfirm investEventsInvestfirm)
	{
		if (investEventsInvestfirm == null) {
			return null;
		}
		InvestEventsInvestfirmInfo investEventsInvestfirmInfo = new InvestEventsInvestfirmInfo();
		beanCopierForInvestEventsInvestfirmInfo.copy(investEventsInvestfirm, investEventsInvestfirmInfo, null);
		return investEventsInvestfirmInfo;
	}

	public static InvestEventsInvestfirm toInvestEventsInvestfirm(InvestEventsInvestfirmInfo investEventsInvestfirmInfo)
	{
		InvestEventsInvestfirm investEventsInvestfirm = new InvestEventsInvestfirm();
		beanCopierForInvestEventsInvestfirm.copy(investEventsInvestfirmInfo, investEventsInvestfirm, null);
		return investEventsInvestfirm;
	}

	public static List<InvestEventsInvestfirmInfo> toInvestEventsInvestfirmInfoList(List<InvestEventsInvestfirm> investEventsInvestfirmList)
	{
		if (investEventsInvestfirmList == null || investEventsInvestfirmList.isEmpty()) {
			return null;
		}
		List<InvestEventsInvestfirmInfo> investEventsInvestfirmInfoList = new ArrayList<InvestEventsInvestfirmInfo>(investEventsInvestfirmList.size());
		for (InvestEventsInvestfirm investEventsInvestfirm : investEventsInvestfirmList) {
			investEventsInvestfirmInfoList.add(toInvestEventsInvestfirmInfo(investEventsInvestfirm));
		}
		return investEventsInvestfirmInfoList;
	}

	public static List<InvestEventsInvestfirm> toInvestEventsInvestfirmList(List<InvestEventsInvestfirmInfo> investEventsInvestfirmInfoList)
	{
		if (investEventsInvestfirmInfoList == null || investEventsInvestfirmInfoList.isEmpty()) {
			return null;
		}
		List<InvestEventsInvestfirm> investEventsInvestfirmList = new ArrayList<InvestEventsInvestfirm>(investEventsInvestfirmInfoList.size());
		for (InvestEventsInvestfirmInfo investEventsInvestfirmInfo : investEventsInvestfirmInfoList) {
			investEventsInvestfirmList.add(toInvestEventsInvestfirm(investEventsInvestfirmInfo));
		}
		return investEventsInvestfirmList;
	}
	
	public static InvestEventsInvestfirmQuery toInvestEventsInvestfirmQuery(InvestEventsInvestfirmQueryInfo investEventsInvestfirmQueryInfo)
	{
		if (investEventsInvestfirmQueryInfo== null) {
			return null;
		}
		InvestEventsInvestfirmQuery investEventsInvestfirmQuery = new InvestEventsInvestfirmQuery();
		beanCopierForInvestEventsInvestfirmQuery.copy(investEventsInvestfirmQueryInfo, investEventsInvestfirmQuery, null);
		return investEventsInvestfirmQuery;
	}

	public static QueryResultInfo<InvestEventsInvestfirmInfo> toQueryResultInfo(QueryResult<InvestEventsInvestfirm> queryResult)
	{
		QueryResultInfo<InvestEventsInvestfirmInfo> queryResultInfo = new QueryResultInfo<InvestEventsInvestfirmInfo>();
		queryResultInfo.setPages(queryResult.getPages());
		queryResult.setRecords(queryResult.getRecords());
		queryResultInfo.setTotal(queryResult.getTotal());
		queryResultInfo.setRecords(toInvestEventsInvestfirmInfoList(queryResult.getRecords()));
		return queryResultInfo;
	}
}