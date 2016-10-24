package com.gi.xm.platform.facede;


import java.util.List;
import java.util.Date;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.view.InvestfirmsDataInfo;
import com.gi.xm.platform.view.InvestfirmsDataQueryInfo;

public interface InvestfirmsDataFacede {
		MessageInfo<Integer> deleteInvestfirmsData(Integer id);
		
    MessageInfo<Integer> createInvestfirmsData(InvestfirmsDataInfo investfirmsDataInfo);
		
	MessageInfo<Integer> updateInvestfirmsData(InvestfirmsDataInfo investfirmsDataInfo);
		
	MessageInfo<InvestfirmsDataInfo> getInvestfirmsData(Integer id);
		
    MessageInfo<List<InvestfirmsDataInfo>> getAllInvestfirmsData();
			
    MessageInfo<QueryResultInfo<InvestfirmsDataInfo>> queryInvestfirmsData(InvestfirmsDataQueryInfo investfirmsDataQueryInfo);
	
		
	MessageInfo<List<InvestfirmsDataInfo>> getListByInvestfirmId(Long investfirmId);
		

}