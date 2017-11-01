package com.gi.ctdn.ods.pojo;

import com.gi.ctdn.view.common.PojoInfo;

public class RiskCourtAnnouncement extends PojoInfo {

        public static final String ID = "id";
        public static final String CODE = "项目code";
        public static final String SOURCEID = "项目id";
        public static final String DISTRIBUTEDATE = "发布时间";
        public static final String SORTMENT = "分类";
        public static final String LITIGANT = "当事人";
        public static final String CONTENT = "公告内容";
    
	
	/**
	 * @Fields id : 
	 */
	private Long id;
	
	/**
	 * @Fields code : 项目code
	 */
	private String sourceCode;
	
	/**
	 * @Fields sourceId : 项目id
	 */
	private Long sourceId;
	
	/**
	 * @Fields distributeDate : 发布时间
	 */
	private String distributeDate;
	
	/**
	 * @Fields sortment : 分类
	 */
	private String sortment;
	
	/**
	 * @Fields litigant : 当事人
	 */
	private String litigant;
	
	/**
	 * @Fields content : 公告内容
	 */
	private String content;
	
    
	public Long getId(){
		return id;
	}

	public void setId(Long id){
		this.id = id;
	}

	public String getSourceCode() {
		return sourceCode;
	}

	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}

	public Long getSourceId(){
		return sourceId;
	}

	public void setSourceId(Long sourceId){
		this.sourceId = sourceId;
	}
    
	public String getDistributeDate(){
		return distributeDate;
	}

	public void setDistributeDate(String distributeDate){
		this.distributeDate = distributeDate;
	}
    
	public String getSortment(){
		return sortment;
	}

	public void setSortment(String sortment){
		this.sortment = sortment;
	}
    
	public String getLitigant(){
		return litigant;
	}

	public void setLitigant(String litigant){
		this.litigant = litigant;
	}
    
	public String getContent(){
		return content;
	}

	public void setContent(String content){
		this.content = content;
	}
    }