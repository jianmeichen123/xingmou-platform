package com.gi.ctdn.ods.pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.sql.Timestamp;
import java.util.Date;
import com.gi.xm.platform.view.common.PojoInfo;

public class RiskJudgmentDocument extends PojoInfo {

        public static final String ID = "id";
        public static final String SOURCECODE = "项目code";
        public static final String SOURCEID = "项目id";
        public static final String CASENAME = "案件名称";
        public static final String CASENUM = "案件编号";
        public static final String CASEROLE = "案件身份";
        public static final String DISTRIBUTEDATE = "发布时间";
        public static final String EXCUTECOURT = "执行法院";
    
	
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
	 * @Fields caseNum : 案件编号
	 */
	private String caseNum;
	
	/**
	 * @Fields caseRole : 案件身份
	 */
	private String caseRole;
	
	/**
	 * @Fields distributeDate : 发布时间
	 */
	private String distributeDate;
	
	/**
	 * @Fields excuteCourt : 执行法院
	 */
	private String excuteCourt;
	
    
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
    
	public String getCaseNum(){
		return caseNum;
	}

	public void setCaseNum(String caseNum){
		this.caseNum = caseNum;
	}
    
	public String getCaseRole(){
		return caseRole;
	}

	public void setCaseRole(String caseRole){
		this.caseRole = caseRole;
	}
    
	public String getDistributeDate(){
		return distributeDate;
	}

	public void setDistributeDate(String distributeDate){
		this.distributeDate = distributeDate;
	}
    
	public String getExcuteCourt(){
		return excuteCourt;
	}

	public void setExcuteCourt(String excuteCourt){
		this.excuteCourt = excuteCourt;
	}
    }