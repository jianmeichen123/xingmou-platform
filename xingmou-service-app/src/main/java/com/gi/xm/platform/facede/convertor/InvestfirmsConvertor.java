package com.gi.xm.platform.facede.convertor;
import java.util.ArrayList;
import java.util.List;

import java.util.Date;
import org.springframework.cglib.beans.BeanCopier;

import com.gi.xm.platform.view.InvestfirmsInfo;
import com.gi.xm.platform.view.InvestfirmsQueryInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.pojo.Investfirms;
import com.gi.xm.platform.query.InvestfirmsQuery;
import com.gi.xm.platform.biz.common.QueryResult;

public abstract class InvestfirmsConvertor {

	private static final BeanCopier beanCopierForInvestfirmsInfo = BeanCopier.create(Investfirms.class, InvestfirmsInfo.class, false);
	private static final BeanCopier beanCopierForInvestfirms = BeanCopier.create(InvestfirmsInfo.class, Investfirms.class, false);
	private static final BeanCopier beanCopierForInvestfirmsQuery = BeanCopier.create(InvestfirmsQueryInfo.class, InvestfirmsQuery.class, false);

	public static InvestfirmsInfo toInvestfirmsInfo(Investfirms investfirms)
	{
		if (investfirms == null) {
			return null;
		}
		InvestfirmsInfo investfirmsInfo = new InvestfirmsInfo();
		beanCopierForInvestfirmsInfo.copy(investfirms, investfirmsInfo, null);
		return investfirmsInfo;
	}

	public static Investfirms toInvestfirms(InvestfirmsInfo investfirmsInfo)
	{
		Investfirms investfirms = new Investfirms();
		beanCopierForInvestfirms.copy(investfirmsInfo, investfirms, null);
		return investfirms;
	}

	public static List<InvestfirmsInfo> toInvestfirmsInfoList(List<Investfirms> investfirmsList)
	{
		if (investfirmsList == null || investfirmsList.isEmpty()) {
			return null;
		}
		List<InvestfirmsInfo> investfirmsInfoList = new ArrayList<InvestfirmsInfo>(investfirmsList.size());
		for (Investfirms investfirms : investfirmsList) {
			investfirmsInfoList.add(toInvestfirmsInfo(investfirms));
		}
		return investfirmsInfoList;
	}

	public static List<Investfirms> toInvestfirmsList(List<InvestfirmsInfo> investfirmsInfoList)
	{
		if (investfirmsInfoList == null || investfirmsInfoList.isEmpty()) {
			return null;
		}
		List<Investfirms> investfirmsList = new ArrayList<Investfirms>(investfirmsInfoList.size());
		for (InvestfirmsInfo investfirmsInfo : investfirmsInfoList) {
			investfirmsList.add(toInvestfirms(investfirmsInfo));
		}
		return investfirmsList;
	}
	
	public static InvestfirmsQuery toInvestfirmsQuery(InvestfirmsQueryInfo investfirmsQueryInfo)
	{
		if (investfirmsQueryInfo== null) {
			return null;
		}
		InvestfirmsQuery investfirmsQuery = new InvestfirmsQuery();
		beanCopierForInvestfirmsQuery.copy(investfirmsQueryInfo, investfirmsQuery, null);
		return investfirmsQuery;
	}

	public static QueryResultInfo<InvestfirmsInfo> toQueryResultInfo(QueryResult<Investfirms> queryResult)
	{
		QueryResultInfo<InvestfirmsInfo> queryResultInfo = new QueryResultInfo<InvestfirmsInfo>();
		queryResultInfo.setPages(queryResult.getPages());
		queryResult.setRecords(queryResult.getRecords());
		queryResultInfo.setTotal(queryResult.getTotal());
		queryResultInfo.setRecords(toInvestfirmsInfoList(queryResult.getRecords()));
		return queryResultInfo;
	}
}