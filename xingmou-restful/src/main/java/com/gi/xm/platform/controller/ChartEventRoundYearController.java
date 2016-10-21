package com.gi.xm.platform.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.report.biz.ChartEventRoundYearBiz;
import com.gi.xm.report.pojo.ChartEventRoundYear;

@Controller
@RequestMapping("chartEventRoundYear")
public class ChartEventRoundYearController {

	@Autowired
	private ChartEventRoundYearBiz chartEventRoundYearBiz;
    
    /**
     * 投资事件轮次分析 
     * @return
     */
	@RequestMapping("bar")
	@ResponseBody
	public MessageInfo bar() {
		MessageInfo<List<ChartEventRoundYear>> messageInfo = chartEventRoundYearBiz.getListByRoundYear();
        if (!messageInfo.isSuccess()){
            return messageInfo;
        }
        
        List<ChartEventRoundYear> ls = messageInfo.getData();
        MessageInfo message = new MessageInfo();
        if(ls != null){
        	List<String> roundNames = chartEventRoundYearBiz.getroundNames().getData();
        	List<Integer> years = chartEventRoundYearBiz.getYears().getData();
        	Map<String,Map<Integer,Integer>> data = new LinkedHashMap<String,Map<Integer,Integer>>();
        	for(String rn : roundNames){
        		Map<Integer,Integer> map  = new HashMap<Integer,Integer>();
        		for(Integer yr :years){
        			map.put(yr.intValue(), 0);
        		}
        		data.put(rn,map);
        	}
        	for(int i = 0; i< ls.size(); i++){
        		ChartEventRoundYear entity = ls.get(i);
        		for(String rn :roundNames){
        			if(rn.equals(entity.getRoundName())){
        				data.get(entity.getRoundName()).put(entity.getYear(),entity.getInvestedNum());
        			}
        		}
        		
        	}
        	message.setData(data);
        }
        return message;
        
	}
	
}