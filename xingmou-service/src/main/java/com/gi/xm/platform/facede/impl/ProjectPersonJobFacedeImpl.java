
package com.gi.xm.platform.facede.impl;

import java.util.List;
import java.util.Date;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.gi.xm.platform.biz.ProjectPersonJobBiz;

import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;

import com.gi.xm.platform.view.ProjectPersonJobInfo;
import com.gi.xm.platform.view.ProjectPersonJobQueryInfo;


import com.gi.xm.platform.biz.common.Message;
import com.gi.xm.platform.biz.common.QueryResult;
import com.gi.xm.platform.pojo.ProjectPersonJob;
import com.gi.xm.platform.query.ProjectPersonJobQuery;


import com.gi.xm.platform.facede.ProjectPersonJobFacede;
import com.gi.xm.platform.facede.convertor.ProjectPersonJobConvertor;
import com.gi.xm.platform.facede.convertor.MessageConvertor;

@Service
public class ProjectPersonJobFacedeImpl implements ProjectPersonJobFacede {

	@Autowired
	private ProjectPersonJobBiz projectPersonJobBiz;
				
	public MessageInfo<Integer> deleteProjectPersonJob(Long id){
		
		Message<Integer> message  = projectPersonJobBiz.deleteProjectPersonJob(id);
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;		
	}
		
    public MessageInfo<Long> createProjectPersonJob(ProjectPersonJobInfo projectPersonJobInfo){
		
		ProjectPersonJob projectPersonJob = ProjectPersonJobConvertor.toProjectPersonJob(projectPersonJobInfo);
		Message<Long> message  =  projectPersonJobBiz.createProjectPersonJob( projectPersonJob );
		MessageInfo<Long> messageInfo  = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
	public MessageInfo<Integer> updateProjectPersonJob(ProjectPersonJobInfo projectPersonJobInfo){
		
		ProjectPersonJob projectPersonJob = ProjectPersonJobConvertor.toProjectPersonJob(projectPersonJobInfo);
		Message<Integer> message  =  projectPersonJobBiz.updateProjectPersonJob( projectPersonJob );
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
		public MessageInfo<ProjectPersonJobInfo> getProjectPersonJob( Long id ){
		
		Message<ProjectPersonJob> message  = projectPersonJobBiz.getProjectPersonJob( id );
		MessageInfo<ProjectPersonJobInfo> messageInfo = MessageConvertor.toMessageInfo(message);
		ProjectPersonJobInfo projectPersonJobInfo = ProjectPersonJobConvertor.toProjectPersonJobInfo(message.getData());
		messageInfo.setData(projectPersonJobInfo);
		return messageInfo;
	}

    public MessageInfo<List<ProjectPersonJobInfo>> getAllProjectPersonJob(){
	
		Message<List<ProjectPersonJob>> message  = projectPersonJobBiz.getAllProjectPersonJob();
		MessageInfo<List<ProjectPersonJobInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<ProjectPersonJobInfo> projectPersonJobInfoList = ProjectPersonJobConvertor.toProjectPersonJobInfoList(message.getData());
		messageInfo.setData(projectPersonJobInfoList);
		return messageInfo;	
	}

	public MessageInfo<QueryResultInfo<ProjectPersonJobInfo>> queryProjectPersonJob(ProjectPersonJobQueryInfo projectPersonJobQueryInfo) {
		ProjectPersonJobQuery projectPersonJobQuery = ProjectPersonJobConvertor.toProjectPersonJobQuery(projectPersonJobQueryInfo);
		Message<QueryResult<ProjectPersonJob>> message = projectPersonJobBiz.queryProjectPersonJob(projectPersonJobQuery);
		MessageInfo<QueryResultInfo<ProjectPersonJobInfo>> messageInfo = new MessageInfo<QueryResultInfo<ProjectPersonJobInfo>>();
		QueryResultInfo<ProjectPersonJobInfo> queryResultInfo = ProjectPersonJobConvertor.toQueryResultInfo(message.getData());
		messageInfo.setData(queryResultInfo);
		return messageInfo;
	}
   
	
}