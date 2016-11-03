package com.gi.xm.platform.facede.query;


import java.util.List;
import java.util.Date;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.view.CompanyInfo;
import com.gi.xm.platform.view.CompanyQueryInfo;

public interface CompanyFacede {
		
		
		
	MessageInfo<CompanyInfo> getCompany(Long id);
		
    MessageInfo<QueryResultInfo<CompanyInfo>> queryCompany(CompanyQueryInfo companyQueryInfo);
	
	

}