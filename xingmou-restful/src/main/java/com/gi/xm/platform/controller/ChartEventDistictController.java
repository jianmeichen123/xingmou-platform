package com.gi.xm.platform.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.config.annotation.Reference;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.report.biz.ChartEventIndustryDistictYearBiz;
import com.gi.xm.report.pojo.ChartEventIndustryDistictYear;
/**
 * 投资事件地区分布图
 * @author zhangchunyuan
 *
 */
@Controller
@RequestMapping("chartEventDistict")
public class ChartEventDistictController {

	@Autowired
	private ChartEventIndustryDistictYearBiz chartEventIndustryDistictYearBiz;


    /**
     * 事件地区分析的柱状图和饼图
     * @return
     */
    @RequestMapping("barAndpie")
    @ResponseBody
	@Cacheable(value = "barAndpie",keyGenerator = "reportKG")
	public MessageInfo barAndpie(){
		MessageInfo<List<ChartEventIndustryDistictYear>> messageInfo = chartEventIndustryDistictYearBiz.selectDistrictTop10();
        if (!messageInfo.isSuccess()){
            return messageInfo;
        }
        
        Map<String,Object> data = new HashMap<String,Object>();
        MessageInfo<Map<String,Object>> message = new  MessageInfo<Map<String,Object>>();
        List<ChartEventIndustryDistictYear> ls = messageInfo.getData();
        List<String> districtNames = new ArrayList<String>();
        List<Integer> counts =  new ArrayList<Integer>();
        List<Map<String,Object>> mls = new ArrayList<Map<String,Object>>();
        
        if(ls != null){
        	int c = 0 ;
	        for(int i = 0; i< ls.size(); i++){
	        	Map<String,Object> map = new HashMap<String,Object>();
	        	if(i<10){
	        		districtNames.add(ls.get(i).getDistrictName());
	        		counts.add(ls.get(i).getInvestedNum());
	        		map.put("name",ls.get(i).getDistrictName());
	        		map.put("value",ls.get(i).getInvestedNum());
	        		mls.add(map);
	        	}else{
	        		c += ls.get(i).getInvestedNum();
	        	}
	        }
	        Map<String,Object> map = new HashMap<String,Object>();
	        map.put("name","其他");
    		map.put("value",c);
    		mls.add(map);
    		
	        districtNames.add("其他");
        	counts.add(c);
	        data.put("count", counts);
	        data.put("name", districtNames);
	        data.put("map", mls);
	        message.setData(data);
        }
        
		return message;
	}
	
}
