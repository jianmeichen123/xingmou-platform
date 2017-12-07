package com.gi.ctdn.api.rest;

import com.gi.ctdn.biz.ProjectContactBiz;
import com.gi.ctdn.biz.ProjectListBiz;
import com.gi.ctdn.biz.ProjectMediaInfoBiz;
import com.gi.ctdn.biz.ProjectTeamBiz;
import com.gi.ctdn.pojo.*;
import com.gi.ctdn.view.common.MessageInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
	@ApiOperation("根据code查项目'")
	@ApiImplicitParams(@ApiImplicitParam(paramType = "query", dataType = "String", name = "projectCode", value = "项目code", required = true))
	@RequestMapping("queryProjectByCode/{projectCode}")
	@ResponseBody
	public MessageInfo<ProjectList> queryProjectByCode(@PathVariable String  projectCode){
		ProjectList projectList =  projectListBiz.getOneByCode(projectCode);
		MessageInfo<ProjectList> messageInfo = new MessageInfo<ProjectList>();
		messageInfo.setData(projectList);
		return messageInfo;
	}

	/**
	 * 根据code查询发展历史
	 */
	@ApiOperation("查询项目发展历史")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", dataType = "String", name = "projectCode", value = "项目code", required = true),
			@ApiImplicitParam(paramType = "query", dataType = "Integer", name = "pageNo", value = "pageNo:1开始", required = true),
			@ApiImplicitParam(paramType = "query", dataType = "Integer", name = "pageSize", value = "pageSize", required = true),
			@ApiImplicitParam(paramType = "query", dataType = "String", name = "type", value = "发展历史:N", required = true)
	})
	@RequestMapping("queryMediaInfoByCode")
	@ResponseBody
	public MessageInfo<ProjectMediaInfo> queryProjectByCode(@RequestBody ProjectMediaInfo projectMediaInfo){
		MessageInfo<ProjectMediaInfo> messageInfo = projectMediaInfoBiz.queryMediaInfoList(projectMediaInfo);
		return messageInfo;
	}

	/**
	 * 根据code查询团队成员
	 */
	@ApiOperation("查询项目成员 ")
	@ApiImplicitParams(@ApiImplicitParam(paramType = "body", dataType = "ProjectTeam", name = "team", value = "只传projectCode", required = true))
	@RequestMapping("queryProjectTeamByCode")
	@ResponseBody
	public MessageInfo<List<ProjectTeam>> queryProjectByCode(@RequestBody ProjectTeam team){
		MessageInfo<List<ProjectTeam>> messageInfo =  projectTeamBiz.getListByProjectCode(team.getProjectCode());
		return messageInfo;
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
	@ApiOperation("查询竞争对手 不分页")
	@ApiImplicitParam(paramType = "query", dataType = "String", name = "projCode", value = "项目code", required = true)
	@RequestMapping("queryCompetationlist/{projCode}")
	@ResponseBody
	public MessageInfo<ProjectListInfo>  queryCompetationlist (@PathVariable String  projCode) {
		MessageInfo<ProjectListInfo> resultMessageInfo = projectListBiz.queryCompetationlist(projCode);
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

	/**
	 * 查询公司下的企业项目
	 * @param projectList
	 * @return
	 */
	@RequestMapping("queryByCompCode")
	@ResponseBody
	public  MessageInfo<ProjectList> queryByProjTitle(@RequestBody ProjectList projectList){
		MessageInfo<ProjectList> messageInfo = projectListBiz.queryByCompCode(projectList);
		return messageInfo;
	}


}
