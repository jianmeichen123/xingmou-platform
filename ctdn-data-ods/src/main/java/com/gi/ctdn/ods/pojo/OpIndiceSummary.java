package com.gi.ctdn.ods.pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.sql.Timestamp;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gi.xm.platform.view.common.PojoInfo;

public class OpIndiceSummary extends PojoInfo {

        public static final String ID = "id";
        public static final String CODE = "项目code";
        public static final String APPNAME = "网站域名,appName,微博、微信名称";
        public static final String TYPE = "domain,ios,android,weibo,weixin";
        public static final String APPID = "appid";
        public static final String INDEX_1 = "index1";
        public static final String INDEX_2 = "index2";
        public static final String AVG_SCORE = "APP评分";
        public static final String UPDATE_DATE = "指标获取时间";
    
	
	/**
	 * @Fields id : 
	 */
	@JsonIgnore
	private Integer id;
	
	/**
	 * @Fields code : 项目code
	 */
	@JsonIgnore
	private String code;
	
	/**
	 * @Fields appname : 网站域名,appName,微博、微信名称
	 */
	private String appname;
	
	/**
	 * @Fields type : domain,ios,android,weibo,weixin
	 */
	private String type;
	
	/**
	 * @Fields appid : 
	 */
	private String appid;
	
	/**
	 * @Fields index1 : 
	 */
	private Long index1;
	
	/**
	 * @Fields index2 : 
	 */
	private Long index2;
	
	/**
	 * @Fields avgScore : APP评分
	 */
	private Integer avgScore;
	
	/**
	 * @Fields updateDate : 指标获取时间
	 */
	private Integer updateDate;
	
    
	public Integer getId(){
		return id;
	}

	public void setId(Integer id){
		this.id = id;
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
    
	public String getAppid(){
		return appid;
	}

	public void setAppid(String appid){
		this.appid = appid;
	}
    
	public Long getIndex1(){
		return index1;
	}

	public void setIndex1(Long index1){
		this.index1 = index1;
	}
    
	public Long getIndex2(){
		return index2;
	}

	public void setIndex2(Long index2){
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