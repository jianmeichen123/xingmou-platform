package com.gi.xm.platform.facede.convertor;
import java.util.ArrayList;
import java.util.List;

import java.util.Date;
import org.springframework.cglib.beans.BeanCopier;

import com.gi.xm.platform.view.CompanyInfo;
import com.gi.xm.platform.view.CompanyQueryInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.pojo.Company;
import com.gi.xm.platform.query.CompanyQuery;
import com.gi.xm.platform.biz.common.QueryResult;

public abstract class CompanyConvertor {

	private static final BeanCopier beanCopierForCompanyInfo = BeanCopier.create(Company.class, CompanyInfo.class, false);
	private static final BeanCopier beanCopierForCompany = BeanCopier.create(CompanyInfo.class, Company.class, false);
	private static final BeanCopier beanCopierForCompanyQuery = BeanCopier.create(CompanyQueryInfo.class, CompanyQuery.class, false);

	public static CompanyInfo toCompanyInfo(Company company)
	{
		if (company == null) {
			return null;
		}
		CompanyInfo companyInfo = new CompanyInfo();
		beanCopierForCompanyInfo.copy(company, companyInfo, null);
		return companyInfo;
	}

	public static Company toCompany(CompanyInfo companyInfo)
	{
		Company company = new Company();
		beanCopierForCompany.copy(companyInfo, company, null);
		return company;
	}

	public static List<CompanyInfo> toCompanyInfoList(List<Company> companyList)
	{
		if (companyList == null || companyList.isEmpty()) {
			return null;
		}
		List<CompanyInfo> companyInfoList = new ArrayList<CompanyInfo>(companyList.size());
		for (Company company : companyList) {
			companyInfoList.add(toCompanyInfo(company));
		}
		return companyInfoList;
	}

	public static List<Company> toCompanyList(List<CompanyInfo> companyInfoList)
	{
		if (companyInfoList == null || companyInfoList.isEmpty()) {
			return null;
		}
		List<Company> companyList = new ArrayList<Company>(companyInfoList.size());
		for (CompanyInfo companyInfo : companyInfoList) {
			companyList.add(toCompany(companyInfo));
		}
		return companyList;
	}
	
	public static CompanyQuery toCompanyQuery(CompanyQueryInfo companyQueryInfo)
	{
		if (companyQueryInfo== null) {
			return null;
		}
		CompanyQuery companyQuery = new CompanyQuery();
		beanCopierForCompanyQuery.copy(companyQueryInfo, companyQuery, null);
		return companyQuery;
	}

	public static QueryResultInfo<CompanyInfo> toQueryResultInfo(QueryResult<Company> queryResult)
	{
		QueryResultInfo<CompanyInfo> queryResultInfo = new QueryResultInfo<CompanyInfo>();
		queryResultInfo.setPages(queryResult.getPages());
		queryResult.setRecords(queryResult.getRecords());
		queryResultInfo.setTotal(queryResult.getTotal());
		queryResultInfo.setRecords(toCompanyInfoList(queryResult.getRecords()));
		return queryResultInfo;
	}
}