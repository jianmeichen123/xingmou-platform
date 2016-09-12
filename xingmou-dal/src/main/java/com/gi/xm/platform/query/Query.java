package com.gi.xm.platform.query;

import java.io.Serializable;

/**
 * Created by vincent on 16-9-6.
 */
public class Query implements Serializable{

    private boolean doOrder = true ;
    private int pageIndex = 1;
    private int pageSize = 10;
    private String order;
    private String orderBy;
    private String returnFields;

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getReturnFields() {
        return returnFields;
    }

    public void setReturnFields(String returnFields) {
        this.returnFields = returnFields;
    }

    public boolean isDoOrder() {
        return doOrder;
    }

    public void setDoOrder(boolean doOrder) {
        this.doOrder = doOrder;
    }
}
