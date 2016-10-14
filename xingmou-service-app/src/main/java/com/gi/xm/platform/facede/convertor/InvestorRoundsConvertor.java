package com.gi.xm.platform.facede.convertor;
import java.util.ArrayList;
import java.util.List;

import java.util.Date;
import org.springframework.cglib.beans.BeanCopier;

import com.gi.xm.platform.view.InvestorRoundsInfo;
import com.gi.xm.platform.view.InvestorRoundsQueryInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.pojo.InvestorRounds;
import com.gi.xm.platform.query.InvestorRoundsQuery;
import com.gi.xm.platform.biz.common.QueryResult;

public abstract class InvestorRoundsConvertor {

	private static final BeanCopier beanCopierForInvestorRoundsInfo = BeanCopier.create(InvestorRounds.class, InvestorRoundsInfo.class, false);
	private static final BeanCopier beanCopierForInvestorRounds = BeanCopier.create(InvestorRoundsInfo.class, InvestorRounds.class, false);
	private static final BeanCopier beanCopierForInvestorRoundsQuery = BeanCopier.create(InvestorRoundsQueryInfo.class, InvestorRoundsQuery.class, false);

	public static InvestorRoundsInfo toInvestorRoundsInfo(InvestorRounds investorRounds)
	{
		if (investorRounds == null) {
			return null;
		}
		InvestorRoundsInfo investorRoundsInfo = new InvestorRoundsInfo();
		beanCopierForInvestorRoundsInfo.copy(investorRounds, investorRoundsInfo, null);
		return investorRoundsInfo;
	}

	public static InvestorRounds toInvestorRounds(InvestorRoundsInfo investorRoundsInfo)
	{
		InvestorRounds investorRounds = new InvestorRounds();
		beanCopierForInvestorRounds.copy(investorRoundsInfo, investorRounds, null);
		return investorRounds;
	}

	public static List<InvestorRoundsInfo> toInvestorRoundsInfoList(List<InvestorRounds> investorRoundsList)
	{
		if (investorRoundsList == null || investorRoundsList.isEmpty()) {
			return null;
		}
		List<InvestorRoundsInfo> investorRoundsInfoList = new ArrayList<InvestorRoundsInfo>(investorRoundsList.size());
		for (InvestorRounds investorRounds : investorRoundsList) {
			investorRoundsInfoList.add(toInvestorRoundsInfo(investorRounds));
		}
		return investorRoundsInfoList;
	}

	public static List<InvestorRounds> toInvestorRoundsList(List<InvestorRoundsInfo> investorRoundsInfoList)
	{
		if (investorRoundsInfoList == null || investorRoundsInfoList.isEmpty()) {
			return null;
		}
		List<InvestorRounds> investorRoundsList = new ArrayList<InvestorRounds>(investorRoundsInfoList.size());
		for (InvestorRoundsInfo investorRoundsInfo : investorRoundsInfoList) {
			investorRoundsList.add(toInvestorRounds(investorRoundsInfo));
		}
		return investorRoundsList;
	}
	
	public static InvestorRoundsQuery toInvestorRoundsQuery(InvestorRoundsQueryInfo investorRoundsQueryInfo)
	{
		if (investorRoundsQueryInfo== null) {
			return null;
		}
		InvestorRoundsQuery investorRoundsQuery = new InvestorRoundsQuery();
		beanCopierForInvestorRoundsQuery.copy(investorRoundsQueryInfo, investorRoundsQuery, null);
		return investorRoundsQuery;
	}

	public static QueryResultInfo<InvestorRoundsInfo> toQueryResultInfo(QueryResult<InvestorRounds> queryResult)
	{
		QueryResultInfo<InvestorRoundsInfo> queryResultInfo = new QueryResultInfo<InvestorRoundsInfo>();
		queryResultInfo.setPages(queryResult.getPages());
		queryResult.setRecords(queryResult.getRecords());
		queryResultInfo.setTotal(queryResult.getTotal());
		queryResultInfo.setRecords(toInvestorRoundsInfoList(queryResult.getRecords()));
		return queryResultInfo;
	}
}