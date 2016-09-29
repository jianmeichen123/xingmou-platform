package com.gi.xm.report.common;

import com.gi.xm.report.pojo.Pojo;

import java.util.Map;

/**
 * Created by vincent on 16-9-29.
 */
public class ChartPojo<T> extends Pojo{

    private Map<String, Object>  raw;

    private Map<String, Object> cal;


    public Map<String, Object> getCal() {
        return cal;
    }

    public void setCal(Map<String, Object> cal) {
        this.cal = cal;
    }

    public Map<String, Object> getRaw() {
        return raw;
    }

    public void setRaw(Map<String, Object> raw) {
        this.raw = raw;
    }
}

