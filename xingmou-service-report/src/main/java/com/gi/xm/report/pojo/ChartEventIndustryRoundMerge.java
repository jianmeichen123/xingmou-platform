package com.gi.xm.report.pojo;

import com.gi.xm.report.pojo.Pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.sql.Timestamp;
import java.util.Date;

public class ChartEventIndustryRoundMerge extends Pojo {

	public static final String ID = "id";
	public static final String YEAR = "���";
	public static final String PARENT_ID = "��ҵ�ϼ�id";
	public static final String INDUSTRY_ID = "��ҵid";
	public static final String INDUSTRY_NAME = "��ҵ����";
	public static final String INDUSTRY_LEVEL = "1.һ����ҵ  2.������ҵ";
	public static final String MONEY_LEVEL_ORDER_ID = "���ʽ��ȼ���ʱid�����������򡢸�ʽ������";
	public static final String MONEY_LEVEL_NAME = "���ʽ��ȼ�";
	public static final String INVEST_NUM_A = "���ʱ���,����/��ʹ��";
	public static final String INVEST_NUM_PERCENT_A = "���ʱ���ռ�ȣ�%��";
	public static final String INVEST_NUM_RATE_A = "�������������ʣ�%��";
	public static final String INVEST_MONEY_A = "���ʽ��";
	public static final String INVEST_MONEY_RATE_A = "���������ʣ�%��";
	public static final String INVEST_MONEY_PER_A = "ƽ�����ʶ�";
	public static final String INVEST_MONEY_MAX_A = "������ʶ�";
	public static final String INVEST_NUM_B = "���ʱ���,Pre-A/A/A+��";
	public static final String INVEST_NUM_PERCENT_B = "���ʱ���ռ�ȣ�%��";
	public static final String INVEST_NUM_RATE_B = "�������������ʣ�%��";
	public static final String INVEST_MONEY_B = "���ʽ��";
	public static final String INVEST_MONEY_RATE_B = "���������ʣ�%��";
	public static final String INVEST_MONEY_PER_B = "ƽ�����ʶ�";
	public static final String INVEST_MONEY_MAX_B = "������ʶ�";
	public static final String INVEST_NUM_C = "���ʱ���,Pre-B/B/B+��";
	public static final String INVEST_NUM_PERCENT_C = "���ʱ���ռ�ȣ�%��";
	public static final String INVEST_NUM_RATE_C = "�������������ʣ�%��";
	public static final String INVEST_MONEY_C = "���ʽ��";
	public static final String INVEST_MONEY_RATE_C = "���������ʣ�%��";
	public static final String INVEST_MONEY_PER_C = "ƽ�����ʶ�";
	public static final String INVEST_MONEY_MAX_C = "������ʶ�";
	public static final String INVEST_NUM_D = "���ʱ���,C��";
	public static final String INVEST_NUM_PERCENT_D = "���ʱ���ռ�ȣ�%��";
	public static final String INVEST_NUM_RATE_D = "�������������ʣ�%��";
	public static final String INVEST_MONEY_D = "���ʽ��";
	public static final String INVEST_MONEY_RATE_D = "���������ʣ�%��";
	public static final String INVEST_MONEY_PER_D = "ƽ�����ʶ�";
	public static final String INVEST_MONEY_MAX_D = "������ʶ�";
	public static final String INVEST_NUM_E = "���ʱ���,D~F��";
	public static final String INVEST_NUM_PERCENT_E = "���ʱ���ռ�ȣ�%��";
	public static final String INVEST_NUM_RATE_E = "�������������ʣ�%��";
	public static final String INVEST_MONEY_E = "���ʽ��";
	public static final String INVEST_MONEY_RATE_E = "���������ʣ�%��";
	public static final String INVEST_MONEY_PER_E = "ƽ�����ʶ�";
	public static final String INVEST_MONEY_MAX_E = "������ʶ�";
	public static final String INVEST_NUM_F = "���ʱ���,IOP���Ժ�";
	public static final String INVEST_NUM_PERCENT_F = "���ʱ���ռ�ȣ�%��";
	public static final String INVEST_NUM_RATE_F = "�������������ʣ�%��";
	public static final String INVEST_MONEY_F = "���ʽ��";
	public static final String INVEST_MONEY_RATE_F = "���������ʣ�%��";
	public static final String INVEST_MONEY_PER_F = "ƽ�����ʶ�";
	public static final String INVEST_MONEY_MAX_F = "������ʶ�";
	public static final String INVEST_NUM_G = "���ʱ���,����";
	public static final String INVEST_NUM_PERCENT_G = "���ʱ���ռ�ȣ�%��";
	public static final String INVEST_NUM_RATE_G = "�������������ʣ�%��";
	public static final String INVEST_MONEY_G = "���ʽ��";
	public static final String INVEST_MONEY_RATE_G = "���������ʣ�%��";
	public static final String INVEST_MONEY_PER_G = "ƽ�����ʶ�";
	public static final String INVEST_MONEY_MAX_G = "������ʶ�";
	public static final String INVEST_NUM_H = "���ʱ���,����ȷ";
	public static final String INVEST_NUM_PERCENT_H = "���ʱ���ռ�ȣ�%��";
	public static final String INVEST_NUM_RATE_H = "�������������ʣ�%��";
	public static final String INVEST_MONEY_H = "���ʽ��";
	public static final String INVEST_MONEY_RATE_H = "���������ʣ�%��";
	public static final String INVEST_MONEY_PER_H = "ƽ�����ʶ�";
	public static final String INVEST_MONEY_MAX_H = "������ʶ�";
	public static final String INVEST_NUM_I = "���ʱ���,������";
	public static final String INVEST_NUM_PERCENT_I = "���ʱ���ռ�ȣ�%��";
	public static final String INVEST_NUM_RATE_I = "�������������ʣ�%��";
	public static final String INVEST_MONEY_I = "���ʽ��";
	public static final String INVEST_MONEY_RATE_I = "���������ʣ�%��";
	public static final String INVEST_MONEY_PER_I = "ƽ�����ʶ�";
	public static final String INVEST_MONEY_MAX_I = "������ʶ�";
	public static final String TYPE = "1.���������ʵȼ�  2.�������ʵȼ�";
	public static final String ADD_TIME = "addTime";
	public static final String UPDATE_TIME = "updateTime";


	/**
	 * @Fields id :
	 */
	private Integer id;

	/**
	 * @Fields year : ���
	 */
	private Integer year;

	/**
	 * @Fields parentId : ��ҵ�ϼ�id
	 */
	private Integer parentId;

	/**
	 * @Fields industryId : ��ҵid
	 */
	private Integer industryId;

	/**
	 * @Fields industryName : ��ҵ����
	 */
	private String industryName;

	/**
	 * @Fields industryLevel : 1.һ����ҵ  2.������ҵ
	 */
	private Integer industryLevel;

	/**
	 * @Fields moneyLevelOrderId : ���ʽ��ȼ���ʱid�����������򡢸�ʽ������
	 */
	private Integer moneyLevelOrderId;

	/**
	 * @Fields moneyLevelName : ���ʽ��ȼ�
	 */
	private String moneyLevelName;

	/**
	 * @Fields investNumA : ���ʱ���,����/��ʹ��
	 */
	private Integer investNumA;

	/**
	 * @Fields investNumPercentA : ���ʱ���ռ�ȣ�%��
	 */
	private Integer investNumPercentA;

	/**
	 * @Fields investNumRateA : �������������ʣ�%��
	 */
	private Integer investNumRateA;

	/**
	 * @Fields investMoneyA : ���ʽ��
	 */
	private Long investMoneyA;

	/**
	 * @Fields investMoneyRateA : ���������ʣ�%��
	 */
	private Integer investMoneyRateA;

	/**
	 * @Fields investMoneyPerA : ƽ�����ʶ�
	 */
	private Long investMoneyPerA;

	/**
	 * @Fields investMoneyMaxA : ������ʶ�
	 */
	private Long investMoneyMaxA;

	/**
	 * @Fields investNumB : ���ʱ���,Pre-A/A/A+��
	 */
	private Integer investNumB;

	/**
	 * @Fields investNumPercentB : ���ʱ���ռ�ȣ�%��
	 */
	private Integer investNumPercentB;

	/**
	 * @Fields investNumRateB : �������������ʣ�%��
	 */
	private Integer investNumRateB;

	/**
	 * @Fields investMoneyB : ���ʽ��
	 */
	private Long investMoneyB;

	/**
	 * @Fields investMoneyRateB : ���������ʣ�%��
	 */
	private Integer investMoneyRateB;

	/**
	 * @Fields investMoneyPerB : ƽ�����ʶ�
	 */
	private Long investMoneyPerB;

	/**
	 * @Fields investMoneyMaxB : ������ʶ�
	 */
	private Long investMoneyMaxB;

	/**
	 * @Fields investNumC : ���ʱ���,Pre-B/B/B+��
	 */
	private Integer investNumC;

	/**
	 * @Fields investNumPercentC : ���ʱ���ռ�ȣ�%��
	 */
	private Integer investNumPercentC;

	/**
	 * @Fields investNumRateC : �������������ʣ�%��
	 */
	private Integer investNumRateC;

	/**
	 * @Fields investMoneyC : ���ʽ��
	 */
	private Long investMoneyC;

	/**
	 * @Fields investMoneyRateC : ���������ʣ�%��
	 */
	private Integer investMoneyRateC;

	/**
	 * @Fields investMoneyPerC : ƽ�����ʶ�
	 */
	private Long investMoneyPerC;

	/**
	 * @Fields investMoneyMaxC : ������ʶ�
	 */
	private Long investMoneyMaxC;

	/**
	 * @Fields investNumD : ���ʱ���,C��
	 */
	private Integer investNumD;

	/**
	 * @Fields investNumPercentD : ���ʱ���ռ�ȣ�%��
	 */
	private Integer investNumPercentD;

	/**
	 * @Fields investNumRateD : �������������ʣ�%��
	 */
	private Integer investNumRateD;

	/**
	 * @Fields investMoneyD : ���ʽ��
	 */
	private Long investMoneyD;

	/**
	 * @Fields investMoneyRateD : ���������ʣ�%��
	 */
	private Integer investMoneyRateD;

	/**
	 * @Fields investMoneyPerD : ƽ�����ʶ�
	 */
	private Long investMoneyPerD;

	/**
	 * @Fields investMoneyMaxD : ������ʶ�
	 */
	private Long investMoneyMaxD;

	/**
	 * @Fields investNumE : ���ʱ���,D~F��
	 */
	private Integer investNumE;

	/**
	 * @Fields investNumPercentE : ���ʱ���ռ�ȣ�%��
	 */
	private Integer investNumPercentE;

	/**
	 * @Fields investNumRateE : �������������ʣ�%��
	 */
	private Integer investNumRateE;

	/**
	 * @Fields investMoneyE : ���ʽ��
	 */
	private Long investMoneyE;

	/**
	 * @Fields investMoneyRateE : ���������ʣ�%��
	 */
	private Integer investMoneyRateE;

	/**
	 * @Fields investMoneyPerE : ƽ�����ʶ�
	 */
	private Long investMoneyPerE;

	/**
	 * @Fields investMoneyMaxE : ������ʶ�
	 */
	private Long investMoneyMaxE;

	/**
	 * @Fields investNumF : ���ʱ���,IOP���Ժ�
	 */
	private Integer investNumF;

	/**
	 * @Fields investNumPercentF : ���ʱ���ռ�ȣ�%��
	 */
	private Integer investNumPercentF;

	/**
	 * @Fields investNumRateF : �������������ʣ�%��
	 */
	private Integer investNumRateF;

	/**
	 * @Fields investMoneyF : ���ʽ��
	 */
	private Long investMoneyF;

	/**
	 * @Fields investMoneyRateF : ���������ʣ�%��
	 */
	private Integer investMoneyRateF;

	/**
	 * @Fields investMoneyPerF : ƽ�����ʶ�
	 */
	private Long investMoneyPerF;

	/**
	 * @Fields investMoneyMaxF : ������ʶ�
	 */
	private Long investMoneyMaxF;

	/**
	 * @Fields investNumG : ���ʱ���,����
	 */
	private Integer investNumG;

	/**
	 * @Fields investNumPercentG : ���ʱ���ռ�ȣ�%��
	 */
	private Integer investNumPercentG;

	/**
	 * @Fields investNumRateG : �������������ʣ�%��
	 */
	private Integer investNumRateG;

	/**
	 * @Fields investMoneyG : ���ʽ��
	 */
	private Long investMoneyG;

	/**
	 * @Fields investMoneyRateG : ���������ʣ�%��
	 */
	private Integer investMoneyRateG;

	/**
	 * @Fields investMoneyPerG : ƽ�����ʶ�
	 */
	private Long investMoneyPerG;

	/**
	 * @Fields investMoneyMaxG : ������ʶ�
	 */
	private Long investMoneyMaxG;

	/**
	 * @Fields investNumH : ���ʱ���,����ȷ
	 */
	private Integer investNumH;

	/**
	 * @Fields investNumPercentH : ���ʱ���ռ�ȣ�%��
	 */
	private Integer investNumPercentH;

	/**
	 * @Fields investNumRateH : �������������ʣ�%��
	 */
	private Integer investNumRateH;

	/**
	 * @Fields investMoneyH : ���ʽ��
	 */
	private Long investMoneyH;

	/**
	 * @Fields investMoneyRateH : ���������ʣ�%��
	 */
	private Integer investMoneyRateH;

	/**
	 * @Fields investMoneyPerH : ƽ�����ʶ�
	 */
	private Long investMoneyPerH;

	/**
	 * @Fields investMoneyMaxH : ������ʶ�
	 */
	private Long investMoneyMaxH;

	/**
	 * @Fields investNumI : ���ʱ���,������
	 */
	private Integer investNumI;

	/**
	 * @Fields investNumPercentI : ���ʱ���ռ�ȣ�%��
	 */
	private Integer investNumPercentI;

	/**
	 * @Fields investNumRateI : �������������ʣ�%��
	 */
	private Integer investNumRateI;

	/**
	 * @Fields investMoneyI : ���ʽ��
	 */
	private Long investMoneyI;

	/**
	 * @Fields investMoneyRateI : ���������ʣ�%��
	 */
	private Integer investMoneyRateI;

	/**
	 * @Fields investMoneyPerI : ƽ�����ʶ�
	 */
	private Long investMoneyPerI;

	/**
	 * @Fields investMoneyMaxI : ������ʶ�
	 */
	private Long investMoneyMaxI;

	/**
	 * @Fields type : 1.���������ʵȼ�  2.�������ʵȼ�
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