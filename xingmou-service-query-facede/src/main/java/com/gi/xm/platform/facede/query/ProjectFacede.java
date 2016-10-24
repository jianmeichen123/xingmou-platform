package com.gi.xm.platform.facede.query;


import java.util.List;
import java.util.Date;

import com.gi.xm.platform.view.ProjectSearchTitleInfo;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.view.ProjectInfo;
import com.gi.xm.platform.view.ProjectQueryInfo;

public interface ProjectFacede {

	MessageInfo<ProjectInfo> getProject(Long id);
		
    MessageInfo<List<ProjectInfo>> getAllProject();
			
    MessageInfo<QueryResultInfo<ProjectInfo>> queryProject(ProjectQueryInfo projectQueryInfo);
	
		
	MessageInfo<List<ProjectInfo>> getListBySourceId(Long sourceId);

	MessageInfo<ProjectSearchTitleInfo> getProjectSearchTitleInfo();

	MessageInfo<QueryResultInfo<ProjectInfo>> searchProject(ProjectQueryInfo projectQueryInfo);

	MessageInfo<QueryResultInfo<ProjectInfo>> queryCompetationlist(ProjectQueryInfo projectQueryInfo);
}