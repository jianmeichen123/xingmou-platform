package com.gi.xm.report.query;

import java.util.Date;
import java.math.BigDecimal;
import java.io.Serializable;
import java.sql.Timestamp;
import com.gi.xm.platform.view.common.QueryInfo;

public class TargetIndustryHotQueryInfo extends QueryInfo {
	
	/**   
	 * @Fields serialVersionUID : 序列化版本号 
	 */ 
	private static final long serialVersionUID = 1L;

	
	private Integer id;
	
	private Integer industryId;
	
	private String industryName;
	
	private Integer industryLevel;
	
	private Integer investHot;
	
	private Long investMoneyPerA;
	
	private Long investMoneyPerB;
	
	private Long investMoneyPerC;
	
	private Long investMoneyPerD;
	
	private Long investMoneyPerE;
	
	private Long investMoneyPerF;
	
	private Long investMoneyPerG;
	
	private Long investMoneyPerH;
	
	private Long investMoneyPerI;
	
	private Timestamp addTime;
	
	private Timestamp updateTime;
		
    
	public Integer getId(){
		return id;
	}
	
	public void setId(Integer id){
		this.id = id;
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
    
	public Integer getInvestHot(){
		return investHot;
	}
	
	public void setInvestHot(Integer investHot){
		this.investHot = investHot;
	}
    
	public Long getInvestMoneyPerA(){
		return investMoneyPerA;
	}
	
	public void setInvestMoneyPerA(Long investMoneyPerA){
		this.investMoneyPerA = investMoneyPerA;
	}
    
	public Long getInvestMoneyPerB(){
		return investMoneyPerB;
	}
	
	public void setInvestMoneyPerB(Long investMoneyPerB){
		this.investMoneyPerB = investMoneyPerB;
	}
    
	public Long getInvestMoneyPerC(){
		return investMoneyPerC;
	}
	
	public void setInvestMoneyPerC(Long investMoneyPerC){
		this.investMoneyPerC = investMoneyPerC;
	}
    
	public Long getInvestMoneyPerD(){
		return investMoneyPerD;
	}
	
	public void setInvestMoneyPerD(Long investMoneyPerD){
		this.investMoneyPerD = investMoneyPerD;
	}
    
	public Long getInvestMoneyPerE(){
		return investMoneyPerE;
	}
	
	public void setInvestMoneyPerE(Long investMoneyPerE){
		this.investMoneyPerE = investMoneyPerE;
	}
    
	public Long getInvestMoneyPerF(){
		return investMoneyPerF;
	}
	
	public void setInvestMoneyPerF(Long investMoneyPerF){
		this.investMoneyPerF = investMoneyPerF;
	}
    
	public Long getInvestMoneyPerG(){
		return investMoneyPerG;
	}
	
	public void setInvestMoneyPerG(Long investMoneyPerG){
		this.investMoneyPerG = investMoneyPerG;
	}
    
	public Long getInvestMoneyPerH(){
		return investMoneyPerH;
	}
	
	public void setInvestMoneyPerH(Long investMoneyPerH){
		this.investMoneyPerH = investMoneyPerH;
	}
    
	public Long getInvestMoneyPerI(){
		return investMoneyPerI;
	}
	
	public void setInvestMoneyPerI(Long investMoneyPerI){
		this.investMoneyPerI = investMoneyPerI;
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