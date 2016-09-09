package com.gi.xm.platform.facede;


import java.util.List;
import java.util.Date;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.view.InvestorRoundsInfo;
import com.gi.xm.platform.view.InvestorRoundsQueryInfo;

public interface InvestorRoundsFacede {
		MessageInfo<Integer> deleteInvestorRounds(Long id);
		
    MessageInfo<Long> createInvestorRounds(InvestorRoundsInfo investorRoundsInfo);
		
	MessageInfo<Integer> updateInvestorRounds(InvestorRoundsInfo investorRoundsInfo);
		
	MessageInfo<InvestorRoundsInfo> getInvestorRounds(Long id);
		
    MessageInfo<List<InvestorRoundsInfo>> getAllInvestorRounds();
			
    MessageInfo<QueryResultInfo<InvestorRoundsInfo>> queryInvestorRounds(InvestorRoundsQueryInfo investorRoundsQueryInfo);
	
	

}