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
import com.gi.xm.platform.view.InvestfirmsInfo;
import com.gi.xm.platform.view.InvestfirmsQueryInfo;
import com.gi.xm.platform.facede.InvestfirmsFacede;

@Controller
@RequestMapping("investfirms")
public class InvestfirmsController {

    @Reference
	private InvestfirmsFacede investfirmsFacede;

	@RequestMapping(value = "index", method = RequestMethod.GET)
	public ModelAndView index() {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		return new ModelAndView("investfirms/index", modelMap);
	}

	@RequestMapping("query")
	@ResponseBody
	public MessageInfo<QueryResultInfo<InvestfirmsInfo>>  queryInvestfirms (InvestfirmsQueryInfo investfirmsQueryInfo) {
		MessageInfo<QueryResultInfo<InvestfirmsInfo>> resultMessageInfo = investfirmsFacede.queryInvestfirms(investfirmsQueryInfo);
		return resultMessageInfo;
	}

    @RequestMapping("create")
    @ResponseBody
    public MessageInfo<Long> createInvestfirms(InvestfirmsInfo investfirmsInfo){
        MessageInfo<Long> messageInfo =  investfirmsFacede.createInvestfirms(investfirmsInfo);
        return messageInfo;
    }

    @RequestMapping("update")
    @ResponseBody
	public MessageInfo<Integer> updateInvestfirms(InvestfirmsInfo investfirmsInfo){
		MessageInfo<Integer> messageInfo =  investfirmsFacede.updateInvestfirms(investfirmsInfo);
		return messageInfo;
	}

    @RequestMapping("get")
    @ResponseBody
	public MessageInfo<InvestfirmsInfo> getInvestfirms( Long id ){
		MessageInfo<InvestfirmsInfo> messageInfo =  investfirmsFacede.getInvestfirms(id);
		return messageInfo;
	}

    @RequestMapping("getAll")
    @ResponseBody
    public MessageInfo<List<InvestfirmsInfo>> getAllInvestfirms(){
		MessageInfo<List<InvestfirmsInfo>>  messageInfo = investfirmsFacede.getAllInvestfirms();
		return messageInfo;
	}


		
    @RequestMapping("getListBySourceId")
    @ResponseBody
	public MessageInfo<List<InvestfirmsInfo>> getListBySourceId(Long sourceId){
		MessageInfo<List<InvestfirmsInfo>> messageInfo = investfirmsFacede.getListBySourceId(sourceId);
		return messageInfo;
	}
		
}
