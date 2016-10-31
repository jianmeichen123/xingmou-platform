package com.gi.xm.doc.pojo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class IndustryReportsInfo implements Serializable {

	/**   
	 * @Fields serialVersionUID : 序列化版本号 
	 */ 
	private static final long serialVersionUID = 1L;

			
	/**
	 * @Fields id : 
	 */
	private Integer id;
			
	/**
	 * @Fields title : 标题
	 */
	private String title;
			
	/**
	 * @Fields publishDate :  发布日期（源）
	 */
	private String publishDate;


	/**
	 * @Fields sourceType : 1. 艾瑞网 2.易观
	 */
	private Integer sourceType;
			
	/**
	 * @Fields icon : 图标
	 */
	private String icon;
			
	/**
	 * @Fields industryId : 一级行业分类id
	 */
	private Integer industryId;
			
	/**
	 * @Fields industrySubId : 二级行业分类id
	 */
	private Integer industrySubId;
			
	/**
	 * @Fields summaryShort : 摘要
	 */
	private String summaryShort;
			
	/**
	 * @Fields summary : 正文
	 */
	private String summary;
			
	/**
	 * @Fields addTime : 
	 */
	private Timestamp addTime;
			
	/**
	 * @Fields updateTime : 
	 */
	private Timestamp updateTime;
		
    private String source;

	private String sourceId;

	private Integer year;

	private Integer docType;

	private String tags;

    private String industryName;

    public String getIndustryName() {
        return industryName;
    }

    public void setIndustryName(String industryName) {
        this.industryName = industryName;
    }

    private IndustryReportsInfo pre;

    private IndustryReportsInfo next;

    private List<IndustryReportsInfo> tagLikeList;

    public List<IndustryReportsInfo> getTagLikeList() {
        return tagLikeList;
    }

    public void setTagLikeList(List<IndustryReportsInfo> tagLikeList) {
        this.tagLikeList = tagLikeList;
    }

    public IndustryReportsInfo getPre() {
        return pre;
    }

    public void setPre(IndustryReportsInfo pre) {
        this.pre = pre;
    }

    public IndustryReportsInfo getNext() {
        return next;
    }

    public void setNext(IndustryReportsInfo next) {
        this.next = next;
    }

    public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public Integer getDocType() {
		return docType;
	}

	public void setDocType(Integer docType) {
		this.docType = docType;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getSourceId() {
		return sourceId;
	}

	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Integer getId(){
		return id;
	}
	
	public void setId(Integer id){
		this.id = id;
	}
    
	public String getTitle(){
		return title;
	}
	
	public void setTitle(String title){
		this.title = title;
	}

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public Integer getSourceType(){
		return sourceType;
	}
	
	public void setSourceType(Integer sourceType){
		this.sourceType = sourceType;
	}
    
	public String getIcon(){
		return icon;
	}
	
	public void setIcon(String icon){
		this.icon = icon;
	}
    
	public Integer getIndustryId(){
		return industryId;
	}
	
	public void setIndustryId(Integer industryId){
		this.industryId = industryId;
	}
    
	public Integer getIndustrySubId(){
		return industrySubId;
	}
	
	public void setIndustrySubId(Integer industrySubId){
		this.industrySubId = industrySubId;
	}
    
	public String getSummaryShort(){
		return summaryShort;
	}
	
	public void setSummaryShort(String summaryShort){
		this.summaryShort = summaryShort;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Timestamp getAddTime(){
		return addTime;
	}
	
	public void setAddTime(Timestamp addTime){
		this.addTime = addTime;
	}
    
	public Timestamp getUpdateTime(){
		return updateTime;
	}
	
	public void setUpdateTime(Timestamp updateTime){
		this.updateTime = updateTime;
	}
    }