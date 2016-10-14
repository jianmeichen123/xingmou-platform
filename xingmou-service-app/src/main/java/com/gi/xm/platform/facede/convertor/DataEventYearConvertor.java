package com.gi.xm.platform.facede.convertor;
import java.util.ArrayList;
import java.util.List;

import java.util.Date;
import org.springframework.cglib.beans.BeanCopier;

import com.gi.xm.platform.view.DataEventYearInfo;
import com.gi.xm.platform.view.DataEventYearQueryInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.pojo.DataEventYear;
import com.gi.xm.platform.query.DataEventYearQuery;
import com.gi.xm.platform.biz.common.QueryResult;

public abstract class DataEventYearConvertor {

	private static final BeanCopier beanCopierForDataEventYearInfo = BeanCopier.create(DataEventYear.class, DataEventYearInfo.class, false);
	private static final BeanCopier beanCopierForDataEventYear = BeanCopier.create(DataEventYearInfo.class, DataEventYear.class, false);
	private static final BeanCopier beanCopierForDataEventYearQuery = BeanCopier.create(DataEventYearQueryInfo.class, DataEventYearQuery.class, false);

	public static DataEventYearInfo toDataEventYearInfo(DataEventYear dataEventYear)
	{
		if (dataEventYear == null) {
			return null;
		}
		DataEventYearInfo dataEventYearInfo = new DataEventYearInfo();
		beanCopierForDataEventYearInfo.copy(dataEventYear, dataEventYearInfo, null);
		return dataEventYearInfo;
	}

	public static DataEventYear toDataEventYear(DataEventYearInfo dataEventYearInfo)
	{
		DataEventYear dataEventYear = new DataEventYear();
		beanCopierForDataEventYear.copy(dataEventYearInfo, dataEventYear, null);
		return dataEventYear;
	}

	public static List<DataEventYearInfo> toDataEventYearInfoList(List<DataEventYear> dataEventYearList)
	{
		if (dataEventYearList == null || dataEventYearList.isEmpty()) {
			return null;
		}
		List<DataEventYearInfo> dataEventYearInfoList = new ArrayList<DataEventYearInfo>(dataEventYearList.size());
		for (DataEventYear dataEventYear : dataEventYearList) {
			dataEventYearInfoList.add(toDataEventYearInfo(dataEventYear));
		}
		return dataEventYearInfoList;
	}

	public static List<DataEventYear> toDataEventYearList(List<DataEventYearInfo> dataEventYearInfoList)
	{
		if (dataEventYearInfoList == null || dataEventYearInfoList.isEmpty()) {
			return null;
		}
		List<DataEventYear> dataEventYearList = new ArrayList<DataEventYear>(dataEventYearInfoList.size());
		for (DataEventYearInfo dataEventYearInfo : dataEventYearInfoList) {
			dataEventYearList.add(toDataEventYear(dataEventYearInfo));
		}
		return dataEventYearList;
	}
	
	public static DataEventYearQuery toDataEventYearQuery(DataEventYearQueryInfo dataEventYearQueryInfo)
	{
		if (dataEventYearQueryInfo== null) {
			return null;
		}
		DataEventYearQuery dataEventYearQuery = new DataEventYearQuery();
		beanCopierForDataEventYearQuery.copy(dataEventYearQueryInfo, dataEventYearQuery, null);
		return dataEventYearQuery;
	}

	public static QueryResultInfo<DataEventYearInfo> toQueryResultInfo(QueryResult<DataEventYear> queryResult)
	{
		QueryResultInfo<DataEventYearInfo> queryResultInfo = new QueryResultInfo<DataEventYearInfo>();
		queryResultInfo.setPages(queryResult.getPages());
		queryResult.setRecords(queryResult.getRecords());
		queryResultInfo.setTotal(queryResult.getTotal());
		queryResultInfo.setRecords(toDataEventYearInfoList(queryResult.getRecords()));
		return queryResultInfo;
	}
}