package com.gi.xm.platform.pojo.ctdn;

import java.util.List;

/**
 * 公司信息
 * Created by zcy on 17-2-16.
 */
public class CtdnCompany extends CtdnPojo {

    /**
     * @Fields id :
     */
    private Long id;

    /**
     * @Fields title :公司名
     */
    private String title;

    /**
     * @Fields districtId：一级地区id
     */
    private  Long districtId;

    /**
     * @Fields districtSubId：二级地区id
     */
    private  Long districtSubId;

    /**
     * @Fields employeeNumber :公司规模
     */
    private Integer employeeNumber;

    /**
     * @Fields foundＤate : 成立日期
     */
    private String foundＤate;

    /**
     * @Fields roundName :融资需求轮次
     */
    private String  roundName;

    /**
     * @Fields roundId :融资需求轮次ID
     */
    private Long roundId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
    }

    public Long getDistrictSubId() {
        return districtSubId;
    }

    public void setDistrictSubId(Long districtSubId) {
        this.districtSubId = districtSubId;
    }

    public Integer getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(Integer employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getFoundＤate() {
        return foundＤate;
    }

    public void setFoundＤate(String foundＤate) {
        this.foundＤate = foundＤate;
    }

    public String getRoundName() {
        return roundName;
    }

    public void setRoundName(String roundName) {
        this.roundName = roundName;
    }

    public Long getRoundId() {
        return roundId;
    }

    public void setRoundId(Long roundId) {
        this.roundId = roundId;
    }
}
