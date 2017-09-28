package com.gi.ctdn.pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.sql.Timestamp;
import java.util.Date;
import com.gi.xm.platform.view.common.PojoInfo;

public class IndexHeaderStat extends PojoInfo {

        public static final String ID = "id";
        public static final String PROJECTNUM = "projectNum";
        public static final String ORGNUM = "orgNum";
        public static final String EVENTNUM = "eventNum";
    
	
	/**
	 * @Fields id : 
	 */
	private Integer id;
	
	/**
	 * @Fields projectNum : 
	 */
	private Integer projectNum;
	
	/**
	 * @Fields orgNum : 
	 */
	private Integer orgNum;
	
	/**
	 * @Fields eventNum : 
	 */
	private Integer eventNum;
	
    
	public Integer getId(){
		return id;
	}

	public void setId(Integer id){
		this.id = id;
	}
    
	public Integer getProjectNum(){
		return projectNum;
	}

	public void setProjectNum(Integer projectNum){
		this.projectNum = projectNum;
	}
    
	public Integer getOrgNum(){
		return orgNum;
	}

	public void setOrgNum(Integer orgNum){
		this.orgNum = orgNum;
	}
    
	public Integer getEventNum(){
		return eventNum;
	}

	public void setEventNum(Integer eventNum){
		this.eventNum = eventNum;
	}
    }