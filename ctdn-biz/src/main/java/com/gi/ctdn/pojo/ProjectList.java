package com.gi.ctdn.pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.sql.Timestamp;
import java.util.Date;
import com.gi.xm.platform.view.common.PojoInfo;

public class ProjectList extends PojoInfo {

	/**
	 * @Fields id : 项目ID
	 */
	private Integer id;
	
	/**
	 * @Fields code : 
	 */
	private String code;
	
	/**
	 * @Fields projTitle : 项目名称
	 */
	private String projTitle;
	
	/**
	 * @Fields runState : 运营状态[Y:运营中]
	 */
	private String runState;
	
	/**
	 * @Fields needFinance : 是否需融资[Y:需要，N:不需要]
	 */
	private String needFinance;
	
	/**
	 * @Fields addr : 地点
	 */
	private String addr;
	
	/**
	 * @Fields setupDT : 成立时间
	 */
	private String setupDT;
	
	/**
	 * @Fields labels : 标签
	 */
	private String labels;
	
	/**
	 * @Fields introduce : 项目简短介绍
	 */
	private String introduce;
	
	/**
	 * @Fields latestFinanceDT : 最新融资时间
	 */
	private Date latestFinanceDT;
	
	/**
	 * @Fields latestFinanceRound : 最新融资轮次
	 */
	private String latestFinanceRound;
	
	/**
	 * @Fields latestFinanceAmountNum : 最新融资金额
	 */
	private Integer latestFinanceAmountNum;
	
	/**
	 * @Fields latestFinanceAmountStr : 最新融资金额字面量
	 */
	private String latestFinanceAmountStr;

	/**
	 * similar 竞品相似度
	 */
	private  Double similarity ;

	/**
	 * 直接间接
	 */
	private Integer isSame;
	
	/**
	 * @Fields investSideJson : {"investSideJson":[{"title":"红杉资本","id":2,"isleader":"0"}]}
	 */
	private String investSideJson;
	
	/**
	 * @Fields firmDesc : 公司描述
	 */
	private String firmDesc;
	
	/**
	 * @Fields firmPos : 公司定位
	 */
	private String firmPos;
	
	/**
	 * @Fields persona : 用户画像
	 */
	private String persona;
	
	/**
	 * @Fields prodSrv : 产品服务
	 */
	private String prodSrv;
	
	/**
	 * @Fields bizModel : 商业模式
	 */
	private String bizModel;
	
	/**
	 * @Fields industryName : 一级行业
	 */
	private String industryName;
	
	/**
	 * @Fields industrySubName : 二级行业
	 */
	private String industrySubName;
	
	/**
	 * @Fields industryIds : 行业ids,各级行业逗号分隔
	 */
	private String industryIds;
	
	/**
	 * @Fields districtId : 一级地区id
	 */
	private Integer districtId;
	
	/**
	 * @Fields districtSubId : 二级地区id
	 */
	private Integer districtSubId;
	
	/**
	 * @Fields districtName : 一级地区
	 */
	private String districtName;
	
	/**
	 * @Fields districtSubName : 二级地区
	 */
	private String districtSubName;
	
	/**
	 * @Fields logoSmall : 列表项logo
	 */
	private String logoSmall;
	
	/**
	 * @Fields logoBig : 列表项logo
	 */
	private String logoBig;
	
	/**
	 * @Fields currencyType : 币种
	 */
	private String currencyType;
	
	/**
	 * @Fields loadDate : 录入时间
	 */
	private Long loadDate;
    
	public Integer getId(){
		return id;
	}

	public void setId(Integer id){
		this.id = id;
	}
    
	public String getCode(){
		return code;
	}

	public void setCode(String code){
		this.code = code;
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
    
	public Integer getLatestFinanceAmountNum(){
		return latestFinanceAmountNum;
	}

	public void setLatestFinanceAmountNum(Integer latestFinanceAmountNum){
		this.latestFinanceAmountNum = latestFinanceAmountNum;
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
    
	public String getLogoSmall(){
		return logoSmall;
	}

	public void setLogoSmall(String logoSmall){
		this.logoSmall = logoSmall;
	}
    
	public String getLogoBig(){
		return logoBig;
	}

	public void setLogoBig(String logoBig){
		this.logoBig = logoBig;
	}
    
	public String getCurrencyType(){
		return currencyType;
	}

	public void setCurrencyType(String currencyType){
		this.currencyType = currencyType;
	}
    
	public Long getLoadDate(){
		return loadDate;
	}

	public void setLoadDate(Long loadDate){
		this.loadDate = loadDate;
	}
    }