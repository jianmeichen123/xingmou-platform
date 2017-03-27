package com.gi.xm.platform.view.common;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * Created by vincent on 16-8-25.
 */
public class PojoInfo implements Serializable {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String uid;

    public String getUid() {
        return uid;
    }
    public void setUid(String uid) {
        this.uid = uid;
    }
}
