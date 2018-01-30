package com.gi.ctdn.pojo;

import com.gi.ctdn.view.common.PojoInfo;

public class MergerIndustry extends PojoInfo {

    /**
     * @Fields industryId;
     */
    private Integer industryId;

    /**
     * @Fields industryName;
     */
    private String industryName;

    /**
     * @Fields mergerNum;
     */
    private Integer mergerNum;

    /**
     * @Fields timeType;
     */
    private String timeType;

    public Integer getIndustryId() {
        return industryId;
    }

    public void setIndustryId(Integer industryId) {
        this.industryId = industryId;
    }

    public String getIndustryName() {
        return industryName;
    }

    public void setIndustryName(String industryName) {
        this.industryName = industryName;
    }

    public Integer getMergerNum() {
        return mergerNum;
    }

    public void setMergerNum(Integer mergerNum) {
        this.mergerNum = mergerNum;
    }

    public String getTimeType() {
        return timeType;
    }

    public void setTimeType(String timeType) {
        this.timeType = timeType;
    }
}
