package com.gi.xm.platform.facede;


import java.util.List;
import java.util.Date;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.view.CompanyInfo;
import com.gi.xm.platform.view.CompanyQueryInfo;

public interface CompanyFacede {
		MessageInfo<Integer> deleteCompany(Long id);
		
    MessageInfo<Long> createCompany(CompanyInfo companyInfo);
		
	MessageInfo<Integer> updateCompany(CompanyInfo companyInfo);
		
	MessageInfo<CompanyInfo> getCompany(Long id);
		
    MessageInfo<List<CompanyInfo>> getAllCompany();
			
    MessageInfo<QueryResultInfo<CompanyInfo>> queryCompany(CompanyQueryInfo companyQueryInfo);
	
	

}