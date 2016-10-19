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
import com.gi.xm.platform.view.IndustryFirstDataYearInfo;
import com.gi.xm.platform.view.IndustryFirstDataYearQueryInfo;
import com.gi.xm.platform.facede.IndustryFirstDataYearFacede;

@Controller
@RequestMapping("industryFirstDataYear")
public class IndustryFirstDataYearController {

    @Reference
	private IndustryFirstDataYearFacede industryFirstDataYearFacede;


/*

    @RequestMapping("create")
    @ResponseBody
    public MessageInfo<Long> createIndustryFirstDataYear(IndustryFirstDataYearInfo industryFirstDataYearInfo){
        MessageInfo<Long> messageInfo =  industryFirstDataYearFacede.createIndustryFirstDataYear(industryFirstDataYearInfo);
        return messageInfo;
    }

    @RequestMapping("update")
    @ResponseBody
	public MessageInfo<Integer> updateIndustryFirstDataYear(IndustryFirstDataYearInfo industryFirstDataYearInfo){
		MessageInfo<Integer> messageInfo =  industryFirstDataYearFacede.updateIndustryFirstDataYear(industryFirstDataYearInfo);
		return messageInfo;
	}
*/

    @RequestMapping("get")
    @ResponseBody
	public MessageInfo<IndustryFirstDataYearInfo> getIndustryFirstDataYear( Long id ){
		MessageInfo<IndustryFirstDataYearInfo> messageInfo =  industryFirstDataYearFacede.getIndustryFirstDataYear(id);
		return messageInfo;
	}

    /*
    @RequestMapping("getAll")
    @ResponseBody
    public MessageInfo<List<IndustryFirstDataYearInfo>> getAllIndustryFirstDataYear(){
		MessageInfo<List<IndustryFirstDataYearInfo>>  messageInfo = industryFirstDataYearFacede.getAllIndustryFirstDataYear();
		return messageInfo;
	}
*/



    @RequestMapping("getListByIndustryId")
    @ResponseBody
	public MessageInfo<List<IndustryFirstDataYearInfo>> getListByIndustryId(Integer industryId){
		MessageInfo<List<IndustryFirstDataYearInfo>> messageInfo = industryFirstDataYearFacede.getListByIndustryId(industryId);
		return messageInfo;
	}
			

		
}
