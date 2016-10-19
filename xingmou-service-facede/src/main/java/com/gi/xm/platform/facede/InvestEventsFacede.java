package com.gi.xm.platform.facede;


import java.util.List;
import java.util.Date;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.view.InvestEventsInfo;
import com.gi.xm.platform.view.InvestEventsQueryInfo;
import com.gi.xm.platform.view.InvestfirmsQueryInfo;

public interface InvestEventsFacede {
		MessageInfo<Integer> deleteInvestEvents(Long id);
		
    MessageInfo<Long> createInvestEvents(InvestEventsInfo investEventsInfo);
		
	MessageInfo<Integer> updateInvestEvents(InvestEventsInfo investEventsInfo);
		
	MessageInfo<InvestEventsInfo> getInvestEvents(Long id);
		
    MessageInfo<List<InvestEventsInfo>> getAllInvestEvents();

    /**
     *
     * @param investEventsQueryInfo
     * @return
     */
    MessageInfo<QueryResultInfo<InvestEventsInfo>> queryInvestEvents(InvestEventsQueryInfo investEventsQueryInfo);
    List<InvestEventsInfo>  queryProject(InvestEventsQueryInfo investEventsQueryInfo);

	MessageInfo<QueryResultInfo<InvestEventsInfo>> getEventByInvestfirmId(InvestfirmsQueryInfo investfirmsQueryInfo);


    MessageInfo<List<InvestEventsInfo>> getListByProjectId(Long projectId);

}