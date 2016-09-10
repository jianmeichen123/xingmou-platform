package com.gi.xm.platform.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.dubbo.config.annotation.Reference;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.view.ProjectPersonInfo;
import com.gi.xm.platform.view.ProjectPersonQueryInfo;
import com.gi.xm.platform.facede.ProjectPersonFacede;

@Controller
@RequestMapping("projectPerson")
public class ProjectPersonController {

    @Reference
	private ProjectPersonFacede projectPersonFacede;

	@RequestMapping(value = "index", method = RequestMethod.GET)
	public ModelAndView index() {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		return new ModelAndView("projectPerson/index", modelMap);
	}

	@RequestMapping("query")
	@ResponseBody
	public MessageInfo<QueryResultInfo<ProjectPersonInfo>>  queryProjectPerson (ProjectPersonQueryInfo projectPersonQueryInfo) {
		MessageInfo<QueryResultInfo<ProjectPersonInfo>> resultMessageInfo = projectPersonFacede.queryProjectPerson(projectPersonQueryInfo);
		return resultMessageInfo;
	}

    @RequestMapping("create")
    @ResponseBody
    public MessageInfo<Integer> createProjectPerson(ProjectPersonInfo projectPersonInfo){
        MessageInfo<Integer> messageInfo =  projectPersonFacede.createProjectPerson(projectPersonInfo);
        return messageInfo;
    }

    @RequestMapping("update")
    @ResponseBody
	public MessageInfo<Integer> updateProjectPerson(ProjectPersonInfo projectPersonInfo){
		MessageInfo<Integer> messageInfo =  projectPersonFacede.updateProjectPerson(projectPersonInfo);
		return messageInfo;
	}

    @RequestMapping("get")
    @ResponseBody
	public MessageInfo<ProjectPersonInfo> getProjectPerson( Integer id ){
		MessageInfo<ProjectPersonInfo> messageInfo =  projectPersonFacede.getProjectPerson(id);
		return messageInfo;
	}

    @RequestMapping("getAll")
    @ResponseBody
    public MessageInfo<List<ProjectPersonInfo>> getAllProjectPerson(){
		MessageInfo<List<ProjectPersonInfo>>  messageInfo = projectPersonFacede.getAllProjectPerson();
		return messageInfo;
	}


	
}
