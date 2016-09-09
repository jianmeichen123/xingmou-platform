package com.gi.xm.platform.facede;


import java.util.List;
import java.util.Date;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.view.ProjectPersonJobInfo;
import com.gi.xm.platform.view.ProjectPersonJobQueryInfo;

public interface ProjectPersonJobFacede {
		MessageInfo<Integer> deleteProjectPersonJob(Long id);
		
    MessageInfo<Long> createProjectPersonJob(ProjectPersonJobInfo projectPersonJobInfo);
		
	MessageInfo<Integer> updateProjectPersonJob(ProjectPersonJobInfo projectPersonJobInfo);
		
	MessageInfo<ProjectPersonJobInfo> getProjectPersonJob(Long id);
		
    MessageInfo<List<ProjectPersonJobInfo>> getAllProjectPersonJob();
			
    MessageInfo<QueryResultInfo<ProjectPersonJobInfo>> queryProjectPersonJob(ProjectPersonJobQueryInfo projectPersonJobQueryInfo);
	
	

}