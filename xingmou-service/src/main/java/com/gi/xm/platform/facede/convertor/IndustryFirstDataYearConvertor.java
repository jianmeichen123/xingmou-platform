package com.gi.xm.platform.facede.convertor;
import java.util.ArrayList;
import java.util.List;

import java.util.Date;

import com.gi.xm.platform.view.IndustryDataYearInfo;
import org.springframework.cglib.beans.BeanCopier;

import com.gi.xm.platform.view.IndustryFirstDataYearInfo;
import com.gi.xm.platform.view.IndustryFirstDataYearQueryInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.pojo.IndustryFirstDataYear;
import com.gi.xm.platform.query.IndustryFirstDataYearQuery;
import com.gi.xm.platform.biz.common.QueryResult;

public abstract class IndustryFirstDataYearConvertor {

	private static final BeanCopier beanCopierForIndustryFirstDataYearInfo = BeanCopier.create(IndustryFirstDataYear.class, IndustryFirstDataYearInfo.class, false);
	private static final BeanCopier beanCopierForIndustryFirstDataYear = BeanCopier.create(IndustryFirstDataYearInfo.class, IndustryFirstDataYear.class, false);
	private static final BeanCopier beanCopierForIndustryFirstDataYearQuery = BeanCopier.create(IndustryFirstDataYearQueryInfo.class, IndustryFirstDataYearQuery.class, false);

	public static IndustryFirstDataYearInfo toIndustryFirstDataYearInfo(IndustryFirstDataYear industryFirstDataYear)
	{
		if (industryFirstDataYear == null) {
			return null;
		}
		IndustryFirstDataYearInfo industryFirstDataYearInfo = new IndustryFirstDataYearInfo();
		beanCopierForIndustryFirstDataYearInfo.copy(industryFirstDataYear, industryFirstDataYearInfo, null);
		return industryFirstDataYearInfo;
	}

	public static IndustryFirstDataYear toIndustryFirstDataYear(IndustryFirstDataYearInfo industryFirstDataYearInfo)
	{
		IndustryFirstDataYear industryFirstDataYear = new IndustryFirstDataYear();
		beanCopierForIndustryFirstDataYear.copy(industryFirstDataYearInfo, industryFirstDataYear, null);
		return industryFirstDataYear;
	}

	public static List<IndustryFirstDataYearInfo> toIndustryFirstDataYearInfoList(List<IndustryFirstDataYear> industryFirstDataYearList)
	{
		if (industryFirstDataYearList == null || industryFirstDataYearList.isEmpty()) {
			return null;
		}
		List<IndustryFirstDataYearInfo> industryFirstDataYearInfoList = new ArrayList<IndustryFirstDataYearInfo>(industryFirstDataYearList.size());
		for (IndustryFirstDataYear industryFirstDataYear : industryFirstDataYearList) {
			industryFirstDataYearInfoList.add(toIndustryFirstDataYearInfo(industryFirstDataYear));
		}
		return industryFirstDataYearInfoList;
	}

	public static List<IndustryDataYearInfo> toIndustryFirstDataYearInfoList1(List<IndustryFirstDataYear> industryFirstDataYearList)
	{
		if (industryFirstDataYearList == null || industryFirstDataYearList.isEmpty()) {
			return null;
		}
		List<IndustryDataYearInfo> industryFirstDataYearInfoList = new ArrayList<IndustryDataYearInfo>(industryFirstDataYearList.size());
		for (IndustryFirstDataYear industryFirstDataYear : industryFirstDataYearList) {
			industryFirstDataYearInfoList.add(toIndustryFirstDataYearInfo(industryFirstDataYear));
		}
		return industryFirstDataYearInfoList;
	}

	public static List<IndustryFirstDataYear> toIndustryFirstDataYearList(List<IndustryFirstDataYearInfo> industryFirstDataYearInfoList)
	{
		if (industryFirstDataYearInfoList == null || industryFirstDataYearInfoList.isEmpty()) {
			return null;
		}
		List<IndustryFirstDataYear> industryFirstDataYearList = new ArrayList<IndustryFirstDataYear>(industryFirstDataYearInfoList.size());
		for (IndustryFirstDataYearInfo industryFirstDataYearInfo : industryFirstDataYearInfoList) {
			industryFirstDataYearList.add(toIndustryFirstDataYear(industryFirstDataYearInfo));
		}
		return industryFirstDataYearList;
	}
	
	public static IndustryFirstDataYearQuery toIndustryFirstDataYearQuery(IndustryFirstDataYearQueryInfo industryFirstDataYearQueryInfo)
	{
		if (industryFirstDataYearQueryInfo== null) {
			return null;
		}
		IndustryFirstDataYearQuery industryFirstDataYearQuery = new IndustryFirstDataYearQuery();
		beanCopierForIndustryFirstDataYearQuery.copy(industryFirstDataYearQueryInfo, industryFirstDataYearQuery, null);
		return industryFirstDataYearQuery;
	}

	public static QueryResultInfo<IndustryFirstDataYearInfo> toQueryResultInfo(QueryResult<IndustryFirstDataYear> queryResult)
	{
		QueryResultInfo<IndustryFirstDataYearInfo> queryResultInfo = new QueryResultInfo<IndustryFirstDataYearInfo>();
		queryResultInfo.setPages(queryResult.getPages());
		queryResult.setRecords(queryResult.getRecords());
		queryResultInfo.setTotal(queryResult.getTotal());
		queryResultInfo.setRecords(toIndustryFirstDataYearInfoList(queryResult.getRecords()));
		return queryResultInfo;
	}

	public static QueryResultInfo<IndustryDataYearInfo> toQueryResultInfo1(QueryResult<IndustryFirstDataYear> queryResult)
	{
		QueryResultInfo<IndustryDataYearInfo> queryResultInfo = new QueryResultInfo<IndustryDataYearInfo>();
		//queryResultInfo.setPages(queryResult.getPages());

		if (queryResult != null) {
			queryResult.setRecords(queryResult.getRecords());
			queryResultInfo.setTotal(queryResult.getTotal());
			queryResultInfo.setRecords(toIndustryFirstDataYearInfoList1(queryResult.getRecords()));
		}

		return queryResultInfo;
	}
}