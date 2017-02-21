package com.gi.ctdn.restful.controller;


import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.ctdn.biz.CompanysBiz;
import com.gi.ctdn.biz.FilesBiz;
import com.gi.ctdn.biz.ProjectProductBiz;
import com.gi.ctdn.biz.ProjectsBiz;
import com.gi.ctdn.pojo.FilesInfo;
import com.gi.ctdn.pojo.ProjectProductInfo;
import com.gi.ctdn.pojo.ProjectsInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

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
		//check 表单必填项
		if(projectsInfo.getTitle()==null || projectsInfo.getIndustryId() ==null || projectsInfo.getIndustryName()==null
				||projectsInfo.getProductInfo()==null ||projectsInfo.getProductCompete() ==null
				||projectsInfo.getBpFile() ==null || projectsInfo.getProductLogo()==null || projectsInfo.getProjectPicList()==null){
			messageInfo.setMessage("必填项未填写完整!");
			messageInfo.setStatus(10001);
			return messageInfo;
		}
		Date now  = new Date();
		projectsInfo.setAddTime(now);
		messageInfo = projectsBiz.createProjects(projectsInfo);
		Long id = messageInfo.getData();

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

		//save　产品地址
		List<ProjectProductInfo> productList = projectsInfo.getProductList();
		for(ProjectProductInfo productInfo: productList){
			productInfo.setAddTime(now);
			productInfo.setProjectId(id);
			projectProductBiz.updateProjectProduct(productInfo);
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

		//check 表单必填项
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
		projectsInfo.setUpdateTime(new Date());
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
		List<ProjectProductInfo> productList = projectsInfo.getProductList();
		for(ProjectProductInfo productInfo: productList){
			productInfo.setAddTime(now);
			productInfo.setProjectId(id);
			projectProductBiz.updateProjectProduct(productInfo);
		}
		return messageInfo;
	}


	@RequestMapping("queryById")
	@ResponseBody
	public MessageInfo<ProjectsInfo> queryById (Long id) {
		MessageInfo<ProjectsInfo> messageInfo = new MessageInfo<ProjectsInfo>();
		if(id == null){
			messageInfo.setMessage("缺失项目id！");
			messageInfo.setStatus(10001);
			return messageInfo;
		}
		messageInfo  = projectsBiz.queryById(id);
		ProjectsInfo projectsInfo = messageInfo.getData();
		if(null != projectsInfo){
			List<ProjectProductInfo> projectProductInfoList = projectProductBiz.queryListByProjectId(id).getData();
			List<FilesInfo> filesInfoList = filesBiz.queryListByProjectId(id).getData();
			if(!filesInfoList.isEmpty()){
				List<String> projectPicList = new ArrayList<String>();
				for(FilesInfo filesInfo:filesInfoList){
					projectPicList.add(filesInfo.getFilePath());
				}
				projectsInfo.setProjectPicList(projectPicList);
			}
			projectsInfo.setProductList(projectProductInfoList);
			messageInfo.setData(projectsInfo);
		}else{
			messageInfo.setMessage("项目id 错误！");
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}

	/*@RequestMapping
	@ResponseBody
	public MessageInfo<QueryResultInfo<List<ProjectsInfo>>> */
}
