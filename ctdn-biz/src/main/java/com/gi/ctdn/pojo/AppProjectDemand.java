package com.gi.ctdn.pojo;

import com.gi.ctdn.view.common.PojoInfo;

public class AppProjectDemand extends PojoInfo {


	/**
	 * @Fields projId : 项目唯一标识
	 */
	private Long projId;
	
	/**
	 * @Fields projCode : 
	 */
	private String projCode;
	
	/**
	 * @Fields projName : 项目名称
	 */
	private String projName;
	
	/**
	 * @Fields projDistrictId : 一级地区id
	 */
	private Integer projDistrictId;
	
	/**
	 * @Fields projSubDistrictId : 二级地区id
	 */
	private Integer projSubDistrictId;
	
	/**
	 * @Fields projDistrict : 一级地区
	 */
	private String projDistrict;
	
	/**
	 * @Fields projSubDistrict : 二级地区
	 */
	private String projSubDistrict;
	
	/**
	 * @Fields projDesc : 项目介绍
	 */
	private String projDesc;
	
	/**
	 * @Fields projLinkman : 项目联系人
	 */
	private String projLinkman;
	
	/**
	 * @Fields projLinktel : 联系电话
	 */
	private String projLinktel;
	
	/**
	 * @Fields projPb : 商业计划书
	 */
	private String projPb;
	
	/**
	 * @Fields projLogo : 项目logo
	 */
	private String projLogo;
	
	/**
	 * @Fields projIndustryId : 一级行业id
	 */
	private Integer projIndustryId;
	
	/**
	 * @Fields projSubIndustryId : 二级行业id
	 */
	private Integer projSubIndustryId;
	
	/**
	 * @Fields projIndustry : 一级行业
	 */
	private String projIndustry;
	
	/**
	 * @Fields projSubIndustry : 二级行业
	 */
	private String projSubIndustry;
	
	/**
	 * @Fields projWebaddress : 官网
	 */
	private String projWebaddress;
	
	/**
	 * @Fields projCompName : 公司全称
	 */
	private String projCompName;
	
	/**
	 * @Fields projCompAddr : 公司地址
	 */
	private String projCompAddr;
	
	/**
	 * @Fields projRoundsId : 融资轮次id
	 */
	private Integer projRoundId;
	
	/**
	 * @Fields projRounds : 融资轮次
	 */
	private String projRound;
	
	/**
	 * @Fields projMoney : 融资金额
	 */
	private Double projMoney;
	
	/**
	 * @Fields projStock : 出让股份
	 */
	private Double projStock;
	
	/**
	 * @Fields projAddTime : 项目添加时间
	 */
	private Long projAddTime;
	
	/**
	 * @Fields projUpdateTime : 项目更新时间
	 */
	private Long projUpdateTime;
	
    
	public Long getProjId(){
		return projId;
	}

	public void setProjId(Long projId){
		this.projId = projId;
	}
    
	public String getProjCode(){
		return projCode;
	}

	public void setProjCode(String projCode){
		this.projCode = projCode;
	}
    
	public String getProjName(){
		return projName;
	}

	public void setProjName(String projName){
		this.projName = projName;
	}
    
	public Integer getProjDistrictId(){
		return projDistrictId;
	}

	public void setProjDistrictId(Integer projDistrictId){
		this.projDistrictId = projDistrictId;
	}
    
	public Integer getProjSubDistrictId(){
		return projSubDistrictId;
	}

	public void setProjSubDistrictId(Integer projSubDistrictId){
		this.projSubDistrictId = projSubDistrictId;
	}
    
	public String getProjDistrict(){
		return projDistrict;
	}

	public void setProjDistrict(String projDistrict){
		this.projDistrict = projDistrict;
	}
    
	public String getProjSubDistrict(){
		return projSubDistrict;
	}

	public void setProjSubDistrict(String projSubDistrict){
		this.projSubDistrict = projSubDistrict;
	}
    
	public String getProjDesc(){
		return projDesc;
	}

	public void setProjDesc(String projDesc){
		this.projDesc = projDesc;
	}
    
	public String getProjLinkman(){
		return projLinkman;
	}

	public void setProjLinkman(String projLinkman){
		this.projLinkman = projLinkman;
	}
    
	public String getProjLinktel(){
		return projLinktel;
	}

	public void setProjLinktel(String projLinktel){
		this.projLinktel = projLinktel;
	}
    
	public String getProjPb(){
		return projPb;
	}

	public void setProjPb(String projPb){
		this.projPb = projPb;
	}
    
	public String getProjLogo(){
		return projLogo;
	}

	public void setProjLogo(String projLogo){
		this.projLogo = projLogo;
	}
    
	public Integer getProjIndustryId(){
		return projIndustryId;
	}

	public void setProjIndustryId(Integer projIndustryId){
		this.projIndustryId = projIndustryId;
	}
    
	public Integer getProjSubIndustryId(){
		return projSubIndustryId;
	}

	public void setProjSubIndustryId(Integer projSubIndustryId){
		this.projSubIndustryId = projSubIndustryId;
	}
    
	public String getProjIndustry(){
		return projIndustry;
	}

	public void setProjIndustry(String projIndustry){
		this.projIndustry = projIndustry;
	}
    
	public String getProjSubIndustry(){
		return projSubIndustry;
	}

	public void setProjSubIndustry(String projSubIndustry){
		this.projSubIndustry = projSubIndustry;
	}
    
	public String getProjWebaddress(){
		return projWebaddress;
	}

	public void setProjWebaddress(String projWebaddress){
		this.projWebaddress = projWebaddress;
	}
    
	public String getProjCompName(){
		return projCompName;
	}

	public void setProjCompName(String projCompName){
		this.projCompName = projCompName;
	}
    
	public String getProjCompAddr(){
		return projCompAddr;
	}

	public void setProjCompAddr(String projCompAddr){
		this.projCompAddr = projCompAddr;
	}

	public Integer getProjRoundId() {
		return projRoundId;
	}

	public void setProjRoundId(Integer projRoundId) {
		this.projRoundId = projRoundId;
	}

	public String getProjRound() {
		return projRound;
	}

	public void setProjRound(String projRound) {
		this.projRound = projRound;
	}

	public void setProjMoney(Double projMoney) {
		this.projMoney = projMoney;
	}

	public Double getProjMoney() {
		return projMoney;
	}

	public void setProjStock(Double projStock) {
		this.projStock = projStock;
	}

	public Double getProjStock() {
		return projStock;
	}

	public Long getProjAddTime() {
		return projAddTime;
	}

	public void setProjAddTime(Long projAddTime) {
		this.projAddTime = projAddTime;
	}

	public Long getProjUpdateTime() {
		return projUpdateTime;
	}

	public void setProjUpdateTime(Long projUpdateTime) {
		this.projUpdateTime = projUpdateTime;
	}
}