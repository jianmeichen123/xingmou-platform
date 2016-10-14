package com.gi.xm.platform.facede.convertor;
import java.util.ArrayList;
import java.util.List;

import java.util.Date;
import org.springframework.cglib.beans.BeanCopier;

import com.gi.xm.platform.view.MoneyLevelInfo;
import com.gi.xm.platform.view.MoneyLevelQueryInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.pojo.MoneyLevel;
import com.gi.xm.platform.query.MoneyLevelQuery;
import com.gi.xm.platform.biz.common.QueryResult;

public abstract class MoneyLevelConvertor {

	private static final BeanCopier beanCopierForMoneyLevelInfo = BeanCopier.create(MoneyLevel.class, MoneyLevelInfo.class, false);
	private static final BeanCopier beanCopierForMoneyLevel = BeanCopier.create(MoneyLevelInfo.class, MoneyLevel.class, false);
	private static final BeanCopier beanCopierForMoneyLevelQuery = BeanCopier.create(MoneyLevelQueryInfo.class, MoneyLevelQuery.class, false);

	public static MoneyLevelInfo toMoneyLevelInfo(MoneyLevel moneyLevel)
	{
		if (moneyLevel == null) {
			return null;
		}
		MoneyLevelInfo moneyLevelInfo = new MoneyLevelInfo();
		beanCopierForMoneyLevelInfo.copy(moneyLevel, moneyLevelInfo, null);
		return moneyLevelInfo;
	}

	public static MoneyLevel toMoneyLevel(MoneyLevelInfo moneyLevelInfo)
	{
		MoneyLevel moneyLevel = new MoneyLevel();
		beanCopierForMoneyLevel.copy(moneyLevelInfo, moneyLevel, null);
		return moneyLevel;
	}

	public static List<MoneyLevelInfo> toMoneyLevelInfoList(List<MoneyLevel> moneyLevelList)
	{
		if (moneyLevelList == null || moneyLevelList.isEmpty()) {
			return null;
		}
		List<MoneyLevelInfo> moneyLevelInfoList = new ArrayList<MoneyLevelInfo>(moneyLevelList.size());
		for (MoneyLevel moneyLevel : moneyLevelList) {
			moneyLevelInfoList.add(toMoneyLevelInfo(moneyLevel));
		}
		return moneyLevelInfoList;
	}

	public static List<MoneyLevel> toMoneyLevelList(List<MoneyLevelInfo> moneyLevelInfoList)
	{
		if (moneyLevelInfoList == null || moneyLevelInfoList.isEmpty()) {
			return null;
		}
		List<MoneyLevel> moneyLevelList = new ArrayList<MoneyLevel>(moneyLevelInfoList.size());
		for (MoneyLevelInfo moneyLevelInfo : moneyLevelInfoList) {
			moneyLevelList.add(toMoneyLevel(moneyLevelInfo));
		}
		return moneyLevelList;
	}
	
	public static MoneyLevelQuery toMoneyLevelQuery(MoneyLevelQueryInfo moneyLevelQueryInfo)
	{
		if (moneyLevelQueryInfo== null) {
			return null;
		}
		MoneyLevelQuery moneyLevelQuery = new MoneyLevelQuery();
		beanCopierForMoneyLevelQuery.copy(moneyLevelQueryInfo, moneyLevelQuery, null);
		return moneyLevelQuery;
	}

	public static QueryResultInfo<MoneyLevelInfo> toQueryResultInfo(QueryResult<MoneyLevel> queryResult)
	{
		QueryResultInfo<MoneyLevelInfo> queryResultInfo = new QueryResultInfo<MoneyLevelInfo>();
		queryResultInfo.setPages(queryResult.getPages());
		queryResult.setRecords(queryResult.getRecords());
		queryResultInfo.setTotal(queryResult.getTotal());
		queryResultInfo.setRecords(toMoneyLevelInfoList(queryResult.getRecords()));
		return queryResultInfo;
	}
}