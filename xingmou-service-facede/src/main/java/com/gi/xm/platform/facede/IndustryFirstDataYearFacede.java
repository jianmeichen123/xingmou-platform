package com.gi.xm.platform.facede;


import java.util.List;

import com.gi.xm.platform.view.IndustryDataYearInfo;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.view.IndustryFirstDataYearInfo;
import com.gi.xm.platform.view.IndustryFirstDataYearQueryInfo;

public interface IndustryFirstDataYearFacede {
		MessageInfo<Integer> deleteIndustryFirstDataYear(Long id);
		
    MessageInfo<Long> createIndustryFirstDataYear(IndustryFirstDataYearInfo industryFirstDataYearInfo);
		
	MessageInfo<Integer> updateIndustryFirstDataYear(IndustryFirstDataYearInfo industryFirstDataYearInfo);
		
	MessageInfo<IndustryFirstDataYearInfo> getIndustryFirstDataYear(Long id);
		
    MessageInfo<List<IndustryFirstDataYearInfo>> getAllIndustryFirstDataYear();
			
    MessageInfo<QueryResultInfo<IndustryDataYearInfo>> queryIndustryFirstDataYear(IndustryFirstDataYearQueryInfo industryFirstDataYearQueryInfo);
	
		
	MessageInfo<List<IndustryFirstDataYearInfo>> getListByIndustryIdYaar(Integer industryId, Integer yaar);
			
	MessageInfo<List<IndustryFirstDataYearInfo>> getListByYaar(Integer[] yaars);


	MessageInfo<List<IndustryFirstDataYearInfo>> getListByIndustryId(Integer industryId);

		

}