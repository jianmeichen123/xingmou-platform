package com.gi.xm.platform.facede;


import java.util.List;
import java.util.Date;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.view.InvestEventsInvestfirmInfo;
import com.gi.xm.platform.view.InvestEventsInvestfirmQueryInfo;

public interface InvestEventsInvestfirmFacede {
		MessageInfo<Integer> deleteInvestEventsInvestfirm(Long id);
		
    MessageInfo<Long> createInvestEventsInvestfirm(InvestEventsInvestfirmInfo investEventsInvestfirmInfo);
		
	MessageInfo<Integer> updateInvestEventsInvestfirm(InvestEventsInvestfirmInfo investEventsInvestfirmInfo);
		
	MessageInfo<InvestEventsInvestfirmInfo> getInvestEventsInvestfirm(Long id);
		
    MessageInfo<List<InvestEventsInvestfirmInfo>> getAllInvestEventsInvestfirm();
			
    MessageInfo<QueryResultInfo<InvestEventsInvestfirmInfo>> queryInvestEventsInvestfirm(InvestEventsInvestfirmQueryInfo investEventsInvestfirmQueryInfo);
	
	

}