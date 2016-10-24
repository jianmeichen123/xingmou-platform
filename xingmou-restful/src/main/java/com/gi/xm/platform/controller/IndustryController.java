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
import com.gi.xm.platform.view.IndustryInfo;
import com.gi.xm.platform.view.IndustryQueryInfo;
import com.gi.xm.platform.facede.IndustryFacede;

@Controller
@RequestMapping("industry")
public class IndustryController {

	@Reference(check = false)
	private IndustryFacede industryFacede;


	@RequestMapping("query")
	@ResponseBody
	public MessageInfo<QueryResultInfo<IndustryInfo>>  queryIndustry (IndustryQueryInfo industryQueryInfo) {
		MessageInfo<QueryResultInfo<IndustryInfo>> resultMessageInfo = industryFacede.queryIndustry(industryQueryInfo);
		return resultMessageInfo;
	}
/*

    @RequestMapping("create")
    @ResponseBody
    public MessageInfo<Integer> createIndustry(IndustryInfo industryInfo){
        MessageInfo<Integer> messageInfo =  industryFacede.createIndustry(industryInfo);
        return messageInfo;
    }

    @RequestMapping("update")
    @ResponseBody
	public MessageInfo<Integer> updateIndustry(IndustryInfo industryInfo){
		MessageInfo<Integer> messageInfo =  industryFacede.updateIndustry(industryInfo);
		return messageInfo;
	}
*/

    @RequestMapping("get")
    @ResponseBody
	public MessageInfo<IndustryInfo> getIndustry( Integer id ){
		MessageInfo<IndustryInfo> messageInfo =  industryFacede.getIndustry(id);
		return messageInfo;
	}

    @RequestMapping("getAll")
    @ResponseBody
    public MessageInfo<List<IndustryInfo>> getAllIndustry(){
		MessageInfo<List<IndustryInfo>>  messageInfo = industryFacede.getAllIndustry();
		return messageInfo;
	}

	@RequestMapping("getListByParentId")
	@ResponseBody
	public MessageInfo<List<IndustryInfo>> getListByParentId(Integer parentId){
		MessageInfo<List<IndustryInfo>> messageInfo = industryFacede.getListByParentId(parentId);
		return messageInfo;
	}
	
}
