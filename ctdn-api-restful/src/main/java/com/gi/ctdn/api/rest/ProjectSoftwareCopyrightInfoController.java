package com.gi.ctdn.api.rest;

import com.gi.ctdn.biz.ProjectSoftwareCopyrightInfoBiz;
import com.gi.ctdn.pojo.ProjectSoftwareCopyrightInfo;
import com.gi.ctdn.view.common.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("projectSoftwareCopyrightInfo")
public class ProjectSoftwareCopyrightInfoController {

    @Autowired
	private ProjectSoftwareCopyrightInfoBiz projectSoftwareCopyrightInfoBiz;



    @RequestMapping("getAll")
    @ResponseBody
    public MessageInfo<List<ProjectSoftwareCopyrightInfo>> getAllProjectSoftwareCopyrightInfo(){
		MessageInfo<List<ProjectSoftwareCopyrightInfo>>  messageInfo = projectSoftwareCopyrightInfoBiz.getAllProjectSoftwareCopyrightInfo();
		return messageInfo;
	}


		
    @RequestMapping("getListBySourceCode")
    @ResponseBody
	public MessageInfo<List<ProjectSoftwareCopyrightInfo>> getListBySourceCode(String sourceCode){
		MessageInfo<List<ProjectSoftwareCopyrightInfo>> messageInfo = projectSoftwareCopyrightInfoBiz.getListBySourceCode(sourceCode);
		return messageInfo;
	}
		
}
