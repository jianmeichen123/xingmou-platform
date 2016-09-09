package com.gi.xm.platform.facede;


import java.util.List;
import java.util.Date;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.view.InvestorAreasInfo;
import com.gi.xm.platform.view.InvestorAreasQueryInfo;

public interface InvestorAreasFacede {
		MessageInfo<Integer> deleteInvestorAreas(Long id);
		
    MessageInfo<Long> createInvestorAreas(InvestorAreasInfo investorAreasInfo);
		
	MessageInfo<Integer> updateInvestorAreas(InvestorAreasInfo investorAreasInfo);
		
	MessageInfo<InvestorAreasInfo> getInvestorAreas(Long id);
		
    MessageInfo<List<InvestorAreasInfo>> getAllInvestorAreas();
			
    MessageInfo<QueryResultInfo<InvestorAreasInfo>> queryInvestorAreas(InvestorAreasQueryInfo investorAreasQueryInfo);
	
	

}