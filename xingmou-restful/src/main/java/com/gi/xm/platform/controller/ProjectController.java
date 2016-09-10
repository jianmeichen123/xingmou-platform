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
import com.gi.xm.platform.view.ProjectInfo;
import com.gi.xm.platform.view.ProjectQueryInfo;
import com.gi.xm.platform.facede.ProjectFacede;

@Controller
@RequestMapping("project")
public class ProjectController {

    @Reference
	private ProjectFacede projectFacede;

	@RequestMapping(value = "index", method = RequestMethod.GET)
	public ModelAndView index() {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		return new ModelAndView("project/index", modelMap);
	}

	@RequestMapping("query")
	@ResponseBody
	public MessageInfo<QueryResultInfo<ProjectInfo>>  queryProject (ProjectQueryInfo projectQueryInfo) {
		MessageInfo<QueryResultInfo<ProjectInfo>> resultMessageInfo = projectFacede.queryProject(projectQueryInfo);
		return resultMessageInfo;
	}

    @RequestMapping("create")
    @ResponseBody
    public MessageInfo<Long> createProject(ProjectInfo projectInfo){
        MessageInfo<Long> messageInfo =  projectFacede.createProject(projectInfo);
        return messageInfo;
    }

    @RequestMapping("update")
    @ResponseBody
	public MessageInfo<Integer> updateProject(ProjectInfo projectInfo){
		MessageInfo<Integer> messageInfo =  projectFacede.updateProject(projectInfo);
		return messageInfo;
	}

    @RequestMapping("get")
    @ResponseBody
	public MessageInfo<ProjectInfo> getProject( Long id ){
		MessageInfo<ProjectInfo> messageInfo =  projectFacede.getProject(id);
		return messageInfo;
	}

    @RequestMapping("getAll")
    @ResponseBody
    public MessageInfo<List<ProjectInfo>> getAllProject(){
		MessageInfo<List<ProjectInfo>>  messageInfo = projectFacede.getAllProject();
		return messageInfo;
	}


		
    @RequestMapping("getListBySourceId")
    @ResponseBody
	public MessageInfo<List<ProjectInfo>> getListBySourceId(Long sourceId){
		MessageInfo<List<ProjectInfo>> messageInfo = projectFacede.getListBySourceId(sourceId);
		return messageInfo;
	}
		
}
