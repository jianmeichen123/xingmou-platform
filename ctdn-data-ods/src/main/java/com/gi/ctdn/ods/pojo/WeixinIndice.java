package com.gi.ctdn.ods.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gi.ctdn.view.common.PojoInfo;

public class WeixinIndice extends PojoInfo {

        public static final String ID = "id";
        public static final String DATE = "date";
        public static final String COUNT_DATE = "countDate";
        public static final String TITLE = "项目title";
        public static final String WXID = "wxid";
        public static final String ARTICLE_CLICKS_COUNT = "articleClicksCount";
        public static final String ARTICLE_COUNT = "articleCount";
        public static final String ARTICLE_LIKES_COUNT = "articleLikesCount";
        public static final String AVG_ARTICLE_CLICKS_COUNT = "avgArticleClicksCount";
        public static final String AVG_ARTICLE_LIKES_COUNT = "avgArticleLikesCount";
    
	
	/**
	 * @Fields id : 
	 */
	@JsonIgnore
	private Integer id;
	
	/**
	 * @Fields date : 
	 */
	private Integer date;
	
	/**
	 * @Fields countDate : 
	 */
	private Date countDate;
	
	/**
	 * @Fields title : 项目title
	 */
	@JsonIgnore
	private String title;
	
	/**
	 * @Fields wxid : 
	 */
	@JsonIgnore
	private String wxid;
	
	/**
	 * @Fields articleClicksCount : 
	 */
	private Integer articleClicksCount;
	
	/**
	 * @Fields articleCount : 
	 */
	private Integer articleCount;
	
	/**
	 * @Fields articleLikesCount : 
	 */
	private Integer articleLikesCount;
	
	/**
	 * @Fields avgArticleClicksCount : 
	 */
	private Integer avgArticleClicksCount;
	
	/**
	 * @Fields avgArticleLikesCount : 
	 */
	private Integer avgArticleLikesCount;
	
    
	public Integer getId(){
		return id;
	}

	public void setId(Integer id){
		this.id = id;
	}
    
	public Integer getDate(){
		return date;
	}

	public void setDate(Integer date){
		this.date = date;
	}
    
	public Date getCountDate(){
		return countDate;
	}

	public void setCountDate(Date countDate){
		this.countDate = countDate;
	}
    
	public String getTitle(){
		return title;
	}

	public void setTitle(String title){
		this.title = title;
	}
    
	public String getWxid(){
		return wxid;
	}

	public void setWxid(String wxid){
		this.wxid = wxid;
	}
    
	public Integer getArticleClicksCount(){
		return articleClicksCount;
	}

	public void setArticleClicksCount(Integer articleClicksCount){
		this.articleClicksCount = articleClicksCount;
	}
    
	public Integer getArticleCount(){
		return articleCount;
	}

	public void setArticleCount(Integer articleCount){
		this.articleCount = articleCount;
	}
    
	public Integer getArticleLikesCount(){
		return articleLikesCount;
	}

	public void setArticleLikesCount(Integer articleLikesCount){
		this.articleLikesCount = articleLikesCount;
	}
    
	public Integer getAvgArticleClicksCount(){
		return avgArticleClicksCount;
	}

	public void setAvgArticleClicksCount(Integer avgArticleClicksCount){
		this.avgArticleClicksCount = avgArticleClicksCount;
	}
    
	public Integer getAvgArticleLikesCount(){
		return avgArticleLikesCount;
	}

	public void setAvgArticleLikesCount(Integer avgArticleLikesCount){
		this.avgArticleLikesCount = avgArticleLikesCount;
	}
    }