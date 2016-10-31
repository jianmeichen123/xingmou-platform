package com.gi.xm.platform.view;

import java.math.BigDecimal;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class CompanyInfo implements Serializable {

	/**   
	 * @Fields serialVersionUID : 序列化版本号 
	 */ 
	private static final long serialVersionUID = 1L;

			
	/**
	 * @Fields id : 
	 */
	private Long id;
			
	/**
	 * @Fields companyName : 公司名称
	 */
	private String companyName;
			
	/**
	 * @Fields conutryType : 1.国内公司 2.国外公司
	 */
	private Integer conutryType;
			
	/**
	 * @Fields createDate : 成立时间（有问题，此字段暂时不可用）
	 */
	private String createDate;
			
	/**
	 * @Fields locaId : 地区，关联：ods.dw_v_district.id
	 */
	private Integer locaId;
			
	/**
	 * @Fields loca : 冗余：地区名称
	 */
	private String loca;
			
	/**
	 * @Fields industryId : 行业id,关联:ods.dw_v_industry.id
	 */
	private Integer industryId;
			
	/**
	 * @Fields industryName : 冗余：行业名称
	 */
	private String industryName;
			
	/**
	 * @Fields industrySubId : 
	 */
	private Integer industrySubId;
			
	/**
	 * @Fields industrySubName : 
	 */
	private String industrySubName;
			
	/**
	 * @Fields locaSubId : 
	 */
	private Integer locaSubId;
			
	/**
	 * @Fields locaSubName : 
	 */
	private String locaSubName;
			
	/**
	 * @Fields phone : 
	 */
	private String phone;
			
	/**
	 * @Fields email : 
	 */
	private String email;
			
	/**
	 * @Fields address : 
	 */
	private String address;
			
	/**
	 * @Fields description : 公司详情
	 */
	private String description;
			
	public Long getId(){
		return id;
	}
	
	public void setId(Long id){
		this.id = id;
	}
    
	public String getCompanyName(){
		return companyName;
	}
	
	public void setCompanyName(String companyName){
		this.companyName = companyName;
	}
    
	public Integer getConutryType(){
		return conutryType;
	}
	
	public void setConutryType(Integer conutryType){
		this.conutryType = conutryType;
	}
    
	public String getCreateDate(){
		return createDate;
	}
	
	public void setCreateDate(String createDate){
		this.createDate = createDate;
	}
    
	public Integer getLocaId(){
		return locaId;
	}
	
	public void setLocaId(Integer locaId){
		this.locaId = locaId;
	}
    
	public String getLoca(){
		return loca;
	}
	
	public void setLoca(String loca){
		this.loca = loca;
	}
    
	public Integer getIndustryId(){
		return industryId;
	}
	
	public void setIndustryId(Integer industryId){
		this.industryId = industryId;
	}
    
	public String getIndustryName(){
		return industryName;
	}
	
	public void setIndustryName(String industryName){
		this.industryName = industryName;
	}
    
	public Integer getIndustrySubId(){
		return industrySubId;
	}
	
	public void setIndustrySubId(Integer industrySubId){
		this.industrySubId = industrySubId;
	}
    
	public String getIndustrySubName(){
		return industrySubName;
	}
	
	public void setIndustrySubName(String industrySubName){
		this.industrySubName = industrySubName;
	}
    
	public Integer getLocaSubId(){
		return locaSubId;
	}
	
	public void setLocaSubId(Integer locaSubId){
		this.locaSubId = locaSubId;
	}
    
	public String getLocaSubName(){
		return locaSubName;
	}
	
	public void setLocaSubName(String locaSubName){
		this.locaSubName = locaSubName;
	}
    
	public String getPhone(){
		return phone;
	}
	
	public void setPhone(String phone){
		this.phone = phone;
	}
    
	public String getEmail(){
		return email;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
    
	public String getAddress(){
		return address;
	}
	
	public void setAddress(String address){
		this.address = address;
	}
    
	public String getDescription(){
		return description;
	}
	
	public void setDescription(String description){
		this.description = description;
	}
    
}