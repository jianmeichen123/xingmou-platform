package com.gi.ctdn.core;

import lombok.Data;

@Data
public class Result<T> {

    private int code;
    private String msg;
    private boolean success = false;
    public Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
