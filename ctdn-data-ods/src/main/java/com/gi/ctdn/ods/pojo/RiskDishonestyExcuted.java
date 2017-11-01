package com.gi.ctdn.ods.pojo;

import com.gi.ctdn.view.common.PojoInfo;

public class RiskDishonestyExcuted extends PojoInfo {

        public static final String ID = "id";
        public static final String SOURCECODE = "项目code";
        public static final String SOURCEID = "项目id";
        public static final String CASENAME = "案件名称";
        public static final String RECORDDATE = "立案时间";
        public static final String DISTRIBUTEDATE = "发布时间";
        public static final String EVIDENCENUM = "执行依据文号";
        public static final String PERFORMANCE = "被执行人的履行情况";
        public static final String EXCUTECOURT = "执行法院";
        public static final String RETURNBACK = "执行标的";
        public static final String DUTY = "法院文书确定的义务";
    
	
	/**
	 * @Fields id : 
	 */
	private Long id;
	
	/**
	 * @Fields sourceCode : 项目code
	 */
	private String sourceCode;
	
	/**
	 * @Fields sourceId : 项目id
	 */
	private Long sourceId;
	
	/**
	 * @Fields caseName : 案件名称
	 */
	private String caseName;
	
	/**
	 * @Fields recordDate : 立案时间
	 */
	private String recordDate;
	
	/**
	 * @Fields distributeDate : 发布时间
	 */
	private String distributeDate;
	
	/**
	 * @Fields evidenceNum : 执行依据文号
	 */
	private String evidenceNum;
	
	/**
	 * @Fields performance : 被执行人的履行情况
	 */
	private String performance;
	
	/**
	 * @Fields excuteCourt : 执行法院
	 */
	private String excuteCourt;

	/**
	 * @Fields duty : 法院文书确定的义务
	 */
	private String duty;
	
    
	public Long getId(){
		return id;
	}

	public void setId(Long id){
		this.id = id;
	}
    
	public String getSourceCode(){
		return sourceCode;
	}

	public void setSourceCode(String sourceCode){
		this.sourceCode = sourceCode;
	}
    
	public Long getSourceId(){
		return sourceId;
	}

	public void setSourceId(Long sourceId){
		this.sourceId = sourceId;
	}
    
	public String getCaseName(){
		return caseName;
	}

	public void setCaseName(String caseName){
		this.caseName = caseName;
	}
    
	public String getRecordDate(){
		return recordDate;
	}

	public void setRecordDate(String recordDate){
		this.recordDate = recordDate;
	}
    
	public String getDistributeDate(){
		return distributeDate;
	}

	public void setDistributeDate(String distributeDate){
		this.distributeDate = distributeDate;
	}
    
	public String getEvidenceNum(){
		return evidenceNum;
	}

	public void setEvidenceNum(String evidenceNum){
		this.evidenceNum = evidenceNum;
	}
    
	public String getPerformance(){
		return performance;
	}

	public void setPerformance(String performance){
		this.performance = performance;
	}
    
	public String getExcuteCourt(){
		return excuteCourt;
	}

	public void setExcuteCourt(String excuteCourt){
		this.excuteCourt = excuteCourt;
	}

	public String getDuty(){
		return duty;
	}

	public void setDuty(String duty){
		this.duty = duty;
	}
    }