package com.gi.xm.platform.query;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class InvestfirmsDataYearQuery extends Query {
	
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

	private Integer roundNum;

	private Long roundMoney;
			
	private Timestamp addTime;
			
	private Timestamp updateTime;
	private String pic;

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
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

	public Long getRoundMoney() {
		return roundMoney;
	}

	public void setRoundMoney(Long roundMoney) {
		this.roundMoney = roundMoney;
	}

	public Integer getRoundNum() {
		return roundNum;
	}

	public void setRoundNum(Integer roundNum) {
		this.roundNum = roundNum;
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