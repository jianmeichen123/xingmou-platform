package com.gi.xm.platform.facede.convertor;
import java.util.ArrayList;
import java.util.List;

import java.util.Date;
import org.springframework.cglib.beans.BeanCopier;

import com.gi.xm.platform.view.IndustryDataYearInfo;
import com.gi.xm.platform.view.IndustryDataYearQueryInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.pojo.IndustryDataYear;
import com.gi.xm.platform.query.IndustryDataYearQuery;
import com.gi.xm.platform.biz.common.QueryResult;

public abstract class IndustryDataYearConvertor {

	private static final BeanCopier beanCopierForIndustryDataYearInfo = BeanCopier.create(IndustryDataYear.class, IndustryDataYearInfo.class, false);
	private static final BeanCopier beanCopierForIndustryDataYear = BeanCopier.create(IndustryDataYearInfo.class, IndustryDataYear.class, false);
	private static final BeanCopier beanCopierForIndustryDataYearQuery = BeanCopier.create(IndustryDataYearQueryInfo.class, IndustryDataYearQuery.class, false);

	public static IndustryDataYearInfo toIndustryDataYearInfo(IndustryDataYear industryDataYear)
	{
		if (industryDataYear == null) {
			return null;
		}
		IndustryDataYearInfo industryDataYearInfo = new IndustryDataYearInfo();
		beanCopierForIndustryDataYearInfo.copy(industryDataYear, industryDataYearInfo, null);
		return industryDataYearInfo;
	}

	public static IndustryDataYear toIndustryDataYear(IndustryDataYearInfo industryDataYearInfo)
	{
		IndustryDataYear industryDataYear = new IndustryDataYear();
		beanCopierForIndustryDataYear.copy(industryDataYearInfo, industryDataYear, null);
		return industryDataYear;
	}

	public static List<IndustryDataYearInfo> toIndustryDataYearInfoList(List<IndustryDataYear> industryDataYearList)
	{
		if (industryDataYearList == null || industryDataYearList.isEmpty()) {
			return null;
		}
		List<IndustryDataYearInfo> industryDataYearInfoList = new ArrayList<IndustryDataYearInfo>(industryDataYearList.size());
		for (IndustryDataYear industryDataYear : industryDataYearList) {
			industryDataYearInfoList.add(toIndustryDataYearInfo(industryDataYear));
		}
		return industryDataYearInfoList;
	}

	public static List<IndustryDataYear> toIndustryDataYearList(List<IndustryDataYearInfo> industryDataYearInfoList)
	{
		if (industryDataYearInfoList == null || industryDataYearInfoList.isEmpty()) {
			return null;
		}
		List<IndustryDataYear> industryDataYearList = new ArrayList<IndustryDataYear>(industryDataYearInfoList.size());
		for (IndustryDataYearInfo industryDataYearInfo : industryDataYearInfoList) {
			industryDataYearList.add(toIndustryDataYear(industryDataYearInfo));
		}
		return industryDataYearList;
	}
	
	public static IndustryDataYearQuery toIndustryDataYearQuery(IndustryDataYearQueryInfo industryDataYearQueryInfo)
	{
		if (industryDataYearQueryInfo== null) {
			return null;
		}
		IndustryDataYearQuery industryDataYearQuery = new IndustryDataYearQuery();
		beanCopierForIndustryDataYearQuery.copy(industryDataYearQueryInfo, industryDataYearQuery, null);
		return industryDataYearQuery;
	}

	public static QueryResultInfo<IndustryDataYearInfo> toQueryResultInfo(QueryResult<IndustryDataYear> queryResult)
	{
		QueryResultInfo<IndustryDataYearInfo> queryResultInfo = new QueryResultInfo<IndustryDataYearInfo>();
		queryResultInfo.setPages(queryResult.getPages());
		queryResult.setRecords(queryResult.getRecords());
		queryResultInfo.setTotal(queryResult.getTotal());
		queryResultInfo.setRecords(toIndustryDataYearInfoList(queryResult.getRecords()));
		return queryResultInfo;
	}
}