package com.gi.xm.platform.facede.convertor;
import java.util.ArrayList;
import java.util.List;

import java.util.Date;
import org.springframework.cglib.beans.BeanCopier;

import com.gi.xm.platform.view.DistrictInfo;
import com.gi.xm.platform.view.DistrictQueryInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.pojo.District;
import com.gi.xm.platform.query.DistrictQuery;
import com.gi.xm.platform.biz.common.QueryResult;

public abstract class DistrictConvertor {

	private static final BeanCopier beanCopierForDistrictInfo = BeanCopier.create(District.class, DistrictInfo.class, false);
	private static final BeanCopier beanCopierForDistrict = BeanCopier.create(DistrictInfo.class, District.class, false);
	private static final BeanCopier beanCopierForDistrictQuery = BeanCopier.create(DistrictQueryInfo.class, DistrictQuery.class, false);

	public static DistrictInfo toDistrictInfo(District district)
	{
		if (district == null) {
			return null;
		}
		DistrictInfo districtInfo = new DistrictInfo();
		beanCopierForDistrictInfo.copy(district, districtInfo, null);
		return districtInfo;
	}

	public static District toDistrict(DistrictInfo districtInfo)
	{
		District district = new District();
		beanCopierForDistrict.copy(districtInfo, district, null);
		return district;
	}

	public static List<DistrictInfo> toDistrictInfoList(List<District> districtList)
	{
		if (districtList == null || districtList.isEmpty()) {
			return null;
		}
		List<DistrictInfo> districtInfoList = new ArrayList<DistrictInfo>(districtList.size());
		for (District district : districtList) {
			districtInfoList.add(toDistrictInfo(district));
		}
		return districtInfoList;
	}

	public static List<District> toDistrictList(List<DistrictInfo> districtInfoList)
	{
		if (districtInfoList == null || districtInfoList.isEmpty()) {
			return null;
		}
		List<District> districtList = new ArrayList<District>(districtInfoList.size());
		for (DistrictInfo districtInfo : districtInfoList) {
			districtList.add(toDistrict(districtInfo));
		}
		return districtList;
	}
	
	public static DistrictQuery toDistrictQuery(DistrictQueryInfo districtQueryInfo)
	{
		if (districtQueryInfo== null) {
			return null;
		}
		DistrictQuery districtQuery = new DistrictQuery();
		beanCopierForDistrictQuery.copy(districtQueryInfo, districtQuery, null);
		return districtQuery;
	}

	public static QueryResultInfo<DistrictInfo> toQueryResultInfo(QueryResult<District> queryResult)
	{
		QueryResultInfo<DistrictInfo> queryResultInfo = new QueryResultInfo<DistrictInfo>();
		queryResultInfo.setPages(queryResult.getPages());
		queryResult.setRecords(queryResult.getRecords());
		queryResultInfo.setTotal(queryResult.getTotal());
		queryResultInfo.setRecords(toDistrictInfoList(queryResult.getRecords()));
		return queryResultInfo;
	}
}