package com.gi.xm.platform.facede.convertor;
import java.util.ArrayList;
import java.util.List;

import java.util.Date;
import org.springframework.cglib.beans.BeanCopier;

import com.gi.xm.platform.view.CurrencyInfo;
import com.gi.xm.platform.view.CurrencyQueryInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.pojo.Currency;
import com.gi.xm.platform.query.CurrencyQuery;
import com.gi.xm.platform.biz.common.QueryResult;

public abstract class CurrencyConvertor {

	private static final BeanCopier beanCopierForCurrencyInfo = BeanCopier.create(Currency.class, CurrencyInfo.class, false);
	private static final BeanCopier beanCopierForCurrency = BeanCopier.create(CurrencyInfo.class, Currency.class, false);
	private static final BeanCopier beanCopierForCurrencyQuery = BeanCopier.create(CurrencyQueryInfo.class, CurrencyQuery.class, false);

	public static CurrencyInfo toCurrencyInfo(Currency currency)
	{
		if (currency == null) {
			return null;
		}
		CurrencyInfo currencyInfo = new CurrencyInfo();
		beanCopierForCurrencyInfo.copy(currency, currencyInfo, null);
		return currencyInfo;
	}

	public static Currency toCurrency(CurrencyInfo currencyInfo)
	{
		Currency currency = new Currency();
		beanCopierForCurrency.copy(currencyInfo, currency, null);
		return currency;
	}

	public static List<CurrencyInfo> toCurrencyInfoList(List<Currency> currencyList)
	{
		if (currencyList == null || currencyList.isEmpty()) {
			return null;
		}
		List<CurrencyInfo> currencyInfoList = new ArrayList<CurrencyInfo>(currencyList.size());
		for (Currency currency : currencyList) {
			currencyInfoList.add(toCurrencyInfo(currency));
		}
		return currencyInfoList;
	}

	public static List<Currency> toCurrencyList(List<CurrencyInfo> currencyInfoList)
	{
		if (currencyInfoList == null || currencyInfoList.isEmpty()) {
			return null;
		}
		List<Currency> currencyList = new ArrayList<Currency>(currencyInfoList.size());
		for (CurrencyInfo currencyInfo : currencyInfoList) {
			currencyList.add(toCurrency(currencyInfo));
		}
		return currencyList;
	}
	
	public static CurrencyQuery toCurrencyQuery(CurrencyQueryInfo currencyQueryInfo)
	{
		if (currencyQueryInfo== null) {
			return null;
		}
		CurrencyQuery currencyQuery = new CurrencyQuery();
		beanCopierForCurrencyQuery.copy(currencyQueryInfo, currencyQuery, null);
		return currencyQuery;
	}

	public static QueryResultInfo<CurrencyInfo> toQueryResultInfo(QueryResult<Currency> queryResult)
	{
		QueryResultInfo<CurrencyInfo> queryResultInfo = new QueryResultInfo<CurrencyInfo>();
		queryResultInfo.setPages(queryResult.getPages());
		queryResult.setRecords(queryResult.getRecords());
		queryResultInfo.setTotal(queryResult.getTotal());
		queryResultInfo.setRecords(toCurrencyInfoList(queryResult.getRecords()));
		return queryResultInfo;
	}
}