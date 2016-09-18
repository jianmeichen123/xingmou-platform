package com.gi.xm.platform.facede;


import java.util.List;
import java.util.Date;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.view.IndustryDataHalfYearInfo;
import com.gi.xm.platform.view.IndustryDataHalfYearQueryInfo;

public interface IndustryDataHalfYearFacede {
		MessageInfo<Integer> deleteIndustryDataHalfYear(Long id);
		
    MessageInfo<Long> createIndustryDataHalfYear(IndustryDataHalfYearInfo industryDataHalfYearInfo);
		
	MessageInfo<Integer> updateIndustryDataHalfYear(IndustryDataHalfYearInfo industryDataHalfYearInfo);
		
	MessageInfo<IndustryDataHalfYearInfo> getIndustryDataHalfYear(Long id);
		
    MessageInfo<List<IndustryDataHalfYearInfo>> getAllIndustryDataHalfYear();
			
    MessageInfo<QueryResultInfo<IndustryDataHalfYearInfo>> queryIndustryDataHalfYear(IndustryDataHalfYearQueryInfo industryDataHalfYearQueryInfo);
	
		
	MessageInfo<List<IndustryDataHalfYearInfo>> getListByIndustryIdYaar(Integer industryId, Integer yaar);
			
	MessageInfo<List<IndustryDataHalfYearInfo>> getListByYaarIndustrySubId(Integer yaar, Integer industrySubId);
			
	MessageInfo<List<IndustryDataHalfYearInfo>> getListByIndustryId(Integer industryId);
			
	MessageInfo<List<IndustryDataHalfYearInfo>> getListByYaar(Integer yaar);
		

}