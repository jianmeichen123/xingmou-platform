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
import com.gi.xm.platform.view.InvestfirmsInfo;
import com.gi.xm.platform.view.InvestfirmsQueryInfo;
import com.gi.xm.platform.facede.InvestfirmsFacede;

@Controller
@RequestMapping("investfirms")
public class InvestfirmsController {

	@Reference(check = false)
	private InvestfirmsFacede investfirmsFacede;

	

	@RequestMapping("query")
	@ResponseBody
	public MessageInfo<QueryResultInfo<InvestfirmsInfo>>  queryInvestfirms (InvestfirmsQueryInfo investfirmsQueryInfo) {
		MessageInfo<QueryResultInfo<InvestfirmsInfo>> resultMessageInfo = investfirmsFacede.queryInvestfirms(investfirmsQueryInfo);
		return resultMessageInfo;
	}

    @RequestMapping("get")
    @ResponseBody
	@Cacheable(value = "investfirmsInfo:id",keyGenerator = "api")
	public MessageInfo<InvestfirmsInfo> getInvestfirms( Long id ){
		MessageInfo<InvestfirmsInfo> messageInfo =  investfirmsFacede.getInvestfirms(id);
		return messageInfo;
	}

}
