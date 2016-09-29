

package com.gi.xm.report.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.gi.xm.report.dao.ChartProjectIndustrySubDistictYearDAO;

import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.report.pojo.ChartProjectIndustrySubDistictYear;

@Service("chartProjectIndustrySubDistictYearBiz")
public class ChartProjectIndustrySubDistictYearBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(ChartProjectIndustrySubDistictYearBiz.class);

    @Autowired
	ChartProjectIndustrySubDistictYearDAO chartProjectIndustrySubDistictYearDAO;



    public MessageInfo<Long> createChartProjectIndustrySubDistictYear(ChartProjectIndustrySubDistictYear chartProjectIndustrySubDistictYear){
		MessageInfo<Long> messageInfo = new MessageInfo<Long>();
		try {
						        				        				        							chartProjectIndustrySubDistictYearDAO.insert( chartProjectIndustrySubDistictYear );
			messageInfo.setData(chartProjectIndustrySubDistictYear.getId());

		} catch (Exception e) {
			LOGGER.error("createChartProjectIndustrySubDistictYear","创建ChartProjectIndustrySubDistictYear失败", e);
			messageInfo.setStatus(10001);;
		}
		return messageInfo;
	}

		
	public MessageInfo<List<ChartProjectIndustrySubDistictYear>> getListByIndustryId(Integer industryId){

		MessageInfo<List<ChartProjectIndustrySubDistictYear>> messageInfo = new MessageInfo<List<ChartProjectIndustrySubDistictYear>>();
		try {
			List<ChartProjectIndustrySubDistictYear> chartProjectIndustrySubDistictYearList = chartProjectIndustrySubDistictYearDAO.selectByIndustryId(industryId);
			messageInfo.setData(chartProjectIndustrySubDistictYearList);
		} catch (Exception e) {
			LOGGER.error("getListByIndustryId","查询ChartProjectIndustrySubDistictYear失败", e);
			messageInfo.setStatus(10001);;
		}
		return messageInfo;
	}
			
	public MessageInfo<List<ChartProjectIndustrySubDistictYear>> getListByDistrictId(Integer districtId){

		MessageInfo<List<ChartProjectIndustrySubDistictYear>> messageInfo = new MessageInfo<List<ChartProjectIndustrySubDistictYear>>();
		try {
			List<ChartProjectIndustrySubDistictYear> chartProjectIndustrySubDistictYearList = chartProjectIndustrySubDistictYearDAO.selectByDistrictId(districtId);
			messageInfo.setData(chartProjectIndustrySubDistictYearList);
		} catch (Exception e) {
			LOGGER.error("getListByDistrictId","查询ChartProjectIndustrySubDistictYear失败", e);
			messageInfo.setStatus(10001);;
		}
		return messageInfo;
	}
			
	public MessageInfo<List<ChartProjectIndustrySubDistictYear>> getListByYear(Integer year){

		MessageInfo<List<ChartProjectIndustrySubDistictYear>> messageInfo = new MessageInfo<List<ChartProjectIndustrySubDistictYear>>();
		try {
			List<ChartProjectIndustrySubDistictYear> chartProjectIndustrySubDistictYearList = chartProjectIndustrySubDistictYearDAO.selectByYear(year);
			messageInfo.setData(chartProjectIndustrySubDistictYearList);
		} catch (Exception e) {
			LOGGER.error("getListByYear","查询ChartProjectIndustrySubDistictYear失败", e);
			messageInfo.setStatus(10001);;
		}
		return messageInfo;
	}
		

}