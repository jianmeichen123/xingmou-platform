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
import com.gi.xm.platform.view.InvestfirmAreaInfo;
import com.gi.xm.platform.view.InvestfirmAreaQueryInfo;
import com.gi.xm.platform.facede.InvestfirmAreaFacede;

@Controller
@RequestMapping("investfirmArea")
public class InvestfirmAreaController {

	@Reference(check = false)
	private InvestfirmAreaFacede investfirmAreaFacede;

	@RequestMapping("query")
	@ResponseBody
	public MessageInfo<QueryResultInfo<InvestfirmAreaInfo>>  queryInvestfirmArea (InvestfirmAreaQueryInfo investfirmAreaQueryInfo) {
		MessageInfo<QueryResultInfo<InvestfirmAreaInfo>> resultMessageInfo = investfirmAreaFacede.queryInvestfirmArea(investfirmAreaQueryInfo);
		return resultMessageInfo;
	}
/*

    @RequestMapping("create")
    @ResponseBody
    public MessageInfo<Long> createInvestfirmArea(InvestfirmAreaInfo investfirmAreaInfo){
        MessageInfo<Long> messageInfo =  investfirmAreaFacede.createInvestfirmArea(investfirmAreaInfo);
        return messageInfo;
    }

    @RequestMapping("update")
    @ResponseBody
	public MessageInfo<Integer> updateInvestfirmArea(InvestfirmAreaInfo investfirmAreaInfo){
		MessageInfo<Integer> messageInfo =  investfirmAreaFacede.updateInvestfirmArea(investfirmAreaInfo);
		return messageInfo;
	}
*/

    @RequestMapping("get")
    @ResponseBody
	public MessageInfo<InvestfirmAreaInfo> getInvestfirmArea( Long id ){
		MessageInfo<InvestfirmAreaInfo> messageInfo =  investfirmAreaFacede.getInvestfirmArea(id);
		return messageInfo;
	}


    @RequestMapping("getListByInvestfrimId")
    @ResponseBody
	public MessageInfo<List<InvestfirmAreaInfo>> getListByInvestfrimId(Integer investfrimId){
		MessageInfo<List<InvestfirmAreaInfo>> messageInfo = investfirmAreaFacede.getListByInvestfrimId(investfrimId);
		return messageInfo;
	}
		
}
