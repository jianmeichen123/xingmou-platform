package com.gi.xm.platform.pojo.ctdn;

import java.util.Date;

/**
 * 成员
 * Created by zcy on 17-2-16.
 */
public class CtdnTeam extends CtdnPojo{

    /**
     * @Fields id :
     */
    private Long id;

    /**
     * @Fields projectId :项目id
     */
    private Long projectId;

    /**
     * @Fields avatar :头像
     */
    private String avatar;

    /**
     * @Fields name :创始人姓名
     */
    private String  name;

    /**
     * @Fields gender :性别
     */
    private Integer  gender;

    /**
     * @Fields email 邮箱
     */
    private String email;

    /**
     * @Fields phone :电话
     */
    private String phone;

    /**
     * @Fields info :创始人简介
     */
    private String info;

    /**
     * @Fields isFounder :是否是创始人
     */
    private Integer isFounder;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Integer getIsFounder() {
        return isFounder;
    }

    public void setIsFounder(Integer isFounder) {
        this.isFounder = isFounder;
    }
}
