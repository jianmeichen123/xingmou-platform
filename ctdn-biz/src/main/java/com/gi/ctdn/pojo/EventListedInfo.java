package com.gi.ctdn.pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.sql.Timestamp;
import java.util.Date;
import com.gi.xm.platform.view.common.PojoInfo;

public class EventListedInfo extends PojoInfo {


    
	
	/**
	 * @Fields listedEvent : 上市挂牌事件
	 */
	private String listedEvent;
	
	/**
	 * @Fields eventId : 事件ID
	 */
	private Integer eventId;
	
	/**
	 * @Fields code : 
	 */
	private String code;
	
	/**
	 * @Fields industry : 行业
	 */
	private String industry;
	
	/**
	 * @Fields type : 类型
	 */
	private String type;
	
	/**
	 * @Fields stockExchange : 交易所
	 */
	private String stockExchange;
	
	/**
	 * @Fields transferType : 转让方式
	 */
	private String transferType;
	
	/**
	 * @Fields marketLayer : 市场分层
	 */
	private String marketLayer;
	
	/**
	 * @Fields company : 公司
	 */
	private String projTitle;
	
	/**
	 * @Fields stockCode : 股票代码
	 */
	private String stockCode;
	
	/**
	 * @Fields listedDate : 上市/挂牌时间
	 */
	private Date listedDate;
	
	/**
	 * @Fields amountNum : 筹资额
	 */
	private Integer amountNum;
	
	/**
	 * @Fields amountStr : 筹资额字面量
	 */
	private String amountStr;
	
	/**
	 * @Fields issuePrice : 发行价
	 */
	private Integer issuePrice;
	
	/**
	 * @Fields districtSubName : 地区
	 */
	private String districtSubName;
	
	/**
	 * @Fields circulation : 发行量
	 */
	private Integer circulation;
	
	/**
	 * @Fields stockValue : 股本
	 */
	private String stockValue;
	
	/**
	 * @Fields peRatio : 市盈率
	 */
	private Integer peRatio;
	
	/**
	 * @Fields netRate : 市净率
	 */
	private Integer netRate;
	
	/**
	 * @Fields isVcPe : 是否VC/PE支持
	 */
	private String isVcPe;
	
	/**
	 * @Fields salesSum : 总上市费用
	 */
	private Integer salesSum;
	
	/**
	 * @Fields accountFirms : 会计师事务所
	 */
	private String accountFirms;
	
	/**
	 * @Fields lawFirms : 律师事务所
	 */
	private String lawFirms;
	
	/**
	 * @Fields desc : 描述
	 */
	private String desc;
	
	/**
	 * @Fields prospectus : 招股说明书
	 */
	private String prospectus;
	
	/**
	 * @Fields fiscaleReport : 财务会计报告
	 */
	private String fiscaleReport;
	
	/**
	 * @Fields articles : 公司章程
	 */
	private String articles;
	
	/**
	 * @Fields sourceId : 上市挂牌项目/投资机构 id
	 */
	private Integer sourceId;
	
	/**
	 * @Fields sourceCode : 上市挂牌项目/投资机构 code
	 */
	private String sourceCode;
	
	/**
	 * @Fields logo : 列表项logo
	 */
	private String logo;
	
	/**
	 * @Fields industryName : 一级行业
	 */
	private String industryName;
	
	/**
	 * @Fields industrySubName : 二级行业
	 */
	private String industrySubName;
	
	/**
	 * @Fields industryGrandsonName : 三级行业
	 */
	private String industryGrandsonName;
	
	/**
	 * @Fields industryIds : 行业ids,各级行业逗号分隔
	 */
	private String industryIds;
	
	/**
	 * @Fields bodyRole : 预留 挂牌事件的主体
	 */
	private String bodyRole;
	
	/**
	 * @Fields sourceType : 预留 类型:指定是项目或投资机构
	 */
	private String sourceType;
	
	/**
	 * @Fields isClick : 预留 是否可点击
	 */
	private String isClick;
	
    
	public String getListedEvent(){
		return listedEvent;
	}

	public void setListedEvent(String listedEvent){
		this.listedEvent = listedEvent;
	}
    
	public Integer getEventId(){
		return eventId;
	}

	public void setEventId(Integer eventId){
		this.eventId = eventId;
	}
    
	public String getCode(){
		return code;
	}

	public void setCode(String code){
		this.code = code;
	}
    
	public String getIndustry(){
		return industry;
	}

	public void setIndustry(String industry){
		this.industry = industry;
	}
    
	public String getType(){
		return type;
	}

	public void setType(String type){
		this.type = type;
	}
    
	public String getStockExchange(){
		return stockExchange;
	}

	public void setStockExchange(String stockExchange){
		this.stockExchange = stockExchange;
	}
    
	public String getTransferType(){
		return transferType;
	}

	public void setTransferType(String transferType){
		this.transferType = transferType;
	}
    
	public String getMarketLayer(){
		return marketLayer;
	}

	public void setMarketLayer(String marketLayer){
		this.marketLayer = marketLayer;
	}

	public String getProjTitle() {
		return projTitle;
	}

	public void setProjTitle(String projTitle) {
		this.projTitle = projTitle;
	}

	public String getStockCode(){
		return stockCode;
	}

	public void setStockCode(String stockCode){
		this.stockCode = stockCode;
	}
    
	public Date getListedDate(){
		return listedDate;
	}

	public void setListedDate(Date listedDate){
		this.listedDate = listedDate;
	}
    
	public Integer getAmountNum(){
		return amountNum;
	}

	public void setAmountNum(Integer amountNum){
		this.amountNum = amountNum;
	}
    
	public String getAmountStr(){
		return amountStr;
	}

	public void setAmountStr(String amountStr){
		this.amountStr = amountStr;
	}
    
	public Integer getIssuePrice(){
		return issuePrice;
	}

	public void setIssuePrice(Integer issuePrice){
		this.issuePrice = issuePrice;
	}

	public String getDistrictSubName() {
		return districtSubName;
	}

	public void setDistrictSubName(String districtSubName) {
		this.districtSubName = districtSubName;
	}

	public Integer getCirculation(){
		return circulation;
	}

	public void setCirculation(Integer circulation){
		this.circulation = circulation;
	}
    
	public String getStockValue(){
		return stockValue;
	}

	public void setStockValue(String stockValue){
		this.stockValue = stockValue;
	}
    
	public Integer getPeRatio(){
		return peRatio;
	}

	public void setPeRatio(Integer peRatio){
		this.peRatio = peRatio;
	}
    
	public Integer getNetRate(){
		return netRate;
	}

	public void setNetRate(Integer netRate){
		this.netRate = netRate;
	}
    
	public String getIsVcPe(){
		return isVcPe;
	}

	public void setIsVcPe(String isVcPe){
		this.isVcPe = isVcPe;
	}
    
	public Integer getSalesSum(){
		return salesSum;
	}

	public void setSalesSum(Integer salesSum){
		this.salesSum = salesSum;
	}
    
	public String getAccountFirms(){
		return accountFirms;
	}

	public void setAccountFirms(String accountFirms){
		this.accountFirms = accountFirms;
	}
    
	public String getLawFirms(){
		return lawFirms;
	}

	public void setLawFirms(String lawFirms){
		this.lawFirms = lawFirms;
	}
    
	public String getDesc(){
		return desc;
	}

	public void setDesc(String desc){
		this.desc = desc;
	}
    
	public String getProspectus(){
		return prospectus;
	}

	public void setProspectus(String prospectus){
		this.prospectus = prospectus;
	}
    
	public String getFiscaleReport(){
		return fiscaleReport;
	}

	public void setFiscaleReport(String fiscaleReport){
		this.fiscaleReport = fiscaleReport;
	}
    
	public String getArticles(){
		return articles;
	}

	public void setArticles(String articles){
		this.articles = articles;
	}
    
	public Integer getSourceId(){
		return sourceId;
	}

	public void setSourceId(Integer sourceId){
		this.sourceId = sourceId;
	}
    
	public String getSourceCode(){
		return sourceCode;
	}

	public void setSourceCode(String sourceCode){
		this.sourceCode = sourceCode;
	}
    
	public String getLogo(){
		return logo;
	}

	public void setLogo(String logo){
		this.logo = logo;
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
    
	public String getIndustryGrandsonName(){
		return industryGrandsonName;
	}

	public void setIndustryGrandsonName(String industryGrandsonName){
		this.industryGrandsonName = industryGrandsonName;
	}
    
	public String getIndustryIds(){
		return industryIds;
	}

	public void setIndustryIds(String industryIds){
		this.industryIds = industryIds;
	}
    
	public String getBodyRole(){
		return bodyRole;
	}

	public void setBodyRole(String bodyRole){
		this.bodyRole = bodyRole;
	}
    
	public String getSourceType(){
		return sourceType;
	}

	public void setSourceType(String sourceType){
		this.sourceType = sourceType;
	}
    
	public String getIsClick(){
		return isClick;
	}

	public void setIsClick(String isClick){
		this.isClick = isClick;
	}
    }