package com.gi.ctdn.pojo;

import com.gi.ctdn.view.common.PojoInfo;

public class MergerCurrency extends PojoInfo{

    /**
     * @Fields currencyId;
     */
    private Integer currencyId;

    /**
     * @Fields currencyName;
     */
    private String currencyName;

    /**
     * @Fields mergerNum;
     */
    private Integer mergerNum;

    /**
     * @Fields timeType;
     */
    private Integer timeType;

    public Integer getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Integer currencyId) {
        this.currencyId = currencyId;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
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
