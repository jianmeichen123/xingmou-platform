package com.gi.xm.platform.facede;


import java.util.List;
import java.util.Date;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.view.IndustryInfo;
import com.gi.xm.platform.view.IndustryQueryInfo;

public interface IndustryFacede {
		MessageInfo<Integer> deleteIndustry(Integer id);
		
    MessageInfo<Integer> createIndustry(IndustryInfo industryInfo);
		
	MessageInfo<Integer> updateIndustry(IndustryInfo industryInfo);
		
	MessageInfo<IndustryInfo> getIndustry(Integer id);
		
    MessageInfo<List<IndustryInfo>> getAllIndustry();
			
    MessageInfo<QueryResultInfo<IndustryInfo>> queryIndustry(IndustryQueryInfo industryQueryInfo);
	
	

}