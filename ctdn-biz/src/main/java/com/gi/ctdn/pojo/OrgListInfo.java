package com.gi.ctdn.pojo;


import java.util.List;

/**
 * Created by wanghao on 17-6-14.
 */
public class OrgListInfo extends OrgInfo {

    /**
     * @Fields orgMediaInfoList : 相关新闻
     */
    private List<OrgMediaInfo> orgMediaInfoList;

    /**
     * @Fields orgMemberInfoList : 机构成员
     */
    private List<OrgMemberInfo> orgMemberInfoList;

    /**
     * @Fields eventInfoList : 投资事件
     */
    private List<EventInfoExt> eventInfoExtList;

    private List<News> orgNewsList;

    public List<EventInfoExt> getEventInfoExtList() {
        return eventInfoExtList;
    }

    public void setEventInfoExtList(List<EventInfoExt> eventInfoExtList) {
        this.eventInfoExtList = eventInfoExtList;
    }

    /**
     * @Fields projectContactList : 联系方式
     */
    private List<ProjectContact> projectContactList;

    /**
     * @Fields orgHistoryInfoList : 发展历史
     */
    private List<OrgMediaInfo> orgHistoryInfoList;


    public List<OrgMember> getOrgMemberList() {
        return orgMemberList;
    }

    public void setOrgMemberList(List<OrgMember> orgMemberList) {
        this.orgMemberList = orgMemberList;
    }

    /**
     * @Fields orgMemberList : 机构成员

     */
    private List<OrgMember> orgMemberList;

    public List<OrgMediaInfo> getOrgHistoryInfoList() {
        return orgHistoryInfoList;
    }

    public void setOrgHistoryInfoList(List<OrgMediaInfo> orgHistoryInfoList) {
        this.orgHistoryInfoList = orgHistoryInfoList;
    }

    public List<OrgMemberInfo> getOrgMemberInfoList() {

        return orgMemberInfoList;
    }

    public void setOrgMemberInfoList(List<OrgMemberInfo> orgMemberInfoList) {
        this.orgMemberInfoList = orgMemberInfoList;
    }

    public List<OrgMediaInfo> getOrgMediaInfoList() {

        return orgMediaInfoList;
    }

    public void setOrgMediaInfoList(List<OrgMediaInfo> orgMediaInfoList) {
        this.orgMediaInfoList = orgMediaInfoList;
    }

    public List<ProjectContact> getProjectContactList() {
        return projectContactList;
    }

    public void setProjectContactList(List<ProjectContact> projectContactList) {
        this.projectContactList = projectContactList;
    }

    public List<News> getOrgNewsList() {
        return orgNewsList;
    }

    public void setOrgNewsList(List<News> orgNewsList) {
        this.orgNewsList = orgNewsList;
    }
}
