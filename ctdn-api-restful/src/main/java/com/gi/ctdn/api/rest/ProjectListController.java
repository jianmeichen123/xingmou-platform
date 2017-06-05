package com.gi.ctdn.api.rest;

import com.gi.ctdn.biz.ProjectContactBiz;
import com.gi.ctdn.biz.ProjectListBiz;
import com.gi.ctdn.biz.ProjectMediaInfoBiz;
import com.gi.ctdn.biz.ProjectTeamBiz;
import com.gi.ctdn.pojo.ProjectContact;
import com.gi.ctdn.pojo.ProjectList;
import com.gi.ctdn.pojo.ProjectMediaInfo;
import com.gi.ctdn.pojo.ProjectTeam;
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
	 * 查询竞争对手列表
	 * @param project
	 * @return
	 */
	@RequestMapping("queryCompetationlist")
	@ResponseBody
	public MessageInfo<QueryResultInfo<ProjectList>>  queryCompetationlist (@RequestBody ProjectList project) {
		MessageInfo<QueryResultInfo<ProjectList>> resultMessageInfo = projectListBiz.queryCompetationlist(project);
		return resultMessageInfo;
	}

	/**
	 * 根据项目code 查询团队成员
	 * @param sourceCode
	 * @return
	 */
	@RequestMapping("queryCompetationlist/{sourceCode}")
	@ResponseBody
	public MessageInfo<List<ProjectTeam>>  queryCompetationlist (@PathVariable String  sourceCode) {
		MessageInfo<List<ProjectTeam>> resultMessageInfo = projectTeamBiz.getListBySourcecode(sourceCode);
		return resultMessageInfo;
	}

	/**
	 * 根据项目code 查询发展历史,相关新闻,子公司列表
	 */
	@RequestMapping("queryProjectMediaInfo/{sourceCode}/{type}")
	@ResponseBody
	public MessageInfo<List<ProjectMediaInfo>> queryProjectMediaInfo(@PathVariable String sourceCode,String type){
		MessageInfo<List<ProjectMediaInfo>> resultMessageInfo = projectMediaInfoBiz.queryMediaInfoList(sourceCode,type);
		return resultMessageInfo;
	}

	/**
	 * 根据项目code 查询项目联系方式
	 * @param sourceCode
	 * @return
	 */
	@RequestMapping("queryProjectContact/{sourceCode}")
	@ResponseBody
	public MessageInfo<List<ProjectContact>> queryProjectMediaInfo(@PathVariable String sourceCode){
		MessageInfo<List<ProjectContact>> resultMessageInfo = projectContactBiz.getListBySourceCode(sourceCode);
		return resultMessageInfo;
	}
}
