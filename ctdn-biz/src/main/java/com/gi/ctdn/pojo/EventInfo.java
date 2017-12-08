package com.gi.ctdn.pojo;

import com.gi.ctdn.view.common.Query;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;
@ApiModel
public class EventInfo extends Query {

	/**
	 * @Fields investevent : 投资事件
	 */
	@ApiModelProperty(value="投资事件标题" )
	private String investevent;
	
	/**
	 * @Fields eventId : 事件ID
	 */
	@ApiModelProperty(value="事件id" )
	private Integer eventId;
	
	/**
	 * @Fields code : 事件code
	 */
	@ApiModelProperty(value="事件code" )
	private String code;
	
	/**
	 * @Fields round : 轮次
	 */
	@ApiModelProperty(value="轮次" )
	private String round;
	
	/**
	 * @Fields districtName : 一级地区
	 */
	@ApiModelProperty(value="一级地区" )
	private String districtName;
	
	/**
	 * @Fields districtSubName : 二级地区
	 */
	@ApiModelProperty(value="二级地区" )
	private String districtSubName;


	/**
	 * @Fields investDate : 时间
	 */
	@ApiModelProperty(value="融资时间" )
	private Date investDate;
	
	/**
	 * @Fields company : 融资公司
	 */
	@ApiModelProperty(value="融资公司" )
	private String company;
	
	/**
	 * @Fields stage : 投资阶段
	 */
	@ApiModelProperty(value="投资阶段" )
	private String stage;
	
	/**
	 * @Fields valuation : 企业估值
	 */
	@ApiModelProperty(value="企业估值" )
	private String valuation;
	
	/**
	 * @Fields stock : 股权
	 */
	@ApiModelProperty(value="股权" )
	private String stock;
	
	/**
	 * @Fields mode : 融资方式
	 */
	@ApiModelProperty(value="融资方式" )
	private String mode;
	
	/**
	 * @Fields desc : 描述
	 */
	@ApiModelProperty(value="描述" )
	private String desc;
	
	/**
	 * @Fields sourceCode : 项目/投资机构 code
	 */
	@ApiModelProperty(value="项目/投资机构 code" )
	private String sourceCode;
	
	/**
	 * @Fields industryName : 一级行业
	 */
	@ApiModelProperty(value="一级行业" )
	private String industryName;
	
	/**
	 * @Fields industrySubName : 二级行业
	 */
	@ApiModelProperty(value="二级行业" )
	private String industrySubName;
	
	/**
	 * @Fields industryGrandsonName : 三级行业
	 */
	@ApiModelProperty(value="三级行业" )
	private String industryGrandsonName;
	
	/**
	 * @Fields industryIds : 行业ids,各级行业逗号分隔
	 */
	@ApiModelProperty(value="行业ids,各级行业逗号分隔" )
	private String industryIds;
	
	/**
	 * @Fields districtId : 一级地区id
	 */
	@ApiModelProperty(value="一级地区id" )
	private Integer districtId;
	
	/**
	 * @Fields districtSubId : 二级地区id
	 */
	@ApiModelProperty(value="二级地区id" )
	private Integer districtSubId;
	
	/**
	 * @Fields amountStr : 投资额字面量
	 */
	@ApiModelProperty(value="投资额字面量" )
	private String amountStr;
	
	/**
	 * @Fields investSideJson : 投资方包含未收录 {"investSideJson":[{"type":"0","code":199,"title":"红杉资本","isClick":"0"}]}
	 */
	@ApiModelProperty(value="code:项目/投资机构code" +
					"id:暂时无用,invstor:投资机构,isClick:是否可点击 1是 0否,isLeader:是否领投:1是 0否,type:投资方角色:invst 投资机构 com 公司 例:" +
			"{\"investSideJson\":[{\"code\":\"c1daebd7f2bfd65c4d8cb2c976f2eb41\",\"id\":\"8\",\"invstor\":\"蓝驰创投\",\"isClick\":1,\"isLeader\":0,\"type\":\"invst\"}]}" )
	private String investSideJson;
	
	/**
	 * @Fields bodyRole : 投资事件主体
	 */
	@ApiModelProperty(value="投资事件主体" )
	private String bodyRole;
	
	/**
	 * @Fields invstorgids : 投资事件对应投资机构ids
	 */
	@ApiModelProperty(value="投资事件对应投资机构ids" )
	private String invstorgids;
	
	/**
	 * @Fields invstorgnames : 投资事件对应投资机构names
	 */
	@ApiModelProperty(value="invstorgnames" )
	private String invstorgnames;

	/**
	 * @Fields districtGrandsonName : 三级地区

	 */
	@ApiModelProperty(value="三级地区" )
	private String districtGrandsonName;

	public String getDistrictGrandsonName() {
		return districtGrandsonName;
	}

	public void setDistrictGrandsonName(String districtGrandsonName) {
		this.districtGrandsonName = districtGrandsonName;
	}

	public String getInvestevent(){
		return investevent;
	}

	public void setInvestevent(String investevent){
		this.investevent = investevent;
	}
    
	public Integer getEventId(){
		return eventId;
	}

	public void setEventId(Integer eventId){
		this.eventId = eventId;
	}
    
	public String getCode(){
		return code;
	}

	public void setCode(String code){
		this.code = code;
	}
    
	public String getRound(){
		return round;
	}

	public void setRound(String round){
		this.round = round;
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
    
	public Date getInvestDate(){
		return investDate;
	}

	public void setInvestDate(Date investDate){
		this.investDate = investDate;
	}
    
	public String getCompany(){
		return company;
	}

	public void setCompany(String company){
		this.company = company;
	}
    
	public String getStage(){
		return stage;
	}

	public void setStage(String stage){
		this.stage = stage;
	}
    
	public String getValuation(){
		return valuation;
	}

	public void setValuation(String valuation){
		this.valuation = valuation;
	}
    
	public String getStock(){
		return stock;
	}

	public void setStock(String stock){
		this.stock = stock;
	}
    
	public String getMode(){
		return mode;
	}

	public void setMode(String mode){
		this.mode = mode;
	}
    
	public String getDesc(){
		return desc;
	}

	public void setDesc(String desc){
		this.desc = desc;
	}
    
	public String getSourceCode() {
		return sourceCode;
	}

	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
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
    
	public String getIndustryGrandsonName(){
		return industryGrandsonName;
	}

	public void setIndustryGrandsonName(String industryGrandsonName){
		this.industryGrandsonName = industryGrandsonName;
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

	public String getAmountStr(){
		return amountStr;
	}

	public void setAmountStr(String amountStr){
		this.amountStr = amountStr;
	}

	public String getInvestSideJson(){
		return investSideJson;
	}

	public void setInvestSideJson(String investSideJson){
		this.investSideJson = investSideJson;
	}

	public String getInvstorgids(){
		return invstorgids;
	}

	public void setInvstorgids(String invstorgids){
		this.invstorgids = invstorgids;
	}
    
	public String getInvstorgnames(){
		return invstorgnames;
	}

	public void setInvstorgnames(String invstorgnames){
		this.invstorgnames = invstorgnames;
	}
	
	public List<String> getIndustryIdList() {
		return industryIdList;
	}

	public void setIndustryIdList(List<String> industryIdList) {
		this.industryIdList = industryIdList;
	}

	private List<String> industryIdList;

}