package com.gi.xm.platform.facede;


import java.util.List;
import java.util.Date;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.view.DataYearInfo;
import com.gi.xm.platform.view.DataYearQueryInfo;

public interface DataYearFacede {
		MessageInfo<Integer> deleteDataYear(Long id);
		
    MessageInfo<Long> createDataYear(DataYearInfo dataYearInfo);
		
	MessageInfo<Integer> updateDataYear(DataYearInfo dataYearInfo);
		
	MessageInfo<DataYearInfo> getDataYear(Long id);
		
    MessageInfo<List<DataYearInfo>> getAllDataYear();
			
    MessageInfo<QueryResultInfo<DataYearInfo>> queryDataYear(DataYearQueryInfo dataYearQueryInfo);
	
		
	MessageInfo<List<DataYearInfo>> getListByDistrictId(Integer districtId);
			
	MessageInfo<List<DataYearInfo>> getListByIndustryId(Integer industryId);
			
	MessageInfo<List<DataYearInfo>> getListByMoneyLevelId(Integer moneyLevelId);
			
	MessageInfo<List<DataYearInfo>> getListByRoundId(Integer roundId);
			
	MessageInfo<List<DataYearInfo>> getListByYear(Integer year);
		

}