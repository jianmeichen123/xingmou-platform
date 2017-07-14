package com.gi.ctdn.api.rest;

import com.alibaba.fastjson.JSON;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by vincent on 17-7-10.
 */
public class Heihei implements Serializable{
    @Id
    private String id;
    private String url;
    private String html;
    private Map json;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public Map getJson() {
        return json;
    }

    public void setJson(Map json) {
        this.json = json;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
