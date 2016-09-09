package com.gi.xm.platform.pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.sql.Timestamp;
import java.util.Date;

public class IndustryDataYear extends Pojo {

        public static final String ID = "id";
        public static final String YAAR = "年份";
        public static final String INDUSTRY_ID = "一级行业id";
        public static final String INDUSTRY_NAME = "一级行业名称(冗余)";
        public static final String INDUSTRY_SUB_ID = "二级行业id";
        public static final String INDUSTRY_SUB_NAME = "二级行业名称（冗余）";
        public static final String MARKET_MONEY = "市场规模-金额(市场总量)";
        public static final String MARKET_MONEY_RATE = "市场规模-同比增长率";
        public static final String MARKET_USER = "用户规模";
        public static final String MARKET_USER_RATE = "用户规模同比增长率";
        public static final String SINGLE_USER_VALUE = "单用户价值 = 市场规模/用户规模";
        public static final String MARKET_MONEY_STOCK = "市场存量";
        public static final String PROJECT_NUM = "项目数";
        public static final String INVESTED_NUM = "已获投项目数";
        public static final String INVESTED_NUM_RATE = "获投增长率(笔数增长率)";
        public static final String INVESTED_MONEY = "投资金额(元)";
        public static final String INVESTED_MONEY_RATE = "投资金额增长率";
        public static final String INVESTED_PER_MONEY = "平均融资金额(元)";
        public static final String INVESTED_MEDIAN_MONEY = "融资金额中位数(元)";
        public static final String INVESTED_MAX_MONEY = "最大融资金额（元）";
        public static final String ADD_TIME = "addTime";
        public static final String UPDATE_TIME = "updateTime";
    
	
	/**
	 * @Fields id : 
	 */
	private Long id;
	
	/**
	 * @Fields yaar : 年份
	 */
	private Integer yaar;
	
	/**
	 * @Fields industryId : 一级行业id
	 */
	private Integer industryId;
	
	/**
	 * @Fields industryName : 一级行业名称(冗余)
	 */
	private String industryName;
	
	/**
	 * @Fields industrySubId : 二级行业id
	 */
	private Integer industrySubId;
	
	/**
	 * @Fields industrySubName : 二级行业名称（冗余）
	 */
	private String industrySubName;
	
	/**
	 * @Fields marketMoney : 市场规模-金额(市场总量)
	 */
	private BigDecimal marketMoney;
	
	/**
	 * @Fields marketMoneyRate : 市场规模-同比增长率
	 */
	private Double marketMoneyRate;
	
	/**
	 * @Fields marketUser : 用户规模
	 */
	private Long marketUser;
	
	/**
	 * @Fields marketUserRate : 用户规模同比增长率
	 */
	private Integer marketUserRate;
	
	/**
	 * @Fields singleUserValue : 单用户价值 = 市场规模/用户规模
	 */
	private Long singleUserValue;
	
	/**
	 * @Fields marketMoneyStock : 市场存量
	 */
	private Long marketMoneyStock;
	
	/**
	 * @Fields projectNum : 项目数
	 */
	private Integer projectNum;
	
	/**
	 * @Fields investedNum : 已获投项目数
	 */
	private Integer investedNum;
	
	/**
	 * @Fields investedNumRate : 获投增长率(笔数增长率)
	 */
	private Integer investedNumRate;
	
	/**
	 * @Fields investedMoney : 投资金额(元)
	 */
	private Long investedMoney;
	
	/**
	 * @Fields investedMoneyRate : 投资金额增长率
	 */
	private Integer investedMoneyRate;
	
	/**
	 * @Fields investedPerMoney : 平均融资金额(元)
	 */
	private Long investedPerMoney;
	
	/**
	 * @Fields investedMedianMoney : 融资金额中位数(元)
	 */
	private Long investedMedianMoney;
	
	/**
	 * @Fields investedMaxMoney : 最大融资金额（元）
	 */
	private Long investedMaxMoney;
	
	/**
	 * @Fields addTime : 
	 */
	private Timestamp addTime;
	
	/**
	 * @Fields updateTime : 
	 */
	private Timestamp updateTime;
	
    
	public Long getId(){
		return id;
	}

	public void setId(Long id){
		this.id = id;
	}
    
	public Integer getYaar(){
		return yaar;
	}

	public void setYaar(Integer yaar){
		this.yaar = yaar;
	}
    
	public Integer getIndustryId(){
		return industryId;
	}

	public void setIndustryId(Integer industryId){
		this.industryId = industryId;
	}
    
	public String getIndustryName(){
		return industryName;
	}

	public void setIndustryName(String industryName){
		this.industryName = industryName;
	}
    
	public Integer getIndustrySubId(){
		return industrySubId;
	}

	public void setIndustrySubId(Integer industrySubId){
		this.industrySubId = industrySubId;
	}
    
	public String getIndustrySubName(){
		return industrySubName;
	}

	public void setIndustrySubName(String industrySubName){
		this.industrySubName = industrySubName;
	}
    
	public BigDecimal getMarketMoney(){
		return marketMoney;
	}

	public void setMarketMoney(BigDecimal marketMoney){
		this.marketMoney = marketMoney;
	}
    
	public Double getMarketMoneyRate(){
		return marketMoneyRate;
	}

	public void setMarketMoneyRate(Double marketMoneyRate){
		this.marketMoneyRate = marketMoneyRate;
	}
    
	public Long getMarketUser(){
		return marketUser;
	}

	public void setMarketUser(Long marketUser){
		this.marketUser = marketUser;
	}
    
	public Integer getMarketUserRate(){
		return marketUserRate;
	}

	public void setMarketUserRate(Integer marketUserRate){
		this.marketUserRate = marketUserRate;
	}
    
	public Long getSingleUserValue(){
		return singleUserValue;
	}

	public void setSingleUserValue(Long singleUserValue){
		this.singleUserValue = singleUserValue;
	}
    
	public Long getMarketMoneyStock(){
		return marketMoneyStock;
	}

	public void setMarketMoneyStock(Long marketMoneyStock){
		this.marketMoneyStock = marketMoneyStock;
	}
    
	public Integer getProjectNum(){
		return projectNum;
	}

	public void setProjectNum(Integer projectNum){
		this.projectNum = projectNum;
	}
    
	public Integer getInvestedNum(){
		return investedNum;
	}

	public void setInvestedNum(Integer investedNum){
		this.investedNum = investedNum;
	}
    
	public Integer getInvestedNumRate(){
		return investedNumRate;
	}

	public void setInvestedNumRate(Integer investedNumRate){
		this.investedNumRate = investedNumRate;
	}
    
	public Long getInvestedMoney(){
		return investedMoney;
	}

	public void setInvestedMoney(Long investedMoney){
		this.investedMoney = investedMoney;
	}
    
	public Integer getInvestedMoneyRate(){
		return investedMoneyRate;
	}

	public void setInvestedMoneyRate(Integer investedMoneyRate){
		this.investedMoneyRate = investedMoneyRate;
	}
    
	public Long getInvestedPerMoney(){
		return investedPerMoney;
	}

	public void setInvestedPerMoney(Long investedPerMoney){
		this.investedPerMoney = investedPerMoney;
	}
    
	public Long getInvestedMedianMoney(){
		return investedMedianMoney;
	}

	public void setInvestedMedianMoney(Long investedMedianMoney){
		this.investedMedianMoney = investedMedianMoney;
	}
    
	public Long getInvestedMaxMoney(){
		return investedMaxMoney;
	}

	public void setInvestedMaxMoney(Long investedMaxMoney){
		this.investedMaxMoney = investedMaxMoney;
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