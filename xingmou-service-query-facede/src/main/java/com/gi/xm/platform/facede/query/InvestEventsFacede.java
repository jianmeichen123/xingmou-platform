package com.gi.xm.platform.facede.query;


import java.util.List;
import java.util.Date;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.view.InvestEventsInfo;
import com.gi.xm.platform.view.InvestEventsQueryInfo;
import com.gi.xm.platform.view.InvestfirmsQueryInfo;

public interface InvestEventsFacede {

	MessageInfo<InvestEventsInfo> getInvestEvents(Long id);
		
    MessageInfo<List<InvestEventsInfo>> getAllInvestEvents();
			
    MessageInfo<QueryResultInfo<InvestEventsInfo>> queryInvestEvents(InvestEventsQueryInfo investEventsQueryInfo);
    List<InvestEventsInfo>  queryProject(InvestEventsQueryInfo investEventsQueryInfo);

	MessageInfo<QueryResultInfo<InvestEventsInfo>> getEventByInvestfirmId(InvestfirmsQueryInfo investfirmsQueryInfo);


    MessageInfo<List<InvestEventsInfo>> getListByProjectId(Long projectId);

}