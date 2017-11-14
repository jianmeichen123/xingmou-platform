package com.gi.ctdn.view.common;

import java.io.Serializable;
import java.util.LinkedHashMap;

/**
 * Created by zcy on 16-11-24.
 */
public class Result implements Serializable {

    /*
     *  返回信息
     */
    private String msg;

    /**
     * 返回状态码
     */
    private int status;


    /**
     * 总命中条数
     * @param totalhit
     */
    private Long totalhit;

    /**
     * 分页数据
     */
    private Pagination data;

    private LinkedHashMap<String,Long> numMap;



    public Result(String msg, int status) {
        this.msg = msg;
        this.status = status;
    }

    public Result(String msg, int status, Pagination data) {
        this.msg = msg;
        this.status = status;
        this.data = data;
    }

    public Result() {
        this.status = MessageStatus.OK_CODE;
    }

    public static Result addOK() {
        Result ret = new Result(MessageStatus.OK_MESSAGE, MessageStatus.OK_CODE);
        return ret;
    }

    public static Result addError() {
        Result ret = new Result(MessageStatus.ERROR_MESSAGE, MessageStatus.ERROR_CODE);
        return ret;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Pagination getData() {
        return data;
    }

    public void setData(Pagination page) {
        this.data = data;
    }

    public LinkedHashMap<String, Long> getNumMap() {
        return numMap;
    }

    public void setNumMap(LinkedHashMap<String, Long> numMap) {
        this.numMap = numMap;
    }

    public void setTotalhit(Long totalhit) {
        this.totalhit = totalhit;
    }

    public Long getTotalhit() {
        return totalhit;
    }
}
