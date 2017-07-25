package com.gi.ctdn.ods.pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.sql.Timestamp;
import java.util.Date;
import com.gi.xm.platform.view.common.PojoInfo;

public class ProjectMarkInfo extends PojoInfo {

        public static final String PROJECTID = "项目ID";
        public static final String SOURCECODE = "项目code";
        public static final String PROJTITLE = "项目名称";
        public static final String TRADEMARK = "商标名称";
        public static final String MARKTYPE = "分类";
        public static final String STATE = "状态";
        public static final String TERM = "期限";
    
	
	/**
	 * @Fields projectId : 项目ID
	 */
	private Integer projectId;
	
	/**
	 * @Fields sourceCode : 项目code
	 */
	private String sourceCode;
	
	/**
	 * @Fields projTitle : 项目名称
	 */
	private String projTitle;
	
	/**
	 * @Fields trademark : 商标名称
	 */
	private String trademark;
	
	/**
	 * @Fields markType : 分类
	 */
	private String markType;
	
	/**
	 * @Fields state : 状态
	 */
	private String state;
	
	/**
	 * @Fields term : 期限
	 */
	private String term;

	/**
	 * @Fields picUrl : 图片链接
	 */
	private String picUrl;

	public Integer getProjectId(){
		return projectId;
	}

	public void setProjectId(Integer projectId){
		this.projectId = projectId;
	}
    
	public String getSourceCode(){
		return sourceCode;
	}

	public void setSourceCode(String sourceCode){
		this.sourceCode = sourceCode;
	}
    
	public String getProjTitle(){
		return projTitle;
	}

	public void setProjTitle(String projTitle){
		this.projTitle = projTitle;
	}
    
	public String getTrademark(){
		return trademark;
	}

	public void setTrademark(String trademark){
		this.trademark = trademark;
	}
    
	public String getMarkType(){
		return markType;
	}

	public void setMarkType(String markType){
		this.markType = markType;
	}
    
	public String getState(){
		return state;
	}

	public void setState(String state){
		this.state = state;
	}
    
	public String getTerm(){
		return term;
	}

	public void setTerm(String term){
		this.term = term;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
}