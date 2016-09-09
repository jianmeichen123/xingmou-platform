package com.gi.xm.platform.facede.convertor;
import java.util.ArrayList;
import java.util.List;

import java.util.Date;
import org.springframework.cglib.beans.BeanCopier;

import com.gi.xm.platform.view.InvestfirmAreaInfo;
import com.gi.xm.platform.view.InvestfirmAreaQueryInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.pojo.InvestfirmArea;
import com.gi.xm.platform.query.InvestfirmAreaQuery;
import com.gi.xm.platform.biz.common.QueryResult;

public abstract class InvestfirmAreaConvertor {

	private static final BeanCopier beanCopierForInvestfirmAreaInfo = BeanCopier.create(InvestfirmArea.class, InvestfirmAreaInfo.class, false);
	private static final BeanCopier beanCopierForInvestfirmArea = BeanCopier.create(InvestfirmAreaInfo.class, InvestfirmArea.class, false);
	private static final BeanCopier beanCopierForInvestfirmAreaQuery = BeanCopier.create(InvestfirmAreaQueryInfo.class, InvestfirmAreaQuery.class, false);

	public static InvestfirmAreaInfo toInvestfirmAreaInfo(InvestfirmArea investfirmArea)
	{
		if (investfirmArea == null) {
			return null;
		}
		InvestfirmAreaInfo investfirmAreaInfo = new InvestfirmAreaInfo();
		beanCopierForInvestfirmAreaInfo.copy(investfirmArea, investfirmAreaInfo, null);
		return investfirmAreaInfo;
	}

	public static InvestfirmArea toInvestfirmArea(InvestfirmAreaInfo investfirmAreaInfo)
	{
		InvestfirmArea investfirmArea = new InvestfirmArea();
		beanCopierForInvestfirmArea.copy(investfirmAreaInfo, investfirmArea, null);
		return investfirmArea;
	}

	public static List<InvestfirmAreaInfo> toInvestfirmAreaInfoList(List<InvestfirmArea> investfirmAreaList)
	{
		if (investfirmAreaList == null || investfirmAreaList.isEmpty()) {
			return null;
		}
		List<InvestfirmAreaInfo> investfirmAreaInfoList = new ArrayList<InvestfirmAreaInfo>(investfirmAreaList.size());
		for (InvestfirmArea investfirmArea : investfirmAreaList) {
			investfirmAreaInfoList.add(toInvestfirmAreaInfo(investfirmArea));
		}
		return investfirmAreaInfoList;
	}

	public static List<InvestfirmArea> toInvestfirmAreaList(List<InvestfirmAreaInfo> investfirmAreaInfoList)
	{
		if (investfirmAreaInfoList == null || investfirmAreaInfoList.isEmpty()) {
			return null;
		}
		List<InvestfirmArea> investfirmAreaList = new ArrayList<InvestfirmArea>(investfirmAreaInfoList.size());
		for (InvestfirmAreaInfo investfirmAreaInfo : investfirmAreaInfoList) {
			investfirmAreaList.add(toInvestfirmArea(investfirmAreaInfo));
		}
		return investfirmAreaList;
	}
	
	public static InvestfirmAreaQuery toInvestfirmAreaQuery(InvestfirmAreaQueryInfo investfirmAreaQueryInfo)
	{
		if (investfirmAreaQueryInfo== null) {
			return null;
		}
		InvestfirmAreaQuery investfirmAreaQuery = new InvestfirmAreaQuery();
		beanCopierForInvestfirmAreaQuery.copy(investfirmAreaQueryInfo, investfirmAreaQuery, null);
		return investfirmAreaQuery;
	}

	public static QueryResultInfo<InvestfirmAreaInfo> toQueryResultInfo(QueryResult<InvestfirmArea> queryResult)
	{
		QueryResultInfo<InvestfirmAreaInfo> queryResultInfo = new QueryResultInfo<InvestfirmAreaInfo>();
		queryResultInfo.setPages(queryResult.getPages());
		queryResult.setRecords(queryResult.getRecords());
		queryResultInfo.setTotal(queryResult.getTotal());
		queryResultInfo.setRecords(toInvestfirmAreaInfoList(queryResult.getRecords()));
		return queryResultInfo;
	}
}