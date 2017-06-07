

package com.gi.ctdn.biz;

import com.gi.ctdn.dao.*;
import com.gi.ctdn.pojo.*;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.MessageStatus;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("projectListBiz")
public class ProjectListBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(ProjectListBiz.class);

    @Autowired
	ProjectListDAO projectListDAO;

    @Autowired
	ProjectContactDAO projectContactDAO;

    @Autowired
	ProjectMediaInfoDAO projectMediaInfoDAO;

    @Autowired
	EventListedInfoDAO eventListedInfoDAO;

    @Autowired
	EventMergerInfoDAO eventMergerInfoDAO;

    @Autowired
	EventInfoDAO eventInfoDAO;

    @Autowired
	ProjectTeamDAO projectTeamDAO;


	public MessageInfo<ProjectList> getOneByCode(String code){
		MessageInfo<ProjectList> messageInfo = new  MessageInfo<ProjectList>();
		try {
			ProjectList projectList = projectListDAO.selectByCode(code);
			if(projectList != null){
				List<EventInfo> eventInfoList = eventInfoDAO.selectBySourceCode(code);
				List<ProjectTeam> projectTeamList = projectTeamDAO.selectBySourcecode(code);
				List<ProjectMediaInfo> historyList = projectMediaInfoDAO.selectBySourceCodeAndType(code,"H");
				List<EventMergerInfo> eventMergerInfoList = eventMergerInfoDAO.selectBySourceCode(code);
				List<ProjectContact> projectContactList = projectContactDAO.selectBySourceCode(code);
				List<EventListedInfo> eventListedInfoList = eventListedInfoDAO.selectBySourceCode(code);
				List<ProjectMediaInfo> newsList = projectMediaInfoDAO.selectBySourceCodeAndType(code,"N");

				projectList.setEventInfoList(eventInfoList);
				projectList.setProjectTeamList(projectTeamList);
				projectList.setHistoryList(historyList);
				projectList.setEventListedInfoList(eventListedInfoList);
				projectList.setEventMergerInfoList(eventMergerInfoList);
				projectList.setProjectContactList(projectContactList);
				projectList.setNewsList(newsList);
			}
			messageInfo.setData(projectList);
		} catch (Exception e) {
			LOGGER.error("getListByCode","查询ProjectList失败", e);
			messageInfo.setStatus(MessageStatus.ERROR_CODE);
		}
		return messageInfo;
	}

	public MessageInfo<QueryResultInfo<ProjectList>> queryCompetationlist(ProjectList projectQuery) {
		MessageInfo<QueryResultInfo<ProjectList>> message = new MessageInfo<QueryResultInfo<ProjectList>>();
		try {
			QueryResultInfo<ProjectList> queryResult = new QueryResultInfo<ProjectList>();
			List<ProjectList> newList =  new ArrayList<>();
			//查询竞品列表
			List<ProjectList> pList = projectListDAO.queryCompetationlist(projectQuery);
			if(pList != null && !pList.isEmpty()){
				List<ProjectList> cList =  projectListDAO.queryCompetitiveSimilar(projectQuery);
				for(ProjectList s :cList){
					String code = s.getCode();
					Double similar = s.getSimilarity();
					for(ProjectList p :pList){
						if(code.equals(p.getCode())){
							p.setSimilarity(similar);
							newList.add(p);
						}
					}
				}
			}
			queryResult.setRecords(newList);
			message.setData(queryResult);
		} catch (Exception e) {
			LOGGER.error("queryProject", "分页查询Project失败", e);
			message.setStatus(MessageStatus.ERROR_CODE);
		}
		return message;
	}
}