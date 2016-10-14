package com.gi.xm.platform.facede.convertor;
import java.util.ArrayList;
import java.util.List;

import java.util.Date;
import org.springframework.cglib.beans.BeanCopier;

import com.gi.xm.platform.view.InvestorCompanyInfo;
import com.gi.xm.platform.view.InvestorCompanyQueryInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.pojo.InvestorCompany;
import com.gi.xm.platform.query.InvestorCompanyQuery;
import com.gi.xm.platform.biz.common.QueryResult;

public abstract class InvestorCompanyConvertor {

	private static final BeanCopier beanCopierForInvestorCompanyInfo = BeanCopier.create(InvestorCompany.class, InvestorCompanyInfo.class, false);
	private static final BeanCopier beanCopierForInvestorCompany = BeanCopier.create(InvestorCompanyInfo.class, InvestorCompany.class, false);
	private static final BeanCopier beanCopierForInvestorCompanyQuery = BeanCopier.create(InvestorCompanyQueryInfo.class, InvestorCompanyQuery.class, false);

	public static InvestorCompanyInfo toInvestorCompanyInfo(InvestorCompany investorCompany)
	{
		if (investorCompany == null) {
			return null;
		}
		InvestorCompanyInfo investorCompanyInfo = new InvestorCompanyInfo();
		beanCopierForInvestorCompanyInfo.copy(investorCompany, investorCompanyInfo, null);
		return investorCompanyInfo;
	}

	public static InvestorCompany toInvestorCompany(InvestorCompanyInfo investorCompanyInfo)
	{
		InvestorCompany investorCompany = new InvestorCompany();
		beanCopierForInvestorCompany.copy(investorCompanyInfo, investorCompany, null);
		return investorCompany;
	}

	public static List<InvestorCompanyInfo> toInvestorCompanyInfoList(List<InvestorCompany> investorCompanyList)
	{
		if (investorCompanyList == null || investorCompanyList.isEmpty()) {
			return null;
		}
		List<InvestorCompanyInfo> investorCompanyInfoList = new ArrayList<InvestorCompanyInfo>(investorCompanyList.size());
		for (InvestorCompany investorCompany : investorCompanyList) {
			investorCompanyInfoList.add(toInvestorCompanyInfo(investorCompany));
		}
		return investorCompanyInfoList;
	}

	public static List<InvestorCompany> toInvestorCompanyList(List<InvestorCompanyInfo> investorCompanyInfoList)
	{
		if (investorCompanyInfoList == null || investorCompanyInfoList.isEmpty()) {
			return null;
		}
		List<InvestorCompany> investorCompanyList = new ArrayList<InvestorCompany>(investorCompanyInfoList.size());
		for (InvestorCompanyInfo investorCompanyInfo : investorCompanyInfoList) {
			investorCompanyList.add(toInvestorCompany(investorCompanyInfo));
		}
		return investorCompanyList;
	}
	
	public static InvestorCompanyQuery toInvestorCompanyQuery(InvestorCompanyQueryInfo investorCompanyQueryInfo)
	{
		if (investorCompanyQueryInfo== null) {
			return null;
		}
		InvestorCompanyQuery investorCompanyQuery = new InvestorCompanyQuery();
		beanCopierForInvestorCompanyQuery.copy(investorCompanyQueryInfo, investorCompanyQuery, null);
		return investorCompanyQuery;
	}

	public static QueryResultInfo<InvestorCompanyInfo> toQueryResultInfo(QueryResult<InvestorCompany> queryResult)
	{
		QueryResultInfo<InvestorCompanyInfo> queryResultInfo = new QueryResultInfo<InvestorCompanyInfo>();
		queryResultInfo.setPages(queryResult.getPages());
		queryResult.setRecords(queryResult.getRecords());
		queryResultInfo.setTotal(queryResult.getTotal());
		queryResultInfo.setRecords(toInvestorCompanyInfoList(queryResult.getRecords()));
		return queryResultInfo;
	}
}