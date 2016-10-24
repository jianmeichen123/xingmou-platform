package com.gi.xm.platform.facede.query;


import java.util.List;
import java.util.Date;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.view.ProjectPersonInfo;
import com.gi.xm.platform.view.ProjectPersonQueryInfo;

public interface ProjectPersonFacede {

	MessageInfo<ProjectPersonInfo> getProjectPerson(Integer id);
		
    MessageInfo<List<ProjectPersonInfo>> getAllProjectPerson();
			
    MessageInfo<QueryResultInfo<ProjectPersonInfo>> queryProjectPerson(ProjectPersonQueryInfo projectPersonQueryInfo);

	/*MessageInfo<List<ProjectPersonInfo>> queryPersonByProjectId(Integer projectId, Integer type);*/

	MessageInfo<List<ProjectPersonInfo>> queryPersonList(ProjectPersonQueryInfo projectPersonQueryInfo);

	

}