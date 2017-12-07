package com.gi.ctdn.view.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangchunyuan
 *         查询分页对象
 */
public class Pagination implements Serializable {


    private static final long serialVersionUID = 1L;

    private Long total = 0l;

    private List records;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List getRecords() {
        return records;
    }

    public void setRecords(List records) {
        this.records = records;
    }

}
