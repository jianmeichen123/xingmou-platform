package com.gi.xm.platform.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.config.annotation.Reference;
import com.gi.xm.platform.facede.ProjectFacede;
import com.gi.xm.platform.view.ProjectInfo;
import com.gi.xm.platform.view.ProjectQueryInfo;
import com.gi.xm.platform.view.ProjectSearchTitleInfo;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;

@Controller
@RequestMapping("project")
public class ProjectController {

    @Reference
	private ProjectFacede projectFacede;


	@RequestMapping("query")
	@ResponseBody
	public MessageInfo<QueryResultInfo<ProjectInfo>>  queryProject (@RequestBody ProjectQueryInfo projectQueryInfo) {
		MessageInfo<QueryResultInfo<ProjectInfo>> resultMessageInfo = projectFacede.queryProject(projectQueryInfo);
		return resultMessageInfo;
	}
	
	/**
	 * 根据id查项目
	 * @param id
	 * @return
	 */
    @RequestMapping("get/{id}")
    @ResponseBody
	public MessageInfo<ProjectInfo> getProject( @PathVariable Long id ){
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



    @RequestMapping("getSearchTitle")
    @ResponseBody
    public MessageInfo<ProjectSearchTitleInfo> getSearchTitle() {
        MessageInfo<ProjectSearchTitleInfo> messageInfo = projectFacede.getProjectSearchTitleInfo();
        return messageInfo;
    }


	@RequestMapping("search")
	@ResponseBody
	public MessageInfo<QueryResultInfo<ProjectInfo>>  searchProject (@RequestBody ProjectQueryInfo projectQueryInfo) {
        if ("newestEventDate".equalsIgnoreCase(projectQueryInfo.getOrderBy())){
            projectQueryInfo.setOrderBy("newest_event_date");
        }else {
            projectQueryInfo.setOrderBy(null);
        }
        String returnFields = projectQueryInfo.getSearchFields();
        projectQueryInfo.setReturnFields(returnFields);
		MessageInfo<QueryResultInfo<ProjectInfo>> resultMessageInfo = projectFacede.searchProject(projectQueryInfo);
		return resultMessageInfo;
	}
}
