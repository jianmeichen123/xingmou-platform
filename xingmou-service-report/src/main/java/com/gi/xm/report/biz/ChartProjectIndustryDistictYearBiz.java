

package com.gi.xm.report.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.gi.xm.report.dao.ChartProjectIndustryDistictYearDAO;

import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.report.pojo.ChartProjectIndustryDistictYear;

@Service("chartProjectIndustryDistictYearBiz")
public class ChartProjectIndustryDistictYearBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(ChartProjectIndustryDistictYearBiz.class);

    @Autowired
	ChartProjectIndustryDistictYearDAO chartProjectIndustryDistictYearDAO;



    public MessageInfo<Long> createChartProjectIndustryDistictYear(ChartProjectIndustryDistictYear chartProjectIndustryDistictYear){
		MessageInfo<Long> messageInfo = new MessageInfo<Long>();
		try {
						        				        				        							chartProjectIndustryDistictYearDAO.insert( chartProjectIndustryDistictYear );
			messageInfo.setData(chartProjectIndustryDistictYear.getId());

		} catch (Exception e) {
			LOGGER.error("createChartProjectIndustryDistictYear","创建ChartProjectIndustryDistictYear失败", e);
			messageInfo.setStatus(10001);;
		}
		return messageInfo;
	}

		
	public MessageInfo<List<ChartProjectIndustryDistictYear>> getListByIndustryId(Integer industryId){

		MessageInfo<List<ChartProjectIndustryDistictYear>> messageInfo = new MessageInfo<List<ChartProjectIndustryDistictYear>>();
		try {
			List<ChartProjectIndustryDistictYear> chartProjectIndustryDistictYearList = chartProjectIndustryDistictYearDAO.selectByIndustryId(industryId);
			messageInfo.setData(chartProjectIndustryDistictYearList);
		} catch (Exception e) {
			LOGGER.error("getListByIndustryId","查询ChartProjectIndustryDistictYear失败", e);
			messageInfo.setStatus(10001);;
		}
		return messageInfo;
	}
			
	public MessageInfo<List<ChartProjectIndustryDistictYear>> getListByDistrictId(Integer districtId){

		MessageInfo<List<ChartProjectIndustryDistictYear>> messageInfo = new MessageInfo<List<ChartProjectIndustryDistictYear>>();
		try {
			List<ChartProjectIndustryDistictYear> chartProjectIndustryDistictYearList = chartProjectIndustryDistictYearDAO.selectByDistrictId(districtId);
			messageInfo.setData(chartProjectIndustryDistictYearList);
		} catch (Exception e) {
			LOGGER.error("getListByDistrictId","查询ChartProjectIndustryDistictYear失败", e);
			messageInfo.setStatus(10001);;
		}
		return messageInfo;
	}
			
	public MessageInfo<List<ChartProjectIndustryDistictYear>> getListByYear(Integer year){

		MessageInfo<List<ChartProjectIndustryDistictYear>> messageInfo = new MessageInfo<List<ChartProjectIndustryDistictYear>>();
		try {
			List<ChartProjectIndustryDistictYear> chartProjectIndustryDistictYearList = chartProjectIndustryDistictYearDAO.selectByYear(year);
			messageInfo.setData(chartProjectIndustryDistictYearList);
		} catch (Exception e) {
			LOGGER.error("getListByYear","查询ChartProjectIndustryDistictYear失败", e);
			messageInfo.setStatus(10001);;
		}
		return messageInfo;
	}
		

}