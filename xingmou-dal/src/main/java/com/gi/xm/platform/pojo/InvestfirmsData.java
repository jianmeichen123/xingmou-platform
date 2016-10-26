package com.gi.xm.platform.pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.sql.Timestamp;
import java.util.Date;

public class InvestfirmsData extends Pojo {

        public static final String ID = "id";
        public static final String INVESTFIRM_ID = "??èµ??ºæ??id";
        public static final String INVESTFIRM_NAME = "??ä½???èµ??ºæ????ç§?";
        public static final String INVESTFIRM_LINK = "??ä½??ºæ??ç½???";
        public static final String INVEST_NUM = "?»æ??èµ?ç¬???";
        public static final String INVEST_MONEY = "?»æ??èµ???é¢?ï¼???ï¼?";
        public static final String INVEST_INDUSTRY = "??èµ?è¿???ä¸?çº§è?ä¸?";
        public static final String INVEST_ROUND = "??èµ?è¿???è½?æ¬?";
        public static final String NEWEST_INVEST_PROJECTS = "??èµ?è¿???é¡¹ç????ç§°ï???è¿?ä¸?ä¸?ï¼?";
        public static final String INVEST_MONTH_RATE = "ä¸?????æ¯?å¢??¿ç??ï¼?ç¬??°ï?";
        public static final String ADD_TIME = "addTime";
        public static final String UPDATE_TIME = "updateTime";
    
	
	/**
	 * @Fields id : 
	 */
	private Integer id;
	
	/**
	 * @Fields investfirmId : ??èµ??ºæ??id
	 */
	private Long investfirmId;
	
	/**
	 * @Fields investfirmName : ??ä½???èµ??ºæ????ç§?
	 */
	private String investfirmName;
	
	/**
	 * @Fields investfirmLink : ??ä½??ºæ??ç½???
	 */
	private String investfirmLink;
	
	/**
	 * @Fields investNum : ?»æ??èµ?ç¬???
	 */
	private Integer investNum;
	
	/**
	 * @Fields investMoney : ?»æ??èµ???é¢?ï¼???ï¼?
	 */
	private Long investMoney;

	private  Long sourceId;
	private String pic;

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}
	public Long getSourceId() {
		return sourceId;
	}

	public void setSourceId(Long sourceId) {
		this.sourceId = sourceId;
	}

	/**
	 * @Fields investIndustry : ??èµ?è¿???ä¸?çº§è?ä¸?
	 */
	private String investIndustry;
	
	/**
	 * @Fields investRound : ??èµ?è¿???è½?æ¬?
	 */
	private String investRound;
	
	/**
	 * @Fields newestInvestProjects : ??èµ?è¿???é¡¹ç????ç§°ï???è¿?ä¸?ä¸?ï¼?
	 */
	private String newestInvestProjects;
	
	/**
	 * @Fields investMonthRate : ä¸?????æ¯?å¢??¿ç??ï¼?ç¬??°ï?
	 */
	private Integer investMonthRate;
	
	/**
	 * @Fields addTime : 
	 */
	private Timestamp addTime;
	
	/**
	 * @Fields updateTime : 
	 */
	private Timestamp updateTime;

	private Integer[] newestEventRoundIds;

	private Long[] industryIds;

	public Integer[] getNewestEventRoundIds() {
		return newestEventRoundIds;
	}

	public void setNewestEventRoundIds(Integer[] newestEventRoundIds) {
		this.newestEventRoundIds = newestEventRoundIds;
	}

	public Long[] getIndustryIds() {
		return industryIds;
	}

	public void setIndustryIds(Long[] industryIds) {
		this.industryIds = industryIds;
	}

	public Integer getId(){
		return id;
	}

	public void setId(Integer id){
		this.id = id;
	}
    
	public Long getInvestfirmId(){
		return investfirmId;
	}

	public void setInvestfirmId(Long investfirmId){
		this.investfirmId = investfirmId;
	}
    
	public String getInvestfirmName(){
		return investfirmName;
	}

	public void setInvestfirmName(String investfirmName){
		this.investfirmName = investfirmName;
	}
    
	public String getInvestfirmLink(){
		return investfirmLink;
	}

	public void setInvestfirmLink(String investfirmLink){
		this.investfirmLink = investfirmLink;
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
    
	public String getInvestIndustry(){
		return investIndustry;
	}

	public void setInvestIndustry(String investIndustry){
		this.investIndustry = investIndustry;
	}
    
	public String getInvestRound(){
		return investRound;
	}

	public void setInvestRound(String investRound){
		this.investRound = investRound;
	}
    
	public String getNewestInvestProjects(){
		return newestInvestProjects;
	}

	public void setNewestInvestProjects(String newestInvestProjects){
		this.newestInvestProjects = newestInvestProjects;
	}
    
	public Integer getInvestMonthRate(){
		return investMonthRate;
	}

	public void setInvestMonthRate(Integer investMonthRate){
		this.investMonthRate = investMonthRate;
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