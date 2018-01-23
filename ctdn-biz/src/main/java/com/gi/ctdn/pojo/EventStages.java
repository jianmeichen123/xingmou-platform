package com.gi.ctdn.pojo;

import com.gi.ctdn.view.common.PojoInfo;

public class EventStages extends PojoInfo {

    /**
     * @Fields districtId;
     */
    private Integer districtId;

    /**
     * @Fields districtName;
     */
    private String districtName;

    /**
     * @Fields districtSubId;
     */
    private Integer districtSubId;

    /**
     * @Fields districtSubName;
     */
    private String districtSubName;

    /**
     * @Fields stagesId;
     */
    private Integer stagesId;

    /**
     * @Fields stagesName;
     */
    private String stagesName;

    /**
     * @Fields eventNum;
     */
    private Integer eventNum;

    /**
     * @Fields invstAmount;
     */
    private Long invstAmount;

    /**
     * @Fields timeType;
     */
    private Integer timeType;

    public Integer getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public Integer getDistrictSubId() {
        return districtSubId;
    }

    public void setDistrictSubId(Integer districtSubId) {
        this.districtSubId = districtSubId;
    }

    public String getDistrictSubName() {
        return districtSubName;
    }

    public void setDistrictSubName(String districtSubName) {
        this.districtSubName = districtSubName;
    }

    public Integer getStagesId() {
        return stagesId;
    }

    public void setStagesId(Integer stagesId) {
        this.stagesId = stagesId;
    }

    public String getStagesName() {
        return stagesName;
    }

    public void setStagesName(String stagesName) {
        this.stagesName = stagesName;
    }

    public Integer getEventNum() {
        return eventNum;
    }

    public void setEventNum(Integer eventNum) {
        this.eventNum = eventNum;
    }

    public Long getInvstAmount() {
        return invstAmount;
    }

    public void setInvstAmount(Long invstAmount) {
        this.invstAmount = invstAmount;
    }

    public Integer getTimeType() {
        return timeType;
    }

    public void setTimeType(Integer timeType) {
        this.timeType = timeType;
    }
}
