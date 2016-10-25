package com.gi.xm.report.pojo;

import java.sql.Timestamp;

public class TargetIndustryHot extends Pojo {

        public static final String ID = "id";
        public static final String INDUSTRY_ID = "行业id";
        public static final String INDUSTRY_NAME = "冗余：行业名称";
        public static final String INDUSTRY_LEVEL = "1. 一级行业 2二级行业";
        public static final String INVEST_HOT = "投资热度";
        public static final String INVEST_MONEY_PER_A = "种子/天使轮";
        public static final String INVEST_MONEY_PER_B = "Pre-A/A/A+轮";
        public static final String INVEST_MONEY_PER_C = "Pre-B/B/B+轮";
        public static final String INVEST_MONEY_PER_D = "C轮";
        public static final String INVEST_MONEY_PER_E = "D~F轮";
        public static final String INVEST_MONEY_PER_F = "IOP及以后";
        public static final String INVEST_MONEY_PER_G = "并购";
        public static final String INVEST_MONEY_PER_H = "不明确";
        public static final String INVEST_MONEY_PER_I = "其它";
        public static final String ADD_TIME = "addTime";
        public static final String UPDATE_TIME = "updateTime";
    
	
	/**
	 * @Fields id : 
	 */
	private Integer id;
	
	/**
	 * @Fields industryId : 行业id
	 */
	private Integer industryId;
	
	/**
	 * @Fields industryName : 冗余：行业名称
	 */
	private String industryName;
	
	/**
	 * @Fields industryLevel : 1. 一级行业 2二级行业
	 */
	private Integer industryLevel;
	
	/**
	 * @Fields investHot : 投资热度
	 */
	private Integer investHot;
	
	/**
	 * @Fields investMoneyPerA : 种子/天使轮
	 */
	private Long investMoneyPerA;
	
	/**
	 * @Fields investMoneyPerB : Pre-A/A/A+轮
	 */
	private Long investMoneyPerB;
	
	/**
	 * @Fields investMoneyPerC : Pre-B/B/B+轮
	 */
	private Long investMoneyPerC;
	
	/**
	 * @Fields investMoneyPerD : C轮
	 */
	private Long investMoneyPerD;
	
	/**
	 * @Fields investMoneyPerE : D~F轮
	 */
	private Long investMoneyPerE;
	
	/**
	 * @Fields investMoneyPerF : IOP及以后
	 */
	private Long investMoneyPerF;
	
	/**
	 * @Fields investMoneyPerG : 并购
	 */
	private Long investMoneyPerG;
	
	/**
	 * @Fields investMoneyPerH : 不明确
	 */
	private Long investMoneyPerH;
	
	/**
	 * @Fields investMoneyPerI : 其它
	 */
	private Long investMoneyPerI;
	
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
    
	public Integer getIndustryLevel(){
		return industryLevel;
	}

	public void setIndustryLevel(Integer industryLevel){
		this.industryLevel = industryLevel;
	}
    
	public Integer getInvestHot(){
		return investHot;
	}

	public void setInvestHot(Integer investHot){
		this.investHot = investHot;
	}
    
	public Long getInvestMoneyPerA(){
		return investMoneyPerA;
	}

	public void setInvestMoneyPerA(Long investMoneyPerA){
		this.investMoneyPerA = investMoneyPerA;
	}
    
	public Long getInvestMoneyPerB(){
		return investMoneyPerB;
	}

	public void setInvestMoneyPerB(Long investMoneyPerB){
		this.investMoneyPerB = investMoneyPerB;
	}
    
	public Long getInvestMoneyPerC(){
		return investMoneyPerC;
	}

	public void setInvestMoneyPerC(Long investMoneyPerC){
		this.investMoneyPerC = investMoneyPerC;
	}
    
	public Long getInvestMoneyPerD(){
		return investMoneyPerD;
	}

	public void setInvestMoneyPerD(Long investMoneyPerD){
		this.investMoneyPerD = investMoneyPerD;
	}
    
	public Long getInvestMoneyPerE(){
		return investMoneyPerE;
	}

	public void setInvestMoneyPerE(Long investMoneyPerE){
		this.investMoneyPerE = investMoneyPerE;
	}
    
	public Long getInvestMoneyPerF(){
		return investMoneyPerF;
	}

	public void setInvestMoneyPerF(Long investMoneyPerF){
		this.investMoneyPerF = investMoneyPerF;
	}
    
	public Long getInvestMoneyPerG(){
		return investMoneyPerG;
	}

	public void setInvestMoneyPerG(Long investMoneyPerG){
		this.investMoneyPerG = investMoneyPerG;
	}
    
	public Long getInvestMoneyPerH(){
		return investMoneyPerH;
	}

	public void setInvestMoneyPerH(Long investMoneyPerH){
		this.investMoneyPerH = investMoneyPerH;
	}
    
	public Long getInvestMoneyPerI(){
		return investMoneyPerI;
	}

	public void setInvestMoneyPerI(Long investMoneyPerI){
		this.investMoneyPerI = investMoneyPerI;
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