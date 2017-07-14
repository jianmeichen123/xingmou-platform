package com.gi.ctdn.ods.pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.sql.Timestamp;
import java.util.Date;
import com.gi.xm.platform.view.common.PojoInfo;

public class ProjectPatentInfo extends PojoInfo {

        public static final String PROJECTID = "项目ID";
        public static final String SOURCECODE = "项目code";
        public static final String PROJTITLE = "项目名称";
        public static final String PATENT = "专利名称";
        public static final String APPLYNUM = "申请号";
        public static final String APPLYPUBNUM = "申请公布号";
        public static final String APPLYDATE = "申请日";
        public static final String APPLYPUBDATE = "申请公布日";
        public static final String INVENTOR = "发明人";
        public static final String PATENTTYPE = "类型";
        public static final String AGENCY = "专利代理机构";
        public static final String LEGALSTATUS = "法律状态";
        public static final String SUMMARY = "摘要";
        public static final String LINK = "预留";
    
	
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
	 * @Fields patent : 专利名称
	 */
	private String patent;
	
	/**
	 * @Fields applyNum : 申请号
	 */
	private String applyNum;
	
	/**
	 * @Fields applyPubNum : 申请公布号
	 */
	private String applyPubNum;
	
	/**
	 * @Fields applyDate : 申请日
	 */
	private String applyDate;
	
	/**
	 * @Fields applyPubDate : 申请公布日
	 */
	private String applyPubDate;
	
	/**
	 * @Fields inventor : 发明人
	 */
	private String inventor;
	
	/**
	 * @Fields patentType : 类型
	 */
	private String patentType;
	
	/**
	 * @Fields agency : 专利代理机构
	 */
	private String agency;
	
	/**
	 * @Fields legalStatus : 法律状态
	 */
	private String legalStatus;
	
	/**
	 * @Fields abstract : 摘要
	 */
	private String summary;
	
	/**
	 * @Fields link : 预留
	 */
	private String link;
	
    
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
    
	public String getPatent(){
		return patent;
	}

	public void setPatent(String patent){
		this.patent = patent;
	}
    
	public String getApplyNum(){
		return applyNum;
	}

	public void setApplyNum(String applyNum){
		this.applyNum = applyNum;
	}
    
	public String getApplyPubNum(){
		return applyPubNum;
	}

	public void setApplyPubNum(String applyPubNum){
		this.applyPubNum = applyPubNum;
	}
    
	public String getApplyDate(){
		return applyDate;
	}

	public void setApplyDate(String applyDate){
		this.applyDate = applyDate;
	}
    
	public String getApplyPubDate(){
		return applyPubDate;
	}

	public void setApplyPubDate(String applyPubDate){
		this.applyPubDate = applyPubDate;
	}
    
	public String getInventor(){
		return inventor;
	}

	public void setInventor(String inventor){
		this.inventor = inventor;
	}
    
	public String getPatentType(){
		return patentType;
	}

	public void setPatentType(String patentType){
		this.patentType = patentType;
	}
    
	public String getAgency(){
		return agency;
	}

	public void setAgency(String agency){
		this.agency = agency;
	}
    
	public String getLegalStatus(){
		return legalStatus;
	}

	public void setLegalStatus(String legalStatus){
		this.legalStatus = legalStatus;
	}
    
	public String getSummary(){
		return summary;
	}

	public void setSummary(String summary){
		this.summary = summary;
	}
    
	public String getLink(){
		return link;
	}

	public void setLink(String link){
		this.link = link;
	}
    }