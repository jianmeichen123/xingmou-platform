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
    private List<EventInfo> eventInfoList;

    /**
     * @Fields projectContactList : 联系方式
     */
    private List<ProjectContact> projectContactList;



    public List<EventInfo> getEventInfoList() {
        return eventInfoList;
    }

    public void setEventInfoList(List<EventInfo> eventInfoList) {
        this.eventInfoList = eventInfoList;
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
}
