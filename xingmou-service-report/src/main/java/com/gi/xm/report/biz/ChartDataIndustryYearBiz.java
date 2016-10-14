

package com.gi.xm.report.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.gi.xm.report.dao.ChartDataIndustryYearDAO;

import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.report.pojo.ChartDataIndustryYear;

@Service("chartDataIndustryYearBiz")
public class ChartDataIndustryYearBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(ChartDataIndustryYearBiz.class);

    @Autowired
	ChartDataIndustryYearDAO chartDataIndustryYearDAO;




	public MessageInfo<List<ChartDataIndustryYear>> getListByYaarIndustrySubId(Integer[] years, Integer industrySubId){

		MessageInfo<List<ChartDataIndustryYear>> messageInfo = new MessageInfo<List<ChartDataIndustryYear>>();
		try {
			List<ChartDataIndustryYear> chartDataIndustryYearList = chartDataIndustryYearDAO.selectByYaarIndustrySubId(years, industrySubId);
			messageInfo.setData(chartDataIndustryYearList);
		} catch (Exception e) {
			LOGGER.error("getListByYaarIndustrySubId","查询ChartDataIndustryYear失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}

}