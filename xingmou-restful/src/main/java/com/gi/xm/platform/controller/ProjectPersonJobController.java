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
import com.gi.xm.platform.view.ProjectPersonJobInfo;
import com.gi.xm.platform.view.ProjectPersonJobQueryInfo;
import com.gi.xm.platform.facede.ProjectPersonJobFacede;

@Controller
@RequestMapping("projectPersonJob")
public class ProjectPersonJobController {

	@Reference(check = false)
	private ProjectPersonJobFacede projectPersonJobFacede;


	@RequestMapping("query")
	@ResponseBody
	public MessageInfo<QueryResultInfo<ProjectPersonJobInfo>>  queryProjectPersonJob (ProjectPersonJobQueryInfo projectPersonJobQueryInfo) {
		MessageInfo<QueryResultInfo<ProjectPersonJobInfo>> resultMessageInfo = projectPersonJobFacede.queryProjectPersonJob(projectPersonJobQueryInfo);
		return resultMessageInfo;
	}
/*

    @RequestMapping("create")
    @ResponseBody
    public MessageInfo<Long> createProjectPersonJob(ProjectPersonJobInfo projectPersonJobInfo){
        MessageInfo<Long> messageInfo =  projectPersonJobFacede.createProjectPersonJob(projectPersonJobInfo);
        return messageInfo;
    }

    @RequestMapping("update")
    @ResponseBody
	public MessageInfo<Integer> updateProjectPersonJob(ProjectPersonJobInfo projectPersonJobInfo){
		MessageInfo<Integer> messageInfo =  projectPersonJobFacede.updateProjectPersonJob(projectPersonJobInfo);
		return messageInfo;
	}
*/

    @RequestMapping("get")
    @ResponseBody
	public MessageInfo<ProjectPersonJobInfo> getProjectPersonJob( Long id ){
		MessageInfo<ProjectPersonJobInfo> messageInfo =  projectPersonJobFacede.getProjectPersonJob(id);
		return messageInfo;
	}

}
