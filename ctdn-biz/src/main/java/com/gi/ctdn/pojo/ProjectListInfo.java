package com.gi.ctdn.pojo;

import java.util.List;

public class ProjectListInfo extends ProjectList {

	/**
	 * 冗余 事件列表
	 * @return
	 */
	private List<EventInfo> EventInfoList ;

	/**
	 * 冗余 并购事件列表
	 * @return
	 */
	private List<EventMergerInfo> eventMergerInfoList;

	/**
	 * 冗余 团队列表
	 * @return
	 */
	private List<ProjectTeam> projectTeamList;

	/**
	 * 上市挂牌
	 * @return
	 */
	private List<EventListedInfo> eventListedInfoList;

	/**
	 * 联系方式
	 * @return
	 */
	private List<ProjectContact> projectContactList;

	/**
	 * 相关新闻
	 * @return
	 */
	private List<ProjectMediaInfo> newsList;

	/**
	 * 发展历史
	 * @return
	 */
	private List<ProjectMediaInfo> historyList;

    /**
	 * 直接竞争对手
	 */
	private List<ProjectList> directCompetationlist;

	/**
	 * 间接竞争对手
	 */
	private List<ProjectList> indirectCompetationlist;


	public List<EventInfo> getEventInfoList() {
		return EventInfoList;
	}

	public void setEventInfoList(List<EventInfo> eventInfoList) {
		EventInfoList = eventInfoList;
	}

	public List<EventMergerInfo> getEventMergerInfoList() {
		return eventMergerInfoList;
	}

	public void setEventMergerInfoList(List<EventMergerInfo> eventMergerInfoList) {
		this.eventMergerInfoList = eventMergerInfoList;
	}
	public List<ProjectTeam> getProjectTeamList() {
		return projectTeamList;
	}

	public void setProjectTeamList(List<ProjectTeam> projectTeamList) {
		this.projectTeamList = projectTeamList;
	}

	public List<EventListedInfo> getEventListedInfoList() {
		return eventListedInfoList;
	}

	public void setEventListedInfoList(List<EventListedInfo> eventListedInfoList) {
		this.eventListedInfoList = eventListedInfoList;
	}
	public List<ProjectContact> getProjectContactList() {
		return projectContactList;
	}

	public void setProjectContactList(List<ProjectContact> projectContactList) {
		this.projectContactList = projectContactList;
	}
	public List<ProjectMediaInfo> getNewsList() {
		return newsList;
	}

	public void setNewsList(List<ProjectMediaInfo> newsList) {
		this.newsList = newsList;
	}

	public List<ProjectMediaInfo> getHistoryList() {
		return historyList;
	}

	public void setHistoryList(List<ProjectMediaInfo> historyList) {
		this.historyList = historyList;
	}

	public List<ProjectList> getDirectCompetationlist() {
		return directCompetationlist;
	}

	public void setDirectCompetationlist(List<ProjectList> directCompetationlist) {
		this.directCompetationlist = directCompetationlist;
	}

	public List<ProjectList> getIndirectCompetationlist() {
		return indirectCompetationlist;
	}

	public void setIndirectCompetationlist(List<ProjectList> indirectCompetationlist) {
		this.indirectCompetationlist = indirectCompetationlist;
	}
//
//	public ProjectListInfo(List<EventInfo> eventInfoList, List<EventMergerInfo> eventMergerInfoList, List<ProjectTeam> projectTeamList, List<EventListedInfo> eventListedInfoList, List<ProjectContact> projectContactList, List<ProjectMediaInfo> newsList, List<ProjectMediaInfo> historyList, List<ProjectList> directCompetationlist, List<ProjectList> indirectCompetationlist) {
//		EventInfoList = eventInfoList;
//		this.eventMergerInfoList = eventMergerInfoList;
//		this.projectTeamList = projectTeamList;
//		this.eventListedInfoList = eventListedInfoList;
//		this.projectContactList = projectContactList;
//		this.newsList = newsList;
//		this.historyList = historyList;
//		this.directCompetationlist = directCompetationlist;
//		this.indirectCompetationlist = indirectCompetationlist;
//	}
//	public ProjectListInfo(){}
}