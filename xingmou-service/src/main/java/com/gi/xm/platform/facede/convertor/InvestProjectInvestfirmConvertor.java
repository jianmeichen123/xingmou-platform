package com.gi.xm.platform.facede.convertor;
import java.util.ArrayList;
import java.util.List;

import java.util.Date;
import org.springframework.cglib.beans.BeanCopier;

import com.gi.xm.platform.view.InvestProjectInvestfirmInfo;
import com.gi.xm.platform.view.InvestProjectInvestfirmQueryInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.pojo.InvestProjectInvestfirm;
import com.gi.xm.platform.query.InvestProjectInvestfirmQuery;
import com.gi.xm.platform.biz.common.QueryResult;

public abstract class InvestProjectInvestfirmConvertor {

	private static final BeanCopier beanCopierForInvestProjectInvestfirmInfo = BeanCopier.create(InvestProjectInvestfirm.class, InvestProjectInvestfirmInfo.class, false);
	private static final BeanCopier beanCopierForInvestProjectInvestfirm = BeanCopier.create(InvestProjectInvestfirmInfo.class, InvestProjectInvestfirm.class, false);
	private static final BeanCopier beanCopierForInvestProjectInvestfirmQuery = BeanCopier.create(InvestProjectInvestfirmQueryInfo.class, InvestProjectInvestfirmQuery.class, false);

	public static InvestProjectInvestfirmInfo toInvestProjectInvestfirmInfo(InvestProjectInvestfirm investProjectInvestfirm)
	{
		if (investProjectInvestfirm == null) {
			return null;
		}
		InvestProjectInvestfirmInfo investProjectInvestfirmInfo = new InvestProjectInvestfirmInfo();
		beanCopierForInvestProjectInvestfirmInfo.copy(investProjectInvestfirm, investProjectInvestfirmInfo, null);
		return investProjectInvestfirmInfo;
	}

	public static InvestProjectInvestfirm toInvestProjectInvestfirm(InvestProjectInvestfirmInfo investProjectInvestfirmInfo)
	{
		InvestProjectInvestfirm investProjectInvestfirm = new InvestProjectInvestfirm();
		beanCopierForInvestProjectInvestfirm.copy(investProjectInvestfirmInfo, investProjectInvestfirm, null);
		return investProjectInvestfirm;
	}

	public static List<InvestProjectInvestfirmInfo> toInvestProjectInvestfirmInfoList(List<InvestProjectInvestfirm> investProjectInvestfirmList)
	{
		if (investProjectInvestfirmList == null || investProjectInvestfirmList.isEmpty()) {
			return null;
		}
		List<InvestProjectInvestfirmInfo> investProjectInvestfirmInfoList = new ArrayList<InvestProjectInvestfirmInfo>(investProjectInvestfirmList.size());
		for (InvestProjectInvestfirm investProjectInvestfirm : investProjectInvestfirmList) {
			investProjectInvestfirmInfoList.add(toInvestProjectInvestfirmInfo(investProjectInvestfirm));
		}
		return investProjectInvestfirmInfoList;
	}

	public static List<InvestProjectInvestfirm> toInvestProjectInvestfirmList(List<InvestProjectInvestfirmInfo> investProjectInvestfirmInfoList)
	{
		if (investProjectInvestfirmInfoList == null || investProjectInvestfirmInfoList.isEmpty()) {
			return null;
		}
		List<InvestProjectInvestfirm> investProjectInvestfirmList = new ArrayList<InvestProjectInvestfirm>(investProjectInvestfirmInfoList.size());
		for (InvestProjectInvestfirmInfo investProjectInvestfirmInfo : investProjectInvestfirmInfoList) {
			investProjectInvestfirmList.add(toInvestProjectInvestfirm(investProjectInvestfirmInfo));
		}
		return investProjectInvestfirmList;
	}
	
	public static InvestProjectInvestfirmQuery toInvestProjectInvestfirmQuery(InvestProjectInvestfirmQueryInfo investProjectInvestfirmQueryInfo)
	{
		if (investProjectInvestfirmQueryInfo== null) {
			return null;
		}
		InvestProjectInvestfirmQuery investProjectInvestfirmQuery = new InvestProjectInvestfirmQuery();
		beanCopierForInvestProjectInvestfirmQuery.copy(investProjectInvestfirmQueryInfo, investProjectInvestfirmQuery, null);
		return investProjectInvestfirmQuery;
	}

	public static QueryResultInfo<InvestProjectInvestfirmInfo> toQueryResultInfo(QueryResult<InvestProjectInvestfirm> queryResult)
	{
		QueryResultInfo<InvestProjectInvestfirmInfo> queryResultInfo = new QueryResultInfo<InvestProjectInvestfirmInfo>();
		queryResultInfo.setPages(queryResult.getPages());
		queryResult.setRecords(queryResult.getRecords());
		queryResultInfo.setTotal(queryResult.getTotal());
		queryResultInfo.setRecords(toInvestProjectInvestfirmInfoList(queryResult.getRecords()));
		return queryResultInfo;
	}
}