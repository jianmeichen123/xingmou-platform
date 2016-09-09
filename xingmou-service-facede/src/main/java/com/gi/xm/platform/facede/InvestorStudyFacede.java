package com.gi.xm.platform.facede;


import java.util.List;
import java.util.Date;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.view.InvestorStudyInfo;
import com.gi.xm.platform.view.InvestorStudyQueryInfo;

public interface InvestorStudyFacede {
		MessageInfo<Integer> deleteInvestorStudy(Long id);
		
    MessageInfo<Long> createInvestorStudy(InvestorStudyInfo investorStudyInfo);
		
	MessageInfo<Integer> updateInvestorStudy(InvestorStudyInfo investorStudyInfo);
		
	MessageInfo<InvestorStudyInfo> getInvestorStudy(Long id);
		
    MessageInfo<List<InvestorStudyInfo>> getAllInvestorStudy();
			
    MessageInfo<QueryResultInfo<InvestorStudyInfo>> queryInvestorStudy(InvestorStudyQueryInfo investorStudyQueryInfo);
	
	

}