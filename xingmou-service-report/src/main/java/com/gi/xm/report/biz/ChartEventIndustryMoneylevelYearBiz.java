

package com.gi.xm.report.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.gi.xm.report.dao.ChartEventIndustryMoneylevelYearDAO;

import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.report.pojo.ChartEventIndustryMoneylevelYear;

@Service("chartEventIndustryMoneylevelYearBiz")
public class ChartEventIndustryMoneylevelYearBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(ChartEventIndustryMoneylevelYearBiz.class);

    @Autowired
	ChartEventIndustryMoneylevelYearDAO chartEventIndustryMoneylevelYearDAO;



    public MessageInfo<Long> createChartEventIndustryMoneylevelYear(ChartEventIndustryMoneylevelYear chartEventIndustryMoneylevelYear){
		MessageInfo<Long> messageInfo = new MessageInfo<Long>();
		try {
						        				        				        							chartEventIndustryMoneylevelYearDAO.insert( chartEventIndustryMoneylevelYear );
			messageInfo.setData(chartEventIndustryMoneylevelYear.getId());

		} catch (Exception e) {
			LOGGER.error("createChartEventIndustryMoneylevelYear","创建ChartEventIndustryMoneylevelYear失败", e);
			messageInfo.setStatus(10001);;
		}
		return messageInfo;
	}

		
	public MessageInfo<List<ChartEventIndustryMoneylevelYear>> getListByIndustryId(Integer industryId){

		MessageInfo<List<ChartEventIndustryMoneylevelYear>> messageInfo = new MessageInfo<List<ChartEventIndustryMoneylevelYear>>();
		try {
			List<ChartEventIndustryMoneylevelYear> chartEventIndustryMoneylevelYearList = chartEventIndustryMoneylevelYearDAO.selectByIndustryId(industryId);
			messageInfo.setData(chartEventIndustryMoneylevelYearList);
		} catch (Exception e) {
			LOGGER.error("getListByIndustryId","查询ChartEventIndustryMoneylevelYear失败", e);
			messageInfo.setStatus(10001);;
		}
		return messageInfo;
	}
			
	public MessageInfo<List<ChartEventIndustryMoneylevelYear>> getListByMoneyLevelId(Integer moneyLevelId){

		MessageInfo<List<ChartEventIndustryMoneylevelYear>> messageInfo = new MessageInfo<List<ChartEventIndustryMoneylevelYear>>();
		try {
			List<ChartEventIndustryMoneylevelYear> chartEventIndustryMoneylevelYearList = chartEventIndustryMoneylevelYearDAO.selectByMoneyLevelId(moneyLevelId);
			messageInfo.setData(chartEventIndustryMoneylevelYearList);
		} catch (Exception e) {
			LOGGER.error("getListByMoneyLevelId","查询ChartEventIndustryMoneylevelYear失败", e);
			messageInfo.setStatus(10001);;
		}
		return messageInfo;
	}
			
	public MessageInfo<List<ChartEventIndustryMoneylevelYear>> getListByYear(Integer year){

		MessageInfo<List<ChartEventIndustryMoneylevelYear>> messageInfo = new MessageInfo<List<ChartEventIndustryMoneylevelYear>>();
		try {
			List<ChartEventIndustryMoneylevelYear> chartEventIndustryMoneylevelYearList = chartEventIndustryMoneylevelYearDAO.selectByYear(year);
			messageInfo.setData(chartEventIndustryMoneylevelYearList);
		} catch (Exception e) {
			LOGGER.error("getListByYear","查询ChartEventIndustryMoneylevelYear失败", e);
			messageInfo.setStatus(10001);;
		}
		return messageInfo;
	}
		

}