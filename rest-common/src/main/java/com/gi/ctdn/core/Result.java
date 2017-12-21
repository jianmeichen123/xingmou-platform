package com.gi.ctdn.core;

import lombok.Data;

@Data
public class Result<T> {

    private int code;
    private String msg;

    public Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
