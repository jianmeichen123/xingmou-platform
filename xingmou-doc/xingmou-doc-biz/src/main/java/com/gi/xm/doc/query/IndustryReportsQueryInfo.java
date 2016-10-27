package com.gi.xm.doc.query;

import com.gi.xm.platform.view.common.QueryInfo;

import java.util.Date;
import java.math.BigDecimal;
import java.io.Serializable;
import java.sql.Timestamp;

public class IndustryReportsQueryInfo extends QueryInfo {
	
	/**   
	 * @Fields serialVersionUID : 序列化版本号 
	 */ 
	private static final long serialVersionUID = 1L;

	
	private Integer id;
	
	private String title;
	
	private Date publishDate;
	
	private Integer sourceType;
	
	private String icon;
	
	private Integer industryId;
	
	private Integer industrySubId;
	
	private String summaryShort;
	
	private Byte summary;
	
	private Timestamp addTime;
	
	private Timestamp updateTime;
		
    
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
    
	public Date getPublishDate(){
		return publishDate;
	}
	
	public void setPublishDate(Date publishDate){
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
    
	public Byte getSummary(){
		return summary;
	}
	
	public void setSummary(Byte summary){
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