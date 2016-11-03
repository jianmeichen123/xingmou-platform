/*
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
import com.gi.xm.platform.view.InvestorAreasInfo;
import com.gi.xm.platform.view.InvestorAreasQueryInfo;
import com.gi.xm.platform.facede.InvestorAreasFacede;

@Controller
@RequestMapping("investorAreas")
public class InvestorAreasController {

	@Reference(check = false)
	private InvestorAreasFacede investorAreasFacede;

	@RequestMapping("query")
	@ResponseBody
	public MessageInfo<QueryResultInfo<InvestorAreasInfo>>  queryInvestorAreas (InvestorAreasQueryInfo investorAreasQueryInfo) {
		MessageInfo<QueryResultInfo<InvestorAreasInfo>> resultMessageInfo = investorAreasFacede.queryInvestorAreas(investorAreasQueryInfo);
		return resultMessageInfo;
	}
*/
/*

    @RequestMapping("create")
    @ResponseBody
    public MessageInfo<Long> createInvestorAreas(InvestorAreasInfo investorAreasInfo){
        MessageInfo<Long> messageInfo =  investorAreasFacede.createInvestorAreas(investorAreasInfo);
        return messageInfo;
    }

    @RequestMapping("update")
    @ResponseBody
	public MessageInfo<Integer> updateInvestorAreas(InvestorAreasInfo investorAreasInfo){
		MessageInfo<Integer> messageInfo =  investorAreasFacede.updateInvestorAreas(investorAreasInfo);
		return messageInfo;
	}
*//*


    @RequestMapping("get")
    @ResponseBody
	public MessageInfo<InvestorAreasInfo> getInvestorAreas( Long id ){
		MessageInfo<InvestorAreasInfo> messageInfo =  investorAreasFacede.getInvestorAreas(id);
		return messageInfo;
	}

*/
/*
    @RequestMapping("getAll")
    @ResponseBody
    public MessageInfo<List<InvestorAreasInfo>> getAllInvestorAreas(){
		MessageInfo<List<InvestorAreasInfo>>  messageInfo = investorAreasFacede.getAllInvestorAreas();
		return messageInfo;
	}
*//*



	
}
*/
