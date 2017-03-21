package com.gi.ctdn.ods.pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.sql.Timestamp;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.gi.xm.platform.view.common.PojoInfo;

public class OpIndiceSummary extends PojoInfo {

        public static final String ID = "id";
        public static final String DATE = "指标计算时间";
        public static final String TITLE = "项目title";
        public static final String CODE = "项目code";
        public static final String APPNAME = "网站域名,appName,微博、微信名称";
        public static final String TYPE = "domain,ios,android,weibo,weixin";
        public static final String INDEX_1 = "指标1：PV/UV、APP的下载总量、微博/微信的平均阅读量";
        public static final String INDEX_2 = "指标2：排名、APP当天的下载量、微博的粉丝数、微信的点赞量";
        public static final String AVG_SCORE = "APP评分";
        public static final String UPDATE_DATE = "指标获取时间";
    
	
	/**
	 * @Fields id : 
	 */
	@JsonIgnore
	private Integer id;
	
	/**
	 * @Fields date : 指标计算时间
	 */
	private Integer date;
	
	/**
	 * @Fields title : 项目title
	 */
	@JsonIgnore
	private String title;
	
	/**
	 * @Fields code : 项目code
	 */
	@JsonIgnore
	private String code;
	
	/**
	 * @Fields appname : 网站域名,appName,微博、微信名称
	 */
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String appname;
	
	/**
	 * @Fields type : domain,ios,android,weibo,weixin
	 */
	private String type;
	
	/**
	 * @Fields index1 : 指标1：PV/UV、APP的下载总量、微博/微信的平均阅读量
	 */
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer index1;
	
	/**
	 * @Fields index2 : 指标2：排名、APP当天的下载量、微博的粉丝数、微信的点赞量
	 */
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer index2;
	
	/**
	 * @Fields avgScore : APP评分
	 */
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer avgScore;
	
	/**
	 * @Fields updateDate : 指标获取时间
	 */
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer updateDate;
	
    
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
    
	public String getTitle(){
		return title;
	}

	public void setTitle(String title){
		this.title = title;
	}
    
	public String getCode(){
		return code;
	}

	public void setCode(String code){
		this.code = code;
	}
    
	public String getAppname(){
		return appname;
	}

	public void setAppname(String appname){
		this.appname = appname;
	}
    
	public String getType(){
		return type;
	}

	public void setType(String type){
		this.type = type;
	}
    
	public Integer getIndex1(){
		return index1;
	}

	public void setIndex1(Integer index1){
		this.index1 = index1;
	}
    
	public Integer getIndex2(){
		return index2;
	}

	public void setIndex2(Integer index2){
		this.index2 = index2;
	}
    
	public Integer getAvgScore(){
		return avgScore;
	}

	public void setAvgScore(Integer avgScore){
		this.avgScore = avgScore;
	}
    
	public Integer getUpdateDate(){
		return updateDate;
	}

	public void setUpdateDate(Integer updateDate){
		this.updateDate = updateDate;
	}
    }