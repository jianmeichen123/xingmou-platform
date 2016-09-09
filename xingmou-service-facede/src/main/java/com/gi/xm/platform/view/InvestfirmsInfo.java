package com.gi.xm.platform.view;

import java.math.BigDecimal;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class InvestfirmsInfo implements Serializable {

	/**   
	 * @Fields serialVersionUID : 序列化版本号 
	 */ 
	private static final long serialVersionUID = 1L;

			
	/**
	 * @Fields id : 
	 */
	private Long id;
			
	/**
	 * @Fields sourceId : 源id
	 */
	private Long sourceId;
			
	/**
	 * @Fields name : 机构名称
	 */
	private String name;
			
	/**
	 * @Fields icon : 
	 */
	private String icon;
			
	/**
	 * @Fields iconBig : 大图标
	 */
	private String iconBig;
			
	/**
	 * @Fields description : 描述
	 */
	private String description;
			
	/**
	 * @Fields link : 机构网址
	 */
	private String link;
			
	/**
	 * @Fields email : 联系方式：邮箱
	 */
	private String email;
			
	/**
	 * @Fields phone : 联系方式：电话号码
	 */
	private String phone;
			
	/**
	 * @Fields wechat : 联系方式：微信
	 */
	private String wechat;
			
	/**
	 * @Fields address : 地址
	 */
	private String address;
			
	/**
	 * @Fields addressDetail : 详细地址
	 */
	private String addressDetail;
			
	/**
	 * @Fields roundNames : 冗余：关注轮次名
	 */
	private String roundNames;
			
	/**
	 * @Fields areaNames : 冗余：关注领域名
	 */
	private String areaNames;
			
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