package com.gi.xm.platform.facede.convertor;
import java.util.ArrayList;
import java.util.List;

import java.util.Date;
import org.springframework.cglib.beans.BeanCopier;

import com.gi.xm.platform.view.InvestfirmRoundInfo;
import com.gi.xm.platform.view.InvestfirmRoundQueryInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.pojo.InvestfirmRound;
import com.gi.xm.platform.query.InvestfirmRoundQuery;
import com.gi.xm.platform.biz.common.QueryResult;

public abstract class InvestfirmRoundConvertor {

	private static final BeanCopier beanCopierForInvestfirmRoundInfo = BeanCopier.create(InvestfirmRound.class, InvestfirmRoundInfo.class, false);
	private static final BeanCopier beanCopierForInvestfirmRound = BeanCopier.create(InvestfirmRoundInfo.class, InvestfirmRound.class, false);
	private static final BeanCopier beanCopierForInvestfirmRoundQuery = BeanCopier.create(InvestfirmRoundQueryInfo.class, InvestfirmRoundQuery.class, false);

	public static InvestfirmRoundInfo toInvestfirmRoundInfo(InvestfirmRound investfirmRound)
	{
		if (investfirmRound == null) {
			return null;
		}
		InvestfirmRoundInfo investfirmRoundInfo = new InvestfirmRoundInfo();
		beanCopierForInvestfirmRoundInfo.copy(investfirmRound, investfirmRoundInfo, null);
		return investfirmRoundInfo;
	}

	public static InvestfirmRound toInvestfirmRound(InvestfirmRoundInfo investfirmRoundInfo)
	{
		InvestfirmRound investfirmRound = new InvestfirmRound();
		beanCopierForInvestfirmRound.copy(investfirmRoundInfo, investfirmRound, null);
		return investfirmRound;
	}

	public static List<InvestfirmRoundInfo> toInvestfirmRoundInfoList(List<InvestfirmRound> investfirmRoundList)
	{
		if (investfirmRoundList == null || investfirmRoundList.isEmpty()) {
			return null;
		}
		List<InvestfirmRoundInfo> investfirmRoundInfoList = new ArrayList<InvestfirmRoundInfo>(investfirmRoundList.size());
		for (InvestfirmRound investfirmRound : investfirmRoundList) {
			investfirmRoundInfoList.add(toInvestfirmRoundInfo(investfirmRound));
		}
		return investfirmRoundInfoList;
	}

	public static List<InvestfirmRound> toInvestfirmRoundList(List<InvestfirmRoundInfo> investfirmRoundInfoList)
	{
		if (investfirmRoundInfoList == null || investfirmRoundInfoList.isEmpty()) {
			return null;
		}
		List<InvestfirmRound> investfirmRoundList = new ArrayList<InvestfirmRound>(investfirmRoundInfoList.size());
		for (InvestfirmRoundInfo investfirmRoundInfo : investfirmRoundInfoList) {
			investfirmRoundList.add(toInvestfirmRound(investfirmRoundInfo));
		}
		return investfirmRoundList;
	}
	
	public static InvestfirmRoundQuery toInvestfirmRoundQuery(InvestfirmRoundQueryInfo investfirmRoundQueryInfo)
	{
		if (investfirmRoundQueryInfo== null) {
			return null;
		}
		InvestfirmRoundQuery investfirmRoundQuery = new InvestfirmRoundQuery();
		beanCopierForInvestfirmRoundQuery.copy(investfirmRoundQueryInfo, investfirmRoundQuery, null);
		return investfirmRoundQuery;
	}

	public static QueryResultInfo<InvestfirmRoundInfo> toQueryResultInfo(QueryResult<InvestfirmRound> queryResult)
	{
		QueryResultInfo<InvestfirmRoundInfo> queryResultInfo = new QueryResultInfo<InvestfirmRoundInfo>();
		queryResultInfo.setPages(queryResult.getPages());
		queryResult.setRecords(queryResult.getRecords());
		queryResultInfo.setTotal(queryResult.getTotal());
		queryResultInfo.setRecords(toInvestfirmRoundInfoList(queryResult.getRecords()));
		return queryResultInfo;
	}
}