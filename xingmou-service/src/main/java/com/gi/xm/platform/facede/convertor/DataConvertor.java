package com.gi.xm.platform.facede.convertor;

import com.gi.xm.platform.biz.common.QueryResult;
import com.gi.xm.platform.pojo.Data;
import com.gi.xm.platform.view.DataInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;

public abstract class DataConvertor {

	private static final BeanCopier beanCopierForDataInfo = BeanCopier.create(Data.class, DataInfo.class, false);
	private static final BeanCopier beanCopierForData = BeanCopier.create(DataInfo.class, Data.class, false);

	public static DataInfo toDataInfo(Data data)
	{
		if (data == null) {
			return null;
		}
		DataInfo dataInfo = new DataInfo();
		beanCopierForDataInfo.copy(data, dataInfo, null);
		return dataInfo;
	}

	public static Data toData(DataInfo dataInfo)
	{
		Data data = new Data();
		beanCopierForData.copy(dataInfo, data, null);
		return data;
	}

	public static List<DataInfo> toDataInfoList(List<Data> dataList)
	{
		if (dataList == null || dataList.isEmpty()) {
			return null;
		}
		List<DataInfo> dataInfoList = new ArrayList<DataInfo>(dataList.size());
		for (Data data : dataList) {
			dataInfoList.add(toDataInfo(data));
		}
		return dataInfoList;
	}

	public static List<Data> toDataList(List<DataInfo> dataInfoList)
	{
		if (dataInfoList == null || dataInfoList.isEmpty()) {
			return null;
		}
		List<Data> dataList = new ArrayList<Data>(dataInfoList.size());
		for (DataInfo dataInfo : dataInfoList) {
			dataList.add(toData(dataInfo));
		}
		return dataList;
	}
	

	public static QueryResultInfo<DataInfo> toQueryResultInfo(QueryResult<Data> queryResult)
	{
		QueryResultInfo<DataInfo> queryResultInfo = new QueryResultInfo<DataInfo>();
		queryResultInfo.setPages(queryResult.getPages());
		queryResult.setRecords(queryResult.getRecords());
		queryResultInfo.setTotal(queryResult.getTotal());
		queryResultInfo.setRecords(toDataInfoList(queryResult.getRecords()));
		return queryResultInfo;
	}
}