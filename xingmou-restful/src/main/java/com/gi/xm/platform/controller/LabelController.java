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
import com.gi.xm.platform.view.LabelInfo;
import com.gi.xm.platform.view.LabelQueryInfo;
import com.gi.xm.platform.facede.LabelFacede;

@Controller
@RequestMapping("label")
public class LabelController {

    @Reference
	private LabelFacede labelFacede;


	@RequestMapping("query")
	@ResponseBody
	public MessageInfo<QueryResultInfo<LabelInfo>>  queryLabel (LabelQueryInfo labelQueryInfo) {
		MessageInfo<QueryResultInfo<LabelInfo>> resultMessageInfo = labelFacede.queryLabel(labelQueryInfo);
		return resultMessageInfo;
	}

    @RequestMapping("create")
    @ResponseBody
    public MessageInfo<Long> createLabel(LabelInfo labelInfo){
        MessageInfo<Long> messageInfo =  labelFacede.createLabel(labelInfo);
        return messageInfo;
    }

    @RequestMapping("update")
    @ResponseBody
	public MessageInfo<Integer> updateLabel(LabelInfo labelInfo){
		MessageInfo<Integer> messageInfo =  labelFacede.updateLabel(labelInfo);
		return messageInfo;
	}

    @RequestMapping("get")
    @ResponseBody
	public MessageInfo<LabelInfo> getLabel( Long id ){
		MessageInfo<LabelInfo> messageInfo =  labelFacede.getLabel(id);
		return messageInfo;
	}

    @RequestMapping("getAll")
    @ResponseBody
    public MessageInfo<List<LabelInfo>> getAllLabel(){
		MessageInfo<List<LabelInfo>>  messageInfo = labelFacede.getAllLabel();
		return messageInfo;
	}


	
}
