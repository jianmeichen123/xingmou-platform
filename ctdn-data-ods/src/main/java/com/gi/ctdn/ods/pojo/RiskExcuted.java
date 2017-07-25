package com.gi.ctdn.ods.pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.sql.Timestamp;
import java.util.Date;
import com.gi.xm.platform.view.common.PojoInfo;

public class RiskExcuted extends PojoInfo {

        public static final String ID = "id";
        public static final String SOURCECODE = "项目code";
        public static final String SOURCEID = "项目id";
        public static final String CASENAME = "案件名称";
        public static final String RECORDDATE = "立案时间";
        public static final String EXCUTECOURT = "执行法院";
        public static final String RETURNBACK = "执行标的";
    
	
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
	 * @Fields excuteCourt : 执行法院
	 */
	private String excuteCourt;
	
	/**
	 * @Fields returnBack : 执行标的
	 */
	private String returnBack;
	
    private Integer pageIndex;

    private Integer pageSize;

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
    
	public String getExcuteCourt(){
		return excuteCourt;
	}

	public void setExcuteCourt(String excuteCourt){
		this.excuteCourt = excuteCourt;
	}
    
	public String getReturnBack(){
		return returnBack;
	}

	public void setReturnBack(String returnBack){
		this.returnBack = returnBack;
	}

	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
}