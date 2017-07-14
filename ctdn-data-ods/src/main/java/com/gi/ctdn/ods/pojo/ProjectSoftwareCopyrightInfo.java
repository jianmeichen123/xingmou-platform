package com.gi.ctdn.ods.pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.sql.Timestamp;
import java.util.Date;
import com.gi.xm.platform.view.common.PojoInfo;

public class ProjectSoftwareCopyrightInfo extends PojoInfo {

        public static final String PROJECTID = "项目ID";
        public static final String SOURCECODE = "项目code";
        public static final String PROJTITLE = "项目名称";
        public static final String SOFTWARE = "软件名称";
        public static final String CLASSIFICATIONNUM = "分类号";
        public static final String REGISTNUM = "登记号";
        public static final String APPROVALDATE = "登记批准日期";
    
	
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
	 * @Fields software : 软件名称
	 */
	private String software;
	
	/**
	 * @Fields classificationNum : 分类号
	 */
	private String classificationNum;
	
	/**
	 * @Fields registNum : 登记号
	 */
	private String registNum;
	
	/**
	 * @Fields approvalDate : 登记批准日期
	 */
	private String approvalDate;
	
    
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
    
	public String getSoftware(){
		return software;
	}

	public void setSoftware(String software){
		this.software = software;
	}
    
	public String getClassificationNum(){
		return classificationNum;
	}

	public void setClassificationNum(String classificationNum){
		this.classificationNum = classificationNum;
	}
    
	public String getRegistNum(){
		return registNum;
	}

	public void setRegistNum(String registNum){
		this.registNum = registNum;
	}
    
	public String getApprovalDate(){
		return approvalDate;
	}

	public void setApprovalDate(String approvalDate){
		this.approvalDate = approvalDate;
	}
    }