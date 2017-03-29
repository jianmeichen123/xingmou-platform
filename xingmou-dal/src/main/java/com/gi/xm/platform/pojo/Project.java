package com.gi.xm.platform.pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.sql.Timestamp;
import java.util.Date;

public class Project extends Pojo {

        public static final String ID = "id";
        public static final String TITLE = "项目名称";
        public static final String PIC = "小图标，外链";
        public static final String PIC_BIG = "大图标，外链";
        public static final String PICSHOW = "图片展示，外链";
        public static final String WEBLINK = "项目网站地址";
        public static final String CEO_NAME = "创业者(CEO)名称";
        public static final String COMPANY_ID = "公司id，关联dm_company.id";
        public static final String COMPANY_NAME = "冗余：公司名称";
        public static final String INDUSTRY_ID = "行业id";
        public static final String INDUSTRY_SUB_ID = "子行业id";
        public static final String INDUSTRY_NAME = "冗余：行业名称";
        public static final String INDUSTRY_SUB_NAME = "冗余：子行业名称";
        public static final String DISTRICT_ID = "地区id";
        public static final String DISTRICT_NAME = "冗余：地区名称";
        public static final String DISTRICT_SUB_ID = "二级地区id";
        public static final String DISTRICT_SUB_NAME = "冗余：二级地区名称";
        public static final String NEWEST_EVENT_ID = "最近一次投资事件id";
        public static final String NEWEST_EVENT_DATE = "最近一次投资事件日期";
        public static final String NEWEST_EVENT_ROUND = "最近一次投资事件轮次";
        public static final String NEWEST_EVENT_ROUND_ID = "最近一次投资事件轮次id";
        public static final String NEWEST_EVENT_MONEY = "最近一次投资事件融资金额";
        public static final String SOURCE_ID = "源id";
        public static final String CREATE_DATE = "项目成立时间";
        public static final String STATUS = "status";
        public static final String BUSINESS_MODEL = "商业模式";
        public static final String INDUSTRY_PAIN_POINTS = "行业痛点";
        public static final String TEAM_SCORE = "团队能力得分";
        public static final String OPERATION_SCORE = "运营能力得分";
        public static final String SCORE = "综合得分";
        public static final String TIME_SPAN = "最近一次融资距上次融资时间间隔（月）";
        public static final String INVEST_INFO = "融资详情	";
        public static final String INVEST_NUM = "该项目的融资总笔数";
        public static final String INVEST_MONEY = "该项目的融资总金额";
        public static final String LOAD_TIME = "加载时间";
        public static final String UPDATE_TIME = "最后更新时间";
    
	
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
	 * @Fields newestEventRoundId : 最近一次投资事件轮次id
	 */
	private Integer newestEventRoundId;
	
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

	private String inverstrirmNames;

	/**
	 * @Fields description :项目简介
	 */
	private  String description;

	public Integer sourceType;

	/**
	 * @Fileds
	 */
	private String  newestEventInvestfirms;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    private String code;

	public String getInverstrirmNames() {
		return inverstrirmNames;
	}


	public void setInverstrirmNames(String inverstrirmNames) {
		this.inverstrirmNames = inverstrirmNames;
	}

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
    
	public Integer getNewestEventRoundId(){
		return newestEventRoundId;
	}

	public void setNewestEventRoundId(Integer newestEventRoundId){
		this.newestEventRoundId = newestEventRoundId;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public Integer getSourceType() {
		return sourceType;
	}

	public String getNewestEventInvestfirms() {
		return newestEventInvestfirms;
	}

	public void setNewestEventInvestfirms(String newestEventInvestfirms) {
		this.newestEventInvestfirms = newestEventInvestfirms;
	}

	public void setSourceType(Integer sourceType) {
		this.sourceType = sourceType;
	}
}