
package com.gi.xm.platform.facede.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;

import com.alibaba.dubbo.config.annotation.Service;
import com.gi.xm.platform.biz.LabelBiz;
import com.gi.xm.platform.biz.ProjectPersonBiz;
import com.gi.xm.platform.biz.ProjectPersonJobBiz;
import com.gi.xm.platform.biz.ProjectPersonStudyBiz;
import com.gi.xm.platform.biz.common.Message;
import com.gi.xm.platform.biz.common.QueryResult;
import com.gi.xm.platform.facede.ProjectPersonFacede;
import com.gi.xm.platform.facede.convertor.LabelConvertor;
import com.gi.xm.platform.facede.convertor.MessageConvertor;
import com.gi.xm.platform.facede.convertor.ProjectPersonConvertor;
import com.gi.xm.platform.facede.convertor.ProjectPersonJobConvertor;
import com.gi.xm.platform.facede.convertor.ProjectPersonStudyConvertor;
import com.gi.xm.platform.pojo.Label;
import com.gi.xm.platform.pojo.ProjectPerson;
import com.gi.xm.platform.pojo.ProjectPersonJob;
import com.gi.xm.platform.pojo.ProjectPersonStudy;
import com.gi.xm.platform.query.ProjectPersonQuery;
import com.gi.xm.platform.view.LabelInfo;
import com.gi.xm.platform.view.ProjectPersonInfo;
import com.gi.xm.platform.view.ProjectPersonJobInfo;
import com.gi.xm.platform.view.ProjectPersonQueryInfo;
import com.gi.xm.platform.view.ProjectPersonStudyInfo;
import com.gi.xm.platform.view.ProjectSearchTitleInfo;
import com.gi.xm.platform.view.common.Contants;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;

@Service
public class ProjectPersonFacedeImpl implements ProjectPersonFacede {

	@Autowired
	private ProjectPersonBiz projectPersonBiz;
	
	@Autowired
	private ProjectPersonStudyBiz studyBiz;
	
	@Autowired
	private LabelBiz labelBiz;
	
	@Autowired
	private ProjectPersonJobBiz jobBiz;
				
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
	@Cacheable(value = "projectPersonInfo",keyGenerator = "wiselyKeyGenerator")
	public MessageInfo<ProjectPersonInfo> getProjectPerson( Integer id ){
		
		Message<ProjectPerson> message  = projectPersonBiz.getProjectPerson( id );
		MessageInfo<ProjectPersonInfo> messageInfo = MessageConvertor.toMessageInfo(message);
		ProjectPersonInfo projectPersonInfo = ProjectPersonConvertor.toProjectPersonInfo(message.getData());
		
		messageInfo.setData(projectPersonInfo);
		return messageInfo;
	}

    @Cacheable(value = "projectPersonInfo",keyGenerator = "wiselyKeyGenerator")
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
	
	
	@Override
	public MessageInfo<List<ProjectPersonInfo>> queryPersonByProjectId(Integer projectId,Integer type) {
		MessageInfo<List<ProjectPersonInfo>> messageInfo = new MessageInfo<List<ProjectPersonInfo>>();;
		Message<List<ProjectPerson>> message  = projectPersonBiz.getPersonByProjectId(projectId,type);
		if (!message.isSuccess()){
			messageInfo = MessageConvertor.toMessageInfo(message);
			return messageInfo;
		}
		List<ProjectPersonInfo> personInfos = ProjectPersonConvertor.toProjectPersonInfoList(message.getData());
		
		List<Integer> idList = new ArrayList<Integer>();
		
		for(ProjectPersonInfo p : personInfos){		//查询personIdList
			idList.add(p.getId());
		}
		
		Message<List<ProjectPersonJob>> jobList = jobBiz.getPersonJobByPid(idList);		//in查询jobList
		if(!jobList.isSuccess()){
			messageInfo = MessageConvertor.toMessageInfo(jobList);
			return messageInfo;
		}
		Message<List<ProjectPersonStudy>> studyList = studyBiz.getStudyListByPid(idList);	//in查询学习经历
		if(!studyList.isSuccess()){
			messageInfo = MessageConvertor.toMessageInfo(studyList);
			return messageInfo;
		}
		Message<List<Label>> labelList = labelBiz.getListByTypeRelationId(Contants.LABEL_PERSON, idList);	//in tab
		if(!labelList.isSuccess()){
			messageInfo = MessageConvertor.toMessageInfo(labelList);
			return messageInfo;
		}
		
		List<ProjectPersonJobInfo> jobInfos = ProjectPersonJobConvertor.toProjectPersonJobInfoList(jobList.getData());
		List<ProjectPersonStudyInfo> studyInfos = ProjectPersonStudyConvertor.toProjectPersonStudyInfoList(studyList.getData());
		List<LabelInfo> labelInfos = LabelConvertor.toLabelInfoList(labelList.getData());
		
		for(ProjectPersonInfo p :personInfos){
			for(LabelInfo l:labelInfos){
				if((l.getRelationId().intValue()==p.getId().intValue())&&(l.getType().equals(Contants.LABEL_PERSON))){
					List<LabelInfo> labels = p.getLabelList();
					if(labels==null){
						labels = new ArrayList<>();
						p.setLabelList(labels);
					}
					labels.add(l);
				}
			}
			for(ProjectPersonJobInfo job :jobInfos){
				if(p.getId().intValue()==(job.getPersonId().intValue())){
					List<ProjectPersonJobInfo> jls = p.getJobList();
					if(jls==null){
						jls = new ArrayList<>();
						p.setJobList(jls);
					}
					jls.add(job);
				}
					
			}
				
			for(ProjectPersonStudyInfo study : studyInfos){
				if(p.getId().intValue()==(study.getPersonId().intValue())){
					List<ProjectPersonStudyInfo> studyls = p.getStudyList();
					if(studyls==null){
						studyls = new ArrayList<>();
						p.setStudyList(studyls);
					}
					studyls.add(study);
				}
					
			}
		}
		
		messageInfo.setData(personInfos);
		return messageInfo;
	}
	
	/*@Override
	public MessageInfo<List<ProjectPersonInfo>> queryPersonByProjectId(Integer projectId,Integer type) {
		MessageInfo<List<ProjectPersonInfo>> messageInfo = new MessageInfo<List<ProjectPersonInfo>>();;
		Message<List<ProjectPerson>> message  = projectPersonBiz.getPersonByProjectId(projectId,type);
		List<ProjectPerson> personList = message.getData();
		if(personList != null ){
			List<Integer> idList = new ArrayList<Integer>();
			
			for(ProjectPerson person : personList){		//查询personIdList
				idList.add(person.getId());
			}
			
			Message<List<ProjectPersonJob>> jobList = jobBiz.getPersonJobByPid(idList);		//in查询jobList
			Message<List<ProjectPersonStudy>> studyList = studyBiz.getStudyListByPid(idList);	//in查询学习经历
			Message<List<Label>> labelList = labelBiz.getListByTypeRelationId(Contants.LABEL_PERSON, idList);	//in查询学习经历
			
			List<ProjectPersonJob> newJobList = new ArrayList<ProjectPersonJob>();
			List<ProjectPersonStudy> newStudyList = new ArrayList<ProjectPersonStudy>();
			List<ProjectPerson> newPersonList = new ArrayList<ProjectPerson>();
			List<Label> newlabelList = new ArrayList<Label>();
			for(ProjectPerson person : personList){
				if(jobList != null && jobList.getData() !=null ){
					for(ProjectPersonJob job :jobList.getData()){
						if(person.getId().intValue()==(job.getPersonId().intValue())){
							newJobList.add(job);
						}
							
					}
					person.setJobList(newJobList);
				}
				
				if(studyList != null && studyList.getData() !=null ){
					for(ProjectPersonStudy study :studyList.getData()){
						if(person.getId().intValue()==(study.getPersonId().intValue())){
							newStudyList.add(study);
						}
							
					}
					person.setStudyList(newStudyList);
				}
				
				if(labelList != null && labelList.getData() !=null ){
					for(Label  label:labelList.getData()){
						if((person.getId().intValue()==label.getRelationId().intValue())&&(label.getType().equals(Contants.LABEL_PERSON))){
							newlabelList.add(label);
						}
							
					}
					person.setLabelList(newlabelList);
				}
				newPersonList.add(person);
			}
			message.setData(newPersonList);
			List<ProjectPersonInfo> projectPersonInfoList = ProjectPersonConvertor.toProjectPersonInfoList(message.getData());
			messageInfo.setData(projectPersonInfoList);
		}
		return messageInfo;
	}*/
	
}