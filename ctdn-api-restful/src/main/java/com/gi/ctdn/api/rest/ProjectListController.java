package com.gi.ctdn.api.rest;

import com.gi.ctdn.biz.ProjectContactBiz;
import com.gi.ctdn.biz.ProjectListBiz;
import com.gi.ctdn.biz.ProjectMediaInfoBiz;
import com.gi.ctdn.biz.ProjectTeamBiz;
import com.gi.ctdn.pojo.*;
import com.gi.ctdn.view.common.MessageInfo;
import com.gi.ctdn.view.common.Result;
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
//	@RequestMapping("queryRelativeListByCode/{sourceCode}")
//	@ResponseBody
//	public MessageInfo<ProjectListInfo> queryRelativeByCode(@PathVariable String  sourceCode){
//		MessageInfo<ProjectListInfo> resultMessageInfo = projectListBiz.getRelativeListByCode(sourceCode);
//		return resultMessageInfo;
//	}

	/**
	 * 根据code查询项目
	 */
	@RequestMapping("queryProjectByCode/{projectCode}")
	@ResponseBody
	public MessageInfo<ProjectListInfo> queryProjectByCode(@PathVariable String  projectCode){
		ProjectListInfo projectListInfo =  projectListBiz.getOneByCode(projectCode);
		MessageInfo<ProjectListInfo> resultMessageInfo = new MessageInfo<ProjectListInfo>();
		resultMessageInfo.setData(projectListInfo);
		return resultMessageInfo;
	}

	/**
	 * 根据code查询发展历史
	 */
	@RequestMapping("queryMediaInfoByCode")
	@ResponseBody
	public Result queryProjectByCode(@RequestBody ProjectMediaInfo projectMediaInfo){
		Result result = projectMediaInfoBiz.queryMediaInfoList(projectMediaInfo);
		return result;
	}

	/**
	 * 根据code查询团队成员
	 */
	@RequestMapping("queryProjectTeamByCode")
	@ResponseBody
	public MessageInfo<List<ProjectTeam>> queryProjectByCode(@RequestBody ProjectTeam team){
		MessageInfo<List<ProjectTeam>> resultMessageInfo =  projectTeamBiz.getListByProjectCode(team.getProjectCode());
		return resultMessageInfo;
	}


	/**
	 * 根据projectCode查询联系方式列表
	 * @return
	 */
	@RequestMapping("queryProjectContactByCode")
	@ResponseBody
	public MessageInfo<List<ProjectContact>>  queryContactlist (@RequestBody ProjectContact  projectContact) {
		MessageInfo<List<ProjectContact>> messageInfo = projectContactBiz.getListBySourceCode(projectContact.getProjectCode());
		return messageInfo;
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



	/**
	 * 查询最新项目
	 * @return
	 */
	@RequestMapping("queryLatestProjects")
	@ResponseBody
	public MessageInfo<List>  queryLatestProjects () {
		MessageInfo<List> resultMessageInfo = new MessageInfo<>();
		List<ProjectList> projectLists = projectListBiz.getByFinanceDate();
		resultMessageInfo.setData(projectLists);
		return resultMessageInfo;
	}
}
