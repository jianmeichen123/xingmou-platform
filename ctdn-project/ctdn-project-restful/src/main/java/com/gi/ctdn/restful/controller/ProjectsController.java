package com.gi.ctdn.restful.controller;


import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import ctdn.biz.CompanysBiz;
import ctdn.biz.FilesBiz;
import ctdn.biz.ProjectProductBiz;
import ctdn.biz.ProjectsBiz;
import ctdn.pojo.CompanysInfo;
import ctdn.pojo.FilesInfo;
import ctdn.pojo.ProjectProductInfo;
import ctdn.pojo.ProjectsInfo;
import ctdn.query.ProjectsQueryInfo;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("projects")
public class ProjectsController {

    @Reference
	private ProjectsBiz projectsBiz;
	@Reference
	private FilesBiz  filesBiz;
	@Reference
	private ProjectProductBiz projectProductBiz;
	@Reference
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
		//验证表单项
		if(projectsInfo.getTitle()==null || projectsInfo.getIndustryId() ==null || projectsInfo.getIndustryName()==null
				||projectsInfo.getProductInfo()==null ||projectsInfo.getProductCompete() ==null
				||projectsInfo.getBpFile() ==null || projectsInfo.getProductLogo()==null || projectsInfo.getProjectPicList()==null){
			messageInfo.setMessage("必填项未填写完整!");
			messageInfo.setStatus(10001);
			return messageInfo;
		}
		List<String> labelList = projectsInfo.getLabelNameList();
		StringBuilder labelNames = new StringBuilder("");
		for(int i = 0;i<labelList.size();i++){
			labelNames.append(labelList.get(i));
			if(i>0 && i!= (labelList.size()-1)){
				labelNames.append(",");
			}
		}
		projectsInfo.setLabelNames(labelNames.toString());
		messageInfo = projectsBiz.createProjects(projectsInfo);
		Long id = messageInfo.getData();
		Date now  = new Date();
		Long createUid = projectsInfo.getCreatedUid();
		String createUname = projectsInfo.getCreatedUname();

		//save　项目图片
		List<String> projectPicList = projectsInfo.getProjectPicList();
		for(String pic: projectPicList){
			FilesInfo filesInfo = new FilesInfo();
			filesInfo.setRelationId(id);
			filesInfo.setFilePath(pic);
			filesInfo.setType(1);
			filesInfo.setAddTime(now);
			filesInfo.setCreatedUid(createUid);
			filesInfo.setCreatedUname(createUname);
			filesBiz.updateFiles(filesInfo);
		}

		//save　产品地址 url格式：产品类别|产品名称｜产品地址
		List<String> productUrlList = projectsInfo.getProductUrlList();
		for(String url: productUrlList){
			String tmp[] = url.split("|");
			ProjectProductInfo projectProductInfo = new ProjectProductInfo();
			projectProductInfo.setAddTime(now);
			projectProductInfo.setProjectId(id);
			projectProductInfo.setAddressType(tmp[0]);
			projectProductInfo.setProductName(tmp[1]);
			projectProductInfo.setProductAddress(tmp[2]);
			projectProductBiz.updateProjectProduct(projectProductInfo);
		}
		return messageInfo;
	}




	@RequestMapping("updateProject")
	@ResponseBody
	public MessageInfo<Long> updateProjects(ProjectsInfo projectsInfo){
		MessageInfo<Long> messageInfo = new MessageInfo<>();
		Long id = projectsInfo.getId();
		Long createUid = projectsInfo.getCreatedUid();

		if(id == null){
			messageInfo.setMessage("缺失项目id！");
			messageInfo.setStatus(10001);
			return messageInfo;
		}

		//验证表单项
		if(projectsInfo.getTitle()==null || projectsInfo.getIndustryId() ==null || projectsInfo.getIndustryName()==null
				||projectsInfo.getProductInfo()==null ||projectsInfo.getProductCompete() ==null
				||projectsInfo.getBpFile() ==null || projectsInfo.getProductLogo()==null || projectsInfo.getProjectPicList()==null){
			messageInfo.setMessage("必填项未填写完整!");
			messageInfo.setStatus(10001);
			return messageInfo;
		}

		projectsInfo = projectsBiz.queryById(id).getData();
		if(!projectsInfo.getCreatedUid().equals(createUid)){
			messageInfo.setMessage("只允许本人创建的项目！");
			messageInfo.setStatus(10001);
			return messageInfo;
		}

		List<String> labelList = projectsInfo.getLabelNameList();
		StringBuilder labelNames = new StringBuilder("");
		for(int i = 0;i<labelList.size();i++){
			labelNames.append(labelList.get(i));
			if(i>0 && i!= (labelList.size()-1)){
				labelNames.append(",");
			}
		}
		projectsInfo.setLabelNames(labelNames.toString());
		messageInfo = projectsBiz.updateProject(projectsInfo);
		Date now  = new Date();

		//update　项目图片
		List<String> projectPicList = projectsInfo.getProjectPicList();
		for(String pic: projectPicList){
			FilesInfo filesInfo = new FilesInfo();
			filesInfo.setRelationId(id);
			filesInfo.setFilePath(pic);
			filesInfo.setType(1);
			filesInfo.setAddTime(now);
			filesBiz.updateFiles(filesInfo);
		}

		//update　产品地址 url格式：产品类别|产品名称｜产品地址
		List<String> productUrlList = projectsInfo.getProductUrlList();
		for(String url: productUrlList){
			String tmp[] = url.split("|");
			ProjectProductInfo projectProductInfo = new ProjectProductInfo();
			projectProductInfo.setAddTime(now);
			projectProductInfo.setProjectId(id);
			projectProductInfo.setAddressType(tmp[0]);
			projectProductInfo.setProductName(tmp[1]);
			projectProductInfo.setProductAddress(tmp[2]);
			projectProductBiz.updateProjectProduct(projectProductInfo);
		}
		return messageInfo;
	}

	@RequestMapping("query")
	@ResponseBody
	public MessageInfo<QueryResultInfo<ProjectsInfo>> queryProjects (ProjectsQueryInfo projectsQueryInfo) {
		MessageInfo<QueryResultInfo<ProjectsInfo>> resultMessageInfo = projectsBiz.queryProjects(projectsQueryInfo);
		return resultMessageInfo;
	}

   /* @RequestMapping("get")
    @ResponseBody
	public MessageInfo<ProjectsInfo> getProjects( Long id ){
		MessageInfo<ProjectsInfo> messageInfo =  projectsBiz.getProjects(id);
		return messageInfo;
	}

    @RequestMapping("getAll")
    @ResponseBody
    public MessageInfo<List<ProjectsInfo>> getAllProjects(){
		MessageInfo<List<ProjectsInfo>>  messageInfo = projectsBiz.getAllProjects();
		return messageInfo;
	}*/

}
