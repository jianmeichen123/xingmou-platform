package com.gi.xm.platform.facede.query;


import java.util.List;
import java.util.Date;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.view.InvestfirmRoundInfo;
import com.gi.xm.platform.view.InvestfirmRoundQueryInfo;

public interface InvestfirmRoundFacede {

	MessageInfo<InvestfirmRoundInfo> getInvestfirmRound(Long id);
		
    MessageInfo<List<InvestfirmRoundInfo>> getAllInvestfirmRound();
			
    MessageInfo<QueryResultInfo<InvestfirmRoundInfo>> queryInvestfirmRound(InvestfirmRoundQueryInfo investfirmRoundQueryInfo);
	
		
	MessageInfo<List<InvestfirmRoundInfo>> getListByInvestfrimId(Integer investfrimId);
		

}