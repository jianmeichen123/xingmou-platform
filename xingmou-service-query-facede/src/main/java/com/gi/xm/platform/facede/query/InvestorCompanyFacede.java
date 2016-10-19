package com.gi.xm.platform.facede.query;


import java.util.List;
import java.util.Date;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.view.InvestorCompanyInfo;
import com.gi.xm.platform.view.InvestorCompanyQueryInfo;

public interface InvestorCompanyFacede {

	MessageInfo<Integer> changeStatus(Long id, Integer status, String operatorId);
		
	MessageInfo<InvestorCompanyInfo> getInvestorCompany(Long id);
		
    MessageInfo<List<InvestorCompanyInfo>> getAllInvestorCompany();
			
    MessageInfo<QueryResultInfo<InvestorCompanyInfo>> queryInvestorCompany(InvestorCompanyQueryInfo investorCompanyQueryInfo);
	
	

}