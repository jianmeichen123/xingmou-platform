package com.gi.ctdn.query;


import com.gi.xm.platform.view.common.QueryInfo;

import java.util.Date;

public class ProjectsQueryInfo extends QueryInfo {
	
	/**   
	 * @Fields serialVersionUID : 序列化版本号 
	 */ 
	private static final long serialVersionUID = 1L;

	
	private Long id;
	
	private String title;
	
	private Long companyId;
	
	private Long industryId;
	
	private String industryName;
	
	private Long industrySubId;
	
	private String industrySubName;
	
	private Date productReleaseDate;
	
	private String productUrl;
	
	private String productInfo;
	
	private String productCompete;
	
	private String productAchievements;
	
	private String bpFile;
	
	private String productLogo;
	
	private Long createdUid;
	
	private String createdUname;
	
	private Integer status;

	private Long addTime;

	private Long updateTime;
	
	private Long startLongTime;
	
	private Long endLongTime;
		
    private String startDate;

	private String endDate;

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
    
	public Long getCompanyId(){
		return companyId;
	}
	
	public void setCompanyId(Long companyId){
		this.companyId = companyId;
	}
    
	public Long getIndustryId(){
		return industryId;
	}
	
	public void setIndustryId(Long industryId){
		this.industryId = industryId;
	}
    
	public String getIndustryName(){
		return industryName;
	}
	
	public void setIndustryName(String industryName){
		this.industryName = industryName;
	}
    
	public Long getIndustrySubId(){
		return industrySubId;
	}
	
	public void setIndustrySubId(Long industrySubId){
		this.industrySubId = industrySubId;
	}
    
	public String getIndustrySubName(){
		return industrySubName;
	}
	
	public void setIndustrySubName(String industrySubName){
		this.industrySubName = industrySubName;
	}
    
	public Date getProductReleaseDate(){
		return productReleaseDate;
	}
	
	public void setProductReleaseDate(Date productReleaseDate){
		this.productReleaseDate = productReleaseDate;
	}
    
	public String getProductUrl(){
		return productUrl;
	}
	
	public void setProductUrl(String productUrl){
		this.productUrl = productUrl;
	}
    
	public String getProductInfo(){
		return productInfo;
	}
	
	public void setProductInfo(String productInfo){
		this.productInfo = productInfo;
	}
    
	public String getProductCompete(){
		return productCompete;
	}
	
	public void setProductCompete(String productCompete){
		this.productCompete = productCompete;
	}
    
	public String getProductAchievements(){
		return productAchievements;
	}
	
	public void setProductAchievements(String productAchievements){
		this.productAchievements = productAchievements;
	}
    
	public String getBpFile(){
		return bpFile;
	}
	
	public void setBpFile(String bpFile){
		this.bpFile = bpFile;
	}
    
	public String getProductLogo(){
		return productLogo;
	}
	
	public void setProductLogo(String productLogo){
		this.productLogo = productLogo;
	}
    
	public Long getCreatedUid(){
		return createdUid;
	}
	
	public void setCreatedUid(Long createdUid){
		this.createdUid = createdUid;
	}
    
	public String getCreatedUname(){
		return createdUname;
	}
	
	public void setCreatedUname(String createdUname){
		this.createdUname = createdUname;
	}
    
	public Integer getStatus(){
		return status;
	}
	
	public void setStatus(Integer status){
		this.status = status;
	}

	public Long getStartLongTime() {
		return startLongTime;
	}

	public void setStartLongTime(Long startLongTime) {
		this.startLongTime = startLongTime;
	}

	public Long getEndLongTime() {
		return endLongTime;
	}

	public void setEndLongTime(Long endLongTime) {
		this.endLongTime = endLongTime;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Long getAddTime() {
		return addTime;
	}

	public void setAddTime(Long addTime) {
		this.addTime = addTime;
	}

	public Long getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Long updateTime) {
		this.updateTime = updateTime;
	}
}