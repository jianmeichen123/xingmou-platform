package com.gi.ctdn.pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.sql.Timestamp;
import java.util.Date;
import com.gi.xm.platform.view.common.PojoInfo;

public class ProjectMediaInfo extends PojoInfo {

        public static final String PROJECTID = "项目ID";
        public static final String CODE = "code";
        public static final String PROJTITLE = "项目名称";
        public static final String DATE = "日期[H、N:必须，P：为空]";
        public static final String SOURCE = "来源[N:必须，H、P：为空]";
        public static final String CONTENT = "内容";
        public static final String TYPE = "类型[H:历史，N：相关新闻，P：子公司]";
        public static final String SOURCECODE = "project code";
    
	
	/**
	 * @Fields projectId : 项目ID
	 */
	private Integer projectId;
	
	/**
	 * @Fields code : code
	 */
	private String code;
	
	/**
	 * @Fields projTitle : 项目名称
	 */
	private String projTitle;
	
	/**
	 * @Fields date : 日期[H、N:必须，P：为空]
	 */
	private String date;
	
	/**
	 * @Fields source : 来源[N:必须，H、P：为空]
	 */
	private String source;
	
	/**
	 * @Fields content : 内容
	 */
	private String content;
	
	/**
	 * @Fields type : 类型[H:历史，N：相关新闻，P：子公司]
	 */
	private String type;
	
	/**
	 * @Fields sourceCode : project code
	 */
	private String sourceCode;

	/**
	 * @Fields link :link
	 */
	private String link;

	public Integer getProjectId(){
		return projectId;
	}

	public void setProjectId(Integer projectId){
		this.projectId = projectId;
	}
    
	public String getCode(){
		return code;
	}

	public void setCode(String code){
		this.code = code;
	}
    
	public String getProjTitle(){
		return projTitle;
	}

	public void setProjTitle(String projTitle){
		this.projTitle = projTitle;
	}
    
	public String getDate(){
		return date;
	}

	public void setDate(String date){
		this.date = date;
	}
    
	public String getSource(){
		return source;
	}

	public void setSource(String source){
		this.source = source;
	}
    
	public String getContent(){
		return content;
	}

	public void setContent(String content){
		this.content = content;
	}
    
	public String getType(){
		return type;
	}

	public void setType(String type){
		this.type = type;
	}
    
	public String getSourceCode(){
		return sourceCode;
	}

	public void setSourceCode(String sourceCode){
		this.sourceCode = sourceCode;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
}