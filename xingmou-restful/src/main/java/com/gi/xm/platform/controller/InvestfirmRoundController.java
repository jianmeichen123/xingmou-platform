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
import com.gi.xm.platform.view.InvestfirmRoundInfo;
import com.gi.xm.platform.view.InvestfirmRoundQueryInfo;
import com.gi.xm.platform.facede.InvestfirmRoundFacede;

@Controller
@RequestMapping("investfirmRound")
public class InvestfirmRoundController {

	@Reference(check = false)
	private InvestfirmRoundFacede investfirmRoundFacede;

	@RequestMapping("query")
	@ResponseBody
	public MessageInfo<QueryResultInfo<InvestfirmRoundInfo>>  queryInvestfirmRound (InvestfirmRoundQueryInfo investfirmRoundQueryInfo) {
		MessageInfo<QueryResultInfo<InvestfirmRoundInfo>> resultMessageInfo = investfirmRoundFacede.queryInvestfirmRound(investfirmRoundQueryInfo);
		return resultMessageInfo;
	}
/*

    @RequestMapping("create")
    @ResponseBody
    public MessageInfo<Long> createInvestfirmRound(InvestfirmRoundInfo investfirmRoundInfo){
        MessageInfo<Long> messageInfo =  investfirmRoundFacede.createInvestfirmRound(investfirmRoundInfo);
        return messageInfo;
    }

    @RequestMapping("update")
    @ResponseBody
	public MessageInfo<Integer> updateInvestfirmRound(InvestfirmRoundInfo investfirmRoundInfo){
		MessageInfo<Integer> messageInfo =  investfirmRoundFacede.updateInvestfirmRound(investfirmRoundInfo);
		return messageInfo;
	}
*/

    @RequestMapping("get")
    @ResponseBody
	public MessageInfo<InvestfirmRoundInfo> getInvestfirmRound( Long id ){
		MessageInfo<InvestfirmRoundInfo> messageInfo =  investfirmRoundFacede.getInvestfirmRound(id);
		return messageInfo;
	}

		
    @RequestMapping("getListByInvestfrimId")
    @ResponseBody
	public MessageInfo<List<InvestfirmRoundInfo>> getListByInvestfrimId(Integer investfrimId){
		MessageInfo<List<InvestfirmRoundInfo>> messageInfo = investfirmRoundFacede.getListByInvestfrimId(investfrimId);
		return messageInfo;
	}
		
}
