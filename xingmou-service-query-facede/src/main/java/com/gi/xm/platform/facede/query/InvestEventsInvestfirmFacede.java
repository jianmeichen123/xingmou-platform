package com.gi.xm.platform.facede.query;


import java.util.List;
import java.util.Date;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.view.InvestEventsInvestfirmInfo;
import com.gi.xm.platform.view.InvestEventsInvestfirmQueryInfo;

public interface InvestEventsInvestfirmFacede {

	MessageInfo<InvestEventsInvestfirmInfo> getInvestEventsInvestfirm(Long id);
		
    MessageInfo<List<InvestEventsInvestfirmInfo>> getAllInvestEventsInvestfirm();
			
    MessageInfo<QueryResultInfo<InvestEventsInvestfirmInfo>> queryInvestEventsInvestfirm(InvestEventsInvestfirmQueryInfo investEventsInvestfirmQueryInfo);
	
	

}