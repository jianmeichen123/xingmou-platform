

package com.gi.xm.report.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.gi.xm.report.dao.ChartEventIndustryDistictYearDAO;

import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.report.pojo.ChartEventIndustryDistictYear;

@Service("chartEventIndustryDistictYearBiz")
public class ChartEventIndustryDistictYearBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(ChartEventIndustryDistictYearBiz.class);

    @Autowired
	ChartEventIndustryDistictYearDAO chartEventIndustryDistictYearDAO;



    public MessageInfo<Long> createChartEventIndustryDistictYear(ChartEventIndustryDistictYear chartEventIndustryDistictYear){
		MessageInfo<Long> messageInfo = new MessageInfo<Long>();
		try {
						        				        				        							chartEventIndustryDistictYearDAO.insert( chartEventIndustryDistictYear );
			messageInfo.setData(chartEventIndustryDistictYear.getId());

		} catch (Exception e) {
			LOGGER.error("createChartEventIndustryDistictYear","创建ChartEventIndustryDistictYear失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}

	/*
	public MessageInfo<List<ChartEventIndustryDistictYear>> getListByIndustryId(Integer industryId){

		MessageInfo<List<ChartEventIndustryDistictYear>> messageInfo = new MessageInfo<List<ChartEventIndustryDistictYear>>();
		try {
			List<ChartEventIndustryDistictYear> chartEventIndustryDistictYearList = chartEventIndustryDistictYearDAO.selectByIndustryId(industryId);
			messageInfo.setData(chartEventIndustryDistictYearList);
		} catch (Exception e) {
			LOGGER.error("getListByIndustryId","查询ChartEventIndustryDistictYear失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}
			
	public MessageInfo<List<ChartEventIndustryDistictYear>> getListByDistrictId(Integer districtId){

		MessageInfo<List<ChartEventIndustryDistictYear>> messageInfo = new MessageInfo<List<ChartEventIndustryDistictYear>>();
		try {
			List<ChartEventIndustryDistictYear> chartEventIndustryDistictYearList = chartEventIndustryDistictYearDAO.selectByDistrictId(districtId);
			messageInfo.setData(chartEventIndustryDistictYearList);
		} catch (Exception e) {
			LOGGER.error("getListByDistrictId","查询ChartEventIndustryDistictYear失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}
			*/

	public MessageInfo<List<ChartEventIndustryDistictYear>> selectByYearIndustryId(Integer[] years,Integer industryId){

		MessageInfo<List<ChartEventIndustryDistictYear>> messageInfo = new MessageInfo<List<ChartEventIndustryDistictYear>>();
		try {
			List<ChartEventIndustryDistictYear> chartEventIndustryDistictYearList = chartEventIndustryDistictYearDAO.selectByYearIndustryId(years, industryId);
			messageInfo.setData(chartEventIndustryDistictYearList);
		} catch (Exception e) {
			LOGGER.error("getListByYear","查询ChartEventIndustryDistictYear失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}
	
	public MessageInfo<List<ChartEventIndustryDistictYear>> selectDistrictTop10(){

		MessageInfo<List<ChartEventIndustryDistictYear>> messageInfo = new MessageInfo<List<ChartEventIndustryDistictYear>>();
		try {
			List<ChartEventIndustryDistictYear> chartEventIndustryDistictYearList = chartEventIndustryDistictYearDAO.selectDistrictTop10();
			messageInfo.setData(chartEventIndustryDistictYearList);
		} catch (Exception e) {
			LOGGER.error("selectDistrictTop10","查询ChartEventIndustryDistictYear失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}
	
		

}