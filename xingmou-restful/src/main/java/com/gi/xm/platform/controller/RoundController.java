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
import com.gi.xm.platform.view.RoundInfo;
import com.gi.xm.platform.view.RoundQueryInfo;
import com.gi.xm.platform.facede.RoundFacede;

@Controller
@RequestMapping("round")
public class RoundController {

	@Reference(check = false)
	private RoundFacede roundFacede;


/*

    @RequestMapping("create")
    @ResponseBody
    public MessageInfo<Integer> createRound(RoundInfo roundInfo){
        MessageInfo<Integer> messageInfo =  roundFacede.createRound(roundInfo);
        return messageInfo;
    }

    @RequestMapping("update")
    @ResponseBody
	public MessageInfo<Integer> updateRound(RoundInfo roundInfo){
		MessageInfo<Integer> messageInfo =  roundFacede.updateRound(roundInfo);
		return messageInfo;
	}

    @RequestMapping("get")
    @ResponseBody
	public MessageInfo<RoundInfo> getRound( Integer id ){
		MessageInfo<RoundInfo> messageInfo =  roundFacede.getRound(id);
		return messageInfo;
	}
*/

    @RequestMapping("getAll")
    @ResponseBody
    public MessageInfo<List<RoundInfo>> getAllRound(){
		MessageInfo<List<RoundInfo>>  messageInfo = roundFacede.getAllRound();
		return messageInfo;
	}

	@RequestMapping("getInvestedRounds")
	@ResponseBody
	public MessageInfo<List<RoundInfo>> getInvestedRounds(){
		MessageInfo<List<RoundInfo>>  messageInfo = roundFacede.getInvestedRounds();
		return messageInfo;
	}



}
