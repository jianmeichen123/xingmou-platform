package com.gi.ctdn.ods.pojo;

import java.util.Date;
import com.gi.ctdn.view.common.PojoInfo;

public class ProjectRisk extends PojoInfo {

        public static final String PROJECTID = "项目ID";
        public static final String CODE = "code";
        public static final String PROJTITLE = "项目名称";
        public static final String TYPE = "类型[A:公告，J：判决，P：被执行人，E：经营异常，D：失信人]";
        public static final String PUBLISHDT = "发布时间";
        public static final String EVENTTITLE = "事件名称";
        public static final String CONTENT = "内容[A、J、D、E]、标的[P]";
        public static final String DECIDEDORG = "法院/决定机关[A,J,P,E]";
        public static final String CASENO = "案号[J,P,D]";
        public static final String RELATEDFIRM = "相关企业[A,J,E]";
        public static final String DETAILID = "detailId";
    
	
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
	 * @Fields type : 类型[A:公告，J：判决，P：被执行人，E：经营异常，D：失信人]
	 */
	private String type;
	
	/**
	 * @Fields publishDT : 发布时间
	 */
	private Date publishDT;
	
	/**
	 * @Fields eventTitle : 事件名称
	 */
	private String eventTitle;
	
	/**
	 * @Fields content : 内容[A、J、D、E]、标的[P]
	 */
	private String content;
	
	/**
	 * @Fields decidedOrg : 法院/决定机关[A,J,P,E]
	 */
	private String decidedOrg;
	
	/**
	 * @Fields caseNO : 案号[J,P,D]
	 */
	private String caseNO;
	
	/**
	 * @Fields relatedFirm : 相关企业[A,J,E]
	 */
	private String relatedFirm;
	
	/**
	 * @Fields detailId :
	 */
	private String detailId;
	
    
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
    
	public String getType(){
		return type;
	}

	public void setType(String type){
		this.type = type;
	}
    
	public Date getPublishDT(){
		return publishDT;
	}

	public void setPublishDT(Date publishDT){
		this.publishDT = publishDT;
	}
    
	public String getEventTitle(){
		return eventTitle;
	}

	public void setEventTitle(String eventTitle){
		this.eventTitle = eventTitle;
	}
    
	public String getContent(){
		return content;
	}

	public void setContent(String content){
		this.content = content;
	}
    
	public String getDecidedOrg(){
		return decidedOrg;
	}

	public void setDecidedOrg(String decidedOrg){
		this.decidedOrg = decidedOrg;
	}
    
	public String getCaseNO(){
		return caseNO;
	}

	public void setCaseNO(String caseNO){
		this.caseNO = caseNO;
	}
    
	public String getRelatedFirm(){
		return relatedFirm;
	}

	public void setRelatedFirm(String relatedFirm){
		this.relatedFirm = relatedFirm;
	}
    
	public String getDetailId(){
		return detailId;
	}

	public void setDetailId(String detailId){
		this.detailId = detailId;
	}
    }