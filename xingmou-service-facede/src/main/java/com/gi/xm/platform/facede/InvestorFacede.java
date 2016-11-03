package com.gi.xm.platform.facede;


import java.util.List;
import java.util.Date;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.view.InvestorInfo;
import com.gi.xm.platform.view.InvestorQueryInfo;

public interface InvestorFacede {

    MessageInfo<Integer> deleteInvestor(Long id);
		
    MessageInfo<Long> createInvestor(InvestorInfo investorInfo);
		
	MessageInfo<Integer> updateInvestor(InvestorInfo investorInfo);
		
	MessageInfo<InvestorInfo> getInvestor(Long id);
		
    MessageInfo<List<InvestorInfo>> getAllInvestor();

    /**
     *
     * @param investorQueryInfo
     * @return
     */
    MessageInfo<QueryResultInfo<InvestorInfo>> queryInvestor(InvestorQueryInfo investorQueryInfo);
	
	

}