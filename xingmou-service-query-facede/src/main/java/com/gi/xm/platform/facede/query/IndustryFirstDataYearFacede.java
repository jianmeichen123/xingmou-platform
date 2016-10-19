package com.gi.xm.platform.facede.query;


import java.util.List;

import com.gi.xm.platform.view.IndustryDataYearInfo;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.view.IndustryFirstDataYearInfo;
import com.gi.xm.platform.view.IndustryFirstDataYearQueryInfo;

public interface IndustryFirstDataYearFacede {

	MessageInfo<IndustryFirstDataYearInfo> getIndustryFirstDataYear(Long id);
		
    MessageInfo<List<IndustryFirstDataYearInfo>> getAllIndustryFirstDataYear();
			
    MessageInfo<QueryResultInfo<IndustryDataYearInfo>> queryIndustryFirstDataYear(IndustryFirstDataYearQueryInfo industryFirstDataYearQueryInfo);
	MessageInfo<QueryResultInfo<IndustryDataYearInfo>> queryIndustryDataYear(IndustryFirstDataYearQueryInfo industryFirstDataYearQueryInfo);


	MessageInfo<List<IndustryDataYearInfo>> getListByIndustryIdYaar(Integer industryId, Integer[] yaars);
			
	MessageInfo<List<IndustryFirstDataYearInfo>> getListByYaar(Integer[] yaars);


	MessageInfo<List<IndustryFirstDataYearInfo>> getListByIndustryId(Integer industryId);

		

}