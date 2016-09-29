

package com.gi.xm.report.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.gi.xm.report.dao.ChartEventIndustrySubRoundYearDAO;

import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.report.pojo.ChartEventIndustrySubRoundYear;

@Service("chartEventIndustrySubRoundYearBiz")
public class ChartEventIndustrySubRoundYearBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(ChartEventIndustrySubRoundYearBiz.class);

    @Autowired
	ChartEventIndustrySubRoundYearDAO chartEventIndustrySubRoundYearDAO;



    public MessageInfo<Long> createChartEventIndustrySubRoundYear(ChartEventIndustrySubRoundYear chartEventIndustrySubRoundYear){
		MessageInfo<Long> messageInfo = new MessageInfo<Long>();
		try {
						        				        				        							chartEventIndustrySubRoundYearDAO.insert( chartEventIndustrySubRoundYear );
			messageInfo.setData(chartEventIndustrySubRoundYear.getId());

		} catch (Exception e) {
			LOGGER.error("createChartEventIndustrySubRoundYear","创建ChartEventIndustrySubRoundYear失败", e);
			messageInfo.setStatus(10001);;
		}
		return messageInfo;
	}

		
	public MessageInfo<List<ChartEventIndustrySubRoundYear>> getListByIndustryId(Integer industryId){

		MessageInfo<List<ChartEventIndustrySubRoundYear>> messageInfo = new MessageInfo<List<ChartEventIndustrySubRoundYear>>();
		try {
			List<ChartEventIndustrySubRoundYear> chartEventIndustrySubRoundYearList = chartEventIndustrySubRoundYearDAO.selectByIndustryId(industryId);
			messageInfo.setData(chartEventIndustrySubRoundYearList);
		} catch (Exception e) {
			LOGGER.error("getListByIndustryId","查询ChartEventIndustrySubRoundYear失败", e);
			messageInfo.setStatus(10001);;
		}
		return messageInfo;
	}
			
	public MessageInfo<List<ChartEventIndustrySubRoundYear>> getListByRoundId(Integer roundId){

		MessageInfo<List<ChartEventIndustrySubRoundYear>> messageInfo = new MessageInfo<List<ChartEventIndustrySubRoundYear>>();
		try {
			List<ChartEventIndustrySubRoundYear> chartEventIndustrySubRoundYearList = chartEventIndustrySubRoundYearDAO.selectByRoundId(roundId);
			messageInfo.setData(chartEventIndustrySubRoundYearList);
		} catch (Exception e) {
			LOGGER.error("getListByRoundId","查询ChartEventIndustrySubRoundYear失败", e);
			messageInfo.setStatus(10001);;
		}
		return messageInfo;
	}
			
	public MessageInfo<List<ChartEventIndustrySubRoundYear>> getListByYear(Integer year){

		MessageInfo<List<ChartEventIndustrySubRoundYear>> messageInfo = new MessageInfo<List<ChartEventIndustrySubRoundYear>>();
		try {
			List<ChartEventIndustrySubRoundYear> chartEventIndustrySubRoundYearList = chartEventIndustrySubRoundYearDAO.selectByYear(year);
			messageInfo.setData(chartEventIndustrySubRoundYearList);
		} catch (Exception e) {
			LOGGER.error("getListByYear","查询ChartEventIndustrySubRoundYear失败", e);
			messageInfo.setStatus(10001);;
		}
		return messageInfo;
	}
		

}