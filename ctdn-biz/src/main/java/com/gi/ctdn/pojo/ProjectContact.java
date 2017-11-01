package com.gi.ctdn.pojo;

import com.gi.ctdn.view.common.PojoInfo;

public class ProjectContact extends PojoInfo {
    
	/**
	 * @Fields projectId : 项目ID
	 */
	private Integer projectId;
	
	/**
	 * @Fields code : code
	 */
	private String code;
	
	/**
	 * @Fields projTitle : 项目名称
	 */
	private String projTitle;
	
	/**
	 * @Fields city : 城市
	 */
	private String city;
	
	/**
	 * @Fields addr : 地址
	 */
	private String addr;
	
	/**
	 * @Fields zipCode : 邮编
	 */
	private String zipCode;
	
	/**
	 * @Fields tel : 公司电话
	 */
	private String tel;
	
	/**
	 * @Fields mail : 公司邮箱
	 */
	private String mail;
	
	/**
	 * @Fields fax : 传真
	 */
	private String fax;
	
	/**
	 * @Fields sourceCode : project code
	 */
	private String sourceCode;

	public Integer getProjectId(){
		return projectId;
	}

	public void setProjectId(Integer projectId){
		this.projectId = projectId;
	}
    
	public String getCode(){
		return code;
	}

	public void setCode(String code){
		this.code = code;
	}
    
	public String getProjTitle(){
		return projTitle;
	}

	public void setProjTitle(String projTitle){
		this.projTitle = projTitle;
	}
    
	public String getCity(){
		return city;
	}

	public void setCity(String city){
		this.city = city;
	}
    
	public String getAddr(){
		return addr;
	}

	public void setAddr(String addr){
		this.addr = addr;
	}
    
	public String getZipCode(){
		return zipCode;
	}

	public void setZipCode(String zipCode){
		this.zipCode = zipCode;
	}
    
	public String getTel(){
		return tel;
	}

	public void setTel(String tel){
		this.tel = tel;
	}
    
	public String getMail(){
		return mail;
	}

	public void setMail(String mail){
		this.mail = mail;
	}
    
	public String getFax(){
		return fax;
	}

	public void setFax(String fax){
		this.fax = fax;
	}
    
	public String getSourceCode(){
		return sourceCode;
	}

	public void setSourceCode(String sourceCode){
		this.sourceCode = sourceCode;
	}

}