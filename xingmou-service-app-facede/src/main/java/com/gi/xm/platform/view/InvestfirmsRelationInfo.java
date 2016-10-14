package com.gi.xm.platform.view;

import java.io.Serializable;
import java.util.List;

/**
 * Created by vincent on 16-9-10.
 */
public class InvestfirmsRelationInfo implements Serializable {

    private Long investfirmId;
    private String name;
    private Integer total = 1;

    public Long getInvestfirmId() {
        return investfirmId;
    }

    public void setInvestfirmId(Long investfirmId) {
        this.investfirmId = investfirmId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
