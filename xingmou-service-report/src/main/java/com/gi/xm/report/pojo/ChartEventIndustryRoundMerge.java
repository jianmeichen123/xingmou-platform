package com.gi.xm.report.pojo;

import com.gi.xm.report.pojo.Pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.sql.Timestamp;
import java.util.Date;

public class ChartEventIndustryRoundMerge extends Pojo {

	public static final String ID = "id";
	public static final String YEAR = "年份";
	public static final String PARENT_ID = "行业上级id";
	public static final String INDUSTRY_ID = "行业id";
	public static final String INDUSTRY_NAME = "行业名称";
	public static final String INDUSTRY_LEVEL = "1.一级行业  2.二级行业";
	public static final String MONEY_LEVEL_ORDER_ID = "融资金额等级临时id，可用于排序、格式化数据";
	public static final String MONEY_LEVEL_NAME = "融资金额等级";
	public static final String INVEST_NUM_A = "融资笔数,种子/天使轮";
	public static final String INVEST_NUM_PERCENT_A = "融资笔数占比（%）";
	public static final String INVEST_NUM_RATE_A = "笔数环比增长率（%）";
	public static final String INVEST_MONEY_A = "融资金额";
	public static final String INVEST_MONEY_RATE_A = "金额环比增长率（%）";
	public static final String INVEST_MONEY_PER_A = "平均融资额";
	public static final String INVEST_MONEY_MAX_A = "最大融资额";
	public static final String INVEST_NUM_B = "融资笔数,Pre-A/A/A+轮";
	public static final String INVEST_NUM_PERCENT_B = "融资笔数占比（%）";
	public static final String INVEST_NUM_RATE_B = "笔数环比增长率（%）";
	public static final String INVEST_MONEY_B = "融资金额";
	public static final String INVEST_MONEY_RATE_B = "金额环比增长率（%）";
	public static final String INVEST_MONEY_PER_B = "平均融资额";
	public static final String INVEST_MONEY_MAX_B = "最大融资额";
	public static final String INVEST_NUM_C = "融资笔数,Pre-B/B/B+轮";
	public static final String INVEST_NUM_PERCENT_C = "融资笔数占比（%）";
	public static final String INVEST_NUM_RATE_C = "笔数环比增长率（%）";
	public static final String INVEST_MONEY_C = "融资金额";
	public static final String INVEST_MONEY_RATE_C = "金额环比增长率（%）";
	public static final String INVEST_MONEY_PER_C = "平均融资额";
	public static final String INVEST_MONEY_MAX_C = "最大融资额";
	public static final String INVEST_NUM_D = "融资笔数,C轮";
	public static final String INVEST_NUM_PERCENT_D = "融资笔数占比（%）";
	public static final String INVEST_NUM_RATE_D = "笔数环比增长率（%）";
	public static final String INVEST_MONEY_D = "融资金额";
	public static final String INVEST_MONEY_RATE_D = "金额环比增长率（%）";
	public static final String INVEST_MONEY_PER_D = "平均融资额";
	public static final String INVEST_MONEY_MAX_D = "最大融资额";
	public static final String INVEST_NUM_E = "融资笔数,D~F轮";
	public static final String INVEST_NUM_PERCENT_E = "融资笔数占比（%）";
	public static final String INVEST_NUM_RATE_E = "笔数环比增长率（%）";
	public static final String INVEST_MONEY_E = "融资金额";
	public static final String INVEST_MONEY_RATE_E = "金额环比增长率（%）";
	public static final String INVEST_MONEY_PER_E = "平均融资额";
	public static final String INVEST_MONEY_MAX_E = "最大融资额";
	public static final String INVEST_NUM_F = "融资笔数,IOP及以后";
	public static final String INVEST_NUM_PERCENT_F = "融资笔数占比（%）";
	public static final String INVEST_NUM_RATE_F = "笔数环比增长率（%）";
	public static final String INVEST_MONEY_F = "融资金额";
	public static final String INVEST_MONEY_RATE_F = "金额环比增长率（%）";
	public static final String INVEST_MONEY_PER_F = "平均融资额";
	public static final String INVEST_MONEY_MAX_F = "最大融资额";
	public static final String INVEST_NUM_G = "融资笔数,并购";
	public static final String INVEST_NUM_PERCENT_G = "融资笔数占比（%）";
	public static final String INVEST_NUM_RATE_G = "笔数环比增长率（%）";
	public static final String INVEST_MONEY_G = "融资金额";
	public static final String INVEST_MONEY_RATE_G = "金额环比增长率（%）";
	public static final String INVEST_MONEY_PER_G = "平均融资额";
	public static final String INVEST_MONEY_MAX_G = "最大融资额";
	public static final String INVEST_NUM_H = "融资笔数,不明确";
	public static final String INVEST_NUM_PERCENT_H = "融资笔数占比（%）";
	public static final String INVEST_NUM_RATE_H = "笔数环比增长率（%）";
	public static final String INVEST_MONEY_H = "融资金额";
	public static final String INVEST_MONEY_RATE_H = "金额环比增长率（%）";
	public static final String INVEST_MONEY_PER_H = "平均融资额";
	public static final String INVEST_MONEY_MAX_H = "最大融资额";
	public static final String INVEST_NUM_I = "融资笔数,其它轮";
	public static final String INVEST_NUM_PERCENT_I = "融资笔数占比（%）";
	public static final String INVEST_NUM_RATE_I = "笔数环比增长率（%）";
	public static final String INVEST_MONEY_I = "融资金额";
	public static final String INVEST_MONEY_RATE_I = "金额环比增长率（%）";
	public static final String INVEST_MONEY_PER_I = "平均融资额";
	public static final String INVEST_MONEY_MAX_I = "最大融资额";
	public static final String TYPE = "1.不区分融资等级  2.区分融资等级";
	public static final String ADD_TIME = "addTime";
	public static final String UPDATE_TIME = "updateTime";


	/**
	 * @Fields id :
	 */
	private Integer id;

	/**
	 * @Fields year : 年份
	 */
	private Integer year;

	/**
	 * @Fields parentId : 行业上级id
	 */
	private Integer parentId;

	/**
	 * @Fields industryId : 行业id
	 */
	private Integer industryId;

	/**
	 * @Fields industryName : 行业名称
	 */
	private String industryName;

	/**
	 * @Fields industryLevel : 1.一级行业  2.二级行业
	 */
	private Integer industryLevel;

	/**
	 * @Fields moneyLevelOrderId : 融资金额等级临时id，可用于排序、格式化数据
	 */
	private Integer moneyLevelOrderId;

	/**
	 * @Fields moneyLevelName : 融资金额等级
	 */
	private String moneyLevelName;

	/**
	 * @Fields investNumA : 融资笔数,种子/天使轮
	 */
	private Integer investNumA;

	/**
	 * @Fields investNumPercentA : 融资笔数占比（%）
	 */
	private Integer investNumPercentA;

	/**
	 * @Fields investNumRateA : 笔数环比增长率（%）
	 */
	private Integer investNumRateA;

	/**
	 * @Fields investMoneyA : 融资金额
	 */
	private Long investMoneyA;

	/**
	 * @Fields investMoneyRateA : 金额环比增长率（%）
	 */
	private Integer investMoneyRateA;

	/**
	 * @Fields investMoneyPerA : 平均融资额
	 */
	private Long investMoneyPerA;

	/**
	 * @Fields investMoneyMaxA : 最大融资额
	 */
	private Long investMoneyMaxA;

	/**
	 * @Fields investNumB : 融资笔数,Pre-A/A/A+轮
	 */
	private Integer investNumB;

	/**
	 * @Fields investNumPercentB : 融资笔数占比（%）
	 */
	private Integer investNumPercentB;

	/**
	 * @Fields investNumRateB : 笔数环比增长率（%）
	 */
	private Integer investNumRateB;

	/**
	 * @Fields investMoneyB : 融资金额
	 */
	private Long investMoneyB;

	/**
	 * @Fields investMoneyRateB : 金额环比增长率（%）
	 */
	private Integer investMoneyRateB;

	/**
	 * @Fields investMoneyPerB : 平均融资额
	 */
	private Long investMoneyPerB;

	/**
	 * @Fields investMoneyMaxB : 最大融资额
	 */
	private Long investMoneyMaxB;

	/**
	 * @Fields investNumC : 融资笔数,Pre-B/B/B+轮
	 */
	private Integer investNumC;

	/**
	 * @Fields investNumPercentC : 融资笔数占比（%）
	 */
	private Integer investNumPercentC;

	/**
	 * @Fields investNumRateC : 笔数环比增长率（%）
	 */
	private Integer investNumRateC;

	/**
	 * @Fields investMoneyC : 融资金额
	 */
	private Long investMoneyC;

	/**
	 * @Fields investMoneyRateC : 金额环比增长率（%）
	 */
	private Integer investMoneyRateC;

	/**
	 * @Fields investMoneyPerC : 平均融资额
	 */
	private Long investMoneyPerC;

	/**
	 * @Fields investMoneyMaxC : 最大融资额
	 */
	private Long investMoneyMaxC;

	/**
	 * @Fields investNumD : 融资笔数,C轮
	 */
	private Integer investNumD;

	/**
	 * @Fields investNumPercentD : 融资笔数占比（%）
	 */
	private Integer investNumPercentD;

	/**
	 * @Fields investNumRateD : 笔数环比增长率（%）
	 */
	private Integer investNumRateD;

	/**
	 * @Fields investMoneyD : 融资金额
	 */
	private Long investMoneyD;

	/**
	 * @Fields investMoneyRateD : 金额环比增长率（%）
	 */
	private Integer investMoneyRateD;

	/**
	 * @Fields investMoneyPerD : 平均融资额
	 */
	private Long investMoneyPerD;

	/**
	 * @Fields investMoneyMaxD : 最大融资额
	 */
	private Long investMoneyMaxD;

	/**
	 * @Fields investNumE : 融资笔数,D~F轮
	 */
	private Integer investNumE;

	/**
	 * @Fields investNumPercentE : 融资笔数占比（%）
	 */
	private Integer investNumPercentE;

	/**
	 * @Fields investNumRateE : 笔数环比增长率（%）
	 */
	private Integer investNumRateE;

	/**
	 * @Fields investMoneyE : 融资金额
	 */
	private Long investMoneyE;

	/**
	 * @Fields investMoneyRateE : 金额环比增长率（%）
	 */
	private Integer investMoneyRateE;

	/**
	 * @Fields investMoneyPerE : 平均融资额
	 */
	private Long investMoneyPerE;

	/**
	 * @Fields investMoneyMaxE : 最大融资额
	 */
	private Long investMoneyMaxE;

	/**
	 * @Fields investNumF : 融资笔数,IOP及以后
	 */
	private Integer investNumF;

	/**
	 * @Fields investNumPercentF : 融资笔数占比（%）
	 */
	private Integer investNumPercentF;

	/**
	 * @Fields investNumRateF : 笔数环比增长率（%）
	 */
	private Integer investNumRateF;

	/**
	 * @Fields investMoneyF : 融资金额
	 */
	private Long investMoneyF;

	/**
	 * @Fields investMoneyRateF : 金额环比增长率（%）
	 */
	private Integer investMoneyRateF;

	/**
	 * @Fields investMoneyPerF : 平均融资额
	 */
	private Long investMoneyPerF;

	/**
	 * @Fields investMoneyMaxF : 最大融资额
	 */
	private Long investMoneyMaxF;

	/**
	 * @Fields investNumG : 融资笔数,并购
	 */
	private Integer investNumG;

	/**
	 * @Fields investNumPercentG : 融资笔数占比（%）
	 */
	private Integer investNumPercentG;

	/**
	 * @Fields investNumRateG : 笔数环比增长率（%）
	 */
	private Integer investNumRateG;

	/**
	 * @Fields investMoneyG : 融资金额
	 */
	private Long investMoneyG;

	/**
	 * @Fields investMoneyRateG : 金额环比增长率（%）
	 */
	private Integer investMoneyRateG;

	/**
	 * @Fields investMoneyPerG : 平均融资额
	 */
	private Long investMoneyPerG;

	/**
	 * @Fields investMoneyMaxG : 最大融资额
	 */
	private Long investMoneyMaxG;

	/**
	 * @Fields investNumH : 融资笔数,不明确
	 */
	private Integer investNumH;

	/**
	 * @Fields investNumPercentH : 融资笔数占比（%）
	 */
	private Integer investNumPercentH;

	/**
	 * @Fields investNumRateH : 笔数环比增长率（%）
	 */
	private Integer investNumRateH;

	/**
	 * @Fields investMoneyH : 融资金额
	 */
	private Long investMoneyH;

	/**
	 * @Fields investMoneyRateH : 金额环比增长率（%）
	 */
	private Integer investMoneyRateH;

	/**
	 * @Fields investMoneyPerH : 平均融资额
	 */
	private Long investMoneyPerH;

	/**
	 * @Fields investMoneyMaxH : 最大融资额
	 */
	private Long investMoneyMaxH;

	/**
	 * @Fields investNumI : 融资笔数,其它轮
	 */
	private Integer investNumI;

	/**
	 * @Fields investNumPercentI : 融资笔数占比（%）
	 */
	private Integer investNumPercentI;

	/**
	 * @Fields investNumRateI : 笔数环比增长率（%）
	 */
	private Integer investNumRateI;

	/**
	 * @Fields investMoneyI : 融资金额
	 */
	private Long investMoneyI;

	/**
	 * @Fields investMoneyRateI : 金额环比增长率（%）
	 */
	private Integer investMoneyRateI;

	/**
	 * @Fields investMoneyPerI : 平均融资额
	 */
	private Long investMoneyPerI;

	/**
	 * @Fields investMoneyMaxI : 最大融资额
	 */
	private Long investMoneyMaxI;

	/**
	 * @Fields type : 1.不区分融资等级  2.区分融资等级
	 */
	private Integer type;

	/**
	 * @Fields addTime : 
	 */
	private Timestamp addTime;

	/**
	 * @Fields updateTime : 
	 */
	private Timestamp updateTime;

	private Long[] yearList;
	private boolean doOrder = true ;
	private int pageIndex = 1;
	private int pageSize = 10;
	private String order;
	private String orderBy;
	private String returnFields;


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
	public Long[] getYearList() {
		return yearList;
	}

	public void setYearList(Long[] yearList) {
		this.yearList = yearList;
	}
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

	public Integer getParentId(){
		return parentId;
	}

	public void setParentId(Integer parentId){
		this.parentId = parentId;
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

	public Integer getMoneyLevelOrderId(){
		return moneyLevelOrderId;
	}

	public void setMoneyLevelOrderId(Integer moneyLevelOrderId){
		this.moneyLevelOrderId = moneyLevelOrderId;
	}

	public String getMoneyLevelName(){
		return moneyLevelName;
	}

	public void setMoneyLevelName(String moneyLevelName){
		this.moneyLevelName = moneyLevelName;
	}

	public Integer getInvestNumA(){
		return investNumA;
	}

	public void setInvestNumA(Integer investNumA){
		this.investNumA = investNumA;
	}

	public Integer getInvestNumPercentA(){
		return investNumPercentA;
	}

	public void setInvestNumPercentA(Integer investNumPercentA){
		this.investNumPercentA = investNumPercentA;
	}

	public Integer getInvestNumRateA(){
		return investNumRateA;
	}

	public void setInvestNumRateA(Integer investNumRateA){
		this.investNumRateA = investNumRateA;
	}

	public Long getInvestMoneyA(){
		return investMoneyA;
	}

	public void setInvestMoneyA(Long investMoneyA){
		this.investMoneyA = investMoneyA;
	}

	public Integer getInvestMoneyRateA(){
		return investMoneyRateA;
	}

	public void setInvestMoneyRateA(Integer investMoneyRateA){
		this.investMoneyRateA = investMoneyRateA;
	}

	public Long getInvestMoneyPerA(){
		return investMoneyPerA;
	}

	public void setInvestMoneyPerA(Long investMoneyPerA){
		this.investMoneyPerA = investMoneyPerA;
	}

	public Long getInvestMoneyMaxA(){
		return investMoneyMaxA;
	}

	public void setInvestMoneyMaxA(Long investMoneyMaxA){
		this.investMoneyMaxA = investMoneyMaxA;
	}

	public Integer getInvestNumB(){
		return investNumB;
	}

	public void setInvestNumB(Integer investNumB){
		this.investNumB = investNumB;
	}

	public Integer getInvestNumPercentB(){
		return investNumPercentB;
	}

	public void setInvestNumPercentB(Integer investNumPercentB){
		this.investNumPercentB = investNumPercentB;
	}

	public Integer getInvestNumRateB(){
		return investNumRateB;
	}

	public void setInvestNumRateB(Integer investNumRateB){
		this.investNumRateB = investNumRateB;
	}

	public Long getInvestMoneyB(){
		return investMoneyB;
	}

	public void setInvestMoneyB(Long investMoneyB){
		this.investMoneyB = investMoneyB;
	}

	public Integer getInvestMoneyRateB(){
		return investMoneyRateB;
	}

	public void setInvestMoneyRateB(Integer investMoneyRateB){
		this.investMoneyRateB = investMoneyRateB;
	}

	public Long getInvestMoneyPerB(){
		return investMoneyPerB;
	}

	public void setInvestMoneyPerB(Long investMoneyPerB){
		this.investMoneyPerB = investMoneyPerB;
	}

	public Long getInvestMoneyMaxB(){
		return investMoneyMaxB;
	}

	public void setInvestMoneyMaxB(Long investMoneyMaxB){
		this.investMoneyMaxB = investMoneyMaxB;
	}

	public Integer getInvestNumC(){
		return investNumC;
	}

	public void setInvestNumC(Integer investNumC){
		this.investNumC = investNumC;
	}

	public Integer getInvestNumPercentC(){
		return investNumPercentC;
	}

	public void setInvestNumPercentC(Integer investNumPercentC){
		this.investNumPercentC = investNumPercentC;
	}

	public Integer getInvestNumRateC(){
		return investNumRateC;
	}

	public void setInvestNumRateC(Integer investNumRateC){
		this.investNumRateC = investNumRateC;
	}

	public Long getInvestMoneyC(){
		return investMoneyC;
	}

	public void setInvestMoneyC(Long investMoneyC){
		this.investMoneyC = investMoneyC;
	}

	public Integer getInvestMoneyRateC(){
		return investMoneyRateC;
	}

	public void setInvestMoneyRateC(Integer investMoneyRateC){
		this.investMoneyRateC = investMoneyRateC;
	}

	public Long getInvestMoneyPerC(){
		return investMoneyPerC;
	}

	public void setInvestMoneyPerC(Long investMoneyPerC){
		this.investMoneyPerC = investMoneyPerC;
	}

	public Long getInvestMoneyMaxC(){
		return investMoneyMaxC;
	}

	public void setInvestMoneyMaxC(Long investMoneyMaxC){
		this.investMoneyMaxC = investMoneyMaxC;
	}

	public Integer getInvestNumD(){
		return investNumD;
	}

	public void setInvestNumD(Integer investNumD){
		this.investNumD = investNumD;
	}

	public Integer getInvestNumPercentD(){
		return investNumPercentD;
	}

	public void setInvestNumPercentD(Integer investNumPercentD){
		this.investNumPercentD = investNumPercentD;
	}

	public Integer getInvestNumRateD(){
		return investNumRateD;
	}

	public void setInvestNumRateD(Integer investNumRateD){
		this.investNumRateD = investNumRateD;
	}

	public Long getInvestMoneyD(){
		return investMoneyD;
	}

	public void setInvestMoneyD(Long investMoneyD){
		this.investMoneyD = investMoneyD;
	}

	public Integer getInvestMoneyRateD(){
		return investMoneyRateD;
	}

	public void setInvestMoneyRateD(Integer investMoneyRateD){
		this.investMoneyRateD = investMoneyRateD;
	}

	public Long getInvestMoneyPerD(){
		return investMoneyPerD;
	}

	public void setInvestMoneyPerD(Long investMoneyPerD){
		this.investMoneyPerD = investMoneyPerD;
	}

	public Long getInvestMoneyMaxD(){
		return investMoneyMaxD;
	}

	public void setInvestMoneyMaxD(Long investMoneyMaxD){
		this.investMoneyMaxD = investMoneyMaxD;
	}

	public Integer getInvestNumE(){
		return investNumE;
	}

	public void setInvestNumE(Integer investNumE){
		this.investNumE = investNumE;
	}

	public Integer getInvestNumPercentE(){
		return investNumPercentE;
	}

	public void setInvestNumPercentE(Integer investNumPercentE){
		this.investNumPercentE = investNumPercentE;
	}

	public Integer getInvestNumRateE(){
		return investNumRateE;
	}

	public void setInvestNumRateE(Integer investNumRateE){
		this.investNumRateE = investNumRateE;
	}

	public Long getInvestMoneyE(){
		return investMoneyE;
	}

	public void setInvestMoneyE(Long investMoneyE){
		this.investMoneyE = investMoneyE;
	}

	public Integer getInvestMoneyRateE(){
		return investMoneyRateE;
	}

	public void setInvestMoneyRateE(Integer investMoneyRateE){
		this.investMoneyRateE = investMoneyRateE;
	}

	public Long getInvestMoneyPerE(){
		return investMoneyPerE;
	}

	public void setInvestMoneyPerE(Long investMoneyPerE){
		this.investMoneyPerE = investMoneyPerE;
	}

	public Long getInvestMoneyMaxE(){
		return investMoneyMaxE;
	}

	public void setInvestMoneyMaxE(Long investMoneyMaxE){
		this.investMoneyMaxE = investMoneyMaxE;
	}

	public Integer getInvestNumF(){
		return investNumF;
	}

	public void setInvestNumF(Integer investNumF){
		this.investNumF = investNumF;
	}

	public Integer getInvestNumPercentF(){
		return investNumPercentF;
	}

	public void setInvestNumPercentF(Integer investNumPercentF){
		this.investNumPercentF = investNumPercentF;
	}

	public Integer getInvestNumRateF(){
		return investNumRateF;
	}

	public void setInvestNumRateF(Integer investNumRateF){
		this.investNumRateF = investNumRateF;
	}

	public Long getInvestMoneyF(){
		return investMoneyF;
	}

	public void setInvestMoneyF(Long investMoneyF){
		this.investMoneyF = investMoneyF;
	}

	public Integer getInvestMoneyRateF(){
		return investMoneyRateF;
	}

	public void setInvestMoneyRateF(Integer investMoneyRateF){
		this.investMoneyRateF = investMoneyRateF;
	}

	public Long getInvestMoneyPerF(){
		return investMoneyPerF;
	}

	public void setInvestMoneyPerF(Long investMoneyPerF){
		this.investMoneyPerF = investMoneyPerF;
	}

	public Long getInvestMoneyMaxF(){
		return investMoneyMaxF;
	}

	public void setInvestMoneyMaxF(Long investMoneyMaxF){
		this.investMoneyMaxF = investMoneyMaxF;
	}

	public Integer getInvestNumG(){
		return investNumG;
	}

	public void setInvestNumG(Integer investNumG){
		this.investNumG = investNumG;
	}

	public Integer getInvestNumPercentG(){
		return investNumPercentG;
	}

	public void setInvestNumPercentG(Integer investNumPercentG){
		this.investNumPercentG = investNumPercentG;
	}

	public Integer getInvestNumRateG(){
		return investNumRateG;
	}

	public void setInvestNumRateG(Integer investNumRateG){
		this.investNumRateG = investNumRateG;
	}

	public Long getInvestMoneyG(){
		return investMoneyG;
	}

	public void setInvestMoneyG(Long investMoneyG){
		this.investMoneyG = investMoneyG;
	}

	public Integer getInvestMoneyRateG(){
		return investMoneyRateG;
	}

	public void setInvestMoneyRateG(Integer investMoneyRateG){
		this.investMoneyRateG = investMoneyRateG;
	}

	public Long getInvestMoneyPerG(){
		return investMoneyPerG;
	}

	public void setInvestMoneyPerG(Long investMoneyPerG){
		this.investMoneyPerG = investMoneyPerG;
	}

	public Long getInvestMoneyMaxG(){
		return investMoneyMaxG;
	}

	public void setInvestMoneyMaxG(Long investMoneyMaxG){
		this.investMoneyMaxG = investMoneyMaxG;
	}

	public Integer getInvestNumH(){
		return investNumH;
	}

	public void setInvestNumH(Integer investNumH){
		this.investNumH = investNumH;
	}

	public Integer getInvestNumPercentH(){
		return investNumPercentH;
	}

	public void setInvestNumPercentH(Integer investNumPercentH){
		this.investNumPercentH = investNumPercentH;
	}

	public Integer getInvestNumRateH(){
		return investNumRateH;
	}

	public void setInvestNumRateH(Integer investNumRateH){
		this.investNumRateH = investNumRateH;
	}

	public Long getInvestMoneyH(){
		return investMoneyH;
	}

	public void setInvestMoneyH(Long investMoneyH){
		this.investMoneyH = investMoneyH;
	}

	public Integer getInvestMoneyRateH(){
		return investMoneyRateH;
	}

	public void setInvestMoneyRateH(Integer investMoneyRateH){
		this.investMoneyRateH = investMoneyRateH;
	}

	public Long getInvestMoneyPerH(){
		return investMoneyPerH;
	}

	public void setInvestMoneyPerH(Long investMoneyPerH){
		this.investMoneyPerH = investMoneyPerH;
	}

	public Long getInvestMoneyMaxH(){
		return investMoneyMaxH;
	}

	public void setInvestMoneyMaxH(Long investMoneyMaxH){
		this.investMoneyMaxH = investMoneyMaxH;
	}

	public Integer getInvestNumI(){
		return investNumI;
	}

	public void setInvestNumI(Integer investNumI){
		this.investNumI = investNumI;
	}

	public Integer getInvestNumPercentI(){
		return investNumPercentI;
	}

	public void setInvestNumPercentI(Integer investNumPercentI){
		this.investNumPercentI = investNumPercentI;
	}

	public Integer getInvestNumRateI(){
		return investNumRateI;
	}

	public void setInvestNumRateI(Integer investNumRateI){
		this.investNumRateI = investNumRateI;
	}

	public Long getInvestMoneyI(){
		return investMoneyI;
	}

	public void setInvestMoneyI(Long investMoneyI){
		this.investMoneyI = investMoneyI;
	}

	public Integer getInvestMoneyRateI(){
		return investMoneyRateI;
	}

	public void setInvestMoneyRateI(Integer investMoneyRateI){
		this.investMoneyRateI = investMoneyRateI;
	}

	public Long getInvestMoneyPerI(){
		return investMoneyPerI;
	}

	public void setInvestMoneyPerI(Long investMoneyPerI){
		this.investMoneyPerI = investMoneyPerI;
	}

	public Long getInvestMoneyMaxI(){
		return investMoneyMaxI;
	}

	public void setInvestMoneyMaxI(Long investMoneyMaxI){
		this.investMoneyMaxI = investMoneyMaxI;
	}

	public Integer getType(){
		return type;
	}

	public void setType(Integer type){
		this.type = type;
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