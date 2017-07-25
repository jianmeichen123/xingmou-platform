package com.gi.ctdn.ods.pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.sql.Timestamp;
import java.util.Date;
import com.gi.xm.platform.view.common.PojoInfo;

public class RiskOperationException extends PojoInfo {

        public static final String ID = "id";
        public static final String SOURCECODE = "项目code";
        public static final String SOURCEID = "项目id";
        public static final String RECORDDATE = "列入日期";
        public static final String EXCUTEORGANS = "作出决定机关";
        public static final String EXCUTEREASON = "列入经营异常名录原因";
    
	
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
	 * @Fields recordDate : 列入日期
	 */
	private String recordDate;
	
	/**
	 * @Fields excuteOrgans : 作出决定机关
	 */
	private String excuteOrgans;
	
	/**
	 * @Fields excuteReason : 列入经营异常名录原因
	 */
	private String excuteReason;
	
    
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
    
	public String getRecordDate(){
		return recordDate;
	}

	public void setRecordDate(String recordDate){
		this.recordDate = recordDate;
	}
    
	public String getExcuteOrgans(){
		return excuteOrgans;
	}

	public void setExcuteOrgans(String excuteOrgans){
		this.excuteOrgans = excuteOrgans;
	}
    
	public String getExcuteReason(){
		return excuteReason;
	}

	public void setExcuteReason(String excuteReason){
		this.excuteReason = excuteReason;
	}
    }