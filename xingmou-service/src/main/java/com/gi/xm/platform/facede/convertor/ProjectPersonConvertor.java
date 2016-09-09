package com.gi.xm.platform.facede.convertor;
import java.util.ArrayList;
import java.util.List;

import java.util.Date;
import org.springframework.cglib.beans.BeanCopier;

import com.gi.xm.platform.view.ProjectPersonInfo;
import com.gi.xm.platform.view.ProjectPersonQueryInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.pojo.ProjectPerson;
import com.gi.xm.platform.query.ProjectPersonQuery;
import com.gi.xm.platform.biz.common.QueryResult;

public abstract class ProjectPersonConvertor {

	private static final BeanCopier beanCopierForProjectPersonInfo = BeanCopier.create(ProjectPerson.class, ProjectPersonInfo.class, false);
	private static final BeanCopier beanCopierForProjectPerson = BeanCopier.create(ProjectPersonInfo.class, ProjectPerson.class, false);
	private static final BeanCopier beanCopierForProjectPersonQuery = BeanCopier.create(ProjectPersonQueryInfo.class, ProjectPersonQuery.class, false);

	public static ProjectPersonInfo toProjectPersonInfo(ProjectPerson projectPerson)
	{
		if (projectPerson == null) {
			return null;
		}
		ProjectPersonInfo projectPersonInfo = new ProjectPersonInfo();
		beanCopierForProjectPersonInfo.copy(projectPerson, projectPersonInfo, null);
		return projectPersonInfo;
	}

	public static ProjectPerson toProjectPerson(ProjectPersonInfo projectPersonInfo)
	{
		ProjectPerson projectPerson = new ProjectPerson();
		beanCopierForProjectPerson.copy(projectPersonInfo, projectPerson, null);
		return projectPerson;
	}

	public static List<ProjectPersonInfo> toProjectPersonInfoList(List<ProjectPerson> projectPersonList)
	{
		if (projectPersonList == null || projectPersonList.isEmpty()) {
			return null;
		}
		List<ProjectPersonInfo> projectPersonInfoList = new ArrayList<ProjectPersonInfo>(projectPersonList.size());
		for (ProjectPerson projectPerson : projectPersonList) {
			projectPersonInfoList.add(toProjectPersonInfo(projectPerson));
		}
		return projectPersonInfoList;
	}

	public static List<ProjectPerson> toProjectPersonList(List<ProjectPersonInfo> projectPersonInfoList)
	{
		if (projectPersonInfoList == null || projectPersonInfoList.isEmpty()) {
			return null;
		}
		List<ProjectPerson> projectPersonList = new ArrayList<ProjectPerson>(projectPersonInfoList.size());
		for (ProjectPersonInfo projectPersonInfo : projectPersonInfoList) {
			projectPersonList.add(toProjectPerson(projectPersonInfo));
		}
		return projectPersonList;
	}
	
	public static ProjectPersonQuery toProjectPersonQuery(ProjectPersonQueryInfo projectPersonQueryInfo)
	{
		if (projectPersonQueryInfo== null) {
			return null;
		}
		ProjectPersonQuery projectPersonQuery = new ProjectPersonQuery();
		beanCopierForProjectPersonQuery.copy(projectPersonQueryInfo, projectPersonQuery, null);
		return projectPersonQuery;
	}

	public static QueryResultInfo<ProjectPersonInfo> toQueryResultInfo(QueryResult<ProjectPerson> queryResult)
	{
		QueryResultInfo<ProjectPersonInfo> queryResultInfo = new QueryResultInfo<ProjectPersonInfo>();
		queryResultInfo.setPages(queryResult.getPages());
		queryResult.setRecords(queryResult.getRecords());
		queryResultInfo.setTotal(queryResult.getTotal());
		queryResultInfo.setRecords(toProjectPersonInfoList(queryResult.getRecords()));
		return queryResultInfo;
	}
}