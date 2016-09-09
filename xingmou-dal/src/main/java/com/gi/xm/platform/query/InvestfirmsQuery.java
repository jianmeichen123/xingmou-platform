package com.gi.xm.platform.query;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class InvestfirmsQuery extends Query {
	
	/**   
	 * @Fields serialVersionUID : 序列化版本号 
	 */ 
	private static final long serialVersionUID = 1L;
	
			
	private Long id;
			
	private Long sourceId;
			
	private String name;
			
	private String icon;
			
	private String iconBig;
			
	private String description;
			
	private String link;
			
	private String email;
			
	private String phone;
			
	private String wechat;
			
	private String address;
			
	private String addressDetail;
			
	private String roundNames;
			
	private String areaNames;
			
	private Timestamp addTime;
			
	private Timestamp updateTime;
		
    
	public Long getId(){
		return id;
	}
	public void setId(Long id){
		this.id = id;
	}
    
	public Long getSourceId(){
		return sourceId;
	}
	public void setSourceId(Long sourceId){
		this.sourceId = sourceId;
	}
    
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
    
	public String getIcon(){
		return icon;
	}
	public void setIcon(String icon){
		this.icon = icon;
	}
    
	public String getIconBig(){
		return iconBig;
	}
	public void setIconBig(String iconBig){
		this.iconBig = iconBig;
	}
    
	public String getDescription(){
		return description;
	}
	public void setDescription(String description){
		this.description = description;
	}
    
	public String getLink(){
		return link;
	}
	public void setLink(String link){
		this.link = link;
	}
    
	public String getEmail(){
		return email;
	}
	public void setEmail(String email){
		this.email = email;
	}
    
	public String getPhone(){
		return phone;
	}
	public void setPhone(String phone){
		this.phone = phone;
	}
    
	public String getWechat(){
		return wechat;
	}
	public void setWechat(String wechat){
		this.wechat = wechat;
	}
    
	public String getAddress(){
		return address;
	}
	public void setAddress(String address){
		this.address = address;
	}
    
	public String getAddressDetail(){
		return addressDetail;
	}
	public void setAddressDetail(String addressDetail){
		this.addressDetail = addressDetail;
	}
    
	public String getRoundNames(){
		return roundNames;
	}
	public void setRoundNames(String roundNames){
		this.roundNames = roundNames;
	}
    
	public String getAreaNames(){
		return areaNames;
	}
	public void setAreaNames(String areaNames){
		this.areaNames = areaNames;
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