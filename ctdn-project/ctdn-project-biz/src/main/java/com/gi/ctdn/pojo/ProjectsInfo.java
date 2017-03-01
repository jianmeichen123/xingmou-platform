package com.gi.ctdn.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ProjectsInfo extends CtdnPojo implements Serializable {

	/**   
	 * @Fields serialVersionUID : 序列化版本号 
	 */ 
	private static final long serialVersionUID = 1L;

			
	/**
	 * @Fields id : 
	 */
	private Long id;
			
	/**
	 * @Fields title : 项目名称
	 */
	private String title;
			
	/**
	 * @Fields companyId : 所属公司id
	 */
	private Long companyId;
			
	/**
	 * @Fields industryId : 一级行业id
	 */
	private Long industryId;
			
	/**
	 * @Fields industryName : 一级行业名称
	 */
	private String industryName;
			
	/**
	 * @Fields industrySubId : 二级行业id
	 */
	private Long industrySubId;
			
	/**
	 * @Fields industrySubName : 二级行业名称
	 */
	private String industrySubName;
			
	/**
	 * @Fields productInfo : 产品简介
	 */
	private String productInfo;
			
	/**
	 * @Fields productCompete : 竞品及竞争优势
	 */
	private String productCompete;
			
	/**
	 * @Fields productAchievements : 产品成绩
	 */
	private String productAchievements;
			
	/**
	 * @Fields bpFile : bp文件路径
	 */
	private String bpFile;

	/**
	 * @Fields productLogo : 产品logo文件地址
	 */
	private String productLogo;
			
	/**
	 * @Fields status : 状态
	 */
	private Integer status;

	/**
	 * @Fields labelNames
	 */
	private String labelNames;

	/**
	 * @Fields productList
	 */
	private List<ProjectProductInfo> productList;
	/**
	 * @Fields projectPicList
	 */
	private List<String> projectPicList;

	/**
	 * @Fields 最新融资轮次
     */
	private String newestRoundName;

	/**
	 * @Fields 最新融资时间
     */
	private Date newestInvestDate;

	/**
	 *  @Fields 融资金额单位
	 */
	private String currentName;

	/**
	 * @Fields 最新融资金额
	 */
	private Long newestEventMoney;

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

	public String getLabelNames() {
		return labelNames;
	}

	public void setLabelNames(String labelNames) {
		this.labelNames = labelNames;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<ProjectProductInfo> getProductList() {
		return productList;
	}

	public void setProductList(List<ProjectProductInfo> productList) {
		this.productList = productList;
	}

	public List<String> getProjectPicList() {
		return projectPicList;
	}

	public void setProjectPicList(List<String> projectPicList) {
		this.projectPicList = projectPicList;
	}

	public String getNewestRoundName() {
		return newestRoundName;
	}

	public void setNewestRoundName(String newestRoundName) {
		this.newestRoundName = newestRoundName;
	}

	public Date getNewestInvestDate() {
		return newestInvestDate;
	}

	public void setNewestInvestDate(Date newestInvestDate) {
		this.newestInvestDate = newestInvestDate;
	}

	public Long getNewestEventMoney() {
		return newestEventMoney;
	}

	public void setNewestEventMoney(Long newestEventMoney) {
		this.newestEventMoney = newestEventMoney;
	}

	public void setCurrentName(String currentName) {
		this.currentName = currentName;
	}

	public String getCurrentName() {
		return currentName;
	}
}