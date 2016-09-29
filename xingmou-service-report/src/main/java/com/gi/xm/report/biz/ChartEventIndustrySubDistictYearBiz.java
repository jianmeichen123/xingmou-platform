

package com.gi.xm.report.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.gi.xm.report.dao.ChartEventIndustrySubDistictYearDAO;

import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.report.pojo.ChartEventIndustrySubDistictYear;

@Service("chartEventIndustrySubDistictYearBiz")
public class ChartEventIndustrySubDistictYearBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(ChartEventIndustrySubDistictYearBiz.class);

    @Autowired
	ChartEventIndustrySubDistictYearDAO chartEventIndustrySubDistictYearDAO;



    public MessageInfo<Long> createChartEventIndustrySubDistictYear(ChartEventIndustrySubDistictYear chartEventIndustrySubDistictYear){
		MessageInfo<Long> messageInfo = new MessageInfo<Long>();
		try {
						        				        				        							chartEventIndustrySubDistictYearDAO.insert( chartEventIndustrySubDistictYear );
			messageInfo.setData(chartEventIndustrySubDistictYear.getId());

		} catch (Exception e) {
			LOGGER.error("createChartEventIndustrySubDistictYear","创建ChartEventIndustrySubDistictYear失败", e);
			messageInfo.setStatus(10001);;
		}
		return messageInfo;
	}

		
	public MessageInfo<List<ChartEventIndustrySubDistictYear>> getListByIndustryId(Integer industryId){

		MessageInfo<List<ChartEventIndustrySubDistictYear>> messageInfo = new MessageInfo<List<ChartEventIndustrySubDistictYear>>();
		try {
			List<ChartEventIndustrySubDistictYear> chartEventIndustrySubDistictYearList = chartEventIndustrySubDistictYearDAO.selectByIndustryId(industryId);
			messageInfo.setData(chartEventIndustrySubDistictYearList);
		} catch (Exception e) {
			LOGGER.error("getListByIndustryId","查询ChartEventIndustrySubDistictYear失败", e);
			messageInfo.setStatus(10001);;
		}
		return messageInfo;
	}
			
	public MessageInfo<List<ChartEventIndustrySubDistictYear>> getListByDistrictId(Integer districtId){

		MessageInfo<List<ChartEventIndustrySubDistictYear>> messageInfo = new MessageInfo<List<ChartEventIndustrySubDistictYear>>();
		try {
			List<ChartEventIndustrySubDistictYear> chartEventIndustrySubDistictYearList = chartEventIndustrySubDistictYearDAO.selectByDistrictId(districtId);
			messageInfo.setData(chartEventIndustrySubDistictYearList);
		} catch (Exception e) {
			LOGGER.error("getListByDistrictId","查询ChartEventIndustrySubDistictYear失败", e);
			messageInfo.setStatus(10001);;
		}
		return messageInfo;
	}
			
	public MessageInfo<List<ChartEventIndustrySubDistictYear>> getListByYear(Integer year){

		MessageInfo<List<ChartEventIndustrySubDistictYear>> messageInfo = new MessageInfo<List<ChartEventIndustrySubDistictYear>>();
		try {
			List<ChartEventIndustrySubDistictYear> chartEventIndustrySubDistictYearList = chartEventIndustrySubDistictYearDAO.selectByYear(year);
			messageInfo.setData(chartEventIndustrySubDistictYearList);
		} catch (Exception e) {
			LOGGER.error("getListByYear","查询ChartEventIndustrySubDistictYear失败", e);
			messageInfo.setStatus(10001);;
		}
		return messageInfo;
	}
		

}