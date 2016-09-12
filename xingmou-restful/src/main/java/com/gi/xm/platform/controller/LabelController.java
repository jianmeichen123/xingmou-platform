package com.gi.xm.platform.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.config.annotation.Reference;
import com.gi.xm.platform.facede.LabelFacede;
import com.gi.xm.platform.view.LabelInfo;
import com.gi.xm.platform.view.common.Contants;
import com.gi.xm.platform.view.common.MessageInfo;

@Controller
@RequestMapping("label")
public class LabelController {

    @Reference
	private LabelFacede labelFacede;

		
    @RequestMapping("getList/{projectId}")
    @ResponseBody
	public MessageInfo<List<LabelInfo>> getListByTypeRelationId(@PathVariable Long projectId){
    	MessageInfo<List<LabelInfo>> messageInfo = labelFacede.getListByTypeRelationId(Contants.LABEL_PROJECT,projectId);
		return messageInfo;
	}
		
}
