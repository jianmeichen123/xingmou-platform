package com.gi.xm.platform.facede.convertor;
import java.util.ArrayList;
import java.util.List;

import java.util.Date;
import org.springframework.cglib.beans.BeanCopier;

import com.gi.xm.platform.view.IndustryDataHalfYearInfo;
import com.gi.xm.platform.view.IndustryDataHalfYearQueryInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.pojo.IndustryDataHalfYear;
import com.gi.xm.platform.query.IndustryDataHalfYearQuery;
import com.gi.xm.platform.biz.common.QueryResult;

public abstract class IndustryDataHalfYearConvertor {

	private static final BeanCopier beanCopierForIndustryDataHalfYearInfo = BeanCopier.create(IndustryDataHalfYear.class, IndustryDataHalfYearInfo.class, false);
	private static final BeanCopier beanCopierForIndustryDataHalfYear = BeanCopier.create(IndustryDataHalfYearInfo.class, IndustryDataHalfYear.class, false);
	private static final BeanCopier beanCopierForIndustryDataHalfYearQuery = BeanCopier.create(IndustryDataHalfYearQueryInfo.class, IndustryDataHalfYearQuery.class, false);

	public static IndustryDataHalfYearInfo toIndustryDataHalfYearInfo(IndustryDataHalfYear industryDataHalfYear)
	{
		if (industryDataHalfYear == null) {
			return null;
		}
		IndustryDataHalfYearInfo industryDataHalfYearInfo = new IndustryDataHalfYearInfo();
		beanCopierForIndustryDataHalfYearInfo.copy(industryDataHalfYear, industryDataHalfYearInfo, null);
		return industryDataHalfYearInfo;
	}

	public static IndustryDataHalfYear toIndustryDataHalfYear(IndustryDataHalfYearInfo industryDataHalfYearInfo)
	{
		IndustryDataHalfYear industryDataHalfYear = new IndustryDataHalfYear();
		beanCopierForIndustryDataHalfYear.copy(industryDataHalfYearInfo, industryDataHalfYear, null);
		return industryDataHalfYear;
	}

	public static List<IndustryDataHalfYearInfo> toIndustryDataHalfYearInfoList(List<IndustryDataHalfYear> industryDataHalfYearList)
	{
		if (industryDataHalfYearList == null || industryDataHalfYearList.isEmpty()) {
			return null;
		}
		List<IndustryDataHalfYearInfo> industryDataHalfYearInfoList = new ArrayList<IndustryDataHalfYearInfo>(industryDataHalfYearList.size());
		for (IndustryDataHalfYear industryDataHalfYear : industryDataHalfYearList) {
			industryDataHalfYearInfoList.add(toIndustryDataHalfYearInfo(industryDataHalfYear));
		}
		return industryDataHalfYearInfoList;
	}

	public static List<IndustryDataHalfYear> toIndustryDataHalfYearList(List<IndustryDataHalfYearInfo> industryDataHalfYearInfoList)
	{
		if (industryDataHalfYearInfoList == null || industryDataHalfYearInfoList.isEmpty()) {
			return null;
		}
		List<IndustryDataHalfYear> industryDataHalfYearList = new ArrayList<IndustryDataHalfYear>(industryDataHalfYearInfoList.size());
		for (IndustryDataHalfYearInfo industryDataHalfYearInfo : industryDataHalfYearInfoList) {
			industryDataHalfYearList.add(toIndustryDataHalfYear(industryDataHalfYearInfo));
		}
		return industryDataHalfYearList;
	}
	
	public static IndustryDataHalfYearQuery toIndustryDataHalfYearQuery(IndustryDataHalfYearQueryInfo industryDataHalfYearQueryInfo)
	{
		if (industryDataHalfYearQueryInfo== null) {
			return null;
		}
		IndustryDataHalfYearQuery industryDataHalfYearQuery = new IndustryDataHalfYearQuery();
		beanCopierForIndustryDataHalfYearQuery.copy(industryDataHalfYearQueryInfo, industryDataHalfYearQuery, null);
		return industryDataHalfYearQuery;
	}

	public static QueryResultInfo<IndustryDataHalfYearInfo> toQueryResultInfo(QueryResult<IndustryDataHalfYear> queryResult)
	{
		QueryResultInfo<IndustryDataHalfYearInfo> queryResultInfo = new QueryResultInfo<IndustryDataHalfYearInfo>();
		queryResultInfo.setPages(queryResult.getPages());
		queryResult.setRecords(queryResult.getRecords());
		queryResultInfo.setTotal(queryResult.getTotal());
		queryResultInfo.setRecords(toIndustryDataHalfYearInfoList(queryResult.getRecords()));
		return queryResultInfo;
	}
}