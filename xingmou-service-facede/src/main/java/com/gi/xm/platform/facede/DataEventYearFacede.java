package com.gi.xm.platform.facede;


import java.util.List;
import java.util.Date;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.view.DataEventYearInfo;
import com.gi.xm.platform.view.DataEventYearQueryInfo;

public interface DataEventYearFacede {
	MessageInfo<Integer> deleteDataEventYear(Long id);
		
    MessageInfo<Long> createDataEventYear(DataEventYearInfo dataEventYearInfo);
		
	MessageInfo<Integer> updateDataEventYear(DataEventYearInfo dataEventYearInfo);
		
	MessageInfo<DataEventYearInfo> getDataEventYear(Long id);
		
    MessageInfo<List<DataEventYearInfo>> getAllDataEventYear();
			
    MessageInfo<QueryResultInfo<DataEventYearInfo>> queryDataEventYear(DataEventYearQueryInfo dataEventYearQueryInfo);
	
		
	MessageInfo<List<DataEventYearInfo>> getListByYearIndustryId(Integer[] years, Integer industryId);
			
	MessageInfo<List<DataEventYearInfo>> getListByYearIndustrySubId(Integer[] years, Integer industrySubId);
			
	MessageInfo<List<DataEventYearInfo>> getListByDistrictId(Integer districtId);
			
	MessageInfo<List<DataEventYearInfo>> getListByIndustryId(Integer industryId);
			
	MessageInfo<List<DataEventYearInfo>> getListByMoneyLevelId(Integer moneyLevelId);
			
	MessageInfo<List<DataEventYearInfo>> getListByRoundId(Integer roundId);
			
	MessageInfo<List<DataEventYearInfo>> getListByYear(Integer[] years);
		

}