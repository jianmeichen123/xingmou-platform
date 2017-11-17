package com.gi.ctdn.pojo;

import java.util.List;

/**
 * Created by wanghao on 17-7-17.
 */
public class ProjectBusinessListInfo extends ProjectBusinessInfo{

    /**
     * projectBusinessChangeList 工商变更集合
     */
    private List<ProjectBusinessChange> projectBusinessChangeList;

    /**
     * projectShareholderInfoList 股东信息集合
     */
    private List<ProjectShareholderInfo> projectShareholderInfoList;

    /**
     * projectContactList 联系方式
     */
    private List<ProjectContact> projectContactList;

    public List<ProjectBusinessChange> getProjectBusinessChangeList() {
        return projectBusinessChangeList;
    }

    public void setProjectBusinessChangeList(List<ProjectBusinessChange> projectBusinessChangeList) {
        this.projectBusinessChangeList = projectBusinessChangeList;
    }

    public List<ProjectShareholderInfo> getProjectShareholderInfoList() {
        return projectShareholderInfoList;
    }

    public void setProjectShareholderInfoList(List<ProjectShareholderInfo> projectShareholderInfoList) {
        this.projectShareholderInfoList = projectShareholderInfoList;
    }

    public List<ProjectContact> getProjectContactList() {
        return projectContactList;
    }

    public void setProjectContactList(List<ProjectContact> projectContactList) {
        this.projectContactList = projectContactList;
    }

}
