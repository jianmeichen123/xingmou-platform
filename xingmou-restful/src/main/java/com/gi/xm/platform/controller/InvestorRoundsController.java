package com.gi.xm.platform.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.dubbo.config.annotation.Reference;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.view.InvestorRoundsInfo;
import com.gi.xm.platform.view.InvestorRoundsQueryInfo;
import com.gi.xm.platform.facede.InvestorRoundsFacede;

@Controller
@RequestMapping("investorRounds")
public class InvestorRoundsController {

	@Reference(check = false)
	private InvestorRoundsFacede investorRoundsFacede;
/*
	@RequestMapping("query")
	@ResponseBody
	public MessageInfo<QueryResultInfo<InvestorRoundsInfo>>  queryInvestorRounds (InvestorRoundsQueryInfo investorRoundsQueryInfo) {
		MessageInfo<QueryResultInfo<InvestorRoundsInfo>> resultMessageInfo = investorRoundsFacede.queryInvestorRounds(investorRoundsQueryInfo);
		return resultMessageInfo;
	}


    @RequestMapping("create")
    @ResponseBody
    public MessageInfo<Long> createInvestorRounds(InvestorRoundsInfo investorRoundsInfo){
        MessageInfo<Long> messageInfo =  investorRoundsFacede.createInvestorRounds(investorRoundsInfo);
        return messageInfo;
    }

    @RequestMapping("update")
    @ResponseBody
	public MessageInfo<Integer> updateInvestorRounds(InvestorRoundsInfo investorRoundsInfo){
		MessageInfo<Integer> messageInfo =  investorRoundsFacede.updateInvestorRounds(investorRoundsInfo);
		return messageInfo;
	}
*/

    @RequestMapping("get")
    @ResponseBody
	@Cacheable(value = "investorRoundsInfo:id",keyGenerator = "api")
	public MessageInfo<InvestorRoundsInfo> getInvestorRounds( Long id ){
		MessageInfo<InvestorRoundsInfo> messageInfo =  investorRoundsFacede.getInvestorRounds(id);
		return messageInfo;
	}
/*

    @RequestMapping("getAll")
    @ResponseBody
    public MessageInfo<List<InvestorRoundsInfo>> getAllInvestorRounds(){
		MessageInfo<List<InvestorRoundsInfo>>  messageInfo = investorRoundsFacede.getAllInvestorRounds();
		return messageInfo;
	}
*/


	
}
