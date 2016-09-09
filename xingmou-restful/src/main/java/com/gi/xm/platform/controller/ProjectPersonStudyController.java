package com.gi.xm.platform.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.dubbo.config.annotation.Reference;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.view.ProjectPersonStudyInfo;
import com.gi.xm.platform.view.ProjectPersonStudyQueryInfo;
import com.gi.xm.platform.facede.ProjectPersonStudyFacede;

@Controller
@RequestMapping("projectPersonStudy")
public class ProjectPersonStudyController {

    @Reference
	private ProjectPersonStudyFacede projectPersonStudyFacede;


	@RequestMapping("query")
	@ResponseBody
	public MessageInfo<QueryResultInfo<ProjectPersonStudyInfo>>  queryProjectPersonStudy (ProjectPersonStudyQueryInfo projectPersonStudyQueryInfo) {
		MessageInfo<QueryResultInfo<ProjectPersonStudyInfo>> resultMessageInfo = projectPersonStudyFacede.queryProjectPersonStudy(projectPersonStudyQueryInfo);
		return resultMessageInfo;
	}

    @RequestMapping("create")
    @ResponseBody
    public MessageInfo<Long> createProjectPersonStudy(ProjectPersonStudyInfo projectPersonStudyInfo){
        MessageInfo<Long> messageInfo =  projectPersonStudyFacede.createProjectPersonStudy(projectPersonStudyInfo);
        return messageInfo;
    }

    @RequestMapping("update")
    @ResponseBody
	public MessageInfo<Integer> updateProjectPersonStudy(ProjectPersonStudyInfo projectPersonStudyInfo){
		MessageInfo<Integer> messageInfo =  projectPersonStudyFacede.updateProjectPersonStudy(projectPersonStudyInfo);
		return messageInfo;
	}

    @RequestMapping("get")
    @ResponseBody
	public MessageInfo<ProjectPersonStudyInfo> getProjectPersonStudy( Long id ){
		MessageInfo<ProjectPersonStudyInfo> messageInfo =  projectPersonStudyFacede.getProjectPersonStudy(id);
		return messageInfo;
	}

    @RequestMapping("getAll")
    @ResponseBody
    public MessageInfo<List<ProjectPersonStudyInfo>> getAllProjectPersonStudy(){
		MessageInfo<List<ProjectPersonStudyInfo>>  messageInfo = projectPersonStudyFacede.getAllProjectPersonStudy();
		return messageInfo;
	}


	
}
