package com.gi.ctdn.pojo;

import java.util.List;

import com.gi.ctdn.view.common.PojoInfo;

public class IndustryMonth extends PojoInfo{

	private Long industryId;
	private String industryName;
	private Long investedNum;
	private Long investedAmount;
	private int year;
	private int month;
	public Long getIndustryId() {
		return industryId;
	}
	public void setIndustryId(Long industryId) {
		this.industryId = industryId;
	}
	public String getIndustryName() {
		return industryName;
	}
	public void setIndustryName(String industryName) {
		this.industryName = industryName;
	}
	public Long getInvestedNum() {
		return investedNum;
	}
	public void setInvestedNum(Long investedNum) {
		this.investedNum = investedNum;
	}
	public Long getInvestedAmount() {
		return investedAmount;
	}
	public void setInvestedAmount(Long investedAmount) {
		this.investedAmount = investedAmount;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}

	public String getDateStr() {
		return dateStr;
	}
	public void setDateStr(String dateStr) {
		this.dateStr = dateStr;
	}


	public String getInvestedNumStr() {
		return investedNumStr;
	}
	public void setInvestedNumStr(String investedNumStr) {
		this.investedNumStr = investedNumStr;
	}

	public String getInvestedAmountStr() {
		return investedAmountStr;
	}
	public void setInvestedAmountStr(String investedAmountStr) {
		this.investedAmountStr = investedAmountStr;
	}

	public List<String> getInvestedNumStrList() {
		return investedNumStrList;
	}
	public void setInvestedNumStrList(List<String> investedNumStrList) {
		this.investedNumStrList = investedNumStrList;
	}

	public List<String> getInvestedAmountStrList() {
		return investedAmountStrList;
	}
	public void setInvestedAmountStrList(List<String> investedAmountStrList) {
		this.investedAmountStrList = investedAmountStrList;
	}

	//echarts
	private String dateStr;
	private String investedNumStr;
	private String investedAmountStr;
	private List<String> investedNumStrList;
	private List<String> investedAmountStrList;
	
}
