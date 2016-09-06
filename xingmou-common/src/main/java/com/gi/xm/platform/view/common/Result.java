package com.gi.xm.platform.view.common;

import java.util.List;

/**
 * Created by vincent on 16-9-5.
 */
public class Result<E> {
    private List<E> data;
    private long total;

    public List<E> getData() {
        return data;
    }

    public void setData(List<E> data) {
        this.data = data;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }


}