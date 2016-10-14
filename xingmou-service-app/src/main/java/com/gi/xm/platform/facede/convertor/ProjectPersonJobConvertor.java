package com.gi.xm.platform.facede.convertor;
import java.util.ArrayList;
import java.util.List;

import java.util.Date;
import org.springframework.cglib.beans.BeanCopier;

import com.gi.xm.platform.view.ProjectPersonJobInfo;
import com.gi.xm.platform.view.ProjectPersonJobQueryInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.pojo.ProjectPersonJob;
import com.gi.xm.platform.query.ProjectPersonJobQuery;
import com.gi.xm.platform.biz.common.QueryResult;

public abstract class ProjectPersonJobConvertor {

	private static final BeanCopier beanCopierForProjectPersonJobInfo = BeanCopier.create(ProjectPersonJob.class, ProjectPersonJobInfo.class, false);
	private static final BeanCopier beanCopierForProjectPersonJob = BeanCopier.create(ProjectPersonJobInfo.class, ProjectPersonJob.class, false);
	private static final BeanCopier beanCopierForProjectPersonJobQuery = BeanCopier.create(ProjectPersonJobQueryInfo.class, ProjectPersonJobQuery.class, false);

	public static ProjectPersonJobInfo toProjectPersonJobInfo(ProjectPersonJob projectPersonJob)
	{
		if (projectPersonJob == null) {
			return null;
		}
		ProjectPersonJobInfo projectPersonJobInfo = new ProjectPersonJobInfo();
		beanCopierForProjectPersonJobInfo.copy(projectPersonJob, projectPersonJobInfo, null);
		return projectPersonJobInfo;
	}

	public static ProjectPersonJob toProjectPersonJob(ProjectPersonJobInfo projectPersonJobInfo)
	{
		ProjectPersonJob projectPersonJob = new ProjectPersonJob();
		beanCopierForProjectPersonJob.copy(projectPersonJobInfo, projectPersonJob, null);
		return projectPersonJob;
	}

	public static List<ProjectPersonJobInfo> toProjectPersonJobInfoList(List<ProjectPersonJob> projectPersonJobList)
	{
		if (projectPersonJobList == null || projectPersonJobList.isEmpty()) {
			return null;
		}
		List<ProjectPersonJobInfo> projectPersonJobInfoList = new ArrayList<ProjectPersonJobInfo>(projectPersonJobList.size());
		for (ProjectPersonJob projectPersonJob : projectPersonJobList) {
			projectPersonJobInfoList.add(toProjectPersonJobInfo(projectPersonJob));
		}
		return projectPersonJobInfoList;
	}

	public static List<ProjectPersonJob> toProjectPersonJobList(List<ProjectPersonJobInfo> projectPersonJobInfoList)
	{
		if (projectPersonJobInfoList == null || projectPersonJobInfoList.isEmpty()) {
			return null;
		}
		List<ProjectPersonJob> projectPersonJobList = new ArrayList<ProjectPersonJob>(projectPersonJobInfoList.size());
		for (ProjectPersonJobInfo projectPersonJobInfo : projectPersonJobInfoList) {
			projectPersonJobList.add(toProjectPersonJob(projectPersonJobInfo));
		}
		return projectPersonJobList;
	}
	
	public static ProjectPersonJobQuery toProjectPersonJobQuery(ProjectPersonJobQueryInfo projectPersonJobQueryInfo)
	{
		if (projectPersonJobQueryInfo== null) {
			return null;
		}
		ProjectPersonJobQuery projectPersonJobQuery = new ProjectPersonJobQuery();
		beanCopierForProjectPersonJobQuery.copy(projectPersonJobQueryInfo, projectPersonJobQuery, null);
		return projectPersonJobQuery;
	}

	public static QueryResultInfo<ProjectPersonJobInfo> toQueryResultInfo(QueryResult<ProjectPersonJob> queryResult)
	{
		QueryResultInfo<ProjectPersonJobInfo> queryResultInfo = new QueryResultInfo<ProjectPersonJobInfo>();
		queryResultInfo.setPages(queryResult.getPages());
		queryResult.setRecords(queryResult.getRecords());
		queryResultInfo.setTotal(queryResult.getTotal());
		queryResultInfo.setRecords(toProjectPersonJobInfoList(queryResult.getRecords()));
		return queryResultInfo;
	}
}