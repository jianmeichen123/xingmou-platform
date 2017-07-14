package com.gi.xm.platform.restful;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.gi.ctdn.ods.biz.ProjectMarkInfoBiz;
import com.gi.ctdn.ods.pojo.ProjectMarkInfo;
import com.gi.xm.platform.view.common.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("projectMarkInfo")
public class ProjectMarkInfoController {

    @Autowired
	private ProjectMarkInfoBiz projectMarkInfoBiz;


    @RequestMapping("getAll")
    @ResponseBody
    public MessageInfo<List<ProjectMarkInfo>> getAllProjectMarkInfo(){
		MessageInfo<List<ProjectMarkInfo>>  messageInfo = projectMarkInfoBiz.getAllProjectMarkInfo();
		return messageInfo;
	}


		
    @RequestMapping("getListBySourceCode")
    @ResponseBody
	public MessageInfo<List<ProjectMarkInfo>> getListBySourceCode(String sourceCode){
		MessageInfo<List<ProjectMarkInfo>> messageInfo = projectMarkInfoBiz.getListBySourceCode(sourceCode);
		return messageInfo;
	}
		
}
