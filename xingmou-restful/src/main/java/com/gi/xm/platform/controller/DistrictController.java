package com.gi.xm.platform.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.dubbo.config.annotation.Reference;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.view.DistrictInfo;
import com.gi.xm.platform.view.DistrictQueryInfo;
import com.gi.xm.platform.facede.DistrictFacede;

@Controller
@RequestMapping("district")
public class DistrictController {

	@Reference(check = false)
	private DistrictFacede districtFacede;

/*
	@RequestMapping("query")
	@ResponseBody
	public MessageInfo<QueryResultInfo<DistrictInfo>>  queryDistrict (DistrictQueryInfo districtQueryInfo) {
		MessageInfo<QueryResultInfo<DistrictInfo>> resultMessageInfo = districtFacede.queryDistrict(districtQueryInfo);
		return resultMessageInfo;
	}



    @RequestMapping("create")
    @ResponseBody
    public MessageInfo<Integer> createDistrict(DistrictInfo districtInfo){
        MessageInfo<Integer> messageInfo =  districtFacede.createDistrict(districtInfo);
        return messageInfo;
    }

    @RequestMapping("update")
    @ResponseBody
	public MessageInfo<Integer> updateDistrict(DistrictInfo districtInfo){
		MessageInfo<Integer> messageInfo =  districtFacede.updateDistrict(districtInfo);
		return messageInfo;
	}
*/


    @RequestMapping("getListByTypeLevel")
    @ResponseBody
	public MessageInfo<List<DistrictInfo>> getListByTypeLevel(Integer type, Integer level){
		MessageInfo<List<DistrictInfo>> messageInfo = districtFacede.getListByTypeLevel(type, level);
		return messageInfo;
	}
			
    @RequestMapping("getListByUpidDisplayorder")
    @ResponseBody
	public MessageInfo<List<DistrictInfo>> getListByUpidDisplayorder(Integer upid, Integer displayorder){
		MessageInfo<List<DistrictInfo>> messageInfo = districtFacede.getListByUpidDisplayorder(upid, displayorder);
		return messageInfo;
	}
		
}
