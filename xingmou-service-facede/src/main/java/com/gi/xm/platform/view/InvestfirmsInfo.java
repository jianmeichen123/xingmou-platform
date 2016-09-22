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
			
	private Long id;
	private String name;
	private String icon;
	private String iconBig;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getIconBig() {
		return iconBig;
	}

	public void setIconBig(String iconBig) {
		this.iconBig = iconBig;
	}

	private String description;
	private String link;
	private String email;
	private String phone;
	private String wechat;
	private String address;
	private String addressDetail;
	private Date loadTime;
	private Integer conutryType;
	private String areaNames;
	private String roundNames;
	private String fieldNames;
	private Integer investorNum;
	private Integer historyNum;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getWechat() {
		return wechat;
	}

	public void setWechat(String wechat) {
		this.wechat = wechat;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddressDetail() {
		return addressDetail;
	}

	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}

	public Date getLoadTime() {
		return loadTime;
	}

	public void setLoadTime(Date loadTime) {
		this.loadTime = loadTime;
	}

	public Integer getConutryType() {
		return conutryType;
	}

	public void setConutryType(Integer conutryType) {
		this.conutryType = conutryType;
	}

	public String getAreaNames() {
		return areaNames;
	}

	public void setAreaNames(String areaNames) {
		this.areaNames = areaNames;
	}

	public String getRoundNames() {
		return roundNames;
	}

	public void setRoundNames(String roundNames) {
		this.roundNames = roundNames;
	}

	public String getFieldNames() {
		return fieldNames;
	}

	public void setFieldNames(String fieldNames) {
		this.fieldNames = fieldNames;
	}

	public Integer getInvestorNum() {
		return investorNum;
	}

	public void setInvestorNum(Integer investorNum) {
		this.investorNum = investorNum;
	}

	public Integer getHistoryNum() {
		return historyNum;
	}

	public void setHistoryNum(Integer historyNum) {
		this.historyNum = historyNum;
	}
   }