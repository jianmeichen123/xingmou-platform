

package com.gi.xm.report.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.report.dao.ChartEventRoundYearDAO;
import com.gi.xm.report.pojo.ChartEventIndustryRoundYear;
import com.gi.xm.report.pojo.ChartEventRoundYear;

@Service("chartEventRoundYearBiz")
public class ChartEventRoundYearBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(ChartEventRoundYearBiz.class);

    @Autowired
	ChartEventRoundYearDAO chartEventRoundYearDAO;


	public MessageInfo<List<ChartEventRoundYear>> select() {
		MessageInfo<List<ChartEventRoundYear>> messageInfo = new MessageInfo<List<ChartEventRoundYear>>();
		try {
			List<ChartEventRoundYear> chartEventRoundYearList = chartEventRoundYearDAO.select();
			messageInfo.setData(chartEventRoundYearList);
		} catch (Exception e) {
			LOGGER.error("getListByYear","查询chartEventRoundYear失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}
		
	/**
	 * 投资事件轮次分布
	 * @return
	 */
	public MessageInfo<List<ChartEventRoundYear>> getListByRoundYear (){

		MessageInfo<List<ChartEventRoundYear>> messageInfo = new MessageInfo<List<ChartEventRoundYear>>();
		try {
			List<ChartEventRoundYear> chartEventIndustryRoundYearList = chartEventRoundYearDAO.selectByRoundYear();
			messageInfo.setData(chartEventIndustryRoundYearList);
		} catch (Exception e) {
			LOGGER.error("getListByRoundYear","查询ChartEventIndustryRoundYear失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}


	public MessageInfo<List<String>> getroundNames() {
		MessageInfo<List<String>> messageInfo = new MessageInfo<List<String>>();
		try {
			List<String> roundNames = chartEventRoundYearDAO.selectRoundNames();
			messageInfo.setData(roundNames);
		} catch (Exception e) {
			LOGGER.error("getroundNames","roundNames查询失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}


	public MessageInfo<List<Integer>> getYears() {
		MessageInfo<List<Integer>> messageInfo = new MessageInfo<List<Integer>>();
		try {
			List<Integer> years = chartEventRoundYearDAO.selectYears();
			messageInfo.setData(years);
		} catch (Exception e) {
			LOGGER.error("getYears","查询getYears失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}
	

}