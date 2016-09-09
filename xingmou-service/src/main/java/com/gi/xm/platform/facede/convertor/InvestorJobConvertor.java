package com.gi.xm.platform.facede.convertor;
import java.util.ArrayList;
import java.util.List;

import java.util.Date;
import org.springframework.cglib.beans.BeanCopier;

import com.gi.xm.platform.view.InvestorJobInfo;
import com.gi.xm.platform.view.InvestorJobQueryInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.pojo.InvestorJob;
import com.gi.xm.platform.query.InvestorJobQuery;
import com.gi.xm.platform.biz.common.QueryResult;

public abstract class InvestorJobConvertor {

	private static final BeanCopier beanCopierForInvestorJobInfo = BeanCopier.create(InvestorJob.class, InvestorJobInfo.class, false);
	private static final BeanCopier beanCopierForInvestorJob = BeanCopier.create(InvestorJobInfo.class, InvestorJob.class, false);
	private static final BeanCopier beanCopierForInvestorJobQuery = BeanCopier.create(InvestorJobQueryInfo.class, InvestorJobQuery.class, false);

	public static InvestorJobInfo toInvestorJobInfo(InvestorJob investorJob)
	{
		if (investorJob == null) {
			return null;
		}
		InvestorJobInfo investorJobInfo = new InvestorJobInfo();
		beanCopierForInvestorJobInfo.copy(investorJob, investorJobInfo, null);
		return investorJobInfo;
	}

	public static InvestorJob toInvestorJob(InvestorJobInfo investorJobInfo)
	{
		InvestorJob investorJob = new InvestorJob();
		beanCopierForInvestorJob.copy(investorJobInfo, investorJob, null);
		return investorJob;
	}

	public static List<InvestorJobInfo> toInvestorJobInfoList(List<InvestorJob> investorJobList)
	{
		if (investorJobList == null || investorJobList.isEmpty()) {
			return null;
		}
		List<InvestorJobInfo> investorJobInfoList = new ArrayList<InvestorJobInfo>(investorJobList.size());
		for (InvestorJob investorJob : investorJobList) {
			investorJobInfoList.add(toInvestorJobInfo(investorJob));
		}
		return investorJobInfoList;
	}

	public static List<InvestorJob> toInvestorJobList(List<InvestorJobInfo> investorJobInfoList)
	{
		if (investorJobInfoList == null || investorJobInfoList.isEmpty()) {
			return null;
		}
		List<InvestorJob> investorJobList = new ArrayList<InvestorJob>(investorJobInfoList.size());
		for (InvestorJobInfo investorJobInfo : investorJobInfoList) {
			investorJobList.add(toInvestorJob(investorJobInfo));
		}
		return investorJobList;
	}
	
	public static InvestorJobQuery toInvestorJobQuery(InvestorJobQueryInfo investorJobQueryInfo)
	{
		if (investorJobQueryInfo== null) {
			return null;
		}
		InvestorJobQuery investorJobQuery = new InvestorJobQuery();
		beanCopierForInvestorJobQuery.copy(investorJobQueryInfo, investorJobQuery, null);
		return investorJobQuery;
	}

	public static QueryResultInfo<InvestorJobInfo> toQueryResultInfo(QueryResult<InvestorJob> queryResult)
	{
		QueryResultInfo<InvestorJobInfo> queryResultInfo = new QueryResultInfo<InvestorJobInfo>();
		queryResultInfo.setPages(queryResult.getPages());
		queryResult.setRecords(queryResult.getRecords());
		queryResultInfo.setTotal(queryResult.getTotal());
		queryResultInfo.setRecords(toInvestorJobInfoList(queryResult.getRecords()));
		return queryResultInfo;
	}
}