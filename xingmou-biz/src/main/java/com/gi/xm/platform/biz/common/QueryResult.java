package com.gi.xm.platform.biz.common;

import java.util.List;

/**
 * Created by vincent on 16-9-5.
 */
public class QueryResult<E> {

    private Integer pages;
    private List<E> records;
    private long total;

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public List<E> getRecords() {
        return records;
    }

    public void setRecords(List<E> records) {
        this.records = records;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

}