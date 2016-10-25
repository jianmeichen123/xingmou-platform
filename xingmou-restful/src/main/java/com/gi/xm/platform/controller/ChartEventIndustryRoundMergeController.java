package com.gi.xm.platform.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.dubbo.config.annotation.Reference;

import com.gi.xm.platform.view.IndustryDataYearInfo;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.view.common.StringUtils;
import com.gi.xm.report.biz.ChartDataIndustryFirstYearBiz;
import com.gi.xm.report.biz.ChartDataIndustryYearBiz;
import com.gi.xm.report.biz.ChartEventIndustryRoundMergeBiz;
import com.gi.xm.report.pojo.ChartDataIndustryFirstYear;
import com.gi.xm.report.pojo.ChartEventIndustryRoundMerge;
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
	private ChartDataIndustryYearBiz chartDataIndustryYearBiz;

	@Autowired
	private ChartDataIndustryFirstYearBiz chartDataIndustryFirstYearBiz;

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

	@RequestMapping("analysis/{year}/{industryId}")
	@ResponseBody
	public MessageInfo<List<ChartDataIndustryFirstYear>> analysis(
			@PathVariable("year") Integer[] years, @PathVariable("industryId") Integer industryId){

		//所有行业
		if (years != null  && org.springframework.util.StringUtils.isEmpty(industryId)){
			MessageInfo<List<ChartDataIndustryFirstYear>> messageInfo = chartDataIndustryFirstYearBiz.getListByIndustryIdYaar(years,0);
			return messageInfo;
		}else {
			//具体一级行业
			MessageInfo<List<ChartDataIndustryFirstYear>> messageInfo = chartDataIndustryYearBiz.getListByYaarIndustrySubId(years, industryId);
			return messageInfo;
		}
	}

}
