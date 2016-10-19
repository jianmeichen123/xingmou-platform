package com.gi.xm.platform.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.dubbo.config.annotation.Reference;
import com.gi.xm.platform.facede.ProjectPersonFacede;
import com.gi.xm.platform.view.ProjectPersonInfo;
import com.gi.xm.platform.view.ProjectPersonQueryInfo;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;

/**
 * 团队成员
 * @author zhangchunyuan
 *
 */
@Controller
@RequestMapping("projectPerson")
public class ProjectPersonController {

	@Reference(check = false)
	private ProjectPersonFacede projectPersonFacede;


	@RequestMapping("query")
	@ResponseBody
	public MessageInfo<QueryResultInfo<ProjectPersonInfo>>  queryProjectPerson (ProjectPersonQueryInfo projectPersonQueryInfo) {
		MessageInfo<QueryResultInfo<ProjectPersonInfo>> resultMessageInfo = projectPersonFacede.queryProjectPerson(projectPersonQueryInfo);
		return resultMessageInfo;
	}
/*

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
*/

    @RequestMapping("get")
    @ResponseBody
	public MessageInfo<ProjectPersonInfo> getProjectPerson( Integer id ){
		MessageInfo<ProjectPersonInfo> messageInfo =  projectPersonFacede.getProjectPerson(id);
		return messageInfo;
	}


  /*  @RequestMapping("queryPersonByProjectId")
    @ResponseBody
    public MessageInfo<List<ProjectPersonInfo>> queryPersonByProjectId(Integer projectId,Integer type,String orderBy,String order){
		MessageInfo<List<ProjectPersonInfo>>  messageInfo = projectPersonFacede.queryPersonByProjectId(projectId,type);
		return messageInfo;
	}*/
    
    @RequestMapping("queryPersonList")
    @ResponseBody
    public MessageInfo<List<ProjectPersonInfo>> queryPersonList(@RequestBody ProjectPersonQueryInfo projectPersonQueryInfo){
		MessageInfo<List<ProjectPersonInfo>>  messageInfo = projectPersonFacede.queryPersonList(projectPersonQueryInfo);
		return messageInfo;
	}
	
}
