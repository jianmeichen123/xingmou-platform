package com.gi.xm.report.common;

/**
 * Created by vincent on 16-9-5.
 */
public enum ReportMessageInfoStatus {
    OK(10000, "成功"),
    SYS_ERROR(10001, "系统繁忙,请稍后重试"),
    SAME_DATA_EXISTS(10002, "%s"),
    DATA_NOT_EXISTS(10003, "%s");




    private int status;
    private String message;

    ReportMessageInfoStatus(
            int status, String message) {
        this.setStatus(status);
        this.setMessage(message);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}