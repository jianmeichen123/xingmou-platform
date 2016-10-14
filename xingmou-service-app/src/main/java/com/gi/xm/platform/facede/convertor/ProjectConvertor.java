package com.gi.xm.platform.facede.convertor;
import java.util.ArrayList;
import java.util.List;

import java.util.Date;
import org.springframework.cglib.beans.BeanCopier;

import com.gi.xm.platform.view.ProjectInfo;
import com.gi.xm.platform.view.ProjectQueryInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.pojo.Project;
import com.gi.xm.platform.query.ProjectQuery;
import com.gi.xm.platform.biz.common.QueryResult;

public abstract class ProjectConvertor {

	private static final BeanCopier beanCopierForProjectInfo = BeanCopier.create(Project.class, ProjectInfo.class, false);
	private static final BeanCopier beanCopierForProject = BeanCopier.create(ProjectInfo.class, Project.class, false);
	private static final BeanCopier beanCopierForProjectQuery = BeanCopier.create(ProjectQueryInfo.class, ProjectQuery.class, false);

	public static ProjectInfo toProjectInfo(Project project)
	{
		if (project == null) {
			return null;
		}
		ProjectInfo projectInfo = new ProjectInfo();
		beanCopierForProjectInfo.copy(project, projectInfo, null);
		return projectInfo;
	}

	public static Project toProject(ProjectInfo projectInfo)
	{
		Project project = new Project();
		beanCopierForProject.copy(projectInfo, project, null);
		return project;
	}

	public static List<ProjectInfo> toProjectInfoList(List<Project> projectList)
	{
		if (projectList == null || projectList.isEmpty()) {
			return null;
		}
		List<ProjectInfo> projectInfoList = new ArrayList<ProjectInfo>(projectList.size());
		for (Project project : projectList) {
			projectInfoList.add(toProjectInfo(project));
		}
		return projectInfoList;
	}

	public static List<Project> toProjectList(List<ProjectInfo> projectInfoList)
	{
		if (projectInfoList == null || projectInfoList.isEmpty()) {
			return null;
		}
		List<Project> projectList = new ArrayList<Project>(projectInfoList.size());
		for (ProjectInfo projectInfo : projectInfoList) {
			projectList.add(toProject(projectInfo));
		}
		return projectList;
	}
	
	public static ProjectQuery toProjectQuery(ProjectQueryInfo projectQueryInfo)
	{
		if (projectQueryInfo== null) {
			return null;
		}
		ProjectQuery projectQuery = new ProjectQuery();
		beanCopierForProjectQuery.copy(projectQueryInfo, projectQuery, null);
		return projectQuery;
	}

	public static QueryResultInfo<ProjectInfo> toQueryResultInfo(QueryResult<Project> queryResult)
	{
		QueryResultInfo<ProjectInfo> queryResultInfo = new QueryResultInfo<ProjectInfo>();
		queryResultInfo.setPages(queryResult.getPages());
		queryResult.setRecords(queryResult.getRecords());
		queryResultInfo.setTotal(queryResult.getTotal());
		queryResultInfo.setRecords(toProjectInfoList(queryResult.getRecords()));
		return queryResultInfo;
	}
}