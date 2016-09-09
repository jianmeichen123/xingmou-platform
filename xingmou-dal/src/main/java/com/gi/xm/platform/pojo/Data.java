package com.gi.xm.platform.pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.sql.Timestamp;
import java.util.Date;

public class Data extends Pojo {

        public static final String ID = "id";
        public static final String PROJECT_NUM = "项目数量";
        public static final String PROJECT_INVESTED_NUM = "已获投项目数量";
        public static final String INVESTED_MONEY = "融资总额（元）";
        public static final String INVESTED_MONEY_PER_PROJECT = "单项目融资均额(元)";
        public static final String ADD_TIME = "addTime";
        public static final String UPDATE_TIME = "updateTime";
    
	
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
	 * @Fields addTime : 
	 */
	private Timestamp addTime;
	
	/**
	 * @Fields updateTime : 
	 */
	private Timestamp updateTime;
	
    
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