package com.gi.xm.platform.view;

import java.math.BigDecimal;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class ProjectInfo implements Serializable {

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
	 * @Fields pic : 小图标，外链
	 */
	private String pic;
			
	/**
	 * @Fields picBig : 大图标，外链
	 */
	private String picBig;
			
	/**
	 * @Fields picshow : 图片展示，外链
	 */
	private String picshow;
			
	/**
	 * @Fields weblink : 项目网站地址
	 */
	private String weblink;
			
	/**
	 * @Fields ceoName : 创业者(CEO)名称
	 */
	private String ceoName;
			
	/**
	 * @Fields companyId : 公司id，关联dm_company.id
	 */
	private Long companyId;
			
	/**
	 * @Fields companyName : 冗余：公司名称
	 */
	private String companyName;
			
	/**
	 * @Fields industryId : 行业id
	 */
	private Long industryId;
			
	/**
	 * @Fields industrySubId : 子行业id
	 */
	private Long industrySubId;
			
	/**
	 * @Fields industryName : 冗余：行业名称
	 */
	private String industryName;
			
	/**
	 * @Fields industrySubName : 冗余：子行业名称
	 */
	private String industrySubName;
			
	/**
	 * @Fields districtId : 地区id
	 */
	private Long districtId;
			
	/**
	 * @Fields districtName : 冗余：地区名称
	 */
	private String districtName;
			
	/**
	 * @Fields districtSubId : 二级地区id
	 */
	private Long districtSubId;
			
	/**
	 * @Fields districtSubName : 冗余：二级地区名称
	 */
	private String districtSubName;
			
	/**
	 * @Fields newestEventId : 最近一次投资事件id
	 */
	private Long newestEventId;
			
	/**
	 * @Fields newestEventDate : 最近一次投资事件日期
	 */
	private String newestEventDate;
			
	/**
	 * @Fields newestEventRound : 最近一次投资事件轮次
	 */
	private String newestEventRound;
			
	/**
	 * @Fields newestEventMoney : 最近一次投资事件融资金额
	 */
	private Long newestEventMoney;
			
	/**
	 * @Fields sourceId : 源id
	 */
	private Long sourceId;
			
	/**
	 * @Fields createDate : 项目成立时间
	 */
	private String createDate;
			
	/**
	 * @Fields status : 
	 */
	private Integer status;
			
	/**
	 * @Fields businessModel : 商业模式
	 */
	private String businessModel;
			
	/**
	 * @Fields industryPainPoints : 行业痛点
	 */
	private String industryPainPoints;
			
	/**
	 * @Fields teamScore : 团队能力得分
	 */
	private Integer teamScore;
			
	/**
	 * @Fields operationScore : 运营能力得分
	 */
	private Integer operationScore;
			
	/**
	 * @Fields score : 综合得分
	 */
	private Integer score;
			
	/**
	 * @Fields timeSpan : 最近一次融资距上次融资时间间隔（月）
	 */
	private Integer timeSpan;
			
	/**
	 * @Fields investInfo : 融资详情	
	 */
	private String investInfo;
			
	/**
	 * @Fields investNum : 该项目的融资总笔数
	 */
	private Integer investNum;
			
	/**
	 * @Fields investMoney : 该项目的融资总金额
	 */
	private Long investMoney;
			
	/**
	 * @Fields loadTime : 加载时间
	 */
	private Timestamp loadTime;
			
	/**
	 * @Fields updateTime : 最后更新时间
	 */
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