package com.gi.xm.report.pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class InvestfirmsData extends Pojo {

        public static final String ID = "id";
        public static final String INVESTFIRM_ID = "投资机构id";
        public static final String INVESTFIRM_NAME = "冗余投资机构名称";
        public static final String INVESTFIRM_LINK = "冗余机构网址";
        public static final String INVEST_NUM = "总投资笔数";
        public static final String INVEST_MONEY = "总投资金额（元）";
        public static final String INVEST_INDUSTRY = "投资过的一级行业";
        public static final String INVEST_ROUND = "投资过的轮次";
        public static final String NEWEST_INVEST_PROJECTS = "投资过的项目名称（最近三个）";
        public static final String INVEST_MONTH_RATE = "上月同比增长率（笔数）";
        public static final String ADD_TIME = "addTime";
        public static final String UPDATE_TIME = "updateTime";
    
	
	/**
	 * @Fields id : 
	 */
	private Integer id;
	
	/**
	 * @Fields investfirmId : 投资机构id
	 */
	private Long investfirmId;
	
	private Long sourceId;
	/**
	 * @Fields investfirmName : 冗余投资机构名称
	 */
	private String investfirmName;
	
	/**
	 * @Fields investfirmLink : 冗余机构网址
	 */
	private String investfirmLink;
	
	/**
	 * @Fields investNum : 总投资笔数
	 */
	private Integer investNum;
	
	/**
	 * @Fields investMoney : 总投资金额（元）
	 */
	private Long investMoney;
	
	/**
	 * @Fields investIndustry : 投资过的一级行业
	 */
	private String investIndustry;
	
	/**
	 * @Fields investRound : 投资过的轮次
	 */
	private String investRound;
	
	/**
	 * @Fields newestInvestProjects : 投资过的项目名称（最近三个）
	 */
	private String newestInvestProjects;
	
	/**
	 * @Fields investMonthRate : 上月同比增长率（笔数）
	 */
	private Integer investMonthRate;
	
	/**
	 * @Fields addTime : 
	 */
	private Timestamp addTime;

	//
	private List<Integer> industryIdList;
	private List<Integer> roundIdList;
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

	public List<Integer> getIndustryIdList() {
		return industryIdList;
	}

	public void setIndustryIdList(List<Integer> industryIdList) {
		this.industryIdList = industryIdList;
	}

	public List<Integer> getRoundIdList() {
		return roundIdList;
	}

	public void setRoundIdList(List<Integer> roundIdList) {
		this.roundIdList = roundIdList;
	}

	/**
	 * @Fields updateTime : 
	 */
	private Timestamp updateTime;

	private boolean doOrder = true ;
	private int pageIndex = 1;
	private int pageSize = 10;
	private String order;
	private String orderBy;
	private String returnFields;
	private String pic;

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public String getReturnFields() {
		return returnFields;
	}

	public void setReturnFields(String returnFields) {
		this.returnFields = returnFields;
	}

	public boolean isDoOrder() {
		return doOrder;
	}

	public void setDoOrder(boolean doOrder) {
		this.doOrder = doOrder;
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

	public Long getSourceId(){
		return sourceId;
	}

	public void setSourceId(Long sourceId){
		this.sourceId = sourceId;
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