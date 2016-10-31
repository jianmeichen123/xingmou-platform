package com.gi.xm.platform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.config.annotation.Reference;
import com.gi.xm.platform.facede.CompanyFacede;
import com.gi.xm.platform.view.CompanyInfo;
import com.gi.xm.platform.view.CompanyQueryInfo;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;

@Controller
@RequestMapping("company")
public class CompanyController {

    @Reference
	private CompanyFacede companyFacede;


/*
	@RequestMapping("query")
	@ResponseBody
	public MessageInfo<QueryResultInfo<CompanyInfo>>  queryCompany (CompanyQueryInfo companyQueryInfo) {
		MessageInfo<QueryResultInfo<CompanyInfo>> resultMessageInfo = companyFacede.queryCompany(companyQueryInfo);
		return resultMessageInfo;
	}
*/

    @RequestMapping("get/{id}")
    @ResponseBody
	public MessageInfo<CompanyInfo> getCompany( @PathVariable Long id ){
		MessageInfo<CompanyInfo> messageInfo =  companyFacede.getCompany(id);
		return messageInfo;
	}

}
