package com.gi.xm.platform.facede;


import java.util.List;
import java.util.Date;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.view.InvestfirmRoundInfo;
import com.gi.xm.platform.view.InvestfirmRoundQueryInfo;

public interface InvestfirmRoundFacede {
		MessageInfo<Integer> deleteInvestfirmRound(Long id);
		
    MessageInfo<Long> createInvestfirmRound(InvestfirmRoundInfo investfirmRoundInfo);
		
	MessageInfo<Integer> updateInvestfirmRound(InvestfirmRoundInfo investfirmRoundInfo);
		
	MessageInfo<InvestfirmRoundInfo> getInvestfirmRound(Long id);
		
    MessageInfo<List<InvestfirmRoundInfo>> getAllInvestfirmRound();
			
    MessageInfo<QueryResultInfo<InvestfirmRoundInfo>> queryInvestfirmRound(InvestfirmRoundQueryInfo investfirmRoundQueryInfo);
	
		
	MessageInfo<List<InvestfirmRoundInfo>> getListByInvestfrimId(Integer investfrimId);
		

}