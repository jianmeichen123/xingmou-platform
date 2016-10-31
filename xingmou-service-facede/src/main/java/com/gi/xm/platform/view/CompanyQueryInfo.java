package com.gi.xm.platform.view;

import java.util.Date;
import java.math.BigDecimal;
import java.io.Serializable;
import java.sql.Timestamp;
import com.gi.xm.platform.view.common.QueryInfo;

public class CompanyQueryInfo extends QueryInfo {
	
	/**   
	 * @Fields serialVersionUID : 序列化版本号 
	 */ 
	private static final long serialVersionUID = 1L;

	
	private Long id;
	
	private String companyName;
	
	private Integer conutryType;
	
	private String createDate;
	
	private Integer locaId;
	
	private String loca;
	
	private Integer industryId;
	
	private String industryName;
	
	private Integer industrySubId;
	
	private String industrySubName;
	
	private Integer locaSubId;
	
	private String locaSubName;
	
	private String phone;
	
	private String email;
	
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

}