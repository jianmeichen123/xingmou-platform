package com.gi.xm.platform.facede;


import java.util.List;
import java.util.Date;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.view.ProjectPersonInfo;
import com.gi.xm.platform.view.ProjectPersonQueryInfo;

public interface ProjectPersonFacede {
		MessageInfo<Integer> deleteProjectPerson(Integer id);
		
    MessageInfo<Integer> createProjectPerson(ProjectPersonInfo projectPersonInfo);
		
	MessageInfo<Integer> updateProjectPerson(ProjectPersonInfo projectPersonInfo);
		
	MessageInfo<ProjectPersonInfo> getProjectPerson(Integer id);
		
    MessageInfo<List<ProjectPersonInfo>> getAllProjectPerson();
			
    MessageInfo<QueryResultInfo<ProjectPersonInfo>> queryProjectPerson(ProjectPersonQueryInfo projectPersonQueryInfo);
	
	

}