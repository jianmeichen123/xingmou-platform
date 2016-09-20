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
import com.gi.xm.platform.view.InvestfirmsDataYearInfo;
import com.gi.xm.platform.view.InvestfirmsDataYearQueryInfo;
import com.gi.xm.platform.facede.InvestfirmsDataYearFacede;

@Controller
@RequestMapping("investfirmsDataYear")
public class InvestfirmsDataYearController {

	@Reference(check = false)
	private InvestfirmsDataYearFacede investfirmsDataYearFacede;

	@RequestMapping(value = "index", method = RequestMethod.GET)
	public ModelAndView index() {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		return new ModelAndView("investfirmsDataYear/index", modelMap);
	}

	@RequestMapping("query")
	@ResponseBody
	public MessageInfo<QueryResultInfo<InvestfirmsDataYearInfo>>  queryInvestfirmsDataYear (@RequestBody InvestfirmsDataYearQueryInfo investfirmsDataYearQueryInfo) {

		MessageInfo<QueryResultInfo<InvestfirmsDataYearInfo>> resultMessageInfo = investfirmsDataYearFacede.queryInvestfirmsDataYear(investfirmsDataYearQueryInfo);
		return resultMessageInfo;
	}

    @RequestMapping("create")
    @ResponseBody
	@Deprecated
    public MessageInfo<Long> createInvestfirmsDataYear(InvestfirmsDataYearInfo investfirmsDataYearInfo){
        MessageInfo<Long> messageInfo =  investfirmsDataYearFacede.createInvestfirmsDataYear(investfirmsDataYearInfo);
        return messageInfo;
    }

    @RequestMapping("update")
    @ResponseBody
	@Deprecated
	public MessageInfo<Integer> updateInvestfirmsDataYear(InvestfirmsDataYearInfo investfirmsDataYearInfo){
		MessageInfo<Integer> messageInfo =  investfirmsDataYearFacede.updateInvestfirmsDataYear(investfirmsDataYearInfo);
		return messageInfo;
	}

    @RequestMapping("get")
    @ResponseBody
	public MessageInfo<InvestfirmsDataYearInfo> getInvestfirmsDataYear( Long id ){
		MessageInfo<InvestfirmsDataYearInfo> messageInfo =  investfirmsDataYearFacede.getInvestfirmsDataYear(id);
		return messageInfo;
	}

    @RequestMapping("getAll")
    @ResponseBody
    public MessageInfo<List<InvestfirmsDataYearInfo>> getAllInvestfirmsDataYear(){
		MessageInfo<List<InvestfirmsDataYearInfo>>  messageInfo = investfirmsDataYearFacede.getAllInvestfirmsDataYear();
		return messageInfo;
	}


		
    @RequestMapping("getListByInvestfirmId")
    @ResponseBody
	public MessageInfo<List<InvestfirmsDataYearInfo>> getListByInvestfirmId(Long investfirmId){
		MessageInfo<List<InvestfirmsDataYearInfo>> messageInfo = investfirmsDataYearFacede.getListByInvestfirmId(investfirmId);
		return messageInfo;
	}
			
    @RequestMapping("getListByYear")
    @ResponseBody
	public MessageInfo<List<InvestfirmsDataYearInfo>> getListByYear(Integer year){
		MessageInfo<List<InvestfirmsDataYearInfo>> messageInfo = investfirmsDataYearFacede.getListByYear(year);
		return messageInfo;
	}
		
}
