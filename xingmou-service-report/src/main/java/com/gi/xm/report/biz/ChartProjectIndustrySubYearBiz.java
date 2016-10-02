

package com.gi.xm.report.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.gi.xm.report.dao.ChartProjectIndustrySubYearDAO;

import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.report.pojo.ChartProjectIndustrySubYear;

@Service("chartProjectIndustrySubYearBiz")
public class ChartProjectIndustrySubYearBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(ChartProjectIndustrySubYearBiz.class);

    @Autowired
	ChartProjectIndustrySubYearDAO chartProjectIndustrySubYearDAO;



    public MessageInfo<Long> createChartProjectIndustrySubYear(ChartProjectIndustrySubYear chartProjectIndustrySubYear){
		MessageInfo<Long> messageInfo = new MessageInfo<Long>();
		try {
						        				        				        							chartProjectIndustrySubYearDAO.insert( chartProjectIndustrySubYear );
			messageInfo.setData(chartProjectIndustrySubYear.getId());

		} catch (Exception e) {
			LOGGER.error("createChartProjectIndustrySubYear","创建ChartProjectIndustrySubYear失败", e);
			messageInfo.setStatus(10001);;
		}
		return messageInfo;
	}


	public MessageInfo<List<ChartProjectIndustrySubYear>> getListByYear(Integer[] years,Integer industryId){

		MessageInfo<List<ChartProjectIndustrySubYear>> messageInfo = new MessageInfo<List<ChartProjectIndustrySubYear>>();
		try {
			List<ChartProjectIndustrySubYear> chartProjectIndustrySubYearList = chartProjectIndustrySubYearDAO.selectByYearIndustryId(years,industryId);
			messageInfo.setData(chartProjectIndustrySubYearList);
		} catch (Exception e) {
			LOGGER.error("getListByYear","查询ChartProjectIndustrySubYear失败", e);
			messageInfo.setStatus(10001);;
		}
		return messageInfo;
	}
		

}