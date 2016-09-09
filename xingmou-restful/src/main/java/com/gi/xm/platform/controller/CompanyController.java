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
import com.gi.xm.platform.view.CompanyInfo;
import com.gi.xm.platform.view.CompanyQueryInfo;
import com.gi.xm.platform.facede.CompanyFacede;

@Controller
@RequestMapping("company")
public class CompanyController {

    @Reference
	private CompanyFacede companyFacede;

	@RequestMapping("query")
	@ResponseBody
	public MessageInfo<QueryResultInfo<CompanyInfo>>  queryCompany (CompanyQueryInfo companyQueryInfo) {
		MessageInfo<QueryResultInfo<CompanyInfo>> resultMessageInfo = companyFacede.queryCompany(companyQueryInfo);
		return resultMessageInfo;
	}

    @RequestMapping("create")
    @ResponseBody
    public MessageInfo<Long> createCompany(CompanyInfo companyInfo){
        MessageInfo<Long> messageInfo =  companyFacede.createCompany(companyInfo);
        return messageInfo;
    }

    @RequestMapping("update")
    @ResponseBody
	public MessageInfo<Integer> updateCompany(CompanyInfo companyInfo){
		MessageInfo<Integer> messageInfo =  companyFacede.updateCompany(companyInfo);
		return messageInfo;
	}

    @RequestMapping("get")
    @ResponseBody
	public MessageInfo<CompanyInfo> getCompany( Long id ){
		MessageInfo<CompanyInfo> messageInfo =  companyFacede.getCompany(id);
		return messageInfo;
	}

    @RequestMapping("getAll")
    @ResponseBody
    public MessageInfo<List<CompanyInfo>> getAllCompany(){
		MessageInfo<List<CompanyInfo>>  messageInfo = companyFacede.getAllCompany();
		return messageInfo;
	}


	
}
