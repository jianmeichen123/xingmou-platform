
package com.gi.xm.platform.facede.impl;

import java.util.List;
import java.util.Date;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;

import com.gi.xm.platform.biz.ProjectBiz;

import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;

import com.gi.xm.platform.view.ProjectInfo;
import com.gi.xm.platform.view.ProjectQueryInfo;


import com.gi.xm.platform.biz.common.Message;
import com.gi.xm.platform.biz.common.QueryResult;
import com.gi.xm.platform.pojo.Project;
import com.gi.xm.platform.query.ProjectQuery;


import com.gi.xm.platform.facede.ProjectFacede;
import com.gi.xm.platform.facede.convertor.ProjectConvertor;
import com.gi.xm.platform.facede.convertor.MessageConvertor;

@Service
public class ProjectFacedeImpl implements ProjectFacede {

	@Autowired
	private ProjectBiz projectBiz;
				
	public MessageInfo<Integer> deleteProject(Long id){
		
		Message<Integer> message  = projectBiz.deleteProject(id);
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;		
	}
		
    public MessageInfo<Long> createProject(ProjectInfo projectInfo){
		
		Project project = ProjectConvertor.toProject(projectInfo);
		Message<Long> message  =  projectBiz.createProject( project );
		MessageInfo<Long> messageInfo  = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
	public MessageInfo<Integer> updateProject(ProjectInfo projectInfo){
		
		Project project = ProjectConvertor.toProject(projectInfo);
		Message<Integer> message  =  projectBiz.updateProject( project );
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
		public MessageInfo<Integer> changeStatus(
			Long id,
			Integer status,
			String operatorId){
			
		Message<Integer> message  = projectBiz.changeStatus(id,status,operatorId);
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
		@Cacheable(value = "projectInfo",keyGenerator = "wiselyKeyGenerator")
	public MessageInfo<ProjectInfo> getProject( Long id ){
		
		Message<Project> message  = projectBiz.getProject( id );
		MessageInfo<ProjectInfo> messageInfo = MessageConvertor.toMessageInfo(message);
		ProjectInfo projectInfo = ProjectConvertor.toProjectInfo(message.getData());
		messageInfo.setData(projectInfo);
		return messageInfo;
	}

    @Cacheable(value = "projectInfo",keyGenerator = "wiselyKeyGenerator")
    public MessageInfo<List<ProjectInfo>> getAllProject(){
	
		Message<List<Project>> message  = projectBiz.getAllProject();
		MessageInfo<List<ProjectInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<ProjectInfo> projectInfoList = ProjectConvertor.toProjectInfoList(message.getData());
		messageInfo.setData(projectInfoList);
		return messageInfo;	
	}

	public MessageInfo<QueryResultInfo<ProjectInfo>> queryProject(ProjectQueryInfo projectQueryInfo) {
		ProjectQuery projectQuery = ProjectConvertor.toProjectQuery(projectQueryInfo);
		Message<QueryResult<Project>> message = projectBiz.queryProject(projectQuery);
		MessageInfo<QueryResultInfo<ProjectInfo>> messageInfo = new MessageInfo<QueryResultInfo<ProjectInfo>>();
		QueryResultInfo<ProjectInfo> queryResultInfo = ProjectConvertor.toQueryResultInfo(message.getData());
		messageInfo.setData(queryResultInfo);
		return messageInfo;
	}
   
		


	public MessageInfo<List<ProjectInfo>> getListBySourceId(Long sourceId){
	
		Message<List<Project>> message  = projectBiz.getListBySourceId(sourceId);
		MessageInfo<List<ProjectInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<ProjectInfo> projectInfoList = ProjectConvertor.toProjectInfoList(message.getData());
		messageInfo.setData(projectInfoList);
		return messageInfo;	
	}
		
}