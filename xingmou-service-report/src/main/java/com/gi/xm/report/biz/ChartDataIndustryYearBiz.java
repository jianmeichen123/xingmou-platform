

package com.gi.xm.report.biz;

import java.util.List;

import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.report.query.ChartDataIndustryYearQueryInfo;
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

	public MessageInfo<List<ChartDataIndustryYear>> getListByYaarIndustryId(Integer[] years, Integer industryId){

		MessageInfo<List<ChartDataIndustryYear>> messageInfo = new MessageInfo<List<ChartDataIndustryYear>>();
		try {
			List<ChartDataIndustryYear> chartDataIndustryYearList = chartDataIndustryYearDAO.selectByYaarIndustryId(years, industryId);
			messageInfo.setData(chartDataIndustryYearList);
		} catch (Exception e) {
			LOGGER.error("getListByYaarIndustryId","查询getListByYaarIndustryId失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}

	public MessageInfo<List<ChartDataIndustryYear>> getAll(Integer[] years){

		MessageInfo<List<ChartDataIndustryYear>> messageInfo = new MessageInfo<List<ChartDataIndustryYear>>();
		try {
			List<ChartDataIndustryYear> chartDataIndustryYearList = chartDataIndustryYearDAO.selectAll(years);
			messageInfo.setData(chartDataIndustryYearList);
		} catch (Exception e) {
			LOGGER.error("getAll","查询getAll失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}
	public MessageInfo<QueryResultInfo<ChartDataIndustryYear>> queryChartDataIndustryYear(ChartDataIndustryYearQueryInfo chartDataIndustryYearQueryInfo) {
		MessageInfo<QueryResultInfo<ChartDataIndustryYear>> message = new MessageInfo<QueryResultInfo<ChartDataIndustryYear>>();
		try {
			QueryResultInfo<ChartDataIndustryYear> queryResult = new QueryResultInfo<ChartDataIndustryYear>();
			PageHelper.startPage(chartDataIndustryYearQueryInfo.getPageIndex(), chartDataIndustryYearQueryInfo.getPageSize());
			List<ChartDataIndustryYear> chartDataIndustryYearList = chartDataIndustryYearDAO.queryChartDataIndustryYear(chartDataIndustryYearQueryInfo);
			PageInfo<ChartDataIndustryYear> pageInfo = new PageInfo<ChartDataIndustryYear>(chartDataIndustryYearList);
			queryResult.setPages(pageInfo.getPages());
			queryResult.setTotal(pageInfo.getTotal());
			queryResult.setRecords(chartDataIndustryYearList);
			message.setData(queryResult);
		} catch (Exception e) {
			LOGGER.error("queryChartDataIndustryYear", "分页查询ChartDataIndustryYear失败", e);
			message.setStatus(10001);
		}
		return message;
	}


}