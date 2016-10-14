package com.gi.xm.platform.facede.convertor;
import java.util.ArrayList;
import java.util.List;

import java.util.Date;
import org.springframework.cglib.beans.BeanCopier;

import com.gi.xm.platform.view.InvestorInfo;
import com.gi.xm.platform.view.InvestorQueryInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.pojo.Investor;
import com.gi.xm.platform.query.InvestorQuery;
import com.gi.xm.platform.biz.common.QueryResult;

public abstract class InvestorConvertor {

	private static final BeanCopier beanCopierForInvestorInfo = BeanCopier.create(Investor.class, InvestorInfo.class, false);
	private static final BeanCopier beanCopierForInvestor = BeanCopier.create(InvestorInfo.class, Investor.class, false);
	private static final BeanCopier beanCopierForInvestorQuery = BeanCopier.create(InvestorQueryInfo.class, InvestorQuery.class, false);

	public static InvestorInfo toInvestorInfo(Investor investor)
	{
		if (investor == null) {
			return null;
		}
		InvestorInfo investorInfo = new InvestorInfo();
		beanCopierForInvestorInfo.copy(investor, investorInfo, null);
		return investorInfo;
	}

	public static Investor toInvestor(InvestorInfo investorInfo)
	{
		Investor investor = new Investor();
		beanCopierForInvestor.copy(investorInfo, investor, null);
		return investor;
	}

	public static List<InvestorInfo> toInvestorInfoList(List<Investor> investorList)
	{
		if (investorList == null || investorList.isEmpty()) {
			return null;
		}
		List<InvestorInfo> investorInfoList = new ArrayList<InvestorInfo>(investorList.size());
		for (Investor investor : investorList) {
			investorInfoList.add(toInvestorInfo(investor));
		}
		return investorInfoList;
	}

	public static List<Investor> toInvestorList(List<InvestorInfo> investorInfoList)
	{
		if (investorInfoList == null || investorInfoList.isEmpty()) {
			return null;
		}
		List<Investor> investorList = new ArrayList<Investor>(investorInfoList.size());
		for (InvestorInfo investorInfo : investorInfoList) {
			investorList.add(toInvestor(investorInfo));
		}
		return investorList;
	}
	
	public static InvestorQuery toInvestorQuery(InvestorQueryInfo investorQueryInfo)
	{
		if (investorQueryInfo== null) {
			return null;
		}
		InvestorQuery investorQuery = new InvestorQuery();
		beanCopierForInvestorQuery.copy(investorQueryInfo, investorQuery, null);
		return investorQuery;
	}

	public static QueryResultInfo<InvestorInfo> toQueryResultInfo(QueryResult<Investor> queryResult)
	{
		QueryResultInfo<InvestorInfo> queryResultInfo = new QueryResultInfo<InvestorInfo>();
		queryResultInfo.setPages(queryResult.getPages());
		queryResult.setRecords(queryResult.getRecords());
		queryResultInfo.setTotal(queryResult.getTotal());
		queryResultInfo.setRecords(toInvestorInfoList(queryResult.getRecords()));
		return queryResultInfo;
	}
}