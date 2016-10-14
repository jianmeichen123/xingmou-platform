package com.gi.xm.platform.facede.convertor;
import java.util.ArrayList;
import java.util.List;

import java.util.Date;
import org.springframework.cglib.beans.BeanCopier;

import com.gi.xm.platform.view.ProjectPersonStudyInfo;
import com.gi.xm.platform.view.ProjectPersonStudyQueryInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.pojo.ProjectPersonStudy;
import com.gi.xm.platform.query.ProjectPersonStudyQuery;
import com.gi.xm.platform.biz.common.QueryResult;

public abstract class ProjectPersonStudyConvertor {

	private static final BeanCopier beanCopierForProjectPersonStudyInfo = BeanCopier.create(ProjectPersonStudy.class, ProjectPersonStudyInfo.class, false);
	private static final BeanCopier beanCopierForProjectPersonStudy = BeanCopier.create(ProjectPersonStudyInfo.class, ProjectPersonStudy.class, false);
	private static final BeanCopier beanCopierForProjectPersonStudyQuery = BeanCopier.create(ProjectPersonStudyQueryInfo.class, ProjectPersonStudyQuery.class, false);

	public static ProjectPersonStudyInfo toProjectPersonStudyInfo(ProjectPersonStudy projectPersonStudy)
	{
		if (projectPersonStudy == null) {
			return null;
		}
		ProjectPersonStudyInfo projectPersonStudyInfo = new ProjectPersonStudyInfo();
		beanCopierForProjectPersonStudyInfo.copy(projectPersonStudy, projectPersonStudyInfo, null);
		return projectPersonStudyInfo;
	}

	public static ProjectPersonStudy toProjectPersonStudy(ProjectPersonStudyInfo projectPersonStudyInfo)
	{
		ProjectPersonStudy projectPersonStudy = new ProjectPersonStudy();
		beanCopierForProjectPersonStudy.copy(projectPersonStudyInfo, projectPersonStudy, null);
		return projectPersonStudy;
	}

	public static List<ProjectPersonStudyInfo> toProjectPersonStudyInfoList(List<ProjectPersonStudy> projectPersonStudyList)
	{
		if (projectPersonStudyList == null || projectPersonStudyList.isEmpty()) {
			return null;
		}
		List<ProjectPersonStudyInfo> projectPersonStudyInfoList = new ArrayList<ProjectPersonStudyInfo>(projectPersonStudyList.size());
		for (ProjectPersonStudy projectPersonStudy : projectPersonStudyList) {
			projectPersonStudyInfoList.add(toProjectPersonStudyInfo(projectPersonStudy));
		}
		return projectPersonStudyInfoList;
	}

	public static List<ProjectPersonStudy> toProjectPersonStudyList(List<ProjectPersonStudyInfo> projectPersonStudyInfoList)
	{
		if (projectPersonStudyInfoList == null || projectPersonStudyInfoList.isEmpty()) {
			return null;
		}
		List<ProjectPersonStudy> projectPersonStudyList = new ArrayList<ProjectPersonStudy>(projectPersonStudyInfoList.size());
		for (ProjectPersonStudyInfo projectPersonStudyInfo : projectPersonStudyInfoList) {
			projectPersonStudyList.add(toProjectPersonStudy(projectPersonStudyInfo));
		}
		return projectPersonStudyList;
	}
	
	public static ProjectPersonStudyQuery toProjectPersonStudyQuery(ProjectPersonStudyQueryInfo projectPersonStudyQueryInfo)
	{
		if (projectPersonStudyQueryInfo== null) {
			return null;
		}
		ProjectPersonStudyQuery projectPersonStudyQuery = new ProjectPersonStudyQuery();
		beanCopierForProjectPersonStudyQuery.copy(projectPersonStudyQueryInfo, projectPersonStudyQuery, null);
		return projectPersonStudyQuery;
	}

	public static QueryResultInfo<ProjectPersonStudyInfo> toQueryResultInfo(QueryResult<ProjectPersonStudy> queryResult)
	{
		QueryResultInfo<ProjectPersonStudyInfo> queryResultInfo = new QueryResultInfo<ProjectPersonStudyInfo>();
		queryResultInfo.setPages(queryResult.getPages());
		queryResult.setRecords(queryResult.getRecords());
		queryResultInfo.setTotal(queryResult.getTotal());
		queryResultInfo.setRecords(toProjectPersonStudyInfoList(queryResult.getRecords()));
		return queryResultInfo;
	}
}