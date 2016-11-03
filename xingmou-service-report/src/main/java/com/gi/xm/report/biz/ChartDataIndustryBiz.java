

package com.gi.xm.report.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.gi.xm.report.dao.ChartDataIndustryDAO;

import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.report.pojo.ChartDataIndustry;

@Service("chartDataIndustryBiz")
public class ChartDataIndustryBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(ChartDataIndustryBiz.class);

    @Autowired
	ChartDataIndustryDAO chartDataIndustryDAO;
		

	public MessageInfo<List<ChartDataIndustry>> queryIndustryDistribution() {
		MessageInfo<List<ChartDataIndustry>> messageInfo = new MessageInfo<List<ChartDataIndustry>>();
		try {
			List<ChartDataIndustry> chartDataIndustryList = chartDataIndustryDAO.selectEchart();
			messageInfo.setData(chartDataIndustryList);
		} catch (Exception e) {
			LOGGER.error("queryIndustryDistribution","查询ChartDataIndustry失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}
			

}