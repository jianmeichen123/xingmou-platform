package com.gi.ctdn.ods.pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.sql.Timestamp;
import java.util.Date;
import com.gi.xm.platform.view.common.PojoInfo;

public class ProjectCopyrightInfo extends PojoInfo {

        public static final String PROJECTID = "项目ID";
        public static final String SOURCECODE = "项目code";
        public static final String PROJTITLE = "项目名称";
        public static final String COPYRIGHT = "著作名称";
        public static final String REGISTNUM = "登记号";
        public static final String REGISTDATE = "登记日期";
        public static final String REGISTTYPE = "登记类别";
    
	
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
	 * @Fields copyright : 著作名称
	 */
	private String copyright;
	
	/**
	 * @Fields registNum : 登记号
	 */
	private String registNum;
	
	/**
	 * @Fields registDate : 登记日期
	 */
	private String registDate;
	
	/**
	 * @Fields registType : 登记类别
	 */
	private String registType;
	
    
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
    
	public String getCopyright(){
		return copyright;
	}

	public void setCopyright(String copyright){
		this.copyright = copyright;
	}
    
	public String getRegistNum(){
		return registNum;
	}

	public void setRegistNum(String registNum){
		this.registNum = registNum;
	}
    
	public String getRegistDate(){
		return registDate;
	}

	public void setRegistDate(String registDate){
		this.registDate = registDate;
	}
    
	public String getRegistType(){
		return registType;
	}

	public void setRegistType(String registType){
		this.registType = registType;
	}
    }