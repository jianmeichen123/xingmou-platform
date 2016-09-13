
package com.gi.xm.platform.facede.impl;

import java.util.*;

import com.alibaba.dubbo.config.annotation.Service;
import com.gi.xm.platform.biz.DistrictBiz;
import com.gi.xm.platform.biz.IndustryBiz;
import com.gi.xm.platform.biz.RoundBiz;
import com.gi.xm.platform.facede.IndustryFacede;
import com.gi.xm.platform.facede.convertor.*;
import com.gi.xm.platform.pojo.District;
import com.gi.xm.platform.pojo.Industry;
import com.gi.xm.platform.pojo.Round;
import com.gi.xm.platform.view.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;

import com.gi.xm.platform.biz.ProjectBiz;

import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;


import com.gi.xm.platform.biz.common.Message;
import com.gi.xm.platform.biz.common.QueryResult;
import com.gi.xm.platform.pojo.Project;
import com.gi.xm.platform.query.ProjectQuery;


import com.gi.xm.platform.facede.ProjectFacede;

@Service
public class ProjectFacedeImpl implements ProjectFacede {

	@Autowired
	private ProjectBiz projectBiz;
    @Autowired
    private IndustryBiz industryBiz;
    @Autowired
    private RoundBiz roundBiz;
    @Autowired
    private DistrictBiz districtBiz;

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

    @Cacheable(value = "projectSearchTitleInfo",keyGenerator = "wiselyKeyGenerator")
	public MessageInfo<ProjectSearchTitleInfo> getProjectSearchTitleInfo(){

        MessageInfo<ProjectSearchTitleInfo> messageInfo = null;
        //行业
        Message<List<Industry>> m1 = industryBiz.getAllIndustry();
        if (!m1.isSuccess()){
            messageInfo = MessageConvertor.toMessageInfo(m1);
            return messageInfo;
        }
        //轮次
        Message<List<Round>> m2 = roundBiz.getListByType(1);
        if (!m2.isSuccess()){
            messageInfo = MessageConvertor.toMessageInfo(m2);
            return messageInfo;
        }
        //国内国家
        Message<List<District>> home = districtBiz.getListByTypeLevel(1,1);
        if (!home.isSuccess()){
            messageInfo = MessageConvertor.toMessageInfo(home);
            return messageInfo;
        }
        //国外
        Message<List<District>> outer = districtBiz.getListByTypeLevel(2,2);
        if (!home.isSuccess()) {
            messageInfo = MessageConvertor.toMessageInfo(home);
            return messageInfo;
        }
        //构建行业集合 start
        List<IndustryInfo> industryInfoList = IndustryConvertor.toIndustryInfoList(m1.getData());
        List<IndustryInfo> industryInfoFather = new ArrayList<>();
        Map<Integer,List<IndustryInfo>> industryInfoSons = new HashMap<>();
        for (IndustryInfo i :industryInfoList){
            if (i.getParentId()==0){
                industryInfoFather.add(i);
            }else {
                List<IndustryInfo> sons = industryInfoSons.get(i.getParentId());
                if (sons == null){
                    sons = new ArrayList<>();
                    industryInfoSons.put(i.getParentId(),sons);
                }
                sons.add(i);
            }
        }
        //构建行业集合 end

        //构建轮次 start
        List<RoundInfo> roundInfos = RoundConvertor.toRoundInfoList(m2.getData());
        List<RoundInfo> roundInfoFather = new ArrayList<>();
        Map<Long,List<RoundInfo>> roundInfoSons = new HashMap<>();
        for (RoundInfo r : roundInfos){
            if (r.getParentId()==0){
                roundInfoFather.add(r);
            }else {
                List<RoundInfo> sons = roundInfoSons.get(r.getParentId());
                if (sons == null){
                    sons = new ArrayList<>();
                    roundInfoSons.put(r.getParentId(),sons);
                }
                sons.add(r);
            }
        }
        ProjectSearchTitleInfo r = new ProjectSearchTitleInfo();

        r.setHome(DistrictConvertor.toDistrictInfoList(home.getData()));
        r.setOuter(DistrictConvertor.toDistrictInfoList(outer.getData()));
        r.setIndustryInfoFather(industryInfoFather);
        r.setIndustryInfoSon(industryInfoSons);
        r.setRoundInfoFather(roundInfoFather);
        r.setRoundInfoSon(roundInfoSons);
        messageInfo = new MessageInfo<>();
        messageInfo.setData(r);
        //构建轮次 end
		return messageInfo;
	}

    @Override
    public MessageInfo<QueryResultInfo<ProjectInfo>> searchProject(ProjectQueryInfo projectQueryInfo) {
        ProjectQuery projectQuery = ProjectConvertor.toProjectQuery(projectQueryInfo);
        Message<QueryResult<Project>> message = projectBiz.searchProject(projectQuery);
        MessageInfo<QueryResultInfo<ProjectInfo>> messageInfo = new MessageInfo<QueryResultInfo<ProjectInfo>>();
        QueryResultInfo<ProjectInfo> queryResultInfo = ProjectConvertor.toQueryResultInfo(message.getData());
        messageInfo.setData(queryResultInfo);
        return messageInfo;
    }

}