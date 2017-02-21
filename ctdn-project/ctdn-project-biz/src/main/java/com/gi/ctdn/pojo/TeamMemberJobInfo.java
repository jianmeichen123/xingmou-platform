package com.gi.ctdn.pojo;

import java.io.Serializable;
import java.util.Date;

public class TeamMemberJobInfo extends CtdnPojo implements Serializable {

	/**   
	 * @Fields serialVersionUID : 序列化版本号 
	 */ 
	private static final long serialVersionUID = 1L;

			
	/**
	 * @Fields id : 
	 */
	private Long id;
			
	/**
	 * @Fields memberId : 
	 */
	private Long memberId;
			
	/**
	 * @Fields companyName : 公司名称
	 */
	private String companyName;
			
	/**
	 * @Fields companyUrl : 公司网址
	 */
	private String companyUrl;
			
	/**
	 * @Fields position : 职位
	 */
	private String position;
			
	/**
	 * @Fields startDate : 开始日期
	 */
	private Date startDate;
			
	/**
	 * @Fields endDate : 结束日期
	 */
	private Date endDate;
			
	/**
	 * @Fields descrip : 工作描述
	 */
	private String descrip;
    
	public Long getId(){
		return id;
	}
	
	public void setId(Long id){
		this.id = id;
	}
    
	public Long getMemberId(){
		return memberId;
	}
	
	public void setMemberId(Long memberId){
		this.memberId = memberId;
	}
    
	public String getCompanyName(){
		return companyName;
	}
	
	public void setCompanyName(String companyName){
		this.companyName = companyName;
	}
    
	public String getCompanyUrl(){
		return companyUrl;
	}
	
	public void setCompanyUrl(String companyUrl){
		this.companyUrl = companyUrl;
	}
    
	public String getPosition(){
		return position;
	}
	
	public void setPosition(String position){
		this.position = position;
	}
    
	public Date getStartDate(){
		return startDate;
	}
	
	public void setStartDate(Date startDate){
		this.startDate = startDate;
	}
    
	public Date getEndDate(){
		return endDate;
	}
	
	public void setEndDate(Date endDate){
		this.endDate = endDate;
	}
    
	public String getDescrip(){
		return descrip;
	}
	
	public void setDescrip(String descrip){
		this.descrip = descrip;
	}
    
    }