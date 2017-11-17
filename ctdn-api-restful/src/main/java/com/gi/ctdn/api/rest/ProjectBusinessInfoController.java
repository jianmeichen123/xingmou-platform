package com.gi.ctdn.api.rest;

import com.gi.ctdn.biz.ProjectBusinessInfoBiz;
import com.gi.ctdn.pojo.ProjectBusinessInfo;
import com.gi.ctdn.pojo.ProjectBusinessListInfo;
import com.gi.ctdn.view.common.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("businessInfo")
public class ProjectBusinessInfoController {

    @Autowired
	private ProjectBusinessInfoBiz projectBusinessInfoBiz;


    @RequestMapping("getAll")
    @ResponseBody
    public MessageInfo<List<ProjectBusinessInfo>> getAllProjectBusinessInfo(){
		MessageInfo<List<ProjectBusinessInfo>>  messageInfo = projectBusinessInfoBiz.getAllProjectBusinessInfo();
		return messageInfo;
	}


		
    @RequestMapping("getListBySourceCode/{sourceCode}")
    @ResponseBody
	public MessageInfo<ProjectBusinessListInfo> getListBySourceCode(@PathVariable String sourceCode){
		MessageInfo<ProjectBusinessListInfo> messageInfo = projectBusinessInfoBiz.getProjectBusinessListInfoBySourceCode(sourceCode);
		return messageInfo;
	}

	@RequestMapping("getListByRegName/{company}")
	@ResponseBody
	public MessageInfo<ProjectBusinessInfo> getListByRegName(@PathVariable String company){
		MessageInfo<ProjectBusinessInfo> messageInfo = projectBusinessInfoBiz.getListByRegName(company);
		return messageInfo;
	}
}
