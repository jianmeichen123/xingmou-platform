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
import com.gi.xm.platform.view.InvestorStudyInfo;
import com.gi.xm.platform.view.InvestorStudyQueryInfo;
import com.gi.xm.platform.facede.InvestorStudyFacede;

@Controller
@RequestMapping("investorStudy")
public class InvestorStudyController {

	@Reference(check = false)
	private InvestorStudyFacede investorStudyFacede;

/*
	@RequestMapping("query")
	@ResponseBody
	public MessageInfo<QueryResultInfo<InvestorStudyInfo>>  queryInvestorStudy (InvestorStudyQueryInfo investorStudyQueryInfo) {
		MessageInfo<QueryResultInfo<InvestorStudyInfo>> resultMessageInfo = investorStudyFacede.queryInvestorStudy(investorStudyQueryInfo);
		return resultMessageInfo;
	}


    @RequestMapping("create")
    @ResponseBody
    public MessageInfo<Long> createInvestorStudy(InvestorStudyInfo investorStudyInfo){
        MessageInfo<Long> messageInfo =  investorStudyFacede.createInvestorStudy(investorStudyInfo);
        return messageInfo;
    }

    @RequestMapping("update")
    @ResponseBody
	public MessageInfo<Integer> updateInvestorStudy(InvestorStudyInfo investorStudyInfo){
		MessageInfo<Integer> messageInfo =  investorStudyFacede.updateInvestorStudy(investorStudyInfo);
		return messageInfo;
	}
*/

/*
    @RequestMapping("get")
    @ResponseBody
	public MessageInfo<InvestorStudyInfo> getInvestorStudy( Long id ){
		MessageInfo<InvestorStudyInfo> messageInfo =  investorStudyFacede.getInvestorStudy(id);
		return messageInfo;
	}
*/

    @RequestMapping("getAll")
    @ResponseBody
    public MessageInfo<List<InvestorStudyInfo>> getAllInvestorStudy(){
		MessageInfo<List<InvestorStudyInfo>>  messageInfo = investorStudyFacede.getAllInvestorStudy();
		return messageInfo;
	}


	
}
