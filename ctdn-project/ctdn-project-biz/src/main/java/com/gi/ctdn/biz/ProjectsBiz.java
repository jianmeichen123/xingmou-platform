

package com.gi.ctdn.biz;

import com.gi.ctdn.dao.ProjectsDAO;
import com.gi.ctdn.pojo.CompanysInfo;
import com.gi.ctdn.pojo.ProjectsInfo;
import com.gi.ctdn.query.ProjectsQueryInfo;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("projectsBiz")
public class ProjectsBiz {


	private static final Logger LOGGER = LoggerFactory.getLogger(ProjectsBiz.class);

	@Autowired
	ProjectsDAO projectsDAO;
	@Reference
	private FilesBiz  filesBiz;
	@Reference
	private ProjectProductBiz projectProductBiz;
	@Reference
	private CompanysBiz companysBiz;


	public MessageInfo<Long> createProjects(ProjectsInfo projects) {
		MessageInfo<Long> messageInfo = new MessageInfo<Long>();
		try {

			//set companyId
			CompanysInfo companysInfo = new CompanysInfo();
			companysInfo.setAddTime(new Date());
			companysInfo.setCreatedUid(projects.getCreatedUid());
			companysInfo.setCreatedUname(projects.getCreatedUname());
			Long companyId = companysBiz.createCompanys(companysInfo).getData();
			projects.setCompanyId(companyId);

			projectsDAO.insert(projects);
			messageInfo.setData(projects.getId());
		} catch (RuntimeException e) {
			LOGGER.error("createProjects", "创建Projects失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}


	public MessageInfo<QueryResultInfo<ProjectsInfo>> queryProjects(ProjectsQueryInfo projectsQuery) {
		MessageInfo<QueryResultInfo<ProjectsInfo>> messageInfo = new MessageInfo<QueryResultInfo<ProjectsInfo>>();
		try {
			QueryResultInfo<ProjectsInfo> queryResult = new QueryResultInfo<ProjectsInfo>();
			PageHelper.startPage(projectsQuery.getPageIndex(), projectsQuery.getPageSize());
			List<ProjectsInfo> projectsList = projectsDAO.queryProjects(projectsQuery);
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
			ProjectsInfo projectsInfo = projectsDAO.getById(id);
			messageInfo.setData(projectsInfo);
		} catch (Exception e) {
			LOGGER.error("queryById", "查询项目异常", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}

	public  MessageInfo<Long> updateProject(ProjectsInfo projectsInfo) {
		MessageInfo<Long> messageInfo = new MessageInfo<Long>();
		try {
			Long id = projectsDAO.update(projectsInfo);
			messageInfo.setData(id);
		} catch (Exception e) {
			LOGGER.error("updateProject", "修改项目异常", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}

}
