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
import com.gi.xm.platform.view.IndustryDataHalfYearInfo;
import com.gi.xm.platform.view.IndustryDataHalfYearQueryInfo;
import com.gi.xm.platform.facede.IndustryDataHalfYearFacede;

@Controller
@RequestMapping("industryDataHalfYear")
public class IndustryDataHalfYearController {

    @Reference
	private IndustryDataHalfYearFacede industryDataHalfYearFacede;


	@RequestMapping("query")
	@ResponseBody
	public MessageInfo<QueryResultInfo<IndustryDataHalfYearInfo>>  queryIndustryDataHalfYear (IndustryDataHalfYearQueryInfo industryDataHalfYearQueryInfo) {
		MessageInfo<QueryResultInfo<IndustryDataHalfYearInfo>> resultMessageInfo = industryDataHalfYearFacede.queryIndustryDataHalfYear(industryDataHalfYearQueryInfo);
		return resultMessageInfo;
	}
/*

    @RequestMapping("create")
    @ResponseBody
    public MessageInfo<Long> createIndustryDataHalfYear(IndustryDataHalfYearInfo industryDataHalfYearInfo){
        MessageInfo<Long> messageInfo =  industryDataHalfYearFacede.createIndustryDataHalfYear(industryDataHalfYearInfo);
        return messageInfo;
    }

    @RequestMapping("update")
    @ResponseBody
	public MessageInfo<Integer> updateIndustryDataHalfYear(IndustryDataHalfYearInfo industryDataHalfYearInfo){
		MessageInfo<Integer> messageInfo =  industryDataHalfYearFacede.updateIndustryDataHalfYear(industryDataHalfYearInfo);
		return messageInfo;
	}
*/

    @RequestMapping("get")
    @ResponseBody
	public MessageInfo<IndustryDataHalfYearInfo> getIndustryDataHalfYear( Long id ){
		MessageInfo<IndustryDataHalfYearInfo> messageInfo =  industryDataHalfYearFacede.getIndustryDataHalfYear(id);
		return messageInfo;
	}
/*

    @RequestMapping("getAll")
    @ResponseBody
    public MessageInfo<List<IndustryDataHalfYearInfo>> getAllIndustryDataHalfYear(){
		MessageInfo<List<IndustryDataHalfYearInfo>>  messageInfo = industryDataHalfYearFacede.getAllIndustryDataHalfYear();
		return messageInfo;
	}
*/


		
    @RequestMapping("getListByIndustryIdYaar")
    @ResponseBody
	public MessageInfo<List<IndustryDataHalfYearInfo>> getListByIndustryIdYaar(Integer industryId, Integer yaar){
		MessageInfo<List<IndustryDataHalfYearInfo>> messageInfo = industryDataHalfYearFacede.getListByIndustryIdYaar(industryId, yaar);
		return messageInfo;
	}
			
    @RequestMapping("getListByYaarIndustrySubId")
    @ResponseBody
	public MessageInfo<List<IndustryDataHalfYearInfo>> getListByYaarIndustrySubId(Integer yaar, Integer industrySubId){
		MessageInfo<List<IndustryDataHalfYearInfo>> messageInfo = industryDataHalfYearFacede.getListByYaarIndustrySubId(yaar, industrySubId);
		return messageInfo;
	}
			
    @RequestMapping("getListByIndustryId")
    @ResponseBody
	public MessageInfo<List<IndustryDataHalfYearInfo>> getListByIndustryId(Integer industryId){
		MessageInfo<List<IndustryDataHalfYearInfo>> messageInfo = industryDataHalfYearFacede.getListByIndustryId(industryId);
		return messageInfo;
	}
			
    @RequestMapping("getListByYaar")
    @ResponseBody
	public MessageInfo<List<IndustryDataHalfYearInfo>> getListByYaar(Integer yaar){
		MessageInfo<List<IndustryDataHalfYearInfo>> messageInfo = industryDataHalfYearFacede.getListByYaar(yaar);
		return messageInfo;
	}
		
}
