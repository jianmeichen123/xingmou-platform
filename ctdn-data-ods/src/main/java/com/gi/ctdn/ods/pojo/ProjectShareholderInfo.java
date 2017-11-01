package com.gi.ctdn.ods.pojo;

import com.gi.ctdn.view.common.PojoInfo;

public class ProjectShareholderInfo extends PojoInfo {

        public static final String PROJECTID = "项目ID";
        public static final String SOURCECODE = "项目code";
        public static final String PROJTITLE = "项目名称";
        public static final String SHAREHOLDERTYPE = "股东类型";
        public static final String SHAREHOLDER = "股东";
        public static final String PREPAYDATE = "认缴出资时间";
        public static final String PREPAYAMOUNTSTR = "认缴出资金额";
        public static final String PAIDDATE = "实缴出资时间";
        public static final String PAIDPAYAMOUNTSTR = "实缴出资金额";
        public static final String PAYTYPE = "出资方式";
        public static final String EQUITYRATE = "所占股份";
    
	
	/**
	 * @Fields projectId : 项目ID
	 */
	private Integer projectId;
	
	/**
	 * @Fields sourceCode : 项目code
	 */
	private String sourceCode;
	
	/**
	 * @Fields projTitle : 项目名称
	 */
	private String projTitle;
	
	/**
	 * @Fields shareholderType : 股东类型
	 */
	private String shareholderType;
	
	/**
	 * @Fields shareholder : 股东
	 */
	private String shareholder;
	
	/**
	 * @Fields prePayDate : 认缴出资时间
	 */
	private String prePayDate;
	
	/**
	 * @Fields prePayAmountStr : 认缴出资金额
	 */
	private String prePayAmountStr;
	
	/**
	 * @Fields paidDate : 实缴出资时间
	 */
	private String paidDate;
	
	/**
	 * @Fields paidPayAmountStr : 实缴出资金额
	 */
	private String paidPayAmountStr;
	
	/**
	 * @Fields payType : 出资方式
	 */
	private String payType;
	
	/**
	 * @Fields equityRate : 所占股份
	 */
	private String equityRate;
	
    
	public Integer getProjectId(){
		return projectId;
	}

	public void setProjectId(Integer projectId){
		this.projectId = projectId;
	}
    
	public String getSourceCode(){
		return sourceCode;
	}

	public void setSourceCode(String sourceCode){
		this.sourceCode = sourceCode;
	}
    
	public String getProjTitle(){
		return projTitle;
	}

	public void setProjTitle(String projTitle){
		this.projTitle = projTitle;
	}
    
	public String getShareholderType(){
		return shareholderType;
	}

	public void setShareholderType(String shareholderType){
		this.shareholderType = shareholderType;
	}
    
	public String getShareholder(){
		return shareholder;
	}

	public void setShareholder(String shareholder){
		this.shareholder = shareholder;
	}
    
	public String getPrePayDate(){
		return prePayDate;
	}

	public void setPrePayDate(String prePayDate){
		this.prePayDate = prePayDate;
	}
    
	public String getPrePayAmountStr(){
		return prePayAmountStr;
	}

	public void setPrePayAmountStr(String prePayAmountStr){
		this.prePayAmountStr = prePayAmountStr;
	}
    
	public String getPaidDate(){
		return paidDate;
	}

	public void setPaidDate(String paidDate){
		this.paidDate = paidDate;
	}
    
	public String getPaidPayAmountStr(){
		return paidPayAmountStr;
	}

	public void setPaidPayAmountStr(String paidPayAmountStr){
		this.paidPayAmountStr = paidPayAmountStr;
	}
    
	public String getPayType(){
		return payType;
	}

	public void setPayType(String payType){
		this.payType = payType;
	}
    
	public String getEquityRate(){
		return equityRate;
	}

	public void setEquityRate(String equityRate){
		this.equityRate = equityRate;
	}
    }