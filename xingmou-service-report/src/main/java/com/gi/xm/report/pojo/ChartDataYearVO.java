package com.gi.xm.report.pojo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ChartDataYearVO extends Pojo {


	//年份
	private List<Integer> yearList = new ArrayList<>();
	//融资笔数
	private List<Integer> investedNumList = new ArrayList<>();
	//笔数增长率
	private List<String> investedNumRateList= new ArrayList<>();
	//融资金额
	private List<Long> marketMoneyList= new ArrayList<>();
	//金额增长率
	private List<String> marketMoneyRateList= new ArrayList<>();
	//平均融资金额
	private List<Long> investedPerMoneyList= new ArrayList<>();
	//融资金额中位数
	private List<Long> investedMedianMoneyList= new ArrayList<>();

	//最大单笔融资金额
	private List<Long> investedMaxMoneyList= new ArrayList<>();

	public List<Integer> getYearList() {
		return yearList;
	}

	public void setYearList(List<Integer> yearList) {
		this.yearList = yearList;
	}

	public List<Integer> getInvestedNumList() {
		return investedNumList;
	}

	public void setInvestedNumList(List<Integer> investedNumList) {
		this.investedNumList = investedNumList;
	}

	public List<String> getInvestedNumRateList() {
		return investedNumRateList;
	}

	public void setInvestedNumRateList(List<String> investedNumRateList) {
		this.investedNumRateList = investedNumRateList;
	}

	public List<Long> getMarketMoneyList() {
		return marketMoneyList;
	}

	public void setMarketMoneyList(List<Long> marketMoneyList) {
		this.marketMoneyList = marketMoneyList;
	}

	public List<String> getMarketMoneyRateList() {
		return marketMoneyRateList;
	}

	public void setMarketMoneyRateList(List<String> marketMoneyRateList) {
		this.marketMoneyRateList = marketMoneyRateList;
	}

	public List<Long> getInvestedPerMoneyList() {
		return investedPerMoneyList;
	}

	public void setInvestedPerMoneyList(List<Long> investedPerMoneyList) {
		this.investedPerMoneyList = investedPerMoneyList;
	}

	public List<Long> getInvestedMedianMoneyList() {
		return investedMedianMoneyList;
	}

	public void setInvestedMedianMoneyList(List<Long> investedMedianMoneyList) {
		this.investedMedianMoneyList = investedMedianMoneyList;
	}

	public List<Long> getInvestedMaxMoneyList() {
		return investedMaxMoneyList;
	}

	public void setInvestedMaxMoneyList(List<Long> investedMaxMoneyList) {
		this.investedMaxMoneyList = investedMaxMoneyList;
	}

}