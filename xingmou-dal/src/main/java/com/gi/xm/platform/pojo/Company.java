package com.gi.xm.platform.pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.sql.Timestamp;
import java.util.Date;

public class Company extends Pojo {

        public static final String ID = "id";
        public static final String COMPANY_NAME = "公司名称";
        public static final String CONUTRY_TYPE = "1.国内公司 2.国外公司";
        public static final String CREATE_DATE = "成立时间（有问题，此字段暂时不可用）";
        public static final String LOCA_ID = "地区，关联：ods.dw_v_district.id";
        public static final String LOCA = "冗余：地区名称";
        public static final String INDUSTRY_ID = "行业id,关联:ods.dw_v_industry.id";
        public static final String INDUSTRY_NAME = "冗余：行业名称";
        public static final String INDUSTRY_SUB_ID = "industrySubId";
        public static final String INDUSTRY_SUB_NAME = "industrySubName";
        public static final String LOCA_SUB_ID = "locaSubId";
        public static final String LOCA_SUB_NAME = "locaSubName";
        public static final String PHONE = "phone";
        public static final String EMAIL = "email";
        public static final String ADDRESS = "address";
        public static final String ADD_TIME = "addTime";
        public static final String UPDATE_TIME = "updateTime";
    
	
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
	 * @Fields addTime : 
	 */
	private Timestamp addTime;
	
	/**
	 * @Fields updateTime : 
	 */
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