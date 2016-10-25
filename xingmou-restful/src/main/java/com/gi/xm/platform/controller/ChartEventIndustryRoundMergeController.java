package com.gi.xm.platform.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.dubbo.config.annotation.Reference;

import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.report.biz.ChartDataIndustryFirstYearBiz;
import com.gi.xm.report.biz.ChartDataIndustryYearBiz;
import com.gi.xm.report.biz.ChartEventIndustryRoundMergeBiz;
import com.gi.xm.report.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("chartEventIndustryRoundMerge")
public class ChartEventIndustryRoundMergeController {


	@Autowired
	private ChartEventIndustryRoundMergeBiz chartEventIndustryRoundMergeBiz;
	@Autowired
	private ChartDataIndustryFirstYearBiz chartDataIndustryFirstYearBiz;

	@Autowired
	private ChartDataIndustryYearBiz chartDataIndustryYearBiz;

	@RequestMapping("search")
	@ResponseBody
	public MessageInfo<QueryResultInfo<ChartEventIndustryRoundMerge>> queryInvestfirms (@RequestBody ChartEventIndustryRoundMerge chartEventIndustryRoundMerge) {

		MessageInfo<QueryResultInfo<ChartEventIndustryRoundMerge>> resultMessageInfo = chartEventIndustryRoundMergeBiz.queryChartEventIndustryRoundMerge(chartEventIndustryRoundMerge);

		return resultMessageInfo;
	}
	@RequestMapping("chartAnalysis")
	@ResponseBody
	public  MessageInfo<List<ChartEventIndustryRoundMerge>>  chartAnalysis (@RequestBody ChartEventIndustryRoundMerge chartEventIndustryRoundMerge) {
		MessageInfo<List<ChartEventIndustryRoundMerge>> resultMessageInfo = chartEventIndustryRoundMergeBiz.chartAnalysis(chartEventIndustryRoundMerge);
		return resultMessageInfo;
	}
	@RequestMapping("chartDataYear/{years}/{industryId}")
	@ResponseBody
	public MessageInfo chartDataYear(@PathVariable("years") Integer[] years, @PathVariable("industryId") Integer industryId){

		//所有一级行业
		if (industryId==null) {

		} else {
			//二级行业
		}


		return null;



	}
	
}
