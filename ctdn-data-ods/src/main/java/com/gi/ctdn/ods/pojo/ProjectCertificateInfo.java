package com.gi.ctdn.ods.pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.sql.Timestamp;
import java.util.Date;
import com.gi.xm.platform.view.common.PojoInfo;

public class ProjectCertificateInfo extends PojoInfo {

        public static final String PROJECTID = "项目ID";
        public static final String SOURCECODE = "项目code";
        public static final String PROJTITLE = "项目名称";
        public static final String ENCLOSURE = "附件";
        public static final String REASON = "原因";
        public static final String ENDDATE = "证书截止日期";
        public static final String FIRSTDATE = "首次发证日期";
        public static final String STANDARD = "标准";
        public static final String PRODNAME = "产品名称";
        public static final String DATE = "发证日期";
        public static final String MANUFACTURER = "制造商";
        public static final String STATE = "现状态";
        public static final String PRODUCTER = "生产商";
        public static final String NUMBER = "证书编号";
        public static final String MODEL = "型号/规格";
        public static final String CHANGEDATE = "证书状态变化时间";
        public static final String APPLICANT = "申请人";
    
	
	/**
	 * @Fields projectId : 项目ID
	 */
	private Integer projectId;
	
	/**
	 * @Fields sourceCode : 项目code
	 */
	private String sourceCode;
	
	/**
	 * @Fields projTitle : 项目名称
	 */
	private String projTitle;
	
	/**
	 * @Fields enclosure : 附件
	 */
	private String enclosure;
	
	/**
	 * @Fields reason : 原因
	 */
	private String reason;
	
	/**
	 * @Fields endDate : 证书截止日期
	 */
	private String endDate;
	
	/**
	 * @Fields firstDate : 首次发证日期
	 */
	private String firstDate;
	
	/**
	 * @Fields standard : 标准
	 */
	private String standard;
	
	/**
	 * @Fields prodName : 产品名称
	 */
	private String prodName;
	
	/**
	 * @Fields date : 发证日期
	 */
	private String date;
	
	/**
	 * @Fields manufacturer : 制造商
	 */
	private String manufacturer;
	
	/**
	 * @Fields state : 现状态
	 */
	private String state;
	
	/**
	 * @Fields producter : 生产商
	 */
	private String producter;
	
	/**
	 * @Fields number : 证书编号
	 */
	private String number;
	
	/**
	 * @Fields model : 型号/规格
	 */
	private String model;
	
	/**
	 * @Fields changeDate : 证书状态变化时间
	 */
	private String changeDate;
	
	/**
	 * @Fields applicant : 申请人
	 */
	private String applicant;
	
    
	public Integer getProjectId(){
		return projectId;
	}

	public void setProjectId(Integer projectId){
		this.projectId = projectId;
	}
    
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
    
	public String getEnclosure(){
		return enclosure;
	}

	public void setEnclosure(String enclosure){
		this.enclosure = enclosure;
	}
    
	public String getReason(){
		return reason;
	}

	public void setReason(String reason){
		this.reason = reason;
	}
    
	public String getEndDate(){
		return endDate;
	}

	public void setEndDate(String endDate){
		this.endDate = endDate;
	}
    
	public String getFirstDate(){
		return firstDate;
	}

	public void setFirstDate(String firstDate){
		this.firstDate = firstDate;
	}
    
	public String getStandard(){
		return standard;
	}

	public void setStandard(String standard){
		this.standard = standard;
	}
    
	public String getProdName(){
		return prodName;
	}

	public void setProdName(String prodName){
		this.prodName = prodName;
	}
    
	public String getDate(){
		return date;
	}

	public void setDate(String date){
		this.date = date;
	}
    
	public String getManufacturer(){
		return manufacturer;
	}

	public void setManufacturer(String manufacturer){
		this.manufacturer = manufacturer;
	}
    
	public String getState(){
		return state;
	}

	public void setState(String state){
		this.state = state;
	}
    
	public String getProducter(){
		return producter;
	}

	public void setProducter(String producter){
		this.producter = producter;
	}
    
	public String getNumber(){
		return number;
	}

	public void setNumber(String number){
		this.number = number;
	}
    
	public String getModel(){
		return model;
	}

	public void setModel(String model){
		this.model = model;
	}
    
	public String getChangeDate(){
		return changeDate;
	}

	public void setChangeDate(String changeDate){
		this.changeDate = changeDate;
	}
    
	public String getApplicant(){
		return applicant;
	}

	public void setApplicant(String applicant){
		this.applicant = applicant;
	}
    }