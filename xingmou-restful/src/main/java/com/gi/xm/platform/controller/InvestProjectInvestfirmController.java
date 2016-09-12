package com.gi.xm.platform.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.dubbo.config.annotation.Reference;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.view.InvestProjectInvestfirmInfo;
import com.gi.xm.platform.view.InvestProjectInvestfirmQueryInfo;
import com.gi.xm.platform.facede.InvestProjectInvestfirmFacede;

@Controller
@RequestMapping("investProjectInvestfirm")
public class InvestProjectInvestfirmController {

	@Reference(check = false)
	private InvestProjectInvestfirmFacede investProjectInvestfirmFacede;

	@RequestMapping(value = "index", method = RequestMethod.GET)
	public ModelAndView index() {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		return new ModelAndView("investProjectInvestfirm/index", modelMap);
	}

	@RequestMapping("query")
	@ResponseBody
	public MessageInfo<QueryResultInfo<InvestProjectInvestfirmInfo>>  queryInvestProjectInvestfirm (@RequestBody InvestProjectInvestfirmQueryInfo investProjectInvestfirmQueryInfo) {
		MessageInfo<QueryResultInfo<InvestProjectInvestfirmInfo>> resultMessageInfo = investProjectInvestfirmFacede.queryInvestProjectInvestfirm(investProjectInvestfirmQueryInfo);
		return resultMessageInfo;
	}

    @RequestMapping("create")
    @ResponseBody
	@Deprecated
    public MessageInfo<Long> createInvestProjectInvestfirm(InvestProjectInvestfirmInfo investProjectInvestfirmInfo){
        MessageInfo<Long> messageInfo =  investProjectInvestfirmFacede.createInvestProjectInvestfirm(investProjectInvestfirmInfo);
        return messageInfo;
    }

    @RequestMapping("update")
    @ResponseBody
	@Deprecated
	public MessageInfo<Integer> updateInvestProjectInvestfirm(InvestProjectInvestfirmInfo investProjectInvestfirmInfo){
		MessageInfo<Integer> messageInfo =  investProjectInvestfirmFacede.updateInvestProjectInvestfirm(investProjectInvestfirmInfo);
		return messageInfo;
	}

    @RequestMapping("get")
    @ResponseBody
	public MessageInfo<InvestProjectInvestfirmInfo> getInvestProjectInvestfirm( Long id ){
		MessageInfo<InvestProjectInvestfirmInfo> messageInfo =  investProjectInvestfirmFacede.getInvestProjectInvestfirm(id);
		return messageInfo;
	}

    @RequestMapping("getAll")
    @ResponseBody
    public MessageInfo<List<InvestProjectInvestfirmInfo>> getAllInvestProjectInvestfirm(){
		MessageInfo<List<InvestProjectInvestfirmInfo>>  messageInfo = investProjectInvestfirmFacede.getAllInvestProjectInvestfirm();
		return messageInfo;
	}


		
    @RequestMapping("getListByInvestId")
    @ResponseBody
	public MessageInfo<List<InvestProjectInvestfirmInfo>> getListByInvestId(Long investId){
		MessageInfo<List<InvestProjectInvestfirmInfo>> messageInfo = investProjectInvestfirmFacede.getListByInvestId(investId);
		return messageInfo;
	}
			
    @RequestMapping("getListByInvestfirmId")
    @ResponseBody
	public MessageInfo<List<InvestProjectInvestfirmInfo>> getListByInvestfirmId(Long investfirmId){
		MessageInfo<List<InvestProjectInvestfirmInfo>> messageInfo = investProjectInvestfirmFacede.getListByInvestfirmId(investfirmId);
		return messageInfo;
	}
			
    @RequestMapping("getListByProjectId")
    @ResponseBody
	public MessageInfo<List<InvestProjectInvestfirmInfo>> getListByProjectId(Long projectId){
		MessageInfo<List<InvestProjectInvestfirmInfo>> messageInfo = investProjectInvestfirmFacede.getListByProjectId(projectId);
		return messageInfo;
	}
		
}
