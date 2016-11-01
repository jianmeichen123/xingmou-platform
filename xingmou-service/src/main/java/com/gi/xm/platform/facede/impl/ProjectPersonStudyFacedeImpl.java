
package com.gi.xm.platform.facede.impl;

import java.util.List;
import java.util.Date;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;

import com.gi.xm.platform.biz.ProjectPersonStudyBiz;

import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;

import com.gi.xm.platform.view.ProjectPersonStudyInfo;
import com.gi.xm.platform.view.ProjectPersonStudyQueryInfo;


import com.gi.xm.platform.biz.common.Message;
import com.gi.xm.platform.biz.common.QueryResult;
import com.gi.xm.platform.pojo.ProjectPersonStudy;
import com.gi.xm.platform.query.ProjectPersonStudyQuery;


import com.gi.xm.platform.facede.ProjectPersonStudyFacede;
import com.gi.xm.platform.facede.convertor.ProjectPersonStudyConvertor;
import com.gi.xm.platform.facede.convertor.MessageConvertor;

@Service
public class ProjectPersonStudyFacedeImpl implements ProjectPersonStudyFacede {

	@Autowired
	private ProjectPersonStudyBiz projectPersonStudyBiz;
				
	public MessageInfo<Integer> deleteProjectPersonStudy(Long id){
		
		Message<Integer> message  = projectPersonStudyBiz.deleteProjectPersonStudy(id);
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;		
	}
		
    public MessageInfo<Long> createProjectPersonStudy(ProjectPersonStudyInfo projectPersonStudyInfo){
		
		ProjectPersonStudy projectPersonStudy = ProjectPersonStudyConvertor.toProjectPersonStudy(projectPersonStudyInfo);
		Message<Long> message  =  projectPersonStudyBiz.createProjectPersonStudy( projectPersonStudy );
		MessageInfo<Long> messageInfo  = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
	public MessageInfo<Integer> updateProjectPersonStudy(ProjectPersonStudyInfo projectPersonStudyInfo){
		
		ProjectPersonStudy projectPersonStudy = ProjectPersonStudyConvertor.toProjectPersonStudy(projectPersonStudyInfo);
		Message<Integer> message  =  projectPersonStudyBiz.updateProjectPersonStudy( projectPersonStudy );
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}

	public MessageInfo<ProjectPersonStudyInfo> getProjectPersonStudy( Long id ){
		
		Message<ProjectPersonStudy> message  = projectPersonStudyBiz.getProjectPersonStudy( id );
		MessageInfo<ProjectPersonStudyInfo> messageInfo = MessageConvertor.toMessageInfo(message);
		ProjectPersonStudyInfo projectPersonStudyInfo = ProjectPersonStudyConvertor.toProjectPersonStudyInfo(message.getData());
		messageInfo.setData(projectPersonStudyInfo);
		return messageInfo;
	}

    public MessageInfo<List<ProjectPersonStudyInfo>> getAllProjectPersonStudy(){
	
		Message<List<ProjectPersonStudy>> message  = projectPersonStudyBiz.getAllProjectPersonStudy();
		MessageInfo<List<ProjectPersonStudyInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<ProjectPersonStudyInfo> projectPersonStudyInfoList = ProjectPersonStudyConvertor.toProjectPersonStudyInfoList(message.getData());
		messageInfo.setData(projectPersonStudyInfoList);
		return messageInfo;	
	}

	public MessageInfo<QueryResultInfo<ProjectPersonStudyInfo>> queryProjectPersonStudy(ProjectPersonStudyQueryInfo projectPersonStudyQueryInfo) {
		ProjectPersonStudyQuery projectPersonStudyQuery = ProjectPersonStudyConvertor.toProjectPersonStudyQuery(projectPersonStudyQueryInfo);
		Message<QueryResult<ProjectPersonStudy>> message = projectPersonStudyBiz.queryProjectPersonStudy(projectPersonStudyQuery);
		MessageInfo<QueryResultInfo<ProjectPersonStudyInfo>> messageInfo = new MessageInfo<QueryResultInfo<ProjectPersonStudyInfo>>();
		QueryResultInfo<ProjectPersonStudyInfo> queryResultInfo = ProjectPersonStudyConvertor.toQueryResultInfo(message.getData());
		messageInfo.setData(queryResultInfo);
		return messageInfo;
	}
   
	
}