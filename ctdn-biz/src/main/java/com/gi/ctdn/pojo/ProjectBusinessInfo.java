package com.gi.ctdn.pojo;

import com.gi.ctdn.view.common.PojoInfo;
import io.swagger.annotations.ApiModelProperty;

public class ProjectBusinessInfo extends PojoInfo {


	/**
	 * @Fields sourceCode : 
	 */
	@ApiModelProperty("公司code")
	private String sourceCode;
	
	/**
	 * @Fields projTitle : 项目名称
	 */
	@ApiModelProperty("项目名称")
	private String projTitle;
	
	/**
	 * @Fields company : 公司全称
	 */
	@ApiModelProperty(" 公司全称")
	private String company;
	
	/**
	 * @Fields companyEng : 英文全称
	 */
	@ApiModelProperty("英文全称")
	private String companyEng;
	
	/**
	 * @Fields uniformSocialCreditCode : 统一社会信用代码
	 */
	@ApiModelProperty(" 统一社会信用代码")
	private String uniformSocialCreditCode;
	
	/**
	 * @Fields registrationCode : 注册码
	 */
	@ApiModelProperty("注册码")
	private String registrationCode;
	
	/**
	 * @Fields organizationCode : 组织机构代码
	 */
	@ApiModelProperty("组织机构代码")
	private String organizationCode;
	
	/**
	 * @Fields organizationForm : 组织形式
	 */
	@ApiModelProperty("组织形式")
	private String organizationForm;
	
	/**
	 * @Fields legalPerson : 法人代表
	 */
	@ApiModelProperty("法人代表")
	private String legalPerson;
	
	/**
	 * @Fields businessTerm : 营业期限
	 */
	@ApiModelProperty("营业期限")
	private String businessTerm;
	
	/**
	 * @Fields issuingDate : 发照日期
	 */
	@ApiModelProperty("发照日期")
	private String issuingDate;
	
	/**
	 * @Fields industry : 所属行业
	 */
	@ApiModelProperty("所属行业")
	private String industry;
	
	/**
	 * @Fields registeredAddress : 注册地址
	 */
	@ApiModelProperty("注册地址")
	private String registeredAddress;
	
	/**
	 * @Fields managementStatus : 经营状态
	 */
	@ApiModelProperty("经营状态")
	private String managementStatus;
	
	/**
	 * @Fields foundDate : 成立日期
	 */
	@ApiModelProperty("成立日期")
	private String foundDate;
	
	/**
	 * @Fields registeredCapital : 公司全称
	 */
	@ApiModelProperty("公司全称")
	private String registeredCapital;
	
	/**
	 * @Fields registrationAuthority : 登记机关
	 */
	@ApiModelProperty("登记机关")
	private String registrationAuthority;
	
	/**
	 * @Fields companySize : 公司规模
	 */
	@ApiModelProperty("公司规模")
	private String companySize;
	
	/**
	 * @Fields registrationType : 注册登记类型
	 */
	@ApiModelProperty("注册登记类型")
	private String registrationType;
	
	/**
	 * @Fields businessScope : 经营范围
	 */
	@ApiModelProperty("经营范围")
	private String businessScope;
	
    
	public String getSourceCode(){
		return sourceCode;
	}

	public void setSourceCode(String sourceCode){
		this.sourceCode = sourceCode;
	}
    
	public String getProjTitle(){
		return projTitle;
	}

	public void setProjTitle(String projTitle){
		this.projTitle = projTitle;
	}
    
	public String getCompany(){
		return company;
	}

	public void setCompany(String company){
		this.company = company;
	}
    
	public String getCompanyEng(){
		return companyEng;
	}

	public void setCompanyEng(String companyEng){
		this.companyEng = companyEng;
	}
    
	public String getUniformSocialCreditCode(){
		return uniformSocialCreditCode;
	}

	public void setUniformSocialCreditCode(String uniformSocialCreditCode){
		this.uniformSocialCreditCode = uniformSocialCreditCode;
	}
    
	public String getRegistrationCode(){
		return registrationCode;
	}

	public void setRegistrationCode(String registrationCode){
		this.registrationCode = registrationCode;
	}
    
	public String getOrganizationCode(){
		return organizationCode;
	}

	public void setOrganizationCode(String organizationCode){
		this.organizationCode = organizationCode;
	}
    
	public String getOrganizationForm(){
		return organizationForm;
	}

	public void setOrganizationForm(String organizationForm){
		this.organizationForm = organizationForm;
	}
    
	public String getLegalPerson(){
		return legalPerson;
	}

	public void setLegalPerson(String legalPerson){
		this.legalPerson = legalPerson;
	}
    
	public String getBusinessTerm(){
		return businessTerm;
	}

	public void setBusinessTerm(String businessTerm){
		this.businessTerm = businessTerm;
	}
    
	public String getIssuingDate(){
		return issuingDate;
	}

	public void setIssuingDate(String issuingDate){
		this.issuingDate = issuingDate;
	}
    
	public String getIndustry(){
		return industry;
	}

	public void setIndustry(String industry){
		this.industry = industry;
	}
    
	public String getRegisteredAddress(){
		return registeredAddress;
	}

	public void setRegisteredAddress(String registeredAddress){
		this.registeredAddress = registeredAddress;
	}
    
	public String getManagementStatus(){
		return managementStatus;
	}

	public void setManagementStatus(String managementStatus){
		this.managementStatus = managementStatus;
	}
    
	public String getFoundDate(){
		return foundDate;
	}

	public void setFoundDate(String foundDate){
		this.foundDate = foundDate;
	}
    
	public String getRegisteredCapital(){
		return registeredCapital;
	}

	public void setRegisteredCapital(String registeredCapital){
		this.registeredCapital = registeredCapital;
	}
    
	public String getRegistrationAuthority(){
		return registrationAuthority;
	}

	public void setRegistrationAuthority(String registrationAuthority){
		this.registrationAuthority = registrationAuthority;
	}
    
	public String getCompanySize(){
		return companySize;
	}

	public void setCompanySize(String companySize){
		this.companySize = companySize;
	}
    
	public String getRegistrationType(){
		return registrationType;
	}

	public void setRegistrationType(String registrationType){
		this.registrationType = registrationType;
	}
    
	public String getBusinessScope(){
		return businessScope;
	}

	public void setBusinessScope(String businessScope){
		this.businessScope = businessScope;
	}
    }