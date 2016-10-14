package com.gi.xm.platform.facede;


import java.util.List;
import java.util.Date;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.view.ProjectPersonInfo;
import com.gi.xm.platform.view.ProjectPersonQueryInfo;

public interface ProjectPersonFacede {

    MessageInfo<QueryResultInfo<ProjectPersonInfo>> queryProjectPerson(ProjectPersonQueryInfo projectPersonQueryInfo);



}