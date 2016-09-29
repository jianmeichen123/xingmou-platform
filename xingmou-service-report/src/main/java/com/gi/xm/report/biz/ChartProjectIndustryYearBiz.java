

package com.gi.xm.report.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.gi.xm.report.dao.ChartProjectIndustryYearDAO;

import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.report.pojo.ChartProjectIndustryYear;

@Service("chartProjectIndustryYearBiz")
public class ChartProjectIndustryYearBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(ChartProjectIndustryYearBiz.class);

    @Autowired
	ChartProjectIndustryYearDAO chartProjectIndustryYearDAO;



    public MessageInfo<Long> createChartProjectIndustryYear(ChartProjectIndustryYear chartProjectIndustryYear){
		MessageInfo<Long> messageInfo = new MessageInfo<Long>();
		try {
						        				        							chartProjectIndustryYearDAO.insert( chartProjectIndustryYear );
			messageInfo.setData(chartProjectIndustryYear.getId());

		} catch (Exception e) {
			LOGGER.error("createChartProjectIndustryYear","创建ChartProjectIndustryYear失败", e);
			messageInfo.setStatus(10001);;
		}
		return messageInfo;
	}

		
	public MessageInfo<List<ChartProjectIndustryYear>> getListByIndustryId(Integer industryId){

		MessageInfo<List<ChartProjectIndustryYear>> messageInfo = new MessageInfo<List<ChartProjectIndustryYear>>();
		try {
			List<ChartProjectIndustryYear> chartProjectIndustryYearList = chartProjectIndustryYearDAO.selectByIndustryId(industryId);
			messageInfo.setData(chartProjectIndustryYearList);
		} catch (Exception e) {
			LOGGER.error("getListByIndustryId","查询ChartProjectIndustryYear失败", e);
			messageInfo.setStatus(10001);;
		}
		return messageInfo;
	}
			
	public MessageInfo<List<ChartProjectIndustryYear>> getListByYear(Integer year){

		MessageInfo<List<ChartProjectIndustryYear>> messageInfo = new MessageInfo<List<ChartProjectIndustryYear>>();
		try {
			List<ChartProjectIndustryYear> chartProjectIndustryYearList = chartProjectIndustryYearDAO.selectByYear(year);
			messageInfo.setData(chartProjectIndustryYearList);
		} catch (Exception e) {
			LOGGER.error("getListByYear","查询ChartProjectIndustryYear失败", e);
			messageInfo.setStatus(10001);;
		}
		return messageInfo;
	}
		

}