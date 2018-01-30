package com.gi.ctdn.pojo;

import com.gi.ctdn.view.common.PojoInfo;

public class MergerEquity extends PojoInfo{

    /**
     * @Fields equityRateTypeId;
     */
    private Integer equityRateTypeId;

    /**
     * @Fields equityRateTypeName;
     */
    private String equityRateTypeName;

    /**
     * @Fields mergerNum;
     */
    private Integer mergerNum;

    /**
     * @Fields timeType;
     */
    private Integer timeType;

    public Integer getEquityRateTypeId() {
        return equityRateTypeId;
    }

    public void setEquityRateTypeId(Integer equityRateTypeId) {
        this.equityRateTypeId = equityRateTypeId;
    }

    public String getEquityRateTypeName() {
        return equityRateTypeName;
    }

    public void setEquityRateTypeName(String equityRateTypeName) {
        this.equityRateTypeName = equityRateTypeName;
    }

    public Integer getMergerNum() {
        return mergerNum;
    }

    public void setMergerNum(Integer mergerNum) {
        this.mergerNum = mergerNum;
    }

    public Integer getTimeType() {
        return timeType;
    }

    public void setTimeType(Integer timeType) {
        this.timeType = timeType;
    }
}
