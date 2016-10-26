package com.gi.xm.platform.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.report.biz.TargetIndustryHotBiz;
import com.gi.xm.report.pojo.TargetIndustryHot;
import com.gi.xm.report.query.TargetIndustryHotQueryInfo;

@Controller
@RequestMapping("targetIndustryHot")
public class TargetIndustryHotController {

    @Autowired
	private TargetIndustryHotBiz targetIndustryHotBiz;

	@RequestMapping(value = "index", method = RequestMethod.GET)
	public ModelAndView index() {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		return new ModelAndView("targetIndustryHot/index", modelMap);
	}

	@RequestMapping("query")
	@ResponseBody
	public MessageInfo  queryTargetIndustryHot (@RequestBody TargetIndustryHotQueryInfo targetIndustryHotQueryInfo) {
		MessageInfo<QueryResultInfo<TargetIndustryHot>> messageInfo =  targetIndustryHotBiz.queryTargetIndustryHot(targetIndustryHotQueryInfo);
		if(!messageInfo.isSuccess()){
			return messageInfo;
		}
		Integer pageIndex = targetIndustryHotQueryInfo.getPageIndex();
		Integer pageSize = targetIndustryHotQueryInfo.getPageSize();
		int rownum  = pageSize*(pageIndex-1)+1;
		List<TargetIndustryHot> data = messageInfo.getData().getRecords();
		if(data != null && data.size()>0){
			for(TargetIndustryHot t: data){
				t.setRownum(rownum++);
			}
		}
        return  messageInfo;
	}

		
    @RequestMapping("getListByIndustryLevel")
    @ResponseBody
	public MessageInfo getListByIndustryLevel(@RequestBody TargetIndustryHotQueryInfo targetIndustryHotQueryInfo){
    	if(targetIndustryHotQueryInfo == null || targetIndustryHotQueryInfo.getIndustryLevel() == null){
    		return new MessageInfo();
    	}
		MessageInfo<List<TargetIndustryHot>> messageInfo = targetIndustryHotBiz.getListByIndustryLevel(targetIndustryHotQueryInfo.getIndustryLevel());
		if(!messageInfo.isSuccess()){
			return messageInfo;
		}
		List<TargetIndustryHot> ls = messageInfo.getData();
        List<String> names = new ArrayList<String>();
        List<Integer> hotcounts =  new ArrayList<Integer>();
        Map<String,Object> data = new HashMap<String,Object>();
        MessageInfo  message = new MessageInfo();
        if(ls != null){
        	if(targetIndustryHotQueryInfo.getIndustryLevel().intValue()==2){
        		for(int i = 0; i< ls.size(); i++){
    	        	if(i<14){
    	        		names.add(ls.get(i).getIndustryName());
    	        		hotcounts.add(ls.get(i).getInvestHot());
    	        	}
    	        }
        	}else{
        		for(int i = 0; i< ls.size(); i++){
	        		names.add(ls.get(i).getIndustryName());
	        		hotcounts.add(ls.get(i).getInvestHot());
    	        }
        	}
	        
	        Map<String,Object> map = new HashMap<String,Object>();
	        data.put("hotcounts", hotcounts);
	        data.put("names", names);
	        message.setData(data);
        }
		return message;
	}
		
}
