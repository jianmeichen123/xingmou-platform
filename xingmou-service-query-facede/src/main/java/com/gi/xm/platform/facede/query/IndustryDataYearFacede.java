package com.gi.xm.platform.facede.query;


import java.util.List;
import java.util.Date;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.view.IndustryDataYearInfo;
import com.gi.xm.platform.view.IndustryDataYearQueryInfo;

public interface IndustryDataYearFacede {

	MessageInfo<IndustryDataYearInfo> getIndustryDataYear(Long id);
		
    MessageInfo<List<IndustryDataYearInfo>> getAllIndustryDataYear();
			
    MessageInfo<QueryResultInfo<IndustryDataYearInfo>> queryIndustryDataYear(IndustryDataYearQueryInfo industryDataYearQueryInfo);
	
		
	MessageInfo<List<IndustryDataYearInfo>> getListByIndustryIdYaar(Integer industryId, Integer[] yaars);
			
	MessageInfo<List<IndustryDataYearInfo>> getListByYaarIndustrySubId(Integer[] yaars, Integer industrySubId);
			
	MessageInfo<List<IndustryDataYearInfo>> getListByIndustryId(Integer industryId);
			
	MessageInfo<List<IndustryDataYearInfo>> getListByYaar(Integer[] yaars);
		

}