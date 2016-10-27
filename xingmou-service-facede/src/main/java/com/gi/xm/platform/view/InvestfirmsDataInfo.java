package com.gi.xm.platform.view;

import java.math.BigDecimal;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class InvestfirmsDataInfo implements Serializable {

	/**
	 * @Fields serialVersionUID : �???????????
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * @Fields id :
	 */
	private Integer id;

	/**
	 * @Fields investfirmId : ??�??��??id
	 */
	private Long investfirmId;

	/**
	 * @Fields investfirmName : ??�???�??��????�?
	 */
	private String investfirmName;

	/**
	 * @Fields investfirmLink : ??�??��??�???
	 */
	private String investfirmLink;

	/**
	 * @Fields investNum : ?��??�?�???
	 */
	private Integer investNum;

	/**
	 * @Fields investMoney : ?��??�???�?�???�?
	 */
	private Long investMoney;

	/**
	 * @Fields investIndustry : ??�?�???�?级�?�?
	 */
	private String investIndustry;

	/**
	 * @Fields investRound : ??�?�???�?�?
	 */
	private String investRound;

	/**
	 * @Fields newestInvestProjects : ??�?�???项�????称�???�?�?�?�?
	 */
	private String newestInvestProjects;

	/**
	 * @Fields investMonthRate : �?????�?�??��??�?�??��?
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

	private String pic;

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

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