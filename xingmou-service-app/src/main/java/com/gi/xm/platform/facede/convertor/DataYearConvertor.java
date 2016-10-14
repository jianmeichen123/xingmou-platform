package com.gi.xm.platform.facede.convertor;
import java.util.ArrayList;
import java.util.List;

import java.util.Date;
import org.springframework.cglib.beans.BeanCopier;

import com.gi.xm.platform.view.DataYearInfo;
import com.gi.xm.platform.view.DataYearQueryInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.pojo.DataYear;
import com.gi.xm.platform.query.DataYearQuery;
import com.gi.xm.platform.biz.common.QueryResult;

public abstract class DataYearConvertor {

	private static final BeanCopier beanCopierForDataYearInfo = BeanCopier.create(DataYear.class, DataYearInfo.class, false);
	private static final BeanCopier beanCopierForDataYear = BeanCopier.create(DataYearInfo.class, DataYear.class, false);
	private static final BeanCopier beanCopierForDataYearQuery = BeanCopier.create(DataYearQueryInfo.class, DataYearQuery.class, false);

	public static DataYearInfo toDataYearInfo(DataYear dataYear)
	{
		if (dataYear == null) {
			return null;
		}
		DataYearInfo dataYearInfo = new DataYearInfo();
		beanCopierForDataYearInfo.copy(dataYear, dataYearInfo, null);
		return dataYearInfo;
	}

	public static DataYear toDataYear(DataYearInfo dataYearInfo)
	{
		DataYear dataYear = new DataYear();
		beanCopierForDataYear.copy(dataYearInfo, dataYear, null);
		return dataYear;
	}

	public static List<DataYearInfo> toDataYearInfoList(List<DataYear> dataYearList)
	{
		if (dataYearList == null || dataYearList.isEmpty()) {
			return null;
		}
		List<DataYearInfo> dataYearInfoList = new ArrayList<DataYearInfo>(dataYearList.size());
		for (DataYear dataYear : dataYearList) {
			dataYearInfoList.add(toDataYearInfo(dataYear));
		}
		return dataYearInfoList;
	}

	public static List<DataYear> toDataYearList(List<DataYearInfo> dataYearInfoList)
	{
		if (dataYearInfoList == null || dataYearInfoList.isEmpty()) {
			return null;
		}
		List<DataYear> dataYearList = new ArrayList<DataYear>(dataYearInfoList.size());
		for (DataYearInfo dataYearInfo : dataYearInfoList) {
			dataYearList.add(toDataYear(dataYearInfo));
		}
		return dataYearList;
	}
	
	public static DataYearQuery toDataYearQuery(DataYearQueryInfo dataYearQueryInfo)
	{
		if (dataYearQueryInfo== null) {
			return null;
		}
		DataYearQuery dataYearQuery = new DataYearQuery();
		beanCopierForDataYearQuery.copy(dataYearQueryInfo, dataYearQuery, null);
		return dataYearQuery;
	}

	public static QueryResultInfo<DataYearInfo> toQueryResultInfo(QueryResult<DataYear> queryResult)
	{
		QueryResultInfo<DataYearInfo> queryResultInfo = new QueryResultInfo<DataYearInfo>();
		queryResultInfo.setPages(queryResult.getPages());
		queryResult.setRecords(queryResult.getRecords());
		queryResultInfo.setTotal(queryResult.getTotal());
		queryResultInfo.setRecords(toDataYearInfoList(queryResult.getRecords()));
		return queryResultInfo;
	}
}