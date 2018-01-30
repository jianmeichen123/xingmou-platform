package com.gi.ctdn.pojo;

import com.gi.ctdn.view.common.PojoInfo;

public class EventDistrict extends PojoInfo{

    public static final String DISTRICTID="地区ID";
    public static final String DISTRICTNAME = "地区名字";
    public static final String DISTRICTSUBID = "二级地区Id";
    public static final String DISTRICTSUBNAME ="二级地区名字";
    public static final String EVENTNUM = "融资笔数";
    public static final String INVSTAMOUNT = "融资金额(万元)";
    public static final String TIMETYPE = "时间类型";

    /**
     * @Fields districtId
     */
    private Integer districtId;

    /**
     * @Fields districtName
     */
    private String districtName;

    /**
     * @Fields districtSubId
     */
    private Integer districtSubId;

    /**
     * @Fields districtSubName
     */
    private String districtSubName;

    /**
     * @Fields eventNum
     */
    private String eventNum;

    /**
     * @Fields invstAmount
     */
    private String invstAmount;

    /**
     * @Fields timeType
     */
    private Integer timeType;

    /**
     * @Fields countNum
     */
    private Integer countNum;

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

    public String getEventNum() {
        return eventNum;
    }

    public void setEventNum(String eventNum) {
        this.eventNum = eventNum;
    }

    public String getInvstAmount() {
        return invstAmount;
    }

    public void setInvstAmount(String invstAmount) {
        this.invstAmount = invstAmount;
    }

    public Integer getTimeType() {
        return timeType;
    }

    public void setTimeType(Integer timeType) {
        this.timeType = timeType;
    }

    public Integer getCountNum() {
        return countNum;
    }

    public void setCountNum(Integer countNum) {
        this.countNum = countNum;
    }
}
