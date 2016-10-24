package com.gi.xm.platform.facede.query;


import java.util.List;
import java.util.Date;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.view.InvestfirmsInfo;
import com.gi.xm.platform.view.InvestfirmsQueryInfo;

public interface InvestfirmsFacede {

	MessageInfo<InvestfirmsInfo> getInvestfirms(Long id);
		
    MessageInfo<List<InvestfirmsInfo>> getAllInvestfirms();
			
    MessageInfo<QueryResultInfo<InvestfirmsInfo>> queryInvestfirms(InvestfirmsQueryInfo investfirmsQueryInfo);
	
		
	MessageInfo<List<InvestfirmsInfo>> getListBySourceId(Long sourceId);
		

}