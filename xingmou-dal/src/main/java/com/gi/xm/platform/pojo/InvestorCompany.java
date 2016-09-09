package com.gi.xm.platform.pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.sql.Timestamp;
import java.util.Date;

public class InvestorCompany extends Pojo {

        public static final String ID = "id";
        public static final String INVESTOR_ID = "投资人id";
        public static final String INVERSTFIRM_ID = "投资机构id";
        public static final String INVERSTFIRM_NAME = "冗余：投资机构名称";
        public static final String INVERSTFIRM_POSTION_ID = "投资职位id";
        public static final String INVERSTFIRM_POSTION_NAME = "冗余：职位名称";
        public static final String SOURCE_INVERSTFIRM_ID = "源投资机构id";
        public static final String SORTNUM = "sortnum";
        public static final String STATUS = "状态 ：1在职 2离职";
        public static final String ADD_TIME = "addTime";
        public static final String UPDATE_TIME = "updateTime";
    
	
	/**
	 * @Fields id : 
	 */
	private Long id;
	
	/**
	 * @Fields investorId : 投资人id
	 */
	private Long investorId;
	
	/**
	 * @Fields inverstfirmId : 投资机构id
	 */
	private Long inverstfirmId;
	
	/**
	 * @Fields inverstfirmName : 冗余：投资机构名称
	 */
	private String inverstfirmName;
	
	/**
	 * @Fields inverstfirmPostionId : 投资职位id
	 */
	private Long inverstfirmPostionId;
	
	/**
	 * @Fields inverstfirmPostionName : 冗余：职位名称
	 */
	private String inverstfirmPostionName;
	
	/**
	 * @Fields sourceInverstfirmId : 源投资机构id
	 */
	private Long sourceInverstfirmId;
	
	/**
	 * @Fields sortnum : 
	 */
	private Integer sortnum;
	
	/**
	 * @Fields status : 状态 ：1在职 2离职
	 */
	private Integer status;
	
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
    
	public Long getInvestorId(){
		return investorId;
	}

	public void setInvestorId(Long investorId){
		this.investorId = investorId;
	}
    
	public Long getInverstfirmId(){
		return inverstfirmId;
	}

	public void setInverstfirmId(Long inverstfirmId){
		this.inverstfirmId = inverstfirmId;
	}
    
	public String getInverstfirmName(){
		return inverstfirmName;
	}

	public void setInverstfirmName(String inverstfirmName){
		this.inverstfirmName = inverstfirmName;
	}
    
	public Long getInverstfirmPostionId(){
		return inverstfirmPostionId;
	}

	public void setInverstfirmPostionId(Long inverstfirmPostionId){
		this.inverstfirmPostionId = inverstfirmPostionId;
	}
    
	public String getInverstfirmPostionName(){
		return inverstfirmPostionName;
	}

	public void setInverstfirmPostionName(String inverstfirmPostionName){
		this.inverstfirmPostionName = inverstfirmPostionName;
	}
    
	public Long getSourceInverstfirmId(){
		return sourceInverstfirmId;
	}

	public void setSourceInverstfirmId(Long sourceInverstfirmId){
		this.sourceInverstfirmId = sourceInverstfirmId;
	}
    
	public Integer getSortnum(){
		return sortnum;
	}

	public void setSortnum(Integer sortnum){
		this.sortnum = sortnum;
	}
    
	public Integer getStatus(){
		return status;
	}

	public void setStatus(Integer status){
		this.status = status;
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