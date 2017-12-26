package com.gi.ctdn.pojo;

import com.gi.ctdn.view.common.Query;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

@ApiModel
public class ProjectList extends Query {

	/**
	 * @Fields id : 项目ID
	 */
	@ApiModelProperty(value = "项目id")
	private Integer id;
	
	/**
	 * @Fields compCode :
	 */
	@ApiModelProperty(value = "所属公司code")
	private String compCode;

	@ApiModelProperty(value = "项目code")
	private String projCode;

	/**
	 * @Fields projTitle : 项目名称
	 */
	@ApiModelProperty(value = "项目名称")
	private String projTitle;
	
	/**
	 * @Fields runState : 运营状态
	 */
	@ApiModelProperty(value = "运营状态")
	private String runState;

	/**
	 * @Fields needFinance : 是否需融资
	 */
	@ApiModelProperty(value = "是否需融资")
	private String needFinance;
	
	/**
	 * @Fields addr : 地点
	 */
	@ApiModelProperty(value = "地点")
	private String addr;
	
	/**
	 * @Fields setupDT : 成立时间
	 */
	@ApiModelProperty(value = "成立时间")
	private String setupDT;
	
	/**
	 * @Fields labels : 标签
	 */
	@ApiModelProperty(value = "标签 用逗号隔开")
	private String labels;
	
	/**
	 * @Fields introduce : 项目slogan
	 */
	@ApiModelProperty(value = "项目slogan")
	private String introduce;
	
	/**
	 * @Fields latestFinanceDT : 最新融资时间
	 */
	@ApiModelProperty(value = "最新融资时间")
	private Date latestFinanceDT;
	
	/**
	 * @Fields latestFinanceRound : 最新融资轮次
	 */
	@ApiModelProperty(value = "最新融资轮次")
	private String latestFinanceRound;
	
	/**
	 * @Fields latestFinanceAmountStr : 最新融资金额
	 */

	@ApiModelProperty(value = "最新融资金额")
	private String latestFinanceAmountStr;

	/**
	 * similar 竞品相似度
	 */
	@ApiModelProperty(value = "竞品相似度")
	private  Double similarity ;

	/**
	 * 直接间接
	 */
	@ApiModelProperty(value = "查询竞品 0直接 1直接")
	private Integer isSame;
	
	/**
	 * @Fields investSideJson : {"investSideJson":[{"title":"红杉资本","id":2,"isleader":"0"}]}
	 */
	@ApiModelProperty(value = "投资方 暂无用")
	private String investSideJson;
	
	/**
	 * @Fields firmDesc : 公司描述
	 */
	@ApiModelProperty(value = "项目描述")
	private String firmDesc;
	
	/**
	 * @Fields firmPos : 公司定位
	 */
	@ApiModelProperty(value = "公司定位")
	private String firmPos;
	
	/**
	 * @Fields persona : 用户画像
	 */
	@ApiModelProperty(value = "用户画像")
	private String persona;
	
	/**
	 * @Fields prodSrv : 产品服务
	 */
	@ApiModelProperty(value = "产品服务")
	private String prodSrv;
	
	/**
	 * @Fields bizModel : 商业模式
	 */
	@ApiModelProperty(value = "商业模式")
	private String bizModel;
	
	/**
	 * @Fields industryName : 一级行业
	 */
	@ApiModelProperty(value = "一级行业")
	private String industryName;
	
	/**
	 * @Fields industrySubName : 二级行业
	 */
	@ApiModelProperty(value = "二级行业")
	private String industrySubName;
	
	/**
	 * @Fields industryIds : 行业ids,各级行业逗号分隔
	 */
	@ApiModelProperty(value = "行业ids,各级行业逗号分隔")
	private String industryIds;
	
	/**
	 * @Fields districtId : 一级地区id
	 */
	@ApiModelProperty(value = "一级地区id")
	private Integer districtId;
	
	/**
	 * @Fields districtSubId : 二级地区id
	 */
	@ApiModelProperty(value = "二级地区id")
	private Integer districtSubId;
	
	/**
	 * @Fields districtName : 一级地区
	 */
	@ApiModelProperty(value = "一级地区")
	private String districtName;
	
	/**
	 * @Fields districtSubName : 二级地区
	 */
	@ApiModelProperty(value = "二级地区")
	private String districtSubName;

	/**
	 * @Fields districtGrandsonName :三级地区
	 */
	@ApiModelProperty(value = "三级地区")
	private String districtGrandsonName;

	/**
	 * 商业计划书
	 */
	@ApiModelProperty(value = "商业计划书")
	private String bp;

	/**
	 * 企业总部邮箱
	 */
	@ApiModelProperty(value = "企业总部邮箱")
	private String hqEmail;

	/**
	 * 企业电话
	 */
	@ApiModelProperty(value = "企业电话")
	private String hqTel;

	/**
	 * 微博
	 */
	@ApiModelProperty(value = "微博")
	private String weibo;
	/**
	 * 微信
	 */
	@ApiModelProperty(value = "微信")
	private String weixin;

	/**
	 * 官网地址
	 */
	@ApiModelProperty(value = "官网地址")
	private String webUrl;

	/**
	 * 团队关键字
	 */
	@ApiModelProperty(value = "团队关键字")
	private String teamTags;
	/**
	 * 团队优势
	 */
	@ApiModelProperty(value = "团队优势")
	private String teamSuper;
	/**
	 * 用户市场
	 */
	@ApiModelProperty(value = "用户市场")
	private String userMarket;

	@ApiModelProperty(value = "产品图片 code  用^$^分割")
	private String photos;

	@ApiModelProperty(value = "融资总额")
	private String invstAmount;

	@ApiModelProperty(value = "compScale")
	private String compScale;

	@ApiModelProperty(value="企业估值")
	private  String valuation;

	/**
	 * @Fields loadDate : 录入时间
	 */
	@ApiModelProperty(value = "录入时间")
	private Long loadDate;

	private String regName;

	public Integer getId(){
		return id;
	}

	public void setId(Integer id){
		this.id = id;
	}

	public String getProjTitle(){
		return projTitle;
	}

	public void setProjTitle(String projTitle){
		this.projTitle = projTitle;
	}
    
	public String getRunState(){
		return runState;
	}

	public void setRunState(String runState){
		this.runState = runState;
	}
    
	public String getNeedFinance(){
		return needFinance;
	}

	public void setNeedFinance(String needFinance){
		this.needFinance = needFinance;
	}
    
	public String getAddr(){
		return addr;
	}

	public void setAddr(String addr){
		this.addr = addr;
	}
    
	public String getSetupDT(){
		return setupDT;
	}

	public void setSetupDT(String setupDT){
		this.setupDT = setupDT;
	}
    
	public String getLabels(){
		return labels;
	}

	public void setLabels(String labels){
		this.labels = labels;
	}
    
	public String getIntroduce(){
		return introduce;
	}

	public void setIntroduce(String introduce){
		this.introduce = introduce;
	}
    
	public Date getLatestFinanceDT(){
		return latestFinanceDT;
	}

	public void setLatestFinanceDT(Date latestFinanceDT){
		this.latestFinanceDT = latestFinanceDT;
	}
    
	public String getLatestFinanceRound(){
		return latestFinanceRound;
	}

	public void setLatestFinanceRound(String latestFinanceRound){
		this.latestFinanceRound = latestFinanceRound;
	}

	public String getLatestFinanceAmountStr(){
		return latestFinanceAmountStr;
	}

	public void setLatestFinanceAmountStr(String latestFinanceAmountStr){
		this.latestFinanceAmountStr = latestFinanceAmountStr;
	}

	public void setIsSame(Integer isSame) {
		this.isSame = isSame;
	}

	public Integer getIsSame() {
		return isSame;
	}

	public Double getSimilarity() {
		return similarity;
	}

	public void setSimilarity(Double similarity) {
		this.similarity = similarity;
	}

	public String getInvestSideJson(){
		return investSideJson;
	}

	public void setInvestSideJson(String investSideJson){
		this.investSideJson = investSideJson;
	}
    
	public String getFirmDesc(){
		return firmDesc;
	}

	public void setFirmDesc(String firmDesc){
		this.firmDesc = firmDesc;
	}
    
	public String getFirmPos(){
		return firmPos;
	}

	public void setFirmPos(String firmPos){
		this.firmPos = firmPos;
	}
    
	public String getPersona(){
		return persona;
	}

	public void setPersona(String persona){
		this.persona = persona;
	}
    
	public String getProdSrv(){
		return prodSrv;
	}

	public void setProdSrv(String prodSrv){
		this.prodSrv = prodSrv;
	}
    
	public String getBizModel(){
		return bizModel;
	}

	public void setBizModel(String bizModel){
		this.bizModel = bizModel;
	}
    
	public String getIndustryName(){
		return industryName;
	}

	public void setIndustryName(String industryName){
		this.industryName = industryName;
	}
    
	public String getIndustrySubName(){
		return industrySubName;
	}

	public void setIndustrySubName(String industrySubName){
		this.industrySubName = industrySubName;
	}
    
	public String getIndustryIds(){
		return industryIds;
	}

	public void setIndustryIds(String industryIds){
		this.industryIds = industryIds;
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
    
	public String getDistrictName(){
		return districtName;
	}

	public void setDistrictName(String districtName){
		this.districtName = districtName;
	}
    
	public String getDistrictSubName(){
		return districtSubName;
	}

	public void setDistrictSubName(String districtSubName){
		this.districtSubName = districtSubName;
	}

	public String getBp() {
		return bp;
	}

	public void setBp(String bp) {
		this.bp = bp;
	}

	public String getHqEmail() {
		return hqEmail;
	}

	public void setHqEmail(String hqEmail) {
		this.hqEmail = hqEmail;
	}

	public String getHqTel() {
		return hqTel;
	}

	public void setHqTel(String hqTel) {
		this.hqTel = hqTel;
	}

	public Long getLoadDate(){
		return loadDate;
	}

	public void setLoadDate(Long loadDate){
		this.loadDate = loadDate;
	}

	public String getDistrictGrandsonName() {
		return districtGrandsonName;
	}

	public void setDistrictGrandsonName(String districtGrandsonName) {
		this.districtGrandsonName = districtGrandsonName;
	}

	public String getWeibo() {
		return weibo;
	}

	public void setWeibo(String weibo) {
		this.weibo = weibo;
	}

	public String getWeixin() {
		return weixin;
	}

	public void setWeixin(String weixin) {
		this.weixin = weixin;
	}

	public String getWebUrl() {
		return webUrl;
	}

	public void setWebUrl(String webUrl) {
		this.webUrl = webUrl;
	}

	public String getTeamTags() {
		return teamTags;
	}

	public void setTeamTags(String teamTags) {
		this.teamTags = teamTags;
	}

	public String getTeamSuper() {
		return teamSuper;
	}

	public void setTeamSuper(String teamSuper) {
		this.teamSuper = teamSuper;
	}

	public String getUserMarket() {
		return userMarket;
	}

	public void setUserMarket(String userMarket) {
		this.userMarket = userMarket;
	}

	public String getRegName() {
		return regName;
	}

	public void setRegName(String regName) {
		this.regName = regName;
	}

	public String getCompCode() {
		return compCode;
	}

	public void setCompCode(String compCode) {
		this.compCode = compCode;
	}

	public String getProjCode() {
		return projCode;
	}

	public void setProjCode(String projCode) {
		this.projCode = projCode;
	}

	public void setPhotos(String photos) {
		this.photos = photos;
	}

	public String getPhotos() {
		return photos;
	}

	public String getInvstAmount() {
		return invstAmount;
	}

	public void setInvstAmount(String invstAmount) {
		this.invstAmount = invstAmount;
	}

	public String getCompScale() {
		return compScale;
	}

	public void setCompScale(String compScale) {
		this.compScale = compScale;
	}

	public String getValuation() {
		return valuation;
	}

	public void setValuation(String valuation) {
		this.valuation = valuation;
	}
}