package com.gi.xm.platform.facede.query;


import java.util.List;
import java.util.Date;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.view.InvestorInverstfirmInfo;
import com.gi.xm.platform.view.InvestorInverstfirmQueryInfo;

public interface InvestorInverstfirmFacede {

	MessageInfo<InvestorInverstfirmInfo> getInvestorInverstfirm(Long id);
		
    MessageInfo<List<InvestorInverstfirmInfo>> getAllInvestorInverstfirm();
			
    MessageInfo<QueryResultInfo<InvestorInverstfirmInfo>> queryInvestorInverstfirm(InvestorInverstfirmQueryInfo investorInverstfirmQueryInfo);
	
	

}