package com.gi.xm.platform.view;

import java.util.Date;
import java.math.BigDecimal;
import java.io.Serializable;
import java.sql.Timestamp;
import com.gi.xm.platform.view.common.QueryInfo;

public class InvestfirmsDataYearQueryInfo extends QueryInfo {
	
	/**   
	 * @Fields serialVersionUID : 序列化版本号 
	 */ 
	private static final long serialVersionUID = 1L;

	
	private Long id;
	
	private Integer year;
	
	private Long investfirmId;
	
	private String investfirmName;
	
	private String industryNames;
	
	private Integer roundANum;
	
	private Long roundAMoney;
	
	private Integer roundBNum;
	
	private Long roundBMoney;
	
	private Integer roundCNum;
	
	private Long roundCMoney;
	
	private Integer roundDNum;
	
	private Long roundDMoney;
	
	private Integer roundENum;
	
	private Long roundEMoney;
	
	private Integer roundFNum;
	
	private Long roundFMoney;
	
	private Integer roundGNum;
	
	private Long roundGMoney;
	
	private Timestamp addTime;
	
	private Timestamp updateTime;
	private String searchFields ="id,investfirm_name,round_num,round_money" ;

	/**
	 * @Fields industryId :
	 */
	private Integer industryId;

	/**
	 * @Fields industryName :
	 */
	private String industryName;

	/**
	 * @Fields industrySubId :
	 */
	private Integer industrySubId;
	/**
	 * @Fields industrySubName :
	 */
	private String industrySubName;
	private Long[] yearList;

	public Long[] getYearList() {
		return yearList;
	}

	public void setYearList(Long[] yearList) {
		this.yearList = yearList;
	}
	public String getIndustrySubName() {
		return industrySubName;
	}

	public void setIndustrySubName(String industrySubName) {
		this.industrySubName = industrySubName;
	}

	public Integer getIndustryId() {
		return industryId;
	}

	public void setIndustryId(Integer industryId) {
		this.industryId = industryId;
	}

	public String getIndustryName() {
		return industryName;
	}

	public void setIndustryName(String industryName) {
		this.industryName = industryName;
	}

	public Integer getIndustrySubId() {
		return industrySubId;
	}

	public void setIndustrySubId(Integer industrySubId) {
		this.industrySubId = industrySubId;
	}
	public Long getId(){
		return id;
	}
	
	public void setId(Long id){
		this.id = id;
	}
    
	public Integer getYear(){
		return year;
	}
	
	public void setYear(Integer year){
		this.year = year;
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
    
	public String getIndustryNames(){
		return industryNames;
	}
	
	public void setIndustryNames(String industryNames){
		this.industryNames = industryNames;
	}
    
	public Integer getRoundANum(){
		return roundANum;
	}
	
	public void setRoundANum(Integer roundANum){
		this.roundANum = roundANum;
	}
    
	public Long getRoundAMoney(){
		return roundAMoney;
	}
	
	public void setRoundAMoney(Long roundAMoney){
		this.roundAMoney = roundAMoney;
	}
    
	public Integer getRoundBNum(){
		return roundBNum;
	}
	
	public void setRoundBNum(Integer roundBNum){
		this.roundBNum = roundBNum;
	}
    
	public Long getRoundBMoney(){
		return roundBMoney;
	}
	
	public void setRoundBMoney(Long roundBMoney){
		this.roundBMoney = roundBMoney;
	}
    
	public Integer getRoundCNum(){
		return roundCNum;
	}
	
	public void setRoundCNum(Integer roundCNum){
		this.roundCNum = roundCNum;
	}
    
	public Long getRoundCMoney(){
		return roundCMoney;
	}
	
	public void setRoundCMoney(Long roundCMoney){
		this.roundCMoney = roundCMoney;
	}
    
	public Integer getRoundDNum(){
		return roundDNum;
	}
	
	public void setRoundDNum(Integer roundDNum){
		this.roundDNum = roundDNum;
	}
    
	public Long getRoundDMoney(){
		return roundDMoney;
	}
	
	public void setRoundDMoney(Long roundDMoney){
		this.roundDMoney = roundDMoney;
	}
    
	public Integer getRoundENum(){
		return roundENum;
	}
	
	public void setRoundENum(Integer roundENum){
		this.roundENum = roundENum;
	}
    
	public Long getRoundEMoney(){
		return roundEMoney;
	}
	
	public void setRoundEMoney(Long roundEMoney){
		this.roundEMoney = roundEMoney;
	}
    
	public Integer getRoundFNum(){
		return roundFNum;
	}
	
	public void setRoundFNum(Integer roundFNum){
		this.roundFNum = roundFNum;
	}
    
	public Long getRoundFMoney(){
		return roundFMoney;
	}
	
	public void setRoundFMoney(Long roundFMoney){
		this.roundFMoney = roundFMoney;
	}
    
	public Integer getRoundGNum(){
		return roundGNum;
	}
	
	public void setRoundGNum(Integer roundGNum){
		this.roundGNum = roundGNum;
	}
    
	public Long getRoundGMoney(){
		return roundGMoney;
	}
	
	public void setRoundGMoney(Long roundGMoney){
		this.roundGMoney = roundGMoney;
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

	public String getSearchFields() {
		return searchFields;
	}

	public void setSearchFields(String searchFields) {
		this.searchFields = searchFields;
	}
}

