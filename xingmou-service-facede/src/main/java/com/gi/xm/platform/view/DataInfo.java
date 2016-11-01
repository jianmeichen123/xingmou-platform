package com.gi.xm.platform.view;

import java.math.BigDecimal;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class DataInfo implements Serializable {

	/**   
	 * @Fields serialVersionUID : 序列化版本号 
	 */ 
	private static final long serialVersionUID = 1L;

			
	/**
	 * @Fields id : 
	 */
	private Integer id;
			
	/**
	 * @Fields projectNum : 项目数量
	 */
	private Integer projectNum;
			
	/**
	 * @Fields projectInvestedNum : 已获投项目数量
	 */
	private Integer projectInvestedNum;
			
	/**
	 * @Fields investedMoney : 融资总额（元）
	 */
	private Long investedMoney;
			
	/**
	 * @Fields investedMoneyPerProject : 单项目融资均额(元)
	 */
	private Long investedMoneyPerProject;
	/**
	 * @Fields investedMoneyPerProject : 融资机构数量
	 */
	private Integer investfirmNum;
	
	/**
	 * @Fields eventNum : 融资事件数量
	 */
	private Integer eventNum;
	
	public Integer getId(){
		return id;
	}
	
	public void setId(Integer id){
		this.id = id;
	}
    
	public Integer getProjectNum(){
		return projectNum;
	}
	
	public void setProjectNum(Integer projectNum){
		this.projectNum = projectNum;
	}
    
	public Integer getProjectInvestedNum(){
		return projectInvestedNum;
	}
	
	public void setProjectInvestedNum(Integer projectInvestedNum){
		this.projectInvestedNum = projectInvestedNum;
	}
    
	public Long getInvestedMoney(){
		return investedMoney;
	}
	
	public void setInvestedMoney(Long investedMoney){
		this.investedMoney = investedMoney;
	}
    
	public Long getInvestedMoneyPerProject(){
		return investedMoneyPerProject;
	}
	
	public void setInvestedMoneyPerProject(Long investedMoneyPerProject){
		this.investedMoneyPerProject = investedMoneyPerProject;
	}
	public Integer getInvestfirmNum() {
		return investfirmNum;
	}

	public void setInvestfirmNum(Integer investfirmNum) {
		this.investfirmNum = investfirmNum;
	}

	public Integer getEventNum() {
		return eventNum;
	}

	public void setEventNum(Integer eventNum) {
		this.eventNum = eventNum;
	}
    }