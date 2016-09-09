package com.gi.xm.platform.facede.convertor;
import java.util.ArrayList;
import java.util.List;

import java.util.Date;
import org.springframework.cglib.beans.BeanCopier;

import com.gi.xm.platform.view.InvestfirmsDataYearInfo;
import com.gi.xm.platform.view.InvestfirmsDataYearQueryInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.pojo.InvestfirmsDataYear;
import com.gi.xm.platform.query.InvestfirmsDataYearQuery;
import com.gi.xm.platform.biz.common.QueryResult;

public abstract class InvestfirmsDataYearConvertor {

	private static final BeanCopier beanCopierForInvestfirmsDataYearInfo = BeanCopier.create(InvestfirmsDataYear.class, InvestfirmsDataYearInfo.class, false);
	private static final BeanCopier beanCopierForInvestfirmsDataYear = BeanCopier.create(InvestfirmsDataYearInfo.class, InvestfirmsDataYear.class, false);
	private static final BeanCopier beanCopierForInvestfirmsDataYearQuery = BeanCopier.create(InvestfirmsDataYearQueryInfo.class, InvestfirmsDataYearQuery.class, false);

	public static InvestfirmsDataYearInfo toInvestfirmsDataYearInfo(InvestfirmsDataYear investfirmsDataYear)
	{
		if (investfirmsDataYear == null) {
			return null;
		}
		InvestfirmsDataYearInfo investfirmsDataYearInfo = new InvestfirmsDataYearInfo();
		beanCopierForInvestfirmsDataYearInfo.copy(investfirmsDataYear, investfirmsDataYearInfo, null);
		return investfirmsDataYearInfo;
	}

	public static InvestfirmsDataYear toInvestfirmsDataYear(InvestfirmsDataYearInfo investfirmsDataYearInfo)
	{
		InvestfirmsDataYear investfirmsDataYear = new InvestfirmsDataYear();
		beanCopierForInvestfirmsDataYear.copy(investfirmsDataYearInfo, investfirmsDataYear, null);
		return investfirmsDataYear;
	}

	public static List<InvestfirmsDataYearInfo> toInvestfirmsDataYearInfoList(List<InvestfirmsDataYear> investfirmsDataYearList)
	{
		if (investfirmsDataYearList == null || investfirmsDataYearList.isEmpty()) {
			return null;
		}
		List<InvestfirmsDataYearInfo> investfirmsDataYearInfoList = new ArrayList<InvestfirmsDataYearInfo>(investfirmsDataYearList.size());
		for (InvestfirmsDataYear investfirmsDataYear : investfirmsDataYearList) {
			investfirmsDataYearInfoList.add(toInvestfirmsDataYearInfo(investfirmsDataYear));
		}
		return investfirmsDataYearInfoList;
	}

	public static List<InvestfirmsDataYear> toInvestfirmsDataYearList(List<InvestfirmsDataYearInfo> investfirmsDataYearInfoList)
	{
		if (investfirmsDataYearInfoList == null || investfirmsDataYearInfoList.isEmpty()) {
			return null;
		}
		List<InvestfirmsDataYear> investfirmsDataYearList = new ArrayList<InvestfirmsDataYear>(investfirmsDataYearInfoList.size());
		for (InvestfirmsDataYearInfo investfirmsDataYearInfo : investfirmsDataYearInfoList) {
			investfirmsDataYearList.add(toInvestfirmsDataYear(investfirmsDataYearInfo));
		}
		return investfirmsDataYearList;
	}
	
	public static InvestfirmsDataYearQuery toInvestfirmsDataYearQuery(InvestfirmsDataYearQueryInfo investfirmsDataYearQueryInfo)
	{
		if (investfirmsDataYearQueryInfo== null) {
			return null;
		}
		InvestfirmsDataYearQuery investfirmsDataYearQuery = new InvestfirmsDataYearQuery();
		beanCopierForInvestfirmsDataYearQuery.copy(investfirmsDataYearQueryInfo, investfirmsDataYearQuery, null);
		return investfirmsDataYearQuery;
	}

	public static QueryResultInfo<InvestfirmsDataYearInfo> toQueryResultInfo(QueryResult<InvestfirmsDataYear> queryResult)
	{
		QueryResultInfo<InvestfirmsDataYearInfo> queryResultInfo = new QueryResultInfo<InvestfirmsDataYearInfo>();
		queryResultInfo.setPages(queryResult.getPages());
		queryResult.setRecords(queryResult.getRecords());
		queryResultInfo.setTotal(queryResult.getTotal());
		queryResultInfo.setRecords(toInvestfirmsDataYearInfoList(queryResult.getRecords()));
		return queryResultInfo;
	}
}