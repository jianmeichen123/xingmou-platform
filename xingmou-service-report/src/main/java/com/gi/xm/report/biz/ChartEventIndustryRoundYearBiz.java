

package com.gi.xm.report.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.gi.xm.report.dao.ChartEventIndustryRoundYearDAO;

import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.report.pojo.ChartEventIndustryRoundYear;

@Service("chartEventIndustryRoundYearBiz")
public class ChartEventIndustryRoundYearBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(ChartEventIndustryRoundYearBiz.class);

    @Autowired
	ChartEventIndustryRoundYearDAO chartEventIndustryRoundYearDAO;



    public MessageInfo<Long> createChartEventIndustryRoundYear(ChartEventIndustryRoundYear chartEventIndustryRoundYear){
		MessageInfo<Long> messageInfo = new MessageInfo<Long>();
		try {
						        				        				        							chartEventIndustryRoundYearDAO.insert( chartEventIndustryRoundYear );
			messageInfo.setData(chartEventIndustryRoundYear.getId());

		} catch (Exception e) {
			LOGGER.error("createChartEventIndustryRoundYear","创建ChartEventIndustryRoundYear失败", e);
			messageInfo.setStatus(10001);;
		}
		return messageInfo;
	}

		
	public MessageInfo<List<ChartEventIndustryRoundYear>> getListByIndustryId(Integer industryId){

		MessageInfo<List<ChartEventIndustryRoundYear>> messageInfo = new MessageInfo<List<ChartEventIndustryRoundYear>>();
		try {
			List<ChartEventIndustryRoundYear> chartEventIndustryRoundYearList = chartEventIndustryRoundYearDAO.selectByIndustryId(industryId);
			messageInfo.setData(chartEventIndustryRoundYearList);
		} catch (Exception e) {
			LOGGER.error("getListByIndustryId","查询ChartEventIndustryRoundYear失败", e);
			messageInfo.setStatus(10001);;
		}
		return messageInfo;
	}
			
	public MessageInfo<List<ChartEventIndustryRoundYear>> getListByRoundId(Integer roundId){

		MessageInfo<List<ChartEventIndustryRoundYear>> messageInfo = new MessageInfo<List<ChartEventIndustryRoundYear>>();
		try {
			List<ChartEventIndustryRoundYear> chartEventIndustryRoundYearList = chartEventIndustryRoundYearDAO.selectByRoundId(roundId);
			messageInfo.setData(chartEventIndustryRoundYearList);
		} catch (Exception e) {
			LOGGER.error("getListByRoundId","查询ChartEventIndustryRoundYear失败", e);
			messageInfo.setStatus(10001);;
		}
		return messageInfo;
	}
			
	public MessageInfo<List<ChartEventIndustryRoundYear>> getListByYear(Integer year){

		MessageInfo<List<ChartEventIndustryRoundYear>> messageInfo = new MessageInfo<List<ChartEventIndustryRoundYear>>();
		try {
			List<ChartEventIndustryRoundYear> chartEventIndustryRoundYearList = chartEventIndustryRoundYearDAO.selectByYear(year);
			messageInfo.setData(chartEventIndustryRoundYearList);
		} catch (Exception e) {
			LOGGER.error("getListByYear","查询ChartEventIndustryRoundYear失败", e);
			messageInfo.setStatus(10001);;
		}
		return messageInfo;
	}
		

}