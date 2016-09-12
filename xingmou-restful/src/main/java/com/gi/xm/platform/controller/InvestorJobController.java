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
import com.gi.xm.platform.view.InvestorJobInfo;
import com.gi.xm.platform.view.InvestorJobQueryInfo;
import com.gi.xm.platform.facede.InvestorJobFacede;

@Controller
@RequestMapping("investorJob")
public class InvestorJobController {

	@Reference(check = false)
	private InvestorJobFacede investorJobFacede;

	@RequestMapping(value = "index", method = RequestMethod.GET)
	public ModelAndView index() {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		return new ModelAndView("investorJob/index", modelMap);
	}

	@RequestMapping("query")
	@ResponseBody
	public MessageInfo<QueryResultInfo<InvestorJobInfo>>  queryInvestorJob (InvestorJobQueryInfo investorJobQueryInfo) {
		MessageInfo<QueryResultInfo<InvestorJobInfo>> resultMessageInfo = investorJobFacede.queryInvestorJob(investorJobQueryInfo);
		return resultMessageInfo;
	}

    @RequestMapping("create")
    @ResponseBody
    public MessageInfo<Long> createInvestorJob(InvestorJobInfo investorJobInfo){
        MessageInfo<Long> messageInfo =  investorJobFacede.createInvestorJob(investorJobInfo);
        return messageInfo;
    }

    @RequestMapping("update")
    @ResponseBody
	public MessageInfo<Integer> updateInvestorJob(InvestorJobInfo investorJobInfo){
		MessageInfo<Integer> messageInfo =  investorJobFacede.updateInvestorJob(investorJobInfo);
		return messageInfo;
	}

    @RequestMapping("get")
    @ResponseBody
	public MessageInfo<InvestorJobInfo> getInvestorJob( Long id ){
		MessageInfo<InvestorJobInfo> messageInfo =  investorJobFacede.getInvestorJob(id);
		return messageInfo;
	}

    @RequestMapping("getAll")
    @ResponseBody
    public MessageInfo<List<InvestorJobInfo>> getAllInvestorJob(){
		MessageInfo<List<InvestorJobInfo>>  messageInfo = investorJobFacede.getAllInvestorJob();
		return messageInfo;
	}


	
}
