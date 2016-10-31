

package com.gi.xm.report.biz;

import java.util.List;

import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.report.pojo.ChartEventIndustryRoundMerge;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.gi.xm.report.dao.ChartEventIndustryRoundMergeDAO;


@Service("chartEventIndustryRoundMergeBiz")
public class ChartEventIndustryRoundMergeBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(ChartEventIndustryRoundMergeBiz.class);

    @Autowired
	ChartEventIndustryRoundMergeDAO chartEventIndustryRoundMergeDAO;



	public MessageInfo<QueryResultInfo<ChartEventIndustryRoundMerge>> queryChartEventIndustryRoundMerge(ChartEventIndustryRoundMerge chartEventIndustryRoundMergeQuery) {
		MessageInfo<QueryResultInfo<ChartEventIndustryRoundMerge>> message = new MessageInfo<QueryResultInfo<ChartEventIndustryRoundMerge>>();
		try {
			QueryResultInfo<ChartEventIndustryRoundMerge> queryResult = new QueryResultInfo<ChartEventIndustryRoundMerge>();
			PageHelper.startPage(chartEventIndustryRoundMergeQuery.getPageIndex(), chartEventIndustryRoundMergeQuery.getPageSize());
			List<ChartEventIndustryRoundMerge> investfirmsDataList = chartEventIndustryRoundMergeDAO.queryChartEventIndustryRoundMerge(chartEventIndustryRoundMergeQuery);
			PageInfo<ChartEventIndustryRoundMerge> pageInfo = new PageInfo<ChartEventIndustryRoundMerge>(investfirmsDataList);
			queryResult.setPages(pageInfo.getPages());
			queryResult.setTotal(pageInfo.getTotal());
			queryResult.setRecords(investfirmsDataList);
			message.setData(queryResult);
		} catch (Exception e) {
			LOGGER.error("queryChartEventIndustryRoundMerge", "queryChartEventIndustryRoundMerge", e);
			message.setStatus(10001);
		}
		return message;
	}

	/**
	 * ͼ�����
	 * @param chartEventIndustryRoundMergeQuery
	 * @return
     */
	public  MessageInfo<List<ChartEventIndustryRoundMerge>>chartAnalysis(ChartEventIndustryRoundMerge chartEventIndustryRoundMergeQuery ){
		MessageInfo<List<ChartEventIndustryRoundMerge>> messageInfo = new MessageInfo<List<ChartEventIndustryRoundMerge>>();
		try {
			List<ChartEventIndustryRoundMerge> chartEventIndustryRoundMergeQueryList = chartEventIndustryRoundMergeDAO.chartAnalysis(chartEventIndustryRoundMergeQuery);
			messageInfo.setData(chartEventIndustryRoundMergeQueryList);
		} catch (Exception e) {
			LOGGER.error("chartAnalysis","chartAnalysis", e);
			messageInfo.setStatus(10001);;
		}
		return messageInfo;

	}


	public MessageInfo<QueryResultInfo<ChartEventIndustryRoundMerge>> chartAnalysis1(ChartEventIndustryRoundMerge chartEventIndustryRoundMergeQuery) {
		MessageInfo<QueryResultInfo<ChartEventIndustryRoundMerge>> message = new MessageInfo<QueryResultInfo<ChartEventIndustryRoundMerge>>();
		try {
			QueryResultInfo<ChartEventIndustryRoundMerge> queryResult = new QueryResultInfo<ChartEventIndustryRoundMerge>();
			List<ChartEventIndustryRoundMerge> investfirmsDataList = chartEventIndustryRoundMergeDAO.chartAnalysis(chartEventIndustryRoundMergeQuery);

			queryResult.setPages(1);
			queryResult.setTotal(100L);
			queryResult.setRecords(investfirmsDataList);
			message.setData(queryResult);
		} catch (Exception e) {
			LOGGER.error("chartAnalysis1", "chartAnalysis1 失败", e);
			message.setStatus(10001);
		}
		return message;
	}

}