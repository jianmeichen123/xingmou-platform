

package com.gi.ctdn.biz;

import com.gi.ctdn.dao.*;
import com.gi.ctdn.pojo.*;
import com.gi.ctdn.view.common.MessageInfo;
import com.gi.ctdn.view.common.MessageStatus;
import com.gi.ctdn.view.common.Pagination;
import com.gi.ctdn.view.common.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("projectListBiz")
public class ProjectListBiz {


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


	public MessageInfo<ProjectListInfo> getRelativeListByCode(String code) {
		MessageInfo<ProjectListInfo> messageInfo = new MessageInfo<ProjectListInfo>();
		try {
			ProjectListInfo projectListInfo = getOneByCode(code);
			if (projectListInfo != null) {
				List<EventInfo> eventInfoList = eventInfoDAO.selectBySourceCode(code);
				List<ProjectMediaInfo> historyList = projectMediaInfoDAO.selectBySourceCodeAndType(code, "H");
				List<EventMergerInfo> eventMergerInfoList = eventMergerInfoDAO.selectBySourceCode(code);
				List<ProjectContact> projectContactList = projectContactDAO.selectByProjectCode(code);
				List<EventListedInfo> eventListedInfoList = eventListedInfoDAO.selectBySourceCode(code);
				List<ProjectMediaInfo> newsList = projectMediaInfoDAO.selectBySourceCodeAndType(code, "N");

				projectListInfo.setEventInfoList(eventInfoList);
				projectListInfo.setHistoryList(historyList);
				projectListInfo.setEventListedInfoList(eventListedInfoList);
				projectListInfo.setEventMergerInfoList(eventMergerInfoList);
				projectListInfo.setProjectContactList(projectContactList);
				if(newsList.size()>10){
					List<ProjectMediaInfo> limitNewsList =new ArrayList<>(newsList.subList(0,10));
					projectListInfo.setNewsList(limitNewsList);
				}else{
					projectListInfo.setNewsList(newsList);
				}
			}
			messageInfo.setData(projectListInfo);
		} catch (Exception e) {
			LOGGER.error("getListByCode", "查询ProjectList失败", e);
			messageInfo.setStatus(MessageStatus.ERROR_CODE);
		}
		return messageInfo;
	}

	public MessageInfo<ProjectListInfo> queryCompetationlist(String sourceCode) {

		MessageInfo<ProjectListInfo> message = new MessageInfo<ProjectListInfo>();
		try {
			ProjectListInfo projectListInfo = getOneByCode(sourceCode);
			if(projectListInfo != null){
				List<ProjectList> directCompetationlist = getNewsList(sourceCode,1);
				List<ProjectList> indirectCompetationlist = getNewsList(sourceCode,0);
				projectListInfo.setDirectCompetationlist(directCompetationlist);
				projectListInfo.setIndirectCompetationlist(indirectCompetationlist);
			}
			message.setData(projectListInfo);
		} catch (Exception e) {
			LOGGER.error("queryCompetationlist", "查询竞争对手失败", e);
			message.setStatus(MessageStatus.ERROR_CODE);
		}
		return message;
	}


	private List<ProjectList> getNewsList(String sourceCode, Integer isSame) {
		List<ProjectList> newList = new ArrayList<>();
		//查询竞品列表
		List<ProjectList> pList = projectListDAO.queryCompetationlist(sourceCode, isSame);
		if (pList != null && !pList.isEmpty()) {
			List<ProjectList> cList = projectListDAO.queryCompetitiveSimilar(sourceCode, isSame);
			for (ProjectList s : cList) {
				String code = s.getProjCode();
				Double similar = s.getSimilarity();
				for (ProjectList p : pList) {
					if (code.equals(p.getProjCode())) {
						p.setSimilarity(similar);
						newList.add(p);
					}
				}
			}
		}
		return newList;
	}

	public ProjectListInfo getOneByCode(String code){
		ProjectListInfo projectListInfo = projectListDAO.selectByCode(code);
		return projectListInfo;
	}

	public List<ProjectList> getByFinanceDate(){

		List<ProjectList> projectLists = projectListDAO.selectByFinanceDate();
		return projectLists;
	}

	public MessageInfo<List> getByProjName(String projTitle){
		MessageInfo<List> message = new MessageInfo();
		try {
			List<ProjectList> projectLists = projectListDAO.selectByName(projTitle);
			message.setData(projectLists);
		} catch (Exception e) {
			LOGGER.error("getByProjName", "查询项目列表失败", e);
			message.setStatus(MessageStatus.ERROR_CODE);
		}
		return message;
	}

	public Result queryProjectLists(ProjectList projectList){
		Result result;
		try {
			PageHelper.startPage(projectList.getPageNo(), projectList.getPageSize());
			List<ProjectList> projectLists = projectListDAO.selectListByCode(projectList.getCompCode());
			PageInfo<ProjectList> pageInfo = new PageInfo<ProjectList>(projectLists);
			Pagination page = new Pagination();
			page.setTotal(pageInfo.getTotal());
			page.setRecords(projectLists);
			result = new Result(MessageStatus.OK_MESSAGE, MessageStatus.OK_CODE, page);
		} catch (Exception e) {
			LOGGER.error("querycompSubList","查询CompSub失败", e);
			return Result.addError();
		}
		return result;
	}

}