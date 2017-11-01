package com.gi.ctdn.ods.pojo;

import com.gi.ctdn.view.common.PojoInfo;

public class ProjectCertificateInfo extends PojoInfo {

	public static final String ID = "id";
	public static final String PROJECTID = "项目ID";
	public static final String SOURCECODE = "项目code";
	public static final String PROJTITLE = "项目名称";
	public static final String CFCTTITLE = "证书名称";
	public static final String ISSUEDT = "发证日期";
	public static final String CLOSEDT = "截止日期";
	public static final String DETAILJSON = "详情内容";


	/**
	 * @Fields id :
	 */
	private Integer id;

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
	 * @Fields cfctTitle : 证书名称
	 */
	private String cfctTitle;

	/**
	 * @Fields issueDT : 发证日期
	 */
	private String issueDT;

	/**
	 * @Fields closeDT : 截止日期
	 */
	private String closeDT;

	/**
	 * @Fields detailJson : 详情内容
	 */
	private String detailJson;


	public Integer getId(){
		return id;
	}

	public void setId(Integer id){
		this.id = id;
	}

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

	public String getCfctTitle(){
		return cfctTitle;
	}

	public void setCfctTitle(String cfctTitle){
		this.cfctTitle = cfctTitle;
	}

	public String getIssueDT(){
		return issueDT;
	}

	public void setIssueDT(String issueDT){
		this.issueDT = issueDT;
	}

	public String getCloseDT(){
		return closeDT;
	}

	public void setCloseDT(String closeDT){
		this.closeDT = closeDT;
	}

	public String getDetailJson(){
		return detailJson;
	}

	public void setDetailJson(String detailJson){
		this.detailJson = detailJson;
	}
}