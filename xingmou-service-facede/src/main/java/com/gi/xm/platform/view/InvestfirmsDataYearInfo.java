package com.gi.xm.platform.view;

import java.math.BigDecimal;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class InvestfirmsDataYearInfo implements Serializable {

	/**   
	 * @Fields serialVersionUID : 序列化版本号 
	 */ 
	private static final long serialVersionUID = 1L;

			
	/**
	 * @Fields id : 
	 */
	private Long id;
			
	/**
	 * @Fields year : 年份
	 */
	private Integer year;
			
	/**
	 * @Fields investfirmId : 投资机构id
	 */
	private Long investfirmId;
			
	/**
	 * @Fields investfirmName : 投资机构名称（冗余）
	 */
	private String investfirmName;
			
	/**
	 * @Fields industryNames : 投资过的行业名称
	 */
	private String industryNames;
			
	/**
	 * @Fields roundANum : 种子/天使轮融资笔数
	 */
	private Integer roundANum;
			
	/**
	 * @Fields roundAMoney : 种子/天使轮融资总额
	 */
	private Long roundAMoney;
			
	/**
	 * @Fields roundBNum : Pre-A/A/A+轮融资笔数
	 */
	private Integer roundBNum;
			
	/**
	 * @Fields roundBMoney : Pre-A/A/A+轮融资总额
	 */
	private Long roundBMoney;
			
	/**
	 * @Fields roundCNum : Pre-B/B/B+轮融资笔数
	 */
	private Integer roundCNum;
			
	/**
	 * @Fields roundCMoney : Pre-B/B/B+轮融资总额
	 */
	private Long roundCMoney;
			
	/**
	 * @Fields roundDNum : C轮融资笔数
	 */
	private Integer roundDNum;
			
	/**
	 * @Fields roundDMoney : C轮融资总额
	 */
	private Long roundDMoney;
			
	/**
	 * @Fields roundENum : D/轮融资笔数
	 */
	private Integer roundENum;
			
	/**
	 * @Fields roundEMoney : D/轮融资总额
	 */
	private Long roundEMoney;
			
	/**
	 * @Fields roundFNum : IOP及以后融资笔数
	 */
	private Integer roundFNum;
			
	/**
	 * @Fields roundFMoney : IOP及以后融资总额
	 */
	private Long roundFMoney;
			
	/**
	 * @Fields roundGNum : 其他融资笔数
	 */
	private Integer roundGNum;
			
	/**
	 * @Fields roundGMoney : 其他融资总额
	 */
	private Long roundGMoney;
			
	/**
	 * @Fields addTime : 
	 */
	private Timestamp addTime;
			
	/**
	 * @Fields updateTime : 
	 */
	private Timestamp updateTime;
		
    
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
    }