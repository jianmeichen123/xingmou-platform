package com.gi.xm.platform.view;

import java.util.Date;
import java.math.BigDecimal;
import java.io.Serializable;
import java.sql.Timestamp;
import com.gi.xm.platform.view.common.QueryInfo;

public class FilesQueryInfo extends QueryInfo {
	
	/**   
	 * @Fields serialVersionUID : 序列化版本号 
	 */ 
	private static final long serialVersionUID = 1L;

	
	private Long id;
	
	private Integer type;
	
	private Long sourceId;
	
	private String pic;
	
	private String picBig;
	
	private String picShow;
	
	private Timestamp addTime;
	
	private Timestamp updateTime;
		
    
	public Long getId(){
		return id;
	}
	
	public void setId(Long id){
		this.id = id;
	}
    
	public Integer getType(){
		return type;
	}
	
	public void setType(Integer type){
		this.type = type;
	}
    
	public Long getSourceId(){
		return sourceId;
	}
	
	public void setSourceId(Long sourceId){
		this.sourceId = sourceId;
	}
    
	public String getPic(){
		return pic;
	}
	
	public void setPic(String pic){
		this.pic = pic;
	}
    
	public String getPicBig(){
		return picBig;
	}
	
	public void setPicBig(String picBig){
		this.picBig = picBig;
	}
    
	public String getPicShow(){
		return picShow;
	}
	
	public void setPicShow(String picShow){
		this.picShow = picShow;
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