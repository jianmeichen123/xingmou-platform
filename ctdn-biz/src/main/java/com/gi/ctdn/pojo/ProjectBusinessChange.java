package com.gi.ctdn.pojo;

import com.gi.ctdn.view.common.PojoInfo;

public class ProjectBusinessChange extends PojoInfo {

        public static final String PROJECTID = "项目ID";
        public static final String SOURCECODE = "项目code";
        public static final String PROJTITLE = "项目名称";
        public static final String CHANGEITEMS = "变更事项";
        public static final String BEFORECONTENT = "变更前内容";
        public static final String AFTERCONTENT = "变更后内容";
        public static final String CHANGEDATE = "变更日期";
    
	
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
	 * @Fields changeItems : 变更事项
	 */
	private String changeItems;
	
	/**
	 * @Fields beforeContent : 变更前内容
	 */
	private String beforeContent;
	
	/**
	 * @Fields afterContent : 变更后内容
	 */
	private String afterContent;
	
	/**
	 * @Fields changeDate : 变更日期
	 */
	private String changeDate;
	
    
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
    
	public String getChangeItems(){
		return changeItems;
	}

	public void setChangeItems(String changeItems){
		this.changeItems = changeItems;
	}
    
	public String getBeforeContent(){
		return beforeContent;
	}

	public void setBeforeContent(String beforeContent){
		this.beforeContent = beforeContent;
	}
    
	public String getAfterContent(){
		return afterContent;
	}

	public void setAfterContent(String afterContent){
		this.afterContent = afterContent;
	}
    
	public String getChangeDate(){
		return changeDate;
	}

	public void setChangeDate(String changeDate){
		this.changeDate = changeDate;
	}
    }