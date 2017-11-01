package com.gi.ctdn.ods.pojo;

import com.gi.ctdn.view.common.PojoInfo;

public class ProjectWebInfo extends PojoInfo {

        public static final String PROJECTID = "项目ID";
        public static final String SOURCECODE = "项目code";
        public static final String PROJTITLE = "项目名称";
        public static final String COMPANY = "公司名称";
        public static final String WEB = "网址";
        public static final String DOMAIN = "域名";
        public static final String LICENSEKEY = "网站备案/许可证号";
        public static final String EXAMINEDATE = "审核时间";
    
	
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
	 * @Fields company : 公司名称
	 */
	private String company;
	
	/**
	 * @Fields web : 网址
	 */
	private String web;
	
	/**
	 * @Fields domain : 域名
	 */
	private String domain;
	
	/**
	 * @Fields licenseKey : 网站备案/许可证号
	 */
	private String licenseKey;
	
	/**
	 * @Fields examineDate : 审核时间
	 */
	private String examineDate;
	
    
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
    
	public String getCompany(){
		return company;
	}

	public void setCompany(String company){
		this.company = company;
	}
    
	public String getWeb(){
		return web;
	}

	public void setWeb(String web){
		this.web = web;
	}
    
	public String getDomain(){
		return domain;
	}

	public void setDomain(String domain){
		this.domain = domain;
	}
    
	public String getLicenseKey(){
		return licenseKey;
	}

	public void setLicenseKey(String licenseKey){
		this.licenseKey = licenseKey;
	}
    
	public String getExamineDate(){
		return examineDate;
	}

	public void setExamineDate(String examineDate){
		this.examineDate = examineDate;
	}
    }