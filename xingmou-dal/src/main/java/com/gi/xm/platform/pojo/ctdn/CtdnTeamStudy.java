package com.gi.xm.platform.pojo.ctdn;

import java.util.Date;

/*
 *教育经历
 * Created by zcy on 17-2-16.
 */
public class CtdnTeamStudy extends CtdnPojo{

    /**
     * @Fields id :
     */
    private Long id;

    /**
     * @Fields memeberId :成员id
     */
    private Long memeberId;

    /**
     * @Fields schoolName :学校名
     */
    private String schoolName;

    /**
     * @Fields startDate :开始时间
     */
    private Date startDate;

    /**
     * @Fields startDate :结束时间
     */
    private Date endDate;

    /**
     * @Fields major :专业
     */
    private String major;

    /**
     * @Fields degree :学位
     */
    private String degree;

    /**
     * @Fields descrip :详情说明
     */
    private String descrip;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMemeberId() {
        return memeberId;
    }

    public void setMemeberId(Long memeberId) {
        this.memeberId = memeberId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }
}
