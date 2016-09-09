
package com.gi.xm.platform.facede.impl;

import java.util.List;
import java.util.Date;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.gi.xm.platform.biz.ProjectPersonBiz;

import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;

import com.gi.xm.platform.view.ProjectPersonInfo;
import com.gi.xm.platform.view.ProjectPersonQueryInfo;


import com.gi.xm.platform.biz.common.Message;
import com.gi.xm.platform.biz.common.QueryResult;
import com.gi.xm.platform.pojo.ProjectPerson;
import com.gi.xm.platform.query.ProjectPersonQuery;


import com.gi.xm.platform.facede.ProjectPersonFacede;
import com.gi.xm.platform.facede.convertor.ProjectPersonConvertor;
import com.gi.xm.platform.facede.convertor.MessageConvertor;

@Service
public class ProjectPersonFacedeImpl implements ProjectPersonFacede {

	@Autowired
	private ProjectPersonBiz projectPersonBiz;
				
	public MessageInfo<Integer> deleteProjectPerson(Integer id){
		
		Message<Integer> message  = projectPersonBiz.deleteProjectPerson(id);
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;		
	}
		
    public MessageInfo<Integer> createProjectPerson(ProjectPersonInfo projectPersonInfo){
		
		ProjectPerson projectPerson = ProjectPersonConvertor.toProjectPerson(projectPersonInfo);
		Message<Integer> message  =  projectPersonBiz.createProjectPerson( projectPerson );
		MessageInfo<Integer> messageInfo  = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
	public MessageInfo<Integer> updateProjectPerson(ProjectPersonInfo projectPersonInfo){
		
		ProjectPerson projectPerson = ProjectPersonConvertor.toProjectPerson(projectPersonInfo);
		Message<Integer> message  =  projectPersonBiz.updateProjectPerson( projectPerson );
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
		public MessageInfo<ProjectPersonInfo> getProjectPerson( Integer id ){
		
		Message<ProjectPerson> message  = projectPersonBiz.getProjectPerson( id );
		MessageInfo<ProjectPersonInfo> messageInfo = MessageConvertor.toMessageInfo(message);
		ProjectPersonInfo projectPersonInfo = ProjectPersonConvertor.toProjectPersonInfo(message.getData());
		messageInfo.setData(projectPersonInfo);
		return messageInfo;
	}

    public MessageInfo<List<ProjectPersonInfo>> getAllProjectPerson(){
	
		Message<List<ProjectPerson>> message  = projectPersonBiz.getAllProjectPerson();
		MessageInfo<List<ProjectPersonInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<ProjectPersonInfo> projectPersonInfoList = ProjectPersonConvertor.toProjectPersonInfoList(message.getData());
		messageInfo.setData(projectPersonInfoList);
		return messageInfo;	
	}

	public MessageInfo<QueryResultInfo<ProjectPersonInfo>> queryProjectPerson(ProjectPersonQueryInfo projectPersonQueryInfo) {
		ProjectPersonQuery projectPersonQuery = ProjectPersonConvertor.toProjectPersonQuery(projectPersonQueryInfo);
		Message<QueryResult<ProjectPerson>> message = projectPersonBiz.queryProjectPerson(projectPersonQuery);
		MessageInfo<QueryResultInfo<ProjectPersonInfo>> messageInfo = new MessageInfo<QueryResultInfo<ProjectPersonInfo>>();
		QueryResultInfo<ProjectPersonInfo> queryResultInfo = ProjectPersonConvertor.toQueryResultInfo(message.getData());
		messageInfo.setData(queryResultInfo);
		return messageInfo;
	}
   
	
}