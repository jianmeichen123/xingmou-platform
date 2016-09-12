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
import com.gi.xm.platform.view.InvestEventsInvestfirmInfo;
import com.gi.xm.platform.view.InvestEventsInvestfirmQueryInfo;
import com.gi.xm.platform.facede.InvestEventsInvestfirmFacede;

@Controller
@RequestMapping("investEventsInvestfirm")
public class InvestEventsInvestfirmController {

	@Reference(check = false)
	private InvestEventsInvestfirmFacede investEventsInvestfirmFacede;

	@RequestMapping(value = "index", method = RequestMethod.GET)
	public ModelAndView index() {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		return new ModelAndView("investEventsInvestfirm/index", modelMap);
	}

	@RequestMapping("query")
	@ResponseBody
	public MessageInfo<QueryResultInfo<InvestEventsInvestfirmInfo>>  queryInvestEventsInvestfirm (InvestEventsInvestfirmQueryInfo investEventsInvestfirmQueryInfo) {
		MessageInfo<QueryResultInfo<InvestEventsInvestfirmInfo>> resultMessageInfo = investEventsInvestfirmFacede.queryInvestEventsInvestfirm(investEventsInvestfirmQueryInfo);
		return resultMessageInfo;
	}

    @RequestMapping("create")
    @ResponseBody
    public MessageInfo<Long> createInvestEventsInvestfirm(InvestEventsInvestfirmInfo investEventsInvestfirmInfo){
        MessageInfo<Long> messageInfo =  investEventsInvestfirmFacede.createInvestEventsInvestfirm(investEventsInvestfirmInfo);
        return messageInfo;
    }

    @RequestMapping("update")
    @ResponseBody
	public MessageInfo<Integer> updateInvestEventsInvestfirm(InvestEventsInvestfirmInfo investEventsInvestfirmInfo){
		MessageInfo<Integer> messageInfo =  investEventsInvestfirmFacede.updateInvestEventsInvestfirm(investEventsInvestfirmInfo);
		return messageInfo;
	}

    @RequestMapping("get")
    @ResponseBody
	public MessageInfo<InvestEventsInvestfirmInfo> getInvestEventsInvestfirm( Long id ){
		MessageInfo<InvestEventsInvestfirmInfo> messageInfo =  investEventsInvestfirmFacede.getInvestEventsInvestfirm(id);
		return messageInfo;
	}

    @RequestMapping("getAll")
    @ResponseBody
    public MessageInfo<List<InvestEventsInvestfirmInfo>> getAllInvestEventsInvestfirm(){
		MessageInfo<List<InvestEventsInvestfirmInfo>>  messageInfo = investEventsInvestfirmFacede.getAllInvestEventsInvestfirm();
		return messageInfo;
	}


	
}
