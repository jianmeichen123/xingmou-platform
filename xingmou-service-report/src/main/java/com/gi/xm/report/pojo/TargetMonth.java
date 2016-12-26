package com.gi.xm.report.pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.sql.Timestamp;
import java.util.Date;

public class TargetMonth extends Pojo {

        public static final String ID = "id";
        public static final String YEAR = "年";
        public static final String MONTH = "月";
        public static final String YM = "ym";
        public static final String INDUSTRY_ID = "一级行业id";
        public static final String INDUSTRY_NAME = "一级行业名";
        public static final String INDUSTRY_SUB_ID = "二级行业id";
        public static final String INDUSTRY_SUB_NAME = "二级行业名";
        public static final String DISTRICT_ID = "一级地区id";
        public static final String DISTRICT_NAME = "一级地区名";
        public static final String INVEST_NUM = "融资笔数";
        public static final String INVEST_MONEY = "融资金额";
        public static final String CREATE_NUM = "新增项目数";
        public static final String ACTIVE_INVESTFIRM_NUM = "活跃机构数";
        public static final String TYPE = "type";
        public static final String INDUSTRY_TYPE = "1.行业一级 2.行业二级";
        public static final String ADD_TIME = "addTime";
        public static final String UPDATE_TIME = "updateTime";
    
	
	/**
	 * @Fields id : 
	 */
	private Integer id;
	
	/**
	 * @Fields year : 年
	 */
	private Integer year;
	
	/**
	 * @Fields month : 月
	 */
	private Integer month;
	
	/**
	 * @Fields ym : 
	 */
	private Date ym;
	
	/**
	 * @Fields industryId : 一级行业id
	 */
	private Integer industryId;
	
	/**
	 * @Fields industryName : 一级行业名
	 */
	private String industryName;
	
	/**
	 * @Fields industrySubId : 二级行业id
	 */
	private Integer industrySubId;
	
	/**
	 * @Fields industrySubName : 二级行业名
	 */
	private String industrySubName;
	
	/**
	 * @Fields districtId : 一级地区id
	 */
	private Integer districtId;
	
	/**
	 * @Fields districtName : 一级地区名
	 */
	private String districtName;
	
	/**
	 * @Fields investNum : 融资笔数
	 */
	private Integer investNum;
	
	/**
	 * @Fields investMoney : 融资金额
	 */
	private Long investMoney;
	
	/**
	 * @Fields createNum : 新增项目数
	 */
	private Integer createNum;
	
	/**
	 * @Fields activeInvestfirmNum : 活跃机构数
	 */
	private Integer activeInvestfirmNum;
	
	/**
	 * @Fields type : 
	 */
	private Integer type;
	
	/**
	 * @Fields industryType : 1.行业一级 2.行业二级
	 */
	private Integer industryType;
	
	/**
	 * @Fields addTime : 
	 */
	private Timestamp addTime;
	
	/**
	 * @Fields updateTime : 
	 */
	private Timestamp updateTime;
	
    
	public Integer getId(){
		return id;
	}

	public void setId(Integer id){
		this.id = id;
	}
    
	public Integer getYear(){
		return year;
	}

	public void setYear(Integer year){
		this.year = year;
	}
    
	public Integer getMonth(){
		return month;
	}

	public void setMonth(Integer month){
		this.month = month;
	}
    
	public Date getYm(){
		return ym;
	}

	public void setYm(Date ym){
		this.ym = ym;
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
    
	public Integer getDistrictId(){
		return districtId;
	}

	public void setDistrictId(Integer districtId){
		this.districtId = districtId;
	}
    
	public String getDistrictName(){
		return districtName;
	}

	public void setDistrictName(String districtName){
		this.districtName = districtName;
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
    
	public Integer getCreateNum(){
		return createNum;
	}

	public void setCreateNum(Integer createNum){
		this.createNum = createNum;
	}
    
	public Integer getActiveInvestfirmNum(){
		return activeInvestfirmNum;
	}

	public void setActiveInvestfirmNum(Integer activeInvestfirmNum){
		this.activeInvestfirmNum = activeInvestfirmNum;
	}
    
	public Integer getType(){
		return type;
	}

	public void setType(Integer type){
		this.type = type;
	}
    
	public Integer getIndustryType(){
		return industryType;
	}

	public void setIndustryType(Integer industryType){
		this.industryType = industryType;
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