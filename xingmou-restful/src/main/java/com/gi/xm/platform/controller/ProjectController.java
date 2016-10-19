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
        if(projectQueryInfo.getCreateDateEnd()!=null){
            projectQueryInfo.setCreateDateEnd(((Integer.parseInt(projectQueryInfo.getCreateDateEnd())+1)+""));
        }

        if (projectQueryInfo.getOrder() != null&&projectQueryInfo.getOrderBy() != null){
			if (projectQueryInfo.getOrderBy().equalsIgnoreCase("createDate")){
				projectQueryInfo.setOrderBy("create_date");
			}else if (projectQueryInfo.getOrderBy().equalsIgnoreCase("newestEventRoundId")) {
				projectQueryInfo.setOrderBy("newest_event_round_id");
			}else if (projectQueryInfo.getOrderBy().equalsIgnoreCase("investMoney")) {
				projectQueryInfo.setOrderBy("invest_money");
			}else if (projectQueryInfo.getOrderBy().equalsIgnoreCase("newestEventMoney")) {
				projectQueryInfo.setOrderBy("newest_event_money");
			}else {
                projectQueryInfo.setOrderBy("create_date");
            }
		}else {
			projectQueryInfo.setOrder("desc");
			projectQueryInfo.setOrderBy("info_integrity");
		}
		String returnFields = projectQueryInfo.getSearchFields();
        projectQueryInfo.setReturnFields(returnFields);
		MessageInfo<QueryResultInfo<ProjectInfo>> resultMessageInfo = projectFacede.searchProject(projectQueryInfo);
		return resultMessageInfo;
	}
	
	@RequestMapping("queryCompetationlist")
	@ResponseBody
	public MessageInfo<QueryResultInfo<ProjectInfo>>  queryCompetationlist (@RequestBody ProjectQueryInfo projectQueryInfo) {
		MessageInfo<QueryResultInfo<ProjectInfo>> resultMessageInfo = projectFacede.queryCompetationlist(projectQueryInfo);
		return resultMessageInfo;
	}
}
