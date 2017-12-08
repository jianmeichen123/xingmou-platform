package com.gi.ctdn.pojo;

import com.gi.ctdn.view.common.Query;

import java.util.Date;

public class OrgInfo extends Query {

        public static final String INVESTORG = "投资机构";
        public static final String ORGID = "机构ID";
        public static final String ORGCODE = "投资机构code";
        public static final String INVESTSTAGE = "投资阶段";
        public static final String DISTRICT = "地区";
        public static final String INDUSTRYIDS = "industryIds";
        public static final String CAPITALTYPE = "资本类型";
        public static final String CURRENCYTYPE = "currencyType";
        public static final String ORGTYPE = "机构类型";
        public static final String INVESTTOTAL = "总投资笔数";
        public static final String TOTALRATIO = "投资笔数上月环比";
        public static final String INVESTAMOUNTNUM = "投资总额";
        public static final String INVESTAMOUNTSTR = "投资总额字面量";
        public static final String AMOUNTRATIO = "投资额度上月环比";
        public static final String INVESTPROJ = "最近投资项目";
        public static final String WEBURL = "官方网址";
        public static final String LOGO = "Logo";
        public static final String ORGNAME = "中文简称";
        public static final String ORGNAMEEN = "英文简称";
        public static final String FOUNDDATE = "成立时间";
        public static final String ORGFORM = "组织形式";
        public static final String REGISTAREA = "注册地区";
        public static final String ISBACK = "是否备案";
        public static final String BACKDATE = "备案时间";
        public static final String REGISTNO = "工商注册号";
        public static final String MANAGECAPITAL = "管理资本量";
        public static final String ISNATION = "是否有国有背景";
        public static final String ORGDESC = "机构描述";
        public static final String PROPSATGE = "拟投资阶段／轮次";
        public static final String PROPDOMAIN = "拟投领域/行业";
        public static final String PROPDIST = "拟投地区";
        public static final String INVESTSTAND = "投资标准";
        public static final String ADDEDSERVICE = "增值服务";
        public static final String REMARK = "备注说明";
        public static final String CASTSTAGE = "已投阶段／轮次";
        public static final String CASTINDUSTRY = "已投资行业";
        public static final String CASTDISTRICT = "已投地区";
        public static final String LOGOSMALL = "列表项logo";
        public static final String DISTRICTID = "一级地区id";
        public static final String DISTRICTSUBID = "二级地区id";
        public static final String NEWESTINVESTDATE = "最新融资日期";
        public static final String ORGPROJJSON = "最近投资项目";
        public static final String FOUNDDATESTR = "投资时间字符串";

	
	/**
	 * @Fields investOrg : 投资机构
	 */
	private String investOrg;
	
	/**
	 * @Fields orgId : 机构ID
	 */
	private Integer orgId;
	
	/**
	 * @Fields orgCode : 投资机构code
	 */
	private String orgCode;
	
	/**
	 * @Fields investStage : 投资阶段
	 */
	private String investStage;
	
	/**
	 * @Fields district : 地区
	 */
	private String district;
	
	/**
	 * @Fields industryIds : 
	 */
	private String industryIds;
	
	/**
	 * @Fields capitalType : 资本类型
	 */
	private String capitalType;
	
	/**
	 * @Fields currencyType : 
	 */
	private String currencyType;
	
	/**
	 * @Fields orgType : 机构类型
	 */
	private String orgType;
	
	/**
	 * @Fields investTotal : 总投资笔数
	 */
	private Integer investTotal;
	
	/**
	 * @Fields totalRatio : 投资笔数上月环比
	 */
	private Integer totalRatio;
	
	/**
	 * @Fields investAmountNum : 投资总额
	 */
	private Integer investAmountNum;
	
	/**
	 * @Fields investAmountStr : 投资总额字面量
	 */
	private String investAmountStr;
	
	/**
	 * @Fields amountRatio : 投资额度上月环比
	 */
	private Integer amountRatio;
	
	/**
	 * @Fields investProj : 最近投资项目
	 */
	private String investProj;
	
	/**
	 * @Fields webUrl : 官方网址
	 */
	private String webUrl;
	
	/**
	 * @Fields logo : Logo
	 */
	private String logo;
	
	/**
	 * @Fields orgName : 中文简称
	 */
	private String orgName;
	
	/**
	 * @Fields orgNameEn : 英文简称
	 */
	private String orgNameEn;
	
	/**
	 * @Fields foundDate : 成立时间
	 */
	private Date foundDate;

	/**
	 * @Fields foundDateStr : 成立时间

	 */
	 private String foundDateStr;
	
	/**
	 * @Fields orgForm : 组织形式
	 */
	private String orgForm;
	
	/**
	 * @Fields registArea : 注册地区
	 */
	private String registArea;
	
	/**
	 * @Fields isBack : 是否备案
	 */
	private String isBack;
	
	/**
	 * @Fields backDate : 备案时间
	 */
	private Date backDate;
	
	/**
	 * @Fields registNo : 工商注册号
	 */
	private String registNo;
	
	/**
	 * @Fields manageCapital : 管理资本量
	 */
	private String manageCapital;
	
	/**
	 * @Fields isNation : 是否有国有背景
	 */
	private String isNation;
	
	/**
	 * @Fields orgDesc : 机构描述
	 */
	private String orgDesc;
	
	/**
	 * @Fields propSatge : 拟投资阶段／轮次
	 */
	private String propSatge;
	
	/**
	 * @Fields propDomain : 拟投领域/行业
	 */
	private String propDomain;
	
	/**
	 * @Fields propDist : 拟投地区
	 */
	private String propDist;
	
	/**
	 * @Fields investStand : 投资标准
	 */
	private String investStand;
	
	/**
	 * @Fields addedService : 增值服务
	 */
	private String addedService;
	
	/**
	 * @Fields remark : 备注说明
	 */
	private String remark;
	
	/**
	 * @Fields castStage : 已投阶段／轮次
	 */
	private String castStage;
	
	/**
	 * @Fields castIndustry : 已投资行业
	 */
	private String castIndustry;
	
	/**
	 * @Fields castDistrict : 已投地区
	 */
	private String castDistrict;
	
	/**
	 * @Fields logoSmall : 列表项logo
	 */
	private String logoSmall;
	
	/**
	 * @Fields districtId : 一级地区id
	 */
	private Integer districtId;
	
	/**
	 * @Fields districtSubId : 二级地区id
	 */
	private Integer districtSubId;
	
	/**
	 * @Fields newestInvestDate : 最新融资日期
	 */
	private Date newestInvestDate;
	
	/**
	 * @Fields investProjJson : 最近投资项目 {"investProjJson":[{"type":"0","code":199,"title":"红杉资本","isClick":"0"}]}
	 */
	private String orgProjJson;
	
    
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

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getInvestStage(){
		return investStage;
	}

	public void setInvestStage(String investStage){
		this.investStage = investStage;
	}
    
	public String getDistrict(){
		return district;
	}

	public void setDistrict(String district){
		this.district = district;
	}
    
	public String getIndustryIds(){
		return industryIds;
	}

	public void setIndustryIds(String industryIds){
		this.industryIds = industryIds;
	}
    
	public String getCapitalType(){
		return capitalType;
	}

	public void setCapitalType(String capitalType){
		this.capitalType = capitalType;
	}
    
	public String getCurrencyType(){
		return currencyType;
	}

	public void setCurrencyType(String currencyType){
		this.currencyType = currencyType;
	}
    
	public String getOrgType(){
		return orgType;
	}

	public void setOrgType(String orgType){
		this.orgType = orgType;
	}
    
	public Integer getInvestTotal(){
		return investTotal;
	}

	public void setInvestTotal(Integer investTotal){
		this.investTotal = investTotal;
	}
    
	public Integer getTotalRatio(){
		return totalRatio;
	}

	public void setTotalRatio(Integer totalRatio){
		this.totalRatio = totalRatio;
	}
    
	public Integer getInvestAmountNum(){
		return investAmountNum;
	}

	public void setInvestAmountNum(Integer investAmountNum){
		this.investAmountNum = investAmountNum;
	}
    
	public String getInvestAmountStr(){
		return investAmountStr;
	}

	public void setInvestAmountStr(String investAmountStr){
		this.investAmountStr = investAmountStr;
	}
    
	public Integer getAmountRatio(){
		return amountRatio;
	}

	public void setAmountRatio(Integer amountRatio){
		this.amountRatio = amountRatio;
	}
    
	public String getInvestProj(){
		return investProj;
	}

	public void setInvestProj(String investProj){
		this.investProj = investProj;
	}
    
	public String getWebUrl(){
		return webUrl;
	}

	public void setWebUrl(String webUrl){
		this.webUrl = webUrl;
	}
    
	public String getLogo(){
		return logo;
	}

	public void setLogo(String logo){
		this.logo = logo;
	}
    
	public String getOrgName(){
		return orgName;
	}

	public void setOrgName(String orgName){
		this.orgName = orgName;
	}
    
	public String getOrgNameEn(){
		return orgNameEn;
	}

	public void setOrgNameEn(String orgNameEn){
		this.orgNameEn = orgNameEn;
	}
    
	public Date getFoundDate(){
		return foundDate;
	}

	public void setFoundDate(Date foundDate){
		this.foundDate = foundDate;
	}
    
	public String getOrgForm(){
		return orgForm;
	}

	public void setOrgForm(String orgForm){
		this.orgForm = orgForm;
	}
    
	public String getRegistArea(){
		return registArea;
	}

	public void setRegistArea(String registArea){
		this.registArea = registArea;
	}
    
	public String getIsBack(){
		return isBack;
	}

	public void setIsBack(String isBack){
		this.isBack = isBack;
	}
    
	public Date getBackDate(){
		return backDate;
	}

	public void setBackDate(Date backDate){
		this.backDate = backDate;
	}
    
	public String getRegistNo(){
		return registNo;
	}

	public void setRegistNo(String registNo){
		this.registNo = registNo;
	}
    
	public String getManageCapital(){
		return manageCapital;
	}

	public void setManageCapital(String manageCapital){
		this.manageCapital = manageCapital;
	}
    
	public String getIsNation(){
		return isNation;
	}

	public void setIsNation(String isNation){
		this.isNation = isNation;
	}
    
	public String getOrgDesc(){
		return orgDesc;
	}

	public void setOrgDesc(String orgDesc){
		this.orgDesc = orgDesc;
	}
    
	public String getPropSatge(){
		return propSatge;
	}

	public void setPropSatge(String propSatge){
		this.propSatge = propSatge;
	}
    
	public String getPropDomain(){
		return propDomain;
	}

	public void setPropDomain(String propDomain){
		this.propDomain = propDomain;
	}
    
	public String getPropDist(){
		return propDist;
	}

	public void setPropDist(String propDist){
		this.propDist = propDist;
	}
    
	public String getInvestStand(){
		return investStand;
	}

	public void setInvestStand(String investStand){
		this.investStand = investStand;
	}
    
	public String getAddedService(){
		return addedService;
	}

	public void setAddedService(String addedService){
		this.addedService = addedService;
	}
    
	public String getRemark(){
		return remark;
	}

	public void setRemark(String remark){
		this.remark = remark;
	}
    
	public String getCastStage(){
		return castStage;
	}

	public void setCastStage(String castStage){
		this.castStage = castStage;
	}
    
	public String getCastIndustry(){
		return castIndustry;
	}

	public void setCastIndustry(String castIndustry){
		this.castIndustry = castIndustry;
	}
    
	public String getCastDistrict(){
		return castDistrict;
	}

	public void setCastDistrict(String castDistrict){
		this.castDistrict = castDistrict;
	}
    
	public String getLogoSmall(){
		return logoSmall;
	}

	public void setLogoSmall(String logoSmall){
		this.logoSmall = logoSmall;
	}
    
	public Integer getDistrictId(){
		return districtId;
	}

	public void setDistrictId(Integer districtId){
		this.districtId = districtId;
	}
    
	public Integer getDistrictSubId(){
		return districtSubId;
	}

	public void setDistrictSubId(Integer districtSubId){
		this.districtSubId = districtSubId;
	}
    
	public Date getNewestInvestDate(){
		return newestInvestDate;
	}

	public void setNewestInvestDate(Date newestInvestDate){
		this.newestInvestDate = newestInvestDate;
	}
    
	public String getOrgProjJson(){
		return orgProjJson;
	}

	public void setOrgProjJson(String orgProjJson){
		this.orgProjJson = orgProjJson;
	}
	public String getFoundDateStr() {
		return foundDateStr;
	}

	public void setFoundDateStr(String foundDateStr) {
		this.foundDateStr = foundDateStr;
	}
    }