package com.gi.xm.platform.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.dubbo.config.annotation.Reference;
import com.gi.xm.platform.facede.InvestEventsFacede;
import com.gi.xm.platform.view.InvestEventsInfo;
import com.gi.xm.platform.view.InvestEventsQueryInfo;
import com.gi.xm.platform.view.InvestfirmsQueryInfo;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;

@Controller
@RequestMapping("investEvents")
public class InvestEventsController {

	@Reference(check = false)
	private InvestEventsFacede investEventsFacede;

	@RequestMapping(value = "index", method = RequestMethod.GET)
	public ModelAndView index() {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		return new ModelAndView("investEvents/index", modelMap);
	}

	@RequestMapping("query")
	@ResponseBody
	public MessageInfo<QueryResultInfo<InvestEventsInfo>>  queryInvestEvents (InvestEventsQueryInfo investEventsQueryInfo) {
		MessageInfo<QueryResultInfo<InvestEventsInfo>> resultMessageInfo = investEventsFacede.queryInvestEvents(investEventsQueryInfo);
		return resultMessageInfo;
	}

    @RequestMapping("create")
    @ResponseBody
    public MessageInfo<Long> createInvestEvents(InvestEventsInfo investEventsInfo){
        MessageInfo<Long> messageInfo =  investEventsFacede.createInvestEvents(investEventsInfo);
        return messageInfo;
    }

    @RequestMapping("update")
    @ResponseBody
	public MessageInfo<Integer> updateInvestEvents(InvestEventsInfo investEventsInfo){
		MessageInfo<Integer> messageInfo =  investEventsFacede.updateInvestEvents(investEventsInfo);
		return messageInfo;
	}

    @RequestMapping("get")
    @ResponseBody
	public MessageInfo<InvestEventsInfo> getInvestEvents( Long id ){
		MessageInfo<InvestEventsInfo> messageInfo =  investEventsFacede.getInvestEvents(id);
		return messageInfo;
	}

    @RequestMapping("getAll")
    @ResponseBody
    public MessageInfo<List<InvestEventsInfo>> getAllInvestEvents(){
		MessageInfo<List<InvestEventsInfo>>  messageInfo = investEventsFacede.getAllInvestEvents();
		return messageInfo;
	}

    @RequestMapping("getEventByInvestfirmId")
	@ResponseBody
	public MessageInfo<QueryResultInfo<InvestEventsInfo>>  getEventByInvestfirmId (@RequestBody InvestfirmsQueryInfo investfirmsQueryInfo) {
		MessageInfo<QueryResultInfo<InvestEventsInfo>> resultMessageInfo = investEventsFacede.getEventByInvestfirmId(investfirmsQueryInfo);
		return resultMessageInfo;
	}



	@RequestMapping("getListByProjectId/{projectId}")
	@ResponseBody
	public MessageInfo<List<InvestEventsInfo>> getListByProjectId(@PathVariable("projectId") Long projectId){
		MessageInfo<List<InvestEventsInfo>> messageInfo = investEventsFacede.getListByProjectId(projectId);
		return messageInfo;
	}
}
