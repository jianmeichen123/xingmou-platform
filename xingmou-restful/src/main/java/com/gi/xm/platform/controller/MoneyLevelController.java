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
import com.gi.xm.platform.view.MoneyLevelInfo;
import com.gi.xm.platform.view.MoneyLevelQueryInfo;
import com.gi.xm.platform.facede.MoneyLevelFacede;

@Controller
@RequestMapping("moneyLevel")
public class MoneyLevelController {

    @Reference
	private MoneyLevelFacede moneyLevelFacede;


	@RequestMapping("query")
	@ResponseBody
	public MessageInfo<QueryResultInfo<MoneyLevelInfo>>  queryMoneyLevel (MoneyLevelQueryInfo moneyLevelQueryInfo) {
		MessageInfo<QueryResultInfo<MoneyLevelInfo>> resultMessageInfo = moneyLevelFacede.queryMoneyLevel(moneyLevelQueryInfo);
		return resultMessageInfo;
	}

    @RequestMapping("create")
    @ResponseBody
    public MessageInfo<Integer> createMoneyLevel(MoneyLevelInfo moneyLevelInfo){
        MessageInfo<Integer> messageInfo =  moneyLevelFacede.createMoneyLevel(moneyLevelInfo);
        return messageInfo;
    }

    @RequestMapping("update")
    @ResponseBody
	public MessageInfo<Integer> updateMoneyLevel(MoneyLevelInfo moneyLevelInfo){
		MessageInfo<Integer> messageInfo =  moneyLevelFacede.updateMoneyLevel(moneyLevelInfo);
		return messageInfo;
	}

	@RequestMapping(value="/get/{id}",method=RequestMethod.DELETE)
    @ResponseBody
	public MessageInfo<MoneyLevelInfo> getMoneyLevel(Integer id ){
		MessageInfo<MoneyLevelInfo> messageInfo =  moneyLevelFacede.getMoneyLevel(id);
		return messageInfo;
	}

    @RequestMapping("getAll")
    @ResponseBody
    public MessageInfo<List<MoneyLevelInfo>> getAllMoneyLevel(){
		MessageInfo<List<MoneyLevelInfo>>  messageInfo = moneyLevelFacede.getAllMoneyLevel();
		return messageInfo;
	}


	
}
