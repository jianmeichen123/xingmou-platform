package com.gi.xm.platform.facede.convertor;
import java.util.ArrayList;
import java.util.List;

import java.util.Date;
import org.springframework.cglib.beans.BeanCopier;

import com.gi.xm.platform.view.IndustryInfo;
import com.gi.xm.platform.view.IndustryQueryInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.pojo.Industry;
import com.gi.xm.platform.query.IndustryQuery;
import com.gi.xm.platform.biz.common.QueryResult;

public abstract class IndustryConvertor {

	private static final BeanCopier beanCopierForIndustryInfo = BeanCopier.create(Industry.class, IndustryInfo.class, false);
	private static final BeanCopier beanCopierForIndustry = BeanCopier.create(IndustryInfo.class, Industry.class, false);
	private static final BeanCopier beanCopierForIndustryQuery = BeanCopier.create(IndustryQueryInfo.class, IndustryQuery.class, false);

	public static IndustryInfo toIndustryInfo(Industry industry)
	{
		if (industry == null) {
			return null;
		}
		IndustryInfo industryInfo = new IndustryInfo();
		beanCopierForIndustryInfo.copy(industry, industryInfo, null);
		return industryInfo;
	}

	public static Industry toIndustry(IndustryInfo industryInfo)
	{
		Industry industry = new Industry();
		beanCopierForIndustry.copy(industryInfo, industry, null);
		return industry;
	}

	public static List<IndustryInfo> toIndustryInfoList(List<Industry> industryList)
	{
		if (industryList == null || industryList.isEmpty()) {
			return null;
		}
		List<IndustryInfo> industryInfoList = new ArrayList<IndustryInfo>(industryList.size());
		for (Industry industry : industryList) {
			industryInfoList.add(toIndustryInfo(industry));
		}
		return industryInfoList;
	}

	public static List<Industry> toIndustryList(List<IndustryInfo> industryInfoList)
	{
		if (industryInfoList == null || industryInfoList.isEmpty()) {
			return null;
		}
		List<Industry> industryList = new ArrayList<Industry>(industryInfoList.size());
		for (IndustryInfo industryInfo : industryInfoList) {
			industryList.add(toIndustry(industryInfo));
		}
		return industryList;
	}
	
	public static IndustryQuery toIndustryQuery(IndustryQueryInfo industryQueryInfo)
	{
		if (industryQueryInfo== null) {
			return null;
		}
		IndustryQuery industryQuery = new IndustryQuery();
		beanCopierForIndustryQuery.copy(industryQueryInfo, industryQuery, null);
		return industryQuery;
	}

	public static QueryResultInfo<IndustryInfo> toQueryResultInfo(QueryResult<Industry> queryResult)
	{
		QueryResultInfo<IndustryInfo> queryResultInfo = new QueryResultInfo<IndustryInfo>();
		queryResultInfo.setPages(queryResult.getPages());
		queryResult.setRecords(queryResult.getRecords());
		queryResultInfo.setTotal(queryResult.getTotal());
		queryResultInfo.setRecords(toIndustryInfoList(queryResult.getRecords()));
		return queryResultInfo;
	}
}