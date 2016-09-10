package com.gi.xm.platform.view;

import java.util.Date;
import java.math.BigDecimal;
import java.io.Serializable;
import java.sql.Timestamp;
import com.gi.xm.platform.view.common.QueryInfo;

public class ProjectQueryInfo extends QueryInfo {
	
	/**   
	 * @Fields serialVersionUID : 序列化版本号 
	 */ 
	private static final long serialVersionUID = 1L;

	
	private Long id;
	
	private String title;
	
	private String pic;
	
	private String picBig;
	
	private String picshow;
	
	private String weblink;
	
	private String ceoName;
	
	private Long companyId;
	
	private String companyName;
	
	private Long industryId;
	
	private Long industrySubId;
	
	private String industryName;
	
	private String industrySubName;
	
	private Long districtId;
	
	private String districtName;
	
	private Long districtSubId;
	
	private String districtSubName;
	
	private Long newestEventId;
	
	private String newestEventDate;
	
	private String newestEventRound;
	
	private Long newestEventMoney;
	
	private Long sourceId;
	
	private String createDate;
	
	private Integer status;
	
	private String businessModel;
	
	private String industryPainPoints;
	
	private Integer teamScore;
	
	private Integer operationScore;
	
	private Integer score;
	
	private Integer timeSpan;
	
	private String investInfo;
	
	private Integer investNum;
	
	private Long investMoney;
	
	private Timestamp loadTime;
	
	private Timestamp updateTime;
		
    
	public Long getId(){
		return id;
	}
	
	public void setId(Long id){
		this.id = id;
	}
    
	public String getTitle(){
		return title;
	}
	
	public void setTitle(String title){
		this.title = title;
	}
    
	public String getPic(){
		return pic;
	}
	
	public void setPic(String pic){
		this.pic = pic;
	}
    
	public String getPicBig(){
		return picBig;
	}
	
	public void setPicBig(String picBig){
		this.picBig = picBig;
	}
    
	public String getPicshow(){
		return picshow;
	}
	
	public void setPicshow(String picshow){
		this.picshow = picshow;
	}
    
	public String getWeblink(){
		return weblink;
	}
	
	public void setWeblink(String weblink){
		this.weblink = weblink;
	}
    
	public String getCeoName(){
		return ceoName;
	}
	
	public void setCeoName(String ceoName){
		this.ceoName = ceoName;
	}
    
	public Long getCompanyId(){
		return companyId;
	}
	
	public void setCompanyId(Long companyId){
		this.companyId = companyId;
	}
    
	public String getCompanyName(){
		return companyName;
	}
	
	public void setCompanyName(String companyName){
		this.companyName = companyName;
	}
    
	public Long getIndustryId(){
		return industryId;
	}
	
	public void setIndustryId(Long industryId){
		this.industryId = industryId;
	}
    
	public Long getIndustrySubId(){
		return industrySubId;
	}
	
	public void setIndustrySubId(Long industrySubId){
		this.industrySubId = industrySubId;
	}
    
	public String getIndustryName(){
		return industryName;
	}
	
	public void setIndustryName(String industryName){
		this.industryName = industryName;
	}
    
	public String getIndustrySubName(){
		return industrySubName;
	}
	
	public void setIndustrySubName(String industrySubName){
		this.industrySubName = industrySubName;
	}
    
	public Long getDistrictId(){
		return districtId;
	}
	
	public void setDistrictId(Long districtId){
		this.districtId = districtId;
	}
    
	public String getDistrictName(){
		return districtName;
	}
	
	public void setDistrictName(String districtName){
		this.districtName = districtName;
	}
    
	public Long getDistrictSubId(){
		return districtSubId;
	}
	
	public void setDistrictSubId(Long districtSubId){
		this.districtSubId = districtSubId;
	}
    
	public String getDistrictSubName(){
		return districtSubName;
	}
	
	public void setDistrictSubName(String districtSubName){
		this.districtSubName = districtSubName;
	}
    
	public Long getNewestEventId(){
		return newestEventId;
	}
	
	public void setNewestEventId(Long newestEventId){
		this.newestEventId = newestEventId;
	}
    
	public String getNewestEventDate(){
		return newestEventDate;
	}
	
	public void setNewestEventDate(String newestEventDate){
		this.newestEventDate = newestEventDate;
	}
    
	public String getNewestEventRound(){
		return newestEventRound;
	}
	
	public void setNewestEventRound(String newestEventRound){
		this.newestEventRound = newestEventRound;
	}
    
	public Long getNewestEventMoney(){
		return newestEventMoney;
	}
	
	public void setNewestEventMoney(Long newestEventMoney){
		this.newestEventMoney = newestEventMoney;
	}
    
	public Long getSourceId(){
		return sourceId;
	}
	
	public void setSourceId(Long sourceId){
		this.sourceId = sourceId;
	}
    
	public String getCreateDate(){
		return createDate;
	}
	
	public void setCreateDate(String createDate){
		this.createDate = createDate;
	}
    
	public Integer getStatus(){
		return status;
	}
	
	public void setStatus(Integer status){
		this.status = status;
	}
    
	public String getBusinessModel(){
		return businessModel;
	}
	
	public void setBusinessModel(String businessModel){
		this.businessModel = businessModel;
	}
    
	public String getIndustryPainPoints(){
		return industryPainPoints;
	}
	
	public void setIndustryPainPoints(String industryPainPoints){
		this.industryPainPoints = industryPainPoints;
	}
    
	public Integer getTeamScore(){
		return teamScore;
	}
	
	public void setTeamScore(Integer teamScore){
		this.teamScore = teamScore;
	}
    
	public Integer getOperationScore(){
		return operationScore;
	}
	
	public void setOperationScore(Integer operationScore){
		this.operationScore = operationScore;
	}
    
	public Integer getScore(){
		return score;
	}
	
	public void setScore(Integer score){
		this.score = score;
	}
    
	public Integer getTimeSpan(){
		return timeSpan;
	}
	
	public void setTimeSpan(Integer timeSpan){
		this.timeSpan = timeSpan;
	}
    
	public String getInvestInfo(){
		return investInfo;
	}
	
	public void setInvestInfo(String investInfo){
		this.investInfo = investInfo;
	}
    
	public Integer getInvestNum(){
		return investNum;
	}
	
	public void setInvestNum(Integer investNum){
		this.investNum = investNum;
	}
    
	public Long getInvestMoney(){
		return investMoney;
	}
	
	public void setInvestMoney(Long investMoney){
		this.investMoney = investMoney;
	}
    
	public Timestamp getLoadTime(){
		return loadTime;
	}
	
	public void setLoadTime(Timestamp loadTime){
		this.loadTime = loadTime;
	}
    
	public Timestamp getUpdateTime(){
		return updateTime;
	}
	
	public void setUpdateTime(Timestamp updateTime){
		this.updateTime = updateTime;
	}
    }