package com.gi.xm.platform.facede.convertor;
import java.util.ArrayList;
import java.util.List;

import java.util.Date;
import org.springframework.cglib.beans.BeanCopier;

import com.gi.xm.platform.view.InvestorStudyInfo;
import com.gi.xm.platform.view.InvestorStudyQueryInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.pojo.InvestorStudy;
import com.gi.xm.platform.query.InvestorStudyQuery;
import com.gi.xm.platform.biz.common.QueryResult;

public abstract class InvestorStudyConvertor {

	private static final BeanCopier beanCopierForInvestorStudyInfo = BeanCopier.create(InvestorStudy.class, InvestorStudyInfo.class, false);
	private static final BeanCopier beanCopierForInvestorStudy = BeanCopier.create(InvestorStudyInfo.class, InvestorStudy.class, false);
	private static final BeanCopier beanCopierForInvestorStudyQuery = BeanCopier.create(InvestorStudyQueryInfo.class, InvestorStudyQuery.class, false);

	public static InvestorStudyInfo toInvestorStudyInfo(InvestorStudy investorStudy)
	{
		if (investorStudy == null) {
			return null;
		}
		InvestorStudyInfo investorStudyInfo = new InvestorStudyInfo();
		beanCopierForInvestorStudyInfo.copy(investorStudy, investorStudyInfo, null);
		return investorStudyInfo;
	}

	public static InvestorStudy toInvestorStudy(InvestorStudyInfo investorStudyInfo)
	{
		InvestorStudy investorStudy = new InvestorStudy();
		beanCopierForInvestorStudy.copy(investorStudyInfo, investorStudy, null);
		return investorStudy;
	}

	public static List<InvestorStudyInfo> toInvestorStudyInfoList(List<InvestorStudy> investorStudyList)
	{
		if (investorStudyList == null || investorStudyList.isEmpty()) {
			return null;
		}
		List<InvestorStudyInfo> investorStudyInfoList = new ArrayList<InvestorStudyInfo>(investorStudyList.size());
		for (InvestorStudy investorStudy : investorStudyList) {
			investorStudyInfoList.add(toInvestorStudyInfo(investorStudy));
		}
		return investorStudyInfoList;
	}

	public static List<InvestorStudy> toInvestorStudyList(List<InvestorStudyInfo> investorStudyInfoList)
	{
		if (investorStudyInfoList == null || investorStudyInfoList.isEmpty()) {
			return null;
		}
		List<InvestorStudy> investorStudyList = new ArrayList<InvestorStudy>(investorStudyInfoList.size());
		for (InvestorStudyInfo investorStudyInfo : investorStudyInfoList) {
			investorStudyList.add(toInvestorStudy(investorStudyInfo));
		}
		return investorStudyList;
	}
	
	public static InvestorStudyQuery toInvestorStudyQuery(InvestorStudyQueryInfo investorStudyQueryInfo)
	{
		if (investorStudyQueryInfo== null) {
			return null;
		}
		InvestorStudyQuery investorStudyQuery = new InvestorStudyQuery();
		beanCopierForInvestorStudyQuery.copy(investorStudyQueryInfo, investorStudyQuery, null);
		return investorStudyQuery;
	}

	public static QueryResultInfo<InvestorStudyInfo> toQueryResultInfo(QueryResult<InvestorStudy> queryResult)
	{
		QueryResultInfo<InvestorStudyInfo> queryResultInfo = new QueryResultInfo<InvestorStudyInfo>();
		queryResultInfo.setPages(queryResult.getPages());
		queryResult.setRecords(queryResult.getRecords());
		queryResultInfo.setTotal(queryResult.getTotal());
		queryResultInfo.setRecords(toInvestorStudyInfoList(queryResult.getRecords()));
		return queryResultInfo;
	}
}