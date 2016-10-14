package com.gi.xm.platform.facede.convertor;
import java.util.ArrayList;
import java.util.List;

import java.util.Date;
import org.springframework.cglib.beans.BeanCopier;

import com.gi.xm.platform.view.AreaInfo;
import com.gi.xm.platform.view.AreaQueryInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.pojo.Area;
import com.gi.xm.platform.query.AreaQuery;
import com.gi.xm.platform.biz.common.QueryResult;

public abstract class AreaConvertor {

	private static final BeanCopier beanCopierForAreaInfo = BeanCopier.create(Area.class, AreaInfo.class, false);
	private static final BeanCopier beanCopierForArea = BeanCopier.create(AreaInfo.class, Area.class, false);
	private static final BeanCopier beanCopierForAreaQuery = BeanCopier.create(AreaQueryInfo.class, AreaQuery.class, false);

	public static AreaInfo toAreaInfo(Area area)
	{
		if (area == null) {
			return null;
		}
		AreaInfo areaInfo = new AreaInfo();
		beanCopierForAreaInfo.copy(area, areaInfo, null);
		return areaInfo;
	}

	public static Area toArea(AreaInfo areaInfo)
	{
		Area area = new Area();
		beanCopierForArea.copy(areaInfo, area, null);
		return area;
	}

	public static List<AreaInfo> toAreaInfoList(List<Area> areaList)
	{
		if (areaList == null || areaList.isEmpty()) {
			return null;
		}
		List<AreaInfo> areaInfoList = new ArrayList<AreaInfo>(areaList.size());
		for (Area area : areaList) {
			areaInfoList.add(toAreaInfo(area));
		}
		return areaInfoList;
	}

	public static List<Area> toAreaList(List<AreaInfo> areaInfoList)
	{
		if (areaInfoList == null || areaInfoList.isEmpty()) {
			return null;
		}
		List<Area> areaList = new ArrayList<Area>(areaInfoList.size());
		for (AreaInfo areaInfo : areaInfoList) {
			areaList.add(toArea(areaInfo));
		}
		return areaList;
	}
	
	public static AreaQuery toAreaQuery(AreaQueryInfo areaQueryInfo)
	{
		if (areaQueryInfo== null) {
			return null;
		}
		AreaQuery areaQuery = new AreaQuery();
		beanCopierForAreaQuery.copy(areaQueryInfo, areaQuery, null);
		return areaQuery;
	}

	public static QueryResultInfo<AreaInfo> toQueryResultInfo(QueryResult<Area> queryResult)
	{
		QueryResultInfo<AreaInfo> queryResultInfo = new QueryResultInfo<AreaInfo>();
		queryResultInfo.setPages(queryResult.getPages());
		queryResult.setRecords(queryResult.getRecords());
		queryResultInfo.setTotal(queryResult.getTotal());
		queryResultInfo.setRecords(toAreaInfoList(queryResult.getRecords()));
		return queryResultInfo;
	}
}