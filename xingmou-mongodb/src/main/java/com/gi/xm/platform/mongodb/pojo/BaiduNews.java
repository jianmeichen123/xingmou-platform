package com.gi.xm.platform.mongodb.pojo;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by vincent on 16-8-21.
 */
@Document(collection = "baidu_news")
public class BaiduNews extends Pojo {

    private  String author;
    private String url;
    private String abs;
    private String title;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAbs() {
        return abs;
    }

    public void setAbs(String abs) {
        this.abs = abs;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Long getPublicTime() {
        return publicTime;
    }

    public void setPublicTime(Long publicTime) {
        this.publicTime = publicTime;
    }

    public Long getSortTime() {
        return sortTime;
    }

    public void setSortTime(Long sortTime) {
        this.sortTime = sortTime;
    }

    private String imgUrl;
    private Long publicTime;
    private Long sortTime;

}
