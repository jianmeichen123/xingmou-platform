package com.gi.xm.platform.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

import com.alibaba.dubbo.config.annotation.Reference;

import com.gi.xm.platform.view.IndustryDataYearInfo;
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


	@RequestMapping("chartAnalysis1")
	@ResponseBody
	public MessageInfo<QueryResultInfo<ChartEventIndustryRoundMerge>> chartAnalysis1 (@RequestBody ChartEventIndustryRoundMerge chartEventIndustryRoundMerge) {

		MessageInfo<QueryResultInfo<ChartEventIndustryRoundMerge>> resultMessageInfo = chartEventIndustryRoundMergeBiz.chartAnalysis1(chartEventIndustryRoundMerge);
		List<ChartEventIndustryRoundMerge> list = resultMessageInfo.getData().getRecords();
		processMerge(list);
		resultMessageInfo.getData().setRecords(list);
		return resultMessageInfo;
	}
	@RequestMapping("chartAnalysis")
	@ResponseBody
	public  MessageInfo<List<ChartEventIndustryRoundMerge>>  chartAnalysis (@RequestBody ChartEventIndustryRoundMerge chartEventIndustryRoundMerge) {
		MessageInfo<List<ChartEventIndustryRoundMerge>> resultMessageInfo = chartEventIndustryRoundMergeBiz.chartAnalysis(chartEventIndustryRoundMerge);

		List<ChartEventIndustryRoundMerge> list = resultMessageInfo.getData();

		processMerge(list);
		resultMessageInfo.setData(list);
		QueryResultInfo info = new QueryResultInfo();
		info.setRecords(list);
		return resultMessageInfo;
	}

	private void processMerge(List<ChartEventIndustryRoundMerge> list) {
		List<Long> list1 = new ArrayList<Long>();
		List<Long> list2 = new ArrayList<Long>();
		Long[] array1 = new Long[2];
		Long[] array2 = new Long[2];
		Double [] rankA = new Double[10];
		Double [] rankB = new Double[5];

		for (ChartEventIndustryRoundMerge data:list) {

			list1.add(data.getInvestNumA().longValue());
			list1.add(data.getInvestNumB().longValue());
			list1.add(data.getInvestNumC().longValue());
			list1.add(data.getInvestNumD().longValue());
			list1.add(data.getInvestNumE().longValue());
			list1.add(data.getInvestNumF().longValue());
			list1.add(data.getInvestNumG().longValue());
			list1.add(data.getInvestNumH().longValue());
			list1.add(data.getInvestNumI().longValue());


			list2.add(data.getInvestMoneyA());
			list2.add(data.getInvestMoneyB());
			list2.add(data.getInvestMoneyC());
			list2.add(data.getInvestMoneyD());
			list2.add(data.getInvestMoneyE());
			list2.add(data.getInvestMoneyF());
			list2.add(data.getInvestMoneyG());
			list2.add(data.getInvestMoneyH());
			list2.add(data.getInvestMoneyI());





		}

		array1 = getMaxInteger(list1);


		array2 = getMaxInteger(list2);

		rankA[0] = array1[0].doubleValue();
		rankA[1] = rankA[0]  + (array1[1]-array1[0])/9.0;
		rankA[2] = rankA[1] + (array1[1]-array1[0])/9.0;
		rankA[3] = rankA[2] + (array1[1]-array1[0])/9.0;
		rankA[4] = rankA[3] + (array1[1]-array1[0])/9.0;
		rankA[5] = rankA[4] + (array1[1]-array1[0])/9.0;
		rankA[6] = rankA[5] + (array1[1]-array1[0])/9.0;
		rankA[7] = rankA[6] + (array1[1]-array1[0])/9.0;
		rankA[8] = rankA[7] + (array1[1]-array1[0])/9.0;
		rankA[9] = array1[1].doubleValue() ;

		rankB[0] = array2[0].doubleValue();
		rankB[1] = rankB[0]  + (array2[1]-array2[0])/4.0;
		rankB[2] = rankB[1] + (array2[1]-array2[0])/4.0;
		rankB[3] = rankB[2] + (array2[1]-array2[0])/4.0;
		rankB[4] = array2[1].doubleValue();


		for (ChartEventIndustryRoundMerge data:list) {



			Integer numALevel = getRank(rankA,data.getInvestNumA().longValue());
			Integer numBLevel = getRank(rankA,data.getInvestNumB().longValue());
			Integer numCLevel = getRank(rankA,data.getInvestNumC().longValue());
			Integer numDLevel = getRank(rankA,data.getInvestNumD().longValue());
			Integer numELevel = getRank(rankA,data.getInvestNumE().longValue());
			Integer numFLevel = getRank(rankA,data.getInvestNumF().longValue());
			Integer numGLevel = getRank(rankA,data.getInvestNumG().longValue());
			Integer numHLevel = getRank(rankA,data.getInvestNumH().longValue());
			Integer numILevel = getRank(rankA,data.getInvestNumI().longValue());

			Integer moneyALevel = getRank(rankB,data.getInvestMoneyA().longValue());
			Integer moneyBLevel = getRank(rankB,data.getInvestMoneyB().longValue());
			Integer moneyCLevel = getRank(rankB,data.getInvestMoneyC().longValue());
			Integer moneyDLevel = getRank(rankB,data.getInvestMoneyD().longValue());
			Integer moneyELevel = getRank(rankB,data.getInvestMoneyE().longValue());
			Integer moneyFLevel = getRank(rankB,data.getInvestMoneyF().longValue());
			Integer moneyGLevel = getRank(rankB,data.getInvestMoneyG().longValue());
			Integer moneyHLevel = getRank(rankB,data.getInvestMoneyH().longValue());
			Integer moneyILevel = getRank(rankB,data.getInvestMoneyI().longValue());


			data.setMoneyALevel(moneyALevel);
			data.setMoneyBLevel(moneyBLevel);
			data.setMoneyCLevel(moneyCLevel);
			data.setMoneyDLevel(moneyDLevel);
			data.setMoneyELevel(moneyELevel);
			data.setMoneyFLevel(moneyFLevel);
			data.setMoneyGLevel(moneyGLevel);
			data.setMoneyHLevel(moneyHLevel);
			data.setMoneyILevel(moneyILevel);

			data.setNumALevel(numALevel);
			data.setNumBLevel(numBLevel);
			data.setNumCLevel(numCLevel);
			data.setNumDLevel(numDLevel);
			data.setNumELevel(numELevel);
			data.setNumFLevel(numFLevel);
			data.setNumGLevel(numGLevel);
			data.setNumHLevel(numHLevel);
			data.setNumILevel(numILevel);






		}
	}

	@RequestMapping("chartDataYear/{years}/{industryId}")
	@ResponseBody
	public MessageInfo<List<ChartDataIndustryYear>> chartDataYear(@PathVariable("years") Integer[] years, @PathVariable("industryId") Integer industryId){
		MessageInfo<List<ChartDataIndustryYear>> messageInfo = null;
		//所有一级行业
		if (industryId==null ||industryId==0) {
			messageInfo = chartDataIndustryYearBiz.getAll(years);
		} else {
			//二级行业
			messageInfo = chartDataIndustryYearBiz.getListByYaarIndustryId(years,industryId);

		}



		return messageInfo;



	}

    private static int getRank(Double[] ranks,Long value) {
        int rt =ranks.length ;
		for (int i=0;i<ranks.length;i++) {

			if (value.doubleValue()<=ranks[i].doubleValue()) {
				rt=  i+1;
				break;
			}
		}

       return rt;
	}
	private  static Long[] getMaxInteger(List list){
		Long[] array = new Long[2];
		Long max = (Long)Collections.max(list);
		Long min = (Long)Collections.min(list);
		array[0] = min;

		array[1] = max;
		return  array;
	}
}
