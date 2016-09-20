package com.gi.xm.platform.facede.convertor;
import java.util.ArrayList;
import java.util.List;

import java.util.Date;
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


	public static List<IndustryFirstDataYear> toIndustryDataYearList(List<IndustryFirstDataYearInfo> industryDataYearInfoList)
	{
		if (industryDataYearInfoList == null || industryDataYearInfoList.isEmpty()) {
			return null;
		}
		List<IndustryFirstDataYear> industryDataYearList = new ArrayList<IndustryFirstDataYear>(industryDataYearInfoList.size());
		for (IndustryFirstDataYearInfo industryDataYearInfo : industryDataYearInfoList) {
			industryDataYearList.add(toIndustryDataYear(industryDataYearInfo));
		}
		return industryDataYearList;
	}

	public static IndustryFirstDataYear toIndustryDataYear(IndustryFirstDataYearInfo industryDataYearInfo)
	{
		IndustryFirstDataYear industryDataYear = new IndustryFirstDataYear();
		beanCopierForIndustryFirstDataYear.copy(industryDataYearInfo, industryDataYear, null);
		return industryDataYear;
	}


	public static List<IndustryFirstDataYearInfo> toIndustryDataYearInfoList(List<IndustryFirstDataYear> industryDataYearList)
	{
		if (industryDataYearList == null || industryDataYearList.isEmpty()) {
			return null;
		}
		List<IndustryFirstDataYearInfo> industryDataYearInfoList = new ArrayList<IndustryFirstDataYearInfo>(industryDataYearList.size());
		for (IndustryFirstDataYear industryDataYear : industryDataYearList) {
			industryDataYearInfoList.add(toIndustryDataYearInfo(industryDataYear));
		}
		return industryDataYearInfoList;
	}

	public static IndustryFirstDataYearInfo toIndustryDataYearInfo(IndustryFirstDataYear industryDataYear)
	{
		if (industryDataYear == null) {
			return null;
		}
		IndustryFirstDataYearInfo industryDataYearInfo = new IndustryFirstDataYearInfo();
		beanCopierForIndustryFirstDataYearInfo.copy(industryDataYear, industryDataYearInfo, null);
		return industryDataYearInfo;
	}
}