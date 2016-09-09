package com.gi.xm.platform.facede;


import java.util.List;
import java.util.Date;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.view.IndustryDataYearInfo;
import com.gi.xm.platform.view.IndustryDataYearQueryInfo;

public interface IndustryDataYearFacede {
		MessageInfo<Integer> deleteIndustryDataYear(Long id);
		
    MessageInfo<Long> createIndustryDataYear(IndustryDataYearInfo industryDataYearInfo);
		
	MessageInfo<Integer> updateIndustryDataYear(IndustryDataYearInfo industryDataYearInfo);
		
	MessageInfo<IndustryDataYearInfo> getIndustryDataYear(Long id);
		
    MessageInfo<List<IndustryDataYearInfo>> getAllIndustryDataYear();
			
    MessageInfo<QueryResultInfo<IndustryDataYearInfo>> queryIndustryDataYear(IndustryDataYearQueryInfo industryDataYearQueryInfo);
	
		
	MessageInfo<List<IndustryDataYearInfo>> getListByIndustryId(Integer industryId);
			
	MessageInfo<List<IndustryDataYearInfo>> getListByYaar(Integer yaar);
		

}