package com.gi.xm.platform.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
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

	@Reference(check = false)
	private LabelFacede labelFacede;

		
    @RequestMapping("getListByTypeRelationId")
    @ResponseBody
	public MessageInfo<List<LabelInfo>> getListByTypeRelationId(Long projectId){
    	MessageInfo<List<LabelInfo>> messageInfo = labelFacede.getListByTypeRelationId(Contants.LABEL_PROJECT,projectId);
		return messageInfo;
	}
		
}
