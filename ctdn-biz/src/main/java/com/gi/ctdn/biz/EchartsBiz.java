package com.gi.ctdn.biz;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.gi.ctdn.dao.IndustryGroupDistrictDao;
import com.gi.ctdn.pojo.IndustryEcharsQuery;
import com.gi.ctdn.pojo.echars.IndustryGroupDistrictCXHTFX;
import com.gi.ctdn.pojo.echars.IndustryGroupDistrictRZBK;
import com.gi.ctdn.view.common.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import com.gi.ctdn.dao.IndustryMonthDao;
import com.gi.ctdn.dao.IndustryRoundMergerDao;
import com.gi.ctdn.pojo.EchartsData;
import com.gi.ctdn.pojo.IndustryMonth;
import com.gi.ctdn.pojo.IndustryRoundMerger;
import com.gi.ctdn.utils.Constants;
import com.gi.ctdn.view.common.MessageInfo;

import org.springframework.util.StringUtils;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

@Service("echartsBiz")
public class EchartsBiz {

	@Autowired
	private IndustryMonthDao industryMonthDao;
	
	@Autowired
	private IndustryRoundMergerDao industryRoundMergerDao;

	@Autowired
	private StringRedisTemplate redisTemplate;

	/**
	 * 高管首页----行业融资趋势
	 * @return
	 */
	public MessageInfo<EchartsData<IndustryMonth>> getIndustryMonthForEchart() {
		MessageInfo<EchartsData<IndustryMonth>> messageInfo = new MessageInfo<EchartsData<IndustryMonth>>();
		List<IndustryMonth> industryMonthList  = industryMonthDao.getIndustryMonthForEcharts();
		EchartsData<IndustryMonth> echartsData = new EchartsData<IndustryMonth>();
		List<String> xAxis = new ArrayList<String>();
		List<String> legend = new ArrayList<String>();
		int count = 0;
		for(IndustryMonth industryMonth : industryMonthList){
			if(count == 0){
				xAxis.addAll(Arrays.asList(industryMonth.getDateStr().split(",")));
				echartsData.setxAxis(xAxis);
			}
			legend.add(industryMonth.getIndustryName());
			industryMonth.setInvestedNumStrList(Arrays.asList(industryMonth.getInvestedNumStr().split(",")));
			industryMonth.setInvestedAmountStrList(Arrays.asList(industryMonth.getInvestedAmountStr().split(",")));
			count ++;
		}
		echartsData.setLegend(legend);
		echartsData.setSeries(industryMonthList);
		messageInfo.setData(echartsData);
		return messageInfo;
	}



    /**
     * 高管-融资对比
     * @return
     */
	public MessageInfo<EchartsData<IndustryRoundMerger>> getIndustryRoundMergerForEcharts() {
		MessageInfo<EchartsData<IndustryRoundMerger>>  messageInfo = new MessageInfo<EchartsData<IndustryRoundMerger>>();
		List<IndustryRoundMerger> industryRoundMergerList = industryRoundMergerDao.getIndustryRoundMergerForEcharts();
		EchartsData<IndustryRoundMerger> echartsData = new EchartsData<IndustryRoundMerger>();
		List<String> xAxis = new ArrayList<String>();
		List<String> legend = new ArrayList<String>();
		int count = 0;
		for(IndustryRoundMerger roundMerger : industryRoundMergerList){
			if(count == 0){
				xAxis.addAll(Arrays.asList(roundMerger.getIndustryNameStr().split(",")));
				echartsData.setxAxis(xAxis);
			}
			legend.add(roundMerger.getRoundName());
			roundMerger.setInvestedAmountList(Arrays.asList(roundMerger.getInvestedAmountStr().split(",")));
			roundMerger.setInvestedNumList(Arrays.asList(roundMerger.getInvestedNumStr().split(",")));
			count ++;
		}
		echartsData.setLegend(legend);
		echartsData.setSeries(industryRoundMergerList);
		messageInfo.setData(echartsData);
		return messageInfo;
	}


}
 