package com.gi.ctdn.pojo;

import java.util.List;

import com.gi.ctdn.view.common.PojoInfo;

public class IndustryRoundMerger  extends PojoInfo {

	private Long industryId;
	private String industryName;
	private int roundId;
	private String roundName;
	private Long investedNum;
	private Long investedAmount;
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
	public int getRoundId() {
		return roundId;
	}
	public void setRoundId(int roundId) {
		this.roundId = roundId;
	}
	public String getRoundName() {
		return roundName;
	}
	public void setRoundName(String roundName) {
		this.roundName = roundName;
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
	
	//For echarts
	private String industryNameStr;
	private String investedAmountStr;
	private String investedNumStr;
	private List<String> investedAmountList;
	private List<String> investedNumList;
	public String getInvestedAmountStr() {
		return investedAmountStr;
	}
	public void setInvestedAmountStr(String investedAmountStr) {
		this.investedAmountStr = investedAmountStr;
	}
	public String getInvestedNumStr() {
		return investedNumStr;
	}
	public void setInvestedNumStr(String investedNumStr) {
		this.investedNumStr = investedNumStr;
	}
	public List<String> getInvestedAmountList() {
		return investedAmountList;
	}
	public void setInvestedAmountList(List<String> investedAmountList) {
		this.investedAmountList = investedAmountList;
	}
	public List<String> getInvestedNumList() {
		return investedNumList;
	}
	public void setInvestedNumList(List<String> investedNumList) {
		this.investedNumList = investedNumList;
	}
	public String getIndustryNameStr() {
		return industryNameStr;
	}
	public void setIndustryNameStr(String industryNameStr) {
		this.industryNameStr = industryNameStr;
	}
	
	
	
}
