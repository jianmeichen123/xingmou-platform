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
import com.gi.xm.platform.view.IndustryDataYearInfo;
import com.gi.xm.platform.view.IndustryDataYearQueryInfo;
import com.gi.xm.platform.facede.IndustryDataYearFacede;

@Controller
@RequestMapping("industryDataYear")
public class IndustryDataYearController {

	@Reference(check = false)
	private IndustryDataYearFacede industryDataYearFacede;

	@RequestMapping(value = "index", method = RequestMethod.GET)
	public ModelAndView index() {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		return new ModelAndView("industryDataYear/index", modelMap);
	}

	@RequestMapping("query")
	@ResponseBody
	public MessageInfo<QueryResultInfo<IndustryDataYearInfo>>  queryIndustryDataYear (IndustryDataYearQueryInfo industryDataYearQueryInfo) {
		MessageInfo<QueryResultInfo<IndustryDataYearInfo>> resultMessageInfo = industryDataYearFacede.queryIndustryDataYear(industryDataYearQueryInfo);
		return resultMessageInfo;
	}

    @RequestMapping("create")
    @ResponseBody
    public MessageInfo<Long> createIndustryDataYear(IndustryDataYearInfo industryDataYearInfo){
        MessageInfo<Long> messageInfo =  industryDataYearFacede.createIndustryDataYear(industryDataYearInfo);
        return messageInfo;
    }

    @RequestMapping("update")
    @ResponseBody
	public MessageInfo<Integer> updateIndustryDataYear(IndustryDataYearInfo industryDataYearInfo){
		MessageInfo<Integer> messageInfo =  industryDataYearFacede.updateIndustryDataYear(industryDataYearInfo);
		return messageInfo;
	}

    @RequestMapping("get")
    @ResponseBody
	public MessageInfo<IndustryDataYearInfo> getIndustryDataYear( Long id ){
		MessageInfo<IndustryDataYearInfo> messageInfo =  industryDataYearFacede.getIndustryDataYear(id);
		return messageInfo;
	}

    @RequestMapping("getAll")
    @ResponseBody
    public MessageInfo<List<IndustryDataYearInfo>> getAllIndustryDataYear(){
		MessageInfo<List<IndustryDataYearInfo>>  messageInfo = industryDataYearFacede.getAllIndustryDataYear();
		return messageInfo;
	}


		
    @RequestMapping("getListByIndustryIdYaar")
    @ResponseBody
	public MessageInfo<List<IndustryDataYearInfo>> getListByIndustryIdYaar(Integer industryId, Integer[] yaars){
		MessageInfo<List<IndustryDataYearInfo>> messageInfo = industryDataYearFacede.getListByIndustryIdYaar(industryId, yaars);
		return messageInfo;
	}
			
    @RequestMapping("getListByYaarIndustrySubId")
    @ResponseBody
	public MessageInfo<List<IndustryDataYearInfo>> getListByYaarIndustrySubId(Integer[] yaars, Integer industrySubId){
		MessageInfo<List<IndustryDataYearInfo>> messageInfo = industryDataYearFacede.getListByYaarIndustrySubId(yaars, industrySubId);
		return messageInfo;
	}
			
    @RequestMapping("getListByIndustryId")
    @ResponseBody
	public MessageInfo<List<IndustryDataYearInfo>> getListByIndustryId(Integer industryId){
		MessageInfo<List<IndustryDataYearInfo>> messageInfo = industryDataYearFacede.getListByIndustryId(industryId);
		return messageInfo;
	}
			
    @RequestMapping("getListByYaar")
    @ResponseBody
	public MessageInfo<List<IndustryDataYearInfo>> getListByYaar(Integer[] yaars){
		MessageInfo<List<IndustryDataYearInfo>> messageInfo = industryDataYearFacede.getListByYaar(yaars);
		return messageInfo;
	}
		
}
