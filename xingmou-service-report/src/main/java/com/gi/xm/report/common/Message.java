package com.gi.xm.report.common;

import java.io.Serializable;

/**
 * Created by vincent on 16-9-5.
 */
public class Message<E> implements Serializable{

    public Message() {
        status = ReportMessageInfoStatus.OK.getStatus();
        message = ReportMessageInfoStatus.OK.getMessage();
    }

    public Message(ReportMessageInfoStatus messgeStatus) {
        status = messgeStatus.getStatus();
        message = messgeStatus.getMessage();
    }

    private String message;
    private int status;
    private E data;

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

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return ReportMessageInfoStatus.OK.getStatus() == this.status;
    }

    public void setMessageStatus(ReportMessageInfoStatus code, Object... args) {
        this.setStatus(code.getStatus());
        if (args.length == 0) {
            this.setMessage(code.getMessage());
        } else {
            this.setMessage(String.format(code.getMessage(), args));
        }
    }

    public static <T> Message<T> getMessage(ReportMessageInfoStatus code, Object... args) {
        Message<T> message = new Message<T>();
        message.setStatus(code.getStatus());
        if (args.length == 0) {
            message.setMessage(code.getMessage());
        } else {
            message.setMessage(String.format(code.getMessage(), args));
        }
        return message;
    }

    @SuppressWarnings("rawtypes")
    public void copy(Message ms) {
        this.status = ms.getStatus();
        this.message = ms.getMessage();
    }
}