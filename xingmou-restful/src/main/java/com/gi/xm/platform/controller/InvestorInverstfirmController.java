package com.gi.xm.platform.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.dubbo.config.annotation.Reference;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.view.InvestorInverstfirmInfo;
import com.gi.xm.platform.view.InvestorInverstfirmQueryInfo;
import com.gi.xm.platform.facede.InvestorInverstfirmFacede;

@Controller
@RequestMapping("investorInverstfirm")
public class InvestorInverstfirmController {

    @Reference
	private InvestorInverstfirmFacede investorInverstfirmFacede;

	@RequestMapping("query")
	@ResponseBody
	public MessageInfo<QueryResultInfo<InvestorInverstfirmInfo>>  queryInvestorInverstfirm (InvestorInverstfirmQueryInfo investorInverstfirmQueryInfo) {
		MessageInfo<QueryResultInfo<InvestorInverstfirmInfo>> resultMessageInfo = investorInverstfirmFacede.queryInvestorInverstfirm(investorInverstfirmQueryInfo);
		return resultMessageInfo;
	}

    @RequestMapping("create")
    @ResponseBody
    public MessageInfo<Long> createInvestorInverstfirm(InvestorInverstfirmInfo investorInverstfirmInfo){
        MessageInfo<Long> messageInfo =  investorInverstfirmFacede.createInvestorInverstfirm(investorInverstfirmInfo);
        return messageInfo;
    }

    @RequestMapping("update")
    @ResponseBody
	public MessageInfo<Integer> updateInvestorInverstfirm(InvestorInverstfirmInfo investorInverstfirmInfo){
		MessageInfo<Integer> messageInfo =  investorInverstfirmFacede.updateInvestorInverstfirm(investorInverstfirmInfo);
		return messageInfo;
	}

    @RequestMapping("get")
    @ResponseBody
	public MessageInfo<InvestorInverstfirmInfo> getInvestorInverstfirm( Long id ){
		MessageInfo<InvestorInverstfirmInfo> messageInfo =  investorInverstfirmFacede.getInvestorInverstfirm(id);
		return messageInfo;
	}

    @RequestMapping("getAll")
    @ResponseBody
    public MessageInfo<List<InvestorInverstfirmInfo>> getAllInvestorInverstfirm(){
		MessageInfo<List<InvestorInverstfirmInfo>>  messageInfo = investorInverstfirmFacede.getAllInvestorInverstfirm();
		return messageInfo;
	}


	
}
