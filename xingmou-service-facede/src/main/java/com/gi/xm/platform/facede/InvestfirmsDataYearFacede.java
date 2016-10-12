package com.gi.xm.platform.facede;


import java.util.List;
import java.util.Date;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.view.InvestfirmsDataYearInfo;
import com.gi.xm.platform.view.InvestfirmsDataYearQueryInfo;

public interface InvestfirmsDataYearFacede {
		MessageInfo<Integer> deleteInvestfirmsDataYear(Long id);
		
    MessageInfo<Long> createInvestfirmsDataYear(InvestfirmsDataYearInfo investfirmsDataYearInfo);
		
	MessageInfo<Integer> updateInvestfirmsDataYear(InvestfirmsDataYearInfo investfirmsDataYearInfo);
		
	MessageInfo<InvestfirmsDataYearInfo> getInvestfirmsDataYear(Long id);
		
    MessageInfo<List<InvestfirmsDataYearInfo>> getAllInvestfirmsDataYear();
			
    MessageInfo<QueryResultInfo<InvestfirmsDataYearInfo>> queryInvestfirmsDataYear(InvestfirmsDataYearQueryInfo investfirmsDataYearQueryInfo);
	MessageInfo<QueryResultInfo<InvestfirmsDataYearInfo>> queryInvestfirmsDataYearByIndustry(InvestfirmsDataYearQueryInfo investfirmsDataYearQueryInfo);
	MessageInfo<QueryResultInfo<InvestfirmsDataYearInfo>> queryInvestfirmsDataYearBySub(InvestfirmsDataYearQueryInfo investfirmsDataYearQueryInfo);


	MessageInfo<List<InvestfirmsDataYearInfo>> getListByInvestfirmId(Long investfirmId);
			
	MessageInfo<List<InvestfirmsDataYearInfo>> getListByYear(Integer year);
		

}