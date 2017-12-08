package com.gi.ctdn.pojo;

import com.gi.ctdn.view.common.Query;

public class EventMergerDetail extends Query {

	public static final String MERGEREVENT = "并购事件";
	public static final String EVENTID = "事件ID";
	public static final String CODE = "事件code";
	public static final String PARTY = "主体[并购方：B，被并购方：C，卖方：S]";
	public static final String PARTYNAME = "主体公司名称";
	public static final String INDUSTRYNAME = "一级行业";
	public static final String DISTRICT = "地区";
	public static final String ISVCFE = "是否VC/PE支持";
	public static final String ISSTOCK = "是否上市";
	public static final String ISNATION = "是否国有背景";
	public static final String LAWFIRMS = "律师事务所";
	public static final String ACCOUNTFIRMS = "会计师事务所";
	public static final String FINANCECONSULT = "财务顾问";


	/**
	 * @Fields mergerEvent : 并购事件
	 */
	private String mergerEvent;

	/**
	 * @Fields eventId : 事件ID
	 */
	private Integer eventId;

	/**
	 * @Fields code : 事件code
	 */
	private String code;

	/**
	 * @Fields party : 主体[并购方：B，被并购方：C，卖方：S]
	 */
	private String party;

	/**
	 * @Fields partyName : 主体公司名称
	 */
	private String partyName;

	/**
	 * @Fields industry : 一级行业
	 */
	private String industryName;

	/**
	 * @Fields industry : 二级行业
	 */
	private String industrySubName;
	/**
	 * @Fields district : 二级地区
	 */
	private String districtSubName;

	/**
	 * @Fields district : 三级地区
	 */
	private String districtGrandsonName;

	/**
	 * @Fields isVcFe : 是否VC/PE支持
	 */
	private String isVcFe;

	/**
	 * @Fields isStock : 是否上市
	 */
	private String isStock;

	/**
	 * @Fields isNation : 是否国有背景
	 */
	private String isNation;

	/**
	 * @Fields lawFirms : 律师事务所
	 */
	private String lawFirms;

	/**
	 * @Fields accountFirms : 会计师事务所
	 */
	private String accountFirms;

	/**
	 * @Fields financeConsult : 财务顾问
	 */
	private String financeConsult;


	public String getMergerEvent(){
		return mergerEvent;
	}

	public void setMergerEvent(String mergerEvent){
		this.mergerEvent = mergerEvent;
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

	public String getParty(){
		return party;
	}

	public void setParty(String party){
		this.party = party;
	}

	public String getPartyName(){
		return partyName;
	}

	public void setPartyName(String partyName){
		this.partyName = partyName;
	}

	public String getIndustryName() {
		return industryName;
	}

	public void setIndustryName(String industryName) {
		this.industryName = industryName;
	}

	public String getIndustrySubName() {
		return industrySubName;
	}

	public void setIndustrySubName(String industrySubName) {
		this.industrySubName = industrySubName;
	}

	public String getDistrictGrandsonName() {
		return districtGrandsonName;
	}

	public void setDistrictGrandsonName(String districtGrandsonName) {
		this.districtGrandsonName = districtGrandsonName;
	}

	public String getDistrictSubName() {
		return districtSubName;
	}

	public void setDistrictSubName(String districtSubName) {
		this.districtSubName = districtSubName;
	}

	public String getIsVcFe(){
		return isVcFe;
	}

	public void setIsVcFe(String isVcFe){
		this.isVcFe = isVcFe;
	}

	public String getIsStock(){
		return isStock;
	}

	public void setIsStock(String isStock){
		this.isStock = isStock;
	}

	public String getIsNation(){
		return isNation;
	}

	public void setIsNation(String isNation){
		this.isNation = isNation;
	}

	public String getLawFirms(){
		return lawFirms;
	}

	public void setLawFirms(String lawFirms){
		this.lawFirms = lawFirms;
	}

	public String getAccountFirms(){
		return accountFirms;
	}

	public void setAccountFirms(String accountFirms){
		this.accountFirms = accountFirms;
	}

	public String getFinanceConsult(){
		return financeConsult;
	}

	public void setFinanceConsult(String financeConsult){
		this.financeConsult = financeConsult;
	}
}