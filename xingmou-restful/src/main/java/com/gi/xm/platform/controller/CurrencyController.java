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
import com.gi.xm.platform.view.CurrencyInfo;
import com.gi.xm.platform.view.CurrencyQueryInfo;
import com.gi.xm.platform.facede.CurrencyFacede;

@Controller
@RequestMapping("currency")
public class CurrencyController {

	@Reference(check = false)
	private CurrencyFacede currencyFacede;

	@RequestMapping(value = "index", method = RequestMethod.GET)
	public ModelAndView index() {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		return new ModelAndView("currency/index", modelMap);
	}

	@RequestMapping("query")
	@ResponseBody
	public MessageInfo<QueryResultInfo<CurrencyInfo>>  queryCurrency (CurrencyQueryInfo currencyQueryInfo) {
		MessageInfo<QueryResultInfo<CurrencyInfo>> resultMessageInfo = currencyFacede.queryCurrency(currencyQueryInfo);
		return resultMessageInfo;
	}

    @RequestMapping("create")
    @ResponseBody
    public MessageInfo<Long> createCurrency(CurrencyInfo currencyInfo){
        MessageInfo<Long> messageInfo =  currencyFacede.createCurrency(currencyInfo);
        return messageInfo;
    }

    @RequestMapping("update")
    @ResponseBody
	public MessageInfo<Integer> updateCurrency(CurrencyInfo currencyInfo){
		MessageInfo<Integer> messageInfo =  currencyFacede.updateCurrency(currencyInfo);
		return messageInfo;
	}

    @RequestMapping("get")
    @ResponseBody
	public MessageInfo<CurrencyInfo> getCurrency( Long id ){
		MessageInfo<CurrencyInfo> messageInfo =  currencyFacede.getCurrency(id);
		return messageInfo;
	}

    @RequestMapping("getAll")
    @ResponseBody
    public MessageInfo<List<CurrencyInfo>> getAllCurrency(){
		MessageInfo<List<CurrencyInfo>>  messageInfo = currencyFacede.getAllCurrency();
		return messageInfo;
	}


	
}
