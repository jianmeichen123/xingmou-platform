package com.gi.xm.platform.facede.query;


import java.util.List;
import java.util.Date;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.view.ProjectPersonStudyInfo;
import com.gi.xm.platform.view.ProjectPersonStudyQueryInfo;

public interface ProjectPersonStudyFacede {

	MessageInfo<ProjectPersonStudyInfo> getProjectPersonStudy(Long id);
		
    MessageInfo<List<ProjectPersonStudyInfo>> getAllProjectPersonStudy();
			
    MessageInfo<QueryResultInfo<ProjectPersonStudyInfo>> queryProjectPersonStudy(ProjectPersonStudyQueryInfo projectPersonStudyQueryInfo);
	
	

}