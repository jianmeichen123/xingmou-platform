package com.gi.xm.platform.restful;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.gi.ctdn.ods.biz.ProjectPatentInfoBiz;
import com.gi.ctdn.ods.pojo.ProjectPatentInfo;
import com.gi.xm.platform.view.common.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("projectPatentInfo")
public class ProjectPatentInfoController {

    @Autowired
	private ProjectPatentInfoBiz projectPatentInfoBiz;


    @RequestMapping("getAll")
    @ResponseBody
    public MessageInfo<List<ProjectPatentInfo>> getAllProjectPatentInfo(){
		MessageInfo<List<ProjectPatentInfo>>  messageInfo = projectPatentInfoBiz.getAllProjectPatentInfo();
		return messageInfo;
	}


		
    @RequestMapping("getListBySourceCode")
    @ResponseBody
	public MessageInfo<List<ProjectPatentInfo>> getListBySourceCode(String sourceCode){
		MessageInfo<List<ProjectPatentInfo>> messageInfo = projectPatentInfoBiz.getListBySourceCode(sourceCode);
		return messageInfo;
	}
		
}
