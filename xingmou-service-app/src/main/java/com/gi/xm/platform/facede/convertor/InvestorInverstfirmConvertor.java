package com.gi.xm.platform.facede.convertor;
import java.util.ArrayList;
import java.util.List;

import java.util.Date;
import org.springframework.cglib.beans.BeanCopier;

import com.gi.xm.platform.view.InvestorInverstfirmInfo;
import com.gi.xm.platform.view.InvestorInverstfirmQueryInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.pojo.InvestorInverstfirm;
import com.gi.xm.platform.query.InvestorInverstfirmQuery;
import com.gi.xm.platform.biz.common.QueryResult;

public abstract class InvestorInverstfirmConvertor {

	private static final BeanCopier beanCopierForInvestorInverstfirmInfo = BeanCopier.create(InvestorInverstfirm.class, InvestorInverstfirmInfo.class, false);
	private static final BeanCopier beanCopierForInvestorInverstfirm = BeanCopier.create(InvestorInverstfirmInfo.class, InvestorInverstfirm.class, false);
	private static final BeanCopier beanCopierForInvestorInverstfirmQuery = BeanCopier.create(InvestorInverstfirmQueryInfo.class, InvestorInverstfirmQuery.class, false);

	public static InvestorInverstfirmInfo toInvestorInverstfirmInfo(InvestorInverstfirm investorInverstfirm)
	{
		if (investorInverstfirm == null) {
			return null;
		}
		InvestorInverstfirmInfo investorInverstfirmInfo = new InvestorInverstfirmInfo();
		beanCopierForInvestorInverstfirmInfo.copy(investorInverstfirm, investorInverstfirmInfo, null);
		return investorInverstfirmInfo;
	}

	public static InvestorInverstfirm toInvestorInverstfirm(InvestorInverstfirmInfo investorInverstfirmInfo)
	{
		InvestorInverstfirm investorInverstfirm = new InvestorInverstfirm();
		beanCopierForInvestorInverstfirm.copy(investorInverstfirmInfo, investorInverstfirm, null);
		return investorInverstfirm;
	}

	public static List<InvestorInverstfirmInfo> toInvestorInverstfirmInfoList(List<InvestorInverstfirm> investorInverstfirmList)
	{
		if (investorInverstfirmList == null || investorInverstfirmList.isEmpty()) {
			return null;
		}
		List<InvestorInverstfirmInfo> investorInverstfirmInfoList = new ArrayList<InvestorInverstfirmInfo>(investorInverstfirmList.size());
		for (InvestorInverstfirm investorInverstfirm : investorInverstfirmList) {
			investorInverstfirmInfoList.add(toInvestorInverstfirmInfo(investorInverstfirm));
		}
		return investorInverstfirmInfoList;
	}

	public static List<InvestorInverstfirm> toInvestorInverstfirmList(List<InvestorInverstfirmInfo> investorInverstfirmInfoList)
	{
		if (investorInverstfirmInfoList == null || investorInverstfirmInfoList.isEmpty()) {
			return null;
		}
		List<InvestorInverstfirm> investorInverstfirmList = new ArrayList<InvestorInverstfirm>(investorInverstfirmInfoList.size());
		for (InvestorInverstfirmInfo investorInverstfirmInfo : investorInverstfirmInfoList) {
			investorInverstfirmList.add(toInvestorInverstfirm(investorInverstfirmInfo));
		}
		return investorInverstfirmList;
	}
	
	public static InvestorInverstfirmQuery toInvestorInverstfirmQuery(InvestorInverstfirmQueryInfo investorInverstfirmQueryInfo)
	{
		if (investorInverstfirmQueryInfo== null) {
			return null;
		}
		InvestorInverstfirmQuery investorInverstfirmQuery = new InvestorInverstfirmQuery();
		beanCopierForInvestorInverstfirmQuery.copy(investorInverstfirmQueryInfo, investorInverstfirmQuery, null);
		return investorInverstfirmQuery;
	}

	public static QueryResultInfo<InvestorInverstfirmInfo> toQueryResultInfo(QueryResult<InvestorInverstfirm> queryResult)
	{
		QueryResultInfo<InvestorInverstfirmInfo> queryResultInfo = new QueryResultInfo<InvestorInverstfirmInfo>();
		queryResultInfo.setPages(queryResult.getPages());
		queryResult.setRecords(queryResult.getRecords());
		queryResultInfo.setTotal(queryResult.getTotal());
		queryResultInfo.setRecords(toInvestorInverstfirmInfoList(queryResult.getRecords()));
		return queryResultInfo;
	}
}