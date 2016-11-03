package com.gi.xm.platform.facede.convertor;
import java.util.ArrayList;
import java.util.List;

import java.util.Date;
import org.springframework.cglib.beans.BeanCopier;

import com.gi.xm.platform.view.InvestfirmsDataInfo;
import com.gi.xm.platform.view.InvestfirmsDataQueryInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.pojo.InvestfirmsData;
import com.gi.xm.platform.query.InvestfirmsDataQuery;
import com.gi.xm.platform.biz.common.QueryResult;

public abstract class InvestfirmsDataConvertor {

	private static final BeanCopier beanCopierForInvestfirmsDataInfo = BeanCopier.create(InvestfirmsData.class, InvestfirmsDataInfo.class, false);
	private static final BeanCopier beanCopierForInvestfirmsData = BeanCopier.create(InvestfirmsDataInfo.class, InvestfirmsData.class, false);
	private static final BeanCopier beanCopierForInvestfirmsDataQuery = BeanCopier.create(InvestfirmsDataQueryInfo.class, InvestfirmsDataQuery.class, false);

	public static InvestfirmsDataInfo toInvestfirmsDataInfo(InvestfirmsData investfirmsData)
	{
		if (investfirmsData == null) {
			return null;
		}
		InvestfirmsDataInfo investfirmsDataInfo = new InvestfirmsDataInfo();
		beanCopierForInvestfirmsDataInfo.copy(investfirmsData, investfirmsDataInfo, null);
		return investfirmsDataInfo;
	}

	public static InvestfirmsData toInvestfirmsData(InvestfirmsDataInfo investfirmsDataInfo)
	{
		InvestfirmsData investfirmsData = new InvestfirmsData();
		beanCopierForInvestfirmsData.copy(investfirmsDataInfo, investfirmsData, null);
		return investfirmsData;
	}

	public static List<InvestfirmsDataInfo> toInvestfirmsDataInfoList(List<InvestfirmsData> investfirmsDataList)
	{
		if (investfirmsDataList == null || investfirmsDataList.isEmpty()) {
			return null;
		}
		List<InvestfirmsDataInfo> investfirmsDataInfoList = new ArrayList<InvestfirmsDataInfo>(investfirmsDataList.size());
		for (InvestfirmsData investfirmsData : investfirmsDataList) {
			investfirmsDataInfoList.add(toInvestfirmsDataInfo(investfirmsData));
		}
		return investfirmsDataInfoList;
	}

	public static List<InvestfirmsData> toInvestfirmsDataList(List<InvestfirmsDataInfo> investfirmsDataInfoList)
	{
		if (investfirmsDataInfoList == null || investfirmsDataInfoList.isEmpty()) {
			return null;
		}
		List<InvestfirmsData> investfirmsDataList = new ArrayList<InvestfirmsData>(investfirmsDataInfoList.size());
		for (InvestfirmsDataInfo investfirmsDataInfo : investfirmsDataInfoList) {
			investfirmsDataList.add(toInvestfirmsData(investfirmsDataInfo));
		}
		return investfirmsDataList;
	}
	
	public static InvestfirmsDataQuery toInvestfirmsDataQuery(InvestfirmsDataQueryInfo investfirmsDataQueryInfo)
	{
		if (investfirmsDataQueryInfo== null) {
			return null;
		}
		InvestfirmsDataQuery investfirmsDataQuery = new InvestfirmsDataQuery();
		beanCopierForInvestfirmsDataQuery.copy(investfirmsDataQueryInfo, investfirmsDataQuery, null);
		return investfirmsDataQuery;
	}

	public static QueryResultInfo<InvestfirmsDataInfo> toQueryResultInfo(QueryResult<InvestfirmsData> queryResult)
	{
		QueryResultInfo<InvestfirmsDataInfo> queryResultInfo = new QueryResultInfo<InvestfirmsDataInfo>();
		queryResultInfo.setPages(queryResult.getPages());
		queryResult.setRecords(queryResult.getRecords());
		queryResultInfo.setTotal(queryResult.getTotal());
		queryResultInfo.setRecords(toInvestfirmsDataInfoList(queryResult.getRecords()));
		return queryResultInfo;
	}
}