package com.gi.xm.platform.facede;


import java.util.List;
import java.util.Date;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.view.InvestProjectInvestfirmInfo;
import com.gi.xm.platform.view.InvestProjectInvestfirmQueryInfo;

public interface InvestProjectInvestfirmFacede {
		MessageInfo<Integer> deleteInvestProjectInvestfirm(Long id);
		
    MessageInfo<Long> createInvestProjectInvestfirm(InvestProjectInvestfirmInfo investProjectInvestfirmInfo);
		
	MessageInfo<Integer> updateInvestProjectInvestfirm(InvestProjectInvestfirmInfo investProjectInvestfirmInfo);
		
	MessageInfo<InvestProjectInvestfirmInfo> getInvestProjectInvestfirm(Long id);
		
    MessageInfo<List<InvestProjectInvestfirmInfo>> getAllInvestProjectInvestfirm();
			
    MessageInfo<QueryResultInfo<InvestProjectInvestfirmInfo>> queryInvestProjectInvestfirm(InvestProjectInvestfirmQueryInfo investProjectInvestfirmQueryInfo);
	
		
	MessageInfo<List<InvestProjectInvestfirmInfo>> getListByInvestId(Long investId);
			
	MessageInfo<List<InvestProjectInvestfirmInfo>> getListByInvestfirmId(Long investfirmId);
			
	MessageInfo<List<InvestProjectInvestfirmInfo>> getListByProjectId(Long projectId);
		

}