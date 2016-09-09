package com.gi.xm.platform.query;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class CompanyQuery extends Query {
	
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
			
	private String address;
			
	private Timestamp addTime;
			
	private Timestamp updateTime;
		
    
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
    
	public Timestamp getAddTime(){
		return addTime;
	}
	public void setAddTime(Timestamp addTime){
		this.addTime = addTime;
	}
    
	public Timestamp getUpdateTime(){
		return updateTime;
	}
	public void setUpdateTime(Timestamp updateTime){
		this.updateTime = updateTime;
	}
    }