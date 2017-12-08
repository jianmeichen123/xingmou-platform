package com.gi.ctdn.pojo;

import com.gi.ctdn.view.common.Query;

/**
 * Created by wanghao on 17-11-3.
 */
public class News extends Query {

    public static final String OBJCODE = "主体唯一标识";
    public static final String OBJTYPE = "主体类型";
    public static final String NEWSREPORTDATE = "报道时间";
    public static final String NEWSTITLE = "新闻标题";
    public static final String NEWSOVERVIEW = "新闻概览";
    public static final String LABELS = "标签";
    public static final String NEWSCONTENT = "新闻内容";
    public static final String NEWSLISTPICS = "新闻列表图片";
    public static final String NEWSSOURCE = "新闻来源";
    public static final String NEWSADDRESS = "新闻访问链接";
    public static final String NEWSTYPE = "新闻类型";
    public static final String NEWSTYPENAME = "新闻类型名称";
    public static final String NEWSCOLUMNS = "新闻栏目";

    /**
     * @Fields objCode : 主体唯一标识
     */
    private String objCode;

    /**
     * @Fields objType : 主体类型
     */
    private String objType;

    /**
     * @Fields newsReportDate : 报道时间
     */
    private String newsReportDate;

    /**
     * @Fields newsTitle : 新闻标题
     */
    private String newsTitle;

    /**
     * @Fields newsOverview : 新闻概览
     */
    private String newsOverview;

    /**
     * @Fields labels : 标签
     */
    private String labels;

    /**
     * @Fields newsContent : 新闻内容
     */
    private String newsContent;

    /**
     * @Fields newsListPics : 新闻列表图片
     */
    private String newsListPics;

    /**
     * @Fields newsSource : 新闻来源
     */
    private String newsSource;

    /**
     * @Fields newsAddress : 新闻访问链接
     */
    private String newsAddress;

    /**
     * @Fields newsType : 新闻类型
     */
    private int newsType;

    /**
     * @Fields newsTypeName : 新闻类型名称
     */
    private String newsTypeName;

    /**
     * @Fields newsColumns : 新闻栏目
     */
    private int newsColumns;

    public String getObjCode() {
        return objCode;
    }

    public void setObjCode(String objCode) {
        this.objCode = objCode;
    }

    public String getObjType() {
        return objType;
    }

    public void setObjType(String objType) {
        this.objType = objType;
    }

    public String getNewsReportDate() {
        return newsReportDate;
    }

    public void setNewsReportDate(String newsReportDate) {
        this.newsReportDate = newsReportDate;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsOverview() {
        return newsOverview;
    }

    public void setNewsOverview(String newsOverview) {
        this.newsOverview = newsOverview;
    }

    public String getLabels() {
        return labels;
    }

    public void setLabels(String labels) {
        this.labels = labels;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }

    public String getNewsListPics() {
        return newsListPics;
    }

    public void setNewsListPics(String newsListPics) {
        this.newsListPics = newsListPics;
    }

    public String getNewsSource() {
        return newsSource;
    }

    public void setNewsSource(String newsSource) {
        this.newsSource = newsSource;
    }

    public String getNewsAddress() {
        return newsAddress;
    }

    public void setNewsAddress(String newsAddress) {
        this.newsAddress = newsAddress;
    }

    public int getNewsType() {
        return newsType;
    }

    public void setNewsType(int newsType) {
        this.newsType = newsType;
    }

    public String getNewsTypeName() {
        return newsTypeName;
    }

    public void setNewsTypeName(String newsTypeName) {
        this.newsTypeName = newsTypeName;
    }

    public int getNewsColumns() {
        return newsColumns;
    }

    public void setNewsColumns(int newsColumns) {
        this.newsColumns = newsColumns;
    }
}
