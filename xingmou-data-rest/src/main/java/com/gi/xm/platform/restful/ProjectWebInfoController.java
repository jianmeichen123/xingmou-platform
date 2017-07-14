package com.gi.xm.platform.restful;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.gi.ctdn.ods.biz.ProjectWebInfoBiz;
import com.gi.ctdn.ods.pojo.ProjectWebInfo;
import com.gi.xm.platform.view.common.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("projectWebInfo")
public class ProjectWebInfoController {

    @Autowired
	private ProjectWebInfoBiz projectWebInfoBiz;



    @RequestMapping("getAll")
    @ResponseBody
    public MessageInfo<List<ProjectWebInfo>> getAllProjectWebInfo(){
		MessageInfo<List<ProjectWebInfo>>  messageInfo = projectWebInfoBiz.getAllProjectWebInfo();
		return messageInfo;
	}


		
    @RequestMapping("getListBySourceCode")
    @ResponseBody
	public MessageInfo<List<ProjectWebInfo>> getListBySourceCode(String sourceCode){
		MessageInfo<List<ProjectWebInfo>> messageInfo = projectWebInfoBiz.getListBySourceCode(sourceCode);
		return messageInfo;
	}
		
}
