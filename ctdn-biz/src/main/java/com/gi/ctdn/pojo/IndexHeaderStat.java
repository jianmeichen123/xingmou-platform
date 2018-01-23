package com.gi.ctdn.pojo;

import com.gi.ctdn.view.common.PojoInfo;

public class IndexHeaderStat extends PojoInfo {

	public static final String ID = "id";
	public static final String PROJECTNUM = "projectNum";
	public static final String ORGNUM = "orgNum";
	public static final String EVENTNUM = "eventNum";
	public static final String INVSTEDNUM = "invstedNum";
	public static final String MERGERNUM = "mergerNum";
	public static final String LISTEDNUM = "listedNum";
	public static final String INVESTEDPROJNUM = "investedProjNum";
	public static final String AMOUNT = "amount";
	public static final String STARTUPNUM = "startUpNum";
	public static final String INVESTORNUM = "investorNum";
	public static final String INVSTEVENTNUM = "invstEventNum";
	public static final String INVSTAMOUNT = "invstAmount";
	public static final String YEAR = "year";
	public static final String MONTH =  "month";
	public static final String TYPE = "type";


	/**
	 * @Fields id :
	 */
	private Integer id;

	/**
	 * @Fields projectNum :
	 */
	private Integer projectNum;

	/**
	 * @Fields orgNum :
	 */
	private Integer orgNum;

	/**
	 * @Fields eventNum :
	 */
	private Integer eventNum;

	private  Integer invstedNum;

	private Integer mergerNum;

	private  Integer listedNum;

	private Integer investedProjNum;

	private Integer invstEventNum;

	private Integer invstAmount;

	public Integer getInvestedProjNum() {
		return investedProjNum;
	}

	public void setInvestedProjNum(Integer investedProjNum) {
		this.investedProjNum = investedProjNum;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	private Integer amount;
	
	private Integer startUpNum;

	private Integer investorNum;
	
	private Integer year;
	private Integer month;
	private Integer type;

	public Integer getStartUpNum() {
		return startUpNum;
	}

	public void setStartUpNum(Integer startUpNum) {
		this.startUpNum = startUpNum;
	}

	public Integer getInvestorNum() {
		return investorNum;
	}

	public void setInvestorNum(Integer investorNum) {
		this.investorNum = investorNum;
	}

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

	public Integer getOrgNum(){
		return orgNum;
	}

	public void setOrgNum(Integer orgNum){
		this.orgNum = orgNum;
	}

	public Integer getEventNum(){
		return eventNum;
	}

	public void setEventNum(Integer eventNum){
		this.eventNum = eventNum;
	}

	public Integer getInvstedNum() {
		return invstedNum;
	}

	public void setInvstedNum(Integer invstedNum) {
		this.invstedNum = invstedNum;
	}

	public Integer getMergerNum() {
		return mergerNum;
	}

	public void setMergerNum(Integer mergerNum) {
		this.mergerNum = mergerNum;
	}

	public Integer getListedNum() {
		return listedNum;
	}

	public void setListedNum(Integer listedNum) {
		this.listedNum = listedNum;
	}

	public Integer getInvstEventNum() {
		return invstEventNum;
	}

	public void setInvstEventNum(Integer invstEventNum) {
		this.invstEventNum = invstEventNum;
	}

	public Integer getInvstAmount() {
		return invstAmount;
	}

	public void setInvstAmount(Integer invstAmount) {
		this.invstAmount = invstAmount;
	}
}