package com.gi.xm.platform.restful;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.gi.ctdn.ods.biz.ProjectSoftwareCopyrightInfoBiz;
import com.gi.ctdn.ods.pojo.ProjectSoftwareCopyrightInfo;
import com.gi.xm.platform.view.common.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


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
