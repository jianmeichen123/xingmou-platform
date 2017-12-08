package com.gi.ctdn.pojo;

import com.gi.ctdn.view.common.PojoInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ProjectShareholderInfo extends PojoInfo {

	/**
	 * @Fields sourceCode : 项目code
	 */
	@ApiModelProperty("项目code")
	private String sourceCode;
	

	/**
	 * @Fields shareholderType : 股东类型
	 */
	@ApiModelProperty("股东类型")
	private String shareholderType;
	
	/**
	 * @Fields shareholder : 股东
	 */
	@ApiModelProperty("股东")
	private String shareholder;
	
	/**
	 * @Fields prePayDate : 认缴出资时间
	 */
	@ApiModelProperty(" 认缴出资时间")
	private String prePayDate;
	
	/**
	 * @Fields prePayAmountStr : 认缴出资金额
	 */
	@ApiModelProperty("认缴出资金额")
	private String prePayAmountStr;
	
	/**
	 * @Fields paidDate : 实缴出资时间
	 */
	@ApiModelProperty("实缴出资时间")
	private String paidDate;
	
	/**
	 * @Fields paidPayAmountStr : 实缴出资金额
	 */
	@ApiModelProperty("实缴出资金额")
	private String paidPayAmountStr;
	
	/**
	 * @Fields payType : 出资方式
	 */
	@ApiModelProperty("出资方式")
	private String payType;
	
	/**
	 * @Fields equityRate : 所占股份
	 */
	@ApiModelProperty("所占股份")
	private String equityRate;
	
	public String getSourceCode(){
		return sourceCode;
	}

	public void setSourceCode(String sourceCode){
		this.sourceCode = sourceCode;
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