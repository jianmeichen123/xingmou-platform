package com.gi.xm.platform.view;

import java.math.BigDecimal;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class InvestfirmsDataInfo implements Serializable {

	/**
	 * @Fields serialVersionUID : ï¿????????????
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * @Fields id :
	 */
	private Integer id;

	/**
	 * @Fields investfirmId : ??ï¿???ï¿½ï¿½??id
	 */
	private Long investfirmId;

	/**
	 * @Fields investfirmName : ??ï¿????ï¿???ï¿½ï¿½????ï¿??
	 */
	private String investfirmName;

	/**
	 * @Fields investfirmLink : ??ï¿???ï¿½ï¿½??ï¿????
	 */
	private String investfirmLink;

	/**
	 * @Fields investNum : ?ï¿½ï¿½??ï¿??ï¿????
	 */
	private Integer investNum;

	/**
	 * @Fields investMoney : ?ï¿½ï¿½??ï¿????ï¿??ï¿????ï¿??
	 */
	private Long investMoney;

	/**
	 * @Fields investIndustry : ??ï¿??ï¿????ï¿??çº§ï¿½?ï¿??
	 */
	private String investIndustry;

	/**
	 * @Fields investRound : ??ï¿??ï¿????ï¿??ï¿??
	 */
	private String investRound;

	/**
	 * @Fields newestInvestProjects : ??ï¿??ï¿????é¡¹ï¿½????ç§°ï¿½???ï¿??ï¿??ï¿??ï¿??
	 */
	private String newestInvestProjects;

	/**
	 * @Fields investMonthRate : ï¿??????ï¿??ï¿???ï¿½ï¿½??ï¿??ï¿???ï¿½ï¿½?
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
	private Long sourceId;

	public Long getSourceId() {
		return sourceId;
	}

	public void setSourceId(Long sourceId) {
		this.sourceId = sourceId;
	}
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