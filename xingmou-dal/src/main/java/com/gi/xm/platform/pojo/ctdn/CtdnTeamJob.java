package com.gi.xm.platform.pojo.ctdn;

import java.util.Date;

/*
 *工作经历
 * Created by zcy on 17-2-16.
 */
public class CtdnTeamJob extends CtdnPojo{

    /**
     * @Fields id :
     */
    private Long id;

    /**
     * @Fields memeberId :成员id
     */
    private Long memeberId;

    /**
     * @Fields companyName :公司名
     */
    private String companyName;

    /**
     * @Fields companyUrl :公司网址
     *
     */
    private String  companyUrl;

    /**
     * @Fields position 职位
     */
    private String position;

    /**
     * @Fields startDate :开始时间
     */
    private Date startDate;

    /**
     * @Fields startDate :结束时间
     */
    private Date endDate;

    /**
     * @Fields descrip :工作描述
     */
    private String descrip;

    /**
     * @Fields currencyId :货币ｉd
     */
    private Integer currencyId;

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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyUrl() {
        return companyUrl;
    }

    public void setCompanyUrl(String companyUrl) {
        this.companyUrl = companyUrl;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public Integer getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Integer currencyId) {
        this.currencyId = currencyId;
    }
}
