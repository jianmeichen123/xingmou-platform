package com.gi.ctdn.pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.sql.Timestamp;
import java.util.Date;
import com.gi.xm.platform.view.common.PojoInfo;

public class OrgMemberInfo extends PojoInfo {

        public static final String INVESTORG = "投资机构";
        public static final String ORGID = "机构ID";
        public static final String CODE = "投资机构code";
        public static final String FUND = "基金";
        public static final String ADMINORG = "管理机构";
        public static final String FOUNDDATE = "成立时间";
        public static final String FUNDTYPE = "基金类型";
        public static final String INVESTDATE = "出资时间";
        public static final String COMMITAMOUNT = "承诺金额";
    
	
	/**
	 * @Fields investOrg : 投资机构
	 */
	private String investOrg;
	
	/**
	 * @Fields orgId : 机构ID
	 */
	private Integer orgId;
	
	/**
	 * @Fields code : 投资机构code
	 */
	private String code;
	
	/**
	 * @Fields fund : 基金
	 */
	private String fund;
	
	/**
	 * @Fields adminOrg : 管理机构
	 */
	private String adminOrg;
	
	/**
	 * @Fields foundDate : 成立时间
	 */
	private Date foundDate;
	
	/**
	 * @Fields fundType : 基金类型
	 */
	private String fundType;
	
	/**
	 * @Fields investDate : 出资时间
	 */
	private Date investDate;
	
	/**
	 * @Fields commitAmount : 承诺金额
	 */
	private String commitAmount;
	
    
	public String getInvestOrg(){
		return investOrg;
	}

	public void setInvestOrg(String investOrg){
		this.investOrg = investOrg;
	}
    
	public Integer getOrgId(){
		return orgId;
	}

	public void setOrgId(Integer orgId){
		this.orgId = orgId;
	}
    
	public String getCode(){
		return code;
	}

	public void setCode(String code){
		this.code = code;
	}
    
	public String getFund(){
		return fund;
	}

	public void setFund(String fund){
		this.fund = fund;
	}
    
	public String getAdminOrg(){
		return adminOrg;
	}

	public void setAdminOrg(String adminOrg){
		this.adminOrg = adminOrg;
	}
    
	public Date getFoundDate(){
		return foundDate;
	}

	public void setFoundDate(Date foundDate){
		this.foundDate = foundDate;
	}
    
	public String getFundType(){
		return fundType;
	}

	public void setFundType(String fundType){
		this.fundType = fundType;
	}
    
	public Date getInvestDate(){
		return investDate;
	}

	public void setInvestDate(Date investDate){
		this.investDate = investDate;
	}
    
	public String getCommitAmount(){
		return commitAmount;
	}

	public void setCommitAmount(String commitAmount){
		this.commitAmount = commitAmount;
	}
    }