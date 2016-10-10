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
	private List<Integer> investedNumRateList= new ArrayList<>();
	//融资金额
	private List<Long> investedMoneyList= new ArrayList<>();
	//金额增长率
	private List<Integer> investedMoneyRateList= new ArrayList<>();
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

	public List<Integer> getInvestedNumRateList() {
		return investedNumRateList;
	}

	public void setInvestedNumRateList(List<Integer> investedNumRateList) {
		this.investedNumRateList = investedNumRateList;
	}

	public List<Long> getInvestedMoneyList() {
		return investedMoneyList;
	}

	public void setInvestedMoneyList(List<Long> investedMoneyList) {
		this.investedMoneyList = investedMoneyList;
	}

	public List<Integer> getInvestedMoneyRateList() {
		return investedMoneyRateList;
	}

	public void setInvestedMoneyRateList(List<Integer> investedMoneyRateList) {
		this.investedMoneyRateList = investedMoneyRateList;
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