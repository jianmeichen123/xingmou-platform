package com.gi.xm.platform.restful;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.gi.ctdn.ods.biz.ProjectRiskBiz;
import com.gi.ctdn.ods.pojo.ProjectRisk;
import com.gi.xm.platform.view.common.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("projectRisk")
public class ProjectRiskController {

    @Autowired
	private ProjectRiskBiz projectRiskBiz;


    @RequestMapping("getAll")
    @ResponseBody
    public MessageInfo<List<ProjectRisk>> getAllProjectRisk(){
		MessageInfo<List<ProjectRisk>>  messageInfo = projectRiskBiz.getAllProjectRisk();
		return messageInfo;
	}


	
}
