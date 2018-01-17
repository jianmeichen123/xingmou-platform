package com.gi.ctdn.pojo;

import com.gi.ctdn.view.common.PojoInfo;

public class ListedExchange extends PojoInfo{

    public static final String EXCHANGEID = "交易所ID";
    public static final String EXCHANGENAME = "交易所名字";
    public static final String EVENTNUM = "上市公司数";

    /**
     * @Fields exchangeId
     */
    private Integer exchangeId;

    /**
     * @Fields exchangeName
     */
    private String exchangeName;

    /**
     * @Fields eventNum
     */
    private Integer eventNum;

    public Integer getExchangeId() {
        return exchangeId;
    }

    public void setExchangeId(Integer exchangeId) {
        this.exchangeId = exchangeId;
    }

    public String getExchangeName() {
        return exchangeName;
    }

    public void setExchangeName(String exchangeName) {
        this.exchangeName = exchangeName;
    }

    public Integer getEventNum() {
        return eventNum;
    }

    public void setEventNum(Integer eventNum) {
        this.eventNum = eventNum;
    }
}
