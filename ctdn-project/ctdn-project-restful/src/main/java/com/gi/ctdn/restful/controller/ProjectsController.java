package com.gi.ctdn.restful.controller;


import com.gi.ctdn.biz.CompanysBiz;
import com.gi.ctdn.biz.FilesBiz;
import com.gi.ctdn.biz.ProjectProductBiz;
import com.gi.ctdn.biz.ProjectsBiz;
import com.gi.ctdn.pojo.FilesInfo;
import com.gi.ctdn.pojo.ProjectProductInfo;
import com.gi.ctdn.pojo.ProjectsInfo;
import com.gi.ctdn.query.ProjectsQueryInfo;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("projects")
public class ProjectsController {

    @Autowired
	private ProjectsBiz projectsBiz;

	@Autowired
	private FilesBiz  filesBiz;

	@Autowired
	private ProjectProductBiz projectProductBiz;

	@Autowired
	private CompanysBiz companysBiz;

	@RequestMapping(value = "index", method = RequestMethod.GET)
	public ModelAndView index() {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		return new ModelAndView("projects/index", modelMap);
	}

	@RequestMapping("createProject")
	@ResponseBody
	public MessageInfo<Long> createProjects(@RequestBody ProjectsInfo projectsInfo){
		MessageInfo<Long> messageInfo = new MessageInfo<>();
		if(projectsInfo.getCreatedUid() ==null||projectsInfo.getCreatedUname()==null){
			messageInfo.setMessage("操作人id为空!");
			messageInfo.setStatus(10001);
			return messageInfo;
		}
		//check 表单必填项
		if(projectsInfo.getTitle()==null || projectsInfo.getIndustryId() ==null || StringUtils.isEmpty(projectsInfo.getIndustryName())||
		projectsInfo.getProductList().isEmpty() ||StringUtils.isEmpty(projectsInfo.getProductCompete())
				||StringUtils.isEmpty(projectsInfo.getBpFile()) || StringUtils.isEmpty(projectsInfo.getProductLogo()) || projectsInfo.getProjectPicList()==null){
			messageInfo.setMessage("必填项未填写完整!");
			messageInfo.setStatus(10001);
			return messageInfo;
		}
		if(projectsInfo.getId() != null){
			messageInfo = projectsBiz.updateProject(projectsInfo);
		}else{
			messageInfo = projectsBiz.createProjects(projectsInfo);
		}
		return messageInfo;
	}

	@RequestMapping("updateProject")
	@ResponseBody
	public MessageInfo<Long> updateProjects(@RequestBody  ProjectsInfo projectsInfo){
		MessageInfo<Long> messageInfo = new MessageInfo<>();
		Long id = projectsInfo.getId();
		Long createUid = projectsInfo.getCreatedUid();

		if(id == null){
			messageInfo.setMessage("缺失项目id！");
			messageInfo.setStatus(10001);
			return messageInfo;
		}

		//check 表单必填项
		if(projectsInfo.getTitle()==null || projectsInfo.getIndustryId() ==null || StringUtils.isEmpty(projectsInfo.getIndustryName())
				||projectsInfo.getProductList().isEmpty() ||StringUtils.isEmpty(projectsInfo.getProductCompete())
				||StringUtils.isEmpty(projectsInfo.getBpFile()) || StringUtils.isEmpty(projectsInfo.getProductLogo()) || projectsInfo.getProjectPicList()==null){
			messageInfo.setMessage("必填项未填写完整!");
			messageInfo.setStatus(10001);
			return messageInfo;
		}

		ProjectsInfo temp = projectsBiz.queryById(id).getData();
		if(!temp.getCreatedUid().equals(createUid)){
			messageInfo.setMessage("当前操作人无权限修改项目！");
			messageInfo.setStatus(10001);
			return messageInfo;
		}
		messageInfo = projectsBiz.updateProject(projectsInfo);
		return messageInfo;
	}


	@RequestMapping("queryById/{id}")
	@ResponseBody
	public MessageInfo<ProjectsInfo> queryById (@PathVariable("id") Long id) {
		MessageInfo<ProjectsInfo> messageInfo = new MessageInfo<ProjectsInfo>();
		if(id == null){
			messageInfo.setMessage("缺失项目id！");
			messageInfo.setStatus(10001);
			return messageInfo;
		}
		messageInfo  = projectsBiz.queryById(id);
		return messageInfo;
	}

	@RequestMapping("delete")
	@ResponseBody
	public MessageInfo<Integer> delete(@RequestBody  ProjectsQueryInfo queryInfo){
		MessageInfo<Integer> messageInfo = new MessageInfo<Integer>();
		messageInfo =  projectsBiz.delete(queryInfo);
		return messageInfo;
	}

	@RequestMapping("queryMyProjects")
	@ResponseBody
	public MessageInfo<QueryResultInfo<ProjectsInfo>> queryMyProjects(@RequestBody  ProjectsQueryInfo queryInfo){
		MessageInfo<QueryResultInfo<ProjectsInfo>> messageInfo = new MessageInfo<QueryResultInfo<ProjectsInfo>>();
		if(queryInfo.getCreatedUid() == null){
			messageInfo.setMessage("操作人id为空!");
			messageInfo.setStatus(10001);
			return messageInfo;
		}
		messageInfo = projectsBiz.queryProjects(queryInfo);
		return messageInfo;
	}
}
