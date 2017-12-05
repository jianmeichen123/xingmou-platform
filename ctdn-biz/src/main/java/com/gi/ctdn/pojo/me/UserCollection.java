package com.gi.ctdn.pojo.me;

import com.gi.ctdn.pojo.OrgInfo;
import com.gi.ctdn.pojo.ProjectList;

import java.util.List;

/**
 * Created by zcy on 17-12-5.
 */
public class UserCollection {

    private Integer userId;

    private Integer type;

    private String code;

    private  Integer id;

    private List<ProjectList> projectList;

    private List<OrgInfo> orgInfoList;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<ProjectList> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<ProjectList> projectList) {
        this.projectList = projectList;
    }

    public List<OrgInfo> getOrgInfoList() {
        return orgInfoList;
    }

    public void setOrgInfoList(List<OrgInfo> orgInfoList) {
        this.orgInfoList = orgInfoList;
    }
}
