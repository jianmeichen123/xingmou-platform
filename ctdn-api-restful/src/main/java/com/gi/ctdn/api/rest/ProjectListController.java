package com.gi.ctdn.api.rest;

import com.gi.ctdn.biz.ProjectListBiz;
import com.gi.ctdn.pojo.ProjectList;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("projectList")
public class ProjectListController {

    @Autowired
	private ProjectListBiz projectListBiz;

    @RequestMapping("getListByCode")
    @ResponseBody
	public MessageInfo<List<ProjectList>> getListByCode(String code){
		MessageInfo<List<ProjectList>> messageInfo = projectListBiz.getListByCode(code);
		return messageInfo;
	}

	@RequestMapping("queryCompetationlist")
	@ResponseBody
	public MessageInfo<QueryResultInfo<ProjectList>>  queryCompetationlist (@RequestBody ProjectList project) {
		MessageInfo<QueryResultInfo<ProjectList>> resultMessageInfo = projectListBiz.queryCompetationlist(project);
		return resultMessageInfo;
	}
}
