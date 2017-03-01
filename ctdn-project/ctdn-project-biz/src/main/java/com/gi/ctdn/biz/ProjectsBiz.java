

package com.gi.ctdn.biz;

import com.gi.ctdn.dao.ProjectsDAO;
import com.gi.ctdn.pojo.*;
import com.gi.ctdn.query.ProjectsQueryInfo;
import com.gi.ctdn.util.DateUtil;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("projectsBiz")
public class ProjectsBiz {


	private static final Logger LOGGER = LoggerFactory.getLogger(ProjectsBiz.class);

	@Autowired
	ProjectsDAO projectsDAO;
	@Autowired
	private FilesBiz  filesBiz;
	@Autowired
	private ProjectProductBiz projectProductBiz;
	@Autowired
	private CompanysBiz companysBiz;
	@Autowired
	private EventsBiz eventsBiz;

	@Transactional(propagation= Propagation.REQUIRED,rollbackFor=Exception.class)
	public MessageInfo<Long> createProjects(ProjectsInfo projects) {
		MessageInfo<Long> messageInfo = new MessageInfo<Long>();
		try {

			//set companyId
			CompanysInfo companysInfo = new CompanysInfo();
			companysInfo.setAddTime(DateUtil.getNow());
			companysInfo.setCreatedUid(projects.getCreatedUid());
			companysInfo.setCreatedUname(projects.getCreatedUname());
			Long companyId = companysBiz.createCompanys(companysInfo).getData();
			projects.setCompanyId(companyId);

			//save project
			projects.setAddTime(DateUtil.getNow());
			projectsDAO.insert(projects);

			//save　picList
			List<String> projectPicList = projects.getProjectPicList();
			for(String pic: projectPicList){
				FilesInfo filesInfo = new FilesInfo();
				filesInfo.setRelationId(messageInfo.getData());
				filesInfo.setFilePath(pic);
				filesInfo.setType(1);
				filesInfo.setAddTime(DateUtil.getNow());
				filesInfo.setCreatedUid(projects.getCreatedUid());
				filesInfo.setCreatedUname(projects.getCreatedUname());
				filesBiz.createFiles(filesInfo);
			}

			//save　projectUrl
			List<ProjectProductInfo> productList = projects.getProductList();
			for(ProjectProductInfo productInfo: productList){
				productInfo.setAddTime(DateUtil.getNow());
				productInfo.setProjectId(messageInfo.getData());
				projectProductBiz.createProjectProduct(productInfo);
			}
			messageInfo.setData(projects.getId());

		} catch (Exception e) {
			LOGGER.error("createProjects", "创建Projects失败", e);
			messageInfo.setStatus(10001);
			throw e;
		}
		return messageInfo;
	}

	@Transactional(propagation= Propagation.REQUIRED,rollbackFor=Exception.class)
	public  MessageInfo<Long> updateProject(ProjectsInfo projectsInfo) {
		MessageInfo<Long> messageInfo = new MessageInfo<Long>();
		try {

			projectsInfo.setUpdateTime(DateUtil.getNow());
			projectsDAO.update(projectsInfo);

			//update　项目图片
			List<String> projectPicList = projectsInfo.getProjectPicList();
			filesBiz.deleteByProjectId(projectsInfo.getId());
			for(String pic: projectPicList){
				FilesInfo filesInfo = new FilesInfo();
				filesInfo.setRelationId(projectsInfo.getId());
				filesInfo.setFilePath(pic);
				filesInfo.setType(1);
				filesInfo.setAddTime(DateUtil.getNow());
				filesBiz.createFiles(filesInfo);
			}

			//update　产品地址 url格式：产品类别|产品名称｜产品地址
			List<ProjectProductInfo> productList = projectsInfo.getProductList();
			projectProductBiz.deleteByProjectId(projectsInfo.getId());
			for(ProjectProductInfo productInfo: productList){
				productInfo.setAddTime(DateUtil.getNow());
				productInfo.setProjectId(projectsInfo.getId());
				projectProductBiz.createProjectProduct(productInfo);
			}
			messageInfo.setData(projectsInfo.getId());
		} catch (Exception e) {
			LOGGER.error("updateProject", "修改项目异常", e);
			messageInfo.setStatus(10001);
			throw e;
		}
		return messageInfo;
	}

	public MessageInfo<QueryResultInfo<ProjectsInfo>> queryProjects(ProjectsQueryInfo projectsQuery) {
		MessageInfo<QueryResultInfo<ProjectsInfo>> messageInfo = new MessageInfo<QueryResultInfo<ProjectsInfo>>();
		try {

			QueryResultInfo<ProjectsInfo> queryResult = new QueryResultInfo<ProjectsInfo>();
			PageHelper.startPage(projectsQuery.getPageIndex(), projectsQuery.getPageSize());
			String startDate = projectsQuery.getStartDate();
			String endDate = projectsQuery.getEndDate();
			if(startDate != null){
				projectsQuery.setStartLongTime(DateUtil.convertStringToDate(startDate.trim()).getTime());
			}
			if(endDate != null){
				projectsQuery.setEndLongTime(DateUtil.convertStringToDate(endDate.trim()).getTime());
			}
			List<ProjectsInfo> projectsList = projectsDAO.queryProjects(projectsQuery);
			if(!projectsList.isEmpty()){
				for(ProjectsInfo projectsInfo :projectsList){
					List<EventsInfo> eventsInfoList = eventsBiz.getListByProjectId(projectsInfo.getId()).getData();
					if(null != eventsInfoList && !eventsInfoList.isEmpty()){
						if(projectsInfo.getId().equals(eventsInfoList.get(0).getProjectId())){
							projectsInfo.setNewestEventMoney(eventsInfoList.get(0).getEventMoney());
							projectsInfo.setNewestInvestDate(eventsInfoList.get(0).getEventDate());
							projectsInfo.setNewestRoundName(eventsInfoList.get(0).getRoundName());
							projectsInfo.setCurrentName(eventsInfoList.get(0).getCurrencyName());
						}
					}
				}
			}
			PageInfo<ProjectsInfo> pageInfo = new PageInfo<ProjectsInfo>(projectsList);
			queryResult.setPages(pageInfo.getPages());
			queryResult.setTotal(pageInfo.getTotal());
			queryResult.setRecords(projectsList);
			messageInfo.setData(queryResult);
		} catch (Exception e) {
			LOGGER.error("queryProjects", "分页查询Projects失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}

	public MessageInfo<ProjectsInfo> queryById(Long id){
		MessageInfo<ProjectsInfo> messageInfo = new MessageInfo<ProjectsInfo>();
		try {
			ProjectsInfo projectsInfo = projectsDAO.queryById(id);
			if(null != projectsInfo){
				//查询产品地址列表
				List<ProjectProductInfo> projectProductInfoList = projectProductBiz.queryListByProjectId(id).getData();
				//查询项目图片
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
			messageInfo.setData(projectsInfo);
		} catch (Exception e) {
			LOGGER.error("queryById", "查询项目异常", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}


	@Transactional(propagation= Propagation.REQUIRED,rollbackFor=Exception.class)
	public MessageInfo<Integer>  delete(ProjectsQueryInfo queryInfo) {
		MessageInfo<Integer> messageInfo = new MessageInfo<Integer>();
		try {
			if(null == queryInfo.getId()){
				messageInfo.setMessage("项目id 缺失！");
				messageInfo.setStatus(10001);
			}
			ProjectsInfo info = projectsDAO.queryById(queryInfo.getId());
			if(!info.getCreatedUid().equals(queryInfo.getCreatedUid())){
				messageInfo.setMessage("当前操作人没有权限删除项目！");
				messageInfo.setStatus(10001);
			}
			Integer ret = projectsDAO.deteleById(queryInfo.getId());
			messageInfo.setData(ret);
		} catch (Exception e) {
			LOGGER.error("deleteById", "删除项目异常", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}

}
