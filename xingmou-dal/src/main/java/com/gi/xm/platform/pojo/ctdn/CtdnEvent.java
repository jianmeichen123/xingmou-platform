package com.gi.xm.platform.pojo.ctdn;

import java.util.Date;

/*
 *融资信息
 * Created by zcy on 17-2-16.
 */
public class CtdnEvent extends CtdnPojo{

    /**
     * @Fields id :
     */
    private Long id;

    /**
     * @Fields projectId :项目id
     */
    private Long projectId;

    /**
     * @Fields roundId :融资需求轮次ID
     */
    private Long roundId;

    /**
     * @Fields roundName :融资需求轮次
     */
    private String  roundName;

    /**
     * @Fields eventDate 融资时间
     */
    private Date eventDate;

    /**
     * @Fields investfirmNames :公司规模
     */
    private String investfirmNames;

    /**
     * @Fields eventMoney :融资金额
     */
    private Integer eventMoney;

    /**
     * @Fields currencyId :货币ｉd
     */
    private Integer currencyId;

    /**
     * @Fields currencyName :货币单位
     */
    private String currencyName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getRoundId() {
        return roundId;
    }

    public void setRoundId(Long roundId) {
        this.roundId = roundId;
    }

    public String getRoundName() {
        return roundName;
    }

    public void setRoundName(String roundName) {
        this.roundName = roundName;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getInvestfirmNames() {
        return investfirmNames;
    }

    public void setInvestfirmNames(String investfirmNames) {
        this.investfirmNames = investfirmNames;
    }

    public Integer getEventMoney() {
        return eventMoney;
    }

    public void setEventMoney(Integer eventMoney) {
        this.eventMoney = eventMoney;
    }

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
}
