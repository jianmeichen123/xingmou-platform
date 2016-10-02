package com.gi.xm.report.common;

import com.gi.xm.report.pojo.Pojo;

/**
 * Created by vincent on 16-10-1.
 */
public class NameValue extends Pojo {

    private  String name;

    private Long value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }
}
