package com.gi.xm.platform.restful;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.gi.ctdn.ods.biz.ProjectCopyrightInfoBiz;
import com.gi.ctdn.ods.pojo.ProjectCopyrightInfo;
import com.gi.xm.platform.view.common.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("projectCopyrightInfo")
public class ProjectCopyrightInfoController {

    @Autowired
	private ProjectCopyrightInfoBiz projectCopyrightInfoBiz;



    @RequestMapping("getAll")
    @ResponseBody
    public MessageInfo<List<ProjectCopyrightInfo>> getAllProjectCopyrightInfo(){
		MessageInfo<List<ProjectCopyrightInfo>>  messageInfo = projectCopyrightInfoBiz.getAllProjectCopyrightInfo();
		return messageInfo;
	}


		
    @RequestMapping("getListBySourceCode")
    @ResponseBody
	public MessageInfo<List<ProjectCopyrightInfo>> getListBySourceCode(String sourceCode){
		MessageInfo<List<ProjectCopyrightInfo>> messageInfo = projectCopyrightInfoBiz.getListBySourceCode(sourceCode);
		return messageInfo;
	}
		
}
