package com.gi.xm.platform.facede;


import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.view.ProjectInfo;
import com.gi.xm.platform.view.ProjectQueryInfo;

public interface ProjectFacede {

	MessageInfo<ProjectInfo> getProject(Long id);
		

    MessageInfo<QueryResultInfo<ProjectInfo>> queryProject(ProjectQueryInfo projectQueryInfo);
	

	MessageInfo<QueryResultInfo<ProjectInfo>> searchProject(ProjectQueryInfo projectQueryInfo);

}