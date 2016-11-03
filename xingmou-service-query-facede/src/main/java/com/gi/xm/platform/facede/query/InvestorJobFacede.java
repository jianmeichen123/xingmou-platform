package com.gi.xm.platform.facede.query;


import java.util.List;
import java.util.Date;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.view.InvestorJobInfo;
import com.gi.xm.platform.view.InvestorJobQueryInfo;

public interface InvestorJobFacede {

	MessageInfo<InvestorJobInfo> getInvestorJob(Long id);
		
    MessageInfo<List<InvestorJobInfo>> getAllInvestorJob();
			
    MessageInfo<QueryResultInfo<InvestorJobInfo>> queryInvestorJob(InvestorJobQueryInfo investorJobQueryInfo);
	
	

}