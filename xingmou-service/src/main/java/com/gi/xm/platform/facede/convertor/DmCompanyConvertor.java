package com.gi.xm.platform.facede.convertor;
import java.util.ArrayList;
import java.util.List;

import org.springframework.cglib.beans.BeanCopier;

import com.gi.xm.platform.view.DmCompanyInfo;
import com.gi.xm.platform.view.DmCompanyQueryInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.pojo.DmCompany;
import com.gi.xm.platform.query.DmCompanyQuery;
import com.gi.xm.platform.biz.common.QueryResult;

public abstract class DmCompanyConvertor {

	private static final BeanCopier beanCopierForDmCompanyInfo = BeanCopier.create(DmCompany.class, DmCompanyInfo.class, false);
	private static final BeanCopier beanCopierForDmCompany = BeanCopier.create(DmCompanyInfo.class, DmCompany.class, false);
	private static final BeanCopier beanCopierForDmCompanyQuery = BeanCopier.create(DmCompanyQueryInfo.class, DmCompanyQuery.class, false);

	public static DmCompanyInfo toDmCompanyInfo(DmCompany dmCompany)
	{
		if (dmCompany == null) {
			return null;
		}
		DmCompanyInfo dmCompanyInfo = new DmCompanyInfo();
		beanCopierForDmCompanyInfo.copy(dmCompany, dmCompanyInfo, null);
		return dmCompanyInfo;
	}

	public static DmCompany toDmCompany(DmCompanyInfo dmCompanyInfo)
	{
		DmCompany dmCompany = new DmCompany();
		beanCopierForDmCompany.copy(dmCompanyInfo, dmCompany, null);
		return dmCompany;
	}

	public static List<DmCompanyInfo> toDmCompanyInfoList(List<DmCompany> dmCompanyList)
	{
		if (dmCompanyList == null || dmCompanyList.isEmpty()) {
			return null;
		}
		List<DmCompanyInfo> dmCompanyInfoList = new ArrayList<DmCompanyInfo>(dmCompanyList.size());
		for (DmCompany dmCompany : dmCompanyList) {
			dmCompanyInfoList.add(toDmCompanyInfo(dmCompany));
		}
		return dmCompanyInfoList;
	}

	public static List<DmCompany> toDmCompanyList(List<DmCompanyInfo> dmCompanyInfoList)
	{
		if (dmCompanyInfoList == null || dmCompanyInfoList.isEmpty()) {
			return null;
		}
		List<DmCompany> dmCompanyList = new ArrayList<DmCompany>(dmCompanyInfoList.size());
		for (DmCompanyInfo dmCompanyInfo : dmCompanyInfoList) {
			dmCompanyList.add(toDmCompany(dmCompanyInfo));
		}
		return dmCompanyList;
	}
	
	public static DmCompanyQuery toDmCompanyQuery(DmCompanyQueryInfo dmCompanyQueryInfo)
	{
		if (dmCompanyQueryInfo== null) {
			return null;
		}
		DmCompanyQuery dmCompanyQuery = new DmCompanyQuery();
		beanCopierForDmCompanyQuery.copy(dmCompanyQueryInfo, dmCompanyQuery, null);
		return dmCompanyQuery;
	}

	public static QueryResultInfo<DmCompanyInfo> toQueryResultInfo(QueryResult<DmCompany> queryResult)
	{
		QueryResultInfo<DmCompanyInfo> queryResultInfo = new QueryResultInfo<DmCompanyInfo>();
		queryResultInfo.setPages(queryResult.getPages());
		queryResult.setRecords(queryResult.getRecords());
		queryResultInfo.setTotal(queryResult.getTotal());
		queryResultInfo.setRecords(toDmCompanyInfoList(queryResult.getRecords()));
		return queryResultInfo;
	}
}