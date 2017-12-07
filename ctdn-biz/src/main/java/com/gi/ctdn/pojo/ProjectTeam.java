package com.gi.ctdn.pojo;

import com.gi.ctdn.view.common.Pagination;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ProjectTeam  {

    /**
     * @Fields projectId : 项目ID
     */
    @ApiModelProperty(value = "项目code")
    private String projectCode;

    /**
     * @Fields code : code
     */
    @ApiModelProperty(value = "人员code,用于拼接头像地址")
    private String personCode;

    /**
     * @Fields projTitle : 项目名称
     */
    @ApiModelProperty(value = "项目名称")
    private String projTitle;

    /**
     * @Fields name : 姓名
     */
    @ApiModelProperty(value = "人员姓名")
    private String name;

    /**
     * @Fields job : 职务
     */
    @ApiModelProperty(value = "人员职务")
    private String job;

    /**
     * @Fields state : 状态
     */
    @ApiModelProperty(value = "人员状态:0 在职 1离职")
    private String state;

    /**
     * @Fields college : 大学
     */
    @ApiModelProperty(value = "毕业学校")
    private String college;

    /**
     * @Fields edu : 学历
     */
    @ApiModelProperty(value = "最高学历")
    private String edu;

    /**
     * @Fields introduction : 简介
     */
    @ApiModelProperty(value = "人员简介")
    private String introduction;

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public String getPersonCode() {
        return personCode;
    }

    public void setPersonCode(String personCode) {
        this.personCode = personCode;
    }

    public String getProjTitle() {
        return projTitle;
    }

    public void setProjTitle(String projTitle) {
        this.projTitle = projTitle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getEdu() {
        return edu;
    }

    public void setEdu(String edu) {
        this.edu = edu;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}