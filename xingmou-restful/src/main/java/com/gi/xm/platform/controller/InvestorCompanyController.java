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
import com.gi.xm.platform.view.InvestorCompanyInfo;
import com.gi.xm.platform.view.InvestorCompanyQueryInfo;
import com.gi.xm.platform.facede.InvestorCompanyFacede;

@Controller
@RequestMapping("investorCompany")
public class InvestorCompanyController {

    @Reference
	private InvestorCompanyFacede investorCompanyFacede;

	@RequestMapping(value = "index", method = RequestMethod.GET)
	public ModelAndView index() {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		return new ModelAndView("investorCompany/index", modelMap);
	}

	@RequestMapping("query")
	@ResponseBody
	public MessageInfo<QueryResultInfo<InvestorCompanyInfo>>  queryInvestorCompany (InvestorCompanyQueryInfo investorCompanyQueryInfo) {
		MessageInfo<QueryResultInfo<InvestorCompanyInfo>> resultMessageInfo = investorCompanyFacede.queryInvestorCompany(investorCompanyQueryInfo);
		return resultMessageInfo;
	}

    @RequestMapping("create")
    @ResponseBody
    public MessageInfo<Long> createInvestorCompany(InvestorCompanyInfo investorCompanyInfo){
        MessageInfo<Long> messageInfo =  investorCompanyFacede.createInvestorCompany(investorCompanyInfo);
        return messageInfo;
    }

    @RequestMapping("update")
    @ResponseBody
	public MessageInfo<Integer> updateInvestorCompany(InvestorCompanyInfo investorCompanyInfo){
		MessageInfo<Integer> messageInfo =  investorCompanyFacede.updateInvestorCompany(investorCompanyInfo);
		return messageInfo;
	}

    @RequestMapping("get")
    @ResponseBody
	public MessageInfo<InvestorCompanyInfo> getInvestorCompany( Long id ){
		MessageInfo<InvestorCompanyInfo> messageInfo =  investorCompanyFacede.getInvestorCompany(id);
		return messageInfo;
	}

    @RequestMapping("getAll")
    @ResponseBody
    public MessageInfo<List<InvestorCompanyInfo>> getAllInvestorCompany(){
		MessageInfo<List<InvestorCompanyInfo>>  messageInfo = investorCompanyFacede.getAllInvestorCompany();
		return messageInfo;
	}


	
}
