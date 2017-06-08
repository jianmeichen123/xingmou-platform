package com.gi.ctdn.api.rest;

import com.gi.ctdn.biz.ProjectContactBiz;
import com.gi.ctdn.biz.ProjectListBiz;
import com.gi.ctdn.biz.ProjectMediaInfoBiz;
import com.gi.ctdn.biz.ProjectTeamBiz;
import com.gi.ctdn.pojo.*;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("projectList")
public class ProjectListController {

    @Autowired
	private ProjectListBiz projectListBiz;

    @Autowired
	private ProjectTeamBiz projectTeamBiz;

    @Autowired
	private ProjectMediaInfoBiz projectMediaInfoBiz;

	@Autowired
	private ProjectContactBiz projectContactBiz;

	/**
	 * 根据code查询项目
	 */
	@RequestMapping("queryProjectByCode/{sourceCode}")
	@ResponseBody
	public MessageInfo<ProjectListInfo> queryProjectByCode(@PathVariable String  sourceCode){
		MessageInfo<ProjectListInfo> resultMessageInfo = projectListBiz.getOneByCode(sourceCode);
		return resultMessageInfo;
	}

	/**
	 * 查询竞争对手列表
	 * @return
	 */
	@RequestMapping("queryCompetationlist/{sourceCode}")
	@ResponseBody
	public MessageInfo<ProjectListInfo>  queryCompetationlist (@PathVariable String  sourceCode) {
		MessageInfo<ProjectListInfo> resultMessageInfo = projectListBiz.queryCompetationlist(sourceCode);
		return resultMessageInfo;
	}
}
